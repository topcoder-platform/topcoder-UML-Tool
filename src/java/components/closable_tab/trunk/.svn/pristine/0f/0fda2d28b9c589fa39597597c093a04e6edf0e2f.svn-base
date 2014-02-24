/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.accuracytests;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEventHandler;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;
import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.ComponentFinder;

/**
 * Accuracy tests for the main class ClosableTabbedPane, all public/protected methods and ctors are tests.
 *
 * @author knuthocean
 * @version 1.0
 */
public class ClosableTabbedPaneAccuracyTests extends JFCTestCase {

    /** The ClosableTabbedPane instance for acc testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** JFC TestHelper for Swing. */
    private TestHelper helper = null;

    /**
     * <p>
     * Sets up accuracy tests.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void setUp() throws Exception {
        // add components
        pane.insertTab("acc-E", null, new JTextArea(), null, 0);
        pane.insertTab("acc-D", null, new JTextArea(), null, 0);
        pane.insertTab("acc-C", null, new JTextArea(), null, 0);
        pane.insertTab("acc-B", null, new JTextArea(), null, 0);
        pane.insertTab("acc-A", null, new JTextArea(), null, 0);

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
     * tear down accuracy tests.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void tearDown() throws Exception {
        pane = null;

    }

    /**
     * Accuracy test for ctor 1: ClosableTabbedPane(), test the creation.
     */

    public void testAccuracyCtor1() {
        pane = new ClosableTabbedPane();
        assertNotNull("fail to create the ClosableTabbedPane instance with ctor1.", pane);
        assertEquals("fail to create the ClosableTabbedPane instance with ctor1.", pane.getCloseButtonPadding(),
                new Dimension(0, 0));
        assertEquals("fail to create the ClosableTabbedPane instance with ctor1.", pane.getActiveTabSelector(), null);
        assertEquals("fail to create the ClosableTabbedPane instance with ctor1.", pane.getInteriorBorder(), null);

    }

