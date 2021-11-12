package io.github.orioncraftmc.meditate.internal.event;

public class LayoutPassStartEventData extends CallableEvent  //Type originates from: event.h
{
    public Object layoutContext;

    public LayoutPassStartEventData(Object layoutContext) {
        this.layoutContext = layoutContext;
    }
}