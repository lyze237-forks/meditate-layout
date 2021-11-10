package facebook.yoga;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public
interface YGMeasureFunc {
    @NotNull YGSize invoke(YGNode node, float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode);
}
