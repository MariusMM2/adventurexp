package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Booking;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingRepository extends IRepository<Booking>{

    private static BookingRepository instance;
    public static BookingRepository getInstance(){
        if (instance == null)
            instance = new BookingRepository();
        return instance;
    }

    private BookingRepository(){}

    @Override
    public int create(Booking item) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO booking(name, startDate, age, activityId) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDate(2, Date.valueOf(item.getDate()));
            preparedStatement.setInt(3, item.getnPeople());
            preparedStatement.setInt(5, item.getActivityId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement("SELECT id FROM booking ORDER BY id DESC LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public Booking read(int itemId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM booking WHERE id=?");
            preparedStatement.setInt(1, itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Booking(
                    resultSet.getInt("id"),
                    resultSet.getInt("activityId"),
                    resultSet.getString("name"),
                    resultSet.getDate("startDate").toLocalDate(),
                    resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Booking> readAll() {
        ArrayList<Booking> bookings = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM booking");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                bookings.add(new Booking(resultSet.getString("name"),
                        resultSet.getDate("startDate").toLocalDate()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    @Override
    public boolean update(Booking item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM booking WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
