package org.example.service;

import org.example.Database;

/**
 * The interface User service.
 */
public interface UserService
{
    /**
     * The constant userType.
     */
    String userType="";
    /**
     * The constant db.
     */
    Database db=null;

    /**
     * Start operation.
     */
    public void startOperation();
}
