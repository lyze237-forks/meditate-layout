package facebook.yoga.detail;

import facebook.yoga.YGValue;
import java.util.ArrayList;


public class Values //Type originates from: Yoga-internal.h
{
    private ArrayList<CompactValue> values_;
    private final int size;


    //  Values() = default;
    public Values(final YGValue defaultValue, int size) {
        values_ = new ArrayList<>(size);
        this.size = size;
        values_.add(CompactValue.createCompactValue(defaultValue));
    }

    public final CompactValue get(Integer i) {
        return CompactValue.createCompactValue(values_.get(i).convertToYgValue());
    }

    public final void set(Integer i, CompactValue value) {
        values_.set(i, value);
    }

    public final CompactValue getCompactValue(Integer i) {
        return CompactValue.createCompactValue(values_.get(i).convertToYgValue());
    }



    public final YGValue get(int i) {
        return values_.get(i).convertToYgValue();
    }


    public final void set(YGValue value, int i) {
        values_.set(i, CompactValue.createCompactValue(value));
    }

    public boolean equalsTo(final Values other) {
        for (int i = 0; i < size; ++i) {
            if (values_.get(i) != other.values_.get(i)) {
                return false;
            }
        }
        return true;
    }
}