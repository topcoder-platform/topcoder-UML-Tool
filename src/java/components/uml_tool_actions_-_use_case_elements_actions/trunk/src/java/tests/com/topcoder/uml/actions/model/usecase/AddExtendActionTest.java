/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddExtendAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddExtendActionTest extends TestCase {
    /** The Extend instance for testing. */
    private Extend extend;

    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The AddExtendAction instance for testing. */
    private AddExtendAction addExtendAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        extend = new ExtendImpl();
        manager = new UMLModelManager();
        addExtendAction = new AddExtendAction(extend, manager);
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#AddExtendAction(Extend, UMLModelManager)}</code> with null extend. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_ExtendUMLModelManager_NullExtend() {
        try {
            extend = null;
            new AddExtendAction(extend, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#AddExtendAction(Extend, UMLModelManager)}</code> with null manager. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_ExtendUMLModelManager_NullUMLModelManager() {
        try {
            manager = null;
            new AddExtendAction(extend, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#AddExtendAction(Extend, UMLModelManager)}</code> with success process.
     * </p>
     */
    public void testConstructor_ExtendUMLModelManager_Success() {
        addExtendAction = new AddExtendAction(extend, manager);
        assertNotNull(addExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Add Extend", addExtendAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addExtendAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        addExtendAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddExtendAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        addExtendAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddExtendActionTest.class);
    }
}
