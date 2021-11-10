package facebook.yoga;

public enum YGFlexDirection {
    YGFlexDirectionColumn,
    YGFlexDirectionColumnReverse,
    YGFlexDirectionRow,
    YGFlexDirectionRowReverse;

    public static final int SIZE = java.lang.Integer.SIZE;

    public int getValue() {
        return this.ordinal();
    }

    public static YGFlexDirection forValue(int value) {
        return values()[value];
    }
}
