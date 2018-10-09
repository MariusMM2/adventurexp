package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Booking;
import com.adventurealley.adventurexp.repositories.ActivityRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BookingForm implements Form<Booking> {

    private int activityId;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private int nPeople;

    @Override
    public boolean validate() {

        boolean activityId 	= ActivityRepository.getInstance().read(this.activityId) != null;
        boolean name        = this.name != null && this.name.length() > 0;
        boolean date 	    = this.date != null;
        boolean age         = this.nPeople > 0 && this.nPeople <= 150;
        return activityId && name && date && age;
    }

    @Override
    public Booking toModel() {

        return new Booking(-1, activityId, name, date, nPeople);
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "activityId=" + activityId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", nPeople=" + nPeople +
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

}
