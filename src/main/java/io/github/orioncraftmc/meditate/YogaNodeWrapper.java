/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.github.orioncraftmc.meditate;

import io.github.orioncraftmc.meditate.enums.*;
import io.github.orioncraftmc.meditate.interfaces.YogaBaselineFunction;
import io.github.orioncraftmc.meditate.interfaces.YogaMeasureFunction;
import io.github.orioncraftmc.meditate.internal.*;
import io.github.orioncraftmc.meditate.internal.enums.*;
import java.util.ArrayList;
import java.util.List;

public class YogaNodeWrapper extends YogaNode {

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
    
    private YogaNodeWrapper mOwner;
    
    private List<YogaNodeWrapper> mChildren;
    
    private YogaMeasureFunction mMeasureFunction;
    
    private YogaBaselineFunction mBaselineFunction;
    
    private Object mData;

    private int mLayoutDirection = 0;
    
    public boolean minWidthManuallySet;
    public boolean minHeightManuallySet;

    private YogaNodeWrapper(YGNode nativePointer) {
        mNativePointer = nativePointer;
    }

    YogaNodeWrapper() {
        this(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeNew());
    }

    YogaNodeWrapper(YogaConfig config) {
        this(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeNewWithConfig(((YogaConfigWrapper) config).mNativePointer));
    }

    private static YogaValue valueFromNative(YGValue value) {
        return new YogaValue(value.getValue(), YogaUnit.fromInt(value.getUnit().getValue()));
    }

    public void reset() {
        mMeasureFunction = null;
        mBaselineFunction = null;
        mData = null;

        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeReset(mNativePointer);
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
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeInsertChild(mNativePointer, child.mNativePointer, i);
    }

