package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;

import java.util.ArrayList;

public class ActivityRepository implements IRepository<Activity> {
    @Override
    public boolean create(Activity item) {
        return false;
    }

    @Override
    public Activity read(int itemId) {
        return null;
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
