/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

/**
 * <p>
 * This class implements the TransientAction interface and used for testing only.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class PrintClassDiagramAction implements TransientAction {
    /**
     * <p>
     * The boolean flag to specify whether the execute() method is called or not.
     * Default value is false, and is set in the execute() method.
     * </p>
     */
    private boolean executed = false;

    /**
     * <p>
     * This method implements the execute() method defined in the TransientAction interface.
     * </p>
     *
     * <p>
     * This method will set the "executed" flag to true and when the system property value of "execute"
     * is "exception", ActionExecutionException will be thrown.
     * </p>
     *
     * @throws ActionExecutionException if the system property value of "execute" is "exception"
     */
    public void execute() throws ActionExecutionException {
        executed = true;

        if ("exception".equals(System.getProperty("execute"))) {
            throw new ActionExecutionException("exception");
        }
    }

    /**
     * <p>
     * This method specifies whether the execute() method is called or not.
     * </p>
     *
     * @return true if the execute() method is called, otherwise false.
     */
    public boolean isExecuted() {
        return executed;
    }

}
