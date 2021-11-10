package facebook.yoga;

public enum YGLogLevel {
    YGLogLevelError,
    YGLogLevelWarn,
    YGLogLevelInfo,
    YGLogLevelDebug,
    YGLogLevelVerbose,
    YGLogLevelFatal;

    public static final int SIZE = java.lang.Integer.SIZE;

    public static YGLogLevel forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
