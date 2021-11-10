package facebook.yoga;

public enum YGEdge {
    YGEdgeLeft,
    YGEdgeTop,
    YGEdgeRight,
    YGEdgeBottom,
    YGEdgeStart,
    YGEdgeEnd,
    YGEdgeHorizontal,
    YGEdgeVertical,
    YGEdgeAll;

    public static final int SIZE = java.lang.Integer.SIZE;

    public static YGEdge forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
