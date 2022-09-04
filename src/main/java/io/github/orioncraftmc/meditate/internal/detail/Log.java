package io.github.orioncraftmc.meditate.internal.detail;

//struct YGNode;
//struct YGConfig;


import io.github.orioncraftmc.meditate.internal.YGConfig;
import io.github.orioncraftmc.meditate.internal.YGNode;
import io.github.orioncraftmc.meditate.internal.enums.YGLogLevel;

public class Log {

    public static void log( YGNode node, YGLogLevel level, Object context, String format, Object... args) {
        GlobalMembers.vlog(node == null ? null : node.getConfig(), node, level, context, format, args);
    }

    public static void log(YGConfig config, YGLogLevel level, Object context, String format, Object... args) {
        GlobalMembers.vlog(config, null, level, context, format, args);
    }
}
