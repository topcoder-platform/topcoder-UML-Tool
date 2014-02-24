/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AddIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>AddIncludeAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddIncludeAction extends TestCase {

    /**
     * The <code>Include</code> instance used for test.
     */
    private Include include;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager manager;

    /**
     * The <code>AddIncludeAction</code> instance used to test against.
     */
    private AddIncludeAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        include = new IncludeImpl();
        manager = new UMLModelManager();
        action = new AddIncludeAction(include, manager);
    }

    /**
     * Test the constructor <code>AddIncludeAction(Include, UMLModelManager)</code>.
     */
    public void testConstructor() {
        AddIncludeAction addIncludeAction = new AddIncludeAction(include, manager);
        assertNotNull("Instance of AddIncludeAction should be created.", addIncludeAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Add Include"));
    }
}
