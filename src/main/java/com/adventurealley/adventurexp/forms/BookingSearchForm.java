package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Booking;

import java.util.ArrayList;
import java.util.Arrays;

public class BookingSearchForm {

    private String searchString;

    public Booking[] search(ArrayList<Booking> allBookings){
        ArrayList<Booking> foundBookings = new ArrayList<>();
        boolean foundAMatch = false;
        for (Booking b : allBookings) {
            if (b.getName().toLowerCase().contains(searchString.toLowerCase())){
                foundBookings.add(b);
                foundAMatch = true;
            }
        }

        if (!foundAMatch){
            return allBookings.toArray(new Booking[]{});
        }
        else{
            return foundBookings.toArray(new Booking[]{});
        }
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
