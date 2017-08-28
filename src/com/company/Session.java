package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private int id;
    private String name;
    private Date conductedOn;
    private String timings;
    private String presenter;
    private int locationID;

    private BookingsRepository bookingsRepository;
    private LocationsRepository locationsRepository;

    Session(int id, String name, Date conductedOn, String timings, String presenter, int locationID) {
        this.id = id;
        this.name = name;
        this.conductedOn = conductedOn;
        this.timings = timings;
        this.presenter = presenter;
        this.locationID = locationID;
    }

    public void setBookingsRepository(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    public void setLocationsRepository(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public String toString() {
        // myDate is the java.util.Date in yyyy-mm-dd format
        // Converting it into String using formatter
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd MMM,yyyy");
        String strDate = dmyFormat.format(conductedOn);

        String s = String.format("%-5s %-40s %-15s %-20s %-20s\n", id, name, strDate, timings, presenter);
        return s;
    }

    public Booking bookSeatFotAttendee(Attendee attendee) {
        if (seatIsAvailable()) {
            Booking newBooking = createBooking(attendee);
            bookingsRepository.saveBooking(newBooking);
            return newBooking;
        } else {
            return null;
        }
    }

    private boolean seatIsAvailable() {
        int capacity = venue().capacity;
        int bookingsCount = bookingsRepository.countOfBookingsForSessionWithId(this.id);

        return bookingsCount < capacity;
    }

    private Booking createBooking(Attendee attendee) {
        return new Booking(this.id, attendee.id);
    }

    public Location venue() {
        return locationsRepository.findById(this.locationID);
    }

    public String getName() {
        return name;
    }
}



