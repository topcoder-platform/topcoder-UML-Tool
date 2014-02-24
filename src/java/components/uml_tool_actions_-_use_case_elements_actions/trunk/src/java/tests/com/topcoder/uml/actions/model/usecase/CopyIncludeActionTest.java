/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CopyIncludeAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyIncludeActionTest extends TestCase {
    /** The Include instance for testing. */
    private Include include;

    /** The CopyIncludeAction instance for testing. */
    private CopyIncludeAction copyIncludeAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        include = new IncludeImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyIncludeAction = new CopyIncludeAction(include, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#CopyIncludeAction(Include)}</code> with null include. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_Include_NullInclude() {
        try {
            include = null;
            new CopyIncludeAction(include);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#CopyIncludeAction(Include)}</code> with success process.
     * </p>
     */
    public void testConstructor_Include_Success() {
        copyIncludeAction = new CopyIncludeAction(include);
        assertNotNull(copyIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#CopyIncludeAction(Include, Clipboard)}</code> with null include. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_IncludeClipboard_NullInclude() {
        try {
            include = null;
            new CopyIncludeAction(include, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#CopyIncludeAction(Include, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_IncludeClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CopyIncludeAction(include, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#CopyIncludeAction(Include, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_IncludeClipboard_Success() {
        copyIncludeAction = new CopyIncludeAction(include, clipboard);
        assertNotNull(copyIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyIncludeAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copyIncludeAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopyIncludeActionTest.class);
    }
}
