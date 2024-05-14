package org.example.activity;

import java.util.UUID;

/**
 * The interface Activity.
 */
public interface Activity
{
    /**
     * The constant activityID.
     */
    UUID activityID =null;
    /**
     * The constant activityName.
     */
    String activityName="";
    /**
     * The constant description.
     */
    String description="";
    /**
     * The constant cost.
     */
    int cost=0;
    /**
     * The constant availableCapacity.
     */
    int availableCapacity=0;

    /**
     * Gets activity id.
     *
     * @return the activity id
     */
    public UUID getActivityID();

    /**
     * Gets activity name.
     *
     * @return the activity name
     */
    public String getActivityName();

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription();

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost();

    /**
     * Gets available capacity.
     *
     * @return the available capacity
     */
    public int getAvailableCapacity();

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity);


}
