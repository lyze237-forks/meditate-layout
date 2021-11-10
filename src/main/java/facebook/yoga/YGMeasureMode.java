package facebook.yoga;

public enum YGMeasureMode {
    YGMeasureModeUndefined,
    YGMeasureModeExactly,
    YGMeasureModeAtMost;

    public static final int SIZE = java.lang.Integer.SIZE;

    public int getValue() {
        return this.ordinal();
    }

    public static YGMeasureMode forValue(int value) {
        return values()[value];
    }
}
