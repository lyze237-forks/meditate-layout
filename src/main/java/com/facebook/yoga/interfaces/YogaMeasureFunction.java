/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.yoga.interfaces;

import com.facebook.yoga.YogaNode;
import com.facebook.yoga.enums.YogaMeasureMode;
import io.github.orioncraftmc.meditate.internal.YGSize;

public interface YogaMeasureFunction {
    /**
     * Return a value created by YogaMeasureOutput.make(width, height);
     */
    YGSize measure(
            YogaNode node,
            float width,
            YogaMeasureMode widthMode,
            float height,
            YogaMeasureMode heightMode);

}
