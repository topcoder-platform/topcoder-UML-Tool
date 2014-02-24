/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import java.awt.TextArea;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import com.topcoder.gui.closabletabbedpane.MockClosableTabbedPaneEventHandlerForStress;
import com.topcoder.gui.closabletabbedpane.MockClosableTabbedPaneForStress;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for class <code>ClosableTabbedPane</code>.
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class ClosableTabbedPaneUnitTest extends TestCase {

    /**
     * <p>
     * Represents the <code>ClosableTabbedPane</code> instance for stress
     * tests.
     * </p>
     */
    private MockClosableTabbedPaneForStress tabbedPane;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        StressTestHelper.LoadConfig();
        tabbedPane = new MockClosableTabbedPaneForStress();
    }

    /**
     * <p>
     * Tear down environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        StressTestHelper.ClearConfig();
        tabbedPane = null;
    }

    /**
     * <p>
     * Test method
     * {@link addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler)}
     * in for stress testing.
     * </p>
     */
    public void testAddClosableTabbedPaneEventHandlerStress() throws Exception {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            MockClosableTabbedPaneEventHandlerForStress eventHandler = new MockClosableTabbedPaneEventHandlerForStress();

            tabbedPane.addClosableTabbedPaneEventHandler(eventHandler);
        }

        assertEquals("Method addClosableTabbedPaneEventHandler should be incorrect", StressTestHelper.TIMES, tabbedPane
                .getClosableTabbedPaneEventHandlers().length);

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testInstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method
     * {@link removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler)}
     * in for stress testing.
     * </p>
     */
    public void testRemoveClosableTabbedPaneEventHandlerStress() throws Exception {

        MockClosableTabbedPaneEventHandlerForStress[] eventHandlers = new MockClosableTabbedPaneEventHandlerForStress[StressTestHelper.TIMES];

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            eventHandlers[i] = new MockClosableTabbedPaneEventHandlerForStress();

            tabbedPane.addClosableTabbedPaneEventHandler(eventHandlers[i]);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.removeClosableTabbedPaneEventHandler(eventHandlers[i]);

            assertEquals("Method removeClosableTabbedPaneEventHandler should be incorrect", StressTestHelper.TIMES - i
                    - 1, tabbedPane.getClosableTabbedPaneEventHandlers().length);
        }

        assertEquals("Method addClosableTabbedPaneEventHandler should be incorrect", 0, tabbedPane
                .getClosableTabbedPaneEventHandlers().length);

        // Nothing should.
        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.removeClosableTabbedPaneEventHandler(eventHandlers[i]);

            assertEquals("Method removeClosableTabbedPaneEventHandler should be incorrect", 0, tabbedPane
                    .getClosableTabbedPaneEventHandlers().length);
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testInstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link insertTab(String, Icon, Component, String, int)} in
     * for stress testing.
     * </p>
     */
    public void testInsertTabStress() throws Exception {
        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            JComponent component = new JTextArea();

            tabbedPane.insertTab("stresstest" + String.valueOf(i), null, component, null, 0);

            assertEquals("Method insertTab should be incorrect", i + 1, tabbedPane.getTabCount());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testInstallSelectorStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link removeTabAt(int)} in for stress testing.
     * </p>
     */
    public void testRemoveTabAtStress() throws Exception {
        // Prepare for tabs to be removed for stress tests.
        for (int i = 0; i < StressTestHelper.TIMES; ++i) {
            tabbedPane.insertTab(String.valueOf(i), null, new TextArea(), null, i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.TIMES - 1; ++i) {
            tabbedPane.setSelectedIndex(StressTestHelper.TIMES - i - 1);
            tabbedPane.remove(0);

            assertEquals("Method removeTabAt should be incorrect", StressTestHelper.TIMES - i - 2, tabbedPane
                    .getSelectedIndex());
        }

        long stop = System.currentTimeMillis();

        // display benchmark
        System.out.println("Method testRemoveTabAtStress() consumed time " + 1.0 * (stop - start)
                / StressTestHelper.TIMES + " ms");
    }

    /**
     * <p>
     * Test method {@link processMouseEvent(MouseEvent)} in for stress testing.
     * </p>
     * <p>
     * Method {@link processMouseEvent(MouseEvent)} won't be tested here because
     * the functional stress tests will cover these functions. Please refer to
     * test class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testProcessMouseEventStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

    /**
     * <p>
     * Test method {@link processMouseMotionEvent(MouseEvent)} in for stress
     * testing.
     * </p>
     * <p>
     * Method {@link processMouseMotionEvent(MouseEvent)} won't be tested here
     * because the functional stress tests will cover these functions. Please
     * refer to test class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testProcessMouseMotionEventStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

    /**
     * <p>
     * Test method {@link paintComponent(Graphics)} in for stress testing.
     * </p>
     * <p>
     * Method {@link paintComponent(Graphics)} won't be tested here because the
     * functional stress tests will cover these functions. Please refer to test
     * class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testPaintComponentStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

    /**
     * <p>
     * Test method {@link fireTabAddedEvent(ClosableTabbedPaneEvent)} in for
     * stress testing.
     * </p>
     * <p>
     * Method {@link fireTabAddedEvent(ClosableTabbedPaneEvent)} won't be tested
     * here because the functional stress tests will cover these functions.
     * Please refer to test class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testFireTabAddedEventStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

    /**
     * <p>
     * Test method {@link fireTabsClosedEvent(ClosableTabbedPaneEvent[])} in for
     * stress testing.
     * </p>
     * <p>
     * Method {@link fireTabsClosedEvent(ClosableTabbedPaneEvent[])} won't be
     * tested here because the functional stress tests will cover these
     * functions. Please refer to test class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testFireTabsClosedEventStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

    /**
     * <p>
     * Test method {@link fireTabsClosingEvent(ClosableTabbedPaneEvent[])} in
     * for stress testing.
     * </p>
     * <p>
     * Method {@link fireTabsClosingEvent(ClosableTabbedPaneEvent[])} won't be
     * tested here because the functional stress tests will cover these
     * functions. Please refer to test class <code>FunctionalStressTest</code>.
     * </p>
     * <p>
     * This test is empty and nothing will be done.
     * </p>
     */
    public void testFireTabsClosingEventStress() throws Exception {
        // @TODO
        // the relative stress tests will be implemented in functional stress
        // test.
    }

}
