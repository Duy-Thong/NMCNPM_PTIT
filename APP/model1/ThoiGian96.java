package model1;

import java.util.UUID;

public class ThoiGian96 {
    private String id;
    private int startTime;
    private int endTime;

    public ThoiGian96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public ThoiGian96( int startTime, int endTime) {
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
