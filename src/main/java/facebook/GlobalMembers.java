package facebook;

import facebook.yoga.YGAlign;
import facebook.yoga.YGConfig;
import facebook.yoga.YGDimension;
import facebook.yoga.YGDirection;
import facebook.yoga.YGDisplay;
import facebook.yoga.YGEdge;
import facebook.yoga.YGExperimentalFeature;
import facebook.yoga.YGFlexDirection;
import facebook.yoga.YGFloatOptional;
import facebook.yoga.YGJustify;
import facebook.yoga.YGLogLevel;
import facebook.yoga.YGMeasureMode;
import facebook.yoga.YGNode;
import facebook.yoga.YGNodeType;
import facebook.yoga.YGOverflow;
import facebook.yoga.YGPositionType;
import facebook.yoga.YGPrintOptions;
import facebook.yoga.YGUnit;
import facebook.yoga.YGValue;
import facebook.yoga.YGWrap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static facebook.yoga.GlobalMembers.isUndefined;

public class GlobalMembers
{
	public static boolean YGValueEqual(final YGValue a, final YGValue b) //Method definition originates from: Utils.cpp
	{
	  if (a.unit != b.unit)
	  {
		return false;
	  }

	  if (a.unit == YGUnit.YGUnitUndefined || (isUndefined(a.value) && isUndefined(b.value)))
	  {
		return true;
	  }

	  return Math.abs(a.value - b.value) < 0.0001f;
	}

	public static boolean YGValueEqual(facebook.yoga.detail.CompactValue a, facebook.yoga.detail.CompactValue b)
	{
	  return YGValueEqual((YGValue) a, (YGValue) b);
	}



	public static boolean YGFloatsEqual(final float a, final float b) //Method definition originates from: Utils.cpp
	{
	  if (!isUndefined(a) && !isUndefined(b))
	  {
		return Math.abs(a - b) < 0.0001f;
	  }
	  return isUndefined(a) && isUndefined(b);
	}

	public static boolean YGDoubleEqual(final double a, final double b) //Method definition originates from: Utils.cpp
	{
	  if (!isUndefined(a) && !isUndefined(b))
	  {
		return Math.abs(a - b) < 0.0001;
	  }
	  return isUndefined(a) && isUndefined(b);
	}

	public static float YGFloatMax(final float a, final float b) //Method definition originates from: Utils.cpp
	{
	  if (!isUndefined(a) && !isUndefined(b))
	  {
		return fmaxf(a, b);
	  }
	  return isUndefined(a) ? b : a;
	}

	public static YGFloatOptional YGFloatOptionalMax(YGFloatOptional op1, YGFloatOptional op2) //Method definition originates from: Utils.cpp
	{
	  if (op1 >= op2)
	  {
		return new YGFloatOptional(op1);
	  }
	  if (op2 > op1)
	  {
		return new YGFloatOptional(op2);
	  }
	  return op1.isUndefined() ? op2 : op1;
	}

	public static float YGFloatMin(final float a, final float b) //Method definition originates from: Utils.cpp
	{
	  if (!isUndefined(a) && !isUndefined(b))
	  {
		return fminf(a, b);
	  }

	  return isUndefined(a) ? b : a;
	}




	//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
	//ORIGINAL LINE: template <std::size_t size>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename size> requires int<size>
	public static <size> boolean YGFloatArrayEqual(final ArrayList<Float> val1, final ArrayList<Float> val2)
	{
	  boolean areEqual = true;
	  for (int i = 0; i < size && areEqual; ++i)
	  {
		areEqual = YGFloatsEqual(val1.get(i), val2.get(i));
	  }
	  return areEqual;
	}


	public static float YGFloatSanitize(final float val) //Method definition originates from: Utils.cpp
	{
	  return isUndefined(val) ? 0F : val;
	}

	public static YGFlexDirection YGFlexDirectionCross(final YGFlexDirection flexDirection, final YGDirection direction) //Method definition originates from: Utils.cpp
	{
	  return YGFlexDirectionIsColumn(flexDirection) ? YGResolveFlexDirection(YGFlexDirection.YGFlexDirectionRow, direction) : YGFlexDirection.YGFlexDirectionColumn;
	}

	public static boolean YGFlexDirectionIsRow(final YGFlexDirection flexDirection)
	{
	  return flexDirection == YGFlexDirection.YGFlexDirectionRow || flexDirection == YGFlexDirection.YGFlexDirectionRowReverse;
	}

	public static YGFloatOptional YGResolveValue(final YGValue value, final float ownerSize)
	{
	  switch (value.unit)
	  {
		case YGUnitPoint:
		  return YGFloatOptional(value.value);
		case YGUnitPercent:
		  return YGFloatOptional(value.value * ownerSize * 0.01f);
		default:
		  return YGFloatOptional();
	  }
	}

	public static YGFloatOptional YGResolveValue(yoga.detail.CompactValue value, float ownerSize)
	{
	  return new YGFloatOptional(YGResolveValue((YGValue) value, ownerSize));
	}

	public static boolean YGFlexDirectionIsColumn(final YGFlexDirection flexDirection)
	{
	  return flexDirection == YGFlexDirection.YGFlexDirectionColumn || flexDirection == YGFlexDirection.YGFlexDirectionColumnReverse;
	}

	public static YGFlexDirection YGResolveFlexDirection(final YGFlexDirection flexDirection, final YGDirection direction)
	{
	  if (direction == YGDirection.YGDirectionRTL)
	  {
		if (flexDirection == YGFlexDirection.YGFlexDirectionRow)
		{
		  return YGFlexDirection.YGFlexDirectionRowReverse;
		}
		else if (flexDirection == YGFlexDirection.YGFlexDirectionRowReverse)
		{
		  return YGFlexDirection.YGFlexDirectionRow;
		}
	  }

	  return flexDirection;
	}

	public static YGFloatOptional YGResolveValueMargin(yoga.detail.CompactValue value, final float ownerSize)
	{
	  return value.isAuto() ? YGFloatOptional(0) : YGResolveValue(new yoga.detail.CompactValue(value), ownerSize);
	}

	public static void throwLogicalErrorWithMessage(String message) //Method definition originates from: Utils.cpp
	{
	  throw std::logic_error(message);
	}

	public static String YGAlignToString(final YGAlign value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGAlignAuto:
		  return "auto";
		case YGAlignFlexStart:
		  return "flex-start";
		case YGAlignCenter:
		  return "center";
		case YGAlignFlexEnd:
		  return "flex-end";
		case YGAlignStretch:
		  return "stretch";
		case YGAlignBaseline:
		  return "baseline";
		case YGAlignSpaceBetween:
		  return "space-between";
		case YGAlignSpaceAround:
		  return "space-around";
	  }
	  return "unknown";
	}

//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
	//					   ;
	public static String YGDimensionToString(final YGDimension value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDimensionWidth:
		  return "width";
		case YGDimensionHeight:
		  return "height";
	  }
	  return "unknown";
	}
	public static String YGDirectionToString(final YGDirection value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDirectionInherit:
		  return "inherit";
		case YGDirectionLTR:
		  return "ltr";
		case YGDirectionRTL:
		  return "rtl";
	  }
	  return "unknown";
	}
	public static String YGDisplayToString(final YGDisplay value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGDisplayFlex:
		  return "flex";
		case YGDisplayNone:
		  return "none";
	  }
	  return "unknown";
	}
	public static String YGEdgeToString(final YGEdge value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGEdgeLeft:
		  return "left";
		case YGEdgeTop:
		  return "top";
		case YGEdgeRight:
		  return "right";
		case YGEdgeBottom:
		  return "bottom";
		case YGEdgeStart:
		  return "start";
		case YGEdgeEnd:
		  return "end";
		case YGEdgeHorizontal:
		  return "horizontal";
		case YGEdgeVertical:
		  return "vertical";
		case YGEdgeAll:
		  return "all";
	  }
	  return "unknown";
	}
	public static String YGExperimentalFeatureToString(final YGExperimentalFeature value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGExperimentalFeatureWebFlexBasis:
		  return "web-flex-basis";
	  }
	  return "unknown";
	}
	public static String YGFlexDirectionToString(final YGFlexDirection value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGFlexDirectionColumn:
		  return "column";
		case YGFlexDirectionColumnReverse:
		  return "column-reverse";
		case YGFlexDirectionRow:
		  return "row";
		case YGFlexDirectionRowReverse:
		  return "row-reverse";
	  }
	  return "unknown";
	}
	public static String YGJustifyToString(final YGJustify value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGJustifyFlexStart:
		  return "flex-start";
		case YGJustifyCenter:
		  return "center";
		case YGJustifyFlexEnd:
		  return "flex-end";
		case YGJustifySpaceBetween:
		  return "space-between";
		case YGJustifySpaceAround:
		  return "space-around";
		case YGJustifySpaceEvenly:
		  return "space-evenly";
	  }
	  return "unknown";
	}
	public static String YGLogLevelToString(final YGLogLevel value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGLogLevelError:
		  return "error";
		case YGLogLevelWarn:
		  return "warn";
		case YGLogLevelInfo:
		  return "info";
		case YGLogLevelDebug:
		  return "debug";
		case YGLogLevelVerbose:
		  return "verbose";
		case YGLogLevelFatal:
		  return "fatal";
	  }
	  return "unknown";
	}
	public static String YGMeasureModeToString(final YGMeasureMode value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGMeasureModeUndefined:
		  return "undefined";
		case YGMeasureModeExactly:
		  return "exactly";
		case YGMeasureModeAtMost:
		  return "at-most";
	  }
	  return "unknown";
	}
	public static String YGNodeTypeToString(final YGNodeType value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGNodeTypeDefault:
		  return "default";
		case YGNodeTypeText:
		  return "text";
	  }
	  return "unknown";
	}
	public static String YGOverflowToString(final YGOverflow value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGOverflowVisible:
		  return "visible";
		case YGOverflowHidden:
		  return "hidden";
		case YGOverflowScroll:
		  return "scroll";
	  }
	  return "unknown";
	}
	public static String YGPositionTypeToString(final YGPositionType value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGPositionTypeStatic:
		  return "static";
		case YGPositionTypeRelative:
		  return "relative";
		case YGPositionTypeAbsolute:
		  return "absolute";
	  }
	  return "unknown";
	}
	public static String YGPrintOptionsToString(final YGPrintOptions value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGPrintOptionsLayout:
		  return "layout";
		case YGPrintOptionsStyle:
		  return "style";
		case YGPrintOptionsChildren:
		  return "children";
	  }
	  return "unknown";
	}
	public static String YGUnitToString(final YGUnit value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGUnitUndefined:
		  return "undefined";
		case YGUnitPoint:
		  return "point";
		case YGUnitPercent:
		  return "percent";
		case YGUnitAuto:
		  return "auto";
	  }
	  return "unknown";
	}
	public static String YGWrapToString(final YGWrap value) //Method definition originates from: YGEnums.cpp
	{
	  switch (value)
	  {
		case YGWrapNoWrap:
		  return "no-wrap";
		case YGWrapWrap:
		  return "wrap";
		case YGWrapWrapReverse:
		  return "wrap-reverse";
	  }
	  return "unknown";
	}




































	private boolean equalsTo(final YGStyle lhs, final YGStyle rhs)
	{
	  boolean areNonFloatValuesEqual = lhs.direction() == rhs.direction() && lhs.flexDirection() == rhs.flexDirection() && lhs.justifyContent() == rhs.justifyContent() && lhs.alignContent() == rhs.alignContent() && lhs.alignItems() == rhs.alignItems() && lhs.alignSelf() == rhs.alignSelf() && lhs.positionType() == rhs.positionType() && lhs.flexWrap() == rhs.flexWrap() && lhs.overflow() == rhs.overflow() && lhs.display() == rhs.display() && YGValueEqual(lhs.flexBasis(), rhs.flexBasis()) && lhs.margin() == rhs.margin() && lhs.position() == rhs.position() && lhs.padding() == rhs.padding() && lhs.border() == rhs.border() && lhs.dimensions() == rhs.dimensions() && lhs.minDimensions() == rhs.minDimensions() && lhs.maxDimensions() == rhs.maxDimensions();

	  areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flex().isUndefined() == rhs.flex().isUndefined();
	  if (areNonFloatValuesEqual && !lhs.flex().isUndefined() && !rhs.flex().isUndefined())
	  {
		areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flex() == rhs.flex();
	  }

	  areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flexGrow().isUndefined() == rhs.flexGrow().isUndefined();
	  if (areNonFloatValuesEqual && !lhs.flexGrow().isUndefined())
	  {
		areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flexGrow() == rhs.flexGrow();
	  }

	  areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flexShrink().isUndefined() == rhs.flexShrink().isUndefined();
	  if (areNonFloatValuesEqual && !rhs.flexShrink().isUndefined())
	  {
		areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.flexShrink() == rhs.flexShrink();
	  }

	  if (!(lhs.aspectRatio().isUndefined() && rhs.aspectRatio().isUndefined()))
	  {
		areNonFloatValuesEqual = areNonFloatValuesEqual && lhs.aspectRatio() == rhs.aspectRatio();
	  }

	  return areNonFloatValuesEqual;
	}



































	public static final float YGUndefined = Float.NaN;

