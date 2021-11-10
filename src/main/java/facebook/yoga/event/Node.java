package facebook.yoga.event;
import java.util.*;

public class Node //Type originates from: event.cpp
{
  public std::function<Event.Subscriber> subscriber = null;
  public Node next = null;

//C++ TO JAVA CONVERTER TODO TASK: 'rvalue references' have no equivalent in Java:
  public Node(std::function<Event.Subscriber>&& subscriber)
  {
	  this.subscriber = std::move(subscriber);
  }
}