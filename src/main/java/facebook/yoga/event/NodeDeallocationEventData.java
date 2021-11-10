package facebook.yoga.event;

import facebook.yoga.YGConfig;

//C++ TO JAVA CONVERTER WARNING: The original type declaration contained unconverted modifiers:
//ORIGINAL LINE: struct Event::TypedData<Event::NodeDeallocation>
//C++ TO JAVA CONVERTER TODO TASK: C++ template specialization was removed by C++ to Java Converter:
public class NodeDeallocationEventData extends CallableEvent  //Type originates from: event.h
{
    public YGConfig config;

    public NodeDeallocationEventData(YGConfig config) {
        this.config = config;
    }
}