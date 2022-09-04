package io.github.orioncraftmc.meditate.internal.interfaces;

import io.github.orioncraftmc.meditate.internal.YGNode;

@FunctionalInterface
public
interface YGCloneNodeFunc {
     YGNode invoke(YGNode oldNode, YGNode owner, int childIndex);
}
//ORIGINAL LINE: template <typename T, typename NeedsUpdate, typename Update>