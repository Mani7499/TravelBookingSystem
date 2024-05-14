package org.example.passenger;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * The interface Passenger.
 * Making a general template of passenger by using interface.
 * This will follow Open and Close Principle when we add a new type passenger
 */
public interface Passenger
{
     /**
      * The constant passengerID.
      */
     UUID passengerID = null;
     /**
      * The constant passengerName.
      */
     String passengerName="";
     /**
      * The constant mobileNumber.
      */
     String mobileNumber="";
     /**
      * The constant balance.
      */
     int balance=0;
     /**
      * The constant passengerType.
      */
     String passengerType="";
     /**
      * The constant listOfActivities.
      */
     HashMap<String,List<Transaction>>listOfActivities=new HashMap<>();

     /**
      * Gets discount.
      *
      * @return the discount
      */
     public int getDiscount();

     /**
      * Gets passenger type.
      *
      * @return the passenger type
      */
     public String getPassengerType();

     /**
      * Gets balance.
      *
      * @return the balance
      */
     public int getBalance();

     /**
      * Gets name.
      *
      * @return the name
      */
     public String getName();

     /**
      * Gets id.
      *
      * @return the id
      */
     public UUID getID();

     /**
      * Sets balance.
      *
      * @param balance the balance
      */
     public void setBalance(int balance);

     /**
      * Add activity.
      *
      * @param destination    the destination
      * @param activityID     the activity id
      * @param costOfActivity the cost of activity
      */
     public void addActivity(String destination,UUID activityID,int costOfActivity);

     /**
      * Get list of transaction list.
      *
      * @return the list
      */
     public List<Transaction>getListOfTransaction();

}
