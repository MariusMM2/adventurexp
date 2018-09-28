package com.adventurealley.adventurexp.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * TODO: change start date and end date to a single day date
 * TODO: change age to number of people
 */
public class Booking {

    private int id;
    private int activityId;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    private int age;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;


    public Booking() {

    }

    public Booking(int id, int activityId, String name, LocalDate startDate, int age, LocalDate endDate) {
        this.id = id;
        this.activityId = activityId;
        this.name = name;
        this.startDate = startDate;
        this.age = age;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
