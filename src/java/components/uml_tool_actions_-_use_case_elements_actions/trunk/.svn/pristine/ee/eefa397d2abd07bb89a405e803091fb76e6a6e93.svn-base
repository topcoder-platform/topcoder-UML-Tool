/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveExtendAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveExtendActionTest extends TestCase {
    /** The Extend instance for testing. */
    private Extend extend;

    /** The RemoveExtendAction instance for testing. */
    private RemoveExtendAction removeExtendAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        extend = new ExtendImpl();
        extend.setNamespace(new MockNamespaceAbstractImpl());
        removeExtendAction = new RemoveExtendAction(extend);
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#RemoveExtendAction(Extend)}</code> with null extend. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_Extend_NullExtend() {
        try {
            extend = null;
            new RemoveExtendAction(extend);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#RemoveExtendAction(Extend)}</code> with success process.
     * </p>
     */
    public void testConstructor_Extend_Success() {
        removeExtendAction = new RemoveExtendAction(extend);
        assertNotNull(removeExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Remove Extend", removeExtendAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        removeExtendAction.redo();
        removeExtendAction.undo();
        removeExtendAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        removeExtendAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link RemoveExtendAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        removeExtendAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveExtendActionTest.class);
    }
}
