/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.stresstests;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Popup;

import junit.framework.TestCase;

import com.topcoder.gui.sidemenu.SideMenuPanel;
import com.topcoder.gui.sidemenu.accuracytests.TestHelper;

/**
 * <p>
 * Stress test class: <code>SideMenuPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SideMenuPanelTest extends TestCase {
    /**
     * <p>
     * An instance of <code>SideMenuPanel</code> which is tested.
     * </p>
     */
    private SideMenuPanel target = null;

    /**
     * <p>
     * An instance of <code>JFrame</code> used in tests.
     * </p>
     */
    private JFrame jFrame;

    /**
     * <p>
     * setUp() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        target = new SideMenuPanel(TestHelper.TITLE, TestHelper.CONTENT, TestHelper.EXPAND_ICON,
                TestHelper.COLLAPSE_ICON, TestHelper.PIN_ICON);
        // create frame
        jFrame = new JFrame();
        jFrame.add(target);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    /**
     * <p>
     * tearDown() routine.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        jFrame.dispose();
        jFrame = null;
    }

    /**
     * Check collapsed status.
     *
     * @param component
     *            the new CollapsedComponent
     */
    private void checkCollapsed(JComponent component) {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        assertEquals("new/old CollapsedComponent should be added/removed.", component, target
                .getComponents()[0]);
    }

    /**
     * Check expanded status.
     *
     * @param component
     *            the new ExpandedComponent
     */
    private void checkExpanded(JComponent component) {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        assertEquals("new/old ExpandedComponent should be added/removed.", component, target
                .getComponents()[0]);
    }

    /**
     * Check floating status.
     */
    private void checkFloating() {
        assertEquals("Should only contains 1 component", 1, target.getComponents().length);
        Popup floatingPopup = (Popup) TestHelper.getPrivateField(SideMenuPanel.class, target,
                "floatingPopup");
        assertNotNull("floatingPopup", floatingPopup);
    }

    /**
     * Simulate click tests low stress.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testClick1() throws Exception {
        long start = System.currentTimeMillis();
        long sleepTime = 30;
        System.out.println("---- Start click test ----");
        // start test
        for (int i = 0; i < 10; i++) {
            target.setExpanded(true);
            Thread.sleep(sleepTime);
            checkExpanded(target.getExpandedComponent());
            target.setExpanded(false);
            Thread.sleep(sleepTime);
            checkCollapsed(target.getCollapsedComponent());
            target.setFloating(true);
            Thread.sleep(sleepTime);
            checkFloating();
            target.setFloating(false);
            Thread.sleep(sleepTime);
            checkCollapsed(target.getCollapsedComponent());
        }
        // end test
        System.out.println("---- End click test in " + (System.currentTimeMillis() - start)
                + " ms ----");
    }

    /**
     * Simulate click tests high stress.
     *
     * @throws Exception
     *             to JUnit
     */
    public void testClick2() throws Exception {
        long start = System.currentTimeMillis();
        long sleepTime = 30;
        System.out.println("---- Start click test ----");
        // start test
        for (int i = 0; i < 50; i++) {
            target.setExpanded(true);
            Thread.sleep(sleepTime);
            checkExpanded(target.getExpandedComponent());
            target.setExpanded(false);
            Thread.sleep(sleepTime);
            checkCollapsed(target.getCollapsedComponent());
            target.setFloating(true);
            Thread.sleep(sleepTime);
            checkFloating();
            target.setFloating(false);
            Thread.sleep(sleepTime);
            checkCollapsed(target.getCollapsedComponent());
        }
        // end test
        System.out.println("---- End click test in " + (System.currentTimeMillis() - start)
                + " ms ----");
    }
}
