package org.example.service;

import org.example.activity.Activity;
import org.example.Database;
import org.example.destination.Destination;
import org.example.passenger.GoldPassenger;
import org.example.passenger.Passenger;
import org.example.passenger.PremiumPassenger;
import org.example.passenger.StandardPassenger;
import org.example.travelPackage.TravelPackage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * The type Non admin service.
 */
public class NonAdminService implements UserService {
    /**
     * The User type.
     */
    String userType;
    /**
     * The Db.
     */
    Database db;

    /**
     * Instantiates a new Non admin service.
     *
     * @param userType the user type
     * @param db       the db
     */
    public NonAdminService(String userType, Database db) {
        this.userType = userType;
        this.db = db;
    }

    /**
     * Create new user.
     */
    public void createUser() {
        try {
            Scanner sc = new Scanner(System.in);
            String name, mobileNumber, passengerType;
            int balance = 0;
            System.out.println("Enter passenger name");
            name = sc.next();
            System.out.println("Enter passenger mobile number");
            mobileNumber = sc.next();
            System.out.println("Enter the type of passenger");
            passengerType = sc.next();
            if (passengerType.equals("Gold") || passengerType.equals("Standard")) {
                System.out.println("Enter initial balance");
                balance = sc.nextInt();
            }
            Passenger passenger = null;
            if (passengerType.equals("Standard")) {
                passenger = new StandardPassenger(name, mobileNumber, balance, passengerType);
            }
            if (passengerType.equals("Gold")) {
                passenger = new GoldPassenger(name, mobileNumber, balance, passengerType);
            }
            if (passengerType.equals("Premium")) {
                passenger = new PremiumPassenger(name, mobileNumber, passengerType);
            }

            db.getPassengerDB().put(passenger.getID(), passenger);
            System.out.println("User enrolled successfully");

        } catch (Exception e) {
            System.out.println("Facing issue in creating a user with exception " + e);
        }
    }

    /**
     * Core logic to subscribe a particular package.
     *
     * @param passenger       the passenger
     * @param activity        the activity
     * @param destinationName the destination name
     * @return the string
     */
    public String subscribePackageUtils(Passenger passenger, Activity activity, String destinationName) {
        UUID activityID = activity.getActivityID();
        if (activity.getAvailableCapacity() == 0) {
            return "Activity slots are full please try for other activities";
        }

        if (passenger.getPassengerType().equals("Standard") || passenger.getPassengerType().equals("Gold")) {
            int discount = passenger.getDiscount();
            int discountedValue = activity.getCost() - (activity.getCost() * discount) / 100;
            if (discountedValue <= passenger.getBalance()) {
                passenger.setBalance(passenger.getBalance() - discountedValue);
                passenger.addActivity(destinationName, activityID, discountedValue);
                activity.setCapacity(activity.getAvailableCapacity() - 1);
                return "Successfully subscribed to activity " + activity.getActivityName() + " with destination " + destinationName;
            } else {
                return "Insufficient Balance";
            }
        } else {
            passenger.addActivity(destinationName, activityID, 0);
            activity.setCapacity(activity.getAvailableCapacity() - 1);
            return "Successfully subscribed to activity " + activity.getActivityName() + " with destination " + destinationName;
        }
    }

    /**
     * Subscribe a package
     */
    public void subscribePackage() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the passengerID");
            UUID passengerID = UUID.fromString(sc.next());
            Passenger passenger = db.getPassengerDB().get(passengerID);
            String packageName;
            System.out.println("Enter the name of package you want to subscribe for");
            packageName = sc.next();
            TravelPackage travelPackage = db.getPackageDB().get(packageName);
            if (travelPackage.getPassengerCapacity() == 0) {
                System.out.println("Package Capacity full please try for a different package");
                return;
            }
            travelPackage.addPassenger(passengerID);
            System.out.println("List of activities available to subscribe for in this package");
            List<Destination> listOfDestination = travelPackage.getListOfDestination();
            for (int i = 0; i < listOfDestination.size(); i++) {
                Destination destination = listOfDestination.get(i);
                System.out.println("Activities available at " + destination.getName());
                for (int j = 0; j < destination.getListOfActivities().size(); j++) {
                    UUID activityID = destination.getListOfActivities().get(j);
                    System.out.println("ActivityID " + activityID + " name " + db.getActivityDB().get(activityID).getActivityName());
                }
            }

