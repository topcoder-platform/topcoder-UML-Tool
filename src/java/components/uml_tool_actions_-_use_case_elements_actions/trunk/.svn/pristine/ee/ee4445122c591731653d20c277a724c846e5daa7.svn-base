/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddUseCaseAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddUseCaseActionTest extends TestCase {
    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The UseCase instance for testing. */
    private UseCase useCase;

    /** The AddUseCaseAction instance for testing. */
    private AddUseCaseAction addUseCaseAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        manager = new UMLModelManager();
        namespace = new MockNamespaceAbstractImpl();
        useCase = new UseCaseImpl();
        addUseCaseAction = new AddUseCaseAction(useCase, manager);
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager)}</code> with null useCase. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManager_NullUseCase() {
        try {
            useCase = null;
            new AddUseCaseAction(useCase, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager)}</code> with null manager. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManager_NullUMLModelManager() {
        try {
            manager = null;
            new AddUseCaseAction(useCase, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManager_Success() {
        addUseCaseAction = new AddUseCaseAction(useCase, manager);
        assertNotNull(addUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code> with null
     * useCase. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManagerNamespace_NullUseCase() {
        try {
            useCase = null;
            new AddUseCaseAction(useCase, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code> with null
     * manager. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManagerNamespace_NullUMLModelManager() {
        try {
            manager = null;
            new AddUseCaseAction(useCase, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code> with null
     * namespace. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManagerNamespace_Namespace() {
        try {
            namespace = null;
            new AddUseCaseAction(useCase, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code> with success
     * process.
     * </p>
     */
    public void testConstructor_UseCaseUMLModelManagerNamespace_Success() {
        addUseCaseAction = new AddUseCaseAction(useCase, manager, namespace);
        assertNotNull(addUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Add Use Case", addUseCaseAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addUseCaseAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        addUseCaseAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddUseCaseAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        addUseCaseAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddUseCaseActionTest.class);
    }
}
