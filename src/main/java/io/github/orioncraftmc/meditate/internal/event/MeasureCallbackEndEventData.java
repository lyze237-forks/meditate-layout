package io.github.orioncraftmc.meditate.internal.event;

import io.github.orioncraftmc.meditate.internal.enums.YGMeasureMode;

public class MeasureCallbackEndEventData extends CallableEvent  //Type originates from: event.h
{
    public Object layoutContext;
    public float width;
    public YGMeasureMode widthMeasureMode;
    public float height;
    public YGMeasureMode heightMeasureMode;
    public float measuredWidth;
    public float measuredHeight;
    public LayoutPassReason reason;

    public MeasureCallbackEndEventData(Object layoutContext, float width, YGMeasureMode widthMeasureMode, float height, YGMeasureMode heightMeasureMode, float measuredWidth, float measuredHeight, LayoutPassReason reason) {
        this.layoutContext = layoutContext;
        this.width = width;
        this.widthMeasureMode = widthMeasureMode;
        this.height = height;
        this.heightMeasureMode = heightMeasureMode;
        this.measuredWidth = measuredWidth;
        this.measuredHeight = measuredHeight;
        this.reason = reason;
    }
}