    public YogaNode setIsReferenceBaseline(boolean isReferenceBaseline) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeSetIsReferenceBaseline(mNativePointer, isReferenceBaseline);
        return this;
    }

    public boolean isReferenceBaseline() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeIsReferenceBaseline(mNativePointer);
    }

    public void swapChildAt(YogaNode newChild, int position) {
        if (!(newChild instanceof YogaNodeWrapper)) {
            return;
        }
        YogaNodeWrapper child = (YogaNodeWrapper) newChild;
        mChildren.remove(position);
        mChildren.add(position, child);
        child.mOwner = this;
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeSwapChild(mNativePointer, child.mNativePointer, position);
    }

    private YogaNodeWrapper cloneShallow() {
        YogaNodeWrapper clone = new YogaNodeWrapper();

        clone.mNativePointer = this.mNativePointer;
        clone.mOwner = this.mOwner;
        clone.mChildren = this.mChildren;
        clone.mMeasureFunction = this.mMeasureFunction;
        clone.mBaselineFunction = this.mBaselineFunction;
        clone.mData = this.mData;
        clone.mLayoutDirection = this.mLayoutDirection;

        return clone;
    }

    @Override
    public YogaNodeWrapper cloneWithChildren() {
        YogaNodeWrapper clonedYogaNode = cloneShallow();
        if (clonedYogaNode.mChildren != null) {
            clonedYogaNode.mChildren = new ArrayList<>(clonedYogaNode.mChildren);
        }
         YGNode clonedNativePointer = io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeClone(mNativePointer);
        clonedYogaNode.mOwner = null;
        clonedYogaNode.mNativePointer = clonedNativePointer;
        for (int i = 0; i < clonedYogaNode.getChildCount(); i++) {
            clonedYogaNode.swapChildAt(clonedYogaNode.getChildAt(i).cloneWithChildren(), i);
        }

        return clonedYogaNode;
    }

    @Override
    public YogaNodeWrapper cloneWithoutChildren() {
        YogaNodeWrapper clonedYogaNode = cloneShallow();
        YGNode clonedNativePointer = io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeClone(mNativePointer);
        clonedYogaNode.mOwner = null;
        clonedYogaNode.mNativePointer = clonedNativePointer;
        clonedYogaNode.clearChildren();
        return clonedYogaNode;
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
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeRemoveChild(mNativePointer, child.mNativePointer);
        return child;
    }

    /**
     * The owner is used to identify the YogaTree that a {@link YogaNode} belongs to. This method will
     * return the parent of the {@link YogaNode} when the {@link YogaNode} only belongs to one
     * YogaTree or null when the {@link YogaNode} is shared between two or more YogaTrees.
     *
     * @return the {@link YogaNode} that owns this {@link YogaNode}.
     */
    
    public YogaNodeWrapper getOwner() {
        return mOwner;
    }

    /**
     * @deprecated Use #getOwner() instead. This will be removed in the next version.
     */
    @Deprecated
    
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
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetDirection(mNativePointer), nativePointers);
    }

    private void freeze(YogaNode parent) {
        Object data = getData();
        if (data instanceof Inputs) {
            ((Inputs) data).freeze(this, parent);
        }
    }

    public void dirty() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeMarkDirty(mNativePointer);
    }

    public void dirtyAllDescendants() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeMarkDirtyAndPropogateToDescendants(mNativePointer);
    }

    public boolean isDirty() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeIsDirty(mNativePointer);
    }

    @Override
    public void copyStyle(YogaNode srcNode) {
        if (!(srcNode instanceof YogaNodeWrapper)) {
            return;
        }
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeCopyStyle(mNativePointer, ((YogaNodeWrapper) srcNode).mNativePointer);
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetDirection(mNativePointer).getValue());
    }

    public YogaNode setDirection(YogaDirection direction) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetDirection(mNativePointer, YGDirection.forValue(direction.intValue()));
        return this;
    }

    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlexDirection(mNativePointer).getValue());
    }

    public YogaNode setFlexDirection(YogaFlexDirection flexDirection) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexDirection(mNativePointer, YGFlexDirection.forValue(flexDirection.intValue()));
        return this;
    }

    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetJustifyContent(mNativePointer).getValue());
    }

    public YogaNode setJustifyContent(YogaJustify justifyContent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetJustifyContent(mNativePointer, YGJustify.forValue(justifyContent.intValue()));
        return this;
    }

    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetAlignItems(mNativePointer).getValue());
    }

    public YogaNode setAlignItems(YogaAlign alignItems) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetAlignItems(mNativePointer, YGAlign.forValue(alignItems.intValue()));
        return this;
    }

    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetAlignSelf(mNativePointer).getValue());
    }

    public YogaNode setAlignSelf(YogaAlign alignSelf) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetAlignSelf(mNativePointer, YGAlign.forValue(alignSelf.intValue()));
        return this;
    }

    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetAlignContent(mNativePointer).getValue());
    }

    public YogaNode setAlignContent(YogaAlign alignContent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetAlignContent(mNativePointer, YGAlign.forValue(alignContent.intValue()));
        return this;
    }

    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetPositionType(mNativePointer).getValue());
    }

    public YogaNode setPositionType(YogaPositionType positionType) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetPositionType(mNativePointer, YGPositionType.forValue(positionType.intValue()));
        return this;
    }

    public YogaWrap getWrap() {
        return YogaWrap.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlexWrap(mNativePointer).getValue());
    }

    public YogaNode setWrap(YogaWrap flexWrap) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexWrap(mNativePointer, YGWrap.forValue(flexWrap.intValue()));
        return this;
    }

    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetOverflow(mNativePointer).getValue());
    }

    public YogaNode setOverflow(YogaOverflow overflow) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetOverflow(mNativePointer, YGOverflow.forValue(overflow.intValue()));
        return this;
    }

    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetDisplay(mNativePointer).getValue());
    }

    public YogaNode setDisplay(YogaDisplay display) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetDisplay(mNativePointer, YGDisplay.forValue(display.intValue()));
        return this;
    }

    public float getFlex() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlex(mNativePointer);
    }

    public YogaNode setFlex(float flex) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlex(mNativePointer, flex);
        return this;
    }

    public float getFlexGrow() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlexGrow(mNativePointer);
    }

    public YogaNode setFlexGrow(float flexGrow) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexGrow(mNativePointer, flexGrow);
        return this;
    }

    public float getFlexShrink() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlexShrink(mNativePointer);
    }

    public YogaNode setFlexShrink(float flexShrink) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexShrink(mNativePointer, flexShrink);
        return this;
    }

    public YogaValue getFlexBasis() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetFlexBasis(mNativePointer));
    }

    public YogaNode setFlexBasis(float flexBasis) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexBasis(mNativePointer, flexBasis);
        return this;
    }

    public YogaNode setFlexBasisPercent(float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexBasisPercent(mNativePointer, percent);
        return this;
    }

    public YogaNode setFlexBasisAuto() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetFlexBasisAuto(mNativePointer);
        return this;
    }

    public YogaValue getMargin(YogaEdge edge) {
        return valueFromNative(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetMargin(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public YogaNode setMargin(YogaEdge edge, float margin) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMargin(mNativePointer, YGEdge.forValue(edge.intValue()), margin);
        return this;
    }

    public YogaNode setMarginPercent(YogaEdge edge, float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMarginPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
        return this;
    }

    public YogaNode setMarginAuto(YogaEdge edge) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMarginAuto(mNativePointer, YGEdge.forValue(edge.intValue()));
        return this;
    }

    public YogaValue getPadding(YogaEdge edge) {
        return valueFromNative(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetPadding(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public YogaNode setPadding(YogaEdge edge, float padding) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetPadding(mNativePointer, YGEdge.forValue(edge.intValue()), padding);
        return this;
    }

    public YogaNode setPaddingPercent(YogaEdge edge, float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetPaddingPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
        return this;
    }

    public float getBorder(YogaEdge edge) {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetBorder(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    public YogaNode setBorder(YogaEdge edge, float border) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetBorder(mNativePointer, YGEdge.forValue(edge.intValue()), border);
        return this;
    }

    public YogaValue getPosition(YogaEdge edge) {
        return valueFromNative(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetPosition(mNativePointer, YGEdge.forValue(edge.intValue())));
    }

    public YogaNode setPosition(YogaEdge edge, float position) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetPosition(mNativePointer, YGEdge.forValue(edge.intValue()), position);
        return this;
    }

    public YogaNode setPositionPercent(YogaEdge edge, float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetPositionPercent(mNativePointer, YGEdge.forValue(edge.intValue()), percent);
        return this;
    }

    public YogaValue getWidth() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetWidth(mNativePointer));
    }

    public YogaNode setWidth(float width) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetWidth(mNativePointer, width);
        return this;
    }

    public YogaNode setWidthPercent(float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetWidthPercent(mNativePointer, percent);
        return this;
    }

    public YogaNode setWidthAuto() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetWidthAuto(mNativePointer);
        return this;
    }

    public YogaValue getHeight() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetHeight(mNativePointer));
    }

    public YogaNode setHeight(float height) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetHeight(mNativePointer, height);
        return this;
    }

    public YogaNode setHeightPercent(float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetHeightPercent(mNativePointer, percent);
        return this;
    }

    public YogaNode setHeightAuto() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetHeightAuto(mNativePointer);
        return this;
    }

    public YogaValue getMinWidth() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetMinWidth(mNativePointer));
    }

    public YogaNode setMinWidth(float minWidth) {
        minWidthManuallySet = true;
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMinWidth(mNativePointer, minWidth);
        return this;
    }

    public YogaNode setMinWidthPercent(float percent) {
        minWidthManuallySet = true;
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMinWidthPercent(mNativePointer, percent);
        return this;
    }

    public YogaValue getMinHeight() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetMinHeight(mNativePointer));
    }

    public YogaNode setMinHeight(float minHeight) {
        minHeightManuallySet = true;
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMinHeight(mNativePointer, minHeight);
        return this;
    }

    public YogaNode setMinHeightPercent(float percent) {
        minHeightManuallySet = true;
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMinHeightPercent(mNativePointer, percent);
        return this;
    }

    public YogaValue getMaxWidth() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetMaxWidth(mNativePointer));
    }

    public YogaNode setMaxWidth(float maxWidth) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMaxWidth(mNativePointer, maxWidth);
        return this;
    }

    public YogaNode setMaxWidthPercent(float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMaxWidthPercent(mNativePointer, percent);
        return this;
    }

    public YogaValue getMaxHeight() {
        return valueFromNative(io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetMaxHeight(mNativePointer));
    }

    public YogaNode setMaxHeight(float maxheight) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMaxHeight(mNativePointer, maxheight);
        return this;
    }

    public YogaNode setMaxHeightPercent(float percent) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetMaxHeightPercent(mNativePointer, percent);
        return this;
    }
    
    public YogaNode setSize(float size) {
        setWidth(size);
        setHeight(size);
        return this;
    }
    
    public YogaNode setSizePercent(float percent) {
        setWidthPercent(percent);
        setHeightPercent(percent);
        return this;
    }
    
    public YogaNode setMinSize(float minSize) {
        setMinWidth(minSize);
        setMinHeight(minSize);
        return this;
    }
    
    public YogaNode setMinSizePercent(float minSizePercent) {
        setMinWidthPercent(minSizePercent);
        setMinHeightPercent(minSizePercent);
        return this;
    }
    
    public YogaNode setMaxSize(float maxSize) {
        setMaxWidth(maxSize);
        setMaxHeight(maxSize);
        return this;
    }
    
    public YogaNode setMaxSizePercent(float maxSizePercent) {
        setMaxWidthPercent(maxSizePercent);
        setMaxHeightPercent(maxSizePercent);
        return this;
    }
    
    public YogaNode setSizeAuto() {
        setWidthAuto();
        setHeightAuto();
        return this;
    }

    public float getAspectRatio() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleGetAspectRatio(mNativePointer);
    }

    public YogaNode setAspectRatio(float aspectRatio) {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeStyleSetAspectRatio(mNativePointer, aspectRatio);
        return this;
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

    public YogaNode setBaselineFunction(YogaBaselineFunction baselineFunction) {
        mBaselineFunction = baselineFunction;
        mNativePointer.setBaselineFunc((node, width, height) -> this.baseline(width, height));
        return this;
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
    public  Object getData() {
        return mData;
    }

    public YogaNode setData(Object data) {
        mData = data;
        return this;
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
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetLeft(mNativePointer);
    }

    @Override
    public float getLayoutY() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetTop(mNativePointer);
    }

    @Override
    public float getLayoutWidth() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetWidth(mNativePointer);
    }

    @Override
    public float getLayoutHeight() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetHeight(mNativePointer);
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetDidLegacyStretchFlagAffectLayout(mNativePointer);
    }

    @Override
    public float getLayoutMargin(YogaEdge edge) {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetMargin(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public float getLayoutPadding(YogaEdge edge) {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetPadding(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public float getLayoutBorder(YogaEdge edge) {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetBorder(mNativePointer, YGEdge.forValue(edge.intValue()));
    }

    @Override
    public YogaDirection getLayoutDirection() {
        return YogaDirection.fromInt(
                io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeLayoutGetDirection(mNativePointer).getValue());
    }

    @Override
    public boolean hasNewLayout() {
        return io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeGetHasNewLayout(mNativePointer);
    }

    @Override
    public void markLayoutSeen() {
        io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeSetHasNewLayout(mNativePointer, false);
    }
}
