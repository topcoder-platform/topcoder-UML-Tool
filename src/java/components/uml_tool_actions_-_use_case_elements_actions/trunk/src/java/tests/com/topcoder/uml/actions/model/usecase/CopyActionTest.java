/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CopyAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyActionTest extends TestCase {
    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /** The CopyAction instance for testing. */
    private CopyAction copyAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelElement = new ActorImpl();
        usecaseToolUtil = new ActorUtil();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyAction = new MockCopyAction(modelElement, usecaseToolUtil, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopyAction#CopyAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with null
     * modelElement. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_NullModelElement() {
        try {
            modelElement = null;
            new MockCopyAction(modelElement, usecaseToolUtil, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyAction#CopyAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with null
     * usecaseToolUtil. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_NullUsecaseToolUtil() {
        try {
            usecaseToolUtil = null;
            new MockCopyAction(modelElement, usecaseToolUtil, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyAction#CopyAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_Success() {
        copyAction = new MockCopyAction(modelElement, usecaseToolUtil, clipboard);
        assertNotNull(copyAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copyAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopyActionTest.class);
    }
}
