package dev.lyze.flexbox;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import io.github.orioncraftmc.meditate.*;
import io.github.orioncraftmc.meditate.enums.YogaEdge;

/**
 * A Scene2D widget that implements Yoga Layout by Facebook. FlexBox is a clean and powerful alternative to group
 * widgets like {@link com.badlogic.gdx.scenes.scene2d.ui.Table Table} and
 * {@link com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup HorizontalGroup}. {@link #add(Actor) Add} an {@link Actor} to the widget
 * and use the returned {@link YogaNode} to modify its FlexBox properties. {@link #getRoot() Get the root node} to
 * modify the properties of the top level element.
 *
 * @author Lyze
 * @see <a href="https://yogalayout.com/docs/">Yoga documentation</a>
 * @see <a href="https://yogalayout.com/playground/">Yoga playground</a>
 * @see <a href="https://github.com/raeleus/meditate-layout">Meditate Layout brought to libGDX by LyzeDev</a>
 */
public class FlexBox extends WidgetGroup {
    private final YogaConfig config;
    private final YogaNode root;

    private final Array<YogaActor> nodes = new Array<>();

    private boolean prefSizeInvalid;
    private float prefWidth, prefHeight;
    private float lastPrefWidth, lastPrefHeight;
    
    /**
     * Creates a FlexBox with the default configuration.
     */
    public FlexBox() {
        this.config = YogaConfigFactory.create();
        this.root = YogaNodeFactory.create();
        setTransform(false);
        setTouchable(Touchable.childrenOnly);
    }
    
    /**
     * Creates a FlexBox with the provided {@link YogaConfig}.
     * @param config
     */
    public FlexBox(YogaConfig config) {
        this.config = config;
        this.root = YogaNodeFactory.create();
    }

    @Override
    public void layout() {
        super.layout();
    
        for (YogaActor yogaActor : nodes) {
            YogaNode yogaNode  = yogaActor.node;
            Actor actor = yogaActor.actor;
            if (actor instanceof Layout) {
                Layout layout = (Layout) actor;

                if (!((YogaNodeWrapper) yogaNode).minWidthManuallySet) {
                    yogaNode.setMinWidth(layout.getMinWidth() + yogaNode.getLayoutPadding(YogaEdge.LEFT) + yogaNode.getLayoutPadding(YogaEdge.RIGHT));
                    ((YogaNodeWrapper)yogaNode).minWidthManuallySet = false;
                }
                if (!((YogaNodeWrapper) yogaNode).minHeightManuallySet) {
                    yogaNode.setMinHeight(layout.getMinHeight() + yogaNode.getLayoutPadding(YogaEdge.BOTTOM) + yogaNode.getLayoutPadding(YogaEdge.TOP));
                    ((YogaNodeWrapper)yogaNode).minHeightManuallySet = false;
                }
            }
        }
        
        //update the bounds of the FlexBox
        if (prefSizeInvalid) calcPrefSize();
        if (prefWidth != lastPrefWidth || prefHeight != lastPrefHeight) {
            lastPrefWidth = prefWidth;
            lastPrefHeight = prefHeight;
            invalidateHierarchy();
        }
        setBounds(0, 0, getWidth(), getHeight());
    
        //update the bounds of the children
        root.calculateLayout(getWidth(), getHeight());
        for (YogaActor yogaActor : nodes) {
            YogaNode node = yogaActor.getNode();
            Actor actor = yogaActor.getActor();
            
            float x = node.getLayoutX();
            float y = node.getLayoutY();
            YogaNode parent = node.getOwner();
            while (parent != null) {
                x += parent.getLayoutX();
                y += parent.getLayoutY();
                parent = parent.getOwner();
            }
            actor.setBounds(x + node.getLayoutPadding(YogaEdge.LEFT), getHeight() - y - node.getLayoutHeight() + node.getLayoutPadding(YogaEdge.BOTTOM), node.getLayoutWidth() - node.getLayoutPadding(YogaEdge.LEFT) - node.getLayoutPadding(YogaEdge.RIGHT), node.getLayoutHeight()  - node.getLayoutPadding(YogaEdge.BOTTOM) - node.getLayoutPadding(YogaEdge.TOP));
        }
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        validate();
        if (isTransform()) {
            applyTransform(batch, computeTransform());
            drawBackground(root, batch, 0, 0);
            drawChildren(batch, parentAlpha);
            resetTransform(batch);
        } else {
            drawBackground(root, batch, getX(), getY());
            super.draw(batch, parentAlpha);
        }
    }
    
