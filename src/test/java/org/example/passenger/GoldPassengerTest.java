package org.example.passenger;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldPassengerTest {

    @Test
    void getName()
    {
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        assertEquals(goldPassenger.getName(),"Mani");
    }

    @Test
    void getBalance()
    {
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        assertEquals(goldPassenger.getBalance(),10000);
    }

    @Test
    void getPassengerType()
    {
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        assertEquals(goldPassenger.getPassengerType(),"Gold");
    }

    @Test
    void checkActivityCost()
    {
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        Activity generalActivity = new GeneralActivity("Scuba", "This is scuba diving", 1000, 10);
        int dicountedCost = generalActivity.getCost() - (generalActivity.getCost() * goldPassenger.getDiscount()) / 100;
        goldPassenger.addActivity("Bali", generalActivity.getActivityID(), dicountedCost);
        assertEquals(goldPassenger.getListOfTransaction().get(0).getCostOfActivity(), 900);
    }


}