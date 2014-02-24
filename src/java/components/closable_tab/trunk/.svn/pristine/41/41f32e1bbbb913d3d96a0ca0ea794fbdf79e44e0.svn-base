/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

/**
 * Failure test for <c>PreviousActiveTabSelector</c> class.
 *
 * @author liulike
 * @version 1.0
 *
 */
public class PreviousActiveTabSelectorFailureTests extends TestCase {

    /**
     * The <c>PreviousActiveTabSelector</c> instance for test.
     */
    private PreviousActiveTabSelector instance;

    /**
     * Set up test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        instance = new PreviousActiveTabSelector();
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
     * PreviousActiveTabSelector#installSelector(ClosableTabbedPane). It tests
     * the case that argument is null, and IllegalArgumentException is expected.
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
     * PreviousActiveTabSelector#uninstallSelector(ClosableTabbedPane). It tests
     * the case that argument is null, and IllegalArgumentException is expected.
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
     * PreviousActiveTabSelector#selectNewActiveTab(ClosableTabbedPane). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testSelectNewActiveTab1() {
        try {
            instance.selectNewActiveTab(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * PreviousActiveTabSelector#selectNewActiveTab(ClosableTabbedPane). It
     * tests the case that if the selector has not been installed on the pane,
     * and IllegalStateException is expected.
     */
    public void testSelectNewActiveTab2() {
        try {
            instance.selectNewActiveTab(new ClosableTabbedPane());
            fail("IllegalStateException is expected");
        } catch (IllegalStateException iae) {
            // good
        }
    }

}
