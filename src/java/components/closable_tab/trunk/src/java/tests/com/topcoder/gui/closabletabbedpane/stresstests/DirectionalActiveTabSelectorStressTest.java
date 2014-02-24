/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import java.awt.TextArea;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for class <code>DirectionalActiveTabSelector</code>.
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class DirectionalActiveTabSelectorStressTest extends TestCase {

    /**
     * <p>
     * Represents the <code>DirectionalActiveTabSelector</code> instance in
     * the direction of increasing index for stress tests.
     * </p>
     */
    private DirectionalActiveTabSelector incSelector = new DirectionalActiveTabSelector(true);

    /**
     * <p>
     * Represents the <code>DirectionalActiveTabSelector</code> instance in
     * the direction of decreasing index for stress tests.
     * </p>
     */
    private DirectionalActiveTabSelector decSelector = new DirectionalActiveTabSelector(false);

    /**
     * <p>
     * Represents the <code>ClosableTabbedPane<code> instance for stress tests.
     * </p>
     */
    private ClosableTabbedPane tabbedPane = new ClosableTabbedPane();

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
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in for
     * stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testInstallSelectorStress() throws Exception  {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            incSelector.installSelector(tabbedPane);
        }

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
    public void testUninstallSelectorStress() throws Exception  {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            decSelector.uninstallSelector(tabbedPane);
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testUninstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in
     * increasing direction for stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStressInIncreasingDirection1() throws Exception  {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.setSelectedIndex(i);
            incSelector.selectNewActiveTab(tabbedPane);
            assertEquals("Method selectNewActiveTab should be incorrect.",
                    i + 1 == StressTestHelper.TIMES ? StressTestHelper.TIMES - 1 : i + 1, tabbedPane.getSelectedIndex());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStressInIncreasingDirection1() consumed time " + 1.0
                * (stop - start) / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in
     * increasing direction for stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStressInIncreasingDirection2() throws Exception  {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {

            int rnd = (int) (Math.random() * StressTestHelper.TIMES);

            tabbedPane.setSelectedIndex(rnd);
            incSelector.selectNewActiveTab(tabbedPane);
            assertEquals("Method selectNewActiveTab should be incorrect.",
                    rnd + 1 == StressTestHelper.TIMES ? StressTestHelper.TIMES - 1 : rnd + 1, tabbedPane
                            .getSelectedIndex());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStressInIncreasingDirection2() consumed time " + 1.0
                * (stop - start) / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in
     * decreasing direction for stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStressInDescreasingDirection1() throws Exception  {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.setSelectedIndex(i);
            decSelector.selectNewActiveTab(tabbedPane);
            assertEquals("Method selectNewActiveTab should be incorrect.", i == 0 ? 0 : i - 1, tabbedPane.getSelectedIndex());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStressInDescreasingDirection1() consumed time " + 1.0
                * (stop - start) / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link selectNewActiveTab(ClosableTabbedPane)} </code> in
     * decreasing direction for stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSelectNewActiveTabStressInDescreasingDirection2() throws Exception {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {

            int rnd = (int) (Math.random() * StressTestHelper.TIMES);
            tabbedPane.setSelectedIndex(rnd);

            decSelector.selectNewActiveTab(tabbedPane);
            assertEquals("Method selectNewActiveTab should be incorrect.", rnd == 0 ? 0 : rnd - 1, tabbedPane.getSelectedIndex());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testSelectNewActiveTabStressInDescreasingDirection2() consumed time " + 1.0
                * (stop - start) / StressTestHelper.TIMES + " ms");
    }
}
