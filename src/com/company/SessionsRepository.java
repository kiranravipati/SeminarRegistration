package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SessionsRepository {
    static Map<Integer, Session> sessions;

    public static void initializeSessionsConductedAtSeminar() {
        sessions = new HashMap<Integer, Session>();
        Session session;
        Date date;

        // Adding sessions to repository
        date = new Date();
        session = new Session(1, "Go Agile with Rails", date, "10:00am - 1:00pm", "Dave Martin", 1);
        sessions.put(1, session);

        session = new Session(2, "Object Oriented Design Patterns", date, "2:00pm - 5:00pm", "Andrew James", 2);
        sessions.put(2, session);

        session = new Session(3, "Clean code and refactoring", date, "10:00am - 1:00pm", "David Thomas", 3);
        sessions.put(3, session);
    }

    public static Session findSessionById(int sessionCode) {
        return sessions.get(sessionCode);
    }

    public static void displayAllSessions() {
        System.out.println("Sessions conducted:");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-40s %-15s %-20s %-20s\n", "Code" , "Session" , "Date", "Timings", "Presenter");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        // Traversing sessions map
        for (Map.Entry <Integer, Session> entry:sessions.entrySet()){
            int key=entry.getKey();
            Session session = entry.getValue();
            System.out.print(session);
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public void saveSession(Session session) {

    }

    public void removeSession(Session session){

    }
}