package io.github.orioncraftmc.meditate.internal;

import static io.github.orioncraftmc.meditate.GlobalMembers.*;
import io.github.orioncraftmc.meditate.internal.enums.*;
import org.junit.jupiter.api.Test;


public class YGAlignItemsTest extends YogaTest {

    @Test public void align_items_stretch()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void align_items_center()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_flex_start()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignFlexStart);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_flex_end()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignFlexEnd);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 60);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 25);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 25);
        YGNodeStyleSetHeight(root_child1_child0, 20);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child1, 25);
        YGNodeStyleSetHeight(root_child1_child1, 10);
        YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child2, 25);
        YGNodeStyleSetHeight(root_child1_child2, 20);
        YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child3, 25);
        YGNodeStyleSetHeight(root_child1_child3, 10);
        YGNodeInsertChild(root_child1, root_child1_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline_override()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 60);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 25);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 25);
        YGNodeStyleSetHeight(root_child1_child0, 20);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child1_child1, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root_child1_child1, 25);
        YGNodeStyleSetHeight(root_child1_child1, 10);
        YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child2, 25);
        YGNodeStyleSetHeight(root_child1_child2, 20);
        YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child1_child3, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root_child1_child3, 25);
        YGNodeStyleSetHeight(root_child1_child3, 10);
        YGNodeInsertChild(root_child1, root_child1_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline_no_override_on_secondline()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 60);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 25);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 25);
        YGNodeStyleSetHeight(root_child1_child0, 20);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child1, 25);
        YGNodeStyleSetHeight(root_child1_child1, 10);
        YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child2, 25);
        YGNodeStyleSetHeight(root_child1_child2, 20);
        YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child1_child3, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root_child1_child3, 25);
        YGNodeStyleSetHeight(root_child1_child3, 10);
        YGNodeInsertChild(root_child1, root_child1_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_top()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_top2()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPosition(root_child1, YGEdge.YGEdgeTop, 5);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_double_nested_child()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0, 50);
        YGNodeStyleSetHeight(root_child0_child0, 20);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 15);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(15, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(15, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_column()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_margin()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeLeft, 5);
        YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeTop, 5);
        YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeRight, 5);
        YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeBottom, 5);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeLeft, 1);
        YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeTop, 1);
        YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeRight, 1);
        YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeBottom, 1);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(44, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(1, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(1, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(44, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(-1, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(1, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_child_padding()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetPadding(root, YGEdge.YGEdgeLeft, 5);
        YGNodeStyleSetPadding(root, YGEdge.YGEdgeTop, 5);
        YGNodeStyleSetPadding(root, YGEdge.YGEdgeRight, 5);
        YGNodeStyleSetPadding(root, YGEdge.YGEdgeBottom, 5);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeLeft, 5);
        YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeTop, 5);
        YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeRight, 5);
        YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeBottom, 5);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(55, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(-5, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(-5, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_multiline()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 20);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2, 50);
        YGNodeStyleSetHeight(root_child2, 20);
        YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2_child0, 50);
        YGNodeStyleSetHeight(root_child2_child0, 10);
        YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child3, 50);
        YGNodeStyleSetHeight(root_child3, 50);
        YGNodeInsertChild(root, root_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_column()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 30);
        YGNodeStyleSetHeight(root_child1, 50);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 20);
        YGNodeStyleSetHeight(root_child1_child0, 20);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2, 40);
        YGNodeStyleSetHeight(root_child2, 70);
        YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2_child0, 10);
        YGNodeStyleSetHeight(root_child2_child0, 10);
        YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child3, 50);
        YGNodeStyleSetHeight(root_child3, 20);
        YGNodeInsertChild(root, root_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_column2()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 30);
        YGNodeStyleSetHeight(root_child1, 50);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 20);
        YGNodeStyleSetHeight(root_child1_child0, 20);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2, 40);
        YGNodeStyleSetHeight(root_child2, 70);
        YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2_child0, 10);
        YGNodeStyleSetHeight(root_child2_child0, 10);
        YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child3, 50);
        YGNodeStyleSetHeight(root_child3, 20);
        YGNodeInsertChild(root, root_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_row_and_column()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 50);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child1_child0, 50);
        YGNodeStyleSetHeight(root_child1_child0, 10);
        YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2, 50);
        YGNodeStyleSetHeight(root_child2, 20);
        YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child2_child0, 50);
        YGNodeStyleSetHeight(root_child2_child0, 10);
        YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child3, 50);
        YGNodeStyleSetHeight(root_child3, 20);
        YGNodeInsertChild(root, root_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_center_child_with_margin_bigger_than_parent()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetWidth(root, 52);
        YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignCenter);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeLeft, 10);
        YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeRight, 10);
        YGNodeStyleSetWidth(root_child0_child0, 52);
        YGNodeStyleSetHeight(root_child0_child0, 52);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_flex_end_child_with_margin_bigger_than_parent()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetWidth(root, 52);
        YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexEnd);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeLeft, 10);
        YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeRight, 10);
        YGNodeStyleSetWidth(root_child0_child0, 52);
        YGNodeStyleSetHeight(root_child0_child0, 52);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_center_child_without_margin_bigger_than_parent()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetWidth(root, 52);
        YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignCenter);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0, 72);
        YGNodeStyleSetHeight(root_child0_child0, 72);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_items_flex_end_child_without_margin_bigger_than_parent()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetWidth(root, 52);
        YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexEnd);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0, 72);
        YGNodeStyleSetHeight(root_child0_child0, 72);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_center_should_size_based_on_content()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        YGNodeStyleSetMargin(root, YGEdge.YGEdgeTop, 20);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root_child0, YGJustify.YGJustifyCenter);
        YGNodeStyleSetFlexShrink(root_child0, 1);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0_child0, 20);
        YGNodeStyleSetHeight(root_child0_child0_child0, 20);
        YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_strech_should_size_based_on_parent()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root, YGEdge.YGEdgeTop, 20);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root_child0, YGJustify.YGJustifyCenter);
        YGNodeStyleSetFlexShrink(root_child0, 1);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0_child0, 20);
        YGNodeStyleSetHeight(root_child0_child0_child0, 20);
        YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_flex_start_with_shrinking_children()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 500);
        YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexStart);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_flex_start_with_stretching_children()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 500);
        YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test public void align_flex_start_with_shrinking_children_with_stretch()
    {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 500);
        YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexStart);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(500, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetHeight(root_child0_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }


}
