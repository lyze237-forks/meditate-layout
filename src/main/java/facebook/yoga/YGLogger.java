package facebook.yoga;

@FunctionalInterface
public interface YGLogger {
    int invoke(YGConfig config, YGNode node, YGLogLevel level, String format, Object... args);
}
