package org.example.passenger;

import org.example.activity.Activity;
import org.example.activity.GeneralActivity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumPassengerTest {

    @Test
    void getPassengerType() {
        Passenger premiumPassenger = new PremiumPassenger("Mani", "9932323123", "Premium");
        assertEquals(premiumPassenger.getPassengerType(), "Premium");
    }

    @Test
    void getName() {
        Passenger premiumPassenger = new PremiumPassenger("Mani", "9932323123", "Premium");
        assertEquals(premiumPassenger.getName(), "Mani");
    }

    @Test
    void checkActivityCost() {
        Passenger premiumPassenger = new PremiumPassenger("Mani", "9932323123", "Premium");
        Activity generalActivity = new GeneralActivity("Scuba", "This is scuba diving", 1000, 10);
        int dicountedCost = generalActivity.getCost() - (generalActivity.getCost() * premiumPassenger.getDiscount()) / 100;
        premiumPassenger.addActivity("Bali", generalActivity.getActivityID(), dicountedCost);
        assertEquals(premiumPassenger.getListOfTransaction().get(0).getCostOfActivity(), 0);
    }
}