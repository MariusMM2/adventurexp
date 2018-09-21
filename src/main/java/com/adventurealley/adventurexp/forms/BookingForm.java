package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Booking;

public class BookingForm implements Form<Booking> {
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Booking toModel() {
        return null;
    }
}