            System.out.println("Enter the number of activities you want to subscribe for");
            int noOfActivities = sc.nextInt();

            for (int i = 0; i < noOfActivities; i++) {
                System.out.println("Enter the destination name followed by activityID you want to subscribe for");
                String destinationName = sc.next();
                UUID activityID = UUID.fromString(sc.next());
                Activity activity = db.getActivityDB().get(activityID);
                System.out.println(subscribePackageUtils(passenger, activity, destinationName));
            }
        } catch (Exception e) {
            System.out.println("Facing issue in subscribing a package with exception " + e);
        }
    }

    /**
     * Show package itenary.
     */
    public void showPackageItenary() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the package name you want to see details for");
            String packageName = sc.next();
            TravelPackage travelPackage = db.getPackageDB().get(packageName);
            System.out.println("Package Name: " + travelPackage.getName());
            System.out.println("Available Capacity " + travelPackage.getPassengerCapacity());
            System.out.println("Itenary of the package with included activities is as follows:");
            List<Destination> destinationList = travelPackage.getListOfDestination();
            for (int i = 0; i < destinationList.size(); i++) {
                Destination destination = destinationList.get(i);
                System.out.println("Destination Name: " + destination.getName());
                List<UUID> activityList = destination.getListOfActivities();
                for (int j = 0; j < activityList.size(); j++) {
                    Activity activity = db.getActivityDB().get(activityList.get(j));
                    System.out.println("Activity Name: " + activity.getActivityName() + " Activity description: " + activity.getDescription() + " Activity cost: " + activity.getCost() + " Activity available capacity: " + activity.getAvailableCapacity());

                }
            }
        } catch (Exception e) {
            System.out.println("Facing issue in displaying package itenary with exception " + e);
        }
    }

    /**
     * Show activities with free slots
     */
    public void showAvailableActivities() {
        try {
            for (Map.Entry<String, Destination> entry : db.getDestinationDB().entrySet()) {
                String destinationName = entry.getKey();
                Destination generalDestination = entry.getValue();
                System.out.println("For the destination " + destinationName + " following activities are available");
                List<UUID> activityList = generalDestination.getListOfActivities();
                for (int i = 0; i < activityList.size(); i++) {
                    Activity activity = db.getActivityDB().get(activityList.get(i));
                    if (activity.getAvailableCapacity() > 0) {
                        System.out.println("Activity Name " + activity.getActivityName());
                        System.out.println("No of slots available " + activity.getAvailableCapacity());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Facing issue in showing available activities with exception " + e);
        }
    }

    @Override
    public void startOperation() {
        try {
            while (true) {
                Scanner sc = new Scanner(System.in);
                int x;
                System.out.println("Press 1 for adding new passenger");
                System.out.println("Press 2 for subscribing to a package");
                System.out.println("Press 3 for viewing the itenary of travel package");
                System.out.println("Press 4 for seeing currently available activities");
                System.out.println("Press 5 for going to main menu");
                x = sc.nextInt();

                switch (x) {
                    case 1:
                        System.out.println("##############################################");
                        this.createUser();
                        System.out.println("##############################################");
                        break;

                    case 2:
                        System.out.println("##############################################");
                        this.subscribePackage();
                        System.out.println("##############################################");
                        break;

                    case 3:
                        System.out.println("##############################################");
                        this.showPackageItenary();
                        System.out.println("##############################################");
                        break;

                    case 4:
                        System.out.println("##############################################");
                        this.showAvailableActivities();
                        System.out.println("##############################################");
                        break;

                    case 5:
                        return;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Facing issue with exception " + e);
        }
    }
}
