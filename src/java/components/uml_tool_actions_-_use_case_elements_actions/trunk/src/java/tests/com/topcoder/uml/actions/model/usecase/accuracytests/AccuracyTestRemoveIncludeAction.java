/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.RemoveIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>RemoveIncludeAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveIncludeAction extends TestCase {

    /**
     * The <code>Include</code> instance used for test.
     */
    private Include include;

    /**
     * The <code>RemoveIncludeAction</code> instance used to test against.
     */
    private RemoveIncludeAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        include = new IncludeImpl();
        action = new RemoveIncludeAction(include);
    }

    /**
     * Test the constructor <code>RemoveIncludeAction(Include)</code>.
     */
    public void testConstructor() {
        RemoveIncludeAction removeIncludeAction = new RemoveIncludeAction(include);
        assertNotNull("Instance of RemoveIncludeAction should be created.", removeIncludeAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Remove Include"));
    }
}
