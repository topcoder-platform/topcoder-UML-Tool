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
 * Unit test cases for <code>{@link CutExtendAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutExtendActionTest extends TestCase {
    /** The Extend instance for testing. */
    private Extend extend;

    /** The CutExtendAction instance for testing. */
    private CutExtendAction cutExtendAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        extend = new ExtendImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        extend.setNamespace(new MockNamespaceAbstractImpl());
        cutExtendAction = new CutExtendAction(extend, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#CutExtendAction(Extend)}</code> with null extend. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Extend_NullExtend() {
        try {
            extend = null;
            new CutExtendAction(extend);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#CutExtendAction(Extend)}</code> with success process.
     * </p>
     */
    public void testConstructor_Extend_Success() {
        cutExtendAction = new CutExtendAction(extend);
        assertNotNull(cutExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#CutExtendAction(Extend, Clipboard)}</code> with null extend. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ExtendClipboard_NullExtend() {
        try {
            extend = null;
            new CutExtendAction(extend, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#CutExtendAction(Extend, Clipboard)}</code> with null clipboard. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_ExtendClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CutExtendAction(extend, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#CutExtendAction(Extend, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ExtendClipboard_Success() {
        cutExtendAction = new CutExtendAction(extend, clipboard);
        assertNotNull(cutExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Cut Extend", cutExtendAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model
        cutExtendAction.redo();
        cutExtendAction.undo();
        //execute the cut action
        cutExtendAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        cutExtendAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link CutExtendAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        cutExtendAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutExtendActionTest.class);
    }
}
