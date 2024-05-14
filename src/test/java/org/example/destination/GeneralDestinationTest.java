package org.example.destination;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralDestinationTest {

    @Test
    void getName()
    {
        Destination generalDestination=new GeneralDestination("Paris");
        assertEquals(generalDestination.getName(),"Paris");
    }

    @Test
    void getListOfActivities()
    {
        Destination generalDestination=new GeneralDestination("Paris");
        Activity activity1=new GeneralActivity("FerryRide","Paris Ferry Ride",1000,10);
        Activity activity2=new GeneralActivity("EiffelTowerVisit","Eiffel tower sight seeing",2000,100);
        generalDestination.updateActivity(activity1.getActivityID());
        generalDestination.updateActivity(activity2.getActivityID());
        assertEquals(generalDestination.getListOfActivities().get(1),activity2.getActivityID());
    }

}