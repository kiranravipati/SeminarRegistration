package com.company;

public interface AttendeesRepository {
    void saveAttendee(Attendee attendee);
    Attendee getRandomAttendee();
    void viewAllAttendees();
    void createDefaultAttendees();
}
