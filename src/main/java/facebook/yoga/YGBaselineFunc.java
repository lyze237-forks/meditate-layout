package facebook.yoga;

@FunctionalInterface
public
interface YGBaselineFunc
{
	float invoke(YGNode node, float width, float height);
}