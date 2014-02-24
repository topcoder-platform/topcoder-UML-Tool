/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.Serializable;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityObjectSelection.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityObjectSelectionTests extends TestCase {

    /**
     * <p>
     * The ActivityObjectSelection instance for testing.
     * </p>
     */
    private ActivityObjectSelection selection;

    /**
     * <p>
     * The Serializable instance for testing.
     * </p>
     */
    private Serializable obj;

    /**
     * <p>
     * The DataFlavor instance for testing.
     * </p>
     */
    private DataFlavor dataFlavor;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        obj = new ActionStateImpl();
        dataFlavor = new DataFlavor(ActionState.class, "ActionState");
        selection = new ActivityObjectSelection(obj, dataFlavor);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        selection = null;
        dataFlavor = null;
        obj = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityObjectSelectionTests.class);
    }

    /**
     * <p>
     * Tests ctor ActivityObjectSelection#ActivityObjectSelection(Serializable,DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ActivityObjectSelection instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ActivityObjectSelection instance.", selection);
    }

    /**
     * <p>
     * Tests ctor ActivityObjectSelection#ActivityObjectSelection(Serializable,DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when obj is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullObj() {
        try {
            new ActivityObjectSelection(null, dataFlavor);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActivityObjectSelection#ActivityObjectSelection(Serializable,DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dataFlavor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullDataFlavor() {
        try {
            new ActivityObjectSelection(obj, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#getTransferData(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : GetTransferData is executed correctly, and return the correct value.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData() throws Exception {

        assertEquals("Failed to return the correct value.", obj, selection.getTransferData(dataFlavor));
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#getTransferData(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when flavor is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData_NullFlavor() throws Exception {
        try {
            selection.getTransferData(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#getTransferData(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the dateFlavor is not correct type and
     * expects UnsupportedFlavorException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData_UnsupportedFlavorException() throws Exception {
        dataFlavor = new DataFlavor(SimpleState.class, "SendSignalAction");
        try {
            selection.getTransferData(dataFlavor);
            fail("UnsupportedFlavorException expected.");
        } catch (UnsupportedFlavorException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#getTransferDataFlavors() for accuracy.
     * </p>
     *
     * <p>
     * Verify : GetTransferDataFlavors is executed correctly, and return the correct value.
     * </p>
     */
    public void testGetTransferDataFlavors() {
        assertEquals("Failed to return the correct value.", dataFlavor, selection.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#isDataFlavorSupported(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The passed dataFlavor is supported and expect return true.
     * </p>
     */
    public void testIsDataFlavorSupported_True() {
        assertTrue("Failed to return the correct value.", selection.isDataFlavorSupported(dataFlavor));
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#isDataFlavorSupported(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The passed dataFlavor is not supported and expect return false.
     * </p>
     */
    public void testIsDataFlavorSupported_False() {
        dataFlavor = new DataFlavor(SimpleState.class, "SendSignalAction");
        assertFalse("Failed to return the correct value.", selection.isDataFlavorSupported(dataFlavor));
    }

    /**
     * <p>
     * Tests ActivityObjectSelection#isDataFlavorSupported(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when flavor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testIsDataFlavorSupported_NullFlavor() {
        try {
            selection.isDataFlavorSupported(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}