package io.github.orioncraftmc.meditate.internal.detail;

import io.github.orioncraftmc.meditate.internal.YGValue;
import io.github.orioncraftmc.meditate.internal.enums.YGEdge;
import java.util.ArrayList;


public class Values<T> //Type originates from: Yoga-internal.h
{
    private final ArrayList<CompactValue> values_;


    public Values() {
        values_ = new ArrayList<>();
    }

    public Values(final  YGValue defaultValue) {
        values_ = new ArrayList<>();
        values_.add(CompactValue.createCompactValue(defaultValue));
    }

    public Values(final  YGValue defaultValue, int size) {
        values_ = new ArrayList<>(size);
        values_.add(CompactValue.createCompactValue(defaultValue));
    }

    public final  CompactValue get(Integer i) {
        return CompactValue.createCompactValue(getValue(i).convertToYgValue());
    }

    private CompactValue getValue(Integer i) {
        while (values_.size() < (i + 1)) {
            values_.add(CompactValue.ofUndefined());
        }
        return values_.get(i);
    }

    public final void set(Integer i, CompactValue value) {
        values_.set(i, value);
    }

    public final  CompactValue getCompactValue( YGEdge edge) {
        return getCompactValue(edge.getValue());
    }

    public final  CompactValue getCompactValue(Integer i) {
        return CompactValue.createCompactValue(getValue(i).convertToYgValue());
    }

    public final YGValue get(int i) {
        return getValue(i).convertToYgValue();
    }


    public final void set(int i,  YGValue value) {
        values_.set(i, CompactValue.createCompactValue(value));
    }

    public boolean equalsTo(final  Values<T> other) {
        for (int i = 0; i < values_.size(); ++i) {
            if (getValue(i) != other.getValue(i)) {
                return false;
            }
        }
        return true;
    }
}