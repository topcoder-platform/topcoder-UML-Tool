/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;


import java.util.Iterator;

import javax.swing.JTextField;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.ZoomTextFieldAction;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure tests for ZoomTextFieldAction class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ZoomTextFieldActionFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private DiagramViewer viewer;

    /**
     * This instance is used in the test.
     */
    private ZoomTextFieldAction action;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
		tearDown();
        // get the config manager
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("failure/config.xml");

        viewer = new DiagramViewer();
        action = new ZoomTextFieldAction(viewer, new JTextField());
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception
     *             if any error occurred when tear down
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Tests the constructor ZoomTextFieldAction(DiagramViewer, JTextField) with null viewer,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullViewer() throws Exception {
        try {
            new ZoomTextFieldAction(null, new JTextField());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomTextFieldAction(DiagramViewer, JTextField) with null textField,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullTextField() throws Exception {
        try {
            new ZoomTextFieldAction(viewer, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method updateZoomFactorText(int) with zero newFactor,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testUpdateZoomFactorText_ZeroNewFactor() throws Exception {
        try {
            action.updateZoomFactorText(0.0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method updateZoomFactorText(int) with negative newFactor,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testUpdateZoomFactorText_NegativeNewFactor() throws Exception {
        try {
            action.updateZoomFactorText(-1.0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}