/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.TextArea;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

/**
 * <p>
 * UnitTest for PreviousActiveTabSelector class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PreviousActiveTabSelectorUnitTest extends TestCase {
    /** Prepare a ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** Prepare a default selector for testing. */
    private PreviousActiveTabSelector selector = new PreviousActiveTabSelector();

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(PreviousActiveTabSelectorUnitTest.class);
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
     * Accuracy test of <code>PreviousActiveTabSelector()</code> constructor.
     * </p>
     * <p>
     * Simply check if the default length is 0.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPreviousActiveTabSelector1Accuracy() throws Exception {
        assertEquals("PreviousActiveTabSelector default value incorrect", 0, selector.getMaximumHistoryLength());
    }

    /**
     * <p>
     * Accuracy test of <code>PreviousActiveTabSelector(int maximumHistoryLength)</code> constructor.
     * </p>
     * <p>
     * Set some length and check if retrieved properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPreviousActiveTabSelector2Accuracy1() throws Exception {
        assertEquals("PreviousActiveTabSelector default value incorrect", 2, new PreviousActiveTabSelector(2)
            .getMaximumHistoryLength());
    }

    /**
     * <p>
     * Accuracy test of <code>PreviousActiveTabSelector(int maximumHistoryLength)</code> constructor.
     * </p>
     * <p>
     * Set some length and check if retrieved properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPreviousActiveTabSelector2Accuracy2() throws Exception {
        assertEquals("PreviousActiveTabSelector default value incorrect", -2, new PreviousActiveTabSelector(-2)
            .getMaximumHistoryLength());
    }

    /**
     * <p>
     * Accuracy test of <code>PreviousActiveTabSelector(int maximumHistoryLength)</code> constructor.
     * </p>
     * <p>
     * Set some length and check if retrieved properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPreviousActiveTabSelector2Accuracy3() throws Exception {
        assertEquals("PreviousActiveTabSelector default value incorrect", 0, new PreviousActiveTabSelector(0)
            .getMaximumHistoryLength());
    }

    /**
     * <p>
     * Accuracy test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * This method will simply test if different kinds of panes will result in error. The detailed function will be
     * tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorAccuracy1() throws Exception {
        pane.setSelectedIndex(-1);
        selector.installSelector(pane);
    }

    /**
     * <p>
     * Accuracy test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * This method will simply test if different kinds of panes will result in error. The detailed function will be
     * tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorAccuracy2() throws Exception {
        pane.setSelectedIndex(2);
        selector.installSelector(pane);
    }

    /**
     * <p>
     * Accuracy test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * This method will simply test if different kinds of panes will result in error. The detailed function will be
     * tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorAccuracy3() throws Exception {
        pane.removeAll();
        selector.installSelector(pane);
    }

    /**
     * <p>
     * Accuracy test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Install twice. tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInstallSelectorAccuracy4() throws Exception {
        pane.setSelectedIndex(1);
        selector.installSelector(pane);
        selector.installSelector(pane);
    }

    /**
     * <p>
     * Failure test of <code>installSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Call it with null.
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
     * Simply uninstall and check if the new calling of select will result in ISE. Different kinds of panes will be
     * tested.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy1() throws Exception {
        pane.setSelectedIndex(-1);
        selector.installSelector(pane);
        selector.uninstallSelector(pane);
        // Check if successfully uninstalled
        try {
            selector.selectNewActiveTab(pane);
        } catch (IllegalStateException e) {
            // Expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Simply uninstall and check if the new calling of select will result in ISE. Different kinds of panes will be
     * tested.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy2() throws Exception {
        pane.setSelectedIndex(3);
        selector.installSelector(pane);
        selector.uninstallSelector(pane);
        // Check if successfully uninstalled
        try {
            selector.selectNewActiveTab(pane);
        } catch (IllegalStateException e) {
            // Expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Simply uninstall and check if the new calling of select will result in ISE. Different kinds of panes will be
     * tested.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy3() throws Exception {
        pane.removeAll();
        selector.installSelector(pane);
        selector.uninstallSelector(pane);
        // Check if successfully uninstalled
        try {
            selector.selectNewActiveTab(pane);
        } catch (IllegalStateException e) {
            // Expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Check uninstall twice.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy4() throws Exception {
        pane.removeAll();
        selector.installSelector(pane);
        selector.uninstallSelector(pane);
        selector.uninstallSelector(pane);
    }

    /**
     * <p>
     * Accuracy test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Check uninstall without install.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUninstallSelectorAccuracy5() throws Exception {
        selector.uninstallSelector(pane);
    }

    /**
     * <p>
     * Failure test of <code>uninstallSelector(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test with null.
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
     * Test without history.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy1() throws Exception {
        // Prepare the selector
        pane.setSelectedIndex(-1);
        selector.installSelector(pane);

        // Select it
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", -1, pane.getSelectedIndex());

        // Select it again
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", -1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test with complex history.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy2() throws Exception {
        // Prepare the selector
        pane.setSelectedIndex(-1);
        // install twice
        selector.installSelector(pane);
        selector.installSelector(pane);

        // Prepare a history
        pane.setSelectedIndex(0);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(2);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(3);

        // Select it many times
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(3, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 2, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(0, pane)});
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test after a new installation.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy3() throws Exception {
        // Prepare the selector
        pane.setSelectedIndex(-1);
        selector.installSelector(pane);

        // Prepare a history
        pane.setSelectedIndex(0);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(2);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(3);

        selector.uninstallSelector(pane);

        // Re-prepare the pane
        pane.setSelectedIndex(-1);
        selector.installSelector(pane);

        // Select it
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", -1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test when more than one panes exist.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy4() throws Exception {
        // Prepare an old selector
        ClosableTabbedPane pane1 = new ClosableTabbedPane();
        pane1.insertTab("title-1", null, new TextArea(), null, 0);
        pane1.insertTab("title-2", null, new TextArea(), null, 0);
        pane1.setSelectedIndex(0);
        selector.installSelector(pane1);
        pane1.setSelectedIndex(1);

        // Prepare the selector
        pane.setSelectedIndex(-1);
        // install twice
        selector.installSelector(pane);
        selector.installSelector(pane);

        // Prepare a history
        pane.setSelectedIndex(0);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(2);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(3);

        // Select it many times
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(3, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 2, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(0, pane)});
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test with a bound on number of history.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy5() throws Exception {
        // Prepare the selector
        pane.setSelectedIndex(-1);

        // Prepare a history max length
        selector = new PreviousActiveTabSelector(2);
        selector.installSelector(pane);

        // Prepare a history
        pane.setSelectedIndex(0);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(2);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(3);

        // Select it many times
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(3, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});
    }

    /**
     * <p>
     * Accuracy test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test with a negative bound on history.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabAccuracy6() throws Exception {
        // Prepare the selector
        pane.setSelectedIndex(-1);
        // install the negative selector
        selector = new PreviousActiveTabSelector(-3);
        selector.installSelector(pane);

        // Prepare a history
        pane.setSelectedIndex(0);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(2);
        pane.setSelectedIndex(1);
        pane.setSelectedIndex(3);

        // Select it many times
        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 1, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(3, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 2, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(1, pane)});

        selector.selectNewActiveTab(pane);
        assertEquals("selectNewActiveTab incorrect", 0, pane.getSelectedIndex());
        pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(0, pane)});
    }

    /**
     * <p>
     * Failure test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test when not installed yet.
     * </p>
     * <p>
     * Expect IllegalStateException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabFailure1() throws Exception {
        try {
            selector.selectNewActiveTab(pane);
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>selectNewActiveTab(ClosableTabbedPane tabbedPane)</code> method.
     * </p>
     * <p>
     * Test with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSelectNewActiveTabFailure2() throws Exception {
        try {
            selector.selectNewActiveTab(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
