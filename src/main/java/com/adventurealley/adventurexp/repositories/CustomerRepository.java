package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository implements IRepository<Customer> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public boolean create(Customer item) {

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO customers(name, startDate, age, endDate) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDate(2, Date.valueOf(item.getStartDate()));
            preparedStatement.setInt(3, item.getAge());
            preparedStatement.setDate(4, Date.valueOf(item.getEndDate()));

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Customer read(int itemId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE  customerid=?");
            preparedStatement.setInt(1, itemId);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getString("name"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getInt("age"),
                        resultSet.getDate("endDate").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Customer> readAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getString("name"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getInt("age"),
                        resultSet.getDate("endDate").toLocalDate()
                ));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Customer item) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE customers SET name = ?, startDate = ?, age = ?, endDate = ?  WHERE customerid=?");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDate(2, Date.valueOf(item.getStartDate()));
            preparedStatement.setInt(3, item.getAge());
            preparedStatement.setDate(4, Date.valueOf(item.getEndDate()));
            preparedStatement.setInt(5, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE customerid=?");
            preparedStatement.setInt(1,id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
