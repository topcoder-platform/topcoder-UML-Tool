/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.*;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.closabletabbedpane.activetabselector.DirectionalActiveTabSelector;
import com.topcoder.gui.closabletabbedpane.activetabselector.PreviousActiveTabSelector;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * UnitTest for ClosableTabbedPane class. Part 1 - basic methods.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneUnitTest1 extends TestCase {
    /** Prepare a ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** Prepare a LineBorder for testing. */
    private LineBorder interiorBorder = new LineBorder(new Color(1, 1, 1));

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ClosableTabbedPaneUnitTest1.class);
    }

    /**
     * <p>
     * Add the config file for testing.
     * </p>
     * @param name
     *            the name of config to be added
     * @throws Exception
     *             unexpected exception.
     */
    private void addConfig(String name) throws Exception {
        ConfigManager.getInstance().add(name);
    }

    /**
     * <p>
     * Clear the config.
     * </p>
     * @throws Exception
     *             unexpected exception.
     */
    private void clearConfig() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        clearConfig();
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
        // pane.setCloseButtonPadding(new Insets(0,0,0,5));
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        clearConfig();
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane()</code> constructor.
     * </p>
     * <p>
     * Simply test the default values.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane1_Accuracy() throws Exception {
        pane = new ClosableTabbedPane();
        // Check if properly created
        assertEquals("default value incorrect", new Dimension(0, 0), pane.getCloseButtonPadding());
        assertEquals("default value incorrect", null, pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane.getInteriorBorder());
        assertEquals("default value incorrect", null, pane.getActiveTabSelector());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(int tabPlacement)</code> constructor.
     * </p>
     * <p>
     * Simply check the default values.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane2_Accuracy() throws Exception {
        pane = new ClosableTabbedPane(ClosableTabbedPane.BOTTOM);
        // Check if properly created
        assertEquals("default value incorrect", new Dimension(0, 0), pane.getCloseButtonPadding());
        assertEquals("default value incorrect", null, pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane.getInteriorBorder());
        assertEquals("default value incorrect", null, pane.getActiveTabSelector());
        assertEquals("ClosableTabbedPane constructor incorrect", ClosableTabbedPane.BOTTOM, pane.getTabPlacement());
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement)</code> constructor.
     * </p>
     * <p>
     * Call with invalid placement.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane2_Failure1() throws Exception {
        try {
            new ClosableTabbedPane(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement)</code> constructor.
     * </p>
     * <p>
     * Call with invalid placement.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane2_Failure2() throws Exception {
        try {
            new ClosableTabbedPane(5);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy)</code> constructor.
     * </p>
     * <p>
     * Check the default values.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane3_Accuracy() throws Exception {
        pane = new ClosableTabbedPane(ClosableTabbedPane.LEFT, ClosableTabbedPane.SCROLL_TAB_LAYOUT);
        // Check if properly created
        assertEquals("default value incorrect", new Dimension(0, 0), pane.getCloseButtonPadding());
        assertEquals("default value incorrect", null, pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane.getInteriorBorder());
        assertEquals("default value incorrect", null, pane.getActiveTabSelector());
        assertEquals("ClosableTabbedPane constructor incorrect", ClosableTabbedPane.LEFT, pane.getTabPlacement());
        assertEquals("ClosableTabbedPane constructor incorrect", ClosableTabbedPane.SCROLL_TAB_LAYOUT, pane
            .getTabLayoutPolicy());

    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy)</code> constructor.
     * </p>
     * <p>
     * Invalid tab placement 0.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane3_Failure1() throws Exception {
        try {
            new ClosableTabbedPane(0, ClosableTabbedPane.WRAP_TAB_LAYOUT);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy)</code> constructor.
     * </p>
     * <p>
     * Invalid tab placement 5.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane3_Failure2() throws Exception {
        try {
            new ClosableTabbedPane(5, ClosableTabbedPane.WRAP_TAB_LAYOUT);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy)</code> constructor.
     * </p>
     * <p>
     * Invalid layout policy -1.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane3_Failure3() throws Exception {
        try {
            new ClosableTabbedPane(ClosableTabbedPane.LEFT, -1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy)</code> constructor.
     * </p>
     * <p>
     * Invalid layout policy 2.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane3_Failure4() throws Exception {
        try {
            new ClosableTabbedPane(ClosableTabbedPane.LEFT, 2);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * A private method to check if the image is correct. It will try to load the image's width and height within
     * 100ms. If either properly cannot be parsed within 100ms, this method fail that test case.
     * @param image
     *            the image to be checked
     */
    private void checkImage(Image image) {
        long time = System.currentTimeMillis();
        while ((image.getWidth(null) == -1 || image.getHeight(null) == -1)
            && System.currentTimeMillis() < time + 200) {
            // Does nothing
        }
        assertTrue("image not properly loaded", image.getWidth(null) != -1);
        assertTrue("image not properly loaded", image.getHeight(null) != -1);
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config1.xml and check the properties.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy1() throws Exception {
        addConfig("config1.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if all properties are set properly
        assertEquals("ClosableTabbedPane(String) incorrect", true, ((DirectionalActiveTabSelector) pane
            .getActiveTabSelector()).isIncreasingIndexDirection());
        checkImage(pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("ClosableTabbedPane(String) incorrect", new Dimension(5, 4), pane.getCloseButtonPadding());
        LineBorder border = (LineBorder) pane.getInteriorBorder();
        assertEquals("ClosableTabbedPane(String) incorrect", new Color(0x4F, 0xAE, 0x52), border.getLineColor());
        assertEquals("ClosableTabbedPane(String) incorrect", 7, border.getThickness());
        assertEquals("ClosableTabbedPane(String) incorrect", true, border.getRoundedCorners());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config2.xml and check the properties. All properties are missing.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy2() throws Exception {
        addConfig("config2.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if properly created
        assertEquals("default value incorrect", new Dimension(0, 0), pane.getCloseButtonPadding());
        assertEquals("default value incorrect", null, pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane.getInteriorBorder());
        assertEquals("default value incorrect", null, pane.getActiveTabSelector());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config3.xml and check the properties. Check if some of properties are missing.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy3() throws Exception {
        addConfig("config3.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if all properties are set properly
        assertEquals("ClosableTabbedPane(String) incorrect", 10, ((PreviousActiveTabSelector) pane
            .getActiveTabSelector()).getMaximumHistoryLength());
        assertEquals("ClosableTabbedPane(String) incorrect", new Dimension(0, 4), pane.getCloseButtonPadding());
        LineBorder border = (LineBorder) pane.getInteriorBorder();
        assertEquals("ClosableTabbedPane(String) incorrect", new Color(0x4F, 0xAE, 0x52), border.getLineColor());
        assertEquals("ClosableTabbedPane(String) incorrect", 1, border.getThickness());
        assertEquals("ClosableTabbedPane(String) incorrect", true, border.getRoundedCorners());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config4.xml and check the properties. Some properties are missing.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy4() throws Exception {
        addConfig("config4.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if all properties are set properly
        assertEquals("ClosableTabbedPane(String) incorrect", 10, ((PreviousActiveTabSelector) pane
            .getActiveTabSelector()).getMaximumHistoryLength());
        assertEquals("ClosableTabbedPane(String) incorrect", new Dimension(0, 4), pane.getCloseButtonPadding());
        LineBorder border = (LineBorder) pane.getInteriorBorder();
        assertEquals("ClosableTabbedPane(String) incorrect", pane.getBackground(), border.getLineColor());
        assertEquals("ClosableTabbedPane(String) incorrect", 0, border.getThickness());
        assertEquals("ClosableTabbedPane(String) incorrect", true, border.getRoundedCorners());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config5.xml and check when no identifier but only key is present.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy5() throws Exception {
        addConfig("config5.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if all properties are set properly
        assertEquals("ClosableTabbedPane(String) incorrect", true, ((DirectionalActiveTabSelector) pane
            .getActiveTabSelector()).isIncreasingIndexDirection());
        checkImage(pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        checkImage(pane.getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("ClosableTabbedPane(String) incorrect", new Dimension(5, 4), pane.getCloseButtonPadding());
        LineBorder border = (LineBorder) pane.getInteriorBorder();
        assertEquals("ClosableTabbedPane(String) incorrect", new Color(0x4F, 0xAE, 0x52), border.getLineColor());
        assertEquals("ClosableTabbedPane(String) incorrect", 7, border.getThickness());
        assertEquals("ClosableTabbedPane(String) incorrect", true, border.getRoundedCorners());
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Use config6.xml and check the properties. All properties are missing. Object factory's namespace and identifier
     * are present, while key is missing.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Accuracy6() throws Exception {
        addConfig("config6.xml");
        pane = new ClosableTabbedPane("myNamespace");
        // Check if properly created
        assertEquals("default value incorrect", new Dimension(0, 0), pane.getCloseButtonPadding());
        assertEquals("default value incorrect", null, pane.getCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
        assertEquals("default value incorrect", null, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED));
        assertEquals("default value incorrect", null, pane.getInteriorBorder());
        assertEquals("default value incorrect", null, pane.getActiveTabSelector());
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * When namespace is not present.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure1() throws Exception {
        addConfig("config1.xml");
        try {
            new ClosableTabbedPane("wrongNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad1.xml. Bad object factory namespace.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure2() throws Exception {
        addConfig("config_bad1.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad2.xml. Bad key in object factory.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure3() throws Exception {
        addConfig("config_bad2.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad3.xml. Bad identifier in object factory.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure4() throws Exception {
        addConfig("config_bad3.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad4.xml. Bad type in object factory's config.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure5() throws Exception {
        addConfig("config_bad4.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad5.xml. Bad parameter in object factory's config.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure6() throws Exception {
        addConfig("config_bad5.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad6.xml. When CCE occurs with wrong selector.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure7() throws Exception {
        addConfig("config_bad6.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad7.xml. Wrong padding top - non integer.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure8() throws Exception {
        addConfig("config_bad7.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad8.xml. Wrong padding right - non integer.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure9() throws Exception {
        addConfig("config_bad8.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad9.xml. Wrong padding right - negative.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure10() throws Exception {
        addConfig("config_bad9.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad10.xml. Wrong padding top - negative.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure11() throws Exception {
        addConfig("config_bad10.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad11.xml. Wrong color - impossible to be parsed, no #.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure12() throws Exception {
        addConfig("config_bad11.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad12.xml. Wrong color - impossible to be parsed, too long.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure13() throws Exception {
        addConfig("config_bad12.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad13.xml. Wrong color - impossible to be parsed, too short.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure14() throws Exception {
        addConfig("config_bad13.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad14.xml. Wrong color - impossible to be parsed, invalid chars.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure15() throws Exception {
        addConfig("config_bad14.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad15.xml. Wrong width - negative.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure16() throws Exception {
        addConfig("config_bad15.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * config_bad16.xml. Wrong width - non integer.
     * </p>
     * <p>
     * Expect ClosableTabbedPaneConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure17() throws Exception {
        addConfig("config_bad16.xml");
        try {
            new ClosableTabbedPane("myNamespace");
            fail("Expect ClosableTabbedPaneConfigurationException.");
        } catch (ClosableTabbedPaneConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Call with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure01() throws Exception {
        try {
            new ClosableTabbedPane(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPane(String namespace)</code> constructor.
     * </p>
     * <p>
     * Call with empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPane4_Failure02() throws Exception {
        try {
            new ClosableTabbedPane("  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>getCloseButtonImage(CloseButtonState buttonState)</code> method.
     * </p>
     * <p>
     * Call this with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetCloseButtonImageFailure() throws Exception {
        try {
            pane.getCloseButtonImage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>setCloseButtonImage(CloseButtonState buttonState, Image image)</code> method.
     * </p>
     * <p>
     * Some some image and get to verify.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonImageAccuracy() throws Exception {
        Image image = Toolkit.getDefaultToolkit().getImage("test");
        pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, image);
        assertEquals("get/setCloseButtonImage incorrect", image, pane
            .getCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED));
    }

    /**
     * <p>
     * Failure test of <code>setCloseButtonImage(CloseButtonState buttonState, Image image)</code> method.
     * </p>
     * <p>
     * Call with null image.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonImageFailure1() throws Exception {
        try {
            pane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>setCloseButtonImage(CloseButtonState buttonState, Image image)</code> method.
     * </p>
     * <p>
     * Call with null state.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonImageFailure2() throws Exception {
        try {
            pane.setCloseButtonImage(null, Toolkit.getDefaultToolkit().createImage("temp"));
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>setCloseButtonPadding(Dimension padding)</code> method.
     * </p>
     * <p>
     * Some some padding and get it.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonPaddingAccuracy() throws Exception {
        pane.setCloseButtonPadding(new Dimension(1, 2));
        assertEquals("set/getCloseButtonPadding incorrect", new Dimension(1, 2), pane.getCloseButtonPadding());
    }

    /**
     * <p>
     * Failure test of <code>setCloseButtonPadding(Dimension padding)</code> method.
     * </p>
     * <p>
     * Call with negative width.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonPaddingFailure1() throws Exception {
        try {
            pane.setCloseButtonPadding(new Dimension(-1, 2));
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>setCloseButtonPadding(Dimension padding)</code> method.
     * </p>
     * <p>
     * Call with negative height.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetCloseButtonPaddingFailure2() throws Exception {
        try {
            pane.setCloseButtonPadding(new Dimension(1, -2));
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>setInteriorBorder(Border border)</code> method.
     * </p>
     * <p>
     * Set some border and get to verify.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetInteriorBorderAccuracy() throws Exception {
        pane.setInteriorBorder(interiorBorder);
        assertEquals("set/getInteriorBorder incorrect", interiorBorder, pane.getInteriorBorder());
    }

    /**
     * <p>
     * Accuracy test of <code>setActiveTabSelector(ActiveTabSelector activeTabSelector)</code> method.
     * </p>
     * <p>
     * Set some selector and get it.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetActiveTabSelectorAccuracy1() throws Exception {
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);
        assertEquals("get/setActiveTabSelector incorrect",
            DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR, pane
                .getActiveTabSelector());
    }

    /**
     * <p>
     * Accuracy test of <code>setActiveTabSelector(ActiveTabSelector activeTabSelector)</code> method.
     * </p>
     * <p>
     * Set it many times.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetActiveTabSelectorAccuracy2() throws Exception {
        pane.setActiveTabSelector(DirectionalActiveTabSelector.DECREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);
        pane.setActiveTabSelector(DirectionalActiveTabSelector.INCREASING_INDEX_DIRECTION_ACTIVE_TAB_SELECTOR);
    }

    /**
     * <p>
     * Accuracy test of <code>setActiveTabSelector(ActiveTabSelector activeTabSelector)</code> method.
     * </p>
     * <p>
     * Set null.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetActiveTabSelectorAccuracy3() throws Exception {
        pane.setActiveTabSelector(null);
    }

    /**
     * <p>
     * Accuracy test of <code>addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Simply add two handlers.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddClosableTabbedPaneEventHandlerAccuracy1() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        MockClosableTabbedPaneEventHandler handler2 = new MockClosableTabbedPaneEventHandler();
        pane.addClosableTabbedPaneEventHandler(handler1);
        pane.addClosableTabbedPaneEventHandler(handler2);

        // Check the result. Order does not matter
        ClosableTabbedPaneEventHandler[] handlers = pane.getClosableTabbedPaneEventHandlers();
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 2, handlers.length);
        if (handlers[0] == handler1) {
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler2, handlers[1]);
        } else {
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler2, handlers[0]);
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler1, handlers[1]);
        }
    }

    /**
     * <p>
     * Accuracy test of <code>addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Add duplicates.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddClosableTabbedPaneEventHandlerAccuracy2() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        MockClosableTabbedPaneEventHandler handler2 = new MockClosableTabbedPaneEventHandler();
        pane.addClosableTabbedPaneEventHandler(handler1);
        pane.addClosableTabbedPaneEventHandler(handler1);
        pane.addClosableTabbedPaneEventHandler(handler2);

        // Check the result. Order does not matter
        ClosableTabbedPaneEventHandler[] handlers = pane.getClosableTabbedPaneEventHandlers();
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 2, handlers.length);
        if (handlers[0] == handler1) {
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler2, handlers[1]);
        } else {
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler2, handlers[0]);
            assertEquals("addClosableTabbedPaneEventHandler incorrect", handler1, handlers[1]);
        }
    }

    /**
     * <p>
     * Accuracy test of <code>addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Add a single one.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddClosableTabbedPaneEventHandlerAccuracy3() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        pane.addClosableTabbedPaneEventHandler(handler1);
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 1,
            pane.getClosableTabbedPaneEventHandlers().length);
        assertEquals("addClosableTabbedPaneEventHandler incorrect", handler1, pane
            .getClosableTabbedPaneEventHandlers()[0]);
    }

    /**
     * <p>
     * Accuracy test of <code>removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Remove nothing.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveClosableTabbedPaneEventHandlerAccuracy1() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        pane.removeClosableTabbedPaneEventHandler(handler1);
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 0,
            pane.getClosableTabbedPaneEventHandlers().length);
    }

    /**
     * <p>
     * Accuracy test of <code>removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Remove a single handler.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveClosableTabbedPaneEventHandlerAccuracy2() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        // Add it
        pane.addClosableTabbedPaneEventHandler(handler1);
        pane.removeClosableTabbedPaneEventHandler(handler1);
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 0,
            pane.getClosableTabbedPaneEventHandlers().length);
    }

    /**
     * <p>
     * Accuracy test of <code>removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler)</code>
     * method.
     * </p>
     * <p>
     * Remove a handle from two.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveClosableTabbedPaneEventHandlerAccuracy3() throws Exception {
        MockClosableTabbedPaneEventHandler handler1 = new MockClosableTabbedPaneEventHandler();
        MockClosableTabbedPaneEventHandler handler2 = new MockClosableTabbedPaneEventHandler();
        // Add it
        pane.addClosableTabbedPaneEventHandler(handler1);
        pane.addClosableTabbedPaneEventHandler(handler2);
        pane.removeClosableTabbedPaneEventHandler(handler1);
        assertEquals("addClosableTabbedPaneEventHandler incorrect", 1,
            pane.getClosableTabbedPaneEventHandlers().length);
    }

    /**
     * <p>
     * Accuracy test of <code>getClosableTabbedPaneEventHandlers()</code> method.
     * </p>
     * <p>
     * Call when empty array.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetClosableTabbedPaneEventHandlersAccuracy() throws Exception {
        assertEquals("getClosableTabbedPaneEventHandlers incorrect", 0,
            pane.getClosableTabbedPaneEventHandlers().length);
    }

    /**
     * <p>
     * Accuracy test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Insert from an empty pane. This method will not test on the fire process, which will be tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabAccuracy1() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();
        LineBorder oldBorder = new LineBorder(new Color(2, 2, 2));
        component.setBorder(oldBorder);

        // Insert it
        pane = new ClosableTabbedPane();
        pane.setInteriorBorder(interiorBorder);
        pane.insertTab("title", null, component, null, 0);

        // Retrieve it
        component = (JComponent) pane.getComponentAt(0);
        CompoundBorder newBorder = (CompoundBorder) component.getBorder();
        assertEquals("insertTab incorrect", interiorBorder, newBorder.getOutsideBorder());
        assertEquals("insertTab incorrect", oldBorder, newBorder.getInsideBorder());
    }

    /**
     * <p>
     * Accuracy test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Insert from a non-empty pane. This method will not test on the fire process, which will be tested later.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabAccuracy2() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();
        LineBorder oldBorder = new LineBorder(new Color(2, 2, 2));
        component.setBorder(oldBorder);

        // Insert it
        pane.setInteriorBorder(interiorBorder);
        pane.insertTab("title", null, component, null, 4);

        // Retrieve it
        component = (JComponent) pane.getComponentAt(4);
        CompoundBorder newBorder = (CompoundBorder) component.getBorder();
        assertEquals("insertTab incorrect", interiorBorder, newBorder.getOutsideBorder());
        assertEquals("insertTab incorrect", oldBorder, newBorder.getInsideBorder());
    }

    /**
     * <p>
     * Accuracy test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Call with null title. "null" text must not appear in the title. This can be confirmed from
     * JTabbedPane#insertTab method.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabAccuracy3() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();

        // Insert it
        pane = new ClosableTabbedPane();
        pane.insertTab(null, null, component, null, 0);

        assertTrue("insertTab incorrect", pane.getTitleAt(0).indexOf("null") == -1);
    }

    /**
     * <p>
     * Accuracy test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Check if the selected index is handled properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabAccuracy4() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();

        // Insert it
        pane.setSelectedIndex(1);
        pane.insertTab("title", null, component, null, 1);

        assertEquals("insertTab incorrect", 2, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Check if the selected index is handled properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabAccuracy5() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();

        // Insert it
        pane.setSelectedIndex(0);
        pane.insertTab("title", null, component, null, 1);

        assertEquals("insertTab incorrect", 0, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Failure test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Call with null component.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabFailure1() throws Exception {
        try {
            pane.insertTab("title", null, null, "tip", 0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Call with negative index.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabFailure2() throws Exception {
        try {
            pane.insertTab("title", null, new JTextArea(), null, -1);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>insertTab(String title, Icon icon, Component component, String tip, int index)</code>
     * method.
     * </p>
     * <p>
     * Call with too large index.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInsertTabFailure3() throws Exception {
        try {
            pane.insertTab("title", null, pane.getComponentAt(2), null, 4);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>getTitleAt(int index)</code> method.
     * </p>
     * <p>
     * Simply retrieve an inserted tab.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetTitleAtAccuracy() throws Exception {
        assertEquals("getTitleAt incorrect", "title1" + pane.getTitleSuffix(), pane.getTitleAt(0));
        assertEquals("getTitleAt incorrect", "title2" + pane.getTitleSuffix(), pane.getTitleAt(1));
        assertEquals("getTitleAt incorrect", "title3" + pane.getTitleSuffix(), pane.getTitleAt(2));
        assertEquals("getTitleAt incorrect", "title4" + pane.getTitleSuffix(), pane.getTitleAt(3));
    }

    /**
     * <p>
     * Failure test of <code>getTitleAt(int index)</code> method.
     * </p>
     * <p>
     * Call with -1.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetTitleAtFailure1() throws Exception {
        try {
            pane.getTitleAt(-1);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>getTitleAt(int index)</code> method.
     * </p>
     * <p>
     * Call with too large index.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetTitleAtFailure2() throws Exception {
        try {
            pane.getTitleAt(4);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>indexOfTab(String title)</code> method.
     * </p>
     * <p>
     * Simply retrieve an inserted tab.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfTabAccuracy1() throws Exception {
        assertEquals("indexOfTab incorrect", 0, pane.indexOfTab("title1" + pane.getTitleSuffix()));
        assertEquals("indexOfTab incorrect", 1, pane.indexOfTab("title2" + pane.getTitleSuffix()));
        assertEquals("indexOfTab incorrect", 2, pane.indexOfTab("title3" + pane.getTitleSuffix()));
        assertEquals("indexOfTab incorrect", 3, pane.indexOfTab("title4" + pane.getTitleSuffix()));
        assertEquals("indexOfTab incorrect", -1, pane.indexOfTab("title5" + pane.getTitleSuffix()));
    }

    /**
     * <p>
     * Accuracy test of <code>indexOfTab(String title)</code> method.
     * </p>
     * <p>
     * Find a tab with null title.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfTabAccuracy2() throws Exception {
        pane.insertTab("", null, new JTextArea(), null, 0);
        assertEquals("indexOfTab incorrect", 0, pane.indexOfTab(pane.getTitleSuffix()));
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the border is reset.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy1() throws Exception {
        // Prepare a tab
        JComponent component = new JTextArea();
        LineBorder oldBorder = new LineBorder(new Color(2, 2, 2));
        component.setBorder(oldBorder);

        // Insert it
        pane = new ClosableTabbedPane();
        pane.setInteriorBorder(interiorBorder);
        pane.insertTab("title", null, component, null, 0);

        // Remove it
        pane.removeTabAt(0);

        // Retrieve it
        assertEquals("insertTab incorrect", oldBorder, component.getBorder());
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Remove from a non-empty pane.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy2() throws Exception {
        pane.removeTabAt(2);
        pane.removeTabAt(0);

        // Remove it
        assertTrue("removeTabAt incorrect", pane.getTitleAt(0).indexOf("2") != -1);
        assertTrue("removeTabAt incorrect", pane.getTitleAt(1).indexOf("4") != -1);
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the selected index is updated properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy3() throws Exception {
        pane.setSelectedIndex(2);
        pane.removeTabAt(1);
        assertEquals("removeTabAt incorrect", 1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the selected index is updated properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy4() throws Exception {
        pane.setSelectedIndex(2);
        pane.removeTabAt(2);
        assertEquals("removeTabAt incorrect", 2, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the selected index is updated properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy5() throws Exception {
        pane.setSelectedIndex(3);
        pane.removeTabAt(3);
        assertEquals("removeTabAt incorrect", 2, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the selected index is updated properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy6() throws Exception {
        pane.setSelectedIndex(1);
        pane.removeTabAt(3);
        assertEquals("removeTabAt incorrect", 1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Check if the selected index is updated properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtAccuracy7() throws Exception {
        pane.setSelectedIndex(1);
        pane.removeTabAt(0);
        pane.removeTabAt(0);
        pane.removeTabAt(0);
        pane.removeTabAt(0);
        assertEquals("removeTabAt incorrect", -1, pane.getSelectedIndex());
    }

    /**
     * <p>
     * Failure test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Call with negative.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtFailure1() throws Exception {
        try {
            pane.removeTabAt(-1);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>removeTabAt(int index)</code> method.
     * </p>
     * <p>
     * Call when too large.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveTabAtFailure2() throws Exception {
        try {
            pane.removeTabAt(5);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }
}
