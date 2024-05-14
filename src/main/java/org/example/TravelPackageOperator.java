package org.example;

import org.example.service.AdminService;
import org.example.service.NonAdminService;
import org.example.service.UserService;
import java.util.Scanner;

/**
 * The type Travel package operator.
 */
public class TravelPackageOperator
{
    /**
     * The Db.
     */
    Database db;

    /**
     * Instantiates a new Travel package operator.
     */
    public TravelPackageOperator()
    {

        this.db=new Database().createDB();
    }

    /**
     * Start operation.
     */
    public void startOperation()
    {
        while (true)
        {
            int x;
            Scanner sc = new Scanner(System.in);

            System.out.println("Press 1 for admin features: ");
            System.out.println("Press 2 for Non Admin features: ");
            System.out.println("Press 3 to exit");
            x = sc.nextInt();
            switch (x)
            {
                case 1:
                    UserService admin = new AdminService("Admin",db);
                    admin.startOperation();
                    break;
                case 2:
                    UserService nonAdmin = new NonAdminService("NonAdmin",db);
                    nonAdmin.startOperation();
                    break;
                case 3:
                    break;

            }
        }
    }
}
