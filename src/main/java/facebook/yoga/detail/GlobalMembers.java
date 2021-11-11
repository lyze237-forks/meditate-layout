package facebook.yoga.detail;

import static facebook.GlobalMembers.YGConfigGetDefault;
import facebook.yoga.YGConfig;
import facebook.yoga.YGLogLevel;
import facebook.yoga.YGNode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlobalMembers {
    public static void vlog(@Nullable YGConfig config, YGNode node, YGLogLevel level, Object context, String format, Object... args) {
        @Nullable YGConfig logConfig = config != null ? config : YGConfigGetDefault();
        logConfig.log(logConfig, node, level, context, format, args);
    }

    public static @NotNull Integer log2ceilFn(Integer n) {
        return n < 1 ? 0 : (1 + log2ceilFn(n / 2));
    }

    public static int mask(Integer bitWidth, Integer index) {
        return ((1 << bitWidth) - 1) << index;
    }

    public static <E extends Enum<E>> int bitWidthFn(@NotNull Class<E> e) {
        return (log2ceilFn(e.getEnumConstants().length - 1));
    }

    public static <E extends Enum<E>> E getEnumData(@NotNull Class<E> e, int flags, Integer index) { //TODO: Change to ByRef
        E[] constants = e.getEnumConstants();
        return constants[((flags & mask(bitWidthFn(e), index)) >> index)];
    }


    @Contract(pure = true)
    public static <E extends Enum<E>> int setEnumData(@NotNull Class<E> e, int flags, int index, @NotNull E newValue) {
        return ((flags & ~mask(bitWidthFn(e), index)) | ((newValue.ordinal() << index) & (mask(bitWidthFn(e),
                index))));
    }

    public static boolean getBooleanData(int flags, Integer index) {
        return ((flags >> index) & 1) != 0;
    }

    @Contract(pure = true)
    public static int setBooleanData(int flags, int index, boolean value) {
        if (value) {
            return (flags | 1 << index);
        } else {
            return (flags & ~(1 << index));
        }
    }

    private boolean notEqualsTo(@NotNull CompactValue a, @NotNull CompactValue b) {
        return !CompactValue.equalsTo(a, b);
    }
}
