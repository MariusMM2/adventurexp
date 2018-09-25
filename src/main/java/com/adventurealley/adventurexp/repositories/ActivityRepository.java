package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityRepository implements IRepository<Activity> {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public boolean create(Activity item) {
        return false;
    }

    @Override
    public Activity read(int itemId) {
        try {
            preparedStatement = conn.prepareStatement("select * from activity");
            preparedStatement.setInt(1, itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Activity(
                    resultSet.getString("title"),
                    resultSet.getInt("capacity"),
                    resultSet.getString("period"),
                    resultSet.getInt("price"),
                    resultSet.getString("location"),
                    resultSet.getInt("ageLimit"),
                    resultSet.getString("description"),
                    resultSet.getString("staff"),
                    resultSet.getInt("activtyId")
            );
        }
        catch (SQLException e)
        {
            e.printStackTrace();;
            return null;
        }
    }

    @Override
    public ArrayList<Activity> readAll() {
        return null;
    }

    @Override
    public boolean update(Activity item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
