package com.company;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AttendeesRepository attendeesRepository = InMemoryAttendeesRepository.getInstance();
        registerAttendees(attendeesRepository);
        attendeesRepository.viewAllAttendees();

        LocationsRepository locationsRepository = InMemoryLocationsRepository.getInstance();
        setupLocations(locationsRepository);

        SessionsRepository.initializeSessionsConductedAtSeminar();
        SessionsRepository.displayAllSessions();

        // create a booking
        BookingsRepository bookingsRepository = InMemoryBookingsRepository.getInstance();

        Attendee attendee = attendeesRepository.getRandomAttendee();
        Session session = SessionsRepository.findSessionById(1);
        System.out.printf("Book seat for %s in session \n %s", attendee, session);

        session.setBookingsRepository(bookingsRepository);
        session.setLocationsRepository(locationsRepository);

        Booking newBooking = session.bookSeatFotAttendee(attendee);
        System.out.println("Status");
        System.out.println("------");

        if (newBooking == null) {
            System.out.println("Sorry no seats available for the requested session");
        } else {
            System.out.printf("Seat booked for %s in session held at %s\n", attendee, session.venue());
            //System.out.println("Seats left" + session.seatsLeft());
        }
    }

    private static void registerAttendees(AttendeesRepository attendeesRepository) {
        Attendee attendee = new Attendee(1, "Mary Martin", 30 );
        attendeesRepository.saveAttendee(attendee);

        attendee = new Attendee(2,"John Donson", 28 );
        attendeesRepository.saveAttendee(attendee);

        attendee = new Attendee(3,"Smith Jones",35 );
        attendeesRepository.saveAttendee(attendee);
    }

    private static void setupLocations(LocationsRepository locationsRepository) {
        // Adding locations to repository
        Location location = new Location("Abdul Kalam", "First", 30, 1);
        locationsRepository.addLocation(location);

        location = new Location("Einstein", "Second", 50, 2);
        locationsRepository.addLocation(location);

        location = new Location("Newton", "Third", 40, 3);
        locationsRepository.addLocation(location);

    }
}
