package facebook.yoga.event;

public enum LayoutPassReason //Type originates from: event.h
{
  kInitial(0),
  kAbsLayout(1),
  kStretch(2),
  kMultilineStretch(3),
  kFlexLayout(4),
  kMeasureChild(5),
  kAbsMeasureChild(6),
  kFlexMeasure(7),
  COUNT(8);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, LayoutPassReason> mappings;
	private static java.util.HashMap<Integer, LayoutPassReason> getMappings()
	{
		if (mappings == null)
		{
			synchronized (LayoutPassReason.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, LayoutPassReason>();
				}
			}
		}
		return mappings;
	}

	private LayoutPassReason(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static LayoutPassReason forValue(int value)
	{
		return getMappings().get(value);
	}
}