package com.adventurealley.adventurexp.model;

import javax.swing.*;

public class Activity {

    private String title;
    private int capacity;
    private String period;
    private int price;
    private String location;
    private int ageLimit;
    private String Description;
    private String staff;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    private int activityId;

    public Activity(String title, int capacity, String period, int price, String location, int ageLimit, String description, String staff, int activityId) {
        this.title = title;
        this.capacity = capacity;
        this.period = period;
        this.price = price;
        this.location = location;
        this.ageLimit = ageLimit;
        this.Description = description;
        this.staff = staff;
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }
}
