package org.example.passenger;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface Passenger
{
     UUID passengerID = null;
     String passengerName="";
     String mobileNumber="";
     int balance=0;
     String passengerType="";
     HashMap<String,List<Transaction>>listOfActivities=new HashMap<>();
     public int getDiscount();
     public String getPassengerType();
     public int getBalance();
     public String getName();
     public UUID getID();
     public void setBalance(int balance);
     public void addActivity(String destination,UUID activityID,int costOfActivity);
     public List<Transaction>getListOfTransaction();

}
