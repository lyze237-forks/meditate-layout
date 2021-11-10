package facebook.yoga;

import facebook.GlobalMembers;
import static facebook.GlobalMembers.*;
import static facebook.GlobalMembers.YGAssertWithNode;
import static facebook.GlobalMembers.YGFlexDirectionIsRow;
import static facebook.GlobalMembers.YGResolveValue;
import static facebook.GlobalMembers.YGResolveValueMargin;
import static facebook.GlobalMembers.YGValueUndefined;
import static facebook.GlobalMembers.plus;
import facebook.yoga.detail.CompactValue;
import static facebook.yoga.detail.GlobalMembers.getBooleanData;
import static facebook.yoga.detail.GlobalMembers.setBooleanData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class YGNode {

    private static final int hasNewLayout_ = 0;
    private static final int isReferenceBaseline_ = 1;
    private static final int isDirty_ = 2;
    private static final int nodeType_ = 3;
    private static final int measureUsesContext_ = 4;
    private static final int baselineUsesContext_ = 5;
    private static final int printUsesContext_ = 6;
    private static final int useWebDefaults_ = 7;

    private Object context_ = null;
    private byte flags = 1;
    private byte reserved_ = 0;
    private measure_Struct measure_ = null;
    private baseline_Struct baseline_ = null;
    private print_Struct print_ = null;
    private YGDirtiedFunc dirtied_ = null;
    private YGStyle style_ = new YGStyle();
    private YGLayout layout_ = new YGLayout();
    private int lineIndex_ = 0;
    private YGNode owner_ = null;
    private ArrayList<YGNode> children_ = new ArrayList<>();
    private YGConfig config_ = new YGConfig(null);
    private ArrayList<YGValue> resolvedDimensions_ = new ArrayList<YGValue>(
            Arrays.asList(YGValueUndefined, YGValueUndefined));
    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGNode(YGNode node) {
        context_ = node.context_;
        flags = node.flags;
        measure_ = node.measure_;
        baseline_ = node.baseline_;
        print_ = node.print_;
        dirtied_ = node.dirtied_;
        style_ = node.style_;
        layout_ = node.layout_;
        lineIndex_ = node.lineIndex_;
        owner_ = node.owner_;
        children_ = node.children_; //TODO: Make full copy
        config_ = node.config_;
        resolvedDimensions_ = node.resolvedDimensions_;
        for (var c : children_) {
            c.setOwner(this);
        }
    }
    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGNode(final YGNode node, YGConfig config) {
        this.YGNode = node;
        config_ = config;
        if (config.useWebDefaults) {
            useWebDefaults();
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void print(Object printContext) {
        if (print_.noContext != null) {
            if (getBooleanData(flags, printUsesContext_)) {
                print_.withContext.invoke(this, printContext);
            } else {
                print_.noContext.invoke(this);
            }
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public CompactValue computeEdgeValueForRow(final YGStyle.Edges edges, YGEdge rowEdge, YGEdge edge, CompactValue defaultValue) {

        if (!edges[(int) rowEdge].isUndefined()) {
            return edges[(int) rowEdge];
        } else if (!edges[(int) edge].isUndefined()) {
            return edges[(int) edge];
        } else if (!edges[(int) YGEdge.YGEdgeHorizontal].isUndefined()) {
            return edges[(int) YGEdge.YGEdgeHorizontal];
        } else if (!edges[(int) YGEdge.YGEdgeAll].isUndefined()) {
            return edges[(int) YGEdge.YGEdgeAll];
        } else {
            return CompactValue.createCompactValue(defaultValue);
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public CompactValue computeEdgeValueForColumn(final YGStyle.Edges edges, YGEdge edge, CompactValue defaultValue) {
        if (!edges[(int) edge].isUndefined()) {
            return edges[(int) edge];
        } else if (!edges[(int) YGEdge.YGEdgeVertical].isUndefined()) {
            return edges[(int) YGEdge.YGEdgeVertical];
        } else if (!edges[(int) YGEdge.YGEdgeAll].isUndefined()) {
            return edges[(int) YGEdge.YGEdgeAll];
        } else {
            return CompactValue.createCompactValue(defaultValue);
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getLeadingPosition(final YGFlexDirection axis, final float axisSize) {
        var leadingPosition = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.position(), YGEdge.YGEdgeStart,
                leading[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.position(),
                leading[(int) axis], CompactValue.ofZero());
        return YGResolveValue(leadingPosition, axisSize);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getTrailingPosition(final YGFlexDirection axis, final float axisSize) {
        var trailingPosition = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.position(), YGEdge.YGEdgeEnd,
                trailing[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.position(),
                trailing[(int) axis], CompactValue.ofZero());
        return YGResolveValue(trailingPosition, axisSize);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean isLeadingPositionDefined(final YGFlexDirection axis) {
        var leadingPosition = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.position(), YGEdge.YGEdgeStart,
                leading[(int) axis], CompactValue.ofUndefined()) : computeEdgeValueForColumn(style_.position(),
                leading[(int) axis], CompactValue.ofUndefined());
        return !leadingPosition.isUndefined();
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean isTrailingPosDefined(final YGFlexDirection axis) {
        var trailingPosition = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.position(), YGEdge.YGEdgeEnd,
                trailing[(int) axis], CompactValue.ofUndefined()) : computeEdgeValueForColumn(style_.position(),
                trailing[(int) axis], CompactValue.ofUndefined());
        return !trailingPosition.isUndefined();
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getLeadingMargin(final YGFlexDirection axis, final float widthSize) {
        var leadingMargin = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.margin(), YGEdge.YGEdgeStart,
                leading[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.margin(),
                leading[(int) axis], CompactValue.ofZero());
        return YGResolveValueMargin(leadingMargin, widthSize);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getTrailingMargin(final YGFlexDirection axis, final float widthSize) {
        var trailingMargin = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.margin(), YGEdge.YGEdgeEnd,
                trailing[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.margin(),
                trailing[(int) axis], CompactValue.ofZero());
        return YGResolveValueMargin(trailingMargin, widthSize);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getMarginForAxis(final YGFlexDirection axis, final float widthSize) {
        return plus(getLeadingMargin(axis, widthSize), getTrailingMargin(axis, widthSize));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGSize measure(float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode, Object layoutContext) {
        return getBooleanData(flags, measureUsesContext_) ? measure_.withContext.invoke(this, width, widthMode, height,
                heightMode, layoutContext) : measure_.noContext.invoke(this, width, widthMode, height, heightMode);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public float baseline(float width, float height, Object layoutContext) {
        return getBooleanData(flags, baselineUsesContext_) ? baseline_.withContext.invoke(this, width, height,
                layoutContext) : baseline_.noContext.invoke(this, width, height);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setMeasureFunc(measure_Struct measureFunc) {
        if (measureFunc.noContext == null) {
            setNodeType(YGNodeType.YGNodeTypeDefault);
        } else {
            YGAssertWithNode(this, children_.size() == 0,
                    "Cannot set measure function: Nodes with measure functions cannot have " + "children.");
            setNodeType(YGNodeType.YGNodeTypeText);
        }

        measure_ = measureFunc;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setMeasureFunc(YGMeasureFunc measureFunc) {
        flags = setBooleanData(flags, measureUsesContext_, false);
        //C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'decltype':
        measure_.noContext = measureFunc;
        setMeasureFunc(measure_);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setMeasureFunc(MeasureWithContextFn measureFunc) {
        flags = setBooleanData(flags, measureUsesContext_, true);
        //C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'decltype':
        measure_.withContext = measureFunc;
        setMeasureFunc(measure_);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void replaceChild(YGNode child, Integer index) {
        children_.set(index, child);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void replaceChild(YGNode oldChild, YGNode newChild) {
        std::replace (children_.begin(), children_.end(), oldChild, newChild);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void insertChild(YGNode child, Integer index) {
        children_.insert(children_.begin() + index, child);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setDirty(boolean isDirty) {
        if (isDirty == getBooleanData(flags, isDirty_)) {
            return;
        }
        flags = setBooleanData(flags, isDirty_, isDirty);
        if (isDirty && dirtied_ != null) {
            dirtied_.invoke(this);
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean removeChild(YGNode child) {
        Iterator<YGNode> p = std::find (children_.begin(), children_.end(), child);
        //C++ TO JAVA CONVERTER TODO TASK: Iterators are only converted within the context of 'while' and 'for' loops:
        if (p != children_.end()) {
            children_.erase(p);
            return true;
        }
        return false;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void removeChild(Integer index) {
        children_.erase(children_.begin() + index);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutDirection(YGDirection direction) {
        layout_.setDirection(direction);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutMargin(float margin, int index) {
        layout_.margin.set(index, margin);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutBorder(float border, int index) {
        layout_.border.set(index, border);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutPadding(float padding, int index) {
        layout_.padding.set(index, padding);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutLastOwnerDirection(YGDirection direction) {
        layout_.lastOwnerDirection = direction;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutComputedFlexBasis(final YGFloatOptional computedFlexBasis) {
        layout_.computedFlexBasis = computedFlexBasis;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutPosition(float position, int index) {
        layout_.position.set(index, position);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutComputedFlexBasisGeneration(Integer computedFlexBasisGeneration) {
        layout_.computedFlexBasisGeneration = computedFlexBasisGeneration;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutMeasuredDimension(float measuredDimension, int index) {
        layout_.measuredDimensions.set(index, measuredDimension);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutHadOverflow(boolean hadOverflow) {
        layout_.setHadOverflow(hadOverflow);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutDimension(float dimension, int index) {
        layout_.dimensions.set(index, dimension);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional relativePosition(final YGFlexDirection axis, final float axisSize) {
        if (isLeadingPositionDefined(axis)) {
            return getLeadingPosition(axis, axisSize);
        }

        YGFloatOptional trailingPosition = getTrailingPosition(axis, axisSize);
        if (!trailingPosition.isUndefined()) {
            trailingPosition = YGFloatOptional((-1 * trailingPosition.unwrap()));
        }
        return new YGFloatOptional(trailingPosition);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setPosition(final YGDirection direction, final float mainSize, final float crossSize, final float ownerWidth) {


        final YGDirection directionRespectingRoot = owner_ != null ? direction : YGDirection.YGDirectionLTR;
        final YGFlexDirection mainAxis = YGResolveFlexDirection(style_.flexDirection(), directionRespectingRoot);
        final YGFlexDirection crossAxis = YGFlexDirectionCross(mainAxis, directionRespectingRoot);


        final YGFloatOptional relativePositionMain = relativePosition(mainAxis, mainSize);
        final YGFloatOptional relativePositionCross = relativePosition(crossAxis, crossSize);

        setLayoutPosition((getLeadingMargin(mainAxis, ownerWidth) + relativePositionMain).unwrap(),
                leading[(int) mainAxis]);
        setLayoutPosition((getTrailingMargin(mainAxis, ownerWidth) + relativePositionMain).unwrap(),
                trailing[(int) mainAxis]);
        setLayoutPosition((getLeadingMargin(crossAxis, ownerWidth) + relativePositionCross).unwrap(),
                leading[(int) crossAxis]);
        setLayoutPosition((getTrailingMargin(crossAxis, ownerWidth) + relativePositionCross).unwrap(),
                trailing[(int) crossAxis]);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGValue marginLeadingValue(final YGFlexDirection axis) {
        if (YGFlexDirectionIsRow(axis) && !style_.margin()[(int) YGEdge.YGEdgeStart].isUndefined()) {
            return style_.margin()[(int) YGEdge.YGEdgeStart];
        } else {
            return style_.margin()[leading[(int) axis]];
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGValue marginTrailingValue(final YGFlexDirection axis) {
        if (YGFlexDirectionIsRow(axis) && !style_.margin()[(int) YGEdge.YGEdgeEnd].isUndefined()) {
            return style_.margin()[(int) YGEdge.YGEdgeEnd];
        } else {
            return style_.margin()[trailing[(int) axis]];
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGValue resolveFlexBasisPtr() {
        YGValue flexBasis = style_.flexBasis();
        if (flexBasis.unit != YGUnit.YGUnitAuto && flexBasis.unit != YGUnit.YGUnitUndefined) {
            //C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
            //ORIGINAL LINE: return flexBasis;
            return new YGValue(flexBasis);
        }
        if (!style_.flex().isUndefined() && style_.flex().unwrap() > 0.0f) {
            return getBooleanData(flags, useWebDefaults_) ? YGValueAuto : YGValueZero;
        }
        return YGValueAuto;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void resolveDimension() {
        final YGStyle style = getStyle();
        for (var dim : {YGDimension.YGDimensionWidth, YGDimension.YGDimensionHeight}) {
            if (!style.maxDimensions()[dim].isUndefined() && YGValueEqual(style.maxDimensions[dim],
                    style.minDimensions[dim])) {
                resolvedDimensions_[dim] = style.maxDimensions()[dim];
            } else {
                resolvedDimensions_[dim] = style.dimensions()[dim];
            }
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGDirection resolveDirection(final YGDirection ownerDirection) {
        if (style_.direction() == YGDirection.YGDirectionInherit) {
            return ownerDirection.getValue() > YGDirection.YGDirectionInherit.getValue() ? ownerDirection : YGDirection.YGDirectionLTR;
        } else {
            return style_.direction();
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void clearChildren() {
        children_.clear();
        children_.shrink_to_fit();
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void cloneChildrenIfNeeded(Object cloneContext) {
        iterChildrenAfterCloningIfNeeded((YGNode UnnamedParameter, Object UnnamedParameter2) ->
        {
        }, cloneContext);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void markDirtyAndPropogate() {
        if (!getBooleanData(flags, isDirty_)) {
            setDirty(true);
            setLayoutComputedFlexBasis(YGFloatOptional());
            if (owner_) {
                owner_.markDirtyAndPropogate();
            }
        }
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void markDirtyAndPropogateDownwards() {
        flags = setBooleanData(flags, isDirty_, true);
        for_each(children_.begin(), children_.end(), (YGNode childNode) ->
        {
            childNode.markDirtyAndPropogateDownwards();
        });
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public float resolveFlexGrow() {

        if (owner_ == null) {
            return 0.0F;
        }
        if (!style_.flexGrow().isUndefined()) {
            return style_.flexGrow().unwrap();
        }
        if (!style_.flex().isUndefined() && style_.flex().unwrap() > 0.0f) {
            return style_.flex().unwrap();
        }
        return kDefaultFlexGrow;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public float resolveFlexShrink() {
        if (owner_ == null) {
            return 0.0F;
        }
        if (!style_.flexShrink().isUndefined()) {
            return style_.flexShrink().unwrap();
        }
        if (!getBooleanData(flags, useWebDefaults_) && !style_.flex().isUndefined() && style_.flex().unwrap() < 0.0f) {
            return -style_.flex().unwrap();
        }
        return getBooleanData(flags, useWebDefaults_) ? kWebDefaultFlexShrink : kDefaultFlexShrink;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean isNodeFlexible() {
        return ((style_.positionType() != YGPositionType.YGPositionTypeAbsolute) && (resolveFlexGrow() != 0 || resolveFlexShrink() != 0));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public float getLeadingBorder(final YGFlexDirection axis) {
        YGValue leadingBorder = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.border(), YGEdge.YGEdgeStart,
                leading[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.border(),
                leading[(int) axis], CompactValue.ofZero());
        return fmaxf(leadingBorder.value, 0.0f);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public float getTrailingBorder(final YGFlexDirection axis) {
        YGValue trailingBorder = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.border(), YGEdge.YGEdgeEnd,
                trailing[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.border(),
                trailing[(int) axis], CompactValue.ofZero());
        return fmaxf(trailingBorder.value, 0.0f);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getLeadingPadding(final YGFlexDirection axis, final float widthSize) {
        var leadingPadding = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.padding(), YGEdge.YGEdgeStart,
                leading[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.padding(),
                leading[(int) axis], CompactValue.ofZero());
        return new YGFloatOptional(
                YGFloatOptionalMax(YGResolveValue(new auto(leadingPadding), widthSize), YGFloatOptional(0.0f)));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getTrailingPadding(final YGFlexDirection axis, final float widthSize) {
        var trailingPadding = YGFlexDirectionIsRow(axis) ? computeEdgeValueForRow(style_.padding(), YGEdge.YGEdgeEnd,
                trailing[(int) axis], CompactValue.ofZero()) : computeEdgeValueForColumn(style_.padding(),
                trailing[(int) axis], CompactValue.ofZero());
        return new YGFloatOptional(
                YGFloatOptionalMax(YGResolveValue(new auto(trailingPadding), widthSize), YGFloatOptional(0.0f)));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getLeadingPaddingAndBorder(final YGFlexDirection axis, final float widthSize) {
        return getLeadingPadding(axis, widthSize) + YGFloatOptional(getLeadingBorder(axis));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public YGFloatOptional getTrailingPaddingAndBorder(final YGFlexDirection axis, final float widthSize) {
        return getTrailingPadding(axis, widthSize) + YGFloatOptional(getTrailingBorder(axis));
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean didUseLegacyFlag() {
        boolean didUseLegacyFlag = layout_.didUseLegacyFlag();
        if (didUseLegacyFlag) {
            return true;
        }
        for (var child : children_) {
            if (child.layout_.didUseLegacyFlag()) {
                didUseLegacyFlag = true;
                break;
            }
        }
        return didUseLegacyFlag;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutDoesLegacyFlagAffectsLayout(boolean doesLegacyFlagAffectsLayout) {
        layout_.setDoesLegacyStretchFlagAffectsLayout(doesLegacyFlagAffectsLayout);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void setLayoutDidUseLegacyFlag(boolean didUseLegacyFlag) {
        layout_.setDidUseLegacyFlag(didUseLegacyFlag);
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public boolean isLayoutTreeEqualToNode(final YGNode node) {
        if (children_.size() != node.children_.size()) {
            return false;
        }
        if (layout_ != node.layout_) {
            return false;
        }
        if (children_.size() == 0) {
            return true;
        }

        boolean isLayoutTreeEqual = true;
        YGNode otherNodeChildren = null;
        for (ArrayList<struct YGNode>.Integerype i = 0;
        i<children_.size (); ++i)
        {
            otherNodeChildren = node.children_[i];
            isLayoutTreeEqual = children_[i].isLayoutTreeEqualToNode(otherNodeChildren);
            if (!isLayoutTreeEqual) {
                return false;
            }
        }
        return isLayoutTreeEqual;
    }

    //C++ TO JAVA CONVERTER WARNING: The original C++ declaration of the following method implementation was not found:
    public void reset() {
        YGAssertWithNode(this, children_.size() == 0, "Cannot reset a node which still has children attached");
        YGAssertWithNode(this, owner_ == null, "Cannot reset a node still attached to a owner");

        clearChildren();

        var webDefaults = getBooleanData(flags, useWebDefaults_);
        this = YGNode((getConfig()));
        if (webDefaults != null) {
            useWebDefaults();
        }
    }

    private static class measure_Struct {

        public YGMeasureFunc noContext = null;
        public MeasureWithContextFn withContext;

    }

    private static class baseline_Struct {

        public YGBaselineFunc noContext = null;
        public BaselineWithContextFn withContext;

    }

    private static class print_Struct {

        public YGPrintFunc noContext = null;
        public PrintWithContextFn withContext;

    }

    public Object getContext() {
        return context_;
    }

    public void setContext(Object context_) {
        this.context_ = context_;
    }

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public byte getReserved() {
        return reserved_;
    }

    public void setReserved(byte reserved_) {
        this.reserved_ = reserved_;
    }

    public measure_Struct getMeasure() {
        return measure_;
    }

    public void setMeasure(measure_Struct measure_) {
        this.measure_ = measure_;
    }

    public baseline_Struct getBaseline() {
        return baseline_;
    }

    public void setBaseline(baseline_Struct baseline_) {
        this.baseline_ = baseline_;
    }

    public print_Struct getPrint() {
        return print_;
    }

    public void setPrint(print_Struct print_) {
        this.print_ = print_;
    }

    public YGDirtiedFunc getDirtied() {
        return dirtied_;
    }

    public void setDirtied(YGDirtiedFunc dirtied_) {
        this.dirtied_ = dirtied_;
    }

    public YGStyle getStyle() {
        return style_;
    }

    public void setStyle(YGStyle style_) {
        this.style_ = style_;
    }

    public YGLayout getLayout() {
        return layout_;
    }

    public void setLayout(YGLayout layout_) {
        this.layout_ = layout_;
    }

    public int getLineIndex() {
        return lineIndex_;
    }

    public void setLineIndex(int lineIndex_) {
        this.lineIndex_ = lineIndex_;
    }

    public YGNode getOwner() {
        return owner_;
    }

    public void setOwner(YGNode owner_) {
        this.owner_ = owner_;
    }

    public ArrayList<YGNode> getChildren() {
        return children_;
    }

    public void setChildren(ArrayList<YGNode> children_) {
        this.children_ = children_;
    }

    public YGConfig getConfig() {
        return config_;
    }

    public void setConfig(YGConfig config_) {
        this.config_ = config_;
    }

    public ArrayList<YGValue> getResolvedDimensions() {
        return resolvedDimensions_;
    }

    public void setResolvedDimensions(ArrayList<YGValue> resolvedDimensions_) {
        this.resolvedDimensions_ = resolvedDimensions_;
    }
}
