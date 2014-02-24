/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.accuracytests;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.JTabbedPaneMouseEventData;
import junit.extensions.jfcunit.eventdata.MouseEventData;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

/**
 * Accuracy tests for class PreviousActiveTabSelector.
 *
 * @author knuthocean
 * @version 1.0
 */
public class PreviousActiveTabSelectorAccuracyTests extends JFCTestCase {

    /** PreviousActiveTabSelector instance for acc tests */
    private PreviousActiveTabSelector selector;

    /** The ClosableTabbedPane instance for acc testing. */
    private ClosableTabbedPane pane;

    /** max size - 10 */
    private int maxSize;

    /** JFC TestHelper for Swing. */
    private TestHelper helper = null;

    /**
     * Sets up accuracy tests.
     *
     * @throws Exception
     *             to JUnit
     */
    public void setUp() throws Exception {
        maxSize = 10;
        selector = new PreviousActiveTabSelector(maxSize);
        pane = new ClosableTabbedPane();
        // add components

        pane.insertTab("acc-A", null, new JTextArea(), null, 0);
        pane.insertTab("acc-B", null, new JTextArea(), null, 1);
        pane.insertTab("acc-C", null, new JTextArea(), null, 2);
        pane.insertTab("acc-D", null, new JTextArea(), null, 3);
        pane.insertTab("acc-E", null, new JTextArea(), null, 4);

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
        helper = new JFCTestHelper();
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
     * Accuracy test for ctor: PreviousActiveTabSelector().
     */
    public void testAccuracyCtor1() {
        selector = new PreviousActiveTabSelector();
        assertNotNull("fail to create PreviousActiveTabSelector.", selector);
        assertEquals("fail to create PreviousActiveTabSelector.", selector.getMaximumHistoryLength(), 0);
    }

    /**
     * Accuracy test for ctor2: PreviousActiveTabSelector(int).
     */
    public void testAccuracyCtor2() {
        assertNotNull("fail to create PreviousActiveTabSelector.", selector);
        assertEquals("fail to create PreviousActiveTabSelector.", selector.getMaximumHistoryLength(), maxSize);
    }

    /**
     * Accuracy test for method: installSelector(ClosableTabbedPane).
     */
    public void testAccuracyInstallSelector() {
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 0);
        assertEquals("before acc test.", pane.getChangeListeners().length, 1);
        selector.installSelector(pane);
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 1);
        assertEquals("before acc test.", pane.getChangeListeners().length, 2);
        selector.installSelector(pane);
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 1);
        assertEquals("before acc test.", pane.getChangeListeners().length, 2);
    }

    /**
     * Accuracy test for method: uninstallSelector(ClosableTabbedPane).
     */
    public void testAccuracyUninstallSelector() {

        selector.installSelector(pane);
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 1);
        assertEquals("before acc test.", pane.getChangeListeners().length, 2);
        selector.uninstallSelector(pane);
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 0);
        assertEquals("before acc test.", pane.getChangeListeners().length, 1);
        selector.uninstallSelector(pane);
        assertEquals("before acc test.", pane.getClosableTabbedPaneEventHandlers().length, 0);
        assertEquals("before acc test.", pane.getChangeListeners().length, 1);

    }

    /**
     * <p>
     * A private helper method to get the button's display rectangle for a given index. This method will
     * check the button's image size also. from peony.
     * </p>
     *
     * @param tabIndex
     *            the tab index to retrieve its Rectangle
     * @return the button's display position
     */
    private Rectangle getCloseImageRectangle(int tabIndex) {
        // Get the image location and hence the image rectangle
        Image image = pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED);
        while (image.getWidth(null) == -1 || image.getHeight(null) == -1) {
            // Does nothing.
        }

        // Get the tab's rectangle
        Rectangle tab = pane.getUI().getTabBounds(pane, tabIndex);
        Dimension dimension = pane.getCloseButtonPadding();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int x = tab.x + tab.width - image.getWidth(null) - dimension.width;
        int y = tab.y + dimension.height;

        return new Rectangle(x, y, width, height);
    }

    /**
     * Accuracy test for method: selectNewActiveTab(ClosableTabbedPane) -- 1.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAccuracySelectNewActiveTab1() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1200, 900);
        frame.setVisible(true);

        // NOT SELECTED
        pane.setSelectedIndex(-1);
        // A B C D E
        assertEquals("processMouseEvent incorrect", 5, pane.getTabCount());

        pane.setSelectedIndex(3);
        selector.installSelector(pane);
        pane.setActiveTabSelector(selector);
        pane.setSelectedIndex(0);
        selector.selectNewActiveTab(pane);
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 3);
        selector.selectNewActiveTab(pane);
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 0);

        // set the selected: 1 3 2 4 0 2 3 1 4
        // A--> B --> d --> C -->E --> A --> C --> D --> B --> E
        pane.setSelectedIndex(1);

        pane.setSelectedIndex(3);

        pane.setSelectedIndex(2);

        pane.setSelectedIndex(4);

        pane.setSelectedIndex(0);

        pane.setSelectedIndex(2);

        pane.setSelectedIndex(3);

        pane.setSelectedIndex(1);

        pane.setSelectedIndex(4);

        // check 4->1->3->2->0->4->2->3->1->0
        // E --> B-->D--> C--> A --> E--> C ---> D --> B ---> A
        // acuracy it should be 4-->1-->2-->0

        // A B C D E*
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 4);

        Rectangle rect = getCloseImageRectangle(pane.getSelectedIndex());
        // delete E --> A B* C D
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 1);

        rect = getCloseImageRectangle(pane.getSelectedIndex());
        // delete B --> A C D*
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 2);

        rect = getCloseImageRectangle(pane.getSelectedIndex());
        // delete D --> A C*
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 1);

        rect = getCloseImageRectangle(pane.getSelectedIndex());
        // delete C --> A*
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to select new activeTab", pane.getSelectedIndex(), 0);

    }

    /**
     * Accuracy test for method: tabClosed(event) -- this is also a function test.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAccuracytabsClosed() throws Exception {

//      Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1200, 900);

        frame.add(pane);
        frame.setVisible(true);
        // Insert tabs
        pane.insertTab("acc-F", null, new JTextArea(), null, 5);

        // A --> D --> F --> B -->D*
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, 0, 1));
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, 3, 1));
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, 5, 1));
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, 1, 1));
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, 3, 1));

        // delete E --> A B C D* F
        Rectangle rect = getCloseImageRectangle(4);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 0,
                new Point(rect.x + 1, rect.y + 1)));

        assertEquals("fail to get active selected.", 3, pane.getSelectedIndex());
        // delete D* ---> A B* C F
        rect = getCloseImageRectangle(3);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 0,
                new Point(rect.x + 1, rect.y + 1)));
        assertEquals("fail to get active selected.", 1, pane.getSelectedIndex());

        // Delete B* ---> A C F*
        rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 0,
                new Point(rect.x + 1, rect.y + 1)));
        assertEquals("fail to get active selected.", 2, pane.getSelectedIndex());

        // Delete F* ---> A* C
        rect = getCloseImageRectangle(2);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 0,
                new Point(rect.x + 1, rect.y + 1)));
        assertEquals("fail to get active selected.", 0, pane.getSelectedIndex());

        // Delete A* ---> C*
        rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 0,
                new Point(rect.x + 1, rect.y + 1)));
        assertEquals("fail to get active selected.", 0, pane.getSelectedIndex());
    }

}
