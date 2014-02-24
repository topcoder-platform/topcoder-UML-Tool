/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddActionTest extends TestCase {
    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The AddAction instance for testing. */
    private AddAction addAction;

    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelElement = new MockModelElementAbstractImpl();
        usecaseToolUtil = new ActorUtil();
        namespace = new MockNamespaceAbstractImpl();
        manager = new UMLModelManager();
        addAction = new MockAddAction(modelElement, usecaseToolUtil, manager, namespace);
    }

    /**
     * <p>
     * Test <code>{@link AddAction#AddAction(ModelElement, UsecaseToolUtil, UMLModelManager, Namespace)}</code> with
     * null manager. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilUMLModelManagerNamespace_NullUMLModelManager() {
        try {
            manager = null;
            new MockAddAction(modelElement, usecaseToolUtil, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddAction#AddAction(ModelElement, UsecaseToolUtil, UMLModelManager, Namespace)}</code> with
     * null namespace. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilUMLModelManagerNamespace_NullNamespace() {
        try {
            namespace = null;
            new MockAddAction(modelElement, usecaseToolUtil, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddAction#AddAction(ModelElement, UsecaseToolUtil, UMLModelManager, Namespace)}</code> with
     * success process.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilUMLModelManagerNamespace_Success() {
        addAction = new MockAddAction(modelElement, usecaseToolUtil, manager, namespace);
        assertNotNull(addAction);
        assertEquals(modelElement, addAction.getModelElement());
        assertEquals(usecaseToolUtil, addAction.getUsecaseToolUtil());
    }

    /**
     * <p>
     * Test <code>{@link AddAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addAction.execute();
        assertTrue(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link AddAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success1() {
        //the redo flag is false
        addAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddAction#undo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success2() {
        //set the redo flag to true
        addAction.undo();
        addAction.redo();
        assertTrue(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>undo()</code> with success process.
     * </p>
     */
    public void testUndo_Success1() {
        //the undo flag is false
        addAction.undo();
    }

    /**
     * <p>
     * Test <code>undo()</code> with success process.
     * </p>
     */
    public void testUndo_Success2() {
        //set the undo flag to true
        addAction.undo();
        addAction.redo();
        addAction.undo();
        assertFalse(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddActionTest.class);
    }
}
