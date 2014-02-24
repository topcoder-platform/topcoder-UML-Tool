/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveIncludeAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveIncludeActionTest extends TestCase {
    /** The Include instance for testing. */
    private Include include;

    /** The RemoveIncludeAction instance for testing. */
    private RemoveIncludeAction removeIncludeAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        include = new IncludeImpl();
        include.setNamespace(new MockNamespaceAbstractImpl());
        removeIncludeAction = new RemoveIncludeAction(include);
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#RemoveIncludeAction(Include)}</code> with null include. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_Include_NullInclude() {
        try {
            include = null;
            new RemoveIncludeAction(include);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#RemoveIncludeAction(Include)}</code> with success process.
     * </p>
     */
    public void testConstructor_Include_Success() {
        removeIncludeAction = new RemoveIncludeAction(include);
        assertNotNull(removeIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Remove Include", removeIncludeAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        removeIncludeAction.redo();
        removeIncludeAction.undo();
        removeIncludeAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        removeIncludeAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link RemoveIncludeAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        removeIncludeAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveIncludeActionTest.class);
    }
}
