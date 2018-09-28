package com.adventurealley.adventurexp.model;

public class Activity {

    private int id;
    private String title;
    private int capacity;
    private String period;
    private int price;
    private String location;
    private int ageLimit;
    private String description;
    private String staff;

    public Activity(int id, String title, int capacity, String period, int price, String location, int ageLimit, String description, String staff) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
        this.period = period;
        this.price = price;
        this.location = location;
        this.ageLimit = ageLimit;
        this.description = description;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", period='" + period + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", ageLimit=" + ageLimit +
                ", description='" + description + '\'' +
                ", staff='" + staff + '\'' +
                '}';
    }
}
