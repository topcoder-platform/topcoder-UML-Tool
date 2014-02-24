/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityObjectCloneException;
import com.topcoder.uml.actions.model.activity.ActivityObjectSelection;

/**
 * <p>
 * Failure test for <code>ActivityObjectSelection</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ActivityObjectSelectionFailureTest extends TestCase {
    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
    }

    /**
     * <p>
     * Clear the namespace.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }
    /**
     * <p>
     * Failure test for
     * <code>ActivityObjectSelection(Serializable obj, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * obj is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testActivityObjectSelectionNullObj() {
        try {
            new ActivityObjectSelection(null, new DataFlavor());
            fail("obj is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>ActivityObjectSelection(Serializable obj, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testActivityObjectSelectionNullDataFlavor() {
        try {
            new ActivityObjectSelection(new ActivityObjectCloneException("msg"), null);
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>isDataFlavorSupported(DataFlavor flavor)</code>.
     * </p>
     * <p>
     * flavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testIsDataFlavorSupported() {
        try {
            new ActivityObjectSelection(new ActivityObjectCloneException("msg"), new DataFlavor())
                    .isDataFlavorSupported(null);
            fail("flavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>getTransferData(DataFlavor flavor)</code>.
     * </p>
     * <p>
     * flavor is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws IOException to JUnit
     * @throws UnsupportedFlavorException to JUnit
     */
    public void testGetTransferDataNullDataFlavor() throws UnsupportedFlavorException, IOException {
        try {
            new ActivityObjectSelection(new ActivityObjectCloneException("msg"), new DataFlavor())
                    .getTransferData(null);
            fail("flavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
