package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Booking;

import java.util.ArrayList;
import java.util.Arrays;

public class BookingSearchForm {

    private final Booking[] ALL_BOOKINGS;
    private String searchString;
    private Booking[] bookings;

    public BookingSearchForm(Booking[] bookings) {
        this.ALL_BOOKINGS = bookings;
        this.searchString = "";
        this.bookings = bookings;
    }

    public void search(){
        ArrayList<Booking> foundBookings = new ArrayList<>();
        boolean foundAMatch = false;
        for (Booking b : ALL_BOOKINGS) {
            if (b.getName().toLowerCase().contains(searchString.toLowerCase())){
                foundBookings.add(b);
                foundAMatch = true;
            }
        }
        Array.

        if (!foundAMatch){
            bookings = ALL_BOOKINGS;
        }
        else{
            bookings = foundBookings.toArray(new Booking[]{});
        }

        System.out.println(searchString);
        System.out.println(Arrays.toString(bookings));
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }
}
