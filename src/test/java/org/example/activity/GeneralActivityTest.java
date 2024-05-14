package org.example.activity;

import static org.junit.jupiter.api.Assertions.*;

class GeneralActivityTest {

    @org.junit.jupiter.api.Test
    void getName()
    {
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        assertEquals(generalActivity.getActivityName(),"Scuba");
    }

    @org.junit.jupiter.api.Test
    void getDescription()
    {
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        assertEquals(generalActivity.getDescription(),"This is scuba diving");
    }

    @org.junit.jupiter.api.Test
    void getCost()
    {
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        assertEquals(generalActivity.getCost(),1000);
    }

    @org.junit.jupiter.api.Test
    void getCapacity()
    {
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        assertEquals(generalActivity.getAvailableCapacity(),10);
    }

}