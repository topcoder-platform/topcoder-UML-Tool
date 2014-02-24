/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.JTabbedPaneMouseEventData;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.ComponentFinder;
import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;

/**
 * <p>
 * This is the main Unit Test class for the whole component. Many complex JFC test cases are put here.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MainUnitTest extends JFCTestCase {
    /** Prepare a ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** Prepare a TestHelper for Swing. */
    private TestHelper helper = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(MainUnitTest.class);
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
        pane.insertTab("title1", null, new JTextArea(), null, 0);
        pane.insertTab("title2", null, new JTextArea(), null, 1);
        pane.insertTab("title3", null, new JTextArea(), null, 2);
        pane.insertTab("title4", null, new JTextArea(), null, 3);

        // We-use the different close images for 4 close button states
        pane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
            "test_files/1.gif"));
        pane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit().createImage(
            "test_files/2.gif"));
        pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit().createImage(
            "test_files/3.gif"));
        pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
            .createImage("test_files/4.gif"));

        pane.setCloseButtonPadding(new Dimension(0,5));

        helper = new JFCTestHelper();
    }

    /**
     * <p>
     * A private helper method to get the button's display rectangle for a given index. This method will check the
     * button's image size also.
     * </p>
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

        Rectangle tab = pane.getUI().getTabBounds(pane, tabIndex);
        Dimension dimension = pane.getCloseButtonPadding();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int x = tab.x + tab.width - image.getWidth(null) - dimension.width;
        int y = tab.y + dimension.height;

        return new Rectangle(x, y, width, height);
    }

    /**
     * To select a tab by clicking.
     * @param index
     *            the index of tab to select
     */
    private void selectTab(int index) {
        helper.enterClickAndLeave(new JTabbedPaneMouseEventData(this, pane, index, 1));
    }

    /**
     * To close a tab by clicking.
     * @param index
     *            the index of tab to close
     */
    private void closeTab(int index) {
        Rectangle rect = getCloseImageRectangle(index);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            0, new Point(rect.x + 1, rect.y + 1)));
    }

    /**
     * To close a tab by pop-up menu.
     * @param index
     *            the index of tab to open a right pop-up menu
     */
    private void popupClose(int index) {
        Rectangle rect = getCloseImageRectangle(index);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            0, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(0)));
    }

    /**
     * To close other tabs by pop-up menu.
     * @param index
     *            the index of tab to open a right pop-up menu
     */
    private void popupCloseOthers(int index) {
        Rectangle rect = getCloseImageRectangle(index);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            0, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(1)));
    }

    /**
     * To close all tabs by pop-up menu.
     * @param index
     *            the index of tab to open a right pop-up menu
     */
    private void popupCloseAll(int index) {
        Rectangle rect = getCloseImageRectangle(index);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            0, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(2)));
    }

    /**
     * Check if the current ClosableTabbedPane's arrangement is the same as given.
     * @param titles
     *            the titles of this arrangement
     * @param selected
     *            the selected index
     */
    private void checkArrange(String[] titles, int selected) {
        assertEquals("titles mismatch", titles.length, pane.getTabCount());
        for (int i = 0; i < titles.length; i++) {
            assertEquals("titles mismatch", titles[i] + pane.getTitleSuffix(), pane.getTitleAt(i));
        }
        assertEquals("selected tab mismatch", selected, pane.getSelectedIndex());
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with increased order will be used.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalIncrease1() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        closeTab(1);
        checkArrange(new String[] {"title1", "title3", "title4"}, 1);

        // Perform actions
        selectTab(1);
        closeTab(1);
        checkArrange(new String[] {"title1", "title4"}, 1);

        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title1", "title4"}, 2);

        // Perform actions
        selectTab(1);
        closeTab(2);
        checkArrange(new String[] {"title5", "title1"}, 1);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {"title1"}, 0);

        // Perform actions
        selectTab(0);
        closeTab(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with increased order will be used. Check close tabs via pop-up menu.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalIncrease2() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        popupClose(1);
        checkArrange(new String[] {"title1", "title3", "title4"}, 1);

        // Perform actions
        selectTab(1);
        popupClose(1);
        checkArrange(new String[] {"title1", "title4"}, 1);

        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title1", "title4"}, 2);

        // Perform actions
        selectTab(1);
        popupClose(2);
        checkArrange(new String[] {"title5", "title1"}, 1);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {"title1"}, 0);

        // Perform actions
        selectTab(0);
        popupClose(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with increased order will be used. Check close others.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalIncrease3() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with increased order will be used. Check close others. The active tag is to be closed.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalIncrease4() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with increased order will be used. Check close all.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalIncrease5() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseAll(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with decreased order will be used.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalDecrease1() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        closeTab(1);
        checkArrange(new String[] {"title1", "title3", "title4"}, 0);

        // Perform actions
        selectTab(2);
        closeTab(2);
        checkArrange(new String[] {"title1", "title3"}, 1);

        // Perform actions
        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title1", "title3"}, 2);

        // Perform actions
        pane.insertTab("title6", null, new JTextArea(), null, 3);
        checkArrange(new String[] {"title5", "title1", "title3", "title6"}, 2);

        // Perform actions
        selectTab(3);
        closeTab(3);
        checkArrange(new String[] {"title5", "title1", "title3"}, 2);

        // Perform actions
        selectTab(1);
        closeTab(2);
        checkArrange(new String[] {"title5", "title1"}, 1);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {"title1"}, 0);

        // Perform actions
        selectTab(0);
        closeTab(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with decreased order will be used. Check close tabs via pop-up menu.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalDecrease2() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        popupClose(1);
        checkArrange(new String[] {"title1", "title3", "title4"}, 0);

        // Perform actions
        selectTab(2);
        popupClose(2);
        checkArrange(new String[] {"title1", "title3"}, 1);

        // Perform actions
        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title1", "title3"}, 2);

        // Perform actions
        pane.insertTab("title6", null, new JTextArea(), null, 3);
        checkArrange(new String[] {"title5", "title1", "title3", "title6"}, 2);

        // Perform actions
        selectTab(3);
        popupClose(3);
        checkArrange(new String[] {"title5", "title1", "title3"}, 2);

        // Perform actions
        selectTab(1);
        popupClose(2);
        checkArrange(new String[] {"title5", "title1"}, 1);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {"title1"}, 0);

        // Perform actions
        selectTab(0);
        popupClose(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with decreased order will be used. Check close others.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalDecrease3() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with decreased order will be used. Check close others. The active tag is to be closed.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalDecrease4() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Directional selector with decreased order will be used. Check close all.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testDirectionalDecrease5() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseAll(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. When we do not select any tab.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious1() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        selectTab(0);

        // Perform actions
        selectTab(2);
        closeTab(2);
        checkArrange(new String[] {"title1", "title2", "title4"}, 0);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {"title2", "title4"}, 0);

        // Insert a tab
        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title2", "title4"}, 1);

        // Insert a tab
        pane.insertTab("title6", null, new JTextArea(), null, 1);
        checkArrange(new String[] {"title5", "title6", "title2", "title4"}, 2);

        // Perform actions
        closeTab(1);
        checkArrange(new String[] {"title5", "title2", "title4"}, 1);

        // Perform actions
        closeTab(1);
        checkArrange(new String[] {"title5", "title4"}, 1);

        // Perform actions
        closeTab(1);
        checkArrange(new String[] {"title5"}, 0);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. This time we also select some tabs.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious2() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Insert tabs
        pane.insertTab("title5", null, new JTextArea(), null, 4);
        pane.insertTab("title6", null, new JTextArea(), null, 5);

        // Select some
        selectTab(0);
        selectTab(3);
        selectTab(5);
        selectTab(1);
        selectTab(3);

        // Perform actions
        closeTab(4);
        checkArrange(new String[] {"title1", "title2", "title3", "title4", "title6"}, 3);

        // Perform actions
        closeTab(3);
        checkArrange(new String[] {"title1", "title2", "title3", "title6"}, 1);

        // Perform actions
        closeTab(1);
        checkArrange(new String[] {"title1", "title3", "title6"}, 2);

        // Perform actions
        closeTab(2);
        checkArrange(new String[] {"title1", "title3"}, 0);

        // Insert a tab
        pane.insertTab("title7", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title7", "title1", "title3"}, 1);

        // Perform actions
        selectTab(0);
        closeTab(0);
        checkArrange(new String[] {"title1", "title3"}, 0);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {"title3"}, 0);

        // Perform actions
        closeTab(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. When we do not select any tab. Pop-up menu is used.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious3() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        selectTab(0);

        // Perform actions
        selectTab(2);
        popupClose(2);
        checkArrange(new String[] {"title1", "title2", "title4"}, 0);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {"title2", "title4"}, 0);

        // Insert a tab
        pane.insertTab("title5", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title5", "title2", "title4"}, 1);

        // Insert a tab
        pane.insertTab("title6", null, new JTextArea(), null, 1);
        checkArrange(new String[] {"title5", "title6", "title2", "title4"}, 2);

        // Perform actions
        popupClose(1);
        checkArrange(new String[] {"title5", "title2", "title4"}, 1);

        // Perform actions
        popupClose(1);
        checkArrange(new String[] {"title5", "title4"}, 1);

        // Perform actions
        popupClose(1);
        checkArrange(new String[] {"title5"}, 0);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. This time we also select some tabs. Pop-up menu is used.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious4() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Insert tabs
        pane.insertTab("title5", null, new JTextArea(), null, 4);
        pane.insertTab("title6", null, new JTextArea(), null, 5);

        // Select some
        selectTab(0);
        selectTab(3);
        selectTab(5);
        selectTab(1);
        selectTab(3);

        // Perform actions
        popupClose(4);
        checkArrange(new String[] {"title1", "title2", "title3", "title4", "title6"}, 3);

        // Perform actions
        popupClose(3);
        checkArrange(new String[] {"title1", "title2", "title3", "title6"}, 1);

        // Perform actions
        popupClose(1);
        checkArrange(new String[] {"title1", "title3", "title6"}, 2);

        // Perform actions
        popupClose(2);
        checkArrange(new String[] {"title1", "title3"}, 0);

        // Insert a tab
        pane.insertTab("title7", null, new JTextArea(), null, 0);
        checkArrange(new String[] {"title7", "title1", "title3"}, 1);

        // Perform actions
        selectTab(0);
        popupClose(0);
        checkArrange(new String[] {"title1", "title3"}, 0);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {"title3"}, 0);

        // Perform actions
        popupClose(0);
        checkArrange(new String[] {}, -1);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. Check close others.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious5() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(1);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. Check close others. The active tag is to be closed.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious6() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseOthers(1);
        checkArrange(new String[] {"title2"}, 0);
    }

    /**
     * <p>
     * A complex test case of this whole component.
     * </p>
     * <p>
     * Previous selector will be used. Check close all.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testPrevious7() throws Exception {
        // Pre-set the selector
        pane.setActiveTabSelector(new PreviousActiveTabSelector());

        // Prepare the frame
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.add(pane);
        frame.setVisible(true);

        // Perform actions
        selectTab(0);
        popupCloseAll(0);
        checkArrange(new String[] {}, -1);
    }
}
