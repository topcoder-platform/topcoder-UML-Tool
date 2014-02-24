/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;

import java.util.Iterator;

import com.topcoder.gui.diagramviewer.CloseTabAction;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.gui.diagramviewer.ConfigurationException;

import junit.framework.TestCase;

/**
 * Failure tests for CloseTabAction class.
 *
 * @author Yeung
 * @version 1.0
 */
public class CloseTabActionFailureTests extends TestCase {
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
     * Tests the constructor CloseTabAction(String, DiagramViewer) with null namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullNamespace() throws Exception {
        try {
            new CloseTabAction(null, viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor CloseTabAction(String, DiagramViewer) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyNamespace1() throws Exception {
        try {
            new CloseTabAction("", viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor CloseTabAction(String, DiagramViewer) with empty namespace,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_EmptyNamespace2() throws Exception {
        try {
            new CloseTabAction(" \t \n ", viewer);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor CloseTabAction(String, DiagramViewer) with null viewer,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullViewer() throws Exception {
        try {
            new CloseTabAction("com.topcoder.gui.diagramviewer.CloseTabAction", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor CloseTabAction(String, DiagramViewer) with invalid configuration,
     * expected ConfigurationException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_InvalidConfiguration() throws Exception {
        try {
            new CloseTabAction("invalid", viewer);
            fail("Expect ConfigurationException.");
        } catch (ConfigurationException ce) {
            // expect
        }
    }
}