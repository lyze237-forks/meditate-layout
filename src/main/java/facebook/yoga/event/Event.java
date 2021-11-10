package facebook.yoga.event;

import facebook.yoga.YGNode;
import org.w3c.dom.Node;

public class Event //Type originates from: event.h
{
    public static void reset() //Method definition originates from: event.cpp
    {
        var head = facebook.yoga.event.GlobalMembers.push(null);
        while (head != null) {
            var current = new auto(head);
            head = head.next;
            current = null;
        }
    }

//  class Data;

//  typedef void(final YGNode UnnamedParameter, Type UnnamedParameter2, DataSubscriber UnnamedParameter3);


    public static void subscribe(std::function<Subscriber>&&subscriber) //Method definition originates from: event.cpp
    {
        facebook.yoga.event.GlobalMembers.push(new Node(new std::function (std::move (subscriber))));
    }


    public static <E> void publish(final YGNode node) {
        publish(node, new EmptyEventData<E>());
    }


    public static <E> void publish(final YGNode node, final CallableEvent eventData) {


    }


    public static <E> void publish(YGNode node) {
        publish(node, new EmptyEventData<E>());
    }


    public static <E> void publish(YGNode node, final EmptyEventData<E> eventData) {
        facebook.yoga.Event.<E>publish(node, eventData);
    }

    private static void publish(final YGNode node, Type eventType, final Data eventData) //Method definition originates from: event.cpp
    {
        for (var subscriber = GlobalMembers.subscribers.load(
                std::memory_order_relaxed); subscriber != null; subscriber = subscriber.next) {
            subscriber.subscriber(node, eventType, eventData);
        }
    }

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

        public static Type forValue(int value) {
            return values()[value];
        }

        public int getValue() {
            return this.ordinal();
        }
    }


    public static class EmptyEventData<E> extends CallableEvent  //Type originates from: event.h
    {
    }

    public static class Data<E> //Type originates from: event.h
    {
        private final Object data_;


        public Data(final EmptyEventData<E> data) {
            this.data_ = data;
        }


        public final <E> EmptyEventData<E> get() {
            return (EmptyEventData<E>) data_;
        }
    }
}