package com.company;

public class Location {
    String roomName;
    String floorNumber;
    int capacity;
    int id;

    Location(String roomName, String floorNumber, int capacity, int id) {
        this.roomName = roomName;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s, %s floor", roomName, floorNumber);
    }
}
