package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Customer;

import java.util.ArrayList;

public class CustomerRepository implements IRepository<Customer> {
    @Override
    public boolean create(Customer item) {
        return false;
    }

    @Override
    public Customer read(int itemId) {
        return null;
    }

    @Override
    public ArrayList<Customer> readAll() {
        return null;
    }

    @Override
    public boolean update(Customer item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
