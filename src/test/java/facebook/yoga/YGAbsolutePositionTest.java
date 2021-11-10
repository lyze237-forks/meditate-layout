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
import static facebook.GlobalMembers.YGNodeStyleSetHeight;
import static facebook.GlobalMembers.YGNodeStyleSetPosition;
import static facebook.GlobalMembers.YGNodeStyleSetPositionType;
import static facebook.GlobalMembers.YGNodeStyleSetWidth;
import static facebook.GlobalMembers.YGUndefined;
import static facebook.yoga.YGDirection.YGDirectionLTR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YGAbsolutePositionTest {

    @Test
    public void absolute_layout_width_height_start_top() {
        final YGConfig config = YGConfigNew();

        final YGNode root = YGNodeNewWithConfig(config);
        YGNodeStyleSetWidth(root, 100);
        YGNodeStyleSetHeight(root, 100);

        final YGNode root_child0 = YGNodeNewWithConfig(config);
        YGNodeStyleSetPositionType(root_child0, YGPositionType.YGPositionTypeAbsolute);
        YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeStart, 10);
        YGNodeStyleSetPosition(root_child0, YGEdge.YGEdgeTop, 10);
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

        YGNodeCalculateLayout(root, YGUndefined, YGUndefined, YGDirection.YGDirectionRTL);

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

}
