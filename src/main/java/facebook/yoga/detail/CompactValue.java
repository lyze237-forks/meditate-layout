package facebook.yoga.detail;

//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
//static_assert(std::numeric_limits<float>::is_iec559, "facebook::yoga::detail::CompactValue only works with IEEE754 floats");


import facebook.yoga.YGUnit;
import facebook.yoga.YGValue;

import static facebook.GlobalMembers.YGValueAuto;
import static facebook.GlobalMembers.YGValueUndefined;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompactValue //Type originates from: CompactValue.h
{
    public static final float LOWER_BOUND = 1.08420217e-19f;
    public static final float UPPER_BOUND_POINT = 36893485948395847680.0f;
    public static final float UPPER_BOUND_PERCENT = 18446742974197923840.0f;
    private static final Integer BIAS = 0x20000000;
    private static final Integer PERCENT_BIT = 0x40000000;
    private static final Integer AUTO_BITS = 0x7faaaaaa;
    private static final Integer ZERO_BITS_POINT = 0x7f8f0f0f;
    private static final Integer ZERO_BITS_PERCENT = 0x7f80f0f0;
    private Payload payload_ = new Payload(0);
    private boolean undefined;

    public CompactValue() {
        undefined = true;
        this.payload_ = new CompactValue.Payload(Float.NaN);
    }

    private CompactValue(Payload data) {
        this.payload_ = data;
    }

    //C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <YGUnit Unit>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Unit> requires YGUnit<Unit>
    public static @NotNull CompactValue of(float value, YGUnit Unit) {
        if (value == 0.0f || (value < LOWER_BOUND && value > -LOWER_BOUND)) {
            @NotNull final var zero = Unit == YGUnit.YGUnitPercent ? ZERO_BITS_PERCENT : ZERO_BITS_POINT;
            return new CompactValue(new Payload(zero));
        }

        final var upperBound = Unit == YGUnit.YGUnitPercent ? UPPER_BOUND_PERCENT : UPPER_BOUND_POINT;
        if (value > upperBound || value < -upperBound) {
            value = Math.copySign(upperBound, value);
        }

        int unitBit = Unit == YGUnit.YGUnitPercent ? PERCENT_BIT : 0;
        @NotNull var data = new Payload((value));
        data.repr -= BIAS;
        data.repr |= unitBit;
        return new CompactValue(data);
    }

    //C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <YGUnit Unit>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Unit> requires YGUnit<Unit>
    public static @NotNull CompactValue ofMaybe(float value, YGUnit Unit) {
        return Float.isNaN(value) || Float.isInfinite(value) ? ofUndefined() : CompactValue.of(value, Unit);
    }

    public static @NotNull CompactValue ofZero() {
        return new CompactValue(new Payload(ZERO_BITS_POINT));
    }

    public static @NotNull CompactValue ofUndefined() {
        return new CompactValue();
    }

    public static @NotNull CompactValue ofAuto() {
        return new CompactValue(new Payload(AUTO_BITS));
    }

    public static @NotNull CompactValue createCompactValue(final @NotNull YGValue x) {
        @Nullable CompactValue compactValue = ofUndefined();
        switch (x.unit) {
            case YGUnitUndefined:
                compactValue = ofUndefined();
                break;
            case YGUnitAuto:
                compactValue = ofAuto();
                break;
            case YGUnitPoint:
                compactValue = CompactValue.of(x.value, YGUnit.YGUnitPoint);
                break;
            case YGUnitPercent:
                compactValue = CompactValue.of(x.value, YGUnit.YGUnitPercent);
                break;
        }
        compactValue.payload_ = new CompactValue.Payload(0);

        return compactValue;
    }

    public static boolean equalsTo(@NotNull CompactValue a, @NotNull CompactValue b) //Method definition originates from: CompactValue.h
    {
        return a.payload_.repr.equals(b.payload_.repr);
    }

    //C++ TO JAVA CONVERTER TODO TASK: The following operator cannot be converted to Java:
    public YGValue convertToYgValue() {
        if (payload_.repr.equals(AUTO_BITS)) {
            return YGValueAuto;
        } else if (payload_.repr.equals(ZERO_BITS_POINT)) {
            return new YGValue(0.0f, YGUnit.YGUnitPoint);
        } else if (payload_.repr.equals(ZERO_BITS_PERCENT)) {
            return new YGValue(0.0f, YGUnit.YGUnitPercent);
        }

        if (Float.isNaN(payload_.value)) {
            return YGValueUndefined;
        }

        var data = payload_;
        data.repr &= ~PERCENT_BIT;
        data.repr += BIAS;

        return new YGValue(data.value, (payload_.repr & 0x40000000) != 0 ? YGUnit.YGUnitPercent : YGUnit.YGUnitPoint);
    }

    public final boolean isUndefined() {
        return undefined || (!payload_.repr.equals(AUTO_BITS) && !payload_.repr.equals(ZERO_BITS_POINT) && !payload_.repr.equals(
                ZERO_BITS_PERCENT) && Float.isNaN(
                payload_.value));
    }

    public final boolean isAuto() {
        return payload_.repr.equals(AUTO_BITS);
    }

    private Integer repr() {
        return (payload_.repr);
    }

    private static class Payload //Type originates from: CompactValue.h
    {
        public float value;
        public Integer repr = 0;

        public Payload(Integer r) {
            this.repr = r;
        }

        public Payload(float v) {
            this.value = v;
        }
    }
}
