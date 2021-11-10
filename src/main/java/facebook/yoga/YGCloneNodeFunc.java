package facebook.yoga;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public
interface YGCloneNodeFunc
{
	@NotNull YGNode invoke(YGNode oldNode, YGNode owner, int childIndex);
}
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename T, typename NeedsUpdate, typename Update>