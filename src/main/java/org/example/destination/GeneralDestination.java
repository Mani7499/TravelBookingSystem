package org.example.destination;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type General destination.
 */
public class GeneralDestination implements Destination
{
    /**
     * The Destination id.
     */
    UUID destinationID;
    /**
     * The Name.
     */
    String name;
    /**
     * The List of activities.
     */
    List<UUID> listOfActivities;

    /**
     * Instantiates a new General destination.
     *
     * @param name the name
     */
    public GeneralDestination(String name)
    {
        this.destinationID=UUID.randomUUID();
        this.name = name;
        this.listOfActivities=new ArrayList<>();
    }
    @Override
    public UUID getDestinationID()
    {
        return destinationID;
    }
    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public List<UUID> getListOfActivities()
    {
        return this.listOfActivities;
    }

    @Override
    public void updateActivity(UUID activityID)
    {
        this.listOfActivities.add(activityID);
    }


}
