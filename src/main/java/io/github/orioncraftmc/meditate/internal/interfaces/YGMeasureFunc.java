package io.github.orioncraftmc.meditate.internal.interfaces;

import io.github.orioncraftmc.meditate.internal.YGNode;
import io.github.orioncraftmc.meditate.internal.YGSize;
import io.github.orioncraftmc.meditate.internal.enums.YGMeasureMode;

@FunctionalInterface
public
interface YGMeasureFunc {
     YGSize invoke(YGNode node, float width, YGMeasureMode widthMode, float height, YGMeasureMode heightMode);
}
