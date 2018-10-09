package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityRepository extends IRepository<Activity> {

    private static ActivityRepository instance;
    public static ActivityRepository getInstance(){
        if (instance == null)
            instance = new ActivityRepository();
        return instance;
    }

    private ActivityRepository(){}

    @Override
    public int create(Activity item) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO activity(title, capacity, period, price, location, ageLimit, description, staff, imgpath) VALUES (?,?,?,?,?,?,?,?,?)" );

            preparedStatement.setString(1,item.getTitle());
            preparedStatement.setInt(2,item.getCapacity());
            preparedStatement.setString(3,item.getPeriod());
            preparedStatement.setInt(4,item.getPrice());
            preparedStatement.setString(5,item.getLocation());
            preparedStatement.setInt(6,item.getAgeLimit());
            preparedStatement.setString(7,item.getDescription());
            preparedStatement.setString(8,item.getStaff());
            preparedStatement.setString(9,item.getImgpath());


            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement = connection.prepareStatement("SELECT activityId FROM activity ORDER BY activityId DESC LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
        // throw new UnsupportedOperationException("Method not implemented: ActivityRepository.create");
    }

    @Override
    public Activity read(int itemId) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM activity where activityId=?");
            preparedStatement.setInt(1, itemId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
            return new Activity(
                    itemId,
                    resultSet.getString("title"),
                    resultSet.getInt("capacity"),
                    resultSet.getString("period"),
                    resultSet.getInt("price"),
                    resultSet.getString("location"),
                    resultSet.getInt("ageLimit"),
                    resultSet.getString("description"),
                    resultSet.getString("staff"),
                    resultSet.getString("imgpath")
            );}
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Activity> readAll() {
        ArrayList<Activity> activities = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM activity");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                activities.add(new Activity(resultSet.getInt("activityId"),
                        resultSet.getString("title"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("period"),
                        resultSet.getInt("price"),
                        resultSet.getString("location"),
                        resultSet.getInt("ageLimit"),
                        resultSet.getString("description"),
                        resultSet.getString("staff"),
                        resultSet.getString("imgpath")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activities;
    }

    @Override
    public boolean update(Activity item) {

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE activity SET title=?, capacity=?, period=?, price=?, location=?, ageLimit=?, description=?, staff=?, imgpath=? WHERE activityId=?");
            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setInt(2, item.getCapacity());
            preparedStatement.setString(3, item.getPeriod());
            preparedStatement.setInt(4, item.getPrice());
            preparedStatement.setString(5, item.getLocation());
            preparedStatement.setInt(6, item.getAgeLimit());
            preparedStatement.setString(7, item.getDescription());
            preparedStatement.setString(8, item.getStaff());
            preparedStatement.setString(9, item.getImgpath());
            preparedStatement.setInt(10, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
