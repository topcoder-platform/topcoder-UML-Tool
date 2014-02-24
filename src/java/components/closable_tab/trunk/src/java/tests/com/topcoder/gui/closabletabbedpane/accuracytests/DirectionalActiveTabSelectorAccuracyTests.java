/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.accuracytests;

import java.awt.*;

import javax.swing.JTextArea;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;

import junit.framework.TestCase;

/**
 * Accuracy tests for class DirectionalActiveTabSelector.
 *
 * @author knuthocean
 * @version 1.0
 */
public class DirectionalActiveTabSelectorAccuracyTests extends TestCase {

    /** DirectionalActiveTabSelector instance for acc tests */
    private DirectionalActiveTabSelector selector;

    /** The ClosableTabbedPane instance for acc testing. */
    private ClosableTabbedPane pane;

    /**
     * Sets up accuracy tests.
     *
     * @throws Exception
     *             to JUnit
     */
    public void setUp() throws Exception {
        selector = new DirectionalActiveTabSelector(true);
        pane = new ClosableTabbedPane();
        // add components
        pane.add("acc-A", new JTextArea());
        pane.add("acc-B", new JTextArea());
        pane.add("acc-C", new JTextArea());
        pane.add("acc-D", new JTextArea());
        pane.add("acc-E", new JTextArea());

        // add button image.
        pane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/accuracytests/acc1.gif"));
        pane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/accuracytests/acc2.gif"));
        pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/accuracytests/acc3.gif"));
        pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/accuracytests/acc4.gif"));

        pane.setCloseButtonPadding(new Dimension(0,5));
    }

    /**
     * <p>
     * Tears down accuracy tests.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void tearDown() throws Exception {
        pane = null;
        selector = null;

    }

    /**
     * Accuracy test for ctor: DirectionalActiveTabSelector(boolean).
     */
    public void testAccuracyCtor() {
        assertNotNull("fail to create DirectionalActiveTabSelector.", selector);
        assertTrue("fail to create DirectionalActiveTabSelector.", selector.isIncreasingIndexDirection());

        assertNotNull("fail to create DirectionalActiveTabSelector.",
                selector = new DirectionalActiveTabSelector(false));
        assertFalse("fail to create DirectionalActiveTabSelector.", selector.isIncreasingIndexDirection());
    }

    /**
     * Accuracy tests for methods: selectNewActiveTab(ClosableTabbedPane) -- 1.
     */
    public void testAccuracySelectNewActiveTab1() {
        pane.setSelectedIndex(3);
        selector = new DirectionalActiveTabSelector(true);

        selector.selectNewActiveTab(pane);

        assertEquals("fail to set new active tab.", 4, pane.getSelectedIndex());

    }

    /**
     * Accuracy tests for methods: selectNewActiveTab(ClosableTabbedPane) -- 2.
     */
    public void testAccuracySelectNewActiveTab2() {
        pane.setSelectedIndex(3);
        selector = new DirectionalActiveTabSelector(false);

        selector.selectNewActiveTab(pane);

        assertEquals("fail to set new active tab.", 2, pane.getSelectedIndex());

    }

    /**
     * Accuracy tests for methods: selectNewActiveTab(ClosableTabbedPane) -- 1.
     */
    public void testAccuracySelectNewActiveTab3() {
        pane.setSelectedIndex(-1);
        selector = new DirectionalActiveTabSelector(true);
        selector.selectNewActiveTab(pane);

        assertEquals("fail to set new active tab.", -1, pane.getSelectedIndex());

    }
}
