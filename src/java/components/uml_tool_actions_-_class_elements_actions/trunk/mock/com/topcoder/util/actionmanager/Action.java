/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Action {
    /**
     * Mock method.
     *
     * @throws ActionExecutionException
     */
    public void execute() throws ActionExecutionException;
}