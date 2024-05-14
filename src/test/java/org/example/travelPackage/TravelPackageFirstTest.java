package org.example.travelPackage;

import org.example.destination.Destination;
import org.example.destination.GeneralDestination;
import org.example.passenger.GoldPassenger;
import org.example.passenger.Passenger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageFirstTest {

    @Test
    void getName()
    {
        List<Destination>destinationList=new ArrayList<>();
        Destination d1=new GeneralDestination("Paris");
        Destination d2=new GeneralDestination("NewYork");
        destinationList.add(d1);
        destinationList.add(d2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",10,destinationList);
        assertEquals(travelPackage.getName(),"Family");
    }

    @Test
    void getPassengerCapacity()
    {
        List<Destination>destinationList=new ArrayList<>();
        Destination d1=new GeneralDestination("Paris");
        Destination d2=new GeneralDestination("NewYork");
        destinationList.add(d1);
        destinationList.add(d2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",10,destinationList);
        assertEquals(travelPackage.getPassengerCapacity(),10);
    }

    @Test
    void checkDestinationAdditionToPackage()
    {
        List<Destination>destinationList=new ArrayList<>();
        Destination d1=new GeneralDestination("Paris");
        Destination d2=new GeneralDestination("NewYork");
        destinationList.add(d1);
        destinationList.add(d2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",10,destinationList);
        assertEquals(travelPackage.getListOfDestination().get(1).getName(),"NewYork");
    }

    @Test
    void checkPassengerEnrollmentToPackage()
    {
        List<Destination>destinationList=new ArrayList<>();
        Destination d1=new GeneralDestination("Paris");
        Destination d2=new GeneralDestination("NewYork");
        destinationList.add(d1);
        destinationList.add(d2);
        TravelPackage travelPackage=new TravelPackageFirst("Family",10,destinationList);
        Passenger passenger=new GoldPassenger("Mani","9982312321",1000,"Gold");
        travelPackage.addPassenger(passenger.getID());
        assertEquals(travelPackage.getListOfPassenger().get(0),passenger.getID());
        assertEquals(travelPackage.getPassengerCapacity(),9);
    }
}