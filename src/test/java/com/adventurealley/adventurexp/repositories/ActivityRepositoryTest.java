package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.model.Activity;
import org.junit.Assert;
import org.junit.Test;

public class ActivityRepositoryTest {

    @Test
    public void read() {
        IRepository<Activity> activityIRepository = ActivityRepository.getInstance();
        Activity activity = activityIRepository.read(1);
        Assert.assertNotNull(activity);
        System.out.println(activity);
    }
}