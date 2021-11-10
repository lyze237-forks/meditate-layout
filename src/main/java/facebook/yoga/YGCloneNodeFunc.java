package facebook.yoga;

import facebook.yoga.*;
import detail.Log;
import detail.CompactValue;

@FunctionalInterface
public
interface YGCloneNodeFunc
{
	YGNode invoke(YGNode oldNode, YGNode owner, int childIndex);
}
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename T, typename NeedsUpdate, typename Update>