package facebook.yoga.detail;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGNode;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//struct YGConfig;


import facebook.yoga.YGConfig;
import facebook.yoga.YGLogLevel;
import facebook.yoga.YGNode;

public class Log {

    public static void log(YGNode node, YGLogLevel level, Object context, String format, Object... args) {
        GlobalMembers.vlog(node == null ? null : node.getConfig(), node, level, context, format, args);
    }

    public static void log(YGConfig config, YGLogLevel level, Object context, String format, Object... args) {
        GlobalMembers.vlog(config, null, level, context, format, args);
    }
}
