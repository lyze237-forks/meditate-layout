package facebook.yoga;

public enum YGFlexDirection {
    YGFlexDirectionColumn,
    YGFlexDirectionColumnReverse,
    YGFlexDirectionRow,
    YGFlexDirectionRowReverse;

    public static final int SIZE = java.lang.Integer.SIZE;

    public static YGFlexDirection forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
