package io.github.orioncraftmc.meditate.internal;

import io.github.orioncraftmc.meditate.internal.enums.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YGAbsolutePositionTest extends YogaTest {

    @Test
    public void absolute_layout_width_height_start_top() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeStart, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        Assertions.assertEquals(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        Assertions.assertEquals(0, GlobalMembers.YGNodeLayoutGetTop(root));
        Assertions.assertEquals(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        Assertions.assertEquals(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        Assertions.assertEquals(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        Assertions.assertEquals(0, GlobalMembers.YGNodeLayoutGetTop(root));
        Assertions.assertEquals(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        Assertions.assertEquals(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        Assertions.assertEquals(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        Assertions.assertEquals(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);

    }

    @Test
    public void absolute_layout_width_height_end_bottom() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeEnd, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_start_top_end_bottom() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeStart, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeEnd, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_width_height_start_top_end_bottom() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeStart, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeEnd, 10);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void do_not_clamp_height_of_absolute_node_to_height_of_its_overflow_hidden_parent() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetOverflow(root, YGOverflow.YGOverflowHidden);
        GlobalMembers.YGNodeStyleSetWidth(root, 50);
        GlobalMembers.YGNodeStyleSetHeight(root, 50);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeStart, 0);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 0);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0_child0, 100);
        GlobalMembers.YGNodeStyleSetHeight(root_child0_child0, 100);
        GlobalMembers.YGNodeInsertChild(root_child0, root_child0_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root_child0_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_within_border() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetMargin(root, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetPadding(root, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetBorder(root, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetBorder(root, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetBorder(root, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetBorder(root, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeLeft, 0);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 0);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child1, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child1, YGEdge.YGEdgeRight, 0);
        GlobalMembers.YGNodeStyleSetPosition(root_child1, YGEdge.YGEdgeBottom, 0);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child2, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child2, YGEdge.YGEdgeLeft, 0);
        GlobalMembers.YGNodeStyleSetPosition(root_child2, YGEdge.YGEdgeTop, 0);
        GlobalMembers.YGNodeStyleSetMargin(root_child2, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child2, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child2, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child2, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child2, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child3 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child3, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child3, YGEdge.YGEdgeRight, 0);
        GlobalMembers.YGNodeStyleSetPosition(root_child3, YGEdge.YGEdgeBottom, 0);
        GlobalMembers.YGNodeStyleSetMargin(root_child3, YGEdge.YGEdgeLeft, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child3, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child3, YGEdge.YGEdgeRight, 10);
        GlobalMembers.YGNodeStyleSetMargin(root_child3, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child3, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child3, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child3, 3);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child3));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_flex_end() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyFlexEnd);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_justify_content_center() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_center() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_center_on_child_only() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child0, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_top_position() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_bottom_position() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_left_position() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeLeft, 5);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_right_position() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetJustifyContent(root, YGJustify.YGJustifyCenter);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignCenter);
        GlobalMembers.YGNodeStyleSetFlexGrow(root, 1);
        GlobalMembers.YGNodeStyleSetWidth(root, 110);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeRight, 5);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 60);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 40);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void position_root_with_rtl_should_position_withoutdirection() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPosition(root, YGEdge.YGEdgeLeft, 72);
        GlobalMembers.YGNodeStyleSetWidth(root, 52);
        GlobalMembers.YGNodeStyleSetHeight(root, 52);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(72, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, GlobalMembers.YGNodeLayoutGetHeight(root));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_percentage_bottom_based_on_parent_height() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 200);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPositionPercent(root_child0, YGEdge.YGEdgeTop, 50);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child1, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPositionPercent(root_child1, YGEdge.YGEdgeBottom, 50);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 10);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child2 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child2, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetPositionPercent(root_child2, YGEdge.YGEdgeTop, 10);
        GlobalMembers.YGNodeStyleSetPositionPercent(root_child2, YGEdge.YGEdgeBottom, 10);
        GlobalMembers.YGNodeStyleSetWidth(root_child2, 10);
        GlobalMembers.YGNodeInsertChild(root, root_child2, 2);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(200, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(160, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(200, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(90, GlobalMembers.YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(10, GlobalMembers.YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(160, GlobalMembers.YGNodeLayoutGetHeight(root_child2));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_column_container() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrapReverse);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_row_container() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrapReverse);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_column_container_flex_end() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrapReverse);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child0, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_row_container_flex_end() {
        final YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetFlexWrap(root, YGWrap.YGWrapWrapReverse);
        GlobalMembers.YGNodeStyleSetWidth(root, 100);
        GlobalMembers.YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetAlignSelf(root_child0, YGAlign.YGAlignFlexEnd);
        GlobalMembers.YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 20);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 20);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);
        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }
}
