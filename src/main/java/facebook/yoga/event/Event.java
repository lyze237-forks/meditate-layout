package facebook.yoga.event;

import facebook.yoga.event.GlobalMembers;

public class Event //Type originates from: event.h
{
  public enum Type //Type originates from: event.h
  {
	NodeAllocation,
	NodeDeallocation,
	NodeLayout,
	LayoutPassStart,
	LayoutPassEnd,
	MeasureCallbackStart,
	MeasureCallbackEnd,
	NodeBaselineStart,
	NodeBaselineEnd;

	  public static final int SIZE = java.lang.Integer.SIZE;

	  public int getValue()
	  {
		  return this.ordinal();
	  }

	  public static Type forValue(int value)
	  {
		  return values()[value];
	  }
  }
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following type could not be found:
//  class Data;
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//  typedef void(final YGNode UnnamedParameter, Type UnnamedParameter2, DataSubscriber UnnamedParameter3);

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <Type E>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename E> requires Type<E>
  public static class TypedData<E> //Type originates from: event.h
  {
  }

  public static class Data //Type originates from: event.h
  {
	private final Object data_;

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <Type E>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename E> requires Type<E>
	public Data(final TypedData<E> data)
	{
		this.data_ = data;
	}

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <Type E>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename E> requires Type<E>
//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: const TypedData<E>& get() const
	public final <E> TypedData<E> get()
	{
	  return (TypedData<E>)data_;
	}
  }

  public static void reset() //Method definition originates from: event.cpp
  {
	var head = facebook.yoga.event.GlobalMembers.push(null);
	while (head != null)
	{
	  var current = new auto(head);
	  head = head.next;
	  current = null;
	}
  }

//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  public static void subscribe(std::function<Subscriber>&& subscriber) //Method definition originates from: event.cpp
  {
	facebook.yoga.event.GlobalMembers.push(new Node(new std::function(std::move(subscriber))));
  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <Type E>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename E> requires Type<E>
  public static <E> void publish(final YGNode node)
  {
	  publish(node, new TypedData<E>());
  }
//C++ TO JAVA CONVERTER NOTE: Java does not allow default values for parameters. Overloaded methods are inserted above:
//ORIGINAL LINE: static void publish(const YGNode& node, const TypedData<E>& eventData = {})
  public static <E> void publish(final YGNode node, final TypedData<E> eventData)
  {



  }

//C++ TO JAVA CONVERTER TODO TASK: Most C++ 'constraints' are not converted by C++ to Java Converter:
//ORIGINAL LINE: template <Type E>
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template <typename E> requires Type<E>
  public static <E> void publish(YGNode node)
  {
	  publish(node, new TypedData<E>());
  }
//C++ TO JAVA CONVERTER NOTE: Java does not allow default values for parameters. Overloaded methods are inserted above:
//ORIGINAL LINE: static void publish(const YGNode* node, const TypedData<E>& eventData = {})
  public static <E> void publish(YGNode node, final TypedData<E> eventData)
  {
	facebook.yoga.Event.<E>publish(node, eventData);
  }

  private static void publish(final YGNode node, Type eventType, final Data eventData) //Method definition originates from: event.cpp
  {
	for (var subscriber = GlobalMembers.subscribers.load(std::memory_order_relaxed); subscriber != null; subscriber = subscriber.next)
	{
	  subscriber.subscriber(node, eventType, eventData);
	}
  }
}