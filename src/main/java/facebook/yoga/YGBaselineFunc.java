package facebook.yoga;

import facebook.yoga.*;
import detail.Log;
import detail.CompactValue;

@FunctionalInterface
public
interface YGBaselineFunc
{
	float invoke(YGNode node, float width, float height);
}