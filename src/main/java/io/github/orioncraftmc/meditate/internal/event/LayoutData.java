package io.github.orioncraftmc.meditate.internal.event;

import java.util.ArrayList;

public class LayoutData extends CallableEvent //Type originates from: event.h
{
    public int layouts;
    public int measures;
    public int maxMeasureCache;
    public int cachedLayouts;
    public int cachedMeasures;
    public int measureCallbacks;
    public final  ArrayList<Integer> measureCallbackReasonsCount = new ArrayList<>();

    public LayoutData() {
        for (int i = 0; i < LayoutPassReason.COUNT.getValue(); i++) {
            measureCallbackReasonsCount.add(0);
        }
    }
}