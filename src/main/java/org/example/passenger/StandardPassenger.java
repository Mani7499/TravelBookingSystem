package org.example.passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Standard passenger.
 */
public class StandardPassenger implements Passenger
{
    private UUID passengerID;
    private String passengerName;
    private String mobileNumber;
    private int balance;
    /**
     * The Passenger type.
     */
    String passengerType;
    /**
     * The List of transaction.
     */
    List<Transaction>listOfTransaction;

    /**
     * Instantiates a new Standard passenger.
     *
     * @param passengerName the passenger name
     * @param mobileNumber  the mobile number
     * @param balance       the balance
     * @param passengerType the passenger type
     */
    public StandardPassenger(String passengerName, String mobileNumber,int balance,String passengerType)
    {
        this.passengerID = UUID.randomUUID();
        this.passengerName = passengerName;
        this.mobileNumber = mobileNumber;
        this.balance=balance;
        this.listOfTransaction=new ArrayList<>();
        this.passengerType=passengerType;
        System.out.println("New passenger with passengerID "+this.getID()+" created");
    }
    @Override
    public int getBalance()
    {
        return balance;
    }
    @Override
    public void setBalance(int balance)
    {
        this.balance=balance;
    }
    @Override
    public String getPassengerType()
    {
        return this.passengerType;
    }
    @Override
    public int getDiscount()
    {
        return 0;
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
    @Override
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
