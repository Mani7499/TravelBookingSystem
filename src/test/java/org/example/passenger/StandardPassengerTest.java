package org.example.passenger;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardPassengerTest {

    @Test
    void getBalance()
    {
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",10000,"Standard");
        assertEquals(standardPassenger.getBalance(),10000);
    }

    @Test
    void getPassengerType()
    {
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",10000,"Standard");
        assertEquals(standardPassenger.getPassengerType(),"Standard");
    }

    @Test
    void getName()
    {
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",10000,"Standard");
        assertEquals(standardPassenger.getName(),"Mani");
    }

    //Dicounted Cost should remain same for standard customer
    @Test
    void checkActivityCost()
    {
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",10000,"Standard");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        int dicountedCost=generalActivity.getCost()-(generalActivity.getCost()*standardPassenger.getDiscount())/100;
        standardPassenger.addActivity("Bali",generalActivity.getActivityID(),dicountedCost);
        assertEquals(standardPassenger.getListOfTransaction().get(0).getCostOfActivity(),1000);
    }

}