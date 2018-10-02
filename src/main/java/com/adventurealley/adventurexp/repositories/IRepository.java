package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.repositories.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class IRepository<T> {

    static Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    static {
        //creates a Runnable object to hold the instructions for the refreshing thread
        TimerTask refreshTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("refreshing");
                //closes the current connection
                try {
                    connection.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                //reconnects to the database
                connection = DBConnection.getConnection();
            }
        };
        connection = DBConnection.getConnection();
        new Timer().scheduleAtFixedRate(refreshTask, 0, 1000 * 60 * 2);
    }

    abstract public int create(T item);
    abstract public T read(int itemId);
    abstract public ArrayList<T> readAll();
    abstract public boolean update(T item);
    abstract public boolean delete(int id);

}
