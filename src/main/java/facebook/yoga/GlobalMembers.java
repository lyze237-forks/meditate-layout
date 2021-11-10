package facebook.yoga;

public class GlobalMembers {
    public static boolean isUndefined(float value) {
        return Float.isNaN(value);
    }

    public static boolean isUndefined(double value) {
        return Double.isNaN(value);
    }
}