//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueAuto;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueUndefined;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueZero;





	public static final YGValue YGValueZero = new YGValue(0, YGUnit.YGUnitPoint);
	public static final YGValue YGValueUndefined = new YGValue(YGUndefined, YGUnit.YGUnitUndefined);
	public static final YGValue YGValueAuto = new YGValue(YGUndefined, YGUnit.YGUnitAuto);




	 public static YGNode YGNodeNew() //Method definition originates from: Yoga.cpp
	 {
	   return YGNodeNewWithConfig(YGConfigGetDefault());
	 }

	 public static YGNode YGNodeNewWithConfig(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   YGNode node = new YGNode(null, (config));
	   YGAssertWithConfig(config, node != null, "Could not allocate memory for node");
	   Event.<Event.NodeAllocation>publish(node, {config});

	   return node;
	 }

	 public static YGNode YGNodeClone(YGNode oldNode) //Method definition originates from: Yoga.cpp
	 {
	   YGNode node = new YGNode(oldNode);
	   YGAssertWithConfig(oldNode.getConfig(), node != null, "Could not allocate memory for node");
	   Event.<Event.NodeAllocation>publish(node, {node.getConfig()});
	   node.setOwner(null);
	   return node;
	 }

	 public static void YGNodeFree(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   if (struct YGNode * owner = node.getOwner())
	   {
		 owner.removeChild(node);
		 node.setOwner(null);
	   }

	   final Integer childCount = YGNodeGetChildCount(node);
	   for (Integer i = 0; i < childCount; i++)
	   {
		 YGNode child = YGNodeGetChild(node, i);
		 child.setOwner(null);
	   }

	   node.clearChildren();
	   Event.<Event.NodeDeallocation>publish(node, {node.getConfig()});
	   node = null;
	 }

	 public static void YGNodeFreeRecursiveWithCleanupFunc(YGNode root, YGNodeCleanupFunc cleanup) //Method definition originates from: Yoga.cpp
	 {
	   Integer skipped = 0;
	   while (YGNodeGetChildCount(root) > skipped)
	   {
		 YGNode child = YGNodeGetChild(root, skipped);
		 if (child.getOwner() != root)
		 {

		   skipped += 1;
		 }
		 else
		 {
		   YGNodeRemoveChild(root, child);
		   YGNodeFreeRecursive(child);
		 }
	   }
	   if (cleanup != null)
	   {
		 cleanup.invoke(root);
	   }
	   YGNodeFree(root);
	 }

	 public static void YGNodeFreeRecursive(YGNode root) //Method definition originates from: Yoga.cpp
	 {
	   return YGNodeFreeRecursiveWithCleanupFunc(root, null);
	 }

	 public static void YGNodeReset(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   node.reset();
	 }

	 public static void YGNodeInsertChild(YGNode owner, YGNode child, final Integer index) //Method definition originates from: Yoga.cpp
	 {
	   YGAssertWithNode(owner, child.getOwner() == null, "Child already has a owner, it must be removed first.");

	   YGAssertWithNode(owner, !owner.hasMeasureFunc(), "Cannot add child: Nodes with measure functions cannot have children.");

	   owner.insertChild(child, index);
	   child.setOwner(owner);
	   owner.markDirtyAndPropogate();
	 }

	 public static void YGNodeSwapChild(YGNode owner, YGNode child, final Integer index) //Method definition originates from: Yoga.cpp
	 {
	   owner.replaceChild(child, index);
	   child.setOwner(owner);
	 }

	 public static void YGNodeRemoveChild(YGNode owner, YGNode excludedChild) //Method definition originates from: Yoga.cpp
	 {
	   if (YGNodeGetChildCount(owner) == 0)
	   {

		 return;
	   }




	   var childOwner = excludedChild.getOwner();
	   if (owner.removeChild(excludedChild))
	   {
		 if (owner == childOwner)
		 {
		   excludedChild.setLayout(());
		   excludedChild.setOwner(null);
		 }
		 owner.markDirtyAndPropogate();
	   }
	 }

	 public static void YGNodeRemoveAllChildren(YGNode owner) //Method definition originates from: Yoga.cpp
	 {
	   final Integer childCount = YGNodeGetChildCount(owner);
	   if (childCount == 0)
	   {

		 return;
	   }
	   YGNode firstChild = YGNodeGetChild(owner, 0);
	   if (firstChild.getOwner() == owner)
	   {


		 for (Integer i = 0; i < childCount; i++)
		 {
		   YGNode oldChild = YGNodeGetChild(owner, i);
		   oldChild.setLayout((new YGNode()).getLayout());
		   oldChild.setOwner(null);
		 }
		 owner.clearChildren();
		 owner.markDirtyAndPropogate();
		 return;
	   }


	   owner.setChildren(YGVector());
	   owner.markDirtyAndPropogate();
	 }

	 public static YGNode YGNodeGetChild(YGNode node, final Integer index) //Method definition originates from: Yoga.cpp
	 {
	   if (index < node.getChildren().size())
	   {
		 return node.getChild(index);
	   }
	   return null;
	 }

	 public static YGNode YGNodeGetOwner(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getOwner();
	 }

	 public static YGNode YGNodeGetParent(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getOwner();
	 }

	 public static Integer YGNodeGetChildCount(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return (Integer)(node.getChildren().size());
	 }

	 public static void YGNodeSetChildren(YGNode owner, YGNode[] c, final Integer count) //Method definition originates from: Yoga.cpp
	 {
	   ArrayList<YGNode> children = new ArrayList<YGNode>(Arrays.asList(c, c + count));
	   YGNodeSetChildrenInternal(owner, children);
	 }

	 public static void YGNodeSetIsReferenceBaseline(YGNode node, boolean isReferenceBaseline) //Method definition originates from: Yoga.cpp
	 {
	   if (node.isReferenceBaseline() != isReferenceBaseline)
	   {
		 node.setIsReferenceBaseline(isReferenceBaseline);
		 node.markDirtyAndPropogate();
	   }
	 }

	 public static boolean YGNodeIsReferenceBaseline(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.isReferenceBaseline();
	 }

	 public static void YGNodeCalculateLayout(YGNode node, final float ownerWidth, final float ownerHeight, final YGDirection ownerDirection) //Method definition originates from: Yoga.cpp
	 {
	   YGNodeCalculateLayoutWithContext(node, ownerWidth, ownerHeight, ownerDirection, null);
	 }







	 public static void YGNodeMarkDirty(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   YGAssertWithNode(node, node.hasMeasureFunc(), "Only leaf nodes with custom measure functions" + "should manually mark themselves as dirty");

	   node.markDirtyAndPropogate();
	 }





	 public static void YGNodeMarkDirtyAndPropogateToDescendants(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.markDirtyAndPropogateDownwards();
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// void YGNodePrint(YGNode node, YGPrintOptions options);

	 public static boolean YGFloatIsUndefined(final float value) //Method definition originates from: Yoga.cpp
	 {
	   return facebook.yoga.isUndefined(value);
	 }

	 public static boolean YGNodeCanUseCachedMeasurement(final YGMeasureMode widthMode, final float width, final YGMeasureMode heightMode, final float height, final YGMeasureMode lastWidthMode, final float lastWidth, final YGMeasureMode lastHeightMode, final float lastHeight, final float lastComputedWidth, final float lastComputedHeight, final float marginRow, final float marginColumn, YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   if ((!YGFloatIsUndefined(lastComputedHeight) && lastComputedHeight < 0F) || (!YGFloatIsUndefined(lastComputedWidth) && lastComputedWidth < 0F))
	   {
		 return false;
	   }
	   boolean useRoundedComparison = config != null && config.pointScaleFactor != 0;
	   final float effectiveWidth = useRoundedComparison ? YGRoundValueToPixelGrid(width, config.pointScaleFactor, false, false) : width;
	   final float effectiveHeight = useRoundedComparison ? YGRoundValueToPixelGrid(height, config.pointScaleFactor, false, false) : height;
	   final float effectiveLastWidth = useRoundedComparison ? YGRoundValueToPixelGrid(lastWidth, config.pointScaleFactor, false, false) : lastWidth;
	   final float effectiveLastHeight = useRoundedComparison ? YGRoundValueToPixelGrid(lastHeight, config.pointScaleFactor, false, false) : lastHeight;

	   final boolean hasSameWidthSpec = lastWidthMode == widthMode && YGFloatsEqual(effectiveLastWidth, effectiveWidth);
	   final boolean hasSameHeightSpec = lastHeightMode == heightMode && YGFloatsEqual(effectiveLastHeight, effectiveHeight);

	   final boolean widthIsCompatible = hasSameWidthSpec || YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(widthMode, width - marginRow, lastComputedWidth) || YGMeasureModeOldSizeIsUnspecifiedAndStillFits(widthMode, width - marginRow, lastWidthMode, lastComputedWidth) || YGMeasureModeNewMeasureSizeIsStricterAndStillValid(widthMode, width - marginRow, lastWidthMode, lastWidth, lastComputedWidth);

	   final boolean heightIsCompatible = hasSameHeightSpec || YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(heightMode, height - marginColumn, lastComputedHeight) || YGMeasureModeOldSizeIsUnspecifiedAndStillFits(heightMode, height - marginColumn, lastHeightMode, lastComputedHeight) || YGMeasureModeNewMeasureSizeIsStricterAndStillValid(heightMode, height - marginColumn, lastHeightMode, lastHeight, lastComputedHeight);

	   return widthIsCompatible && heightIsCompatible;
	 }

	 public static void YGNodeCopyStyle(YGNode dstNode, YGNode srcNode) //Method definition originates from: Yoga.cpp
	 {
	   if (!(dstNode.getStyle() == srcNode.getStyle()))
	   {
		 dstNode.setStyle(srcNode.getStyle());
		 dstNode.markDirtyAndPropogate();
	   }
	 }

	 public static Object YGNodeGetContext(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getContext();
	 }

	 public static void YGNodeSetContext(YGNode node, Object context) //Method definition originates from: Yoga.cpp
	 {
	   return node.setContext(context);
	 }

	public static void YGConfigSetPrintTreeFlag(YGConfig config, boolean enabled) //Method definition originates from: Yoga.cpp
	{
	  config.printTree = enabled;
	}

	public static boolean YGNodeHasMeasureFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.hasMeasureFunc();
	}

	 public static void YGNodeSetMeasureFunc(YGNode node, YGMeasureFunc measureFunc) //Method definition originates from: Yoga.cpp
	 {
	   node.setMeasureFunc(measureFunc);
	 }

	public static boolean YGNodeHasBaselineFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.hasBaselineFunc();
	}

	public static void YGNodeSetBaselineFunc(YGNode node, YGBaselineFunc baselineFunc) //Method definition originates from: Yoga.cpp
	{
	  node.setBaselineFunc(baselineFunc);
	}

	public static YGDirtiedFunc YGNodeGetDirtiedFunc(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.getDirtied();
	}

	public static void YGNodeSetDirtiedFunc(YGNode node, YGDirtiedFunc dirtiedFunc) //Method definition originates from: Yoga.cpp
	{
	  node.setDirtiedFunc(dirtiedFunc);
	}

	public static void YGNodeSetPrintFunc(YGNode node, YGPrintFunc printFunc) //Method definition originates from: Yoga.cpp
	{
	  node.setPrintFunc(printFunc);
	}

	 public static boolean YGNodeGetHasNewLayout(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getHasNewLayout();
	 }

	 public static void YGNodeSetHasNewLayout(YGNode node, boolean hasNewLayout) //Method definition originates from: Yoga.cpp
	 {
	   node.setHasNewLayout(hasNewLayout);
	 }

	public static YGNodeType YGNodeGetNodeType(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.getNodeType();
	}

	public static void YGNodeSetNodeType(YGNode node, YGNodeType nodeType) //Method definition originates from: Yoga.cpp
	{
	  return node.setNodeType(nodeType);
	}

	 public static boolean YGNodeIsDirty(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.isDirty();
	 }

	public static boolean YGNodeLayoutGetDidUseLegacyFlag(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.didUseLegacyFlag();
	}

	 public static void YGNodeStyleSetDirection(YGNode node, final YGDirection value) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).direction())>(node, YGStyle.direction, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGDirection YGNodeStyleGetDirection(YGNode node);

	 public static void YGNodeStyleSetFlexDirection(YGNode node, final YGFlexDirection flexDirection) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flexDirection())>(node, YGStyle.flexDirection, flexDirection);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGFlexDirection YGNodeStyleGetFlexDirection(YGNode node);

	 public static void YGNodeStyleSetJustifyContent(YGNode node, final YGJustify justifyContent) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).justifyContent())>(node, YGStyle.justifyContent, justifyContent);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGJustify YGNodeStyleGetJustifyContent(YGNode node);

	 public static void YGNodeStyleSetAlignContent(YGNode node, final YGAlign alignContent) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).alignContent())>(node, YGStyle.alignContent, alignContent);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGAlign YGNodeStyleGetAlignContent(YGNode node);

	 public static void YGNodeStyleSetAlignItems(YGNode node, final YGAlign alignItems) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).alignItems())>(node, YGStyle.alignItems, alignItems);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGAlign YGNodeStyleGetAlignItems(YGNode node);

	 public static void YGNodeStyleSetAlignSelf(YGNode node, final YGAlign alignSelf) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).alignSelf())>(node, YGStyle.alignSelf, alignSelf);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGAlign YGNodeStyleGetAlignSelf(YGNode node);

	 public static void YGNodeStyleSetPositionType(YGNode node, final YGPositionType positionType) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).positionType())>(node, YGStyle.positionType, positionType);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGPositionType YGNodeStyleGetPositionType(YGNode node);

	 public static void YGNodeStyleSetFlexWrap(YGNode node, final YGWrap flexWrap) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flexWrap())>(node, YGStyle.flexWrap, flexWrap);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGWrap YGNodeStyleGetFlexWrap(YGNode node);

	 public static void YGNodeStyleSetOverflow(YGNode node, final YGOverflow overflow) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).overflow())>(node, YGStyle.overflow, overflow);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGOverflow YGNodeStyleGetOverflow(YGNode node);

	 public static void YGNodeStyleSetDisplay(YGNode node, final YGDisplay display) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).display())>(node, YGStyle.display, display);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGDisplay YGNodeStyleGetDisplay(YGNode node);

	 public static void YGNodeStyleSetFlex(YGNode node, final float flex) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flex())>(node, YGStyle.flex, YGFloatOptional((flex)));
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// float YGNodeStyleGetFlex(YGNode node);

	 public static void YGNodeStyleSetFlexGrow(YGNode node, final float flexGrow) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flexGrow())>(node, YGStyle.flexGrow, YGFloatOptional((flexGrow)));
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// float YGNodeStyleGetFlexGrow(YGNode node);

	 public static void YGNodeStyleSetFlexShrink(YGNode node, final float flexShrink) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flexShrink())>(node, YGStyle.flexShrink, YGFloatOptional((flexShrink)));
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// float YGNodeStyleGetFlexShrink(YGNode node);

	 public static void YGNodeStyleSetFlexBasis(YGNode node, final float flexBasis) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(flexBasis);
	   updateStyle<decltype(YGStyle(()).flexBasis())>(node, YGStyle.flexBasis, value);
	 }

	 public static void YGNodeStyleSetFlexBasisPercent(YGNode node, final float flexBasisPercent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(flexBasisPercent);
	   updateStyle<decltype(YGStyle(()).flexBasis())>(node, YGStyle.flexBasis, value);
	 }

	 public static void YGNodeStyleSetFlexBasisAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).flexBasis())>(node, YGStyle.flexBasis, detail.CompactValue.ofAuto());
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGValue YGNodeStyleGetFlexBasis(YGNode node);

	 public static void YGNodeStyleSetPosition(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(points);
	   updateIndexedStyleProp<decltype(YGStyle(()).position())>(node, YGStyle.position, edge, value);
	 }

	 public static void YGNodeStyleSetPositionPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(percent);
	   updateIndexedStyleProp<decltype(YGStyle(()).position())>(node, YGStyle.position, edge, value);
	 }

	 public static YGValue YGNodeStyleGetPosition(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	   return node.getStyle().position()[(int)edge];
	 }

	 public static void YGNodeStyleSetMargin(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(points);
	   updateIndexedStyleProp<decltype(YGStyle(()).margin())>(node, YGStyle.margin, edge, value);
	 }

	 public static void YGNodeStyleSetMarginPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(percent);
	   updateIndexedStyleProp<decltype(YGStyle(()).margin())>(node, YGStyle.margin, edge, value);
	 }

	 public static void YGNodeStyleSetMarginAuto(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	   updateIndexedStyleProp<decltype(YGStyle(()).margin())>(node, YGStyle.margin, edge, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetMargin(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	   return node.getStyle().margin()[(int)edge];
	 }

	 public static void YGNodeStyleSetPadding(YGNode node, YGEdge edge, float points) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(points);
	   updateIndexedStyleProp<decltype(YGStyle(()).padding())>(node, YGStyle.padding, edge, value);
	 }

	 public static void YGNodeStyleSetPaddingPercent(YGNode node, YGEdge edge, float percent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(percent);
	   updateIndexedStyleProp<decltype(YGStyle(()).padding())>(node, YGStyle.padding, edge, value);
	 }

	 public static YGValue YGNodeStyleGetPadding(YGNode node, YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
	   return node.getStyle().padding()[(int)edge];
	 }

	 public static void YGNodeStyleSetBorder(YGNode node, final YGEdge edge, final float border) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(border);
	   updateIndexedStyleProp<decltype(YGStyle(()).border())>(node, YGStyle.border, edge, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// float YGNodeStyleGetBorder(YGNode node, YGEdge edge);

	 public static void YGNodeStyleSetWidth(YGNode node, float points) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(points);
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetWidthPercent(YGNode node, float percent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(percent);
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetWidthAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionWidth, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getStyle().dimensions()[(int)YGDimension.YGDimensionWidth];
	 }

	 public static void YGNodeStyleSetHeight(YGNode node, float points) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(points);
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetHeightPercent(YGNode node, float percent) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(percent);
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetHeightAuto(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   updateIndexedStyleProp<decltype(YGStyle(()).dimensions())>(node, YGStyle.dimensions, YGDimension.YGDimensionHeight, detail.CompactValue.ofAuto());
	 }

	 public static YGValue YGNodeStyleGetHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
	   return node.getStyle().dimensions()[(int)YGDimension.YGDimensionHeight];
	 }

	 public static void YGNodeStyleSetMinWidth(YGNode node, final float minWidth) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(minWidth);
	   updateIndexedStyleProp<decltype(YGStyle(()).minDimensions())>(node, YGStyle.minDimensions, YGDimension.YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetMinWidthPercent(YGNode node, final float minWidth) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(minWidth);
	   updateIndexedStyleProp<decltype(YGStyle(()).minDimensions())>(node, YGStyle.minDimensions, YGDimension.YGDimensionWidth, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGValue YGNodeStyleGetMinWidth(YGNode node);

	 public static void YGNodeStyleSetMinHeight(YGNode node, final float minHeight) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(minHeight);
	   updateIndexedStyleProp<decltype(YGStyle(()).minDimensions())>(node, YGStyle.minDimensions, YGDimension.YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetMinHeightPercent(YGNode node, final float minHeight) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(minHeight);
	   updateIndexedStyleProp<decltype(YGStyle(()).minDimensions())>(node, YGStyle.minDimensions, YGDimension.YGDimensionHeight, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGValue YGNodeStyleGetMinHeight(YGNode node);

	 public static void YGNodeStyleSetMaxWidth(YGNode node, final float maxWidth) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(maxWidth);
	   updateIndexedStyleProp<decltype(YGStyle(()).maxDimensions())>(node, YGStyle.maxDimensions, YGDimension.YGDimensionWidth, value);
	 }

	 public static void YGNodeStyleSetMaxWidthPercent(YGNode node, final float maxWidth) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(maxWidth);
	   updateIndexedStyleProp<decltype(YGStyle(()).maxDimensions())>(node, YGStyle.maxDimensions, YGDimension.YGDimensionWidth, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGValue YGNodeStyleGetMaxWidth(YGNode node);

	 public static void YGNodeStyleSetMaxHeight(YGNode node, final float maxHeight) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPoint.getValue()>ofMaybe(maxHeight);
	   updateIndexedStyleProp<decltype(YGStyle(()).maxDimensions())>(node, YGStyle.maxDimensions, YGDimension.YGDimensionHeight, value);
	 }

	 public static void YGNodeStyleSetMaxHeightPercent(YGNode node, final float maxHeight) //Method definition originates from: Yoga.cpp
	 {
	   var value = detail.CompactValue.<YGUnit.YGUnitPercent.getValue()>ofMaybe(maxHeight);
	   updateIndexedStyleProp<decltype(YGStyle(()).maxDimensions())>(node, YGStyle.maxDimensions, YGDimension.YGDimensionHeight, value);
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// YGValue YGNodeStyleGetMaxHeight(YGNode node);
	 public static void YGNodeStyleSetAspectRatio(YGNode node, final float aspectRatio) //Method definition originates from: Yoga.cpp
	 {
	   updateStyle<decltype(YGStyle(()).aspectRatio())>(node, YGStyle.aspectRatio, YGFloatOptional((aspectRatio)));
	 }

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	// float YGNodeStyleGetAspectRatio(YGNode node);

	 public static float YGNodeLayoutGetLeft(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position[(int)YGEdge.YGEdgeLeft];
	 }

	 public static float YGNodeLayoutGetTop(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position[(int)YGEdge.YGEdgeTop];
	 }

	 public static float YGNodeLayoutGetRight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position[(int)YGEdge.YGEdgeRight];
	 }

	 public static float YGNodeLayoutGetBottom(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().position[(int)YGEdge.YGEdgeBottom];
	 }

	 public static float YGNodeLayoutGetWidth(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().dimensions[(int)YGDimension.YGDimensionWidth];
	 }

	 public static float YGNodeLayoutGetHeight(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().dimensions[(int)YGDimension.YGDimensionHeight];
	 }

	 public static YGDirection YGNodeLayoutGetDirection(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().direction();
	 }

	 public static boolean YGNodeLayoutGetHadOverflow(YGNode node) //Method definition originates from: Yoga.cpp
	 {
		 return node.getLayout().hadOverflow();
	 }

	public static boolean YGNodeLayoutGetDidLegacyStretchFlagAffectLayout(YGNode node) //Method definition originates from: Yoga.cpp
	{
	  return node.getLayout().doesLegacyStretchFlagAffectsLayout();
	}





	 public static float YGNodeLayoutGetMargin(YGNode node, final YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge.getValue() <= YGEdge.YGEdgeEnd.getValue(), "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdge.YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().margin[(int)YGEdge.YGEdgeRight];
			 }
			 else
			 {
				 return node.getLayout().margin[(int)YGEdge.YGEdgeLeft];
			 }
		 }
		 if (edge == YGEdge.YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().margin[(int)YGEdge.YGEdgeLeft];
			 }
			 else
			 {
				 return node.getLayout().margin[(int)YGEdge.YGEdgeRight];
			 }
		 }
		 return node.getLayout().margin[(int)edge];
	 }

	 public static float YGNodeLayoutGetBorder(YGNode node, final YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge.getValue() <= YGEdge.YGEdgeEnd.getValue(), "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdge.YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().border[(int)YGEdge.YGEdgeRight];
			 }
			 else
			 {
				 return node.getLayout().border[(int)YGEdge.YGEdgeLeft];
			 }
		 }
		 if (edge == YGEdge.YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().border[(int)YGEdge.YGEdgeLeft];
			 }
			 else
			 {
				 return node.getLayout().border[(int)YGEdge.YGEdgeRight];
			 }
		 }
		 return node.getLayout().border[(int)edge];
	 }

	 public static float YGNodeLayoutGetPadding(YGNode node, final YGEdge edge) //Method definition originates from: Yoga.cpp
	 {
		 YGAssertWithNode(node, edge.getValue() <= YGEdge.YGEdgeEnd.getValue(), "Cannot get layout properties of multi-edge shorthands");
		 if (edge == YGEdge.YGEdgeStart)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().padding[(int)YGEdge.YGEdgeRight];
			 }
			 else
			 {
				 return node.getLayout().padding[(int)YGEdge.YGEdgeLeft];
			 }
		 }
		 if (edge == YGEdge.YGEdgeEnd)
		 {
			 if (node.getLayout().direction() == YGDirection.YGDirectionRTL)
			 {
				 return node.getLayout().padding[(int)YGEdge.YGEdgeLeft];
			 }
			 else
			 {
				 return node.getLayout().padding[(int)YGEdge.YGEdgeRight];
			 }
		 }
		 return node.getLayout().padding[(int)edge];
	 }

	 public static void YGConfigSetLogger(YGConfig config, YGLogger logger) //Method definition originates from: Yoga.cpp
	 {
	   if (logger != null)
	   {
		 config.setLogger(logger);
	   }
	   else
	   {



		 config.setLogger(YGDefaultLog);

	   }
	 }

	 public static void YGAssert(final boolean condition, String message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(YGNodeRef((null)), YGLogLevel.YGLogLevelFatal, null, "%s\n", message);
		 throwLogicalErrorWithMessage(message);
	   }
	 }

	 public static void YGAssertWithNode(YGNode node, final boolean condition, String message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(node, YGLogLevel.YGLogLevelFatal, null, "%s\n", message);
		 throwLogicalErrorWithMessage(message);
	   }
	 }

	 public static void YGAssertWithConfig(YGConfig config, final boolean condition, String message) //Method definition originates from: Yoga.cpp
	 {
	   if (!condition)
	   {
		 Log.log(config, YGLogLevel.YGLogLevelFatal, null, "%s\n", message);
		 throwLogicalErrorWithMessage(message);
	   }
	 }


	 public static void YGConfigSetPointScaleFactor(YGConfig config, final float pixelsInPoint) //Method definition originates from: Yoga.cpp
	 {
	   YGAssertWithConfig(config, pixelsInPoint >= 0.0f, "Scale factor should not be less than zero");


	   if (pixelsInPoint == 0.0f)
	   {

		 config.pointScaleFactor = 0.0f;
	   }
	   else
	   {
		 config.pointScaleFactor = pixelsInPoint;
	   }
	 }

	public static void YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(YGConfig config, final boolean shouldDiffLayout) //Method definition originates from: Yoga.cpp
	{
	  config.shouldDiffLayoutWithoutLegacyStretchBehaviour = shouldDiffLayout;
	}






	 public static void YGConfigSetUseLegacyStretchBehaviour(YGConfig config, final boolean useLegacyStretchBehaviour) //Method definition originates from: Yoga.cpp
	 {
	   config.useLegacyStretchBehaviour = useLegacyStretchBehaviour;
	 }


	 public static YGConfig YGConfigNew() //Method definition originates from: Yoga.cpp
	 {



	   YGConfig config = new YGConfig(YGDefaultLog);

	   gConfigInstanceCount++;
	   return config;
	 }

	 public static void YGConfigFree(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   config = null;
	   gConfigInstanceCount--;
	 }

	 public static void YGConfigCopy(YGConfig dest, YGConfig src) //Method definition originates from: Yoga.cpp
	 {
//C++ TO JAVA CONVERTER TODO TASK: The memory management function 'memcpy' has no equivalent in Java:
//C++ TO JAVA CONVERTER TODO TASK: There is no Java equivalent to 'sizeof':
	   memcpy(dest, src, sizeof(YGConfig));
	 }

	 public static int32_t YGConfigGetInstanceCount() //Method definition originates from: Yoga.cpp
	 {
	   return gConfigInstanceCount;
	 }

	 public static void YGConfigSetExperimentalFeatureEnabled(YGConfig config, final YGExperimentalFeature feature, final boolean enabled) //Method definition originates from: Yoga.cpp
	 {
	   config.experimentalFeatures[(int)feature] = enabled;
	 }

	 public static boolean YGConfigIsExperimentalFeatureEnabled(YGConfig config, final YGExperimentalFeature feature) //Method definition originates from: Yoga.cpp
	 {
	   return config.experimentalFeatures[(int)feature];
	 }



	 public static void YGConfigSetUseWebDefaults(YGConfig config, final boolean enabled) //Method definition originates from: Yoga.cpp
	 {
	   config.useWebDefaults = enabled;
	 }

	 public static boolean YGConfigGetUseWebDefaults(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   return config.useWebDefaults;
	 }

	 public static void YGConfigSetCloneNodeFunc(YGConfig config, final YGCloneNodeFunc callback) //Method definition originates from: Yoga.cpp
	 {
	   config.setCloneNodeCallback(callback);
	 }


	//C++ TO JAVA CONVERTER NOTE: This was formerly a static local variable declaration (not allowed in Java):
	 public static YGConfigGetDefault_YGConfig defaultConfig = YGConfigNew();

	 public static YGConfig YGConfigGetDefault() //Method definition originates from: Yoga.cpp
	 {
	//C++ TO JAVA CONVERTER NOTE: This static local variable declaration (not allowed in Java) has been moved just prior to the method:
	//   static struct YGConfig* defaultConfig = YGConfigNew();
	   return defaultConfig;
	 }

	 public static void YGConfigSetContext(YGConfig config, Object context) //Method definition originates from: Yoga.cpp
	 {
	   config.context = context;
	 }

	 public static Object YGConfigGetContext(YGConfig config) //Method definition originates from: Yoga.cpp
	 {
	   return config.context;
	 }

	 public static float YGRoundValueToPixelGrid(final double value, final double pointScaleFactor, final boolean forceCeil, final boolean forceFloor) //Method definition originates from: Yoga.cpp
	 {
	   double scaledValue = value * pointScaleFactor;


	   double fractial = fmod(scaledValue, 1.0);
	   if (fractial < 0)
	   {
		 ++fractial;
	   }
	   if (YGDoubleEqual(fractial, 0))
	   {

		 scaledValue = scaledValue - fractial;
	   }
	   else if (YGDoubleEqual(fractial, 1.0))
	   {
		 scaledValue = scaledValue - fractial + 1.0;
	   }
	   else if (forceCeil)
	   {

		 scaledValue = scaledValue - fractial + 1.0;
	   }
	   else if (forceFloor)
	   {
		 scaledValue = scaledValue - fractial;
	   }
	   else
	   {

		 scaledValue = scaledValue - fractial + (!YGDoubleIsUndefined(fractial) && (fractial > 0.5 || YGDoubleEqual(fractial, 0.5)) ? 1.0 : 0.0);
	   }
	   return (YGDoubleIsUndefined(scaledValue) || YGDoubleIsUndefined(pointScaleFactor)) ? YGUndefined : (float)(scaledValue / pointScaleFactor);
	 }
	public static int YGDefaultLog(YGConfig config, YGNode node, YGLogLevel level, String format, va_list args) //Method definition originates from: Yoga.cpp
	{
	   (config);
	   (node);
	  switch (level)
	  {
		case YGLogLevelError:
		case YGLogLevelFatal:
		  return vfprintf(stderr, format, args);
		case YGLogLevelWarn:
		case YGLogLevelInfo:
		case YGLogLevelDebug:
		case YGLogLevelVerbose:
		default:
		  return vprintf(format, args);
	  }
	}




	public static boolean YGDoubleIsUndefined(final double value)
	{
	  return facebook.yoga.isUndefined(value);
	}

	public static int32_t gConfigInstanceCount = 0;

	public static YGConfig YGConfigClone(final YGConfig oldConfig)
	{
	  YGConfig config = new YGConfig(oldConfig);
	  YGAssert(config != null, "Could not allocate memory for config");
	  gConfigInstanceCount++;
	  return config;
	}

	public static YGNode YGNodeDeepClone(YGNode oldNode)
	{
	  var config = YGConfigClone(*oldNode.getConfig());
	  var node = new YGNode((oldNode, config));
	  node.setOwner(null);
	  Event.<Event.NodeAllocation>publish(node, {node.getConfig()});

	  ArrayList<YGNode> vec = YGVector();
	  vec.ensureCapacity(oldNode.getChildren().size());
	  YGNode childNode = null;
//C++ TO JAVA CONVERTER NOTE: 'auto' variable declarations are not supported in Java:
//ORIGINAL LINE: for (auto* item : oldNode->getChildren())
	  for (var item : oldNode.getChildren())
	  {
		childNode = YGNodeDeepClone(item);
		childNode.setOwner(node);
		vec.add(childNode);
	  }
	  node.setChildren(vec);

//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return node;
	  return new YGNode(node);
	}

	public static void YGConfigFreeRecursive(YGNode root)
	{
	  if (root.getConfig() != null)
	  {
		gConfigInstanceCount--;
		root.getConfig() = null;
	  }

//C++ TO JAVA CONVERTER NOTE: 'auto' variable declarations are not supported in Java:
//ORIGINAL LINE: for (auto* child : root->getChildren())
	  for (var child : root.getChildren())
	  {
		YGConfigFreeRecursive(child);
	  }
	}

	public static void YGNodeSetChildrenInternal(final YGNode owner, final ArrayList<YGNode> children)
	{
	  if (owner == null)
	  {
		return;
	  }
	  if (children.size() == 0)
	  {
		if (YGNodeGetChildCount(owner) > 0)
		{
		  for (YGNode child : owner.getChildren())
		  {
			child.setLayout(YGLayout());
			child.setOwner(null);
		  }
		  owner.setChildren(YGVector());
		  owner.markDirtyAndPropogate();
		}
	  }
	  else
	  {
		if (YGNodeGetChildCount(owner) > 0)
		{
		  for (YGNode oldChild : owner.getChildren())
		  {


			if (std::find(children.iterator(), children.end(), oldChild) == children.end())
			{
			  oldChild.setLayout(YGLayout());
			  oldChild.setOwner(null);
			}
		  }
		}
		owner.setChildren(children);
		for (YGNode child : children)
		{
		  child.setOwner(owner);
		}
		owner.markDirtyAndPropogate();
	  }
	}

	public static void YGNodeSetChildren(final YGNode owner, final ArrayList<YGNode> children)
	{
	  YGNodeSetChildrenInternal(owner, children);
	}

	public static float YGNodeStyleGetFlexGrow(YGNode node)
	{
	  return node.getStyle().flexGrow().isUndefined() ? kDefaultFlexGrow : node.getStyle().flexGrow().unwrap();
	}

	public static float YGNodeStyleGetFlexShrink(YGNode node)
	{
	  return node.getStyle().flexShrink().isUndefined() ? (node.getConfig().useWebDefaults ? kWebDefaultFlexShrink : kDefaultFlexShrink) : node.getStyle().flexShrink().unwrap();
	}
