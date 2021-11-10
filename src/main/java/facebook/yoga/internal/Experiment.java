package facebook.yoga.internal;

public enum Experiment {
    kDoubleMeasureCallbacks;

    public static final int SIZE = java.lang.Integer.SIZE;

    public int getValue() {
        return this.ordinal();
    }

    public static Experiment forValue(int value) {
        return values()[value];
    }
}
