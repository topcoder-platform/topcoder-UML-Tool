/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.failuretests;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneConfigurationException;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;
import com.topcoder.gui.closabletabbedpane.CloseButtonState;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * Failure test for <c>ClosableTabbedPane</c> class.
 *
 * @author liulike
 * @version 1.0
 *
 */
public class ClosableTabbedPaneFailureTests extends TestCase {

    /**
     * The <c>ClosableTabbedPane</c> instance for test.
     */
    private ClosableTabbedPane instance;

    /**
     * Set up test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        LoadConfig();
        instance = new ClosableTabbedPane();
    }

    /**
     * Load config.
     *
     * @throws ConfigManagerException
     *             to JUnit
     *
     */
    private void LoadConfig() throws ConfigManagerException {
        ClearConfig();
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add("failuretests" + File.separator + "config.xml");
    }

    /**
     * Tear down test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        ClearConfig();
    }

    /**
     * Clear config.
     *
     * @throws UnknownNamespaceException
     *             to JUnit
     */
    private void ClearConfig() throws UnknownNamespaceException {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }

    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(int). It tests the
     * case that tabPlacement is invalid, and IllegalArgumentException is
     * expected.
     */
    public void testClosableTabbedPaneInt() {
        try {
            new ClosableTabbedPane(-1);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(int, int). It tests
     * the case that tabPlacement is invalid, and IllegalArgumentException is
     * expected.
     */
    public void testClosableTabbedPaneIntInt1() {
        try {
            new ClosableTabbedPane(-1, 1);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(int, int). It tests
     * the case that tabLayoutPolicy is invalid, and IllegalArgumentException is
     * expected.
     */
    public void testClosableTabbedPaneIntInt2() {
        try {
            new ClosableTabbedPane(1, -1);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that namespace is null, and IllegalArgumentException is
     * expected.
     *
     * @throws ClosableTabbedPaneConfigurationException
     *             to JUnit
     */
    public void testClosableTabbedPaneString1()
            throws ClosableTabbedPaneConfigurationException {
        try {
            new ClosableTabbedPane(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that namespace is empty, and IllegalArgumentException
     * is expected.
     *
     * @throws ClosableTabbedPaneConfigurationException
     *             to JUnit
     */
    public void testClosableTabbedPaneString2()
            throws ClosableTabbedPaneConfigurationException {
        try {
            new ClosableTabbedPane(" \t ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString3() {
        try {
            new ClosableTabbedPane("FailureNamespace1");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString5() {
        try {
            new ClosableTabbedPane("FailureNamespace3");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString7() {
        try {
            new ClosableTabbedPane("FailureNamespace5");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString8() {
        try {
            new ClosableTabbedPane("FailureNamespace6");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString9() {
        try {
            new ClosableTabbedPane("FailureNamespace7");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString11() {
        try {
            new ClosableTabbedPane("FailureNamespace9");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString13() {
        try {
            new ClosableTabbedPane("FailureNamespace11");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString15() {
        try {
            new ClosableTabbedPane("FailureNamespace13");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString17() {
        try {
            new ClosableTabbedPane("FailureNamespace15");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString19() {
        try {
            new ClosableTabbedPane("FailureNamespace17");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString20() {
        try {
            new ClosableTabbedPane("FailureNamespace18");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString22() {
        try {
            new ClosableTabbedPane("FailureNamespace20");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString24() {
        try {
            new ClosableTabbedPane("FailureNamespace22");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString26() {
        try {
            new ClosableTabbedPane("FailureNamespace24");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString27() {
        try {
            new ClosableTabbedPane("FailureNamespace25");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString28() {
        try {
            new ClosableTabbedPane("FailureNamespace26");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString29() {
        try {
            new ClosableTabbedPane("FailureNamespace27");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#ClosableTabbedPane(java.lang.String).
     * It tests the case that config is invalid, and
     * ClosableTabbedPaneConfigurationException is expected.
     */
    public void testClosableTabbedPaneString30() {
        try {
            new ClosableTabbedPane("FailureNamespace28");
            fail("ClosableTabbedPaneConfigurationException is expected");
        } catch (ClosableTabbedPaneConfigurationException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#getCloseButtonImage(CloseButtonState).
     * It tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testGetCloseButtonImage() {
        try {
            instance.getCloseButtonImage(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#setCloseButtonImage(CloseButtonState,
     * java.awt.Image). It tests the case that argument is null, and
     * IllegalArgumentException is expected.
     */
    public void testSetCloseButtonImage1() {
        try {
            instance.setCloseButtonImage(null, new BufferedImage(1, 1,
                    BufferedImage.TYPE_INT_ARGB));
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#setCloseButtonImage(CloseButtonState,
     * java.awt.Image). It tests the case that argument is null, and
     * IllegalArgumentException is expected.
     */
    public void testSetCloseButtonImage2() {
        try {
            instance.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED,
                    null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#setCloseButtonPadding(java.awt.Dimension). It tests
     * the case that argument is null, and IllegalArgumentException is expected.
     */
    public void testSetCloseButtonPadding1() {
        try {
            instance.setCloseButtonPadding(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#setCloseButtonPadding(java.awt.Dimension). It tests
     * the case that either dimension value is negative, and
     * IllegalArgumentException is expected.
     */
    public void testSetCloseButtonPadding2() {
        try {
        	instance.setCloseButtonPadding(new Dimension(-1, 1));
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#setCloseButtonPadding(java.awt.Dimension). It tests
     * the case that either dimension value is negative, and
     * IllegalArgumentException is expected.
     */
    public void testSetCloseButtonPadding3() {
        try {
        	instance.setCloseButtonPadding(new Dimension(1, -1));
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#insertTab(java.lang.String,
     * javax.swing.Icon, java.awt.Component, java.lang.String, int). It tests
     * the case that component is null, and IllegalArgumentException is
     * expected.
     */
    public void testInsertTabStringIconComponentStringInt() {
        try {
            instance.insertTab(null, null, null, null, 0);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#processMouseEvent(java.awt.event.MouseEvent). It tests
     * the case that argument is null, and IllegalArgumentException is expected.
     */
    public void testProcessMouseEventMouseEvent() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.processMouseEvent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#processMouseMotionEvent(java.awt.event.MouseEvent). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testProcessMouseMotionEventMouseEvent() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.processMouseMotionEvent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPane#paintComponent(java.awt.Graphics). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testPaintComponentGraphics() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.paintComponent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabAddedEvent(ClosableTabbedPaneEvent). It tests
     * the case that argument is null, and IllegalArgumentException is expected.
     */
    public void testFireTabAddedEvent() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabAddedEvent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosingEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testFireTabsClosingEvent1() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosingEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument is empty, and IllegalArgumentException is
     * expected.
     */
    public void testFireTabsClosingEvent2() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(new ClosableTabbedPaneEvent[0]);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosingEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument contains null, and IllegalArgumentException
     * is expected.
     */
    public void testFireTabsClosingEvent3() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(new ClosableTabbedPaneEvent[2]);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosedEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument is null, and IllegalArgumentException is
     * expected.
     */
    public void testFireTabsClosedEvent1() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosedEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument is empty, and IllegalArgumentException is
     * expected.
     */
    public void testFireTabsClosedEvent2() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(new ClosableTabbedPaneEvent[0]);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for
     * ClosableTabbedPane#fireTabsClosedEvent(ClosableTabbedPaneEvent[]). It
     * tests the case that argument contains null, and IllegalArgumentException
     * is expected.
     */
    public void testFireTabsClosedEvent3() {
        MockClosableTabbedPane mock = new MockClosableTabbedPane();
        try {
            mock.fireTabsClosingEvent(new ClosableTabbedPaneEvent[2]);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

}