    /**
     * <p>
     * Accuracy test for ctor 2: ClosableTabbedPane(int), test the creation.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyCtor2() throws Exception {
        pane = new ClosableTabbedPane(ClosableTabbedPane.TOP);

        assertEquals("fail to create the ClosableTabbedPane instance with ctor2", new Dimension(0, 0), pane
                .getCloseButtonPadding());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor2", null, pane
                .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("fail to create the ClosableTabbedPane instance with ctor2", null, pane.getInteriorBorder());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor2", null, pane.getActiveTabSelector());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor2", ClosableTabbedPane.TOP, pane
                .getTabPlacement());
    }

    /**
     * <p>
     * Accuracy test for ctor 2: ClosableTabbedPane(int, int), test the creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAccuracyCtor3() throws Exception {
        pane = new ClosableTabbedPane(ClosableTabbedPane.TOP, ClosableTabbedPane.WRAP_TAB_LAYOUT);

        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", new Dimension(0, 0), pane
                .getCloseButtonPadding());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", null, pane
                .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", null, pane.getInteriorBorder());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", null, pane.getActiveTabSelector());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", ClosableTabbedPane.TOP, pane
                .getTabPlacement());
        assertEquals("fail to create the ClosableTabbedPane instance with ctor3", ClosableTabbedPane.WRAP_TAB_LAYOUT,
                pane.getTabLayoutPolicy());

    }

    /**
     * <p>
     * Accuracy test for ctor 4: ClosableTabbedPane(String), test the creation.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyCtor4() throws Exception {

        try {
            ConfigManager.getInstance().add("accuracytests/acc-config.xml");
            pane = new ClosableTabbedPane("acc-tests");

            assertEquals("fail to create the ClosableTabbedPane instance with ctor4", new Dimension(3, 5), pane
                    .getCloseButtonPadding());
            assertNotNull("fail to create the ClosableTabbedPane instance with ctor4", pane
                    .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
            assertEquals("fail to create the ClosableTabbedPane instance with ctor4", ((LineBorder) pane
                    .getInteriorBorder()).getLineColor(), new LineBorder(Color.decode("#13579A"), 7, true)
                    .getLineColor());
            assertTrue("fail to create the ClosableTabbedPane instance with ctor4",
                    pane.getActiveTabSelector() instanceof DirectionalActiveTabSelector);
            assertEquals("fail to create the ClosableTabbedPane instance with ctor4", ClosableTabbedPane.TOP, pane
                    .getTabPlacement());
        } finally {
            ConfigManager.getInstance().refreshAll();
        }
    }

    /**
     * <p>
     * Accuracy test for the methods: getCloseButtonImage()/setCloseButtonImage(CloseButtonState, Image) .
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyGetAndSetCloseButtonImage() throws Exception {
        Image image = Toolkit.getDefaultToolkit().getImage("acc-test");
        assertNotNull("fail to get ClosebuttonImage", pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        pane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, image);
        assertEquals("fail to setCloseButtonImage", image, pane
                .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
    }

    /**
     * <p>
     * Accuracy test for the methods: getCloseButtonPadding() and setCloseButtonPadding(Dimension) method.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyGetAndSetCloseButtonPadding() throws Exception {
        assertEquals("fail to get the close button padding.", new Dimension(0,5), pane.getCloseButtonPadding());
        pane.setCloseButtonPadding(new Dimension(1,2));
        assertEquals("fail to set the close button padding.", new Dimension(1,2), pane.getCloseButtonPadding());
    }

    /**
     * <p>
     * Accuracy test for the methods: getInteriorBorder()/setInteriorBorder(Border).
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyGetAndSetInteriorBorder() throws Exception {
        assertNull("fail to get interior border.", pane.getInteriorBorder());
        Border border = new LineBorder(new Color(0, 0, 0));
        pane.setInteriorBorder(border);
        assertEquals("fail to set the interiro border.", border, pane.getInteriorBorder());
    }

    /**
     * <p>
     * Accuracy test for methods: getActiveTabSelector/setActiveTabSelector(ActiveTabSelector ).
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyGetAndSetActiveTabSelector() throws Exception {
        assertNull("fail to get the selector.", pane.getActiveTabSelector());
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);
        assertEquals("fail to set the selector.",
                DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR, pane
                        .getActiveTabSelector());
        pane.setActiveTabSelector(null);
        assertNull("fail to set the selector.", pane.getActiveTabSelector());

        PreviousActiveTabSelector selector = new PreviousActiveTabSelector(10);
        pane.setActiveTabSelector(selector);
        assertEquals("fail to set the selector.", 10, ((PreviousActiveTabSelector) pane.getActiveTabSelector())
                .getMaximumHistoryLength());
    }

    /**
     * <p>
     * Accuracy test for methods: addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler) and
     * removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler ) and
     * getClosableTabbedPaneEventHandlers().
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyAddAndRemoveAndGetClosableTabbedPaneEventHandler() throws Exception {
        ClosableTabbedPaneEventHandler ctph0 = new MockClosableTabbedPaneEventHandlerACC();
        ClosableTabbedPaneEventHandler ctph1 = new MockClosableTabbedPaneEventHandlerACC();

        assertEquals("before the test.", pane.getClosableTabbedPaneEventHandlers().length, 0);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);
        pane.addClosableTabbedPaneEventHandler(ctph0);
        pane.addClosableTabbedPaneEventHandler(ctph1);

        assertEquals("fail to add the handler", 2, pane.getClosableTabbedPaneEventHandlers().length);
        assertEquals("fail to add the handler", pane.getClosableTabbedPaneEventHandlers()[0] == ctph0, pane
                .getClosableTabbedPaneEventHandlers()[1] == ctph1);

        pane.removeClosableTabbedPaneEventHandler(ctph0);
        assertEquals("fail to remove the handler", 1, pane.getClosableTabbedPaneEventHandlers().length);
        pane.removeClosableTabbedPaneEventHandler(ctph0);
        assertEquals("fail to remove the handler", pane.getClosableTabbedPaneEventHandlers()[0], ctph1);
        pane.removeClosableTabbedPaneEventHandler(ctph0);
        pane.removeClosableTabbedPaneEventHandler(ctph0);
        pane.removeClosableTabbedPaneEventHandler(ctph0);
        pane.removeClosableTabbedPaneEventHandler(ctph0);
        assertEquals("fail to remove the handler", pane.getClosableTabbedPaneEventHandlers()[0], ctph1);
        pane.removeClosableTabbedPaneEventHandler(ctph1);
        assertEquals("fail to remove the handler", 0, pane.getClosableTabbedPaneEventHandlers().length);

    }

    /**
     * <p>
     * Accuracy test for method: insertTab(String, Icon,Component, String, int).
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyInsertTab() throws Exception {

        JComponent jta = new JTextArea();
        LineBorder border = new LineBorder(new Color(1, 3, 5));
        jta.setBorder(border);

        pane = new ClosableTabbedPane();
        pane.setInteriorBorder(border);
        pane.insertTab("acc-insert-tab 1", null, jta, null, 0);

        CompoundBorder cb1 = (CompoundBorder) ((JComponent) pane.getComponentAt(0)).getBorder();
        assertEquals("fail to  insertTab", border, cb1.getOutsideBorder());
        assertEquals("fail to insertTab", border, cb1.getInsideBorder());

        // insert tab 2,3,4,5
        pane.setSelectedIndex(0);
        pane.insertTab("acc-insert-tab2", null, new JTextArea(), null, 0);
        assertEquals("fail to get the selectedIndex.", 1, pane.getSelectedIndex());

        pane.setSelectedIndex(1);
        pane.insertTab("acc-insert-tab3", null, new JTextArea(), null, 1);
        assertEquals("fail to get the selectedIndex.", 2, pane.getSelectedIndex());
        pane.setSelectedIndex(0);
        pane.insertTab("acc-insert-tab4", null, new JTextArea(), null, 0);
        assertEquals("fail to get the selectedIndex.", 1, pane.getSelectedIndex());
        pane.setSelectedIndex(3);
        pane.insertTab("acc-insert-tab5", null, new JTextArea(), null, 4);
        assertEquals("fail to get the selectedIndex.", 3, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test for methods: getTitleAt(int) And getTitleSuffix().
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyGetTitleAt() throws Exception {
        assertEquals("fail to get title", "acc-A" + pane.getTitleSuffix(), pane.getTitleAt(0));
        assertTrue("fail to get suffix.", pane.getTitleSuffix().trim().length() == 0);
    }

    /**
     * <p>
     * Accuracy test for method: removeTabAt(int).
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAccuracyRemoveTabAt() throws Exception {
        // before there are : 0 1 2 3 4
        pane.setSelectedIndex(2);
        // 0 1 2* 3 4
        pane.removeTabAt(0);
        // 1 2* 3 4
        assertEquals("fail to remove tab.", 1, pane.getSelectedIndex());
        pane.removeTabAt(1);
        // 1 3* 4
        assertEquals("fail to remove tab.", 1, pane.getSelectedIndex());
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        pane.setSelectedIndex(0);
        pane.removeTabAt(1);
        // 1* 4
        assertEquals("fail to remove tab.", 0, pane.getSelectedIndex());

        pane.removeTabAt(0);
        pane.removeTabAt(0);
        assertEquals("fail to remove tab.", -1, pane.getSelectedIndex());
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
     * <p>
     * Accuracy tests for method: processMouseEvent(MouseEvent e) --- 1.
     * </p>

     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAccuracyProcessMouseEvent1() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1200, 900);
        frame.setVisible(true);

        // NOT SELECTED
        pane.setSelectedIndex(-1);
        // A B C D E
        assertEquals("processMouseEvent incorrect", 5, pane.getTabCount());

        // set active select
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // set the select C*
        // A B C* D E
        pane.setSelectedIndex(2);
        Rectangle rect = getCloseImageRectangle(2);
        // delete C
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));

        // A B* D E
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 1);
        assertEquals("processMouseEvent incorrect", 4, pane.getTabCount());
        // set active select
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        rect = getCloseImageRectangle(1);
        // delete B
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        // A D* E
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 1);
        assertEquals("processMouseEvent incorrect", 3, pane.getTabCount());

        // delete D* ---> A E*
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        // Thread.sleep(5000);
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 1);
        assertEquals("processMouseEvent incorrect", 2, pane.getTabCount());

        // delete E* ---> A
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 0);
        assertEquals("processMouseEvent incorrect", 1, pane.getTabCount());

        // A --> A nothing happen.
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 0);
        assertEquals("processMouseEvent incorrect", 1, pane.getTabCount());

        // Delete A¡Á
        rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, false, 100,
                new Point(rect.x, rect.y)));
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), -1);
        assertEquals("processMouseEvent incorrect", 0, pane.getTabCount());

    }

    /**
     * <p>
     * Accuracy tests for method: processMouseEvent(MouseEvent e) --- 2.
     * </p>

     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAccuracyProcessMouseEvent2() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1200, 900);
        frame.setVisible(true);

        // NOT SELECTED
        pane.setSelectedIndex(-1);
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);

        // A B C D E
        assertEquals("processMouseEvent incorrect", 5, pane.getTabCount());

        // delete C
        Rectangle rect = getCloseImageRectangle(3);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true, 100,
                new Point(rect.x + 1, rect.y + 1)));
        JPopupMenu popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(0)));

        assertEquals("fail acc test", 4, pane.getTabCount());

        // A B D E --> close all except D --> D
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true, 100,
                new Point(rect.x + 1, rect.y + 1)));
        popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();
        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(1)));

        assertEquals("fail acc test", 1, pane.getTabCount());
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), -1);

        // close D
        rect = getCloseImageRectangle(0);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true, 100,
                new Point(rect.x + 1, rect.y + 1)));
        popup = (JPopupMenu) new ComponentFinder(JPopupMenu.class).find();

        helper.enterClickAndLeave(new MouseEventData(this, popup.getComponent(2)));

        assertEquals("fail acc test", 0, pane.getTabCount());
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), -1);
    }

    /**
     * <p>
     * Accuracy tests for method: processMouseEvent(MouseEvent e) --- 3.
     * </p>

     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAccuracyProcessMouseEvent3() throws Exception {
        // Prepare the outside frame
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setSize(1200, 900);
        frame.setVisible(true);
        pane = new MockClosableTabbedPaneACC();
        pane.insertTab("acc-E", null, new JTextArea(), null, 0);
        pane.insertTab("acc-D", null, new JTextArea(), null, 0);
        pane.insertTab("acc-C", null, new JTextArea(), null, 0);
        pane.insertTab("acc-B", null, new JTextArea(), null, 0);
        pane.insertTab("acc-A", null, new JTextArea(), null, 0);

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

        // NOT SELECTED
        pane.setSelectedIndex(3);
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);
        helper.enterClickAndLeave(new MouseEventData(this, pane, 1, MouseEventData.DEFAULT_MOUSE_MODIFIERS, true, 100,
                new Point(0, 0)));
        // A B C D E
        assertEquals("processMouseEvent incorrect", 5, pane.getTabCount());

        // mouse pressed
        Rectangle rect = getCloseImageRectangle(3);
        ((MockClosableTabbedPaneACC) pane).processMouseEvent(new MouseEvent(pane, MouseEvent.MOUSE_PRESSED, System
                .currentTimeMillis(), MouseEvent.BUTTON1_MASK, rect.x + 1, rect.y + 1, 1, false));

        assertEquals("fail acc test", 5, pane.getTabCount());
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 3);

        // mouse click
        ((MockClosableTabbedPaneACC) pane).processMouseEvent(new MouseEvent(pane, MouseEvent.MOUSE_CLICKED, System
                .currentTimeMillis(), MouseEvent.BUTTON1_MASK, rect.x, rect.y, 1, false));

        assertEquals("fail acc test", 5, pane.getTabCount());
        assertEquals("fail to process mouse event.", pane.getSelectedIndex(), 3);

    }

}
