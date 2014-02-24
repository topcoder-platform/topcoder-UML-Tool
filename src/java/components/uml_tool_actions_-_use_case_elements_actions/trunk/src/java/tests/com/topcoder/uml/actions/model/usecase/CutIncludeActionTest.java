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
 * Unit test cases for <code>{@link CutIncludeAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutIncludeActionTest extends TestCase {
    /** The Include instance for testing. */
    private Include include;

    /** The CutIncludeAction instance for testing. */
    private CutIncludeAction cutIncludeAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        include = new IncludeImpl();
        include.setNamespace(new MockNamespaceAbstractImpl());
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutIncludeAction = new CutIncludeAction(include, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#CutIncludeAction(Include)}</code> with null include. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_Include_NullInclude() {
        try {
            include = null;
            new CutIncludeAction(include);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#CutIncludeAction(Include)}</code> with success process.
     * </p>
     */
    public void testConstructor_Include_Success() {
        cutIncludeAction = new CutIncludeAction(include);
        assertNotNull(cutIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#CutIncludeAction(Include, Clipboard)}</code> with null include. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_IncludeClipboard_NullInclude() {
        try {
            include = null;
            new CutIncludeAction(include, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#CutIncludeAction(Include, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_IncludeClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CutIncludeAction(include, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#CutIncludeAction(Include, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_IncludeClipboard_Success() {
        cutIncludeAction = new CutIncludeAction(include, clipboard);
        assertNotNull(cutIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Cut Include", cutIncludeAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model
        cutIncludeAction.redo();
        cutIncludeAction.undo();
        //execute the cut action
        cutIncludeAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        cutIncludeAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link CutIncludeAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        cutIncludeAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutIncludeActionTest.class);
    }
}
