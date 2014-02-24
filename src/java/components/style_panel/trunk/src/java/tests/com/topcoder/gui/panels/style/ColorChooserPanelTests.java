/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.ComponentFinder;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ColorChooserPanel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ColorChooserPanelTests extends JFCTestCase {
    /**
     * <p>
     * ColorChooserPanel instance for testing.
     * </p>
     *
     * <p>
     * Note, this instance is created without namespace
     * </p>
     */
    private ColorChooserPanel panel;

    /**
     * <p>
     * ColorChooserPanel instance for testing.
     * </p>
     *
     * <p>
     * Note, this instance is created with namespace
     * </p>
     */
    private ColorChooserPanel configedPanel;

    /**
     * <p>
     * The color button used in the ColorChooserPanel.
     * </p>
     */
    private JButton colorButton;

    /**
     * <p>
     * The color text field used in the ColorChooserPanel.
     * </p>
     */
    private JTextField colorTextField;

    /**
     * <p>
     * The color palette panel used in the ColorChooserPanel.
     * </p>
     */
    private ColorPalettePanel palette;

    /**
     * <p>
     * The JColorChooser instance used to contain the ColorChooserPanel.
     * </p>
     */
    private JColorChooser colorChooser;

    /**
     * <p>
     * The JFrame instance used to show to the JColorChooser instance.
     * </p>
     */
    private JFrame frame;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        this.setHelper(new JFCTestHelper());

        colorChooser = new JColorChooser(Color.RED);

        frame = new JFrame();

        panel = new ColorChooserPanel();
        configedPanel = new ColorChooserPanel(TestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        frame.setVisible(false);
        frame = null;
        colorChooser = null;
        colorButton = null;
        colorTextField = null;
        palette = null;

        panel = null;
        configedPanel = null;

        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        flushAWT();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ColorChooserPanelTests.class);
    }

    /**
     * <p>
     * Tests ctor ColorChooserPanel#ColorChooserPanel(String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ColorChooserPanel instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ColorChooserPanel instance.", configedPanel);
    }

    /**
     * <p>
     * Tests ctor ColorChooserPanel#ColorChooserPanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new ColorChooserPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorChooserPanel#ColorChooserPanel(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyNamespace() {
        try {
            new ColorChooserPanel(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ColorChooserPanel#ColorChooserPanel() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created ColorChooserPanel instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ColorChooserPanel instance.", panel);
    }

    /**
     * <p>
     * Tests ColorChooserPanel#installChooserPanel(JColorChooser) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#installChooserPanel(JColorChooser) is correct.
     * </p>
     */
    public void testInstallChooserPanel() {
        // The installChooserPanel() is invoked.
        setUpColorChooserPanel(panel);

        // The color change listener should be installed
        colorChooser.setColor(Color.BLACK);
        assertEquals("The current color should be BLACK.", Color.BLACK, this.colorButton.getBackground());
        assertEquals("The current color should be BLACK.", "#000000", this.colorTextField.getText());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#installChooserPanel(JColorChooser) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the color chooser panel has been installed and
     * expects RuntimeException.
     * </p>
     */
    public void testInstallChooserPanel_RuntimeException() {
        setUpColorChooserPanel(panel);

        try {
            // call the installChooserPanel() method again indirectly
            colorChooser.addChooserPanel(panel);

            fail("RuntimeException expected.");
        } catch (RuntimeException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorChooserPanel#uninstallChooserPanel(JColorChooser) for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#uninstallChooserPanel(JColorChooser) is correct.
     * </p>
     */
    public void testUninstallChooserPanel() {
        // The installChooserPanel() is invoked.
        setUpColorChooserPanel(panel);

        colorChooser.removeChooserPanel(panel);

        assertEquals("All the components should be removed.", 0, panel.getComponentCount());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#buildChooser() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#buildChooser() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBuildChooser() throws Exception {
        // buildChooser() method is invoked
        setUpColorChooserPanel(panel);

        // verify the color button
        assertNotNull("The color button should be located.", this.colorButton);
        assertEquals("The current color should be RED.", Color.RED, this.colorButton.getBackground());

        // verify the color text field
        assertNotNull("The color text field should be located.", this.colorTextField);
        assertEquals("The current color should be RED.", "#FF0000", this.colorTextField.getText());

        // verify the palette widget
        assertNotNull("The palette should be located.", this.palette);
        assertEquals("Failed to get correct accessible name.", "ColorChooserPanel",
            palette.getAccessibleContext().getAccessibleName());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#buildChooser() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#buildChooser() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBuildChooserWithNamespace() throws Exception {
        // buildChooser() method is invoked
        setUpColorChooserPanel(configedPanel);

        // verify the color button
        assertNotNull("The color button should be located.", this.colorButton);
        assertEquals("The current color should be RED.", Color.RED, this.colorButton.getBackground());

        // verify the color text field
        assertNotNull("The color text field should be located.", this.colorTextField);
        assertEquals("The current color should be RED.", "#FF0000", this.colorTextField.getText());

        // verify the palette widget
        assertNotNull("The palette should be located.", this.palette);
        assertEquals("Failed to get correct accessible name.", "ColorChooserPanel",
            palette.getAccessibleContext().getAccessibleName());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#buildChooser() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is not configed and expects StylePanelConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBuildChooserWithNamespaceNotConfiged() throws Exception {
        TestHelper.clearConfigFile(TestHelper.NAMESPACE);

        try {
            // buildChooser() method is invoked
            colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {
                configedPanel
            });

            fail("StylePanelConfigurationException expected.");
        } catch (StylePanelConfigurationException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests ColorChooserPanel#updateChooser() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#updateChooser() is correct.
     * </p>
     */
    public void testUpdateChooser() {
        panel.updateChooser();

        // The current implementation of updateChooser() is empty, so no assertion here.
    }

    /**
     * <p>
     * Tests ColorChooserPanel#getDisplayName() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#getDisplayName() is correct.
     * </p>
     */
    public void testGetDisplayName() {
        assertEquals("The display name should be ColorChooserPanel.", "ColorChooserPanel", panel.getDisplayName());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#getSmallDisplayIcon() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#getSmallDisplayIcon() is correct.
     * </p>
     */
    public void testGetSmallDisplayIcon() {
        assertNull("Expects null large display icon.", panel.getSmallDisplayIcon());
    }

    /**
     * <p>
     * Tests ColorChooserPanel#getLargeDisplayIcon() for accuracy.
     * </p>
     *
     * <p>
     * Verify : ColorChooserPanel#getLargeDisplayIcon() is correct.
     * </p>
     */
    public void testGetLargeDisplayIcon() {
        assertNull("Expects null large display icon.", panel.getLargeDisplayIcon());
    }

    /**
     * <p>
     * Tests MainSwatchListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The frame should be hidden, the color button and color text file should be set
     * to the correct color.
     * </p>
     */
    public void testMousePressEventForPalette() {
        setUpColorChooserPanel(panel);

        EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

        // click the (2, 1) palette
        MouseEvent pevent = new MouseEvent(palette, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent revent = new MouseEvent(palette, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        eq.postEvent(pevent);
        eq.postEvent(revent);
        flushAWT();

        assertFalse("The frame should be hidden.", frame.isVisible());
        assertEquals("The current color should be (204, 204, 204).", new Color(204, 204, 204),
            this.colorButton.getBackground());
        assertEquals("The current color should be (204, 204, 204).", "#CCCCCC", this.colorTextField.getText());
    }

    /**
     * <p>
     * Tests MainSwatchListener#mouseMoved(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The color button and color text file should be set to the correct color.
     * </p>
     */
    public void testMouseMoveEventForPalette() {
        setUpColorChooserPanel(panel);

        EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

        // Move the mouse to the (1, 2) palette
        MouseEvent event = new MouseEvent(palette, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, 15, 5, 0,
            false);
        eq.postEvent(event);
        flushAWT();

        assertEquals("The current color should be (204, 255, 255).", new Color(204, 255, 255),
            this.colorButton.getBackground());
        assertEquals("The current color should be (204, 255, 255).", "#CCFFFF", this.colorTextField.getText());
    }

    /**
     * <p>
     * Install the ColorChooserPanel instance to a JColorChooser instance.
     * So the installChooserPanel() and buildChooser() methods of ColorChooserPanel
     * is invoked indirectly.
     * </p>
     *
     * <p>
     * This method also use the functionality of the JFCUnit to find the color button,
     * color text field and palette widgets from the ColorChooserPanel widget.
     * </p>
     *
     * @param panel the ColorChooserPanel instance
     */
    private void setUpColorChooserPanel(ColorChooserPanel panel) {
        colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {
            panel
        });

        // The frame is used to contain the color chooser and show it
        frame.getContentPane().add(colorChooser);
        frame.pack();
        frame.setVisible(true);

        // locate the widgets in color chooser panel
        this.colorButton = (JButton) new ComponentFinder(JButton.class).find(panel, 0);
        this.colorTextField = (JTextField) new ComponentFinder(JTextField.class).find(panel, 0);
        this.palette = (ColorPalettePanel) new ComponentFinder(ColorPalettePanel.class).find(panel, 0);

        flushAWT();
    }
}