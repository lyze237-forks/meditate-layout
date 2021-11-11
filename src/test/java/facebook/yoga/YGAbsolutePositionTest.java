package facebook.yoga;

import static facebook.GlobalMembers.YGConfigFree;
import static facebook.GlobalMembers.YGConfigNew;
import static facebook.GlobalMembers.YGNodeCalculateLayout;
import static facebook.GlobalMembers.YGNodeFreeRecursive;
import static facebook.GlobalMembers.YGNodeInsertChild;
import static facebook.GlobalMembers.YGNodeLayoutGetHeight;
import static facebook.GlobalMembers.YGNodeLayoutGetLeft;
import static facebook.GlobalMembers.YGNodeLayoutGetTop;
import static facebook.GlobalMembers.YGNodeLayoutGetWidth;
import static facebook.GlobalMembers.YGNodeNewWithConfig;
import static facebook.GlobalMembers.YGNodeStyleSetAlignItems;
import static facebook.GlobalMembers.YGNodeStyleSetAlignSelf;
import static facebook.GlobalMembers.YGNodeStyleSetBorder;
import static facebook.GlobalMembers.YGNodeStyleSetFlexDirection;
import static facebook.GlobalMembers.YGNodeStyleSetFlexGrow;
import static facebook.GlobalMembers.YGNodeStyleSetFlexWrap;
import static facebook.GlobalMembers.YGNodeStyleSetHeight;
import static facebook.GlobalMembers.YGNodeStyleSetJustifyContent;
import static facebook.GlobalMembers.YGNodeStyleSetMargin;
import static facebook.GlobalMembers.YGNodeStyleSetOverflow;
import static facebook.GlobalMembers.YGNodeStyleSetPadding;
import static facebook.GlobalMembers.YGNodeStyleSetPosition;
import static facebook.GlobalMembers.YGNodeStyleSetPositionPercent;
import static facebook.GlobalMembers.YGNodeStyleSetPositionType;
import static facebook.GlobalMembers.YGNodeStyleSetWidth;
import static facebook.GlobalMembers.YGUndefined;
import static facebook.yoga.YGAlign.YGAlignCenter;
import static facebook.yoga.YGAlign.YGAlignFlexEnd;
import static facebook.yoga.YGDirection.YGDirectionLTR;
import static facebook.yoga.YGDirection.YGDirectionRTL;
import static facebook.yoga.YGEdge.YGEdgeBottom;
import static facebook.yoga.YGEdge.YGEdgeEnd;
import static facebook.yoga.YGEdge.YGEdgeLeft;
import static facebook.yoga.YGEdge.YGEdgeRight;
import static facebook.yoga.YGEdge.YGEdgeStart;
import static facebook.yoga.YGEdge.YGEdgeTop;
import static facebook.yoga.YGFlexDirection.YGFlexDirectionRow;
import static facebook.yoga.YGJustify.YGJustifyCenter;
import static facebook.yoga.YGJustify.YGJustifyFlexEnd;
import static facebook.yoga.YGOverflow.YGOverflowHidden;
import static facebook.yoga.YGPositionType.YGPositionTypeAbsolute;
import static facebook.yoga.YGWrap.YGWrapWrapReverse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YGAbsolutePositionTest extends YogaTest {

    @Test
    public void absolute_layout_width_height_start_top() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeStart, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 10);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        Assertions.assertEquals(0, YGNodeLayoutGetLeft(root));
        Assertions.assertEquals(0, YGNodeLayoutGetTop(root));
        Assertions.assertEquals(100, YGNodeLayoutGetWidth(root));
        Assertions.assertEquals(100, YGNodeLayoutGetHeight(root));

        Assertions.assertEquals(10, YGNodeLayoutGetLeft(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetTop(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetWidth(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        Assertions.assertEquals(0, YGNodeLayoutGetLeft(root));
        Assertions.assertEquals(0, YGNodeLayoutGetTop(root));
        Assertions.assertEquals(100, YGNodeLayoutGetWidth(root));
        Assertions.assertEquals(100, YGNodeLayoutGetHeight(root));

        Assertions.assertEquals(80, YGNodeLayoutGetLeft(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetTop(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetWidth(root_child0));
        Assertions.assertEquals(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);

    }

    @Test
    public void absolute_layout_width_height_end_bottom() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeEnd, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_start_top_end_bottom() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeStart, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeEnd, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeBottom, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_width_height_start_top_end_bottom() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeStart, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeEnd, 10);
        YGNodeStyleSetPosition(root_child0, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void do_not_clamp_height_of_absolute_node_to_height_of_its_overflow_hidden_parent() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirectionRow);
        YGNodeStyleSetOverflow(root, YGOverflowHidden);
        YGNodeStyleSetWidth(root, 50);
        YGNodeStyleSetHeight(root, 50);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeStart, 0);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 0);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child0_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root_child0_child0, 100);
        YGNodeStyleSetHeight(root_child0_child0, 100);
        YGNodeInsertChild(root_child0, root_child0_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(-50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root_child0_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root_child0_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_within_border() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetMargin(root, YGEdgeLeft, 10);
        YGNodeStyleSetMargin(root, YGEdgeTop, 10);
        YGNodeStyleSetMargin(root, YGEdgeRight, 10);
        YGNodeStyleSetMargin(root, YGEdgeBottom, 10);
        YGNodeStyleSetPadding(root, YGEdgeLeft, 10);
        YGNodeStyleSetPadding(root, YGEdgeTop, 10);
        YGNodeStyleSetPadding(root, YGEdgeRight, 10);
        YGNodeStyleSetPadding(root, YGEdgeBottom, 10);
        YGNodeStyleSetBorder(root, YGEdgeLeft, 10);
        YGNodeStyleSetBorder(root, YGEdgeTop, 10);
        YGNodeStyleSetBorder(root, YGEdgeRight, 10);
        YGNodeStyleSetBorder(root, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeLeft, 0);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 0);
        YGNodeStyleSetWidth(root_child0, 50);
        YGNodeStyleSetHeight(root_child0, 50);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child1, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child1, YGEdgeRight, 0);
        YGNodeStyleSetPosition(root_child1, YGEdgeBottom, 0);
        YGNodeStyleSetWidth(root_child1, 50);
        YGNodeStyleSetHeight(root_child1, 50);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child2, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child2, YGEdgeLeft, 0);
        YGNodeStyleSetPosition(root_child2, YGEdgeTop, 0);
        YGNodeStyleSetMargin(root_child2, YGEdgeLeft, 10);
        YGNodeStyleSetMargin(root_child2, YGEdgeTop, 10);
        YGNodeStyleSetMargin(root_child2, YGEdgeRight, 10);
        YGNodeStyleSetMargin(root_child2, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child2, 50);
        YGNodeStyleSetHeight(root_child2, 50);
        YGNodeInsertChild(root, root_child2, 2);

        final YGNode root_child3 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child3, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child3, YGEdgeRight, 0);
        YGNodeStyleSetPosition(root_child3, YGEdgeBottom, 0);
        YGNodeStyleSetMargin(root_child3, YGEdgeLeft, 10);
        YGNodeStyleSetMargin(root_child3, YGEdgeTop, 10);
        YGNodeStyleSetMargin(root_child3, YGEdgeRight, 10);
        YGNodeStyleSetMargin(root_child3, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child3, 50);
        YGNodeStyleSetHeight(root_child3, 50);
        YGNodeInsertChild(root, root_child3, 3);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child3));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child2));

        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetLeft(root_child3));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetWidth(root_child3));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetHeight(root_child3));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_flex_end() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyFlexEnd);
        YGNodeStyleSetAlignItems(root, YGAlignFlexEnd);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_justify_content_center() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_center() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_center_on_child_only() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child0, YGAlignCenter);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_top_position() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeTop, 10);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_bottom_position() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(25, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(50, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_left_position() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeLeft, 5);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(5, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_align_items_and_justify_content_center_and_right_position() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetJustifyContent(root, YGJustifyCenter);
        YGNodeStyleSetAlignItems(root, YGAlignCenter);
        YGNodeStyleSetFlexGrow(root, 1);
        YGNodeStyleSetWidth(root, 110);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdgeRight, 5);
        YGNodeStyleSetWidth(root_child0, 60);
        YGNodeStyleSetHeight(root_child0, 40);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(110, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(45, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(30, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(60, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(40, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void position_root_with_rtl_should_position_withoutdirection() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetPosition(root, YGEdgeLeft, 72);
        YGNodeStyleSetWidth(root, 52);
        YGNodeStyleSetHeight(root, 52);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(72, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(52, YGNodeLayoutGetHeight(root));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_percentage_bottom_based_on_parent_height() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 200);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetPositionPercent(root_child0, YGEdgeTop, 50);
        YGNodeStyleSetWidth(root_child0, 10);
        YGNodeStyleSetHeight(root_child0, 10);
        YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child1, YGPositionTypeAbsolute);
        YGNodeStyleSetPositionPercent(root_child1, YGEdgeBottom, 50);
        YGNodeStyleSetWidth(root_child1, 10);
        YGNodeStyleSetHeight(root_child1, 10);
        YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child2 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child2, YGPositionTypeAbsolute);
        YGNodeStyleSetPositionPercent(root_child2, YGEdgeTop, 10);
        YGNodeStyleSetPositionPercent(root_child2, YGEdgeBottom, 10);
        YGNodeStyleSetWidth(root_child2, 10);
        YGNodeInsertChild(root, root_child2, 2);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(200, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(160, YGNodeLayoutGetHeight(root_child2));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(200, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(90, YGNodeLayoutGetLeft(root_child2));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetTop(root_child2));
        ASSERT_FLOAT_EQ(10, YGNodeLayoutGetWidth(root_child2));
        ASSERT_FLOAT_EQ(160, YGNodeLayoutGetHeight(root_child2));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_column_container() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexWrap(root, YGWrapWrapReverse);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 20);
        YGNodeStyleSetHeight(root_child0, 20);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_row_container() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirectionRow);
        YGNodeStyleSetFlexWrap(root, YGWrapWrapReverse);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 20);
        YGNodeStyleSetHeight(root_child0, 20);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_column_container_flex_end() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexWrap(root, YGWrapWrapReverse);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child0, YGAlignFlexEnd);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 20);
        YGNodeStyleSetHeight(root_child0, 20);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }

    @Test
    public void absolute_layout_in_wrap_reverse_row_container_flex_end() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetFlexDirection(root, YGFlexDirectionRow);
        YGNodeStyleSetFlexWrap(root, YGWrapWrapReverse);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetAlignSelf(root_child0, YGAlignFlexEnd);
        YGNodeStyleSetPositionType(root_child0, YGPositionTypeAbsolute);
        YGNodeStyleSetWidth(root_child0, 20);
        YGNodeStyleSetHeight(root_child0, 20);
        YGNodeInsertChild(root, root_child0, 0);
        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirectionRTL);

        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(100, YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(80, YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(20, YGNodeLayoutGetHeight(root_child0));

        YGNodeFreeRecursive(root);

        YGConfigFree(config);
    }
}