    private void drawBackground(YogaNode node, Batch batch, float offsetX, float offsetY) {
        Drawable background = node.getBackground();
    
        if (background != null) {
            float x = node.getLayoutX();
            float y = node.getLayoutY();
            YogaNode parent = node.getOwner();
            while (parent != null) {
                x += parent.getLayoutX();
                y += parent.getLayoutY();
                parent = parent.getOwner();
            }
            background.draw(batch, x + offsetX, getHeight() - y - node.getLayoutHeight() + offsetY, node.getLayoutWidth(),
                    node.getLayoutHeight());
        }
        
        for (int i = 0; i < node.getChildCount(); i++) {
            YogaNode child = node.getChildAt(i);
            drawBackground(child, batch, offsetX, offsetY);
        }
    }
    
    /**
     * Adds an empty node to the end of the root elements list. This node can be used to nest children with {@link #addAsChild(YogaNode, Actor)}.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode add() {
        return addAt(null, root.getChildCount());
    }
    
    /**
     * Adds an actor to the end of the root elements list.
     * @param actor The {@link Actor Scene2D Actor} to be added to the list.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode add(Actor actor) {
        return addAt(actor, root.getChildCount());
    }
    
    /**
     * Adds an empty node to the specified position of the root elements list. This node can be used to nest children
     * with {@link #addAsChild(YogaNode, Actor)}.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAt(int i) {
        return addAsChild(root, null, i);
    }
    
    /**
     * Adds an actor to the specified position in the root elements list.
     * @param actor The {@link Actor Scene2D Actor} to be added to the list.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAt(Actor actor, int i) {
        return addAsChild(root, actor, i);
    }
    
    /**
     * Adds an empty node as a child to the specified node at the end of the elements list. This node can be used to
     * nest children with {@link #addAsChild(YogaNode, Actor)}.
     * @param parent The parent node that the actor will be added as a child to.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAsChild(YogaNode parent) {
        return addAsChild(parent, null, parent.getChildCount());
    }
    
    /**
     * Adds an actor as a child to the specified node at the end of the elements list.
     * @param parent The parent node that the actor will be added as a child to.
     * @param actor The {@link Actor Scene2D Actor} to be added.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAsChild(YogaNode parent, Actor actor) {
        return addAsChild(parent, actor, parent.getChildCount());
    }
    
    /**
     * Adds an empty node as a child to the specified node to the specified position of the elements list. This node can
     * be used to nest children with {@link #addAsChild(YogaNode, Actor)}.
     * @param parent The parent node that the actor will be added as a child to.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAsChild(YogaNode parent, int i) {
        return addAsChild(parent, null, i);
    }
    
    /**
     * Adds an actor as a child to the specified node to the specified position of the elements list.
     * @param parent The parent node that the actor will be added as a child to.
     * @param actor The {@link Actor Scene2D Actor} to be added.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAsChild(YogaNode parent, Actor actor, int i) {
        YogaNode node = YogaNodeFactory.create(config);

        if (actor == null) {
            parent.addChildAt(node, i);
            return node;
        }
        
        if (actor instanceof Layout) {
            Layout layout = (Layout) actor;

            node.setMinWidth(layout.getMinWidth());
            node.setMinHeight(layout.getMinHeight());
            ((YogaNodeWrapper)node).minWidthManuallySet = false;
            ((YogaNodeWrapper)node).minHeightManuallySet = false;
        } else {
            node.setWidth(actor.getWidth());
            node.setHeight(actor.getHeight());
        }

        nodes.add(new YogaActor(node, actor));
        parent.addChildAt(node, i);
        addActor(actor);

        return node;
    }
    
    /**
     * Removes the specified node and the {@link Actor} associated with it.
     * @param node
     */
    public void remove(YogaNode node) {
        YogaNode parent = node.getOwner();

        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            if (parent.getChildAt(i) == node) {
                parent.removeChildAt(i);

                for (YogaActor yogaActor : nodes) {
                    if (yogaActor.getNode() == node) {
                        nodes.removeValue(yogaActor, true);
                        removeActor(yogaActor.getActor());

                        return;
                    }
                }
            }
        }
    }
    
    /**
     * Removes all child actors and nodes.
     */
    @Override
    public void clearChildren() {
        super.clearChildren();
        for (YogaActor node : nodes)
            removeActor(node.getActor());
    
        nodes.clear();
        
        while (root.getChildCount() > 0) {
            root.removeChildAt(0);
        }
    }
    
    private static class YogaActor {
        private final YogaNode node;
        private final Actor actor;

        public YogaActor(YogaNode node, Actor actor) {
            this.node = node;
            this.actor = actor;
        }

        public YogaNode getNode() {
            return node;
        }

        public Actor getActor() {
            return actor;
        }
    }
    
    /**
     * Returns the root element of the FlexBox.
     * @return The root element.
     */
    public YogaNode getRoot() {
        return root;
    }
    
    @Override
    public void invalidate() {
        super.invalidate();
        prefSizeInvalid = true;
    }
    
    @Override
    public float getPrefWidth() {
        if (prefSizeInvalid) calcPrefSize();
        return prefWidth;
    }
    
    @Override
    public float getPrefHeight() {
        if (prefSizeInvalid) calcPrefSize();
        return prefHeight;
    }
    
    private void calcPrefSize() {
        prefSizeInvalid = false;
        
        //calculate the smallest resulting width at the current height
        root.calculateLayout(0, getHeight());
        float maxWidth = 0;
        for (YogaActor yogaActor : nodes) {
            YogaNode node = yogaActor.getNode();
            maxWidth = Math.max(maxWidth, node.getLayoutX() + node.getLayoutWidth());
        }
        prefWidth = maxWidth;
        
        //calculate the smallest resulting height at the current width;
        root.calculateLayout(getWidth(), 0);
        float maxHeight = 0;
        for (YogaActor yogaActor : nodes) {
            YogaNode node = yogaActor.getNode();
            maxHeight = Math.max(maxHeight, node.getLayoutY() + node.getLayoutHeight());
        }
        prefHeight = maxHeight;
    }
    
    /**
     *
     * @param actor
     * @see #add(Actor)
     */
    @Override
    @Deprecated
    public void addActor(Actor actor) {
        super.addActor(actor);
    }
    
    /**
     *
     * @param index May be greater than the number of children.
     * @param actor
     * @see #addAt(Actor, int)
     */
    @Override
    @Deprecated
    public void addActorAt(int index, Actor actor) {
        super.addActorAt(index, actor);
    }
    
    /**
     *
     * @param actorBefore
     * @param actor
     * @see #addAt(Actor, int)
     */
    @Override
    @Deprecated
    public void addActorBefore(Actor actorBefore, Actor actor) {
        super.addActorBefore(actorBefore, actor);
    }
    
    /**
     *
     * @param actorAfter
     * @param actor
     * @see #addAt(Actor, int)
     */
    @Override
    @Deprecated
    public void addActorAfter(Actor actorAfter, Actor actor) {
        super.addActorAfter(actorAfter, actor);
    }
    
    /**
     *
     * @param actor
     * @return
     * @see #remove(YogaNode)
     */
    @Override
    @Deprecated
    public boolean removeActor(Actor actor) {
        return super.removeActor(actor);
    }
    
    /**
     *
     * @param actor
     * @param unfocus
     * @return
     * @see #remove(YogaNode)
     */
    @Override
    @Deprecated
    public boolean removeActor(Actor actor, boolean unfocus) {
        return super.removeActor(actor, unfocus);
    }
    
    /**
     *
     * @param index
     * @param unfocus If true, {@link Stage#unfocus(Actor)} is called.
     * @return
     *
     * @see #remove(YogaNode)
     */
    @Override
    @Deprecated
    public Actor removeActorAt(int index, boolean unfocus) {
        return super.removeActorAt(index, unfocus);
    }
}
