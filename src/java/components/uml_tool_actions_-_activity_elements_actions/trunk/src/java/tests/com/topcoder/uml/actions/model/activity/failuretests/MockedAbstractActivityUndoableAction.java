/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import com.topcoder.uml.actions.model.activity.AbstractActivityUndoableAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
/**
 * <p>
 * This is a mocked implementation of <code>AbstractActivityUndoableAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
class MockedAbstractActivityUndoableAction extends AbstractActivityUndoableAction {

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param name the presentation name of the undoable action
     */
    protected MockedAbstractActivityUndoableAction(String name) {
        super(name);
    }

    /**
     * <p>
     * do nothing.
     * </p>
     */
    public void execute() throws ActionExecutionException {
        // Do nothing
    }

    /**
     * <p>
     * Overrides <code>logException(String message, Throwable exception)</code>
     * to be public.
     * </p>
     *
     * @param message the error message to log. Can be <code>null</code> or
     *            empty string.
     * @param exception the exception to log.
     * @throws IllegalArgumentException if the <code>exception</code> is
     *             <code>null</code>.
     */
    protected void logException(String message, Throwable exception) {
        super.logException(message, exception);
    }
}
