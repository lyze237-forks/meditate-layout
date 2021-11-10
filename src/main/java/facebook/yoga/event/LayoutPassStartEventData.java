package facebook.yoga.event;

//C++ TO JAVA CONVERTER WARNING: The original type declaration contained unconverted modifiers:
//ORIGINAL LINE: struct Event::TypedData<Event::LayoutPassStart>
//C++ TO JAVA CONVERTER TODO TASK: C++ template specialization was removed by C++ to Java Converter:
public class LayoutPassStartEventData extends CallableEvent  //Type originates from: event.h
{
    public Object layoutContext;

    public LayoutPassStartEventData(Object layoutContext) {
        this.layoutContext = layoutContext;
    }
}