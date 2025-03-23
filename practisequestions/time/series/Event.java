package practisequestions.time.series;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 Time Series Database: You are tasked with building a simple in-memory time series database to store events.
 Each event must have:
 Event ID: A unique identifier (auto-generated).
 Timestamp: The exact time the event occurred.
 Event Type: The category or source of the event (e.g., "Database", "UI").
 Description: A brief description of the event.
 */

public class Event implements Comparable<Event> {
    private static int counter = 1;
    private final int eventId;
    private LocalTime timeStamp;
    private String eventType;
    private String description;


    public Event(LocalTime timeStamp, String eventType, String description) {
        this.eventId = counter++;
        this.timeStamp = timeStamp;
        this.eventType = eventType;
        this.description = description;
    }

    public int getEventId() {
        return eventId;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public String getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Event o) {
        return this.timeStamp.compareTo(o.timeStamp);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", timeStamp=" + timeStamp +
                ", eventType='" + eventType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
