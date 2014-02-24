/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CutExceptionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutExceptionActionTest extends TestCase {

    /**
     * The Exception instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class exception = new ClassImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        // create a Exception
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("Exception");
        exception.addStereotype(stereoType);
    }

    /**
     * Test Constructor(Class), with correct exception.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor1() throws Exception {
        CutExceptionAction copyAction = new CutExceptionAction(exception);

        assertTrue("Should be a CutExceptionAction instance.", copyAction instanceof CutExceptionAction);
    }

    /**
     * Test Constructor(Class), with wrong exception.
     * InvalidDataContentException is expected.
     */
    public void testCtor1WithWrongException() {
        try {
            new CutExceptionAction(new ClassImpl());
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor(Class), with null exception. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor1WithNullException() throws Exception {
        try {
            new CutExceptionAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, Clipboard), with correct exception and clipboard.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2() throws Exception {
        CutExceptionAction copyAction = new CutExceptionAction(exception, clipboard);

        assertTrue("Should be a CutExceptionAction instance.", copyAction instanceof CutExceptionAction);
    }

    /**
     * Test Constructor(Class, Clipboard), with wrong exception.
     * InvalidDataContentException is expected.
     */
    public void testCtor2WithWrongException() {
        try {
            new CutExceptionAction(new ClassImpl(), clipboard);
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, Clipboard), with null exception.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullException() throws Exception {
        try {
            new CutExceptionAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, Clipboard), with null clipboard. Do the same as
     * it is not null, for the constructor will assign the default clipboard.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullClipboard() throws Exception {
        try {
            new CutExceptionAction(exception, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test getPresentationName.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testGetPresentationName() throws Exception {
        CutExceptionAction cutAction = new CutExceptionAction(exception);

        assertEquals("Should return PRESENTATION_NAME.", "Cut Exception", cutAction.getPresentationName());
    }
}