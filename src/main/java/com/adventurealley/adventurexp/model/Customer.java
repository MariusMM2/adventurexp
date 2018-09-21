package com.adventurealley.adventurexp.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    private int age;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    public Customer() {

    }

    public Customer(int id, String name, LocalDate startDate, int age, LocalDate endDate){
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate timeSlot) {
        this.endDate = timeSlot;
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
