/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.datatransfer.DataFlavor;
import java.io.Serializable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.ActivityObjectSelection;

/**
 * This class aggregates accuracy tests for ActivityObjectSelection class.
 *
 * @author ch_music
 * @version 1.0
 */
public class ActivityObjectSelectionAccuracyTests extends TestCase {

    /**
     * Placeholder for ActivityObjectSelection.
     */
    private ActivityObjectSelection test = new ActivityObjectSelection(new TestClass(),
            ActivityDataFlavor.INITIAL_NODE);

    /**
     * Tests constructor. No exception is expected.
     *
     * @throws Exception to JUnit
     */
    public void testActivityObjectSelection() throws Exception {
        assertNotNull("Constructor fails to create object.", test);
        assertTrue("Constructor creates object wrongly.", test
                .isDataFlavorSupported(ActivityDataFlavor.INITIAL_NODE));
        assertEquals("Constructor creates object wrongly.", TestClass.class, test.getTransferData(
                ActivityDataFlavor.INITIAL_NODE).getClass());
    }

    /**
     * Tests getTransferDataFlavors method. No exception is expected.
     */
    public void testGetTransferDataFlavors() {
        DataFlavor[] df = test.getTransferDataFlavors();
        assertEquals("getTransferDataFlavors returns wrongly.", 1, df.length);
        assertEquals("getTransferDataFlavors returns wrongly.", ActivityDataFlavor.INITIAL_NODE, df[0]);
    }

    /**
     * Tests isDataFlavorSupported method. No exception is expected.
     */
    public void testIsDataFlavorSupported1() {
        assertTrue("isDataFlavorSupported returns false when true is expected.", test
                .isDataFlavorSupported(ActivityDataFlavor.INITIAL_NODE));
    }

    /**
     * Tests isDataFlavorSupported method. No exception is expected.
     */
    public void testIsDataFlavorSupported2() {
        assertFalse("isDataFlavorSupported returns true false when false is expected.", test
                .isDataFlavorSupported(ActivityDataFlavor.ACCEPT_EVENT_ACTION));
    }

    /**
     * Tests getTransferData method. No exception is expected.
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData() throws Exception {
        assertEquals("getTransferData returns wrong data.", TestClass.class, test.getTransferData(
                ActivityDataFlavor.INITIAL_NODE).getClass());
    }

    /**
     * An inner class used as an argument for ActivityObjectSelection constructor.
     *
     * @author ch_music
     * @version 1.0
     */
    private class TestClass implements Serializable {

        /**
         * Constructs a new TestClass.
         */
        public TestClass() {
        }
    }
}
