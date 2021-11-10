package facebook.yoga;

public enum YGPositionType {
    YGPositionTypeStatic,
    YGPositionTypeRelative,
    YGPositionTypeAbsolute;

    public static YGPositionType forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
