package practisequestions.time.series;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Functional Requirements:
 * 1. Store Events:
 * Implement functionality to store events with their timestamp, type, and description.
 * 2. Retrieve Events:
 * Implement a getter method that retrieves events based on:
 * Event Type (e.g., Database, UI).
 * Timestamp.
 * Retrieval rules:
 * If an event exists exactly at the requested timestamp, return that event.
 * If no event exists at the requested timestamp, return the closest previous event of the same type.
 * If no previous event exists, return a suitable indication (e.g., null or an appropriate message).
 * Example Data:
 * Store the following events:
 * Database sets a "Transaction committed" at 2:00 PM
 * Database sets a "Transaction rollback" at 3:05 PM
 * Database sets a "Some other Transaction committed" at 3:15 PM
 * UI sets a "Got a request from User" at 3:00 PM
 * Example Usage:
 * getEvent("Database", "2:00 PM") should return: "Transaction committed"
 * getEvent("Database", "3:10 getEvent("UI", "2:50 PM") should return the previous event at 3:05 PM: "Transaction rollback"
 * PM") should return an indication that no previous event exists.
 */

public class TimeSeriesDB {
    Map<String, TreeSet<Event>> eventStore = new HashMap<>();

    public void storeEvent(LocalTime timeStamp, String type, String description) {
        eventStore.putIfAbsent(type, new TreeSet<>());
        eventStore.get(type).add(new Event(timeStamp, type, description));
    }

    public Event getEvent(String type, LocalTime timeStamp) {
        if (!eventStore.containsKey(type)) {
            return null;
        }
        TreeSet<Event> events = eventStore.get(type);
        Event searchEvent = new Event(timeStamp, type, "");
        return events.floor(searchEvent); //floor method of treeSet returns the closet but do not exceed it. Here the timestamp is compared as of comparator and

    }

    public static void main(String[] args) {
        TimeSeriesDB db = new TimeSeriesDB();
        db.storeEvent(LocalTime.of(14, 0), "Database", "Transaction committed");
        db.storeEvent(LocalTime.of(15, 5), "Database", "Transaction rollback");
        db.storeEvent(LocalTime.of(15, 15), "Database", "Some other Transaction committed");
        db.storeEvent(LocalTime.of(15, 0), "UI", "Got a request from User");

        System.out.println(db.getEvent("Database", LocalTime.of(14, 0))); // Exact match
        System.out.println(db.getEvent("Database", LocalTime.of(15, 10))); // Closest previous
        System.out.println(db.getEvent("UI", LocalTime.of(14, 50))); // No previous event
    }


}
