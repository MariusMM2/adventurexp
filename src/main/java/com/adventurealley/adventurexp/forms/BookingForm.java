package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Booking;
import com.adventurealley.adventurexp.repositories.ActivityRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//TODO: see Booking.java
public class BookingForm implements Form<Booking> {

    private int activityId;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    private int age;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @Override
    public boolean validate() {
        System.out.println(this.activityId);
        boolean activityId 	= ActivityRepository.getInstance().read(this.activityId) != null;
        System.out.println(activityId);
        System.out.println(this.name);
        boolean name        = this.name != null && this.name.length() > 0;
        System.out.println(name);
        System.out.println(this.startDate);
        boolean startDate 	= this.startDate != null;
        System.out.println(startDate);
        System.out.println(this.endDate);
        boolean endDate 	= this.endDate != null;
        System.out.println(endDate);
        System.out.println(this.age);
        boolean age         = this.age > 0 && this.age <= 150;
        System.out.println(age);
        return activityId && name && startDate && endDate && age;
    }

    @Override
    public Booking toModel() {

        return new Booking(-1, activityId, name, startDate, age, endDate);
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "activityId=" + activityId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", age=" + age +
                ", endDate=" + endDate +
                '}';
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
