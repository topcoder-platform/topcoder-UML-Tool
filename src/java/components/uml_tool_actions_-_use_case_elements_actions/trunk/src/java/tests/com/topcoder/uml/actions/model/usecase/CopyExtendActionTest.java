/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CopyExtendAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyExtendActionTest extends TestCase {
    /** The Extend instance for testing. */
    private Extend extend;

    /** The CopyExtendAction instance for testing. */
    private CopyExtendAction copyExtendAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        extend = new ExtendImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyExtendAction = new CopyExtendAction(extend, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#CopyExtendAction(Extend)}</code> with null extend. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Extend_NullExtend() {
        try {
            extend = null;
            new CopyExtendAction(extend);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#CopyExtendAction(Extend)}</code> with success process.
     * </p>
     */
    public void testConstructor_Extend_Success() {
        copyExtendAction = new CopyExtendAction(extend);
        assertNotNull(copyExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#CopyExtendAction(Extend, Clipboard)}</code> with null extend. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ExtendClipboard_NullExtend() {
        try {
            extend = null;
            new CopyExtendAction(extend, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#CopyExtendAction(Extend, Clipboard)}</code> with null clipboard. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_ExtendClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CopyExtendAction(extend, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#CopyExtendAction(Extend, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ExtendClipboard_Success() {
        copyExtendAction = new CopyExtendAction(extend, clipboard);
        assertNotNull(copyExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyExtendAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copyExtendAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopyExtendActionTest.class);
    }
}
