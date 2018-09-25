package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {
    private Customer cst = new Customer(7, "Dummy", LocalDate.now(), 18, LocalDate.now().plusWeeks(2));
    private Customer cst2 = new Customer(cst.getId(), "ModifiedDummy", LocalDate.now(), 20, LocalDate.now().plusWeeks(4));
    private CustomerRepository customerRepository = new CustomerRepository();
    @Test
    public void create() {
        customerRepository.create(cst);
    }

    @Test
    public void read() {
        Assert.assertEquals(cst, customerRepository.read(cst.getId()));
    }

    @Test
    public void update() {
        customerRepository.update(cst2);
        Assert.assertNotEquals(cst, customerRepository.read(cst.getId()));
        Assert.assertEquals(cst2, customerRepository.read(cst.getId()));
    }

    @Test
    public void delete() {
        customerRepository.delete(cst.getId());
    }
}