package org.example.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

public class ThoiGian96 {
    private String id;
    private Time startTime;
    private Time endTime;

    public ThoiGian96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public ThoiGian96( Time startTime, Time endTime) {
        this.id = UUID.randomUUID().toString();
        this.startTime = startTime;
        this.endTime = endTime;
    }
    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = new Time(startTime.getTime());
    }
    public void setEndTime(Timestamp endTime) {
        this.endTime = new Time(endTime.getTime());
    }
}
