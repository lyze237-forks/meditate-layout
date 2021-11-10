package facebook.yoga;

@FunctionalInterface
interface YGNodeCleanupFunc {
    void invoke(YGNode node);
}
