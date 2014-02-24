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
 * Unit test cases for <code>{@link CopySubsystemAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopySubsystemActionTest extends TestCase {
    /** The Subsystem instance for testing. */
    private Subsystem subsystem;

    /** The CopySubsystemAction instance for testing. */
    private CopySubsystemAction copySubsystemAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copySubsystemAction = new CopySubsystemAction(subsystem, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem)}</code> with null subsystem. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_Subsystem_NullSubsystem() {
        try {
            subsystem = null;
            new CopySubsystemAction(subsystem);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem)}</code> with success process.
     * </p>
     */
    public void testConstructor_Subsystem_Success() {
        copySubsystemAction = new CopySubsystemAction(subsystem);
        assertNotNull(copySubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem, Clipboard)}</code> with null subsystem.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_NullSubsystem() {
        try {
            subsystem = null;
            new CopySubsystemAction(subsystem, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem, Clipboard)}</code> with null clipboard.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CopySubsystemAction(subsystem, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_SubsystemClipboard_Success() {
        copySubsystemAction = new CopySubsystemAction(subsystem, clipboard);
        assertNotNull(copySubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link CopySubsystemAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copySubsystemAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopySubsystemActionTest.class);
    }
}
