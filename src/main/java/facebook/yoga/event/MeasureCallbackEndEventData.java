package facebook.yoga.event;

import facebook.yoga.YGMeasureMode;

//C++ TO JAVA CONVERTER WARNING: The original type declaration contained unconverted modifiers:
//ORIGINAL LINE: struct Event::TypedData<Event::MeasureCallbackEnd>
//C++ TO JAVA CONVERTER TODO TASK: C++ template specialization was removed by C++ to Java Converter:
public class MeasureCallbackEndEventData extends CallableEvent  //Type originates from: event.h
{
  public Object layoutContext;
  public float width;
  public YGMeasureMode widthMeasureMode;
  public float height;
  public YGMeasureMode heightMeasureMode;
  public float measuredWidth;
  public float measuredHeight;
  public LayoutPassReason reason;
}