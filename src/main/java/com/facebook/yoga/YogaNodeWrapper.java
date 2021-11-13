/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.yoga;

import io.github.orioncraftmc.meditate.GlobalMembers;
import io.github.orioncraftmc.meditate.internal.*;
import io.github.orioncraftmc.meditate.internal.enums.*;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class YogaNodeWrapper extends YogaNode implements Cloneable {

    /* Those flags needs be in sync with YGJNI.h */
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;
    private static final byte BORDER = 4;
    private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    private static final byte HAS_NEW_LAYOUT = 16;

    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    protected YGNode mNativePointer;
    @Nullable
    private YogaNodeWrapper mOwner;
    @Nullable
    private List<YogaNodeWrapper> mChildren;
    @Nullable
    private YogaMeasureFunction mMeasureFunction;
    @Nullable
    private YogaBaselineFunction mBaselineFunction;
    @Nullable
    private Object mData;

    private int mLayoutDirection = 0;

    private boolean mHasNewLayout = true;

    private YogaNodeWrapper(YGNode nativePointer) {
        mNativePointer = nativePointer;
    }

    YogaNodeWrapper() {
        this(GlobalMembers.YGNodeNew());
    }

    YogaNodeWrapper(YogaConfig config) {
        this(GlobalMembers.YGNodeNewWithConfig(((YogaConfigWrapper) config).mNativePointer));
    }

    private static YogaValue valueFromNative(YGValue value) {
        return new YogaValue(value.getValue(), YogaUnit.fromInt(value.getUnit().getValue()));
    }

    public void reset() {
        mMeasureFunction = null;
        mBaselineFunction = null;
        mData = null;

        GlobalMembers.YGNodeReset(mNativePointer);
    }

    public int getChildCount() {
        return mChildren == null ? 0 : mChildren.size();
    }

    public YogaNodeWrapper getChildAt(int i) {
        if (mChildren == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return mChildren.get(i);
    }

    public void addChildAt(YogaNode c, int i) {
        if (!(c instanceof YogaNodeWrapper)) {
            return;
        }
        YogaNodeWrapper child = (YogaNodeWrapper) c;
        if (child.mOwner != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }

        if (mChildren == null) {
            mChildren = new ArrayList<>(4);
        }
        mChildren.add(i, child);
        child.mOwner = this;
        GlobalMembers.YGNodeInsertChild(mNativePointer, child.mNativePointer, i);
    }

    public void setIsReferenceBaseline(boolean isReferenceBaseline) {
        GlobalMembers.YGNodeSetIsReferenceBaseline(mNativePointer, isReferenceBaseline);
    }

    public boolean isReferenceBaseline() {
        return GlobalMembers.YGNodeIsReferenceBaseline(mNativePointer);
    }

    public void swapChildAt(YogaNode newChild, int position) {
        if (!(newChild instanceof YogaNodeWrapper)) {
            return;
        }
        YogaNodeWrapper child = (YogaNodeWrapper) newChild;
        mChildren.remove(position);
        mChildren.add(position, child);
        child.mOwner = this;
        GlobalMembers.YGNodeSwapChild(mNativePointer, child.mNativePointer, position);
    }

    @Override
    public YogaNodeWrapper cloneWithChildren() {
        try {
            YogaNodeWrapper clonedYogaNode = (YogaNodeWrapper) super.clone();
            if (clonedYogaNode.mChildren != null) {
                clonedYogaNode.mChildren = new ArrayList<>(clonedYogaNode.mChildren);
            }
            @NotNull YGNode clonedNativePointer = GlobalMembers.YGNodeClone(mNativePointer);
            clonedYogaNode.mOwner = null;
            clonedYogaNode.mNativePointer = clonedNativePointer;
            for (int i = 0; i < clonedYogaNode.getChildCount(); i++) {
                clonedYogaNode.swapChildAt(clonedYogaNode.getChildAt(i).cloneWithChildren(), i);
            }

            return clonedYogaNode;
        } catch (CloneNotSupportedException ex) {
            // This class implements Cloneable, this should not happen
            throw new RuntimeException(ex);
        }
    }

    @Override
    public YogaNodeWrapper cloneWithoutChildren() {
        try {
            YogaNodeWrapper clonedYogaNode = (YogaNodeWrapper) super.clone();
            @NotNull YGNode clonedNativePointer = GlobalMembers.YGNodeClone(mNativePointer);
            clonedYogaNode.mOwner = null;
            clonedYogaNode.mNativePointer = clonedNativePointer;
            clonedYogaNode.clearChildren();
            return clonedYogaNode;
        } catch (CloneNotSupportedException ex) {
            // This class implements Cloneable, this should not happen
            throw new RuntimeException(ex);
        }
    }

    private void clearChildren() {
        mChildren = null;
        mNativePointer.clearChildren();
    }

    public YogaNodeWrapper removeChildAt(int i) {
        if (mChildren == null) {
            throw new IllegalStateException(
                    "Trying to remove a child of a YogaNode that does not have children");
        }
        final YogaNodeWrapper child = mChildren.remove(i);
        child.mOwner = null;
        GlobalMembers.YGNodeRemoveChild(mNativePointer, child.mNativePointer);
        return child;
    }

    /**
     * The owner is used to identify the YogaTree that a {@link YogaNode} belongs to. This method will
     * return the parent of the {@link YogaNode} when the {@link YogaNode} only belongs to one
     * YogaTree or null when the {@link YogaNode} is shared between two or more YogaTrees.
     *
     * @return the {@link YogaNode} that owns this {@link YogaNode}.
     */
    @Nullable
    public YogaNodeWrapper getOwner() {
        return mOwner;
    }

    /**
     * @deprecated Use #getOwner() instead. This will be removed in the next version.
     */
    @Deprecated
    @Nullable
    public YogaNodeWrapper getParent() {
        return getOwner();
    }

    public int indexOf(YogaNode child) {
        return mChildren == null ? -1 : mChildren.indexOf(child);
    }

    public void calculateLayout(float width, float height) {
        YGNode[] nativePointers = null;
        YogaNodeWrapper[] nodes = null;

        freeze(null);

        ArrayList<YogaNodeWrapper> n = new ArrayList<>();
        n.add(this);
        for (int i = 0; i < n.size(); ++i) {
            final YogaNodeWrapper parent = n.get(i);
            List<YogaNodeWrapper> children = parent.mChildren;
            if (children != null) {
                for (YogaNodeWrapper child : children) {
                    child.freeze(parent);
                    n.add(child);
                }
            }
        }

        nodes = n.toArray(new YogaNodeWrapper[0]);
        nativePointers = new YGNode[nodes.length];
        for (int i = 0; i < nodes.length; ++i) {
            nativePointers[i] = nodes[i].mNativePointer;
        }

        GlobalMembers.YGNodeCalculateLayoutWithContext(mNativePointer, width, height,
                GlobalMembers.YGNodeStyleGetDirection(mNativePointer), nativePointers);
    }

    private void freeze(YogaNode parent) {
        Object data = getData();
        if (data instanceof Inputs) {
            ((Inputs) data).freeze(this, parent);
        }
    }

    public void dirty() {
        GlobalMembers.YGNodeMarkDirty(mNativePointer);
    }

    public void dirtyAllDescendants() {
        GlobalMembers.YGNodeMarkDirtyAndPropogateToDescendants(mNativePointer);
    }

    public boolean isDirty() {
        return GlobalMembers.YGNodeIsDirty(mNativePointer);
    }

    @Override
    public void copyStyle(YogaNode srcNode) {
        if (!(srcNode instanceof YogaNodeWrapper)) {
            return;
        }
        GlobalMembers.YGNodeCopyStyle(mNativePointer, ((YogaNodeWrapper) srcNode).mNativePointer);
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(GlobalMembers.YGNodeStyleGetDirection(mNativePointer).getValue());
    }

    public void setDirection(YogaDirection direction) {
        GlobalMembers.YGNodeStyleSetDirection(mNativePointer, YGDirection.forValue(direction.intValue()));
    }

    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(GlobalMembers.YGNodeStyleGetFlexDirection(mNativePointer).getValue());
    }

    public void setFlexDirection(YogaFlexDirection flexDirection) {
        GlobalMembers.YGNodeStyleSetFlexDirection(mNativePointer, YGFlexDirection.forValue(flexDirection.intValue()));
    }

    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(GlobalMembers.YGNodeStyleGetJustifyContent(mNativePointer).getValue());
    }

    public void setJustifyContent(YogaJustify justifyContent) {
        GlobalMembers.YGNodeStyleSetJustifyContent(mNativePointer, YGJustify.forValue(justifyContent.intValue()));
    }

    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(GlobalMembers.YGNodeStyleGetAlignItems(mNativePointer).getValue());
    }

    public void setAlignItems(YogaAlign alignItems) {
        GlobalMembers.YGNodeStyleSetAlignItems(mNativePointer, YGAlign.forValue(alignItems.intValue()));
    }

    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(GlobalMembers.YGNodeStyleGetAlignSelf(mNativePointer).getValue());
    }

    public void setAlignSelf(YogaAlign alignSelf) {
        GlobalMembers.YGNodeStyleSetAlignSelf(mNativePointer, YGAlign.forValue(alignSelf.intValue()));
    }

    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(GlobalMembers.YGNodeStyleGetAlignContent(mNativePointer).getValue());
    }

    public void setAlignContent(YogaAlign alignContent) {
        GlobalMembers.YGNodeStyleSetAlignContent(mNativePointer, YGAlign.forValue(alignContent.intValue()));
    }

    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(GlobalMembers.YGNodeStyleGetPositionType(mNativePointer).getValue());
    }

    public void setPositionType(YogaPositionType positionType) {
        GlobalMembers.YGNodeStyleSetPositionType(mNativePointer, YGPositionType.forValue(positionType.intValue()));
    }

    public YogaWrap getWrap() {
        return YogaWrap.fromInt(GlobalMembers.YGNodeStyleGetFlexWrap(mNativePointer).getValue());
    }

    public void setWrap(YogaWrap flexWrap) {
        GlobalMembers.YGNodeStyleSetFlexWrap(mNativePointer, YGWrap.forValue(flexWrap.intValue()));
    }

    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(GlobalMembers.YGNodeStyleGetOverflow(mNativePointer).getValue());
    }

    public void setOverflow(YogaOverflow overflow) {
        GlobalMembers.YGNodeStyleSetOverflow(mNativePointer, YGOverflow.forValue(overflow.intValue()));
    }

    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(GlobalMembers.YGNodeStyleGetDisplay(mNativePointer).getValue());
    }

    public void setDisplay(YogaDisplay display) {
        GlobalMembers.YGNodeStyleSetDisplay(mNativePointer, YGDisplay.forValue(display.intValue()));
    }

    public float getFlex() {
        return GlobalMembers.YGNodeStyleGetFlex(mNativePointer);
    }

    public void setFlex(float flex) {
        GlobalMembers.YGNodeStyleSetFlex(mNativePointer, flex);
    }

    public float getFlexGrow() {
        return GlobalMembers.YGNodeStyleGetFlexGrow(mNativePointer);
    }

    public void setFlexGrow(float flexGrow) {
        GlobalMembers.YGNodeStyleSetFlexGrow(mNativePointer, flexGrow);
    }

    public float getFlexShrink() {
        return GlobalMembers.YGNodeStyleGetFlexShrink(mNativePointer);
    }

    public void setFlexShrink(float flexShrink) {
        GlobalMembers.YGNodeStyleSetFlexShrink(mNativePointer, flexShrink);
    }

    public YogaValue getFlexBasis() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetFlexBasis(mNativePointer));
    }

    public void setFlexBasis(float flexBasis) {
        GlobalMembers.YGNodeStyleSetFlexBasis(mNativePointer, flexBasis);
    }

    public void setFlexBasisPercent(float percent) {
        GlobalMembers.YGNodeStyleSetFlexBasisPercent(mNativePointer, percent);
    }

    public void setFlexBasisAuto() {
        GlobalMembers.YGNodeStyleSetFlexBasisAuto(mNativePointer);
    }

    public YogaValue getMargin(YogaEdge edge) {
        return valueFromNative(GlobalMembers.YGNodeStyleGetMargin(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public void setMargin(YogaEdge edge, float margin) {
        GlobalMembers.YGNodeStyleSetMargin(mNativePointer, YGEdge.forValue(edge.intValue()), margin);
    }

    public void setMarginPercent(YogaEdge edge, float percent) {
        GlobalMembers.YGNodeStyleSetMarginPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
    }

    public void setMarginAuto(YogaEdge edge) {
        GlobalMembers.YGNodeStyleSetMarginAuto(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    public YogaValue getPadding(YogaEdge edge) {
        return valueFromNative(GlobalMembers.YGNodeStyleGetPadding(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public void setPadding(YogaEdge edge, float padding) {
        GlobalMembers.YGNodeStyleSetPadding(mNativePointer, YGEdge.forValue(edge.intValue()), padding);
    }

    public void setPaddingPercent(YogaEdge edge, float percent) {
        GlobalMembers.YGNodeStyleSetPaddingPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
    }

    public float getBorder(YogaEdge edge) {
        return GlobalMembers.YGNodeStyleGetBorder(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    public void setBorder(YogaEdge edge, float border) {
        GlobalMembers.YGNodeStyleSetBorder(mNativePointer, YGEdge.forValue(edge.intValue()), border);
    }

    public YogaValue getPosition(YogaEdge edge) {
        return valueFromNative(GlobalMembers.YGNodeStyleGetPosition(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public void setPosition(YogaEdge edge, float position) {
        GlobalMembers.YGNodeStyleSetPosition(mNativePointer, YGEdge.forValue(edge.intValue()), position);
    }

    public void setPositionPercent(YogaEdge edge, float percent) {
        GlobalMembers.YGNodeStyleSetPositionPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
    }

    public YogaValue getWidth() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetWidth(mNativePointer));
    }

    public void setWidth(float width) {
        GlobalMembers.YGNodeStyleSetWidth(mNativePointer, width);
    }

    public void setWidthPercent(float percent) {
        GlobalMembers.YGNodeStyleSetWidthPercent(mNativePointer, percent);
    }

    public void setWidthAuto() {
        GlobalMembers.YGNodeStyleSetWidthAuto(mNativePointer);
    }

    public YogaValue getHeight() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetHeight(mNativePointer));
    }

    public void setHeight(float height) {
        GlobalMembers.YGNodeStyleSetHeight(mNativePointer, height);
    }

    public void setHeightPercent(float percent) {
        GlobalMembers.YGNodeStyleSetHeightPercent(mNativePointer, percent);
    }

    public void setHeightAuto() {
        GlobalMembers.YGNodeStyleSetHeightAuto(mNativePointer);
    }

    public YogaValue getMinWidth() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetMinWidth(mNativePointer));
    }

    public void setMinWidth(float minWidth) {
        GlobalMembers.YGNodeStyleSetMinWidth(mNativePointer, minWidth);
    }

    public void setMinWidthPercent(float percent) {
        GlobalMembers.YGNodeStyleSetMinWidthPercent(mNativePointer, percent);
    }

    public YogaValue getMinHeight() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetMinHeight(mNativePointer));
    }

    public void setMinHeight(float minHeight) {
        GlobalMembers.YGNodeStyleSetMinHeight(mNativePointer, minHeight);
    }

    public void setMinHeightPercent(float percent) {
        GlobalMembers.YGNodeStyleSetMinHeightPercent(mNativePointer, percent);
    }

    public YogaValue getMaxWidth() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetMaxWidth(mNativePointer));
    }

    public void setMaxWidth(float maxWidth) {
        GlobalMembers.YGNodeStyleSetMaxWidth(mNativePointer, maxWidth);
    }

    public void setMaxWidthPercent(float percent) {
        GlobalMembers.YGNodeStyleSetMaxWidthPercent(mNativePointer, percent);
    }

    public YogaValue getMaxHeight() {
        return valueFromNative(GlobalMembers.YGNodeStyleGetMaxHeight(mNativePointer));
    }

    public void setMaxHeight(float maxheight) {
        GlobalMembers.YGNodeStyleSetMaxHeight(mNativePointer, maxheight);
    }

    public void setMaxHeightPercent(float percent) {
        GlobalMembers.YGNodeStyleSetMaxHeightPercent(mNativePointer, percent);
    }

    public float getAspectRatio() {
        return GlobalMembers.YGNodeStyleGetAspectRatio(mNativePointer);
    }

    public void setAspectRatio(float aspectRatio) {
        GlobalMembers.YGNodeStyleSetAspectRatio(mNativePointer, aspectRatio);
    }

    public void setMeasureFunction(YogaMeasureFunction measureFunction) {
        mMeasureFunction = measureFunction;
        mNativePointer.getMeasure().noContext = (node, width, widthMode, height, heightMode) -> measure(width,
                widthMode.getValue(), height, heightMode.getValue());
    }

    // Implementation Note: Why this method needs to stay final
    //
    // We cache the jmethodid for this method in Yoga code. This means that even if a subclass
    // were to override measure, we'd still call this implementation from layout code since the
    // overriding method will have a different jmethodid. This is final to prevent that mistake.
    public final YGSize measure(float width, int widthMode, float height, int heightMode) {
        if (!isMeasureDefined()) {
            throw new RuntimeException("Measure function isn't defined!");
        }

        return mMeasureFunction.measure(
                this,
                width,
                YogaMeasureMode.fromInt(widthMode),
                height,
                YogaMeasureMode.fromInt(heightMode));
    }

    public void setBaselineFunction(YogaBaselineFunction baselineFunction) {
        mBaselineFunction = baselineFunction;
        mNativePointer.setBaselineFunc((node, width, height) -> this.baseline(width, height));
    }

    public final float baseline(float width, float height) {
        return mBaselineFunction.baseline(this, width, height);
    }

    public boolean isMeasureDefined() {
        return mMeasureFunction != null;
    }

    @Override
    public boolean isBaselineDefined() {
        return mBaselineFunction != null;
    }

    @Override
    public @Nullable Object getData() {
        return mData;
    }

    public void setData(Object data) {
        mData = data;
    }

    /**
     * Use the set logger (defaults to adb log) to print out the styles, children, and computed layout
     * of the tree rooted at this node.
     */
    public void print() {
        //TODO: GlobalMembers.YGNodePrint(mNativePointer);
        // Couldn't find the print method lmao
    }

    /**
     * This method replaces the child at childIndex position with the newNode received by parameter.
     * This is different than calling removeChildAt and addChildAt because this method ONLY replaces
     * the child in the mChildren datastructure. : called from JNI
     *
     * @return the nativePointer of the newNode {@link YogaNode}
     */
    private final YGNode replaceChild(YogaNodeWrapper newNode, int childIndex) {
        if (mChildren == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        mChildren.remove(childIndex);
        mChildren.add(childIndex, newNode);
        newNode.mOwner = this;
        return newNode.mNativePointer;
    }

    @Override
    public float getLayoutX() {
        return GlobalMembers.YGNodeLayoutGetLeft(mNativePointer);
    }

    @Override
    public float getLayoutY() {
        return GlobalMembers.YGNodeLayoutGetTop(mNativePointer);
    }

    @Override
    public float getLayoutWidth() {
        return GlobalMembers.YGNodeLayoutGetWidth(mNativePointer);
    }

    @Override
    public float getLayoutHeight() {
        return GlobalMembers.YGNodeLayoutGetHeight(mNativePointer);
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        return GlobalMembers.YGNodeLayoutGetDidLegacyStretchFlagAffectLayout(mNativePointer);
    }

    @Override
    public float getLayoutMargin(YogaEdge edge) {
        return GlobalMembers.YGNodeLayoutGetMargin(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public float getLayoutPadding(YogaEdge edge) {
        return GlobalMembers.YGNodeLayoutGetPadding(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public float getLayoutBorder(YogaEdge edge) {
        return GlobalMembers.YGNodeLayoutGetBorder(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public YogaDirection getLayoutDirection() {
        return YogaDirection.fromInt(GlobalMembers.YGNodeLayoutGetDirection(mNativePointer).getValue());
    }

    @Override
    public boolean hasNewLayout() {
        return GlobalMembers.YGNodeGetHasNewLayout(mNativePointer);
    }

    @Override
    public void markLayoutSeen() {
        GlobalMembers.YGNodeSetHasNewLayout(mNativePointer, false);
    }
}
