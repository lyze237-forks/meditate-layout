package facebook.yoga.event;

import facebook.yoga.YGNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class Event //Type originates from: event.h
{

    private static HashMap<Class<?>, Collection<Consumer<CallableEvent>>> listeners;

    public static void reset() //Method definition originates from: event.cpp
    {
        listeners.clear();
    }


    public static <T extends CallableEvent> void subscribe(Class<T> clazz, Consumer<T> listener) //Method definition originates from: event.cpp
    {
        listeners.computeIfAbsent(clazz, aClass -> new ConcurrentLinkedDeque<>()).add(
                (Consumer<CallableEvent>) listener);
    }


    public static void publish(final YGNode node) {
        publish(node, new EmptyEventData());
    }


    public static void publish(final YGNode node, final CallableEvent eventData) {
        Collection<Consumer<CallableEvent>> listeners = Event.listeners.get(eventData.getClass());
        if (listeners != null) {
            for (Consumer<CallableEvent> listener : listeners) {
                listener.accept(eventData);
            }
        }
    }


    private static void publish(final YGNode node, Type eventType, final CallableEvent eventData) //Method definition originates from: event.cpp
    {
        publish(node, eventData);
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


    public static class EmptyEventData extends CallableEvent  //Type originates from: event.h
    {
    }

}