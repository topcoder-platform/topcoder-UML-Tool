/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.JTabbedPaneMouseEventData;
import junit.extensions.jfcunit.eventdata.MouseEventData;

/**
 * <p>
 * Functional stress test for for the whole submission, especially for class
 * <code>ClosableTabbedPane</code>, <code>DirectionalActiveTabSelector</code>
 * and <code>PreviousActiveTabSelecton</code>
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class FunctionalStressTest extends JFCTestCase {

    /**
     * <p>
     * Represents running number for stress testing in class
     * <code>FunctionalStressTest</code>.
     * </p>
     */
    private static final int RUN_TIME = 50;

    /**
     * <p>
     * Represents an instance of <code>ClosableTabbedPane</code> for stress
     * testing.
     * </p>
     */
    private ClosableTabbedPane tabbedPane = new ClosableTabbedPane();

    /**
     * <p>
     * Represents class <code>PreviousActiveTabSelector</code> instance for
     * stress testing.
     * </p>
     */
    private PreviousActiveTabSelector selector;

    /**
     * <p>
     * Represents an instance of <code>TestHelper</code> for stress testing.
     * </p>
     */
    private TestHelper helper = null;

    /**
     * <p>
     * Sets up environment for stress testing.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {

        selector = new PreviousActiveTabSelector();

        for (int i = 0; i < RUN_TIME; ++i) {
            tabbedPane.insertTab("stress_" + String.valueOf(i), null, new JTextArea(), null, i);
        }

        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/stresstests/closeActiveHovered.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
                .createImage("test_files/stresstests/closeActiveNotHovered.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
                "test_files/stresstests/closeInactiveHovered.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
                .createImage("test_files/stresstests/closeInactiveNotHovered.gif"));

        tabbedPane.setCloseButtonPadding(new Dimension(0,5));

        helper = new JFCTestHelper();
    }

    /**
     * <p>
     * Tears down accuracy tests.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void tearDown() throws Exception {
        tabbedPane = null;
        selector = null;
        helper = null;
    }

    /**
     * <p>
     * A private helper method to get the button's display rectangle for a given
     * index. This method will check the button's image size also.
     * </p>
     *
     * @param tabIndex the tab index to retrieve its Rectangle
     * @return the button's display position
     */
    private Rectangle getCloseImageRectangle(int tabIndex) {
        // Get the image location and hence the image rectangle
        Image image = tabbedPane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED);
        while (image.getWidth(null) == -1 || image.getHeight(null) == -1) {
            // Does nothing.
        }

        // Get the tab's rectangle
        Rectangle tab = tabbedPane.getUI().getTabBounds(tabbedPane, tabIndex);
        Dimension dimension = tabbedPane.getCloseButtonPadding();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int x = tab.x + tab.width - image.getWidth(null) - dimension.width;
        int y = tab.y + dimension.height;

        return new Rectangle(x, y, width, height);
    }

    /**
     * <p>
     * To select a tab by clicking.
     * </p>
     *
     * @param index the index of tab to select
     */
    private void selectTab(int index) {
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, tabbedPane, index, 1));
    }

    /**
     * <p>
     * To close a tab by clicking.
     * </p>
     *
     * @param index the index of tab to close
     */
    private void closeTab(int index) {
        Rectangle rect = getCloseImageRectangle(index);
        helper.enterClickAndLeave(new MouseEventData(this, tabbedPane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS,
                false, 0, new Point(rect.x + 1, rect.y + 1)));
    }

    /**
     * <p>
     * A Functional stress test case for directional selector with increased
     * order will be used.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDirectionalStress1() throws Exception {
        tabbedPane.setActiveTabSelector(new DirectionalActiveTabSelector(true));

        JFrame frame = new JFrame();
        frame.setSize(1200, 500);
        frame.add(tabbedPane);
        frame.setVisible(true);

        for (int i = RUN_TIME - 1; i >= 0; --i) {
            selectTab(i);
            closeTab(i);

            assertEquals("Method testDirectionalStress1 should be incorrect.", i - 1, tabbedPane.getSelectedIndex());
        }
    }

    /**
     * <p>
     * A Functional stress test case for directional selector with increased
     * order will be used.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDirectionalStress2() throws Exception {
        tabbedPane.setActiveTabSelector(new DirectionalActiveTabSelector(false));

        JFrame frame = new JFrame();
        frame.setSize(1200, 500);
        frame.add(tabbedPane);
        frame.setVisible(true);

        for (int i = RUN_TIME - 1; i >= 0; --i) {
            selectTab(i);
            closeTab(i);

            assertEquals("Method testDirectionalStress2 should be incorrect.", i - 1, tabbedPane.getSelectedIndex());
        }
    }

    /**
     * <p>
     * A Functional stress test case for previous active tab selector.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPreviousStress() throws Exception {
        tabbedPane.setActiveTabSelector(new PreviousActiveTabSelector());

        JFrame frame = new JFrame();
        frame.setSize(1200, 500);
        frame.add(tabbedPane);
        frame.setVisible(true);

        for (int i = 0; i < RUN_TIME; ++i) {
            selectTab(i);
        }

        for (int i = RUN_TIME - 1; i >= 0; --i) {
            closeTab(i);

            assertEquals("Method testPreviousStress should be incorrect.", i - 1, tabbedPane.getSelectedIndex());
        }
    }
}
