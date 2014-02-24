/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.ComponentFinder;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * <p>
 * UnitTest for ClosableTabbedPane class. Part 2 - advanced methods. The main functionality will be tested in
 * MainUnitTest.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneUnitTest2 extends JFCTestCase {
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
        return new TestSuite(ClosableTabbedPaneUnitTest2.class);
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

        // pane.setCloseButtonPadding(new Insets(0, 0, 0, 5));

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
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Check if the tab can be closed properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy1() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Perform a close event
        Rectangle rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));

        assertEquals("processMouseEvent incorrect", 3, pane.getTabCount());
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(0).indexOf("title1") != -1);
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(1).indexOf("title3") != -1);
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(2).indexOf("title4") != -1);
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * If handler tells the pane "failure".
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy2() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        pane.addClosableTabbedPaneEventHandler(new MockClosableTabbedPaneEventHandler());
        // Perform a close event
        Rectangle rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));

        assertEquals("processMouseEvent incorrect", 4, pane.getTabCount());
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Check if all of them are closed.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy3() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Perform a close event
        Rectangle rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));
        rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));
        rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));
        rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false,
            100, new Point(rect.x + 1, rect.y + 1)));

        assertEquals("processMouseEvent incorrect", 0, pane.getTabCount());
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Close a tab via right click pop-up.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy4() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Perform a close event, using right click pop-up
        Rectangle rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            100, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(0)));

        assertEquals("processMouseEvent incorrect", 3, pane.getTabCount());
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(0).indexOf("title1") != -1);
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(1).indexOf("title3") != -1);
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(2).indexOf("title4") != -1);
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Click other tabs via right click pop-up.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy5() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Perform a close event, using right click pop-up
        Rectangle rect = getCloseImageRectangle(1);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            100, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        // Close others
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(1)));

        assertEquals("processMouseEvent incorrect", 1, pane.getTabCount());
        assertTrue("processMouseEvent incorrect", pane.getTitleAt(0).indexOf("title2") != -1);
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Close all via tripper menu.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy6() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Perform a close event, using right click pop-up
        Rectangle rect = getCloseImageRectangle(2);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true,
            100, new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        // Close others
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(2)));

        assertEquals("processMouseEvent incorrect", 0, pane.getTabCount());
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Check if mouse-press is ignored, to prevent the tab from switching in case the left mouse button is //
     * depressed but the click is still incomplete.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy7() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Pre-set the selected index
        pane.setSelectedIndex(3);

        // Prepare a click
        Rectangle rect = getCloseImageRectangle(2);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEvent.BUTTON3_MASK, false, 0, new Point(
            rect.x + 1, rect.y + 1)));

        // Check if the selected index is changed
        assertEquals("processMouseEvent incorrect", 3, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Check if mouse-press is ignored, to prevent the tab from switching in case the left mouse button is //
     * depressed but the click is still incomplete.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventAccuracy8() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        // Pre-set the selected index
        pane.setSelectedIndex(3);

        // Prepare an event
        Rectangle rect = getCloseImageRectangle(2);
        pane.processMouseEvent(new MouseEvent(pane, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, rect.x + 1, rect.y + 1, 1, false));

        // Check if the selected index is changed
        assertEquals("processMouseEvent incorrect", 3, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Failure test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Call this method with null event.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventFailure1() throws Exception {
        try {
            pane.processMouseEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Call this method when no button image is set.
     * </p>
     * <p>
     * Expect IllegalStateException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventFailure2() throws Exception {
        try {
            // Prepare a pane without button images
            pane = new ClosableTabbedPane();
            pane.insertTab("title1", null, new JTextArea(), null, 0);
            // Handle the event
            Point p = pane.getUI().getTabBounds(pane, 0).getLocation();
            pane.processMouseEvent(new MouseEvent(pane, MouseEvent.BUTTON1, 0, MouseEvent.BUTTON1_MASK, p.x, p.y,
                1, false));
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>processMouseEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Call this method when invalid image is set.
     * </p>
     * <p>
     * Expect IllegalStateException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseEventFailure3() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        try {
            // Prepare a pane without button images
            pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
                .createImage("test"));
            pane.insertTab("title1", null, new JTextArea(), null, 0);
            // Handle the event
            Point p = pane.getUI().getTabBounds(pane, 2).getLocation();
            pane.processMouseEvent(new MouseEvent(pane, MouseEvent.BUTTON1, 0, MouseEvent.BUTTON1_MASK, p.x, p.y,
                1, false));
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>processMouseMotionEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Null event.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseMotionEventFailure1() throws Exception {
        try {
            pane.processMouseMotionEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>processMouseMotionEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Call this method when no button image is set.
     * </p>
     * <p>
     * Expect IllegalStateException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseMotionEventFailure2() throws Exception {
        try {
            // Prepare a pane without button images
            pane = new ClosableTabbedPane();
            pane.insertTab("title1", null, new JTextArea(), null, 0);
            // Handle the event
            Point p = pane.getUI().getTabBounds(pane, 0).getLocation();
            pane.processMouseMotionEvent(new MouseEvent(pane, MouseEvent.BUTTON1, 0, MouseEvent.BUTTON1_MASK, p.x,
                p.y, 1, false));
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>processMouseMotionEvent(MouseEvent e)</code> method.
     * </p>
     * <p>
     * Call this method when invalid image is set.
     * </p>
     * <p>
     * Expect IllegalStateException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testProcessMouseMotionEventFailure3() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        try {
            // Prepare a pane with invalid button images
            pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
                .createImage("test"));
            pane.insertTab("title1", null, new JTextArea(), null, 0);
            // Handle the event
            Point p = pane.getUI().getTabBounds(pane, 2).getLocation();
            pane.processMouseMotionEvent(new MouseEvent(pane, MouseEvent.BUTTON1, 0, MouseEvent.BUTTON1_MASK,
                p.x + 1, p.y + 1, 1, false));
            fail("Expect IllegalStateException.");
        } catch (IllegalStateException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>paintComponent(Graphics g)</code> method.
     * </p>
     * <p>
     * Null g.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPaintComponentFailure() throws Exception {
        try {
            pane.paintComponent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabAddedEvent(ClosableTabbedPaneEvent event)</code> method.
     * </p>
     * <p>
     * Null event
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabAddedEventFailure() throws Exception {
        try {
            pane.fireTabAddedEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosingEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Null events.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosingEventFailure1() throws Exception {
        try {
            pane.fireTabsClosingEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosingEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Empty events.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosingEventFailure2() throws Exception {
        try {
            pane.fireTabsClosingEvent(new ClosableTabbedPaneEvent[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosingEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Null event.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosingEventFailure3() throws Exception {
        try {
            pane.fireTabsClosingEvent(new ClosableTabbedPaneEvent[] {null});
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosedEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Null events.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosedEventFailure1() throws Exception {
        try {
            pane.fireTabsClosedEvent(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosedEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Empty events.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosedEventFailure2() throws Exception {
        try {
            pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>fireTabsClosedEvent(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Null event.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testFireTabsClosedEventFailure3() throws Exception {
        try {
            pane.fireTabsClosedEvent(new ClosableTabbedPaneEvent[] {null});
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
