package org.example.service;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.example.Database;
import org.example.destination.Destination;
import org.example.destination.GeneralDestination;
import org.example.passenger.GoldPassenger;
import org.example.passenger.Passenger;
import org.example.travelPackage.TravelPackage;
import org.example.travelPackage.TravelPackageFirst;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    @Test
    void addDestinationTest()
    {
        Database db=new Database();
        Destination destination=new GeneralDestination("Paris");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        destination.updateActivity(generalActivity.getActivityID());
        db.getDestinationDB().put(destination.getName(), destination);

        assertEquals(db.getDestinationDB().get(destination.getName()).getName(),"Paris");
        assertEquals(db.getDestinationDB().get("Paris").getListOfActivities().get(0),generalActivity.getActivityID());
    }

    //First adding destination then trying to update activity
    @Test
    void updateDestinationActivityTest()
    {
        Database db=new Database();
        Destination destination=new GeneralDestination("Paris");
        db.getDestinationDB().put(destination.getName(), destination);
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        destination.updateActivity(generalActivity.getActivityID());
        System.out.println(generalActivity.getActivityID());
        assertEquals(db.getDestinationDB().get(destination.getName()).getName(),"Paris");
        assertEquals(db.getDestinationDB().get("Paris").getListOfActivities().get(0),generalActivity.getActivityID());
    }

    @Test
    void createPackageTest()
    {
        Database db=new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);

        assertEquals(db.getPackageDB().get("Family").getListOfDestination().get(1).getName(),"NewYork");

    }

    @Test
    void displayPackageItenaryDetailsTest()
    {
        Database db=new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",5,destinationList);
        db.getPackageDB().put(travelPackage.getName(),travelPackage);

        assertEquals(db.getPackageDB().get("Family").getListOfDestination().get(1).getName(),"NewYork");
        assertEquals(db.getPackageDB().get("Family").getListOfDestination().get(1).getListOfActivities().get(0),generalActivity2.getActivityID());
    }

    @Test
    void passengerDetailsTest()
    {
        Database db=new Database();
        Destination destination=new GeneralDestination("Paris");
        Destination destination2=new GeneralDestination("NewYork");
        Activity generalActivity=new GeneralActivity("Scuba","This is scuba diving",1000,10);
        destination.updateActivity(generalActivity.getActivityID());
        Activity generalActivity2=new GeneralActivity("Boating","This is boating",500,6);
        destination2.updateActivity(generalActivity2.getActivityID());
        List<Destination>destinationList=new ArrayList<>();
        destinationList.add(destination);
        destinationList.add(destination2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",2,destinationList);
        Passenger goldPassenger=new GoldPassenger("Mani","9932323123",10000,"Gold");
        travelPackage.addPassenger(goldPassenger.getID());
        db.getPackageDB().put("Family",travelPackage);
        assertEquals(db.getPackageDB().get("Family").getListOfPassenger().get(0),goldPassenger.getID());
    }
}