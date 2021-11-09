package facebook.yoga.detail;

import java.util.*;

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t Size>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename Size> requires size_t<Size>
public class Values<Size> //Type originates from: Yoga-internal.h
{
  private ArrayList<CompactValue> values_ = new ArrayList<>(Size);

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = default':
//  Values() = default;
  public Values(final YGValue defaultValue)
  {
	values_.fill(defaultValue);
  }

  public final CompactValue get(Integer i)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return values_[i];
	  return CompactValue.createCompactValue(values_.get(i));
  }
  public final void set(Integer i, CompactValue value)
  {
	  values_.set(i, value);
  }
  public final CompactValue get(Integer i)
  {
//C++ TO JAVA CONVERTER TODO TASK: The following line was determined to contain a copy constructor call - this should be verified and a copy constructor should be created:
//ORIGINAL LINE: return values_[i];
	  return CompactValue.createCompactValue(values_.get(i));
  }
  public final void set(Integer i, CompactValue value)
  {
	  values_.set(i, value);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
  public final <I> YGValue get()
  {
	return std::get<I>(values_);
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
  public final <I> void set(YGValue value)
  {
	std::get<I>(values_) = value;
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <size_t I>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename I> requires size_t<I>
//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  public final <I> void set(YGValue && value)
  {
	this.<I>set(value);
  }

  public boolean equalsTo(final Values other)
  {
	for (Integer i = 0; i < Size; ++i)
	{
	  if (values_.get(i) != other.values_.get(i))
	  {
		return false;
	  }
	}
	return true;
  }

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to ' = default':
//  Values& operator =(const Values& other) = default;
}