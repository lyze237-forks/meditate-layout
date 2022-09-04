/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.github.orioncraftmc.meditate.interfaces;

import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.YogaValue;
import io.github.orioncraftmc.meditate.enums.*;

public interface YogaProps {

  /* Width properties */

  YogaNode setWidth(float width);

  YogaNode setWidthPercent(float percent);

  YogaNode setMinWidth(float minWidth);

  YogaNode setMinWidthPercent(float percent);

  YogaNode setMaxWidth(float maxWidth);

  YogaNode setMaxWidthPercent(float percent);

  YogaNode setWidthAuto();

  /* Height properties */

  YogaNode setHeight(float height);

  YogaNode setHeightPercent(float percent);

  YogaNode setMinHeight(float minHeight);

  YogaNode setMinHeightPercent(float percent);

  YogaNode setMaxHeight(float maxHeight);

  YogaNode setMaxHeightPercent(float percent);

  YogaNode setHeightAuto();
  
  /* Size convenience methods */
  
  YogaNode setSize(float size);
  
  YogaNode setSizePercent(float percent);
  
  YogaNode setMinSize(float minSize);
  
  YogaNode setMinSizePercent(float percent);
  
  YogaNode setMaxSize(float minSize);
  
  YogaNode setMaxSizePercent(float percent);
  
  YogaNode setSizeAuto();

  /* Margin properties */

  YogaNode setMargin(YogaEdge edge, float margin);

  YogaNode setMarginPercent(YogaEdge edge, float percent);

  YogaNode setMarginAuto(YogaEdge edge);

  /* Padding properties */

  YogaNode setPadding(YogaEdge edge, float padding);

  YogaNode setPaddingPercent(YogaEdge edge, float percent);

  /* Position properties */

  YogaNode setPositionType(YogaPositionType positionType);

  YogaNode setPosition(YogaEdge edge, float position);

  YogaNode setPositionPercent(YogaEdge edge, float percent);

  /* Alignment properties */

  YogaNode setAlignContent(YogaAlign alignContent);

  YogaNode setAlignItems(YogaAlign alignItems);

  YogaNode setAlignSelf(YogaAlign alignSelf);

  /* Flex properties */

  YogaNode setFlex(float flex);

  YogaNode setFlexBasisAuto();

  YogaNode setFlexBasisPercent(float percent);

  YogaNode setFlexBasis(float flexBasis);

  YogaNode setFlexDirection(YogaFlexDirection direction);

  YogaNode setFlexGrow(float flexGrow);

  YogaNode setFlexShrink(float flexShrink);

  /* Other properties */

  YogaNode setJustifyContent(YogaJustify justifyContent);

  YogaNode setDirection(YogaDirection direction);

  YogaNode setBorder(YogaEdge edge, float value);

  YogaNode setWrap(YogaWrap wrap);

  YogaNode setAspectRatio(float aspectRatio);

  YogaNode setIsReferenceBaseline(boolean isReferenceBaseline);

  void setMeasureFunction(YogaMeasureFunction measureFunction);

  YogaNode setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

  /* Getters */

  YogaValue getWidth();

  YogaValue getMinWidth();

  YogaValue getMaxWidth();

  YogaValue getHeight();

  YogaValue getMinHeight();

  YogaValue getMaxHeight();

  YogaDirection getStyleDirection();

  YogaFlexDirection getFlexDirection();

  YogaJustify getJustifyContent();

  YogaAlign getAlignItems();

  YogaAlign getAlignSelf();

  YogaAlign getAlignContent();

  YogaPositionType getPositionType();

  float getFlexGrow();

  float getFlexShrink();

  YogaValue getFlexBasis();

  float getAspectRatio();

  YogaValue getMargin(YogaEdge edge);

  YogaValue getPadding(YogaEdge edge);

  YogaValue getPosition(YogaEdge edge);

  float getBorder(YogaEdge edge);
}
