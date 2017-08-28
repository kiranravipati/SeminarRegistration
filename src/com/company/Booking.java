package com.company;

public class Booking {
    private int sessionId;
    private int attendeeId;

    Booking(int sessionId, int attendeeId) {
        this.sessionId = sessionId;
        this.attendeeId = attendeeId;
    }

    public int getSessionId() {
        return  sessionId;
    }

    public int getAttendeeId() {
       return attendeeId;
    }
}
