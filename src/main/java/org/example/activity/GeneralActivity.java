package org.example.activity;

import java.util.UUID;

/**
 * The type General activity.
 */
public class GeneralActivity implements Activity
{
    /**
     * The Activity id.
     */
    public UUID activityID;
    private String activityName;
    private String description;
    private int cost;
    private int availableCapacity;


    /**
     * Instantiates a new General activity.
     *
     * @param name        the name
     * @param description the description
     * @param cost        the cost
     * @param capacity    the capacity
     */
    public GeneralActivity(String name, String description, int cost, int capacity)
    {
        this.activityID=UUID.randomUUID();
        this.activityName = name;
        this.description = description;
        this.cost = cost;
        this.availableCapacity = capacity;
        System.out.println("Activity "+this.getActivityName()+" added successfully");
    }

    @Override
    public UUID getActivityID()
    {
        return this.activityID;
    }
    @Override
    public String getActivityName()
    {
        return activityName;
    }
    @Override
    public String getDescription()
    {
        return description;
    }
    @Override
    public int getCost()
    {
        return cost;
    }
    @Override
    public int getAvailableCapacity()
    {
        return availableCapacity;
    }
    @Override
    public void setCapacity(int capacity)
    {
        this.availableCapacity = capacity;
    }
}
