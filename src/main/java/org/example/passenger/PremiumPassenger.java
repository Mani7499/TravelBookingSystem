package org.example.passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Premium passenger.
 */
public class PremiumPassenger implements Passenger
{
    private UUID passengerID;
    private String passengerName;
    private String mobileNumber;
    /**
     * The Passenger type.
     */
    String passengerType;
    /**
     * The List of transaction.
     */
    List<Transaction>listOfTransaction;

    /**
     * Instantiates a new Premium passenger.
     *
     * @param passengerName the passenger name
     * @param mobileNumber  the mobile number
     * @param passengerType the passenger type
     */
    public PremiumPassenger(String passengerName, String mobileNumber,String passengerType)
    {
        this.passengerID = UUID.randomUUID();
        this.passengerName = passengerName;
        this.mobileNumber = mobileNumber;
        this.listOfTransaction=new ArrayList<>();
        this.passengerType=passengerType;
        System.out.println("New passenger with passengerID "+this.getID()+" created");
    }

    @Override
    public void setBalance(int balance)
    {
        //Not applicable for premium passenger
    }
    @Override
    public int getBalance()
    {
        //Not Applicable
        return 0;
    }
    @Override
    public String getPassengerType()
    {
        return this.passengerType;
    }
    @Override
    public int getDiscount()
    {
        return 100;
    }
    @Override
    public String getName()
    {
        return this.passengerName;
    }
    @Override
    public UUID getID()
    {
        return this.passengerID;
    }
    public void addActivity(String destination,UUID activityID,int costOfCompany)
    {
        Transaction transaction=new Transaction(destination,activityID,costOfCompany);
        listOfTransaction.add(transaction);
    }
    @Override
    public List<Transaction>getListOfTransaction()
    {
        return this.listOfTransaction;
    }


}
