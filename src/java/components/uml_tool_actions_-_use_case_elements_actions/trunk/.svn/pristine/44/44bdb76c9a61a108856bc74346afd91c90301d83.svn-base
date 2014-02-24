/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AddUseCaseAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>AddUseCaseAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddUseCaseAction extends TestCase {

    /**
     * The <code>UseCase</code> instance used for test.
     */
    private UseCase useCase;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager manager;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>AddUseCaseAction</code> instance used to test against.
     */
    private AddUseCaseAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        manager = new UMLModelManager();
        namespace = new MockNamespaceImpl();
        action = new AddUseCaseAction(useCase, manager);
    }

    /**
     * Test the constructor <code>AddUseCaseAction(UseCase, UMLModelManager)</code>.
     */
    public void testConstructor() {
        AddUseCaseAction addUseCaseAction = new AddUseCaseAction(useCase, manager);
        assertNotNull("Instance of AddUseCaseAction should be created.", addUseCaseAction);
    }

    /**
     * Test the constructor <code>AddUseCaseAction(UseCase, UMLModelManager, Namespace)</code>.
     */
    public void testConstructorWithNamespace() {
        AddUseCaseAction addUseCaseAction = new AddUseCaseAction(useCase, manager, namespace);
        assertNotNull("Instance of AddUseCaseAction should be created.", addUseCaseAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Add Use Case"));
    }
}
