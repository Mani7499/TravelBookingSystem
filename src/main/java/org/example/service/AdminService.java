package org.example.service;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.example.Database;
import org.example.destination.Destination;
import org.example.destination.GeneralDestination;
import org.example.passenger.Passenger;
import org.example.passenger.Transaction;
import org.example.travelPackage.TravelPackage;
import org.example.travelPackage.TravelPackageFirst;

import java.util.*;

/**
 * The type Admin service.
 */
public class AdminService implements UserService
{
    /**
     * The User type.
     */
    String userType;
    /**
     * The Db.
     */
    Database db;

    /**
     * Instantiates a new Admin service.
     *
     * @param userType the user type
     * @param db       the db
     */
    public AdminService(String userType,Database db)
{
    this.userType=userType;
    this.db=db;
}

    /**
     * Add destination.
     */
    public void addDestination()
{
    try
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your destination name: ");
        String destinationName = sc.next();
        Destination destination = new GeneralDestination(destinationName);
        System.out.println("Enter the number of activities you want to add: ");
        int numberOfActivities = sc.nextInt();
        System.out.println("Enter list of activities: ");
        String nameOfActivity, descriptionOfActivity;
        int costOfActivity, capacityOfActivity;
        for (int i = 0; i < numberOfActivities; i++) {

            System.out.println("Enter the name of activity: ");
            nameOfActivity = sc.next();
            System.out.println("Enter the cost of activity: ");
            costOfActivity = sc.nextInt();
            //Need to take whole line as input
            System.out.println("Enter the description of activity: ");
            descriptionOfActivity = sc.nextLine();
            System.out.println("Enter the capacity of activity: ");
            capacityOfActivity = sc.nextInt();
            Activity activity = new GeneralActivity(nameOfActivity, descriptionOfActivity, costOfActivity, capacityOfActivity);
            db.getActivityDB().put(activity.getActivityID(), activity);
            destination.updateActivity(activity.getActivityID());


        }
        db.getDestinationDB().put(destination.getName(), destination);
    }
    catch (Exception e)
    {
        System.out.println("Facing issue in adding destination with exception "+e);
    }
}

    /**
     * Update destination activity.
     */
    public void updateDestinationActivity()
{
    try
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the destination you want to add activity to: ");
        String destinationName = sc.next();
        Destination destination = db.getDestinationDB().get(destinationName);
        System.out.println("Enter the number of activities you want to add: ");
        int numberOfActivities = sc.nextInt();
        System.out.println("Enter list of activities: ");
        for (int i = 0; i < numberOfActivities; i++) {
            System.out.println("Enter the name of activity: ");
            String nameOfActivity = sc.next();
            System.out.println("Enter the cost of activity: ");
            int costOfActivity = sc.nextInt();
            //Need to take whole line as input
            System.out.println("Enter the description of activity: ");
            String descriptionOfActivity = sc.next();
            System.out.println("Enter the capacity of activity: ");
            int capacityOfActivity = sc.nextInt();
            Activity activity = new GeneralActivity(nameOfActivity, descriptionOfActivity, costOfActivity, capacityOfActivity);
            db.getActivityDB().put(activity.getActivityID(), activity);
            destination.updateActivity(activity.getActivityID());
        }
    }
    catch (Exception e)
    {
        System.out.println("Facing issue in updating activity to a destination with exception "+e);
    }
}

    /**
     * Create package.
     */
    public void createPackage()
{
    try
    {
        Scanner sc = new Scanner(System.in);
        String packageName;
        int packageCapacity;
        int numberOfDestination;
        String destinationName;
        List<Destination> listOfDestinations = new ArrayList<>();
        System.out.println("Enter the following details");
        System.out.println("Enter the name of package ");
        packageName = sc.next();
        System.out.println("Enter the maximum capacity of a package ");
        packageCapacity = sc.nextInt();
        System.out.println("Enter the number of destinations you want to add to this package");
        numberOfDestination = sc.nextInt();
        for (int i = 0; i < numberOfDestination; i++) {
            System.out.println("Enter the name of destination you want to add to this package");
            destinationName = sc.next();
            listOfDestinations.add(db.getDestinationDB().get(destinationName));
        }
        TravelPackageFirst travelPackageFirst = new TravelPackageFirst(packageName, packageCapacity, listOfDestinations);
        db.getPackageDB().put(travelPackageFirst.getName(), travelPackageFirst);
    }
    catch (Exception e)
    {
        System.out.println("Facing issue in creating package with exception "+e);
    }
}

    /**
     * Display package enrollement details.
     */
    public void displayPackageEnrollementDetails()
{
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the package name you want to see passenger list for");
        String packageName = sc.next();
        TravelPackage travelPackage = db.getPackageDB().get(packageName);
        System.out.println("Package Name: " + packageName);
        System.out.println("Package capacity " + travelPackage.getPassengerCapacity());
        if (travelPackage.getListOfPassenger() == null) {
            System.out.println("Nobody has registered for this package till now");
            return;
        }
        System.out.println("Number of passengers enrolled: " + travelPackage.getListOfPassenger().size());
        for (int i = 0; i < travelPackage.getListOfPassenger().size(); i++) {
            UUID passengerID = travelPackage.getListOfPassenger().get(i);
            Passenger passenger = db.getPassengerDB().get(passengerID);
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger ID: " + passengerID);
        }
    }
    catch (Exception e)
    {
        System.out.println("Facing issue in displaying package enrolment detail with exception "+e);
    }
}

    /**
     * Passenger details.
     */
    public void passengerDetails()
{
    try
    {
        for (Map.Entry<UUID, Passenger> entry : db.getPassengerDB().entrySet()) {
            Passenger passenger = entry.getValue();
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger ID: " + passenger.getID());
            System.out.println("Passenger Balance: " + passenger.getBalance());
            System.out.println("List of activities subscribed for:");
            for (int i = 0; i < passenger.getListOfTransaction().size(); i++) {
                Transaction transaction = passenger.getListOfTransaction().get(i);
                System.out.println("DestinationName: " + transaction.getDestination());
                System.out.println("ActivityName: " + db.getActivityDB().get(transaction.getActivityID()).getActivityName());
                System.out.println("Price paid for this activity: " + transaction.getCostOfActivity());
            }
        }
    }
    catch (Exception e)
    {
        System.out.println("Facing issue in showing passenger details with exception "+e);
    }

}
@Override
public void startOperation()
{
    while(true)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            String inputString;
            int x;
            System.out.println("Press 1 for adding new destination");
            System.out.println("Press 2 for updating activities in a destination");
            System.out.println("Press 3 for creating a package");
            System.out.println("Press 4 for displaying details of a package");
            System.out.println("Press 5 for displaying details of each passenger");
            System.out.println("Press 6 for main menu");
            x = sc.nextInt();

            switch (x) {
                case 1:
                    this.addDestination();
                    break;

                case 2:
                    this.updateDestinationActivity();
                    break;

                case 3:
                    this.createPackage();
                    break;

                case 4:
                    this.displayPackageEnrollementDetails();
                    break;

                case 5:
                    this.passengerDetails();
                    break;

                case 6:
                    return;
            }
        }
        catch (Exception e)
        {
            System.out.println("Facing issue with exception "+e);
        }
    }

}

}
