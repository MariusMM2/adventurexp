package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityRepositoryTest {

    @Test
    public void read() {
        IRepository<Activity> activityIRepository = new ActivityRepository();
        Activity activity = activityIRepository.read(1);
        Assert.assertNotNull(activity);
        System.out.println(activity);
    }
}