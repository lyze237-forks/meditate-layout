package io.github.orioncraftmc.meditate.internal.event;

public class LayoutPassEndEventData extends CallableEvent //Type originates from: event.h
{
    public Object layoutContext;
    public LayoutData layoutData;

    public LayoutPassEndEventData(Object layoutContext, LayoutData layoutData) {
        this.layoutContext = layoutContext;
        this.layoutData = layoutData;
    }
}