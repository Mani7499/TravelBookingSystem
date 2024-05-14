package org.example.destination;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The interface Destination.
 */
public interface Destination
{
    /**
     * The constant destinationID.
     */
    UUID destinationID=UUID.randomUUID();
    /**
     * The constant name.
     */
    String name="";
    /**
     * The constant listOfActivities.
     */
    List<UUID>listOfActivities=new ArrayList<>();

    /**
     * Gets destination id.
     *
     * @return the destination id
     */
    public UUID getDestinationID();

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();

    /**
     * Update activity.
     *
     * @param activityID the activity id
     */
    public void updateActivity(UUID activityID);

    /**
     * Gets list of activities.
     *
     * @return the list of activities
     */
    public List<UUID> getListOfActivities();


}
