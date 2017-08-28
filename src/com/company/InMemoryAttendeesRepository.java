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

    // Implement interface methods
    public Attendee findById(String attendeeID) {
        return attendees.get(attendeeID);
    }

    public void saveAttendee(Attendee attendee) {
        attendees.put(attendee.id, attendee);
    }

    public Attendee getRandomAttendee() {
        Random rand = new Random();
        int attendeesCount = attendees.size();
        int randomAttendeeID = rand.nextInt(attendeesCount) + 1;
        return attendees.get(randomAttendeeID);
    }
}

