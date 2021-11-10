package facebook.yoga;

@FunctionalInterface
public
interface YGNodeCleanupFunc {
    void invoke(YGNode node);
}
