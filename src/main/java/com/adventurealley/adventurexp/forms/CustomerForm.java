package com.adventurealley.adventurexp.forms;

import com.adventurealley.adventurexp.model.Customer;

//#Marius
//Form submitted when adding a new Customer to the system
public class CustomerForm implements Form<Customer> {

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Customer toModel() {
        return null;
    }
}
