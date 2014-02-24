/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.RemoveExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>RemoveExtendAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveExtendAction extends TestCase {

    /**
     * The <code>Extend</code> instance used for test.
     */
    private Extend extend;

    /**
     * The <code>RemoveExtendAction</code> instance used to test against.
     */
    private RemoveExtendAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        extend = new ExtendImpl();
        action = new RemoveExtendAction(extend);
    }

    /**
     * Test the constructor <code>RemoveExtendAction(Extend)</code>.
     */
    public void testConstructor() {
        RemoveExtendAction removeExtendAction = new RemoveExtendAction(extend);
        assertNotNull("Instance of RemoveExtendAction should be created.", removeExtendAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Remove Extend"));
    }
}
