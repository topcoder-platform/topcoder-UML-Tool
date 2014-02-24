/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;

/**
 * Failure test for <c>DirectionalActiveTabSelector</c> class.
 *
 * @author liulike
 * @version 1.0
 *
 */
public class DirectionalActiveTabSelectorFailureTests extends TestCase {

    /**
     * The <c>DirectionalActiveTabSelector</c> instance for test.
     */
    private DirectionalActiveTabSelector instance;

    /**
     * Set up test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        instance = new DirectionalActiveTabSelector(false);
    }

    /**
     * Tear down test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for
     * DirectionalActiveTabSelector#installSelector(ClosableTabbedPane). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testInstallSelector() {
        try {
            instance.installSelector(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * DirectionalActiveTabSelector#uninstallSelector(ClosableTabbedPane). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testUninstallSelector() {
        try {
            instance.uninstallSelector(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * DirectionalActiveTabSelector#selectNewActiveTab(ClosableTabbedPane). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testSelectNewActiveTab() {
        try {
            instance.selectNewActiveTab(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
