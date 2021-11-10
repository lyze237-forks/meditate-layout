package facebook.yoga;

import java.util.ArrayList;
import java.util.Arrays;

import static facebook.GlobalMembers.YGFloatArrayEqual;
import static facebook.GlobalMembers.YGUndefined;
import static facebook.yoga.event.GlobalMembers.isUndefined;
import static facebook.yoga.detail.GlobalMembers.*;

public class YGLayout {

    // This value was chosen based on empirical data:
    // 98% of analyzed layouts require less than 8 entries.
    private static final int YG_MAX_CACHED_RESULT_COUNT = 8;

    public ArrayList<Float> position = new ArrayList<>();
    public ArrayList<Float> dimensions = new ArrayList<>(Arrays.asList(YGUndefined, YGUndefined));
    public ArrayList<Float> margin = new ArrayList<>();
    public ArrayList<Float> border = new ArrayList<>();
    public ArrayList<Float> padding = new ArrayList<>();

    private static final int directionOffset = 0;
    private static final int didUseLegacyFlagOffset = directionOffset + bitWidthFn(YGDirection.class);
    private static final int doesLegacyStretchFlagAffectsLayoutOffset = didUseLegacyFlagOffset + 1;
    private static final int hadOverflowOffset = doesLegacyStretchFlagAffectsLayoutOffset + 1;
    private byte flags = 0;

    public int computedFlexBasisGeneration = 0;
    public YGFloatOptional computedFlexBasis = new YGFloatOptional();


    public int generationCount = 0;
    public YGDirection lastOwnerDirection = YGDirection.YGDirectionInherit;

    public int nextCachedMeasurementsIndex = 0;
    public ArrayList<YGCachedMeasurement> cachedMeasurements = new ArrayList<>();
    public ArrayList<Float> measuredDimensions = new ArrayList<>(Arrays.asList(YGUndefined, YGUndefined));

    public YGCachedMeasurement cachedLayout = new YGCachedMeasurement();

    //C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: YGDirection direction() const
    public final YGDirection direction() {
        return getEnumData(YGDirection.class, flags, directionOffset);
    }

    public final void setDirection(YGDirection direction) {
        flags = setEnumData(YGDirection.class, flags, directionOffset, direction);
    }

    //C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean didUseLegacyFlag() const
    public final boolean didUseLegacyFlag() {
        return getBooleanData(flags, didUseLegacyFlagOffset);
    }

    public final void setDidUseLegacyFlag(boolean val) {
        flags = setBooleanData(flags, didUseLegacyFlagOffset, val);
    }

    //C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean doesLegacyStretchFlagAffectsLayout() const
    public final boolean doesLegacyStretchFlagAffectsLayout() {
        return getBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset);
    }

    public final void setDoesLegacyStretchFlagAffectsLayout(boolean val) {
        flags = setBooleanData(flags, doesLegacyStretchFlagAffectsLayoutOffset, val);
    }

    //C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean hadOverflow() const
    public final boolean hadOverflow() {
        return getBooleanData(flags, hadOverflowOffset);
    }

    public final void setHadOverflow(boolean hadOverflow) {
        flags = setBooleanData(flags, hadOverflowOffset, hadOverflow);
    }

    //C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean operator ==(YGLayout layout) const
    public boolean equalsTo(YGLayout layout) //Method definition originates from: YGLayout.cpp
    {
        boolean isEqual = YGFloatArrayEqual(position, layout.position) && YGFloatArrayEqual(dimensions, layout.dimensions) && YGFloatArrayEqual(margin, layout.margin) && YGFloatArrayEqual(border, layout.border) && YGFloatArrayEqual(padding, layout.padding) && direction() == layout.direction() && hadOverflow() == layout.hadOverflow() && lastOwnerDirection == layout.lastOwnerDirection && nextCachedMeasurementsIndex == layout.nextCachedMeasurementsIndex && cachedLayout.equalsTo(layout.cachedLayout) && computedFlexBasis == layout.computedFlexBasis;

        for (int i = 0; i < YG_MAX_CACHED_RESULT_COUNT && isEqual; ++i) {
            isEqual = isEqual && cachedMeasurements.get(i).equalsTo(layout.cachedMeasurements.get(i));
        }

        if (!isUndefined(measuredDimensions.get(0)) || !isUndefined(layout.measuredDimensions.get(0))) {
            isEqual = isEqual && (measuredDimensions.get(0) == layout.measuredDimensions.get(0));
        }
        if (!isUndefined(measuredDimensions.get(1)) || !isUndefined(layout.measuredDimensions.get(1))) {
            isEqual = isEqual && (measuredDimensions.get(1) == layout.measuredDimensions.get(1));
        }

        return isEqual;
    }

    public boolean notEqualsTo(YGLayout layout) {
        return !(this.equalsTo(layout));
    }
}
