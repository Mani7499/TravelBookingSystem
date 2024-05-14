package org.example.service;

import org.example.Database;
import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.example.destination.Destination;
import org.example.destination.GeneralDestination;
import org.example.passenger.GoldPassenger;
import org.example.passenger.Passenger;
import org.example.passenger.PremiumPassenger;
import org.example.passenger.StandardPassenger;
import org.example.travelPackage.TravelPackage;
import org.example.travelPackage.TravelPackageFirst;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NonAdminServiceTest
{
    @Test
    void packageActivitySlotFullTest()
    {
        Database db= new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,1);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        Passenger premiumPassenger = new PremiumPassenger("Mani", "9932323123", "Premium");
        db.getPassengerDB().put(goldPassenger.getID(),goldPassenger);
        db.getPassengerDB().put(premiumPassenger.getID(),premiumPassenger);

        NonAdminService nonAdminService=new NonAdminService("NonAdmin",db);
        String output1=nonAdminService.subscribePackageUtils(goldPassenger,generalActivity,"Paris");
        String output2=nonAdminService.subscribePackageUtils(premiumPassenger,generalActivity,"Paris");

        assertEquals(output1,"Successfully subscribed to activity " + generalActivity.getActivityName() + " with destination " + "Paris");
        assertEquals(output2,"Activity slots are full please try for other activities");

    }
    @Test
    void premiumUserSubscriptionTest()
    {
        Database db= new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,1);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);
        Passenger premiumPassenger=new PremiumPassenger("Mani","9932323123","Premium");
        db.getPassengerDB().put(premiumPassenger.getID(),premiumPassenger);

        NonAdminService nonAdminService=new NonAdminService("NonAdmin",db);
        String output=nonAdminService.subscribePackageUtils(premiumPassenger,generalActivity,"Paris");

        assertEquals(output,"Successfully subscribed to activity " + generalActivity.getActivityName() + " with destination " + "Paris");
    }
    @Test
    void packageActivityDiscountCheckForStandard()
    {
        Database db= new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,1);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",10000,"Standard");
        db.getPassengerDB().put(standardPassenger.getID(),standardPassenger);

        NonAdminService nonAdminService=new NonAdminService("NonAdmin",db);
        nonAdminService.subscribePackageUtils(standardPassenger,generalActivity,"Paris");

        assertEquals(standardPassenger.getBalance(),9000);
    }
    @Test
    void packageActivityDiscountCheckForGold()
    {
        Database db= new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,1);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        db.getPassengerDB().put(goldPassenger.getID(),goldPassenger);

        NonAdminService nonAdminService=new NonAdminService("NonAdmin",db);
        nonAdminService.subscribePackageUtils(goldPassenger,generalActivity,"Paris");

        assertEquals(goldPassenger.getBalance(),9100);
    }
    @Test
    void insufficientBalanceTest()
    {
        Database db= new Database();
        Destination destination=new GeneralDestination("Paris");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,1);
        destination.updateActivity(generalActivity.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",899,"Gold");
        Passenger standardPassenger=new StandardPassenger("Mani","9932323123",999,"Standard");

        NonAdminService nonAdminService=new NonAdminService("NonAdmin",db);
        String output1=nonAdminService.subscribePackageUtils(goldPassenger,generalActivity,"Paris");
        String output2=nonAdminService.subscribePackageUtils(standardPassenger,generalActivity,"Paris");

        assertEquals(output1,"Insufficient Balance");
        assertEquals(output2,"Insufficient Balance");

    }


}