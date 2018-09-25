package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.repositories.util.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IRepository<T> {

    Connection connection = DBConnection.getConnection();

    boolean create(T item);
    T read(int itemId);
    ArrayList<T> readAll();
    boolean update(T item);
    boolean delete(int id);

}
