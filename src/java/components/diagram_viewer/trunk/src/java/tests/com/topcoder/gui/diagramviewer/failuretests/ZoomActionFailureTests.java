/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;


import java.util.Iterator;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.ZoomAction;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.gui.diagramviewer.ConfigurationException;

import junit.framework.TestCase;

/**
 * Failure tests for ZoomAction class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ZoomActionFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private DiagramViewer viewer;

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
     * Tests the constructor ZoomAction(String, DiagramViewer) with null namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullNamespace() throws Exception {
        try {
            new ZoomAction(null, viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomAction(String, DiagramViewer) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyNamespace1() throws Exception {
        try {
            new ZoomAction("", viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomAction(String, DiagramViewer) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyNamespace2() throws Exception {
        try {
            new ZoomAction(" \t \n ", viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomAction(String, DiagramViewer) with null viewer,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullViewer() throws Exception {
        try {
            new ZoomAction("com.topcoder.gui.diagramviewer.ZoomInAction", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomAction(String, DiagramViewer) with invalid configuration,
     * expected ConfigurationException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_InvalidConfiguration() throws Exception {
        try {
            new ZoomAction("invalid", viewer);
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }

    /**
     * Tests the constructor ZoomAction(String, DiagramViewer) with invalid "increment",
     * expected ConfigurationException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_InvalidIncrement() throws Exception {
        try {
            new ZoomAction("failuretests.ZoomAction.InvalidIncrement", viewer);
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }
}