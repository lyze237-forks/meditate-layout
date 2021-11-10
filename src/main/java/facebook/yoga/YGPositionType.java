package facebook.yoga;

public enum YGPositionType {
    YGPositionTypeStatic,
    YGPositionTypeRelative,
    YGPositionTypeAbsolute;

    public int getValue() {
        return this.ordinal();
    }

    public static YGPositionType forValue(int value) {
        return values()[value];
    }
}
