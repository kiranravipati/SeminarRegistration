package com.company;

public class Attendee {
    int id;
    String name;
    int age;

    Attendee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + "(" + age + ")years";
    }

    public String getName() {
        return name;
    }
}
