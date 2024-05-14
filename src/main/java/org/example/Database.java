package org.example;

import org.example.activity.Activity;
import org.example.destination.Destination;
import org.example.passenger.Passenger;
import org.example.travelPackage.TravelPackage;

import java.util.HashMap;
import java.util.UUID;
/**
 * Created for mocking databases through in memory hashmaps
 */
public class Database
{
    private static Database db;
    /**
     * The Destination db.
     */
    HashMap<String,Destination>destinationDB;
    /**
     * The Activity db.
     */
    HashMap<UUID, Activity>activityDB;
    /**
     * The Passenger db.
     */
    HashMap<UUID, Passenger>passengerDB;
    /**
     * The Package db.
     */
    HashMap<String, TravelPackage>packageDB;
    /**
     * Instantiates a new Database.
     */
    public Database()
    {
        this.activityDB=new HashMap<>();
        this.destinationDB=new HashMap<>();
        this.packageDB=new HashMap<>();
        this.passengerDB=new HashMap<>();
    }

    /**
     * Gets destination db.
     *
     * @return the destination db
     */
    public HashMap<String, Destination> getDestinationDB() {
        return destinationDB;
    }

    /**
     * Gets activity db.
     *
     * @return the activity db
     */
    public HashMap<UUID, Activity> getActivityDB() {
        return activityDB;
    }

    /**
     * Gets passenger db.
     *
     * @return the passenger db
     */
    public HashMap<UUID, Passenger> getPassengerDB() {
        return passengerDB;
    }

    /**
     * Gets package db.
     *
     * @return the package db
     */
    public HashMap<String, TravelPackage> getPackageDB() {
        return packageDB;
    }

    /**
     * Create db database using Singleton Design Pattern
     *
     * @return the database
     */
    public Database createDB()
    {
        if(this.db!=null)
        {
            return this;
        }
        else
        {
            return this.db=new Database();
        }
    }

}
