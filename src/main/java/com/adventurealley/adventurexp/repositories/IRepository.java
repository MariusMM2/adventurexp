package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.repositories.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class IRepository<T> {

    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    abstract public boolean create(T item);
    abstract public T read(int itemId);
    abstract public ArrayList<T> readAll();
    abstract public boolean update(T item);
    abstract public boolean delete(int id);

}
