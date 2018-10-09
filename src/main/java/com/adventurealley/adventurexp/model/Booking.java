package com.adventurealley.adventurexp.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * TODO: change start date and end date to a single day date
 * TODO: change nPeople to number of people
 */
public class Booking {

    private int id;
    private int activityId;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private int nPeople;


    public Booking() {

    }

    public Booking(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Booking(int id, int activityId, String name, LocalDate date, int nPeople) {
        this.id = id;
        this.activityId = activityId;
        this.name = name;
        this.date = date;
        this.nPeople = nPeople;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getnPeople() {
        return nPeople;
    }

    public void setnPeople(int nPeople) {
        this.nPeople = nPeople;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id &&
                activityId == booking.activityId &&
                nPeople == booking.nPeople &&
                Objects.equals(name, booking.name) &&
                Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityId, name, date, nPeople);
    }
}
