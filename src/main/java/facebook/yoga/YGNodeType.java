package facebook.yoga;

public enum YGNodeType {
    YGNodeTypeDefault,
    YGNodeTypeText;

    public static final int SIZE = java.lang.Integer.SIZE;

    public static YGNodeType forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
