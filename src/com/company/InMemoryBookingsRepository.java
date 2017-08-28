package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryBookingsRepository implements BookingsRepository {
    private static final BookingsRepository instance = new InMemoryBookingsRepository();

    // key - sessionID, value - array list of booking objects
    private Map<Integer, ArrayList<Booking>> bookings;

    private InMemoryBookingsRepository() {
        bookings = new HashMap<Integer, ArrayList<Booking>>();
    }

    public static BookingsRepository getInstance() {
        return instance;
    }

    public int countOfBookingsForSessionWithId(int sessionId) {
        if (bookings.get(sessionId) == null) {
            return 0;
        } else {
            return bookings.get(sessionId).size();
        }
    }

    // implementation for interface methods
    public ArrayList findBookingsBySessionId(int sessionId) {
        return bookings.get(sessionId);
    }

    public void saveBooking(Booking booking) {
        int sessionId = booking.getSessionId();
        if (bookings.size() == 0) {
            ArrayList <Booking> bookingsList = new ArrayList<Booking>();
            bookingsList.add(booking);
            bookings.put(sessionId, bookingsList);
        } else {
            bookings.get(sessionId).add(booking);
        }
    }
}