package dev.lyze.flexbox;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import io.github.orioncraftmc.meditate.YogaConfig;
import io.github.orioncraftmc.meditate.YogaConfigFactory;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.YogaNodeFactory;

/**
 * A Scene2D widget that implements Yoga Layout by Facebook. FlexBox is a clean and powerful alternative to group
 * widgets like {@link com.badlogic.gdx.scenes.scene2d.ui.Table} and
 * {@link com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup}. {@link #add(Actor) Add} an {@link Actor} to the widget
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
            actor.setBounds(node.getLayoutX(), getHeight() - node.getLayoutY() - node.getLayoutHeight(), node.getLayoutWidth(), node.getLayoutHeight());
        }
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
     * Adds an actor to the specified position in the root elements list.
     * @param actor The {@link Actor Scene2D Actor} to be added to the list.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAt(Actor actor, int i) {
        return addAsChild(root, actor, i);
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
     * Adds an actor as a child to the specified node to the specified position of the elements list.
     * @param parent The parent node that the actor will be added as a child to.
     * @param actor The {@link Actor Scene2D Actor} to be added.
     * @param i The position to place the actor.
     * @return The node associated with the actor. Change the properties of the node to modify the FlexBox layout.
     */
    public YogaNode addAsChild(YogaNode parent, Actor actor, int i) {
        YogaNode node = YogaNodeFactory.create(config);

        if (actor instanceof Layout) {
            Layout layout = (Layout) actor;

            node.setMinWidth(layout.getMinWidth());
            node.setMinHeight(layout.getMinHeight());
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
    public void clear() {
        for (int i = root.getChildCount() - 1; i >= 0; i--)
            root.removeChildAt(i);

        for (YogaActor node : nodes)
            removeActor(node.getActor());

        nodes.clear();
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
}
