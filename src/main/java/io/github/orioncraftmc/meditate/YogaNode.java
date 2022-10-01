/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.github.orioncraftmc.meditate;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import io.github.orioncraftmc.meditate.enums.*;
import io.github.orioncraftmc.meditate.interfaces.*;

public abstract class YogaNode implements YogaProps {

  /** The interface the {@link #getData()} object can optionally implement. */
  public interface Inputs {

    /** Requests the data object to disable mutations of its inputs. */
    void freeze(final YogaNode node, final  YogaNode parent);
  }

  public abstract void reset();

  public abstract int getChildCount();

  public abstract YogaNode getChildAt(int i);

  public abstract void addChildAt(YogaNode child, int i);

  public abstract YogaNode setIsReferenceBaseline(boolean isReferenceBaseline);

  public abstract boolean isReferenceBaseline();

  public abstract YogaNode removeChildAt(int i);

  /**
   * @return the {@link YogaNode} that owns this {@link YogaNode}. The owner is used to identify
   *     the YogaTree that a {@link YogaNode} belongs to. This method will return the parent of the
   *     {@link YogaNode} when the {@link YogaNode} only belongs to one YogaTree or null when the
   *     {@link YogaNode} is shared between two or more YogaTrees.
   */
  
  public abstract YogaNode getOwner();

  /** @deprecated Use #getOwner() instead. This will be removed in the next version. */
  @Deprecated
  
  public abstract YogaNode getParent();

  public abstract int indexOf(YogaNode child);

  public abstract void calculateLayout(float width, float height);

  public abstract boolean hasNewLayout();

  public abstract void dirty();

  public abstract boolean isDirty();

  public abstract void copyStyle(YogaNode srcNode);

  public abstract void markLayoutSeen();

  public abstract YogaDirection getStyleDirection();

  public abstract YogaNode setDirection(YogaDirection direction);

  public abstract YogaFlexDirection getFlexDirection();

  public abstract YogaNode setFlexDirection(YogaFlexDirection flexDirection);

  public abstract YogaJustify getJustifyContent();

  public abstract YogaNode setJustifyContent(YogaJustify justifyContent);

  public abstract YogaAlign getAlignItems();

  public abstract YogaNode setAlignItems(YogaAlign alignItems);

  public abstract YogaAlign getAlignSelf();

  public abstract YogaNode setAlignSelf(YogaAlign alignSelf);

  public abstract YogaAlign getAlignContent();

  public abstract YogaNode setAlignContent(YogaAlign alignContent);

  public abstract YogaPositionType getPositionType();

  public abstract YogaNode setPositionType(YogaPositionType positionType);

  public abstract YogaWrap getWrap();

  public abstract YogaNode setWrap(YogaWrap flexWrap);

  public abstract YogaOverflow getOverflow();

  public abstract YogaNode setOverflow(YogaOverflow overflow);

  public abstract YogaDisplay getDisplay();

  public abstract YogaNode setDisplay(YogaDisplay display);

  public abstract float getFlex();

  public abstract YogaNode setFlex(float flex);

  public abstract float getFlexGrow();

  public abstract YogaNode setFlexGrow(float flexGrow);

  public abstract float getFlexShrink();

  public abstract YogaNode setFlexShrink(float flexShrink);

  public abstract YogaValue getFlexBasis();

  public abstract YogaNode setFlexBasis(float flexBasis);

  public abstract YogaNode setFlexBasisPercent(float percent);

  public abstract YogaNode setFlexBasisAuto();

  public abstract YogaValue getMargin(YogaEdge edge);

  public abstract YogaNode setMargin(YogaEdge edge, float margin);

  public abstract YogaNode setMarginPercent(YogaEdge edge, float percent);

  public abstract YogaNode setMarginAuto(YogaEdge edge);

  public abstract YogaValue getPadding(YogaEdge edge);

  public abstract YogaNode setPadding(YogaEdge edge, float padding);

  public abstract YogaNode setPaddingPercent(YogaEdge edge, float percent);

  public abstract float getBorder(YogaEdge edge);

  public abstract YogaNode setBorder(YogaEdge edge, float border);

  public abstract YogaValue getPosition(YogaEdge edge);

  public abstract YogaNode setPosition(YogaEdge edge, float position);

  public abstract YogaNode setPositionPercent(YogaEdge edge, float percent);

  public abstract YogaValue getWidth();

  public abstract YogaNode setWidth(float width);

  public abstract YogaNode setWidthPercent(float percent);

  public abstract YogaNode setWidthAuto();

  public abstract YogaValue getHeight();

  public abstract YogaNode setHeight(float height);

  public abstract YogaNode setHeightPercent(float percent);

  public abstract YogaNode setHeightAuto();

  public abstract YogaValue getMinWidth();

  public abstract YogaNode setMinWidth(float minWidth);

  public abstract YogaNode setMinWidthPercent(float percent);

  public abstract YogaValue getMinHeight();

  public abstract YogaNode setMinHeight(float minHeight);

  public abstract YogaNode setMinHeightPercent(float percent);

  public abstract YogaValue getMaxWidth();

  public abstract YogaNode setMaxWidth(float maxWidth);

  public abstract YogaNode setMaxWidthPercent(float percent);

  public abstract YogaValue getMaxHeight();

  public abstract YogaNode setMaxHeight(float maxheight);

  public abstract YogaNode setMaxHeightPercent(float percent);

  public abstract YogaNode setSize(float size);
  
  public abstract YogaNode setSizePercent(float percent);
  
  public abstract YogaNode setMinSize(float minSize);
  
  public abstract YogaNode setMinSizePercent(float percent);
  
  public abstract YogaNode setMaxSize(float minSize);
  
  public abstract YogaNode setMaxSizePercent(float percent);
  
  public abstract YogaNode setSizeAuto();
  
  public abstract float getAspectRatio();

  public abstract YogaNode setAspectRatio(float aspectRatio);
  
  /**
   * Sets the background of the node to a Scene2D Drawable. If the drawable has padding specified, the node's padding is
   * set to these values. The background is ignored outside Scene2D layouts as Yoga/Meditate do not do drawing on their
   * own. See {@link dev.lyze.flexbox.FlexBox}.
   * @param background The Drawable to be set as the background of the node.
   * @return The node for chaining methods together.
   */
  public abstract YogaNode setBackground(Drawable background);
  
  /**
   * Returns the background of the node to a Scene2D Drawable. The background is ignored outside Scene2D layouts as
   * Yoga/Meditate do not do drawing on their own. See {@link dev.lyze.flexbox.FlexBox}.
   * @return The Drawable to be set as the background of the node.
   */
  public abstract Drawable getBackground();

  public abstract float getLayoutX();

  public abstract float getLayoutY();

  public abstract float getLayoutWidth();

  public abstract float getLayoutHeight();

  public abstract float getLayoutMargin(YogaEdge edge);

  public abstract float getLayoutPadding(YogaEdge edge);

  public abstract float getLayoutBorder(YogaEdge edge);

  public abstract YogaDirection getLayoutDirection();

  public abstract void setMeasureFunction(YogaMeasureFunction measureFunction);

  public abstract YogaNode setBaselineFunction(YogaBaselineFunction baselineFunction);

  public abstract boolean isMeasureDefined();

  public abstract boolean isBaselineDefined();

  public abstract YogaNode setData(Object data);

  
  public abstract Object getData();

  public abstract void print();

  public abstract YogaNode cloneWithoutChildren();

  public abstract YogaNode cloneWithChildren();
}
