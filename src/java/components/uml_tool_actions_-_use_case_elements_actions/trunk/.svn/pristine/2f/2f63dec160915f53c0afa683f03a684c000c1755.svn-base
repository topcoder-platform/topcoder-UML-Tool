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
 * Unit test cases for <code>{@link CutAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutActionTest extends TestCase {
    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /** The CutAction instance for testing. */
    private CutAction cutAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelElement = new ActorImpl();
        modelElement.setNamespace(new MockNamespaceAbstractImpl());
        usecaseToolUtil = new ActorUtil();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutAction = new MockCutAction(modelElement, usecaseToolUtil, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutAction#CutAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with null modelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_NullModelElement() {
        try {
            modelElement = null;
            new MockCutAction(modelElement, usecaseToolUtil, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutAction#CutAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with null
     * usecaseToolUtil. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_NullUsecaseToolUtil() {
        try {
            usecaseToolUtil = null;
            new MockCutAction(modelElement, usecaseToolUtil, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutAction#CutAction(ModelElement, UsecaseToolUtil, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtilClipboard_Success() {
        cutAction = new MockCutAction(modelElement, usecaseToolUtil, clipboard);
        assertNotNull(cutAction);
    }

    /**
     * <p>
     * Test <code>{@link CutAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model 
        cutAction.redo();
        cutAction.undo();
        //execute the cut action
        cutAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link CutAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        //set the redo flag to true
        cutAction.undo();
        cutAction.redo();
        assertFalse(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link CutAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        //set the undo flag to true
        cutAction.redo();
        cutAction.undo();
        assertTrue(usecaseToolUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutActionTest.class);
    }
}
