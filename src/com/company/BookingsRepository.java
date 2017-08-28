package com.company;

public interface BookingsRepository {
    void saveBooking(Booking booking);
    int countOfBookingsForSessionWithId(int sessionId);
}
