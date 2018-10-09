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

        boolean activityId 	= ActivityRepository.getInstance().read(this.activityId) != null;
        boolean name        = this.name != null && this.name.length() > 0;
        boolean startDate 	= this.startDate != null && this.startDate.isAfter(LocalDate.now());
        boolean endDate 	= startDate && this.endDate != null  && this.endDate.isAfter(this.startDate);
        boolean age         = this.age > 0 && this.age <= 150;
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
