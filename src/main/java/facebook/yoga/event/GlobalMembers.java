package facebook.yoga.event;


import java.util.concurrent.atomic.AtomicReference;

public class GlobalMembers
{
	public static String LayoutPassReasonToString(final LayoutPassReason value) //Method definition originates from: event.cpp
	{
	  switch (value)
	  {
		case kInitial:
		  return "initial";
		case kAbsLayout:
		  return "abs_layout";
		case kStretch:
		  return "stretch";
		case kMultilineStretch:
		  return "multiline_stretch";
		case kFlexLayout:
		  return "flex_layout";
		case kMeasureChild:
		  return "measure";
		case kAbsMeasureChild:
		  return "abs_measure";
		case kFlexMeasure:
		  return "flex_measure";
		default:
		  return "unknown";
	  }
	}

public static AtomicReference<Node> subscribers = new AtomicReference<Node>(null);

public static Node push(Node newHead)
{
  Node oldHead;
  do
  {
	oldHead = GlobalMembers.subscribers.load(std::memory_order_relaxed);
	if (newHead != null)
	{
	  newHead.next = oldHead;
	}
  } while (!GlobalMembers.subscribers.compare_exchange_weak(oldHead, newHead, std::memory_order_release, std::memory_order_relaxed));
  return oldHead;
}
}