//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
	public static <T, NeedsUpdate, Update> void updateStyle(YGNode node, T value, NeedsUpdate && needsUpdate, Update && update)
	{
	  if (needsUpdate(node.getStyle(), value))
	  {
		update(node.getStyle(), value);
		node.markDirtyAndPropogate();
	  }
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Ref, typename T>
@FunctionalInterface
interface propDelegate
{
	Ref invoke();
}

	public static <Ref, T> void updateStyle(YGNode node, propDelegate prop, T value)
	{
//C++ TO JAVA CONVERTER TODO TASK: Only lambda expressions having all locals passed by reference can be converted to Java:
//ORIGINAL LINE: updateStyle(node, value, [prop](YGStyle& s, T x)
  updateStyle(node, value, (YGStyle s, T x) ->
  {
	  return prop.invoke() != x;
  }, (YGStyle s, T x) ->
  {
	  prop.invoke() = x;
  });
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Ref, typename Idx>
@FunctionalInterface
interface propDelegate
{
	Ref invoke();
}

	public static <Ref, Idx> void updateIndexedStyleProp(YGNode node, propDelegate prop, Idx idx, facebook.yoga.detail.CompactValue value)
	{
//C++ TO JAVA CONVERTER TODO TASK: Only lambda expressions having all locals passed by reference can be converted to Java:
//ORIGINAL LINE: updateStyle(node, value, [idx, prop](YGStyle& s, CompactValue x)
  updateStyle(node, value, (YGStyle s, CompactValue x) ->
  {
	  return prop.invoke()[idx] != x;
  }, (YGStyle s, CompactValue x) ->
  {
	  prop.invoke()[idx] = x;
  });
	}

	public static YGDirection YGNodeStyleGetDirection(YGNode node)
	{
	  return node.getStyle().direction();
	}
	public static YGFlexDirection YGNodeStyleGetFlexDirection(YGNode node)
	{
	  return node.getStyle().flexDirection();
	}
	public static YGJustify YGNodeStyleGetJustifyContent(YGNode node)
	{
	  return node.getStyle().justifyContent();
	}
	public static YGAlign YGNodeStyleGetAlignContent(YGNode node)
	{
	  return node.getStyle().alignContent();
	}
	public static YGAlign YGNodeStyleGetAlignItems(YGNode node)
	{
	  return node.getStyle().alignItems();
	}
	public static YGAlign YGNodeStyleGetAlignSelf(YGNode node)
	{
	  return node.getStyle().alignSelf();
	}
	public static YGPositionType YGNodeStyleGetPositionType(YGNode node)
	{
	  return node.getStyle().positionType();
	}
	public static YGWrap YGNodeStyleGetFlexWrap(YGNode node)
	{
	  return node.getStyle().flexWrap();
	}
	public static YGOverflow YGNodeStyleGetOverflow(YGNode node)
	{
	  return node.getStyle().overflow();
	}
	public static YGDisplay YGNodeStyleGetDisplay(YGNode node)
	{
	  return node.getStyle().display();
	}


	public static float YGNodeStyleGetFlex(YGNode node)
	{
	  return node.getStyle().flex().isUndefined() ? YGUndefined : node.getStyle().flex().unwrap();
	}

	public static YGValue YGNodeStyleGetFlexBasis(YGNode node)
	{
	  YGValue flexBasis = node.getStyle().flexBasis();
	  if (flexBasis.unit == YGUnit.YGUnitUndefined || flexBasis.unit == YGUnit.YGUnitAuto)
	  {

		flexBasis.value = YGUndefined;
	  }
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexBasis;
	  return new YGValue(flexBasis);
	}

	public static float YGNodeStyleGetBorder(YGNode node, final YGEdge edge)
	{
	  var border = node.getStyle().border()[(int)edge];
	  if (border.isUndefined() || border.isAuto())
	  {


		return YGUndefined;
	  }

	  return ((YGValue)border).value;
	}




	public static float YGNodeStyleGetAspectRatio(YGNode node)
	{
	  final YGFloatOptional op = node.getStyle().aspectRatio();
	  return op.isUndefined() ? YGUndefined : op.unwrap();
	}
	public static YGValue YGNodeStyleGetMinWidth(YGNode node)
	{
	  return node.getStyle().minDimensions()[(int)YGDimension.YGDimensionWidth];
	}
	public static YGValue YGNodeStyleGetMinHeight(YGNode node)
	{
	  return node.getStyle().minDimensions()[(int)YGDimension.YGDimensionHeight];
	}
	public static YGValue YGNodeStyleGetMaxWidth(YGNode node)
	{
	  return node.getStyle().maxDimensions()[(int)YGDimension.YGDimensionWidth];
	}
	public static YGValue YGNodeStyleGetMaxHeight(YGNode node)
	{
	  return node.getStyle().maxDimensions()[(int)YGDimension.YGDimensionHeight];
	}

//C++ TO JAVA CONVERTER TODO TASK: The following statement was not recognized, possibly due to an unrecognized macro:
	std::atomic<Integer> gCurrentGenerationCount(0);

	public static boolean YGLayoutNodeInternal(YGNode node, final float availableWidth, final float availableHeight, final YGDirection ownerDirection, final YGMeasureMode widthMeasureMode, final YGMeasureMode heightMeasureMode, final float ownerWidth, final float ownerHeight, final boolean performLayout, final LayoutPassReason reason, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, Integer depth, final Integer generationCount) //Method definition originates from: Yoga.cpp
	{
	  YGLayout layout = node.getLayout();

	  depth++;

	  final boolean needToVisitNode = (node.isDirty() && layout.generationCount != generationCount) || layout.lastOwnerDirection != ownerDirection;

	  if (needToVisitNode)
	  {

		layout.nextCachedMeasurementsIndex = 0;
		layout.cachedLayout.availableWidth = -1;
		layout.cachedLayout.availableHeight = -1;
		layout.cachedLayout.widthMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
		layout.cachedLayout.heightMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
		layout.cachedLayout.computedWidth = -1;
		layout.cachedLayout.computedHeight = -1;
	  }

	  YGCachedMeasurement cachedResults = null;
	  if (node.hasMeasureFunc())
	  {
		final float marginAxisRow = node.getMarginForAxis(YGFlexDirection.YGFlexDirectionRow, ownerWidth).unwrap();
		final float marginAxisColumn = node.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, ownerWidth).unwrap();


		if (YGNodeCanUseCachedMeasurement(widthMeasureMode, availableWidth, heightMeasureMode, availableHeight, layout.cachedLayout.widthMeasureMode, layout.cachedLayout.availableWidth, layout.cachedLayout.heightMeasureMode, layout.cachedLayout.availableHeight, layout.cachedLayout.computedWidth, layout.cachedLayout.computedHeight, marginAxisRow, marginAxisColumn, config))
		{
		  cachedResults = layout.cachedLayout;
		}
		else
		{

		  for (Integer i = 0; i < layout.nextCachedMeasurementsIndex; i++)
		  {
			if (YGNodeCanUseCachedMeasurement(widthMeasureMode, availableWidth, heightMeasureMode, availableHeight, layout.cachedMeasurements[i].widthMeasureMode, layout.cachedMeasurements[i].availableWidth, layout.cachedMeasurements[i].heightMeasureMode, layout.cachedMeasurements[i].availableHeight, layout.cachedMeasurements[i].computedWidth, layout.cachedMeasurements[i].computedHeight, marginAxisRow, marginAxisColumn, config))
			{
			  cachedResults = layout.cachedMeasurements[i];
			  break;
			}
		  }
		}
	  }
	  else if (performLayout)
	  {
		if (YGFloatsEqual(layout.cachedLayout.availableWidth, availableWidth) && YGFloatsEqual(layout.cachedLayout.availableHeight, availableHeight) && layout.cachedLayout.widthMeasureMode == widthMeasureMode && layout.cachedLayout.heightMeasureMode == heightMeasureMode)
		{
		  cachedResults = layout.cachedLayout;
		}
	  }
	  else
	  {
		for (Integer i = 0; i < layout.nextCachedMeasurementsIndex; i++)
		{
		  if (YGFloatsEqual(layout.cachedMeasurements[i].availableWidth, availableWidth) && YGFloatsEqual(layout.cachedMeasurements[i].availableHeight, availableHeight) && layout.cachedMeasurements[i].widthMeasureMode == widthMeasureMode && layout.cachedMeasurements[i].heightMeasureMode == heightMeasureMode)
		  {
			cachedResults = layout.cachedMeasurements[i];
			break;
		  }
		}
	  }

	  if (!needToVisitNode && cachedResults != null)
	  {
		layout.measuredDimensions[(int)YGDimension.YGDimensionWidth] = cachedResults.computedWidth;
		layout.measuredDimensions[(int)YGDimension.YGDimensionHeight] = cachedResults.computedHeight;

		(performLayout ? layoutMarkerData.cachedLayouts : layoutMarkerData.cachedMeasures) += 1;

		if (gPrintChanges && gPrintSkips)
		{
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "%s%d.{[skipped] ", YGSpacer(depth), depth);
		  node.print(layoutContext);
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "wm: %s, hm: %s, aw: %f ah: %f => d: (%f, %f) %s\n", YGMeasureModeName(widthMeasureMode, performLayout), YGMeasureModeName(heightMeasureMode, performLayout), availableWidth, availableHeight, cachedResults.computedWidth, cachedResults.computedHeight, LayoutPassReasonToString(reason));
		}
	  }
	  else
	  {
		if (gPrintChanges)
		{
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "%s%d.{%s", YGSpacer(depth), depth, needToVisitNode ? "*" : "");
		  node.print(layoutContext);
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "wm: %s, hm: %s, aw: %f ah: %f %s\n", YGMeasureModeName(widthMeasureMode, performLayout), YGMeasureModeName(heightMeasureMode, performLayout), availableWidth, availableHeight, LayoutPassReasonToString(reason));
		}

		YGNodelayoutImpl(node, availableWidth, availableHeight, ownerDirection, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight, performLayout, config, layoutMarkerData, layoutContext, depth, generationCount, reason);

		if (gPrintChanges)
		{
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "%s%d.}%s", YGSpacer(depth), depth, needToVisitNode ? "*" : "");
		  node.print(layoutContext);
		  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "wm: %s, hm: %s, d: (%f, %f) %s\n", YGMeasureModeName(widthMeasureMode, performLayout), YGMeasureModeName(heightMeasureMode, performLayout), layout.measuredDimensions[(int)YGDimension.YGDimensionWidth], layout.measuredDimensions[(int)YGDimension.YGDimensionHeight], LayoutPassReasonToString(reason));
		}

		layout.lastOwnerDirection = ownerDirection;

		if (cachedResults == null)
		{
		  if (layout.nextCachedMeasurementsIndex + 1 > (Integer) layoutMarkerData.maxMeasureCache)
		  {
			layoutMarkerData.maxMeasureCache = layout.nextCachedMeasurementsIndex + 1;
		  }
		  if (layout.nextCachedMeasurementsIndex == YG_MAX_CACHED_RESULT_COUNT)
		  {
			if (gPrintChanges)
			{
			  Log.log(node, YGLogLevel.YGLogLevelVerbose, null, "Out of cache entries!\n");
			}
			layout.nextCachedMeasurementsIndex = 0;
		  }

		  YGCachedMeasurement newCacheEntry;
		  if (performLayout)
		  {

			newCacheEntry = layout.cachedLayout;
		  }
		  else
		  {

			newCacheEntry = layout.cachedMeasurements[layout.nextCachedMeasurementsIndex];
			layout.nextCachedMeasurementsIndex++;
		  }

		  newCacheEntry.availableWidth = availableWidth;
		  newCacheEntry.availableHeight = availableHeight;
		  newCacheEntry.widthMeasureMode = widthMeasureMode;
		  newCacheEntry.heightMeasureMode = heightMeasureMode;
		  newCacheEntry.computedWidth = layout.measuredDimensions[(int)YGDimension.YGDimensionWidth];
		  newCacheEntry.computedHeight = layout.measuredDimensions[(int)YGDimension.YGDimensionHeight];
		}
	  }

	  if (performLayout)
	  {
		node.setLayoutDimension(node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth], YGDimension.YGDimensionWidth);
		node.setLayoutDimension(node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight], YGDimension.YGDimensionHeight);

		node.setHasNewLayout(true);
		node.setDirty(false);
	  }

	  layout.generationCount = generationCount;

	  LayoutType layoutType = new LayoutType();
	  if (performLayout)
	  {
		layoutType = !needToVisitNode && cachedResults == layout.cachedLayout ? LayoutType.kCachedLayout : LayoutType.kLayout;
	  }
	  else
	  {
		layoutType = cachedResults != null ? LayoutType.kCachedMeasure : LayoutType.kMeasure;
	  }
	  Event.<Event.NodeLayout>publish(node, {layoutType, layoutContext});

	  return (needToVisitNode || cachedResults == null);
	}

	public static final ArrayList<YGEdge> leading = new ArrayList<>(List.of(YGEdge.YGEdgeTop, YGEdge.YGEdgeBottom, YGEdge.YGEdgeLeft, YGEdge.YGEdgeRight));
	public static final ArrayList<YGEdge> trailing = new ArrayList<>(List.of(YGEdge.YGEdgeBottom, YGEdge.YGEdgeTop, YGEdge.YGEdgeRight, YGEdge.YGEdgeLeft));
	public static final ArrayList<YGEdge> pos = new ArrayList<>(List.of(YGEdge.YGEdgeTop, YGEdge.YGEdgeBottom, YGEdge.YGEdgeLeft, YGEdge.YGEdgeRight));
	public static final ArrayList<YGDimension> dim = new ArrayList<>(List.of(YGDimension.YGDimensionHeight, YGDimension.YGDimensionHeight, YGDimension.YGDimensionWidth, YGDimension.YGDimensionWidth));

	public static float YGNodePaddingAndBorderForAxis(YGNode node, final YGFlexDirection axis, final float widthSize)
	{
	  return (node.getLeadingPaddingAndBorder(axis, widthSize) + node.getTrailingPaddingAndBorder(axis, widthSize)).unwrap();
	}

	public static YGAlign YGNodeAlignItem(YGNode node, YGNode child)
	{
	  final YGAlign align = child.getStyle().alignSelf() == YGAlign.YGAlignAuto ? node.getStyle().alignItems() : child.getStyle().alignSelf();
	  if (align == YGAlign.YGAlignBaseline && YGFlexDirectionIsColumn(node.getStyle().flexDirection()))
	  {
		return YGAlign.YGAlignFlexStart;
	  }
	  return align;
	}

	public static float YGBaseline(YGNode node, Object layoutContext)
	{
	  if (node.hasBaselineFunc())
	  {

		Event.<Event.NodeBaselineStart>publish(node);

		final float baseline = node.baseline(node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth], node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight], layoutContext);

		Event.<Event.NodeBaselineEnd>publish(node);

		YGAssertWithNode(node, !YGFloatIsUndefined(baseline), "Expect custom baseline function to not return NaN");
		return baseline;
	  }

	  YGNode baselineChild = null;
	  final Integer childCount = YGNodeGetChildCount(node);
	  for (Integer i = 0; i < childCount; i++)
	  {
		YGNode child = YGNodeGetChild(node, i);
		if (child.getLineIndex() > 0)
		{
		  break;
		}
		if (child.getStyle().positionType() == YGPositionType.YGPositionTypeAbsolute)
		{
		  continue;
		}
		if (YGNodeAlignItem(node, child) == YGAlign.YGAlignBaseline || child.isReferenceBaseline())
		{
		  baselineChild = child;
		  break;
		}

		if (baselineChild == null)
		{
		  baselineChild = child;
		}
	  }

	  if (baselineChild == null)
	  {
		return node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight];
	  }

	  final float baseline = YGBaseline(baselineChild, layoutContext);
	  return baseline + baselineChild.getLayout().position[(int)YGEdge.YGEdgeTop];
	}

	public static boolean YGIsBaselineLayout(YGNode node)
	{
	  if (YGFlexDirectionIsColumn(node.getStyle().flexDirection()))
	  {
		return false;
	  }
	  if (node.getStyle().alignItems() == YGAlign.YGAlignBaseline)
	  {
		return true;
	  }
	  final Integer childCount = YGNodeGetChildCount(node);
	  for (Integer i = 0; i < childCount; i++)
	  {
		YGNode child = YGNodeGetChild(node, i);
		if (child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute && child.getStyle().alignSelf() == YGAlign.YGAlignBaseline)
		{
		  return true;
		}
	  }

	  return false;
	}

	public static float YGNodeDimWithMargin(YGNode node, final YGFlexDirection axis, final float widthSize)
	{
	  return node.getLayout().measuredDimensions[dim[(int)axis]] + (node.getLeadingMargin(axis, widthSize) + node.getTrailingMargin(axis, widthSize)).unwrap();
	}

	public static boolean YGNodeIsStyleDimDefined(YGNode node, final YGFlexDirection axis, final float ownerSize)
	{
	  boolean isUndefined = YGFloatIsUndefined(node.getResolvedDimension(dim[(int)axis]).value);
	  return !(node.getResolvedDimension(dim[(int)axis]).unit == YGUnit.YGUnitAuto || node.getResolvedDimension(dim[(int)axis]).unit == YGUnit.YGUnitUndefined || (node.getResolvedDimension(dim[(int)axis]).unit == YGUnit.YGUnitPoint && !yoga.GlobalMembers.isUndefined && node.getResolvedDimension(dim[(int)axis]).value < 0.0f) || (node.getResolvedDimension(dim[(int)axis]).unit == YGUnit.YGUnitPercent && !yoga.GlobalMembers.isUndefined && (node.getResolvedDimension(dim[(int)axis]).value < 0.0f || YGFloatIsUndefined(ownerSize))));
	}

	public static boolean YGNodeIsLayoutDimDefined(YGNode node, final YGFlexDirection axis)
	{
	  final float value = node.getLayout().measuredDimensions[dim[(int)axis]];
	  return !YGFloatIsUndefined(value) && value >= 0.0f;
	}

	public static YGFloatOptional YGNodeBoundAxisWithinMinAndMax(YGNode node, final YGFlexDirection axis, final YGFloatOptional value, final float axisSize)
	{
	  YGFloatOptional min = new YGFloatOptional();
	  YGFloatOptional max = new YGFloatOptional();

	  if (YGFlexDirectionIsColumn(axis))
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: min = YGResolveValue(node->getStyle().minDimensions()[YGDimensionHeight], axisSize);
		min = (YGResolveValue(node.getStyle().minDimensions()[(int)YGDimension.YGDimensionHeight], axisSize));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: max = YGResolveValue(node->getStyle().maxDimensions()[YGDimensionHeight], axisSize);
		max = (YGResolveValue(node.getStyle().maxDimensions()[(int)YGDimension.YGDimensionHeight], axisSize));
	  }
	  else if (YGFlexDirectionIsRow(axis))
	  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: min = YGResolveValue(node->getStyle().minDimensions()[YGDimensionWidth], axisSize);
		min = (YGResolveValue(node.getStyle().minDimensions()[(int)YGDimension.YGDimensionWidth], axisSize));
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to be a copy assignment (rather than a reference assignment) - this should be verified and a 'copyFrom' method should be created:
//ORIGINAL LINE: max = YGResolveValue(node->getStyle().maxDimensions()[YGDimensionWidth], axisSize);
		max = (YGResolveValue(node.getStyle().maxDimensions()[(int)YGDimension.YGDimensionWidth], axisSize));
	  }

	  if (max >= YGFloatOptional((0)) && value > max)
	  {
		return new YGFloatOptional(max);
	  }

	  if (min >= YGFloatOptional((0)) && value < min)
	  {
		return new YGFloatOptional(min);
	  }

	  return new YGFloatOptional(value);
	}



	public static float YGNodeBoundAxis(YGNode node, final YGFlexDirection axis, final float value, final float axisSize, final float widthSize)
	{
	  return YGFloatMax(YGNodeBoundAxisWithinMinAndMax(node, axis, YGFloatOptional((value)), axisSize).unwrap(), YGNodePaddingAndBorderForAxis(node, axis, widthSize));
	}

	public static void YGNodeSetChildTrailingPosition(YGNode node, YGNode child, final YGFlexDirection axis)
	{
	  final float size = child.getLayout().measuredDimensions[dim[(int)axis]];
	  child.setLayoutPosition(node.getLayout().measuredDimensions[dim[(int)axis]] - size - child.getLayout().position[pos[(int)axis]], trailing[(int)axis]);
	}

	public static void YGConstrainMaxSizeForMode(YGNode node, final YGFlexDirection axis, final float ownerAxisSize, final float ownerWidth, YGMeasureMode mode, tangible.RefObject<Float> size)
	{
	  final YGFloatOptional maxSize = YGResolveValue(node.getStyle().maxDimensions()[dim[(int)axis]], ownerAxisSize) + YGFloatOptional(node.getMarginForAxis(axis, ownerWidth));
	  switch (mode)
	  {
		case YGMeasureModeExactly:
		case YGMeasureModeAtMost:
		  size.argValue = (maxSize.isUndefined() || size.argValue < maxSize.unwrap()) ? size.argValue : maxSize.unwrap();
		  break;
		case YGMeasureModeUndefined:
		  if (!maxSize.isUndefined())
		  {
			mode = YGMeasureMode.YGMeasureModeAtMost;
			size.argValue = maxSize.unwrap();
		  }
		  break;
	  }
	}

	public static void YGNodeComputeFlexBasisForChild(YGNode node, YGNode child, final float width, final YGMeasureMode widthMode, final float height, final float ownerWidth, final float ownerHeight, final YGMeasureMode heightMode, final YGDirection direction, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount)
	{
	  final YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), direction);
	  final boolean isMainAxisRow = YGFlexDirectionIsRow(mainAxis);
	  final float mainAxisSize = isMainAxisRow ? width : height;
	  final float mainAxisownerSize = isMainAxisRow ? ownerWidth : ownerHeight;

	  float childWidth;
	  float childHeight;
	  YGMeasureMode childWidthMeasureMode;
	  YGMeasureMode childHeightMeasureMode;

	  final YGFloatOptional resolvedFlexBasis = YGResolveValue(child.resolveFlexBasisPtr(), mainAxisownerSize);
	  final boolean isRowStyleDimDefined = YGNodeIsStyleDimDefined(child, YGFlexDirection.YGFlexDirectionRow, ownerWidth);
	  final boolean isColumnStyleDimDefined = YGNodeIsStyleDimDefined(child, YGFlexDirection.YGFlexDirectionColumn, ownerHeight);

	  if (!resolvedFlexBasis.isUndefined() && !YGFloatIsUndefined(mainAxisSize))
	  {
		if (child.getLayout().computedFlexBasis.isUndefined() || (YGConfigIsExperimentalFeatureEnabled(child.getConfig(), YGExperimentalFeature.YGExperimentalFeatureWebFlexBasis) && child.getLayout().computedFlexBasisGeneration != generationCount))
		{
		  final YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, mainAxis, ownerWidth));
		  child.setLayoutComputedFlexBasis(YGFloatOptionalMax(new YGFloatOptional(resolvedFlexBasis), new YGFloatOptional(paddingAndBorder)));
		}
	  }
	  else if (isMainAxisRow && isRowStyleDimDefined)
	  {

		final YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, YGFlexDirection.YGFlexDirectionRow, ownerWidth));

		child.setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionWidth], ownerWidth), new YGFloatOptional(paddingAndBorder)));
	  }
	  else if (!isMainAxisRow && isColumnStyleDimDefined)
	  {

		final YGFloatOptional paddingAndBorder = new YGFloatOptional(YGNodePaddingAndBorderForAxis(child, YGFlexDirection.YGFlexDirectionColumn, ownerWidth));
		child.setLayoutComputedFlexBasis(YGFloatOptionalMax(YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionHeight], ownerHeight), new YGFloatOptional(paddingAndBorder)));
	  }
	  else
	  {


		childWidth = YGUndefined;
		childHeight = YGUndefined;
		childWidthMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
		childHeightMeasureMode = YGMeasureMode.YGMeasureModeUndefined;

		var marginRow = child.getMarginForAxis(YGFlexDirection.YGFlexDirectionRow, ownerWidth).unwrap();
		var marginColumn = child.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, ownerWidth).unwrap();

		if (isRowStyleDimDefined)
		{
		  childWidth = YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionWidth], ownerWidth).unwrap() + marginRow;
		  childWidthMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		}
		if (isColumnStyleDimDefined)
		{
		  childHeight = YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionHeight], ownerHeight).unwrap() + marginColumn;
		  childHeightMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		}



		if ((!isMainAxisRow && node.getStyle().overflow() == YGOverflow.YGOverflowScroll) || node.getStyle().overflow() != YGOverflow.YGOverflowScroll)
		{
		  if (YGFloatIsUndefined(childWidth) && !YGFloatIsUndefined(width))
		  {
			childWidth = width;
			childWidthMeasureMode = YGMeasureMode.YGMeasureModeAtMost;
		  }
		}

		if ((isMainAxisRow && node.getStyle().overflow() == YGOverflow.YGOverflowScroll) || node.getStyle().overflow() != YGOverflow.YGOverflowScroll)
		{
		  if (YGFloatIsUndefined(childHeight) && !YGFloatIsUndefined(height))
		  {
			childHeight = height;
			childHeightMeasureMode = YGMeasureMode.YGMeasureModeAtMost;
		  }
		}

		final var childStyle = child.getStyle();
		if (!childStyle.aspectRatio().isUndefined())
		{
		  if (!isMainAxisRow && childWidthMeasureMode == YGMeasureMode.YGMeasureModeExactly)
		  {
			childHeight = marginColumn + (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
			childHeightMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		  }
		  else if (isMainAxisRow && childHeightMeasureMode == YGMeasureMode.YGMeasureModeExactly)
		  {
			childWidth = marginRow + (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
			childWidthMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		  }
		}




		final boolean hasExactWidth = !YGFloatIsUndefined(width) && widthMode == YGMeasureMode.YGMeasureModeExactly;
		final boolean childWidthStretch = YGNodeAlignItem(node, child) == YGAlign.YGAlignStretch && childWidthMeasureMode != YGMeasureMode.YGMeasureModeExactly;
		if (!isMainAxisRow && !isRowStyleDimDefined && hasExactWidth && childWidthStretch)
		{
		  childWidth = width;
		  childWidthMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		  if (!childStyle.aspectRatio().isUndefined())
		  {
			childHeight = (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
			childHeightMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		  }
		}

		final boolean hasExactHeight = !YGFloatIsUndefined(height) && heightMode == YGMeasureMode.YGMeasureModeExactly;
		final boolean childHeightStretch = YGNodeAlignItem(node, child) == YGAlign.YGAlignStretch && childHeightMeasureMode != YGMeasureMode.YGMeasureModeExactly;
		if (isMainAxisRow && !isColumnStyleDimDefined && hasExactHeight && childHeightStretch)
		{
		  childHeight = height;
		  childHeightMeasureMode = YGMeasureMode.YGMeasureModeExactly;

		  if (!childStyle.aspectRatio().isUndefined())
		  {
			childWidth = (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
			childWidthMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		  }
		}

		YGConstrainMaxSizeForMode(child, YGFlexDirection.YGFlexDirectionRow, ownerWidth, ownerWidth, childWidthMeasureMode, childWidth);
		YGConstrainMaxSizeForMode(child, YGFlexDirection.YGFlexDirectionColumn, ownerHeight, ownerWidth, childHeightMeasureMode, childHeight);


		YGLayoutNodeInternal(child, childWidth, childHeight, direction, childWidthMeasureMode, childHeightMeasureMode, ownerWidth, ownerHeight, false, LayoutPassReason.kMeasureChild, config, layoutMarkerData, layoutContext, depth, generationCount);

		child.setLayoutComputedFlexBasis(YGFloatOptional(YGFloatMax(child.getLayout().measuredDimensions[dim[(int)mainAxis]], YGNodePaddingAndBorderForAxis(child, mainAxis, ownerWidth))));
	  }
	  child.setLayoutComputedFlexBasisGeneration(generationCount);
	}

	public static void YGNodeAbsoluteLayoutChild(YGNode node, YGNode child, final float width, final YGMeasureMode widthMode, final float height, final YGDirection direction, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount)
	{
	  final YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), direction);
	  final YGFlexDirection crossAxis = YGFlexDirectionCross(mainAxis, direction);
	  final boolean isMainAxisRow = YGFlexDirectionIsRow(mainAxis);

	  float childWidth = YGUndefined;
	  float childHeight = YGUndefined;
	  YGMeasureMode childWidthMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
	  YGMeasureMode childHeightMeasureMode = YGMeasureMode.YGMeasureModeUndefined;

	  var marginRow = child.getMarginForAxis(YGFlexDirection.YGFlexDirectionRow, width).unwrap();
	  var marginColumn = child.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, width).unwrap();

	  if (YGNodeIsStyleDimDefined(child, YGFlexDirection.YGFlexDirectionRow, width))
	  {
		childWidth = YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionWidth], width).unwrap() + marginRow;
	  }
	  else
	  {


		if (child.isLeadingPositionDefined(YGFlexDirection.YGFlexDirectionRow) && child.isTrailingPosDefined(YGFlexDirection.YGFlexDirectionRow))
		{
		  childWidth = node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth] - (node.getLeadingBorder(YGFlexDirection.YGFlexDirectionRow) + node.getTrailingBorder(YGFlexDirection.YGFlexDirectionRow)) - (child.getLeadingPosition(YGFlexDirection.YGFlexDirectionRow, width) + child.getTrailingPosition(YGFlexDirection.YGFlexDirectionRow, width)).unwrap();
		  childWidth = YGNodeBoundAxis(child, YGFlexDirection.YGFlexDirectionRow, childWidth, width, width);
		}
	  }

	  if (YGNodeIsStyleDimDefined(child, YGFlexDirection.YGFlexDirectionColumn, height))
	  {
		childHeight = YGResolveValue(child.getResolvedDimensions [(int)YGDimension.YGDimensionHeight], height).unwrap() + marginColumn;
	  }
	  else
	  {


		if (child.isLeadingPositionDefined(YGFlexDirection.YGFlexDirectionColumn) && child.isTrailingPosDefined(YGFlexDirection.YGFlexDirectionColumn))
		{
		  childHeight = node.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight] - (node.getLeadingBorder(YGFlexDirection.YGFlexDirectionColumn) + node.getTrailingBorder(YGFlexDirection.YGFlexDirectionColumn)) - (child.getLeadingPosition(YGFlexDirection.YGFlexDirectionColumn, height) + child.getTrailingPosition(YGFlexDirection.YGFlexDirectionColumn, height)).unwrap();
		  childHeight = YGNodeBoundAxis(child, YGFlexDirection.YGFlexDirectionColumn, childHeight, height, width);
		}
	  }




	  final var childStyle = child.getStyle();
	  if (YGFloatIsUndefined(childWidth) ^ YGFloatIsUndefined(childHeight))
	  {
		if (!childStyle.aspectRatio().isUndefined())
		{
		  if (YGFloatIsUndefined(childWidth))
		  {
			childWidth = marginRow + (childHeight - marginColumn) * childStyle.aspectRatio().unwrap();
		  }
		  else if (YGFloatIsUndefined(childHeight))
		  {
			childHeight = marginColumn + (childWidth - marginRow) / childStyle.aspectRatio().unwrap();
		  }
		}
	  }


	  if (YGFloatIsUndefined(childWidth) || YGFloatIsUndefined(childHeight))
	  {
		childWidthMeasureMode = YGFloatIsUndefined(childWidth) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;
		childHeightMeasureMode = YGFloatIsUndefined(childHeight) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;





		if (!isMainAxisRow && YGFloatIsUndefined(childWidth) && widthMode != YGMeasureMode.YGMeasureModeUndefined && !YGFloatIsUndefined(width) && width > 0F)
		{
		  childWidth = width;
		  childWidthMeasureMode = YGMeasureMode.YGMeasureModeAtMost;
		}

		YGLayoutNodeInternal(child, childWidth, childHeight, direction, childWidthMeasureMode, childHeightMeasureMode, childWidth, childHeight, false, LayoutPassReason.kAbsMeasureChild, config, layoutMarkerData, layoutContext, depth, generationCount);
		childWidth = child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth] + child.getMarginForAxis(YGFlexDirection.YGFlexDirectionRow, width).unwrap();
		childHeight = child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight] + child.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, width).unwrap();
	  }

	  YGLayoutNodeInternal(child, childWidth, childHeight, direction, YGMeasureMode.YGMeasureModeExactly, YGMeasureMode.YGMeasureModeExactly, childWidth, childHeight, true, LayoutPassReason.kAbsLayout, config, layoutMarkerData, layoutContext, depth, generationCount);

	  if (child.isTrailingPosDefined(mainAxis) && !child.isLeadingPositionDefined(mainAxis))
	  {
		child.setLayoutPosition(node.getLayout().measuredDimensions[dim[(int)mainAxis]] - child.getLayout().measuredDimensions[dim[(int)mainAxis]] - node.getTrailingBorder(mainAxis) - child.getTrailingMargin(mainAxis, width).unwrap() - child.getTrailingPosition(mainAxis, isMainAxisRow ? width : height).unwrap(), leading[(int)mainAxis]);
	  }
	  else if (!child.isLeadingPositionDefined(mainAxis) && node.getStyle().justifyContent() == YGJustify.YGJustifyCenter)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions[dim[(int)mainAxis]] - child.getLayout().measuredDimensions[dim[(int)mainAxis]]) / 2.0f, leading[(int)mainAxis]);
	  }
	  else if (!child.isLeadingPositionDefined(mainAxis) && node.getStyle().justifyContent() == YGJustify.YGJustifyFlexEnd)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions[dim[(int)mainAxis]] - child.getLayout().measuredDimensions[dim[(int)mainAxis]]), leading[(int)mainAxis]);
	  }

	  if (child.isTrailingPosDefined(crossAxis) && !child.isLeadingPositionDefined(crossAxis))
	  {
		child.setLayoutPosition(node.getLayout().measuredDimensions[dim[(int)crossAxis]] - child.getLayout().measuredDimensions[dim[(int)crossAxis]] - node.getTrailingBorder(crossAxis) - child.getTrailingMargin(crossAxis, width).unwrap() - child.getTrailingPosition(crossAxis, isMainAxisRow ? height : width).unwrap(), leading[(int)crossAxis]);

	  }
	  else if (!child.isLeadingPositionDefined(crossAxis) && YGNodeAlignItem(node, child) == YGAlign.YGAlignCenter)
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions[dim[(int)crossAxis]] - child.getLayout().measuredDimensions[dim[(int)crossAxis]]) / 2.0f, leading[(int)crossAxis]);
	  }
	  else if (!child.isLeadingPositionDefined(crossAxis) && ((YGNodeAlignItem(node, child) == YGAlign.YGAlignFlexEnd) ^ (node.getStyle().flexWrap() == YGWrap.YGWrapWrapReverse)))
	  {
		child.setLayoutPosition((node.getLayout().measuredDimensions[dim[(int)crossAxis]] - child.getLayout().measuredDimensions[dim[(int)crossAxis]]), leading[(int)crossAxis]);
	  }
	}

	public static void YGNodeWithMeasureFuncSetMeasuredDimensions(YGNode node, float availableWidth, float availableHeight, final YGMeasureMode widthMeasureMode, final YGMeasureMode heightMeasureMode, final float ownerWidth, final float ownerHeight, LayoutData layoutMarkerData, final Object layoutContext, final LayoutPassReason reason)
	{
	  YGAssertWithNode(node, node.hasMeasureFunc(), "Expected node to have custom measure function");

	  if (widthMeasureMode == YGMeasureMode.YGMeasureModeUndefined)
	  {
		availableWidth = YGUndefined;
	  }
	  if (heightMeasureMode == YGMeasureMode.YGMeasureModeUndefined)
	  {
		availableHeight = YGUndefined;
	  }

	  final var padding = node.getLayout().padding;
	  final var border = node.getLayout().border;
	  final float paddingAndBorderAxisRow = padding[(int)YGEdge.YGEdgeLeft] + padding[(int)YGEdge.YGEdgeRight] + border[(int)YGEdge.YGEdgeLeft] + border[(int)YGEdge.YGEdgeRight];
	  final float paddingAndBorderAxisColumn = padding[(int)YGEdge.YGEdgeTop] + padding[(int)YGEdge.YGEdgeBottom] + border[(int)YGEdge.YGEdgeTop] + border[(int)YGEdge.YGEdgeBottom];


	  final float innerWidth = YGFloatIsUndefined(availableWidth) ? availableWidth : YGFloatMax(0F, availableWidth - paddingAndBorderAxisRow);
	  final float innerHeight = YGFloatIsUndefined(availableHeight) ? availableHeight : YGFloatMax(0F, availableHeight - paddingAndBorderAxisColumn);

	  if (widthMeasureMode == YGMeasureMode.YGMeasureModeExactly && heightMeasureMode == YGMeasureMode.YGMeasureModeExactly)
	  {

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionRow, availableWidth, ownerWidth, ownerWidth), YGDimension.YGDimensionWidth);
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionColumn, availableHeight, ownerHeight, ownerWidth), YGDimension.YGDimensionHeight);
	  }
	  else
	  {
		Event.<Event.MeasureCallbackStart>publish(node);


		final YGSize measuredSize = node.measure(innerWidth, widthMeasureMode, innerHeight, heightMeasureMode, layoutContext);

		layoutMarkerData.measureCallbacks += 1;
		layoutMarkerData.measureCallbackReasonsCount[(Integer)reason] += 1;

		Event.<Event.MeasureCallbackEnd>publish(node, {layoutContext, innerWidth, widthMeasureMode, innerHeight, heightMeasureMode, measuredSize.width, measuredSize.height, reason});

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionRow, (widthMeasureMode == YGMeasureMode.YGMeasureModeUndefined || widthMeasureMode == YGMeasureMode.YGMeasureModeAtMost) ? measuredSize.width + paddingAndBorderAxisRow : availableWidth, ownerWidth, ownerWidth), YGDimension.YGDimensionWidth);

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionColumn, (heightMeasureMode == YGMeasureMode.YGMeasureModeUndefined || heightMeasureMode == YGMeasureMode.YGMeasureModeAtMost) ? measuredSize.height + paddingAndBorderAxisColumn : availableHeight, ownerHeight, ownerWidth), YGDimension.YGDimensionHeight);
	  }
	}



	public static void YGNodeEmptyContainerSetMeasuredDimensions(YGNode node, final float availableWidth, final float availableHeight, final YGMeasureMode widthMeasureMode, final YGMeasureMode heightMeasureMode, final float ownerWidth, final float ownerHeight)
	{
	  final var padding = node.getLayout().padding;
	  final var border = node.getLayout().border;

	  float width = availableWidth;
	  if (widthMeasureMode == YGMeasureMode.YGMeasureModeUndefined || widthMeasureMode == YGMeasureMode.YGMeasureModeAtMost)
	  {
		width = padding[(int)YGEdge.YGEdgeLeft] + padding[(int)YGEdge.YGEdgeRight] + border[(int)YGEdge.YGEdgeLeft] + border[(int)YGEdge.YGEdgeRight];
	  }
	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionRow, width, ownerWidth, ownerWidth), YGDimension.YGDimensionWidth);

	  float height = availableHeight;
	  if (heightMeasureMode == YGMeasureMode.YGMeasureModeUndefined || heightMeasureMode == YGMeasureMode.YGMeasureModeAtMost)
	  {
		height = padding[(int)YGEdge.YGEdgeTop] + padding[(int)YGEdge.YGEdgeBottom] + border[(int)YGEdge.YGEdgeTop] + border[(int)YGEdge.YGEdgeBottom];
	  }
	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionColumn, height, ownerHeight, ownerWidth), YGDimension.YGDimensionHeight);
	}

	public static boolean YGNodeFixedSizeSetMeasuredDimensions(YGNode node, final float availableWidth, final float availableHeight, final YGMeasureMode widthMeasureMode, final YGMeasureMode heightMeasureMode, final float ownerWidth, final float ownerHeight)
	{
	  if ((!YGFloatIsUndefined(availableWidth) && widthMeasureMode == YGMeasureMode.YGMeasureModeAtMost && availableWidth <= 0.0f) || (!YGFloatIsUndefined(availableHeight) && heightMeasureMode == YGMeasureMode.YGMeasureModeAtMost && availableHeight <= 0.0f) || (widthMeasureMode == YGMeasureMode.YGMeasureModeExactly && heightMeasureMode == YGMeasureMode.YGMeasureModeExactly))
	  {
		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionRow, YGFloatIsUndefined(availableWidth) || (widthMeasureMode == YGMeasureMode.YGMeasureModeAtMost && availableWidth < 0.0f) ? 0.0f : availableWidth, ownerWidth, ownerWidth), YGDimension.YGDimensionWidth);

		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionColumn, YGFloatIsUndefined(availableHeight) || (heightMeasureMode == YGMeasureMode.YGMeasureModeAtMost && availableHeight < 0.0f) ? 0.0f : availableHeight, ownerHeight, ownerWidth), YGDimension.YGDimensionHeight);
		return true;
	  }

	  return false;
	}

	public static void YGZeroOutLayoutRecursivly(YGNode node, Object layoutContext)
	{
	  node.getLayout() = {};
	  node.setLayoutDimension(0, 0);
	  node.setLayoutDimension(0, 1);
	  node.setHasNewLayout(true);

	  node.iterChildrenAfterCloningIfNeeded(YGZeroOutLayoutRecursivly, layoutContext);
	}

	public static float YGNodeCalculateAvailableInnerDim(YGNode node, final YGDimension dimension, final float availableDim, final float paddingAndBorder, final float ownerDim)
	{
	  float availableInnerDim = availableDim - paddingAndBorder;


	  if (!YGFloatIsUndefined(availableInnerDim))
	  {


		final YGFloatOptional minDimensionOptional = YGResolveValue(node.getStyle().minDimensions()[(int)dimension], ownerDim);
		final float minInnerDim = minDimensionOptional.isUndefined() ? 0.0f : minDimensionOptional.unwrap() - paddingAndBorder;

		final YGFloatOptional maxDimensionOptional = YGResolveValue(node.getStyle().maxDimensions()[(int)dimension], ownerDim);

		final float maxInnerDim = maxDimensionOptional.isUndefined() ? Float.MAX_VALUE : maxDimensionOptional.unwrap() - paddingAndBorder;
		availableInnerDim = YGFloatMax(YGFloatMin(availableInnerDim, maxInnerDim), minInnerDim);
	  }

	  return availableInnerDim;
	}

	public static float YGNodeComputeFlexBasisForChildren(YGNode node, final float availableInnerWidth, final float availableInnerHeight, YGMeasureMode widthMeasureMode, YGMeasureMode heightMeasureMode, YGDirection direction, YGFlexDirection mainAxis, YGConfig config, boolean performLayout, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount)
	{
	  float totalOuterFlexBasis = 0.0f;
	  YGNode singleFlexChild = null;
	  ArrayList<YGNode> children = node.getChildren();
	  YGMeasureMode measureModeMainDim = YGFlexDirectionIsRow(mainAxis) ? widthMeasureMode : heightMeasureMode;



	  if (measureModeMainDim == YGMeasureMode.YGMeasureModeExactly)
	  {
		for (var child : children)
		{
		  if (child.isNodeFlexible())
		  {
			if (singleFlexChild != null || YGFloatsEqual(child.resolveFlexGrow(), 0.0f) || YGFloatsEqual(child.resolveFlexShrink(), 0.0f))
			{


			  singleFlexChild = null;
			  break;
			}
			else
			{
			  singleFlexChild = child;
			}
		  }
		}
	  }

	  for (var child : children)
	  {
		child.resolveDimension();
		if (child.getStyle().display() == YGDisplay.YGDisplayNone)
		{
		  YGZeroOutLayoutRecursivly(child, layoutContext);
		  child.setHasNewLayout(true);
		  child.setDirty(false);
		  continue;
		}
		if (performLayout)
		{

		  final YGDirection childDirection = child.resolveDirection(direction);
		  final float mainDim = YGFlexDirectionIsRow(mainAxis) ? availableInnerWidth : availableInnerHeight;
		  final float crossDim = YGFlexDirectionIsRow(mainAxis) ? availableInnerHeight : availableInnerWidth;
		  child.setPosition(childDirection, mainDim, crossDim, availableInnerWidth);
		}

		if (child.getStyle().positionType() == YGPositionType.YGPositionTypeAbsolute)
		{
		  continue;
		}
		if (child == singleFlexChild)
		{
		  child.setLayoutComputedFlexBasisGeneration(generationCount);
		  child.setLayoutComputedFlexBasis(YGFloatOptional(0));
		}
		else
		{
		  YGNodeComputeFlexBasisForChild(node, child, availableInnerWidth, widthMeasureMode, availableInnerHeight, availableInnerWidth, availableInnerHeight, heightMeasureMode, direction, config, layoutMarkerData, layoutContext, depth, generationCount);
		}

		totalOuterFlexBasis += (child.getLayout().computedFlexBasis + child.getMarginForAxis(mainAxis, availableInnerWidth)).unwrap();
	  }

	  return totalOuterFlexBasis;
	}





	public static YGCollectFlexItemsRowValues YGCalculateCollectFlexItemsRowValues(YGNode node, final YGDirection ownerDirection, final float mainAxisownerSize, final float availableInnerWidth, final float availableInnerMainDim, final Integer startOfLineIndex, final Integer lineCount)
	{
	  YGCollectFlexItemsRowValues flexAlgoRowMeasurement = new YGCollectFlexItemsRowValues();
	  flexAlgoRowMeasurement.relativeChildren.ensureCapacity(node.getChildren().size());

	  float sizeConsumedOnCurrentLineIncludingMinConstraint = 0F;
	  final YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), node.resolveDirection(ownerDirection));
	  final boolean isNodeFlexWrap = node.getStyle().flexWrap() != YGWrap.YGWrapNoWrap;


	  Integer endOfLineIndex = startOfLineIndex;
	  for (; endOfLineIndex < node.getChildren().size(); endOfLineIndex++)
	  {
		YGNode child = node.getChild(endOfLineIndex);
		if (child.getStyle().display() == YGDisplay.YGDisplayNone || child.getStyle().positionType() == YGPositionType.YGPositionTypeAbsolute)
		{
		  continue;
		}
		child.setLineIndex(lineCount);
		final float childMarginMainAxis = child.getMarginForAxis(mainAxis, availableInnerWidth).unwrap();
		final float flexBasisWithMinAndMaxConstraints = YGNodeBoundAxisWithinMinAndMax(child, mainAxis, child.getLayout().computedFlexBasis, mainAxisownerSize).unwrap();




		if (sizeConsumedOnCurrentLineIncludingMinConstraint + flexBasisWithMinAndMaxConstraints + childMarginMainAxis > availableInnerMainDim && isNodeFlexWrap && flexAlgoRowMeasurement.itemsOnLine > 0)
		{
		  break;
		}

		sizeConsumedOnCurrentLineIncludingMinConstraint += flexBasisWithMinAndMaxConstraints + childMarginMainAxis;
		flexAlgoRowMeasurement.sizeConsumedOnCurrentLine += flexBasisWithMinAndMaxConstraints + childMarginMainAxis;
		flexAlgoRowMeasurement.itemsOnLine++;

		if (child.isNodeFlexible())
		{
		  flexAlgoRowMeasurement.totalFlexGrowFactors += child.resolveFlexGrow();



		  flexAlgoRowMeasurement.totalFlexShrinkScaledFactors += -child.resolveFlexShrink() * child.getLayout().computedFlexBasis.unwrap();
		}

		flexAlgoRowMeasurement.relativeChildren.add(child);
	  }


	  if (flexAlgoRowMeasurement.totalFlexGrowFactors > 0F && flexAlgoRowMeasurement.totalFlexGrowFactors < 1F)
	  {
		flexAlgoRowMeasurement.totalFlexGrowFactors = 1F;
	  }


	  if (flexAlgoRowMeasurement.totalFlexShrinkScaledFactors > 0F && flexAlgoRowMeasurement.totalFlexShrinkScaledFactors < 1F)
	  {
		flexAlgoRowMeasurement.totalFlexShrinkScaledFactors = 1F;
	  }
	  flexAlgoRowMeasurement.endOfLineIndex = endOfLineIndex;
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return flexAlgoRowMeasurement;
	  return new YGCollectFlexItemsRowValues(flexAlgoRowMeasurement);
	}





	public static float YGDistributeFreeSpaceSecondPass(YGCollectFlexItemsRowValues collectedFlexItemsValues, YGNode node, final YGFlexDirection mainAxis, final YGFlexDirection crossAxis, final float mainAxisownerSize, final float availableInnerMainDim, final float availableInnerCrossDim, final float availableInnerWidth, final float availableInnerHeight, final boolean flexBasisOverflows, final YGMeasureMode measureModeCrossDim, final boolean performLayout, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount)
	{
	  float childFlexBasis = 0F;
	  float flexShrinkScaledFactor = 0F;
	  float flexGrowFactor = 0F;
	  float deltaFreeSpace = 0F;
	  final boolean isMainAxisRow = YGFlexDirectionIsRow(mainAxis);
	  final boolean isNodeFlexWrap = node.getStyle().flexWrap() != YGWrap.YGWrapNoWrap;

	  for (var currentRelativeChild : collectedFlexItemsValues.relativeChildren)
	  {
		childFlexBasis = YGNodeBoundAxisWithinMinAndMax(currentRelativeChild, mainAxis, currentRelativeChild.getLayout().computedFlexBasis, mainAxisownerSize).unwrap();
		float updatedMainSize = childFlexBasis;

		if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace < 0F)
		{
		  flexShrinkScaledFactor = -currentRelativeChild.resolveFlexShrink() * childFlexBasis;

		  if (flexShrinkScaledFactor != 0F)
		  {
			float childSize;

			if (!YGFloatIsUndefined(collectedFlexItemsValues.totalFlexShrinkScaledFactors) && collectedFlexItemsValues.totalFlexShrinkScaledFactors == 0F)
			{
			  childSize = childFlexBasis + flexShrinkScaledFactor;
			}
			else
			{
			  childSize = childFlexBasis + (collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexShrinkScaledFactors) * flexShrinkScaledFactor;
			}

			updatedMainSize = YGNodeBoundAxis(currentRelativeChild, mainAxis, childSize, availableInnerMainDim, availableInnerWidth);
		  }
		}
		else if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace > 0F)
		{
		  flexGrowFactor = currentRelativeChild.resolveFlexGrow();


		  if (!YGFloatIsUndefined(flexGrowFactor) && flexGrowFactor != 0F)
		  {
			updatedMainSize = YGNodeBoundAxis(currentRelativeChild, mainAxis, childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexGrowFactors * flexGrowFactor, availableInnerMainDim, availableInnerWidth);
		  }
		}

		deltaFreeSpace += updatedMainSize - childFlexBasis;

		final float marginMain = currentRelativeChild.getMarginForAxis(mainAxis, availableInnerWidth).unwrap();
		final float marginCross = currentRelativeChild.getMarginForAxis(crossAxis, availableInnerWidth).unwrap();

		float childCrossSize;
		float childMainSize = updatedMainSize + marginMain;
		YGMeasureMode childCrossMeasureMode;
		YGMeasureMode childMainMeasureMode = YGMeasureMode.YGMeasureModeExactly;

		final var childStyle = currentRelativeChild.getStyle();
		if (!childStyle.aspectRatio().isUndefined())
		{
		  childCrossSize = isMainAxisRow ? (childMainSize - marginMain) / childStyle.aspectRatio().unwrap() : (childMainSize - marginMain) * childStyle.aspectRatio().unwrap();
		  childCrossMeasureMode = YGMeasureMode.YGMeasureModeExactly;

		  childCrossSize += marginCross;
		}
		else if (!YGFloatIsUndefined(availableInnerCrossDim) && !YGNodeIsStyleDimDefined(currentRelativeChild, crossAxis, availableInnerCrossDim) && measureModeCrossDim == YGMeasureMode.YGMeasureModeExactly && !(isNodeFlexWrap && flexBasisOverflows) && YGNodeAlignItem(node, currentRelativeChild) == YGAlign.YGAlignStretch && currentRelativeChild.marginLeadingValue(crossAxis).unit != YGUnit.YGUnitAuto && currentRelativeChild.marginTrailingValue(crossAxis).unit != YGUnit.YGUnitAuto)
		{
		  childCrossSize = availableInnerCrossDim;
		  childCrossMeasureMode = YGMeasureMode.YGMeasureModeExactly;
		}
		else if (!YGNodeIsStyleDimDefined(currentRelativeChild, crossAxis, availableInnerCrossDim))
		{
		  childCrossSize = availableInnerCrossDim;
		  childCrossMeasureMode = YGFloatIsUndefined(childCrossSize) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeAtMost;
		}
		else
		{
		  childCrossSize = YGResolveValue(currentRelativeChild.getResolvedDimension(dim[(int)crossAxis]), availableInnerCrossDim).unwrap() + marginCross;
		  final boolean isLoosePercentageMeasurement = currentRelativeChild.getResolvedDimension(dim[(int)crossAxis]).unit == YGUnit.YGUnitPercent && measureModeCrossDim != YGMeasureMode.YGMeasureModeExactly;
		  childCrossMeasureMode = YGFloatIsUndefined(childCrossSize) || isLoosePercentageMeasurement ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;
		}

		YGConstrainMaxSizeForMode(currentRelativeChild, mainAxis, availableInnerMainDim, availableInnerWidth, childMainMeasureMode, childMainSize);
		YGConstrainMaxSizeForMode(currentRelativeChild, crossAxis, availableInnerCrossDim, availableInnerWidth, childCrossMeasureMode, childCrossSize);

		final boolean requiresStretchLayout = !YGNodeIsStyleDimDefined(currentRelativeChild, crossAxis, availableInnerCrossDim) && YGNodeAlignItem(node, currentRelativeChild) == YGAlign.YGAlignStretch && currentRelativeChild.marginLeadingValue(crossAxis).unit != YGUnit.YGUnitAuto && currentRelativeChild.marginTrailingValue(crossAxis).unit != YGUnit.YGUnitAuto;

		final float childWidth = isMainAxisRow ? childMainSize : childCrossSize;
		final float childHeight = !isMainAxisRow ? childMainSize : childCrossSize;

		final YGMeasureMode childWidthMeasureMode = isMainAxisRow ? childMainMeasureMode : childCrossMeasureMode;
		final YGMeasureMode childHeightMeasureMode = !isMainAxisRow ? childMainMeasureMode : childCrossMeasureMode;

		final boolean isLayoutPass = performLayout && !requiresStretchLayout;


		YGLayoutNodeInternal(currentRelativeChild, childWidth, childHeight, node.getLayout().direction(), childWidthMeasureMode, childHeightMeasureMode, availableInnerWidth, availableInnerHeight, isLayoutPass, isLayoutPass ? LayoutPassReason.kFlexLayout : LayoutPassReason.kFlexMeasure, config, layoutMarkerData, layoutContext, depth, generationCount);
		node.setLayoutHadOverflow(node.getLayout().hadOverflow() | currentRelativeChild.getLayout().hadOverflow());
	  }
	  return deltaFreeSpace;
	}




	public static void YGDistributeFreeSpaceFirstPass(YGCollectFlexItemsRowValues collectedFlexItemsValues, final YGFlexDirection mainAxis, final float mainAxisownerSize, final float availableInnerMainDim, final float availableInnerWidth)
	{
	  float flexShrinkScaledFactor = 0F;
	  float flexGrowFactor = 0F;
	  float baseMainSize = 0F;
	  float boundMainSize = 0F;
	  float deltaFreeSpace = 0F;

	  for (var currentRelativeChild : collectedFlexItemsValues.relativeChildren)
	  {
		float childFlexBasis = YGNodeBoundAxisWithinMinAndMax(currentRelativeChild, mainAxis, currentRelativeChild.getLayout().computedFlexBasis, mainAxisownerSize).unwrap();

		if (collectedFlexItemsValues.remainingFreeSpace < 0F)
		{
		  flexShrinkScaledFactor = -currentRelativeChild.resolveFlexShrink() * childFlexBasis;


		  if (!YGFloatIsUndefined(flexShrinkScaledFactor) && flexShrinkScaledFactor != 0F)
		  {
			baseMainSize = childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexShrinkScaledFactors * flexShrinkScaledFactor;
			boundMainSize = YGNodeBoundAxis(currentRelativeChild, mainAxis, baseMainSize, availableInnerMainDim, availableInnerWidth);
			if (!YGFloatIsUndefined(baseMainSize) && !YGFloatIsUndefined(boundMainSize) && baseMainSize != boundMainSize)
			{




			  deltaFreeSpace += boundMainSize - childFlexBasis;
			  collectedFlexItemsValues.totalFlexShrinkScaledFactors -= (-currentRelativeChild.resolveFlexShrink() * currentRelativeChild.getLayout().computedFlexBasis.unwrap());
			}
		  }
		}
		else if (!YGFloatIsUndefined(collectedFlexItemsValues.remainingFreeSpace) && collectedFlexItemsValues.remainingFreeSpace > 0F)
		{
		  flexGrowFactor = currentRelativeChild.resolveFlexGrow();


		  if (!YGFloatIsUndefined(flexGrowFactor) && flexGrowFactor != 0F)
		  {
			baseMainSize = childFlexBasis + collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.totalFlexGrowFactors * flexGrowFactor;
			boundMainSize = YGNodeBoundAxis(currentRelativeChild, mainAxis, baseMainSize, availableInnerMainDim, availableInnerWidth);

			if (!YGFloatIsUndefined(baseMainSize) && !YGFloatIsUndefined(boundMainSize) && baseMainSize != boundMainSize)
			{




			  deltaFreeSpace += boundMainSize - childFlexBasis;
			  collectedFlexItemsValues.totalFlexGrowFactors -= flexGrowFactor;
			}
		  }
		}
	  }
	  collectedFlexItemsValues.remainingFreeSpace -= deltaFreeSpace;
	}
	public static void YGResolveFlexibleLength(YGNode node, YGCollectFlexItemsRowValues collectedFlexItemsValues, final YGFlexDirection mainAxis, final YGFlexDirection crossAxis, final float mainAxisownerSize, final float availableInnerMainDim, final float availableInnerCrossDim, final float availableInnerWidth, final float availableInnerHeight, final boolean flexBasisOverflows, final YGMeasureMode measureModeCrossDim, final boolean performLayout, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount)
	{
	  final float originalFreeSpace = collectedFlexItemsValues.remainingFreeSpace;

	  YGDistributeFreeSpaceFirstPass(collectedFlexItemsValues, mainAxis, mainAxisownerSize, availableInnerMainDim, availableInnerWidth);


	  final float distributedFreeSpace = YGDistributeFreeSpaceSecondPass(collectedFlexItemsValues, node, mainAxis, crossAxis, mainAxisownerSize, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, availableInnerHeight, flexBasisOverflows, measureModeCrossDim, performLayout, config, layoutMarkerData, layoutContext, depth, generationCount);

	  collectedFlexItemsValues.remainingFreeSpace = originalFreeSpace - distributedFreeSpace;
	}

	public static void YGJustifyMainAxis(YGNode node, YGCollectFlexItemsRowValues collectedFlexItemsValues, final Integer startOfLineIndex, final YGFlexDirection mainAxis, final YGFlexDirection crossAxis, final YGMeasureMode measureModeMainDim, final YGMeasureMode measureModeCrossDim, final float mainAxisownerSize, final float ownerWidth, final float availableInnerMainDim, final float availableInnerCrossDim, final float availableInnerWidth, final boolean performLayout, final Object layoutContext)
	{
	  final var style = node.getStyle();
	  final float leadingPaddingAndBorderMain = node.getLeadingPaddingAndBorder(mainAxis, ownerWidth).unwrap();
	  final float trailingPaddingAndBorderMain = node.getTrailingPaddingAndBorder(mainAxis, ownerWidth).unwrap();


	  if (measureModeMainDim == YGMeasureMode.YGMeasureModeAtMost && collectedFlexItemsValues.remainingFreeSpace > 0F)
	  {
		if (!style.minDimensions()[dim[(int)mainAxis]].isUndefined() && !YGResolveValue(style.minDimensions [dim[(int)mainAxis]], mainAxisownerSize).isUndefined())
		{







		  final float minAvailableMainDim = YGResolveValue(style.minDimensions [dim[(int)mainAxis]], mainAxisownerSize).unwrap() - leadingPaddingAndBorderMain - trailingPaddingAndBorderMain;
		  final float occupiedSpaceByChildNodes = availableInnerMainDim - collectedFlexItemsValues.remainingFreeSpace;
		  collectedFlexItemsValues.remainingFreeSpace = YGFloatMax(0F, minAvailableMainDim - occupiedSpaceByChildNodes);
		}
		else
		{
		  collectedFlexItemsValues.remainingFreeSpace = 0F;
		}
	  }

	  int numberOfAutoMarginsOnCurrentLine = 0;
	  for (Integer i = startOfLineIndex; i < collectedFlexItemsValues.endOfLineIndex; i++)
	  {
		YGNode child = node.getChild(i);
		if (child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute)
		{
		  if (child.marginLeadingValue(mainAxis).unit == YGUnit.YGUnitAuto)
		  {
			numberOfAutoMarginsOnCurrentLine++;
		  }
		  if (child.marginTrailingValue(mainAxis).unit == YGUnit.YGUnitAuto)
		  {
			numberOfAutoMarginsOnCurrentLine++;
		  }
		}
	  }




	  float leadingMainDim = 0F;
	  float betweenMainDim = 0F;
	  final YGJustify justifyContent = node.getStyle().justifyContent();

	  if (numberOfAutoMarginsOnCurrentLine == 0)
	  {
		switch (justifyContent)
		{
		  case YGJustifyCenter:
			leadingMainDim = collectedFlexItemsValues.remainingFreeSpace / 2;
			break;
		  case YGJustifyFlexEnd:
			leadingMainDim = collectedFlexItemsValues.remainingFreeSpace;
			break;
		  case YGJustifySpaceBetween:
			if (collectedFlexItemsValues.itemsOnLine > 1)
			{
			  betweenMainDim = YGFloatMax(collectedFlexItemsValues.remainingFreeSpace, 0F) / (collectedFlexItemsValues.itemsOnLine - 1);
			}
			else
			{
			  betweenMainDim = 0F;
			}
			break;
		  case YGJustifySpaceEvenly:

			betweenMainDim = collectedFlexItemsValues.remainingFreeSpace / (collectedFlexItemsValues.itemsOnLine + 1);
			leadingMainDim = betweenMainDim;
			break;
		  case YGJustifySpaceAround:

			betweenMainDim = collectedFlexItemsValues.remainingFreeSpace / collectedFlexItemsValues.itemsOnLine;
			leadingMainDim = betweenMainDim / 2;
			break;
		  case YGJustifyFlexStart:
			break;
		}
	  }

	  collectedFlexItemsValues.mainDim = leadingPaddingAndBorderMain + leadingMainDim;
	  collectedFlexItemsValues.crossDim = 0F;

	  float maxAscentForCurrentLine = 0F;
	  float maxDescentForCurrentLine = 0F;
	  boolean isNodeBaselineLayout = YGIsBaselineLayout(node);
	  for (Integer i = startOfLineIndex; i < collectedFlexItemsValues.endOfLineIndex; i++)
	  {
		YGNode child = node.getChild(i);
		final YGStyle childStyle = child.getStyle();
		final YGLayout childLayout = child.getLayout();
		if (childStyle.display() == YGDisplay.YGDisplayNone)
		{
		  continue;
		}
		if (childStyle.positionType() == YGPositionType.YGPositionTypeAbsolute && child.isLeadingPositionDefined(mainAxis))
		{
		  if (performLayout)
		  {



			child.setLayoutPosition(child.getLeadingPosition(mainAxis, availableInnerMainDim).unwrap() + node.getLeadingBorder(mainAxis) + child.getLeadingMargin(mainAxis, availableInnerWidth).unwrap(), pos[(int)mainAxis]);
		  }
		}
		else
		{



		  if (childStyle.positionType() != YGPositionType.YGPositionTypeAbsolute)
		  {
			if (child.marginLeadingValue(mainAxis).unit == YGUnit.YGUnitAuto)
			{
			  collectedFlexItemsValues.mainDim += collectedFlexItemsValues.remainingFreeSpace / numberOfAutoMarginsOnCurrentLine;
			}

			if (performLayout)
			{
			  child.setLayoutPosition(childLayout.position[pos[(int)mainAxis]] + collectedFlexItemsValues.mainDim, pos[(int)mainAxis]);
			}

			if (child.marginTrailingValue(mainAxis).unit == YGUnit.YGUnitAuto)
			{
			  collectedFlexItemsValues.mainDim += collectedFlexItemsValues.remainingFreeSpace / numberOfAutoMarginsOnCurrentLine;
			}
			boolean canSkipFlex = !performLayout && measureModeCrossDim == YGMeasureMode.YGMeasureModeExactly;
			if (canSkipFlex)
			{



			  collectedFlexItemsValues.mainDim += betweenMainDim + child.getMarginForAxis(mainAxis, availableInnerWidth).unwrap() + childLayout.computedFlexBasis.unwrap();
			  collectedFlexItemsValues.crossDim = availableInnerCrossDim;
			}
			else
			{


			  collectedFlexItemsValues.mainDim += betweenMainDim + YGNodeDimWithMargin(child, mainAxis, availableInnerWidth);

			  if (isNodeBaselineLayout)
			  {


				final float ascent = YGBaseline(child, layoutContext) + child.getLeadingMargin(YGFlexDirection.YGFlexDirectionColumn, availableInnerWidth).unwrap();
				final float descent = child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight] + child.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, availableInnerWidth).unwrap() - ascent;

				maxAscentForCurrentLine = YGFloatMax(maxAscentForCurrentLine, ascent);
				maxDescentForCurrentLine = YGFloatMax(maxDescentForCurrentLine, descent);
			  }
			  else
			  {



				collectedFlexItemsValues.crossDim = YGFloatMax(collectedFlexItemsValues.crossDim, YGNodeDimWithMargin(child, crossAxis, availableInnerWidth));
			  }
			}
		  }
		  else if (performLayout)
		  {
			child.setLayoutPosition(childLayout.position[pos[(int)mainAxis]] + node.getLeadingBorder(mainAxis) + leadingMainDim, pos[(int)mainAxis]);
		  }
		}
	  }
	  collectedFlexItemsValues.mainDim += trailingPaddingAndBorderMain;

	  if (isNodeBaselineLayout)
	  {
		collectedFlexItemsValues.crossDim = maxAscentForCurrentLine + maxDescentForCurrentLine;
	  }
	}
	public static void YGNodelayoutImpl(YGNode node, final float availableWidth, final float availableHeight, final YGDirection ownerDirection, final YGMeasureMode widthMeasureMode, final YGMeasureMode heightMeasureMode, final float ownerWidth, final float ownerHeight, final boolean performLayout, YGConfig config, LayoutData layoutMarkerData, final Object layoutContext, final Integer depth, final Integer generationCount, final LayoutPassReason reason)
	{
	  YGAssertWithNode(node, YGFloatIsUndefined(availableWidth) ? widthMeasureMode == YGMeasureMode.YGMeasureModeUndefined : true, "availableWidth is indefinite so widthMeasureMode must be " + "YGMeasureModeUndefined");
	  YGAssertWithNode(node, YGFloatIsUndefined(availableHeight) ? heightMeasureMode == YGMeasureMode.YGMeasureModeUndefined : true, "availableHeight is indefinite so heightMeasureMode must be " + "YGMeasureModeUndefined");

	  (performLayout ? layoutMarkerData.layouts : layoutMarkerData.measures) += 1;


	  final YGDirection direction = node.resolveDirection(ownerDirection);
	  node.setLayoutDirection(direction);

	  final YGFlexDirection flexRowDirection = YGResolveFlexDirection(YGFlexDirection.YGFlexDirectionRow, direction);
	  final YGFlexDirection flexColumnDirection = YGResolveFlexDirection(YGFlexDirection.YGFlexDirectionColumn, direction);

	  final YGEdge startEdge = direction == YGDirection.YGDirectionLTR ? YGEdge.YGEdgeLeft : YGEdge.YGEdgeRight;
	  final YGEdge endEdge = direction == YGDirection.YGDirectionLTR ? YGEdge.YGEdgeRight : YGEdge.YGEdgeLeft;

	  final float marginRowLeading = node.getLeadingMargin(flexRowDirection, ownerWidth).unwrap();
	  node.setLayoutMargin(marginRowLeading, startEdge);
	  final float marginRowTrailing = node.getTrailingMargin(flexRowDirection, ownerWidth).unwrap();
	  node.setLayoutMargin(marginRowTrailing, endEdge);
	  final float marginColumnLeading = node.getLeadingMargin(flexColumnDirection, ownerWidth).unwrap();
	  node.setLayoutMargin(marginColumnLeading, YGEdge.YGEdgeTop);
	  final float marginColumnTrailing = node.getTrailingMargin(flexColumnDirection, ownerWidth).unwrap();
	  node.setLayoutMargin(marginColumnTrailing, YGEdge.YGEdgeBottom);

	  final float marginAxisRow = marginRowLeading + marginRowTrailing;
	  final float marginAxisColumn = marginColumnLeading + marginColumnTrailing;

	  node.setLayoutBorder(node.getLeadingBorder(flexRowDirection), startEdge);
	  node.setLayoutBorder(node.getTrailingBorder(flexRowDirection), endEdge);
	  node.setLayoutBorder(node.getLeadingBorder(flexColumnDirection), YGEdge.YGEdgeTop);
	  node.setLayoutBorder(node.getTrailingBorder(flexColumnDirection), YGEdge.YGEdgeBottom);

	  node.setLayoutPadding(node.getLeadingPadding(flexRowDirection, ownerWidth).unwrap(), startEdge);
	  node.setLayoutPadding(node.getTrailingPadding(flexRowDirection, ownerWidth).unwrap(), endEdge);
	  node.setLayoutPadding(node.getLeadingPadding(flexColumnDirection, ownerWidth).unwrap(), YGEdge.YGEdgeTop);
	  node.setLayoutPadding(node.getTrailingPadding(flexColumnDirection, ownerWidth).unwrap(), YGEdge.YGEdgeBottom);

	  if (node.hasMeasureFunc())
	  {
		YGNodeWithMeasureFuncSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight, layoutMarkerData, layoutContext, reason);
		return;
	  }

	  final Integer childCount = YGNodeGetChildCount(node);
	  if (childCount == 0)
	  {
		YGNodeEmptyContainerSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight);
		return;
	  }



	  if (!performLayout && YGNodeFixedSizeSetMeasuredDimensions(node, availableWidth - marginAxisRow, availableHeight - marginAxisColumn, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight))
	  {
		return;
	  }



	  node.cloneChildrenIfNeeded(layoutContext);

	  node.setLayoutHadOverflow(false);


	  final YGFlexDirection mainAxis = YGResolveFlexDirection(node.getStyle().flexDirection(), direction);
	  final YGFlexDirection crossAxis = YGFlexDirectionCross(mainAxis, direction);
	  final boolean isMainAxisRow = YGFlexDirectionIsRow(mainAxis);
	  final boolean isNodeFlexWrap = node.getStyle().flexWrap() != YGWrap.YGWrapNoWrap;

	  final float mainAxisownerSize = isMainAxisRow ? ownerWidth : ownerHeight;
	  final float crossAxisownerSize = isMainAxisRow ? ownerHeight : ownerWidth;

	  final float paddingAndBorderAxisMain = YGNodePaddingAndBorderForAxis(node, mainAxis, ownerWidth);
	  final float leadingPaddingAndBorderCross = node.getLeadingPaddingAndBorder(crossAxis, ownerWidth).unwrap();
	  final float trailingPaddingAndBorderCross = node.getTrailingPaddingAndBorder(crossAxis, ownerWidth).unwrap();
	  final float paddingAndBorderAxisCross = leadingPaddingAndBorderCross + trailingPaddingAndBorderCross;

	  YGMeasureMode measureModeMainDim = isMainAxisRow ? widthMeasureMode : heightMeasureMode;
	  YGMeasureMode measureModeCrossDim = isMainAxisRow ? heightMeasureMode : widthMeasureMode;

	  final float paddingAndBorderAxisRow = isMainAxisRow ? paddingAndBorderAxisMain : paddingAndBorderAxisCross;
	  final float paddingAndBorderAxisColumn = isMainAxisRow ? paddingAndBorderAxisCross : paddingAndBorderAxisMain;



	  float availableInnerWidth = YGNodeCalculateAvailableInnerDim(node, YGDimension.YGDimensionWidth, availableWidth - marginAxisRow, paddingAndBorderAxisRow, ownerWidth);
	  float availableInnerHeight = YGNodeCalculateAvailableInnerDim(node, YGDimension.YGDimensionHeight, availableHeight - marginAxisColumn, paddingAndBorderAxisColumn, ownerHeight);

	  float availableInnerMainDim = isMainAxisRow ? availableInnerWidth : availableInnerHeight;
	  final float availableInnerCrossDim = isMainAxisRow ? availableInnerHeight : availableInnerWidth;



	  float totalOuterFlexBasis = YGNodeComputeFlexBasisForChildren(node, availableInnerWidth, availableInnerHeight, widthMeasureMode, heightMeasureMode, direction, mainAxis, config, performLayout, layoutMarkerData, layoutContext, depth, generationCount);

	  final boolean flexBasisOverflows = measureModeMainDim == YGMeasureMode.YGMeasureModeUndefined ? false : totalOuterFlexBasis > availableInnerMainDim;
	  if (isNodeFlexWrap && flexBasisOverflows && measureModeMainDim == YGMeasureMode.YGMeasureModeAtMost)
	  {
		measureModeMainDim = YGMeasureMode.YGMeasureModeExactly;
	  }



	  Integer startOfLineIndex = 0;
	  Integer endOfLineIndex = 0;


	  Integer lineCount = 0;


	  float totalLineCrossDim = 0F;


	  float maxLineMainDim = 0F;
	  YGCollectFlexItemsRowValues collectedFlexItemsValues = new YGCollectFlexItemsRowValues();
	  for (; endOfLineIndex < childCount; lineCount++, startOfLineIndex = endOfLineIndex)
	  {
		collectedFlexItemsValues = YGCalculateCollectFlexItemsRowValues(node, ownerDirection, mainAxisownerSize, availableInnerWidth, availableInnerMainDim, startOfLineIndex, lineCount);
		endOfLineIndex = collectedFlexItemsValues.endOfLineIndex;



		final boolean canSkipFlex = !performLayout && measureModeCrossDim == YGMeasureMode.YGMeasureModeExactly;






		boolean sizeBasedOnContent = false;


		if (measureModeMainDim != YGMeasureMode.YGMeasureModeExactly)
		{
		  final var minDimensions = node.getStyle().minDimensions();
		  final var maxDimensions = node.getStyle().maxDimensions();
		  final float minInnerWidth = YGResolveValue(minDimensions[(int)YGDimension.YGDimensionWidth], ownerWidth).unwrap() - paddingAndBorderAxisRow;
		  final float maxInnerWidth = YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionWidth], ownerWidth).unwrap() - paddingAndBorderAxisRow;
		  final float minInnerHeight = YGResolveValue(minDimensions[(int)YGDimension.YGDimensionHeight], ownerHeight).unwrap() - paddingAndBorderAxisColumn;
		  final float maxInnerHeight = YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionHeight], ownerHeight).unwrap() - paddingAndBorderAxisColumn;

		  final float minInnerMainDim = isMainAxisRow ? minInnerWidth : minInnerHeight;
		  final float maxInnerMainDim = isMainAxisRow ? maxInnerWidth : maxInnerHeight;

		  if (!YGFloatIsUndefined(minInnerMainDim) && collectedFlexItemsValues.sizeConsumedOnCurrentLine < minInnerMainDim)
		  {
			availableInnerMainDim = minInnerMainDim;
		  }
		  else if (!YGFloatIsUndefined(maxInnerMainDim) && collectedFlexItemsValues.sizeConsumedOnCurrentLine > maxInnerMainDim)
		  {
			availableInnerMainDim = maxInnerMainDim;
		  }
		  else
		  {
			if (!node.getConfig().useLegacyStretchBehaviour && ((YGFloatIsUndefined(collectedFlexItemsValues.totalFlexGrowFactors) && collectedFlexItemsValues.totalFlexGrowFactors == 0F) || (YGFloatIsUndefined(node.resolveFlexGrow()) && node.resolveFlexGrow() == 0)))
			{



			  availableInnerMainDim = collectedFlexItemsValues.sizeConsumedOnCurrentLine;
			}

			if (node.getConfig().useLegacyStretchBehaviour)
			{
			  node.setLayoutDidUseLegacyFlag(true);
			}
			sizeBasedOnContent = !node.getConfig().useLegacyStretchBehaviour;
		  }
		}

		if (!sizeBasedOnContent && !YGFloatIsUndefined(availableInnerMainDim))
		{
		  collectedFlexItemsValues.remainingFreeSpace = availableInnerMainDim - collectedFlexItemsValues.sizeConsumedOnCurrentLine;
		}
		else if (collectedFlexItemsValues.sizeConsumedOnCurrentLine < 0F)
		{




		  collectedFlexItemsValues.remainingFreeSpace = -collectedFlexItemsValues.sizeConsumedOnCurrentLine;
		}

		if (!canSkipFlex)
		{
		  YGResolveFlexibleLength(node, collectedFlexItemsValues, mainAxis, crossAxis, mainAxisownerSize, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, availableInnerHeight, flexBasisOverflows, measureModeCrossDim, performLayout, config, layoutMarkerData, layoutContext, depth, generationCount);
		}

		node.setLayoutHadOverflow(node.getLayout().hadOverflow() | (collectedFlexItemsValues.remainingFreeSpace < 0F));
		YGJustifyMainAxis(node, collectedFlexItemsValues, startOfLineIndex, mainAxis, crossAxis, measureModeMainDim, measureModeCrossDim, mainAxisownerSize, ownerWidth, availableInnerMainDim, availableInnerCrossDim, availableInnerWidth, performLayout, layoutContext);

		float containerCrossAxis = availableInnerCrossDim;
		if (measureModeCrossDim == YGMeasureMode.YGMeasureModeUndefined || measureModeCrossDim == YGMeasureMode.YGMeasureModeAtMost)
		{

		  containerCrossAxis = YGNodeBoundAxis(node, crossAxis, collectedFlexItemsValues.crossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth) - paddingAndBorderAxisCross;
		}


		if (!isNodeFlexWrap && measureModeCrossDim == YGMeasureMode.YGMeasureModeExactly)
		{
		  collectedFlexItemsValues.crossDim = availableInnerCrossDim;
		}


		collectedFlexItemsValues.crossDim = YGNodeBoundAxis(node, crossAxis, collectedFlexItemsValues.crossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth) - paddingAndBorderAxisCross;



		if (performLayout)
		{
		  for (Integer i = startOfLineIndex; i < endOfLineIndex; i++)
		  {
			YGNode child = node.getChild(i);
			if (child.getStyle().display() == YGDisplay.YGDisplayNone)
			{
			  continue;
			}
			if (child.getStyle().positionType() == YGPositionType.YGPositionTypeAbsolute)
			{



			  final boolean isChildLeadingPosDefined = child.isLeadingPositionDefined(crossAxis);
			  if (isChildLeadingPosDefined)
			  {
				child.setLayoutPosition(child.getLeadingPosition(crossAxis, availableInnerCrossDim).unwrap() + node.getLeadingBorder(crossAxis) + child.getLeadingMargin(crossAxis, availableInnerWidth).unwrap(), pos[(int)crossAxis]);
			  }


			  if (!isChildLeadingPosDefined || YGFloatIsUndefined(child.getLayout().position[pos[(int)crossAxis]]))
			  {
				child.setLayoutPosition(node.getLeadingBorder(crossAxis) + child.getLeadingMargin(crossAxis, availableInnerWidth).unwrap(), pos[(int)crossAxis]);
			  }
			}
			else
			{
			  float leadingCrossDim = leadingPaddingAndBorderCross;




			  final YGAlign alignItem = YGNodeAlignItem(node, child);




			  if (alignItem == YGAlign.YGAlignStretch && child.marginLeadingValue(crossAxis).unit != YGUnit.YGUnitAuto && child.marginTrailingValue(crossAxis).unit != YGUnit.YGUnitAuto)
			  {


				if (!YGNodeIsStyleDimDefined(child, crossAxis, availableInnerCrossDim))
				{
				  float childMainSize = child.getLayout().measuredDimensions[dim[(int)mainAxis]];
				  final var childStyle = child.getStyle();
				  float childCrossSize = !childStyle.aspectRatio().isUndefined() ? child.getMarginForAxis(crossAxis, availableInnerWidth).unwrap() + (isMainAxisRow ? childMainSize / childStyle.aspectRatio().unwrap() : childMainSize * childStyle.aspectRatio().unwrap()) : collectedFlexItemsValues.crossDim;

				  childMainSize += child.getMarginForAxis(mainAxis, availableInnerWidth).unwrap();

				  YGMeasureMode childMainMeasureMode = YGMeasureMode.YGMeasureModeExactly;
				  YGMeasureMode childCrossMeasureMode = YGMeasureMode.YGMeasureModeExactly;
				  YGConstrainMaxSizeForMode(child, mainAxis, availableInnerMainDim, availableInnerWidth, childMainMeasureMode, childMainSize);
				  YGConstrainMaxSizeForMode(child, crossAxis, availableInnerCrossDim, availableInnerWidth, childCrossMeasureMode, childCrossSize);

				  final float childWidth = isMainAxisRow ? childMainSize : childCrossSize;
				  final float childHeight = !isMainAxisRow ? childMainSize : childCrossSize;

				  var alignContent = node.getStyle().alignContent();
				  var crossAxisDoesNotGrow = alignContent != YGAlign.YGAlignStretch && isNodeFlexWrap;
				  final YGMeasureMode childWidthMeasureMode = YGFloatIsUndefined(childWidth) || (!isMainAxisRow && crossAxisDoesNotGrow) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;
				  final YGMeasureMode childHeightMeasureMode = YGFloatIsUndefined(childHeight) || (isMainAxisRow && crossAxisDoesNotGrow) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;

				  YGLayoutNodeInternal(child, childWidth, childHeight, direction, childWidthMeasureMode, childHeightMeasureMode, availableInnerWidth, availableInnerHeight, true, LayoutPassReason.kStretch, config, layoutMarkerData, layoutContext, depth, generationCount);
				}
			  }
			  else
			  {
				final float remainingCrossDim = containerCrossAxis - YGNodeDimWithMargin(child, crossAxis, availableInnerWidth);

				if (child.marginLeadingValue(crossAxis).unit == YGUnit.YGUnitAuto && child.marginTrailingValue(crossAxis).unit == YGUnit.YGUnitAuto)
				{
				  leadingCrossDim += YGFloatMax(0.0f, remainingCrossDim / 2);
				}
				else if (child.marginTrailingValue(crossAxis).unit == YGUnit.YGUnitAuto)
				{

				}
				else if (child.marginLeadingValue(crossAxis).unit == YGUnit.YGUnitAuto)
				{
				  leadingCrossDim += YGFloatMax(0.0f, remainingCrossDim);
				}
				else if (alignItem == YGAlign.YGAlignFlexStart)
				{

				}
				else if (alignItem == YGAlign.YGAlignCenter)
				{
				  leadingCrossDim += remainingCrossDim / 2;
				}
				else
				{
				  leadingCrossDim += remainingCrossDim;
				}
			  }

			  child.setLayoutPosition(child.getLayout().position[pos[(int)crossAxis]] + totalLineCrossDim + leadingCrossDim, pos[(int)crossAxis]);
			}
		  }
		}

		totalLineCrossDim += collectedFlexItemsValues.crossDim;
		maxLineMainDim = YGFloatMax(maxLineMainDim, collectedFlexItemsValues.mainDim);
	  }



	  if (performLayout && (isNodeFlexWrap || YGIsBaselineLayout(node)))
	  {
		float crossDimLead = 0F;
		float currentLead = leadingPaddingAndBorderCross;
		if (!YGFloatIsUndefined(availableInnerCrossDim))
		{
		  final float remainingAlignContentDim = availableInnerCrossDim - totalLineCrossDim;
		  switch (node.getStyle().alignContent())
		  {
			case YGAlignFlexEnd:
			  currentLead += remainingAlignContentDim;
			  break;
			case YGAlignCenter:
			  currentLead += remainingAlignContentDim / 2;
			  break;
			case YGAlignStretch:
			  if (availableInnerCrossDim > totalLineCrossDim)
			  {
				crossDimLead = remainingAlignContentDim / lineCount;
			  }
			  break;
			case YGAlignSpaceAround:
			  if (availableInnerCrossDim > totalLineCrossDim)
			  {
				currentLead += remainingAlignContentDim / (2 * lineCount);
				if (lineCount > 1)
				{
				  crossDimLead = remainingAlignContentDim / lineCount;
				}
			  }
			  else
			  {
				currentLead += remainingAlignContentDim / 2;
			  }
			  break;
			case YGAlignSpaceBetween:
			  if (availableInnerCrossDim > totalLineCrossDim && lineCount > 1)
			  {
				crossDimLead = remainingAlignContentDim / (lineCount - 1);
			  }
			  break;
			case YGAlignAuto:
			case YGAlignFlexStart:
			case YGAlignBaseline:
			  break;
		  }
		}
		Integer endIndex = 0;
		for (Integer i = 0; i < lineCount; i++)
		{
		  final Integer startIndex = endIndex;
		  Integer ii;


		  float lineHeight = 0F;
		  float maxAscentForCurrentLine = 0F;
		  float maxDescentForCurrentLine = 0F;
		  for (ii = startIndex; ii < childCount; ii++)
		  {
			YGNode child = node.getChild(ii);
			if (child.getStyle().display() == YGDisplay.YGDisplayNone)
			{
			  continue;
			}
			if (child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute)
			{
			  if (child.getLineIndex() != i)
			  {
				break;
			  }
			  if (YGNodeIsLayoutDimDefined(child, crossAxis))
			  {
				lineHeight = YGFloatMax(lineHeight, child.getLayout().measuredDimensions[dim[(int)crossAxis]] + child.getMarginForAxis(crossAxis, availableInnerWidth).unwrap());
			  }
			  if (YGNodeAlignItem(node, child) == YGAlign.YGAlignBaseline)
			  {
				final float ascent = YGBaseline(child, layoutContext) + child.getLeadingMargin(YGFlexDirection.YGFlexDirectionColumn, availableInnerWidth).unwrap();
				final float descent = child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight] + child.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, availableInnerWidth).unwrap() - ascent;
				maxAscentForCurrentLine = YGFloatMax(maxAscentForCurrentLine, ascent);
				maxDescentForCurrentLine = YGFloatMax(maxDescentForCurrentLine, descent);
				lineHeight = YGFloatMax(lineHeight, maxAscentForCurrentLine + maxDescentForCurrentLine);
			  }
			}
		  }
		  endIndex = ii;
		  lineHeight += crossDimLead;

		  if (performLayout)
		  {
			for (ii = startIndex; ii < endIndex; ii++)
			{
			  YGNode child = node.getChild(ii);
			  if (child.getStyle().display() == YGDisplay.YGDisplayNone)
			  {
				continue;
			  }
			  if (child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute)
			  {
				switch (YGNodeAlignItem(node, child))
				{
				  case YGAlignFlexStart:
				  {
					child.setLayoutPosition(currentLead + child.getLeadingMargin(crossAxis, availableInnerWidth).unwrap(), pos[(int)crossAxis]);
					break;
				  }
				  case YGAlignFlexEnd:
				  {
					child.setLayoutPosition(currentLead + lineHeight - child.getTrailingMargin(crossAxis, availableInnerWidth).unwrap() - child.getLayout().measuredDimensions[dim[(int)crossAxis]], pos[(int)crossAxis]);
					break;
				  }
				  case YGAlignCenter:
				  {
					float childHeight = child.getLayout().measuredDimensions[dim[(int)crossAxis]];

					child.setLayoutPosition(currentLead + (lineHeight - childHeight) / 2, pos[(int)crossAxis]);
					break;
				  }
				  case YGAlignStretch:
				  {
					child.setLayoutPosition(currentLead + child.getLeadingMargin(crossAxis, availableInnerWidth).unwrap(), pos[(int)crossAxis]);



					if (!YGNodeIsStyleDimDefined(child, crossAxis, availableInnerCrossDim))
					{
					  final float childWidth = isMainAxisRow ? (child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth] + child.getMarginForAxis(mainAxis, availableInnerWidth).unwrap()) : lineHeight;

					  final float childHeight = !isMainAxisRow ? (child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight] + child.getMarginForAxis(crossAxis, availableInnerWidth).unwrap()) : lineHeight;

					  if (!(YGFloatsEqual(childWidth, child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionWidth]) && YGFloatsEqual(childHeight, child.getLayout().measuredDimensions[(int)YGDimension.YGDimensionHeight])))
					  {
						YGLayoutNodeInternal(child, childWidth, childHeight, direction, YGMeasureMode.YGMeasureModeExactly, YGMeasureMode.YGMeasureModeExactly, availableInnerWidth, availableInnerHeight, true, LayoutPassReason.kMultilineStretch, config, layoutMarkerData, layoutContext, depth, generationCount);
					  }
					}
					break;
				  }
				  case YGAlignBaseline:
				  {
					child.setLayoutPosition(currentLead + maxAscentForCurrentLine - YGBaseline(child, layoutContext) + child.getLeadingPosition(YGFlexDirection.YGFlexDirectionColumn, availableInnerCrossDim).unwrap(), YGEdge.YGEdgeTop);

					break;
				  }
				  case YGAlignAuto:
				  case YGAlignSpaceBetween:
				  case YGAlignSpaceAround:
					break;
				}
			  }
			}
		  }
		  currentLead += lineHeight;
		}
	  }



	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionRow, availableWidth - marginAxisRow, ownerWidth, ownerWidth), YGDimension.YGDimensionWidth);

	  node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, YGFlexDirection.YGFlexDirectionColumn, availableHeight - marginAxisColumn, ownerHeight, ownerWidth), YGDimension.YGDimensionHeight);



	  if (measureModeMainDim == YGMeasureMode.YGMeasureModeUndefined || (node.getStyle().overflow() != YGOverflow.YGOverflowScroll && measureModeMainDim == YGMeasureMode.YGMeasureModeAtMost))
	  {


		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, mainAxis, maxLineMainDim, mainAxisownerSize, ownerWidth), dim[(int)mainAxis]);

	  }
	  else if (measureModeMainDim == YGMeasureMode.YGMeasureModeAtMost && node.getStyle().overflow() == YGOverflow.YGOverflowScroll)
	  {
		node.setLayoutMeasuredDimension(YGFloatMax(YGFloatMin(availableInnerMainDim + paddingAndBorderAxisMain, YGNodeBoundAxisWithinMinAndMax(node, mainAxis, YGFloatOptional((maxLineMainDim)), mainAxisownerSize).unwrap()), paddingAndBorderAxisMain), dim[(int)mainAxis]);
	  }

	  if (measureModeCrossDim == YGMeasureMode.YGMeasureModeUndefined || (node.getStyle().overflow() != YGOverflow.YGOverflowScroll && measureModeCrossDim == YGMeasureMode.YGMeasureModeAtMost))
	  {


		node.setLayoutMeasuredDimension(YGNodeBoundAxis(node, crossAxis, totalLineCrossDim + paddingAndBorderAxisCross, crossAxisownerSize, ownerWidth), dim[(int)crossAxis]);

	  }
	  else if (measureModeCrossDim == YGMeasureMode.YGMeasureModeAtMost && node.getStyle().overflow() == YGOverflow.YGOverflowScroll)
	  {
		node.setLayoutMeasuredDimension(YGFloatMax(YGFloatMin(availableInnerCrossDim + paddingAndBorderAxisCross, YGNodeBoundAxisWithinMinAndMax(node, crossAxis, YGFloatOptional((totalLineCrossDim + paddingAndBorderAxisCross)), crossAxisownerSize).unwrap()), paddingAndBorderAxisCross), dim[(int)crossAxis]);
	  }



	  if (performLayout && node.getStyle().flexWrap() == YGWrap.YGWrapWrapReverse)
	  {
		for (Integer i = 0; i < childCount; i++)
		{
		  YGNode child = YGNodeGetChild(node, i);
		  if (child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute)
		  {
			child.setLayoutPosition(node.getLayout().measuredDimensions[dim[(int)crossAxis]] - child.getLayout().position[pos[(int)crossAxis]] - child.getLayout().measuredDimensions[dim[(int)crossAxis]], pos[(int)crossAxis]);
		  }
		}
	  }

	  if (performLayout)
	  {

		for (var child : node.getChildren())
		{
		  if (child.getStyle().display() == YGDisplay.YGDisplayNone || child.getStyle().positionType() != YGPositionType.YGPositionTypeAbsolute)
		  {
			continue;
		  }
		  YGNodeAbsoluteLayoutChild(node, child, availableInnerWidth, isMainAxisRow ? measureModeMainDim : measureModeCrossDim, availableInnerHeight, direction, config, layoutMarkerData, layoutContext, depth, generationCount);
		}


		final boolean needsMainTrailingPos = mainAxis == YGFlexDirection.YGFlexDirectionRowReverse || mainAxis == YGFlexDirection.YGFlexDirectionColumnReverse;
		final boolean needsCrossTrailingPos = crossAxis == YGFlexDirection.YGFlexDirectionRowReverse || crossAxis == YGFlexDirection.YGFlexDirectionColumnReverse;


		if (needsMainTrailingPos || needsCrossTrailingPos)
		{
		  for (Integer i = 0; i < childCount; i++)
		  {
			YGNode child = node.getChild(i);
			if (child.getStyle().display() == YGDisplay.YGDisplayNone)
			{
			  continue;
			}
			if (needsMainTrailingPos)
			{
			  YGNodeSetChildTrailingPosition(node, child, mainAxis);
			}

			if (needsCrossTrailingPos)
			{
			  YGNodeSetChildTrailingPosition(node, child, crossAxis);
			}
		  }
		}
	  }
	}

	public static boolean gPrintChanges = false;
	public static boolean gPrintSkips = false;

	public static final String spacer = "                                                            ";

	//C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
	//ORIGINAL LINE: static const char* YGSpacer(const unsigned long level)
	public static String YGSpacer(final int level)
	{
	  final Integer spacerLen = strlen(spacer);
	  if (level > spacerLen)
	  {
		return spacer[0];
	  }
	  else
	  {
		return spacer[spacerLen - level];
	  }
	}

	public static String YGMeasureModeName(final YGMeasureMode mode, final boolean performLayout)
	{
	  var N = enums.<YGMeasureMode>count();
	  String[] kMeasureModeNames = {"UNDEFINED", "EXACTLY", "AT_MOST"};
	  String[] kLayoutModeNames = {"LAY_UNDEFINED", "LAY_EXACTLY", "LAY_AT_MOST"};

	  if (mode.getValue() >= N)
	  {
		return "";
	  }

	  return performLayout ? kLayoutModeNames[(int)mode] : kMeasureModeNames[(int)mode];
	}

	public static boolean YGMeasureModeSizeIsExactAndMatchesOldMeasuredSize(YGMeasureMode sizeMode, float size, float lastComputedSize)
	{
	  return sizeMode == YGMeasureMode.YGMeasureModeExactly && YGFloatsEqual(size, lastComputedSize);
	}

	public static boolean YGMeasureModeOldSizeIsUnspecifiedAndStillFits(YGMeasureMode sizeMode, float size, YGMeasureMode lastSizeMode, float lastComputedSize)
	{
	  return sizeMode == YGMeasureMode.YGMeasureModeAtMost && lastSizeMode == YGMeasureMode.YGMeasureModeUndefined && (size >= lastComputedSize || YGFloatsEqual(size, lastComputedSize));
	}

	public static boolean YGMeasureModeNewMeasureSizeIsStricterAndStillValid(YGMeasureMode sizeMode, float size, YGMeasureMode lastSizeMode, float lastSize, float lastComputedSize)
	{
	  return lastSizeMode == YGMeasureMode.YGMeasureModeAtMost && sizeMode == YGMeasureMode.YGMeasureModeAtMost && !YGFloatIsUndefined(lastSize) && !YGFloatIsUndefined(size) && !YGFloatIsUndefined(lastComputedSize) && lastSize > size && (lastComputedSize <= size || YGFloatsEqual(size, lastComputedSize));
	}

	public static void YGRoundToPixelGrid(YGNode node, final double pointScaleFactor, final double absoluteLeft, final double absoluteTop)
	{
	  if (pointScaleFactor == 0.0f)
	  {
		return;
	  }

	  final double nodeLeft = node.getLayout().position[(int)YGEdge.YGEdgeLeft];
	  final double nodeTop = node.getLayout().position[(int)YGEdge.YGEdgeTop];

	  final double nodeWidth = node.getLayout().dimensions[(int)YGDimension.YGDimensionWidth];
	  final double nodeHeight = node.getLayout().dimensions[(int)YGDimension.YGDimensionHeight];

	  final double absoluteNodeLeft = absoluteLeft + nodeLeft;
	  final double absoluteNodeTop = absoluteTop + nodeTop;

	  final double absoluteNodeRight = absoluteNodeLeft + nodeWidth;
	  final double absoluteNodeBottom = absoluteNodeTop + nodeHeight;



	  final boolean textRounding = node.getNodeType() == YGNodeType.YGNodeTypeText;

	  node.setLayoutPosition(YGRoundValueToPixelGrid(nodeLeft, pointScaleFactor, false, textRounding), YGEdge.YGEdgeLeft);

	  node.setLayoutPosition(YGRoundValueToPixelGrid(nodeTop, pointScaleFactor, false, textRounding), YGEdge.YGEdgeTop);




	  final boolean hasFractionalWidth = !YGDoubleEqual(fmod(nodeWidth * pointScaleFactor, 1.0), 0) && !YGDoubleEqual(fmod(nodeWidth * pointScaleFactor, 1.0), 1.0);
	  final boolean hasFractionalHeight = !YGDoubleEqual(fmod(nodeHeight * pointScaleFactor, 1.0), 0) && !YGDoubleEqual(fmod(nodeHeight * pointScaleFactor, 1.0), 1.0);

	  node.setLayoutDimension(YGRoundValueToPixelGrid(absoluteNodeRight, pointScaleFactor, (textRounding && hasFractionalWidth), (textRounding && !hasFractionalWidth)) - YGRoundValueToPixelGrid(absoluteNodeLeft, pointScaleFactor, false, textRounding), YGDimension.YGDimensionWidth);

	  node.setLayoutDimension(YGRoundValueToPixelGrid(absoluteNodeBottom, pointScaleFactor, (textRounding && hasFractionalHeight), (textRounding && !hasFractionalHeight)) - YGRoundValueToPixelGrid(absoluteNodeTop, pointScaleFactor, false, textRounding), YGDimension.YGDimensionHeight);

	  final Integer childCount = YGNodeGetChildCount(node);
	  for (Integer i = 0; i < childCount; i++)
	  {
		YGRoundToPixelGrid(YGNodeGetChild(node, i), pointScaleFactor, absoluteNodeLeft, absoluteNodeTop);
	  }
	}

	public static void unsetUseLegacyFlagRecursively(YGNode node)
	{
	  node.getConfig().useLegacyStretchBehaviour = false;
	  for (var child : node.getChildren())
	  {
		unsetUseLegacyFlagRecursively(child);
	  }
	}

	public static void YGNodeCalculateLayoutWithContext(YGNode node, final float ownerWidth, final float ownerHeight, final YGDirection ownerDirection, Object layoutContext)
	{

	  Event.<Event.LayoutPassStart>publish(node, {layoutContext});
	  LayoutData markerData = new LayoutData();




	  gCurrentGenerationCount.fetch_add(1, std::memory_order_relaxed);
	  node.resolveDimension();
	  float width = YGUndefined;
	  YGMeasureMode widthMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
	  final var maxDimensions = node.getStyle().maxDimensions();
	  if (YGNodeIsStyleDimDefined(node, YGFlexDirection.YGFlexDirectionRow, ownerWidth))
	  {
		width = (YGResolveValue(node.getResolvedDimension(dim[(int)YGFlexDirection.YGFlexDirectionRow]), ownerWidth) + node.getMarginForAxis(YGFlexDirection.YGFlexDirectionRow, ownerWidth)).unwrap();
		widthMeasureMode = YGMeasureMode.YGMeasureModeExactly;
	  }
	  else if (!YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionWidth], ownerWidth).isUndefined())
	  {
		width = YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionWidth], ownerWidth).unwrap();
		widthMeasureMode = YGMeasureMode.YGMeasureModeAtMost;
	  }
	  else
	  {
		width = ownerWidth;
		widthMeasureMode = YGFloatIsUndefined(width) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;
	  }

	  float height = YGUndefined;
	  YGMeasureMode heightMeasureMode = YGMeasureMode.YGMeasureModeUndefined;
	  if (YGNodeIsStyleDimDefined(node, YGFlexDirection.YGFlexDirectionColumn, ownerHeight))
	  {
		height = (YGResolveValue(node.getResolvedDimension(dim[(int)YGFlexDirection.YGFlexDirectionColumn]), ownerHeight) + node.getMarginForAxis(YGFlexDirection.YGFlexDirectionColumn, ownerWidth)).unwrap();
		heightMeasureMode = YGMeasureMode.YGMeasureModeExactly;
	  }
	  else if (!YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionHeight], ownerHeight).isUndefined())
	  {
		height = YGResolveValue(maxDimensions[(int)YGDimension.YGDimensionHeight], ownerHeight).unwrap();
		heightMeasureMode = YGMeasureMode.YGMeasureModeAtMost;
	  }
	  else
	  {
		height = ownerHeight;
		heightMeasureMode = YGFloatIsUndefined(height) ? YGMeasureMode.YGMeasureModeUndefined : YGMeasureMode.YGMeasureModeExactly;
	  }
	  if (YGLayoutNodeInternal(node, width, height, ownerDirection, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight, true, LayoutPassReason.kInitial, node.getConfig(), markerData, layoutContext, 0, gCurrentGenerationCount.load(std::memory_order_relaxed)))
	  {
		node.setPosition(node.getLayout().direction(), ownerWidth, ownerHeight, ownerWidth);
		YGRoundToPixelGrid(node, node.getConfig().pointScaleFactor, 0.0f, 0.0f);
	  }

	  Event.<Event.LayoutPassEnd>publish(node, {layoutContext, markerData});
	  if (node.getConfig().shouldDiffLayoutWithoutLegacyStretchBehaviour && node.didUseLegacyFlag())
	  {
		YGNode nodeWithoutLegacyFlag = YGNodeDeepClone(node);
		nodeWithoutLegacyFlag.resolveDimension();

		nodeWithoutLegacyFlag.markDirtyAndPropogateDownwards();
		gCurrentGenerationCount.fetch_add(1, std::memory_order_relaxed);

		unsetUseLegacyFlagRecursively(nodeWithoutLegacyFlag);
		LayoutData layoutMarkerData = new LayoutData();
		if (YGLayoutNodeInternal(nodeWithoutLegacyFlag, width, height, ownerDirection, widthMeasureMode, heightMeasureMode, ownerWidth, ownerHeight, true, LayoutPassReason.kInitial, nodeWithoutLegacyFlag.getConfig(), layoutMarkerData, layoutContext, 0, gCurrentGenerationCount.load(std::memory_order_relaxed)))
		{
		  nodeWithoutLegacyFlag.setPosition(nodeWithoutLegacyFlag.getLayout().direction(), ownerWidth, ownerHeight, ownerWidth);
		  YGRoundToPixelGrid(nodeWithoutLegacyFlag, nodeWithoutLegacyFlag.getConfig().pointScaleFactor, 0.0f, 0.0f);


		  var neededLegacyStretchBehaviour = !nodeWithoutLegacyFlag.isLayoutTreeEqualToNode(node);
		  node.setLayoutDoesLegacyFlagAffectsLayout(neededLegacyStretchBehaviour);
		}
		YGConfigFreeRecursive(nodeWithoutLegacyFlag);
		YGNodeFreeRecursive(nodeWithoutLegacyFlag);
	  }
	}

	public static void YGTraverseChildrenPreOrder(final ArrayList<YGNode> children, voidDelegate void)
	{
	  for (YGNode node : children)
	  {
		f(node);
		YGTraverseChildrenPreOrder(node.getChildren(), f);
	  }
	}
