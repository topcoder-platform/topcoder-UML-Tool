/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.RemoveSubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>RemoveSubsystemAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveSubsystemAction extends TestCase {

    /**
     * The <code>Subsystem</code> instance used for test.
     */
    private Subsystem subsystem;

    /**
     * The <code>RemoveSubsystemAction</code> instance used to test against.
     */
    private RemoveSubsystemAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        action = new RemoveSubsystemAction(subsystem);
    }

    /**
     * Test the constructor <code>RemoveSubsystemAction(Subsystem)</code>.
     */
    public void testConstructor() {
        RemoveSubsystemAction removeSubsystemAction = new RemoveSubsystemAction(subsystem);
        assertNotNull("Instance of RemoveSubsystemAction should be created.", removeSubsystemAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Remove Subsystem"));
    }
}
