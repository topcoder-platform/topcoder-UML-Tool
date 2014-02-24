/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveSubsystemAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveSubsystemActionTest extends TestCase {
    /** The Subsystem instance for testing. */
    private Subsystem subsystem;

    /** The RemoveSubsystemAction instance for testing. */
    private RemoveSubsystemAction removeSubsystemAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        subsystem.setNamespace(new MockNamespaceAbstractImpl());
        removeSubsystemAction = new RemoveSubsystemAction(subsystem);
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#RemoveSubsystemAction(Subsystem)}</code> with null subsystem. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_Subsystem_NullSubsystem() {
        try {
            subsystem = null;
            new RemoveSubsystemAction(subsystem);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#RemoveSubsystemAction(Subsystem)}</code> with success process.
     * </p>
     */
    public void testConstructor_Subsystem_Success() {
        removeSubsystemAction = new RemoveSubsystemAction(subsystem);
        assertNotNull(removeSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Remove Subsystem", removeSubsystemAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        removeSubsystemAction.redo();
        removeSubsystemAction.undo();
        removeSubsystemAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        removeSubsystemAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link RemoveSubsystemAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        removeSubsystemAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveSubsystemActionTest.class);
    }
}
