package io.github.orioncraftmc.meditate.internal;

import java.util.ArrayList;

public class YGCollectFlexItemsRowValues //Type originates from: Utils.h
{
    public int itemsOnLine;
    public float sizeConsumedOnCurrentLine;
    public float totalFlexGrowFactors;
    public float totalFlexShrinkScaledFactors;
    public int endOfLineIndex;
    public final  ArrayList<YGNode> relativeChildren = new ArrayList<>();
    public float remainingFreeSpace;
    public float mainDim;
    public float crossDim;
}