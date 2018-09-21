package com.adventurealley.adventurexp.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    private int id;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate timeSlot;
    private int age;

    public Customer() {

    }

    public Customer(int id, String name, LocalDate timeSlot, int age) {
        this.id = id;
        this.name = name;
        this.timeSlot = timeSlot;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalDate timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
