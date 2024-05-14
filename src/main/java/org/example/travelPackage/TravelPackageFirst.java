package org.example.travelPackage;

import org.example.destination.Destination;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Travel package first, is a type of tour package
 */
public class TravelPackageFirst implements TravelPackage
{
    private UUID packageID;
    private String name;
    private int passengerCapacity;
    private List<Destination> listOfDestination;
    private List<UUID> listOfPassenger;

    /**
     * Instantiates a new Travel package first.
     *
     * @param name              the name
     * @param passengerCapacity the passenger capacity
     * @param listOfDestination the list of destination
     */
    public TravelPackageFirst(String name, int passengerCapacity, List<Destination> listOfDestination) {
        this.packageID=UUID.randomUUID();
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.listOfDestination = listOfDestination;
        this.listOfPassenger=new ArrayList<>();
        System.out.println("Travel Package with name "+this.name+" added successfully");
    }

    /**
     * Gets package id.
     *
     * @return the package id
     */
    public UUID getPackageID() {
        return packageID;
    }
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Sets passenger capacity.
     *
     * @param passengerCapacity the passenger capacity
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public List<Destination> getListOfDestination() {
        return listOfDestination;
    }

    /**
     * Sets list of destination.
     *
     * @param listOfDestination the list of destination
     */
    public void setListOfDestination(List<Destination> listOfDestination) {
        this.listOfDestination = listOfDestination;
    }
    @Override
    public List<UUID> getListOfPassenger() {
        return listOfPassenger;
    }
    @Override
    public void addPassenger(UUID passengerID)
    {
        this.listOfPassenger.add(passengerID);
        this.passengerCapacity--;
    }


}
