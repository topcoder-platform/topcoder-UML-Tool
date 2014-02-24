/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddIncludeAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddIncludeActionTest extends TestCase {
    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The Include instance for testing. */
    private Include include;

    /** The AddIncludeAction instance for testing. */
    private AddIncludeAction addIncludeAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        manager = new UMLModelManager();
        include = new IncludeImpl();
        addIncludeAction = new AddIncludeAction(include, manager);
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#AddIncludeAction(Include, UMLModelManager)}</code> with null include. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_IncludeUMLModelManager_NullInclude() {
        try {
            include = null;
            new AddIncludeAction(include, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#AddIncludeAction(Include, UMLModelManager)}</code> with null manager. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_IncludeUMLModelManager_NullUMLModelManager() {
        try {
            manager = null;
            new AddIncludeAction(include, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#AddIncludeAction(Include, UMLModelManager)}</code> with success process.
     * </p>
     */
    public void testConstructor_IncludeUMLModelManager_Success() {
        addIncludeAction = new AddIncludeAction(include, manager);
        assertNotNull(addIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Add Include", addIncludeAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addIncludeAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        addIncludeAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddIncludeAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        addIncludeAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddIncludeActionTest.class);
    }
}
