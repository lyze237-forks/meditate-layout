package dev.lyze.flexbox;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import io.github.orioncraftmc.meditate.YogaConfig;
import io.github.orioncraftmc.meditate.YogaConfigFactory;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.YogaNodeFactory;

public class FlexBox extends WidgetGroup {
    private final YogaConfig config;
    private final YogaNode root;

    private final Array<YogaActor> nodes = new Array<>();

    private float prefWidth, prefHeight;
    public FlexBox() {
        this.config = YogaConfigFactory.create();
        this.config.setUseWebDefaults(true);

        this.root = YogaNodeFactory.create();
    }
    public FlexBox(YogaConfig config) {
        this.config = config;
        this.root = YogaNodeFactory.create();
    }

    @Override
    public void layout() {
        super.layout();

        root.calculateLayout(getWidth(), getHeight());

        float maxWidth = 0, maxHeight = 0;
        for (YogaActor yogaActor : nodes) {
            YogaNode node = yogaActor.getNode();
            Actor actor = yogaActor.getActor();

            System.out.println(node.getLayoutX() + " / " + node.getLayoutY() + " / " + node.getLayoutWidth() + " / " + node.getLayoutHeight());

            actor.setBounds(node.getLayoutX(), node.getLayoutY(), node.getLayoutWidth(), node.getLayoutHeight());

            maxWidth = Math.max(maxWidth, node.getLayoutX() + node.getLayoutWidth());
            maxHeight = Math.max(maxHeight, node.getLayoutY() + node.getLayoutHeight());
        }
        prefWidth = maxWidth;
        prefHeight = maxHeight;

        System.out.println("Size: " + getWidth() + " / " + getHeight());
        setSize(maxWidth, maxHeight);
    }

    public YogaNode add(Actor actor) {
        return addAt(actor, root.getChildCount());
    }

    public YogaNode addAt(Actor actor, int i) {
        return addAsChild(root, actor, i);
    }

    public YogaNode addAsChild(YogaNode parent, Actor actor) {
        return addAsChild(parent, actor, parent.getChildCount());
    }

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

    public YogaNode getRoot() {
        return root;
    }

    @Override
    public float getPrefWidth() {
        return prefWidth;
    }

    @Override
    public float getPrefHeight() {
        return prefHeight;
    }
}
