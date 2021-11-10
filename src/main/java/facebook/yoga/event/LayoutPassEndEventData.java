package facebook.yoga.event;

//C++ TO JAVA CONVERTER WARNING: The original type declaration contained unconverted modifiers:
//ORIGINAL LINE: struct Event::TypedData<Event::LayoutPassEnd>
//C++ TO JAVA CONVERTER TODO TASK: C++ template specialization was removed by C++ to Java Converter:
public class LayoutPassEndEventData extends CallableEvent //Type originates from: event.h
{
  public LayoutPassEndEventData(Object layoutContext, LayoutData layoutData) {
    this.layoutContext = layoutContext;
    this.layoutData = layoutData;
  }

  public Object layoutContext;
  public LayoutData layoutData;
}