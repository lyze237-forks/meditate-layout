package facebook.yoga.detail;

public class GlobalMembers
{
public static void vlog(YGConfig config, YGNode node, YGLogLevel level, Object context, String format, va_list args)
{
  YGConfig logConfig = config != null ? config : YGConfigGetDefault();
  logConfig.log(logConfig, node, level, context, format, new va_list(args));
}




















	public static Integer log2ceilFn(Integer n)
	{
	  return n < 1 ? 0 : (1 + detail.GlobalMembers.log2ceilFn(n / 2));
	}

	public static int mask(Integer bitWidth, Integer index)
	{
	  return ((1 << bitWidth) - 1) << index;
	}


//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> Integer bitWidthFn()
	{
	//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
	//  static_assert(enums::count<Enum>() > 0, "Enums must have at least one entries");
	  return (detail.GlobalMembers.log2ceilFn(enums.<Enum>count() - 1));
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> Enum getEnumData(int flags, Integer index)
	{
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
	  return (Enum)((flags & detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), index)) >> index);
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> void setEnumData(tangible.RefObject<Integer> flags, Integer index, int newValue)
	{
	  flags.argValue = (flags.argValue & ~detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), index)) | ((newValue << index) & (detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), index)));
	}

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Enum>
	public static <Enum> void setEnumData(tangible.RefObject<Byte> flags, Integer index, int newValue)
	{
	  flags.argValue = (byte)((flags.argValue & ~(Byte)detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), index)) | ((newValue << index) & ((Byte)detail.GlobalMembers.mask(detail.GlobalMembers.<Enum>bitWidthFn(), index))));
	}

	public static boolean getBooleanData(int flags, Integer index)
	{
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
	  return ((flags >> index) & 1) != 0;
	}

	public static void setBooleanData(Byte flags, Integer index, boolean value)
	{
	  if (value)
	  {
		flags |= 1 << index;
	  }
	  else
	  {
		flags &= ~(1 << index);
	  }
	}

	private boolean notEqualsTo(CompactValue a, CompactValue b)
	{
	  return !a.equalsTo(b);
	}
}