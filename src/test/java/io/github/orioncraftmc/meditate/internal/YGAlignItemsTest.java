package io.github.orioncraftmc.meditate.internal;

import io.github.orioncraftmc.meditate.internal.enums.*;
import org.junit.jupiter.api.Test;


public class YGAlignItemsTest extends YogaTest {

    @Test public void align_items_stretch()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_items_center()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_flex_start()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignFlexStart);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_flex_end()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 60);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 25);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child1, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child1, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child2, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child2, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child3, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child3, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline_override()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 60);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 25);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child1_child1, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child1, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child1, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child2, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child2, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child1_child3, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child3, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child3, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_multiline_no_override_on_secondline()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 60);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetFlexWrap(root_child1, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 25);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child1, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child1, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        final YGNode root_child1_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child2, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child2, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child2, 2);

        final YGNode root_child1_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child1_child3, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child3, 25);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child3, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child1));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child2));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child1_child3));
        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child3));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_top()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_top2()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPosition(root_child1, YGEdge.YGEdgeTop, 5);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_double_nested_child()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 15);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(15, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(15, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_column()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_margin()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeLeft, 5);
        GlobalMembers.YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeTop, 5);
        GlobalMembers.YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeRight, 5);
        GlobalMembers.YGNodeStyleSetMargin(root_child0, YGEdge.YGEdgeBottom, 5);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeLeft, 1);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeTop, 1);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeRight, 1);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child0, YGEdge.YGEdgeBottom, 1);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(44, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(1, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(1, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(44, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(-1, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(1, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_child_padding()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeLeft, 5);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeTop, 5);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeRight, 5);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeBottom, 5);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeLeft, 5);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeTop, 5);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeRight, 5);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeBottom, 5);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(55, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(-5, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(-5, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_multiline()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child2, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child2_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child3, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child3, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_column()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 30);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 40);
        GlobalMembers.YGNodeStyleSetHeight(root_child2, 70);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child2_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child3, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child3, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_column2()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 30);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 40);
        GlobalMembers.YGNodeStyleSetHeight(root_child2, 70);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child2_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child3, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child3, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_baseline_multiline_row_and_column()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrap);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child2, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child2_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child2_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child2_child0, 10);
        GlobalMembers.YGNodeInsertChild(root_child2, root_child2_child0, 0);

        final YGNode root_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child3, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child3, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child2_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child2_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_center_child_with_margin_bigger_than_parent()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetWidth(root, 52);
        GlobalMembers.YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 52);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 52);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_flex_end_child_with_margin_bigger_than_parent()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetWidth(root, 52);
        GlobalMembers.YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child0_child0, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 52);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 52);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_center_child_without_margin_bigger_than_parent()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetWidth(root, 52);
        GlobalMembers.YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 72);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 72);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_items_flex_end_child_without_margin_bigger_than_parent()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetWidth(root, 52);
        GlobalMembers.YGNodeStyleSetHeight(root, 52);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 72);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 72);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(-10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_center_should_size_based_on_content()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeTop, 20);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root_child0, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0, 1);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_strech_should_size_based_on_parent()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeTop, 20);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root_child0, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0, 1);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0_child0, 20);
        GlobalMembers.YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_flex_start_with_shrinking_children()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 500);
        GlobalMembers.YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexStart);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_flex_start_with_stretching_children()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 500);
        GlobalMembers.YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test public void align_flex_start_with_shrinking_children_with_stretch()
    {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 500);
        GlobalMembers.YGNodeStyleSetHeight(root, 500);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root_child0, YGAlign.YGAlignFlexStart);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);

        final YGNode root_child0_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0_child0_child0, 1);
        GlobalMembers.YGNodeInsertChild(root_child0_child0, root_child0_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }


}
