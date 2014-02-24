/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.TextArea;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;

/**
 * <p>
 * UnitTest for DirectionalActiveTabSelector class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DirectionalActiveTabSelectorUnitTest extends TestCase {
    /** Prepare a ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** Prepare a default selector for testing. */
    private DirectionalActiveTabSelector selector = new DirectionalActiveTabSelector(true);

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DirectionalActiveTabSelectorUnitTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        // Insert four tabs in order
        pane.insertTab("title1", null, new TextArea(), null, 0);
        pane.insertTab("title2", null, new TextArea(), null, 1);
        pane.insertTab("title3", null, new TextArea(), null, 2);
        pane.insertTab("title4", null, new TextArea(), null, 3);
    }

    /**
     * <p>
     * Accuracy test of <code>DirectionalActiveTabSelector(boolean increasingIndexDirection)</code> constructor.
     * </p>
     * <p>
     * Simply check if the inner value is true.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDirectionalActiveTabSelectorAccuracy1() throws Exception {
        assertTrue("DirectionalActiveTabSelector incorrect", new DirectionalActiveTabSelector(true)
            .isIncreasingIndexDirection());
    }

    /**
     * <p>
     * Accuracy test of <code>DirectionalActiveTabSelector(boolean increasingIndexDirection)</code> constructor.
     * </p>
     * <p>
     * Simply check if the inner value is false.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDirectionalActiveTabSelectorAccuracy2() throws Exception {
        assertFalse("DirectionalActiveTabSelector incorrect", new DirectionalActiveTabSelector(false)
            .isIncreasingIndexDirection());
    }

    /**
     * <p>
     * Accuracy test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Call it several times, nothing should happen.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorAccuracy() throws Exception {
        selector.installSelector(pane);
        selector.installSelector(pane);
    }

    /**
     * <p>
     * Failure test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Install null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorFailure() throws Exception {
        try {
            selector.installSelector(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Uninstall several times, nothing should happen.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy() throws Exception {
        selector.uninstallSelector(pane);
        selector.uninstallSelector(pane);
    }

    /**
     * <p>
     * Failure test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Call with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorFailure() throws Exception {
        try {
            selector.uninstallSelector(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When 0 is selected. Four tabs exist. Increase order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy1() throws Exception {
        pane.setSelectedIndex(0);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When 3 is selected. Four tabs exist. Increase order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy2() throws Exception {
        pane.setSelectedIndex(3);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 3, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When -1 is selected. Four tabs exist. Increase order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy3() throws Exception {
        pane.setSelectedIndex(-1);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", -1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When 0 is selected. Four tabs exist. Decrease order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy4() throws Exception {
        selector = DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR;
        pane.setSelectedIndex(0);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When 3 is selected. Four tabs exist. Decrease order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy5() throws Exception {
        selector = DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR;
        pane.setSelectedIndex(3);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 2, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * When -1 is selected. Four tabs exist. Decrease order.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy6() throws Exception {
        selector = DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR;
        pane.setSelectedIndex(-1);
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", -1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Failure test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Call with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabFailure() throws Exception {
        try {
            selector.selectNewActiveTab(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>isIncreasingIndexDirection()</code> method.
     * </p>
     * <p>
     * Simply check if INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR has true return value.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsIncreasingIndexDirectionAccuracy1() throws Exception {
        assertTrue("isIncreasingIndexDirection incorrect",
            DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR
                .isIncreasingIndexDirection());
    }

    /**
     * <p>
     * Accuracy test of <code>isIncreasingIndexDirection()</code> method.
     * </p>
     * <p>
     * Simply check if DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR has true return value.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsIncreasingIndexDirectionAccuracy2() throws Exception {
        assertFalse("isIncreasingIndexDirection incorrect",
            DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR
                .isIncreasingIndexDirection());
    }
}
