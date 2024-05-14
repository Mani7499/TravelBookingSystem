package org.example.passenger;

import java.util.UUID;

/**
 * The type Transaction is for tracking all transactions taking place.
 * Have seprated it from passenger class following single responsibility principle
 */
public class Transaction
{
    /**
     * The Transaction id.
     */
    UUID transactionID;
private String destination;
private UUID activityID;
    /**
     * The Cost of activity.
     */
    int costOfActivity;

    /**
     * Instantiates a new Transaction.
     *
     * @param destination    the destination
     * @param activityID     the activity id
     * @param costOfActivity the cost of activity
     */
    public Transaction(String destination,UUID activityID,int costOfActivity)
{
    this.destination=destination;
    this.activityID=activityID;
    this.costOfActivity=costOfActivity;
}
    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
    public UUID getTransactionID()
    {
    return transactionID;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public String getDestination()
    {
    return destination;
    }

    /**
     * Gets activity id.
     *
     * @return the activity id
     */
    public UUID getActivityID()
    {
    return activityID;
    }

    /**
     * Gets cost of activity.
     *
     * @return the cost of activity
     */
    public int getCostOfActivity()
    {
    return costOfActivity;
    }
}
