package org.example.travelPackage;

import org.example.destination.Destination;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The interface Travel package.
 */
public interface TravelPackage
{
    /**
     * The constant packageID.
     */
    UUID packageID=null;
    /**
     * The constant name.
     */
    String name="";
    /**
     * The constant passengerCapacity.
     */
    int passengerCapacity=0;
    /**
     * The constant listOfDestination.
     */
    List<Destination> listOfDestination=new ArrayList<>();
    /**
     * The constant listOfPassenger.
     */
    List<UUID> listOfPassenger=new ArrayList<>();

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();

    /**
     * Gets passenger capacity.
     *
     * @return the passenger capacity
     */
    public int getPassengerCapacity();

    /**
     * Gets list of destination.
     *
     * @return the list of destination
     */
    public List<Destination> getListOfDestination();

    /**
     * Gets list of passenger.
     *
     * @return the list of passenger
     */
    public List<UUID> getListOfPassenger();

    /**
     * Add passenger.
     *
     * @param passengerID the passenger id
     */
    public void addPassenger(UUID passengerID);


}
