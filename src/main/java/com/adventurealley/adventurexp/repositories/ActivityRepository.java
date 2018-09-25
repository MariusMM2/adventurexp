package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityRepository extends IRepository<Activity> {

    @Override
    public boolean create(Activity item) {
        throw new UnsupportedOperationException("Method not implemented: ActivityRepository.create");
    }

    @Override
    public Activity read(int itemId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM activity where activityId=?");
            preparedStatement.setInt(1, itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Activity(
                    resultSet.getInt(itemId),
                    resultSet.getString("title"),
                    resultSet.getInt("capacity"),
                    resultSet.getString("period"),
                    resultSet.getInt("price"),
                    resultSet.getString("location"),
                    resultSet.getInt("ageLimit"),
                    resultSet.getString("description"),
                    resultSet.getString("staff")
            );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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
