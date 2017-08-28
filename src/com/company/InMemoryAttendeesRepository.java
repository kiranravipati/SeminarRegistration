package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InMemoryAttendeesRepository implements AttendeesRepository {
    private static final AttendeesRepository instance = new InMemoryAttendeesRepository();
    private Map<Integer, Attendee> attendees;

    private InMemoryAttendeesRepository() {
        attendees = new HashMap<Integer, Attendee>();
    }

    public static AttendeesRepository getInstance() {
        return instance;
    }

    // Implement interface methods

    public void saveAttendee(Attendee attendee) {
        attendees.put(attendee.id, attendee);
    }

    public Attendee getRandomAttendee() {
        Random rand = new Random();
        int attendeesCount = attendees.size();
        int randomAttendeeID = rand.nextInt(attendeesCount) + 1;
        return attendees.get(randomAttendeeID);
    }

    public void viewAllAttendees() {
        System.out.println("---------------------------------------");
        System.out.println("Attendees:");
        System.out.println("---------------------------------------");

        Attendee attendee;

        for (Map.Entry <Integer, Attendee> entry:attendees.entrySet()){
            int key=entry.getKey();
            attendee = entry.getValue();
            System.out.print(attendee);
            System.out.println();
        }

        System.out.println("---------------------------------------");
    }

    public void createDefaultAttendees() {
        Attendee attendee = new Attendee(1, "Mary Martin", 30 );
        saveAttendee(attendee);

        attendee = new Attendee(2,"John Donson", 28 );
        saveAttendee(attendee);

        attendee = new Attendee(3,"Smith Jones",35 );
        saveAttendee(attendee);
    }
}

