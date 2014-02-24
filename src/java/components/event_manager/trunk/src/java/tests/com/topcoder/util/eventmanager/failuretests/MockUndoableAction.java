/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

import javax.swing.undo.CompoundEdit;


/**
 * <p>
 * The mock implementation of <code>UndoableAction</code> class.
 * </p>
 *
 * <p>
 * This class just extends <code>CompoundEdit</code> to implement <code>UndoableEdit</code> interface.
 * </p>
 *
 * @author King_Bette
 * @version 1.0
 */
public class MockUndoableAction extends CompoundEdit implements UndoableAction {
    /**
     * Constructor of <code>MockUndoableAction</code>.
     *
     * @throws ActionExecutionException if any Exception occurs
     */
    public void execute() throws ActionExecutionException {
        // Empty implementation
    }
}
