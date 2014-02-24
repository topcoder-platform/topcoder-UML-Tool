/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CutSubsystemAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutSubsystemActionTest extends TestCase {
    /** The Subsystem instance for testing. */
    private Subsystem subsystem;

    /** The CutSubsystemAction instance for testing. */
    private CutSubsystemAction cutSubsystemAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        subsystem.setNamespace(new MockNamespaceAbstractImpl());
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutSubsystemAction = new CutSubsystemAction(subsystem, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem)}</code> with null subsystem. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_Subsystem_NullSubsystem() {
        try {
            subsystem = null;
            new CutSubsystemAction(subsystem);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem)}</code> with success process.
     * </p>
     */
    public void testConstructor_Subsystem_Success() {
        cutSubsystemAction = new CutSubsystemAction(subsystem);
        assertNotNull(cutSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem, Clipboard)}</code> with null subsystem.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_NullSubsystem() {
        try {
            subsystem = null;
            new CutSubsystemAction(subsystem, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem, Clipboard)}</code> with null clipboard.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CutSubsystemAction(subsystem, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_Success() {
        cutSubsystemAction = new CutSubsystemAction(subsystem, clipboard);
        assertNotNull(cutSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Cut Subsystem", cutSubsystemAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model
        cutSubsystemAction.redo();
        cutSubsystemAction.undo();
        //execute the cut action
        cutSubsystemAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        cutSubsystemAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link CutSubsystemAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        cutSubsystemAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutSubsystemActionTest.class);
    }
}