@FunctionalInterface
interface voidDelegate
{
	void invoke(YGNode node);
}


	public static void YGTraversePreOrder(final YGNode node, voidDelegate void)
	{
	  if (node == null)
	  {
		return;
	  }
	  f(node);
	  YGTraverseChildrenPreOrder(node.getChildren(), f);
	}




	private boolean equalsTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return lhs.unwrap() == rhs.unwrap() || (lhs.isUndefined() && rhs.isUndefined());
	}
	private boolean notEqualsTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return !(lhs == rhs);
	}

	private boolean equalsTo(YGFloatOptional lhs, float rhs)
	{
	  return lhs == YGFloatOptional(rhs);
	}
	private boolean notEqualsTo(YGFloatOptional lhs, float rhs)
	{
	  return !(lhs == rhs);
	}

	private boolean equalsTo(float lhs, YGFloatOptional rhs)
	{
	  return rhs == lhs;
	}
	private boolean notEqualsTo(float lhs, YGFloatOptional rhs)
	{
	  return !(lhs == rhs);
	}

//C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
	YGFloatOptional operator + (YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return YGFloatOptional(lhs.unwrap() + rhs.unwrap());
	}

	private boolean greaterThan(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return lhs.unwrap() > rhs.unwrap();
	}

	private boolean lessThan(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return lhs.unwrap() < rhs.unwrap();
	}

	private boolean greaterThanOrEqualTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return lhs > rhs || lhs == rhs;
	}

	private boolean lessThanOrEqualTo(YGFloatOptional lhs, YGFloatOptional rhs)
	{
	  return lhs < rhs || lhs == rhs;
	}





















//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//void YGNodeCalculateLayoutWithContext(YGNode node, float availableWidth, float availableHeight, YGDirection ownerDirection, Object layoutContext);

//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const java.util.ArrayList<YGEdge> trailing;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const java.util.ArrayList<YGEdge> leading;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueUndefined;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueAuto;
//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern const YGValue YGValueZero;


	public static final float kDefaultFlexGrow = 0.0f;
	public static final float kDefaultFlexShrink = 0.0f;
	public static final float kWebDefaultFlexShrink = 1.0f;

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//boolean YGFloatsEqual(final float a, final float b);

}
