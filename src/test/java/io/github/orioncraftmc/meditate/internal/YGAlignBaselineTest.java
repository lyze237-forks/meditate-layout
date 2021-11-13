package io.github.orioncraftmc.meditate.internal;

import io.github.orioncraftmc.meditate.internal.enums.*;
import org.junit.jupiter.api.Test;

public class YGAlignBaselineTest extends YogaTest {

    private static float _baselineFunc(YGNode node, final float width, final float height) {
        return height / 2;
    }

    private static YGSize _measure1(YGNode node, float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode) {
        return new YGSize(42, 50);
    }

    private static YGSize _measure2(YGNode node, float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode) {
        return new YGSize(279, 126);
    }

    private static YGNode createYGNode(YGConfig config, YGFlexDirection direction, int width, int height, boolean alignBaseline) {
        final YGNode node = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(node, direction);
        if (alignBaseline) {
            GlobalMembers.YGNodeStyleSetAlignItems(node, YGAlign.YGAlignBaseline);
        }
        GlobalMembers.YGNodeStyleSetWidth(node, width);
        GlobalMembers.YGNodeStyleSetHeight(node, height);
        return new YGNode(node);
    }

    // Test case for bug in T32999822
    @Test
    public void align_baseline_parent_ht_not_specified() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignContent(root, YGAlign.YGAlignStretch);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 340);
        GlobalMembers.YGNodeStyleSetMaxHeight(root, 170);
        GlobalMembers.YGNodeStyleSetMinHeight(root, 0);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child0, 0);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child0, 1);
        GlobalMembers.YGNodeSetMeasureFunc(root_child0, YGAlignBaselineTest::_measure1);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexGrow(root_child1, 0);
        GlobalMembers.YGNodeStyleSetFlexShrink(root_child1, 1);
        GlobalMembers.YGNodeSetMeasureFunc(root_child1, YGAlignBaselineTest::_measure2);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(340, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(126, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(42, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));
        ASSERT_FLOAT_EQ(76, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(42, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(279, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(126, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_with_no_parent_ht() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 150);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 40);
        GlobalMembers.YGNodeSetBaselineFunc(root_child1, YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(150, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(70, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(40, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_with_no_baseline_func_and_no_parent_ht() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 150);

        final YGNode root_child0 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child0, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child0, 80);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 50);
        GlobalMembers.YGNodeStyleSetHeight(root_child1, 50);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root));
        ASSERT_FLOAT_EQ(150, GlobalMembers.YGNodeLayoutGetWidth(root));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child0));
        ASSERT_FLOAT_EQ(80, GlobalMembers.YGNodeLayoutGetHeight(root_child0));

        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(30, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetWidth(root_child1));
        ASSERT_FLOAT_EQ(50, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_column_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_with_padding_in_column_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_with_padding_using_child_in_column_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(400, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_with_margin_using_child_in_column_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeStyleSetMargin(root_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(600, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_with_margin_in_column_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(400, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_row_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 500, 800, true);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_with_padding_in_row_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 500, 800, true);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetPadding(root_child1_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_with_margin_in_row_as_reference() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 500, 800, true);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeLeft, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeRight, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeTop, 100);
        GlobalMembers.YGNodeStyleSetMargin(root_child1_child1, YGEdge.YGEdgeBottom, 100);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(600, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_column_as_reference_with_no_baseline_func() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 800, false);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_row_as_reference_with_no_baseline_func() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 1000, 1000, true);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionRow, 500, 800, true);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_column_as_reference_with_height_not_specified() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 1000);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionColumn);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 500);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(800, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(700, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_row_as_reference_with_height_not_specified() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 1000);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 500);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        root_child1_child1.setBaselineFunc(YGAlignBaselineTest::_baselineFunc);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(900, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(400, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_column_as_reference_with_no_baseline_func_and_height_not_specified() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 1000);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionColumn);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 500);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 300, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(700, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(100, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(700, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(300, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

    @Test
    public void align_baseline_parent_using_child_in_row_as_reference_with_no_baseline_func_and_height_not_specified() {
        YGConfig config = GlobalMembers.YGConfigNew();

        final YGNode root = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetAlignItems(root, YGAlign.YGAlignBaseline);
        GlobalMembers.YGNodeStyleSetWidth(root, 1000);

        final YGNode root_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 600, false);
        GlobalMembers.YGNodeInsertChild(root, root_child0, 0);

        final YGNode root_child1 = GlobalMembers.YGNodeNewWithConfig(config);
        GlobalMembers.YGNodeStyleSetFlexDirection(root_child1, YGFlexDirection.YGFlexDirectionRow);
        GlobalMembers.YGNodeStyleSetWidth(root_child1, 500);
        GlobalMembers.YGNodeInsertChild(root, root_child1, 1);

        final YGNode root_child1_child0 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 500, false);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child0, 0);

        final YGNode root_child1_child1 = createYGNode(config, YGFlexDirection.YGFlexDirectionColumn, 500, 400, false);
        GlobalMembers.YGNodeSetIsReferenceBaseline(root_child1_child1, true);
        GlobalMembers.YGNodeInsertChild(root_child1, root_child1_child1, 1);

        GlobalMembers.YGNodeCalculateLayout(root, GlobalMembers.YGUndefined, GlobalMembers.YGUndefined, YGDirection.YGDirectionLTR);

        ASSERT_FLOAT_EQ(700, GlobalMembers.YGNodeLayoutGetHeight(root));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1));
        ASSERT_FLOAT_EQ(200, GlobalMembers.YGNodeLayoutGetTop(root_child1));
        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetHeight(root_child1));

        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child0));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child0));

        ASSERT_FLOAT_EQ(500, GlobalMembers.YGNodeLayoutGetLeft(root_child1_child1));
        ASSERT_FLOAT_EQ(0, GlobalMembers.YGNodeLayoutGetTop(root_child1_child1));

        GlobalMembers.YGNodeFreeRecursive(root);

        GlobalMembers.YGConfigFree(config);
    }

}
