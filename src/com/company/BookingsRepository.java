package com.company;

import java.util.ArrayList;

public interface BookingsRepository {
    public ArrayList findBookingsBySessionId(int sessionId);
    public void saveBooking(Booking booking);
    public int countOfBookingsForSessionWithId(int sessionId);
}
