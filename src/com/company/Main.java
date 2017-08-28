package com.company;

public class Main {
    public static void main(String[] args) {
        AttendeesRepository attendeesRepository = InMemoryAttendeesRepository.getInstance();
        attendeesRepository.createDefaultAttendees();
        attendeesRepository.viewAllAttendees();

        LocationsRepository locationsRepository = InMemoryLocationsRepository.getInstance();
        locationsRepository.createDefaultLocations();

        SessionsRepository.initializeSessionsConductedAtSeminar();
        SessionsRepository.displayAllSessions();

        //  Book a seat for session
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
            System.out.printf("Seat booked for %s in session - %s, held in room %s\n", attendee, session.getName(), session.venue());
            //System.out.println("Seats left" + session.seatsLeft());
        }
    }
}
