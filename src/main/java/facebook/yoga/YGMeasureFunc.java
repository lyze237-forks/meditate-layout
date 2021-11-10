package facebook.yoga;

@FunctionalInterface
interface YGMeasureFunc {
    YGSize invoke(YGNode node, float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode);
}
