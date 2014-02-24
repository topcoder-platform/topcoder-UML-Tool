/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link CopyObjectAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CopyObjectActionUnitTest extends TestCase {

    /**
     * Object instance to be used for the testing.
     */
    private Object object;

    /**
     * CopyObjectAction instance to be used for the testing.
     */
    private CopyObjectAction copyObjectAction = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
        object = new ObjectImpl();
        object.setName("object");
        copyObjectAction = new CopyObjectAction(object);
    }

    /**
     * <p>
     * Tears down the environment after the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        object = null;
        copyObjectAction = null;
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CopyObjectActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CopyObjectAction#CopyObjectAction(Object)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopyObjectAction() throws Exception {
        // check for null
        assertNotNull("CopyObjectAction creation failed", copyObjectAction);
        // check for the variable initialization.
        assertEquals("CopyObjectAction creation failed", Toolkit.getDefaultToolkit().getSystemClipboard(),
            TestHelper.getFieldValue(copyObjectAction, "clipboard"));
        assertNotNull("CopyObjectAction creation failed", TestHelper.getFieldValue(copyObjectAction, "object"));
    }

    /**
     * <p>
     * Failure test for {@link CopyObjectAction#CopyObjectAction(Object)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CopyObjectAction() throws Exception {
        try {
            new CopyObjectAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in CopyObjectAction#CopyObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CopyObjectAction#CopyObjectAction(Object, Clipboard)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CopyObjectAction1() throws Exception {
        Clipboard clipboard = new Clipboard("test");
        CopyObjectAction copyObjectAction1 = new CopyObjectAction(object, clipboard);
        // check for null
        assertNotNull("CopyObjectAction creation failed", copyObjectAction1);
        // check for the variable initialization.
        assertEquals("CopyObjectAction creation failed", clipboard, TestHelper.getFieldValue(copyObjectAction1,
            "clipboard"));
        assertNotNull("CopyObjectAction creation failed", TestHelper.getFieldValue(copyObjectAction1, "object"));
    }

    /**
     * <p>
     * Failure test for {@link CopyObjectAction#CopyObjectAction(Object, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Object object : null value
     *         Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CopyObjectAction1() throws Exception {
        try {
            new CopyObjectAction(null, new Clipboard("test"));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in CopyObjectAction#CopyObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link CopyObjectAction#CopyObjectAction(Object, Clipboard)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Object object : Valid value
     *         Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CopyObjectAction2() throws Exception {
        try {
            new CopyObjectAction(object, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in CopyObjectAction#CopyObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CopyObjectAction#execute()} method.
     * </p>
     * <p>
     * Executes and checks whether the object copied is the same object.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        copyObjectAction.execute();
        assertEquals("execute failed", ((Object) Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null).getTransferData(CollaborationTransfer.OBJECT_FLAVOR)).getName(), "object");
    }
}
