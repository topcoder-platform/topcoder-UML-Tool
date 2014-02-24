/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AddSubsystemAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>AddSubsystemAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddSubsystemAction extends TestCase {

    /**
     * The <code>Subsystem</code> instance used for test.
     */
    private Subsystem subsystem;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager manager;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>AddSubsystemAction</code> instance used to test against.
     */
    private AddSubsystemAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        manager = new UMLModelManager();
        namespace = new MockNamespaceImpl();
        action = new AddSubsystemAction(subsystem, manager);
    }

    /**
     * Test the constructor <code>AddSubsystemAction(Subsystem, UMLModelManager)</code>.
     */
    public void testConstructor() {
        AddSubsystemAction addSubsystemAction = new AddSubsystemAction(subsystem, manager);
        assertNotNull("Instance of AddSubsystemAction should be created.", addSubsystemAction);
    }

    /**
     * Test the constructor <code>AddSubsystemAction(Subsystem, UMLModelManager, Namespace)</code>.
     */
    public void testConstructorWithNamespace() {
        AddSubsystemAction addSubsystemAction = new AddSubsystemAction(subsystem, manager, namespace);
        assertNotNull("Instance of AddSubsystemAction should be created.", addSubsystemAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Add Subsystem"));
    }
}
