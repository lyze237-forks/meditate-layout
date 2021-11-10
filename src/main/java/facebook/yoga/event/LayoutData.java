package facebook.yoga.event;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class LayoutData extends CallableEvent //Type originates from: event.h
{
    public int layouts;
    public int measures;
    public int maxMeasureCache;
    public int cachedLayouts;
    public int cachedMeasures;
    public int measureCallbacks;
    public @NotNull ArrayList<Integer> measureCallbackReasonsCount = new ArrayList<>(LayoutPassReason.COUNT.getValue());
}