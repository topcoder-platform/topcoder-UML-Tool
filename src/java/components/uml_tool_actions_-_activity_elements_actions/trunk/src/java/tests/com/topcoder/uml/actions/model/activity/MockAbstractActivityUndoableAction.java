/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This is a mock extends of AbstractActivityUndoableAction class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockAbstractActivityUndoableAction extends AbstractActivityUndoableAction {

    /**
     * <p>
     * Represents the execute() method is executed or not.
     * </P>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * Call the super construct.
     * </P>
     *
     * @param name the presentation name of the undoable action
     */
    public MockAbstractActivityUndoableAction(String name) {
        super(name);
    }

    /**
     * <p>
     * Implements the execute() method.
     * </p>
     *
     * @throws ActionExecutionException if the value of system property
     * &quot;exception&quot; is &quot;ActionExecutionException&quot;
     */
    public void execute() throws ActionExecutionException {
        isExecute = true;

        if ("ActionExecutionException".equals(System.getProperty("exception"))) {
            throw new ActionExecutionException("exception.");
        }

    }

    /**
     * <p>
     * Return the tag for testing.
     * </p>
     *
     * @return the tag for testing
     */
    public boolean getIsExecuted() {
        return isExecute;
    }

}
