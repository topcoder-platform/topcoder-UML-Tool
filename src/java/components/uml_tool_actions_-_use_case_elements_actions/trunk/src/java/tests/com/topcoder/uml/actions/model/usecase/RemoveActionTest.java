/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActionTest extends TestCase {
    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The RemoveAction instance for testing. */
    private RemoveAction removeAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelElement = new ActorImpl();
        modelElement.setNamespace(new MockNamespaceAbstractImpl());
        usecaseToolUtil = new ActorUtil();
        removeAction = new MockRemoveAction(modelElement, usecaseToolUtil);
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#RemoveAction(ModelElement, UsecaseToolUtil)}</code> with null modelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testConsturctor_ModelElementUsecaseToolUtil_NullModelElement() {
        try {
            modelElement = null;
            new MockRemoveAction(modelElement, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#RemoveAction(ModelElement, UsecaseToolUtil)}</code> with null usecaseToolUtil.
     * Should throw an Exception here.
     * </p>
     */
    public void testConsturctor_ModelElementUsecaseToolUtil_NullUsecaseToolUtil() {
        try {
            usecaseToolUtil = null;
            new MockRemoveAction(modelElement, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#RemoveAction(ModelElement, UsecaseToolUtil)}</code> with success process.
     * </p>
     */
    public void testConsturctor_ModelElementUsecaseToolUtil_Success() {
        removeAction = new MockRemoveAction(modelElement, usecaseToolUtil);
        assertNotNull(removeAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //set the undo flag to true
        removeAction.redo();
        //add a element to model
        removeAction.undo();
        //call the execute
        removeAction.execute();
        assertFalse(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        //set the redo flag to true
        removeAction.undo();
        removeAction.redo();
        assertFalse(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link RemoveAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        //set the undo flag to true
        removeAction.redo();
        removeAction.undo();
        assertTrue(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveActionTest.class);
    }
}
