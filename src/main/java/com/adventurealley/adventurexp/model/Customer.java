package com.adventurealley.adventurexp.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

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


    //Stuff for debugging and testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                Objects.equals(name, customer.name) &&
                Objects.equals(startDate, customer.startDate) &&
                Objects.equals(endDate, customer.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, age, endDate);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
