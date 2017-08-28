package com.company;

public interface AttendeesRepository {
    public Attendee findById(String attendeeID);
    public void saveAttendee(Attendee attendee);
    public Attendee getRandomAttendee();
    public void viewAllAttendees();
}
