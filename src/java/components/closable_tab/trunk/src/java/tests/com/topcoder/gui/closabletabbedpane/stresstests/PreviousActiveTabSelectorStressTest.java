/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import java.awt.TextArea;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;
import com.topcoder.gui.closabletabbedpane.MockClosableTabbedPaneForStress;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for class <code>PreviousActiveTabSelector</code>.
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class PreviousActiveTabSelectorStressTest extends TestCase {

    /**
     * <p>
     * Represents the <code>ClosableTabbedPane<code> instance for stress tests.
     * </p>
     */
    private MockClosableTabbedPaneForStress tabbedPane = new MockClosableTabbedPaneForStress();

    /**
     * <p>
     * Represents the <code>PreviousActiveTabSelector</code> instance for
     * stress tests.
     * </p>
     */
    private PreviousActiveTabSelector preSelector = new PreviousActiveTabSelector();

    /**
     * <p>
     * Constructs the stress tests environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.insertTab(String.valueOf(i), null, new TextArea(), null, i);
        }

        preSelector.installSelector(tabbedPane);
    }

    /**
     * <p>
     * Tear down environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Test method {@link installSelector(ClosableTabbedPane)} </code> in for
     * stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallSelectorStress() throws Exception {
        long start = System.currentTimeMillis();

        preSelector = new PreviousActiveTabSelector(StressTestHelper.TIMES);
        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            ClosableTabbedPane pane = new ClosableTabbedPane();

            pane.insertTab(String.valueOf(i), null, new TextArea(), null, 0);
            pane.setSelectedIndex(0);

            preSelector.installSelector(pane);
        }

        assertEquals("Method installSelector should be incorrect.", StressTestHelper.TIMES, preSelector
                .getMaximumHistoryLength());

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testInstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link uninstallSelector(ClosableTabbedPane)} </code> in for
     * stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUninstallSelectorStress() throws Exception {
        preSelector = new PreviousActiveTabSelector(StressTestHelper.TIMES);

        ClosableTabbedPane[] panes = new ClosableTabbedPane[StressTestHelper.TIMES];
        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            panes[i] = new ClosableTabbedPane();

            panes[i].insertTab(String.valueOf(i), null, new TextArea(), null, 0);
            panes[i].setSelectedIndex(0);

            preSelector.installSelector(panes[i]);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            preSelector.installSelector(panes[i]);
        }

        assertEquals("Method installSelector should be incorrect.", StressTestHelper.TIMES, preSelector
                .getMaximumHistoryLength());

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testInstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in for
     * stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStress1() throws Exception {
        long start = System.currentTimeMillis();

        tabbedPane.setSelectedIndex(-1);
        preSelector.installSelector(tabbedPane);

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.setSelectedIndex(i);
        }

        for (int i = 0; i < StressTestHelper.TIMES - 1; ++i) {
            preSelector.selectNewActiveTab(tabbedPane);

            assertEquals("Method selectNewActiveTab should be incorrect.", StressTestHelper.TIMES - i - 2, tabbedPane
                    .getSelectedIndex());

            ClosableTabbedPaneEvent event = new ClosableTabbedPaneEvent(StressTestHelper.TIMES - i - 1, tabbedPane);
            ClosableTabbedPaneEvent[] events = new ClosableTabbedPaneEvent[] {event};

            tabbedPane.fireTabsClosedEvent(events);
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStress1() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in for
     * stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStress2() throws Exception {
        long start = System.currentTimeMillis();

        tabbedPane.setSelectedIndex(-1);
        preSelector.installSelector(tabbedPane);

        for (int i = StressTestHelper.TIMES - 1; i >= 0; --i) {
            tabbedPane.setSelectedIndex(i);
        }

        for (int i = 0; i < StressTestHelper.TIMES - 1; ++i) {
            preSelector.selectNewActiveTab(tabbedPane);
            assertEquals("Method selectNewActiveTab should be incorrect.", 1, tabbedPane.getSelectedIndex());

            ClosableTabbedPaneEvent event = new ClosableTabbedPaneEvent(0, tabbedPane);
            ClosableTabbedPaneEvent[] events = new ClosableTabbedPaneEvent[] {event};

            tabbedPane.fireTabsClosedEvent(events);
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStress2() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }
}
