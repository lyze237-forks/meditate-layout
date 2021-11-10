package facebook.yoga;

public enum YGDimension {
    YGDimensionWidth,
    YGDimensionHeight;

    public static final int SIZE = java.lang.Integer.SIZE;

    public static YGDimension forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
