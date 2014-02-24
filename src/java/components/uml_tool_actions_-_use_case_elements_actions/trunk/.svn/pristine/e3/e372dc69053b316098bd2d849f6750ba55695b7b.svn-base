/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AddExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>AddExtendAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddExtendAction extends TestCase {

    /**
     * The <code>Extend</code> instance used for test.
     */
    private Extend extend;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager manager;

    /**
     * The <code>AddExtendAction</code> instance used to test against.
     */
    private AddExtendAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        extend = new ExtendImpl();
        manager = new UMLModelManager();
        action = new AddExtendAction(extend, manager);
    }

    /**
     * Test the constructor <code>AddExtendAction(Extend, UMLModelManager)</code>.
     */
    public void testConstructor() {
        AddExtendAction addExtendAction = new AddExtendAction(extend, manager);
        assertNotNull("Instance of AddExtendAction should be created.", addExtendAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Add Extend"));
    }
}
