/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link CollaborationTransfer} class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class CollaborationTransferUnitTest extends TestCase {

    /**
     * CollaborationTransfer instance to be used for the testing.
     */
    private CollaborationTransfer collaborationTransfer = null;

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
        collaborationTransfer = new CollaborationTransfer(TestHelper.OBJECT);
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
        TestHelper.releaseConfig();
        collaborationTransfer = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CollaborationTransferUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#OBJECT_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.OBJECT_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Object implementation");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#ASYNCHRONOUS_MESSAGE_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor1() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Asynchronous message");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CREATE_MESSAGE_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor2() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.CREATE_MESSAGE_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Create message type");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#RETURN_MESSAGE_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor3() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.RETURN_MESSAGE_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Return message type");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#SEND_SIGNAL_MESSAGE_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor4() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Send Signal message type");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#SYNCHRONOUS_MESSAGE_FLAVOR.
     * </p>
     * <p>
     * Checks the name of the data flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_DataFlavor5() throws Exception {
        assertEquals("Static Data flavor creation failed", CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR
            .getHumanPresentableName(), "Represents DataFlavor for Synchronous message type");
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Object)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer() throws Exception {
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", TestHelper.OBJECT, TestHelper.getFieldValue(
            collaborationTransfer, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.OBJECT_FLAVOR,
            collaborationTransfer.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#CollaborationTransfer(Object)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CollaborationTransfer() throws Exception {
        try {
            new CollaborationTransfer((Object) null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in CollaborationTransfer#CollaborationTransfer should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization. For a asynchronous
     * message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer1() throws Exception {
        Stimulus stimulus = TestHelper.getAsynchronousMessage();
        CollaborationTransfer collaborationTransfer1 = new CollaborationTransfer(stimulus);
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer1);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", stimulus, TestHelper.getFieldValue(
            collaborationTransfer1, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR,
            collaborationTransfer1.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization. For a create message
     * type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer2() throws Exception {
        Stimulus stimulus = TestHelper.getCreateMessage();
        CollaborationTransfer collaborationTransfer1 = new CollaborationTransfer(stimulus);
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer1);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", stimulus, TestHelper.getFieldValue(
            collaborationTransfer1, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.CREATE_MESSAGE_FLAVOR,
            collaborationTransfer1.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization. For a return message
     * type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer3() throws Exception {
        Stimulus stimulus = TestHelper.getReturnMessage();
        CollaborationTransfer collaborationTransfer1 = new CollaborationTransfer(stimulus);
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer1);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", stimulus, TestHelper.getFieldValue(
            collaborationTransfer1, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.RETURN_MESSAGE_FLAVOR,
            collaborationTransfer1.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization. For a send signal
     * message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer4() throws Exception {
        Stimulus stimulus = TestHelper.getSendSignalMessage();
        CollaborationTransfer collaborationTransfer1 = new CollaborationTransfer(stimulus);
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer1);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", stimulus, TestHelper.getFieldValue(
            collaborationTransfer1, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.SEND_SIGNAL_MESSAGE_FLAVOR,
            collaborationTransfer1.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization. For a synchronous
     * message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_CollaborationTransfer5() throws Exception {
        Stimulus stimulus = TestHelper.getSynchronousMessage();
        CollaborationTransfer collaborationTransfer1 = new CollaborationTransfer(stimulus);
        // check for null
        assertNotNull("CollaborationTransfer creation failed", collaborationTransfer1);
        // check the variable initialization
        assertEquals("CollaborationTransfer creation failed", stimulus, TestHelper.getFieldValue(
            collaborationTransfer1, "element"));
        assertEquals("CollaborationTransfer creation failed", CollaborationTransfer.SYNCHRONOUS_MESSAGE_FLAVOR,
            collaborationTransfer1.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CollaborationTransfer1() throws Exception {
        try {
            new CollaborationTransfer((Stimulus) null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in CollaborationTransfer#CollaborationTransfer should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#CollaborationTransfer(Stimulus)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     Stimulus stimulus : not of any message types.
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_CollaborationTransfer2() throws Exception {
        try {
            new CollaborationTransfer(new StimulusImpl());
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#lostOwnership(Clipboard, Transferable)} method.
     * </p>
     * <p>
     * Checks whether Information is written to the log about the lost ownership.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_lostOwnership() throws Exception {
        collaborationTransfer.lostOwnership(Toolkit.getDefaultToolkit().getSystemClipboard(),
            new CollaborationTransfer(TestHelper.OBJECT));
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#lostOwnership(Clipboard, Transferable)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     Clipboard clipboard : null value
     *     Transferable transferable : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_lostOwnership() throws Exception {
        try {
            collaborationTransfer.lostOwnership(null, new CollaborationTransfer(TestHelper.OBJECT));
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in CollaborationTransfer#lostOwnership should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#lostOwnership(Clipboard, Transferable)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     Clipboard clipboard : Valid value
     *     Transferable transferable : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_lostOwnership1() throws Exception {
        try {
            collaborationTransfer.lostOwnership(Toolkit.getDefaultToolkit().getSystemClipboard(), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "transferable in CollaborationTransfer#lostOwnership should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)} method.
     * </p>
     * <p>
     * Checks if the object flavor is supported.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_isDataFlavorSupported() throws Exception {
        assertTrue("isDataFlavorSupported failed", collaborationTransfer
            .isDataFlavorSupported(CollaborationTransfer.OBJECT_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)} method.
     * </p>
     * <p>
     * Checks if the ASYNCHRONOUS_MESSAGE_FLAVOR is supported for a object flavor.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_isDataFlavorSupported1() throws Exception {
        assertFalse("isDataFlavorSupported failed", collaborationTransfer
            .isDataFlavorSupported(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)} method.
     * </p>
     * <p>
     * Checks if ASYNCHRONOUS_MESSAGE_FLAVOR is supported for asynchronous message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_isDataFlavorSupported2() throws Exception {
        assertTrue("isDataFlavorSupported failed", new CollaborationTransfer(TestHelper.getAsynchronousMessage())
            .isDataFlavorSupported(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)} method.
     * </p>
     * <p>
     * Checks if the CREATE_MESSAGE_FLAVOR is not supported for asynchronous message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_isDataFlavorSupported3() throws Exception {
        assertFalse("isDataFlavorSupported failed", new CollaborationTransfer(TestHelper.getAsynchronousMessage())
            .isDataFlavorSupported(CollaborationTransfer.CREATE_MESSAGE_FLAVOR));
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#isDataFlavorSupported(DataFlavor)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     DataFlavor dataFlavor : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_isDataFlavorSupported() throws Exception {
        try {
            collaborationTransfer.isDataFlavorSupported(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "dataFlavor in CollaborationTransfer#isDataFlavorSupported should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link CollaborationTransfer#getTransferData(DataFlavor)} method.
     * </p>
     * <p>
     * Checks if the correct element is returned back.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getTransferData() throws Exception {
        assertEquals("getTransferData failed", collaborationTransfer
            .getTransferData(CollaborationTransfer.OBJECT_FLAVOR), TestHelper.OBJECT);
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#getTransferData(DataFlavor)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     DataFlavor dataFlavor : Valid Value
     * </pre>
     *
     * <p>
     * If the flavor is not supported.
     * </p>
     * <p>
     * Expected {@link UnsupportedFlavorException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_getTransferData() throws Exception {
        try {
            collaborationTransfer.getTransferData(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            fail("UnsupportedFlavorException Expected.");
        } catch (UnsupportedFlavorException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Failure test for {@link CollaborationTransfer#getTransferData(DataFlavor)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *     DataFlavor dataFlavor : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_getTransferData1() throws Exception {
        try {
            collaborationTransfer.getTransferData(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "dataFlavor in CollaborationTransfer#getTransferData should not be null.");
        }
    }
}
