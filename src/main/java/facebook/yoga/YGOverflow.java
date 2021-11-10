package facebook.yoga;

public enum YGOverflow {
    YGOverflowVisible,
    YGOverflowHidden,
    YGOverflowScroll;

    public static final int SIZE = java.lang.Integer.SIZE;

    public int getValue() {
        return this.ordinal();
    }

    public static YGOverflow forValue(int value) {
        return values()[value];
    }
}
