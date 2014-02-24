/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.accuracytests;

import javax.swing.Icon;
import javax.swing.JColorChooser;

import junit.framework.TestCase;

import com.topcoder.gui.panels.style.ColorChooserPanel;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.*;

/**
 * Unit test for <code>ColorChooserPanel</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ColorChooserPanelTests extends TestCase {
    /**
     * Represents the ColorChooserPanel panel used for test.
     */
    private ColorChooserPanel panel = null;

    /**
     * Represents the String namespace used for test.
     */
    private String namespace = NAMESPACE;

    /**
     * Represents the JColorChooser enclosingChooser used for test.
     */
    private JColorChooser enclosingChooser = null;

    /**
     * Set up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        panel = new ColorChooserPanel();
        enclosingChooser = new JColorChooser();
    }

    /**
     * Tear down the test environment.
     * 
     * @throws Exception
     *             if any error occurred when tear down
     */
    public void tearDown() throws Exception {
    }

    /**
     * Accuracy test for the Constructor <code>ColorChooserPanel()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testColorChooserPanelAccuracy() throws Exception {
        ColorChooserPanel panel1 = new ColorChooserPanel();
        // verify
        assertNotNull("the object should be created", panel1);
    }

    /**
     * Accuracy test for the Constructor <code>ColorChooserPanel(String namespace)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testColorChooserPanelStringAccuracy() throws Exception {
        ColorChooserPanel panel1 = new ColorChooserPanel(namespace);
        // verify
        assertNotNull("the object should be created", panel1);
    }

    /**
     * Accuracy test for the Method <code>String getDisplayName()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetDisplayNameAccuracy() throws Exception {
        // verify
        assertEquals("the value is wrong", "ColorChooserPanel", panel.getDisplayName());
    }

    /**
     * Accuracy test for the Method <code>Icon getSmallDisplayIcon()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetSmallDisplayIconAccuracy() throws Exception {
        // verify
        assertNull(panel.getSmallDisplayIcon());
    }

    /**
     * Accuracy test for the Method <code>Icon getLargeDisplayIcon()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetLargeDisplayIconAccuracy() throws Exception {
        Icon icon1 = panel.getLargeDisplayIcon();
        // verify
        assertNull("the value is wrong", icon1);
    }

    /**
     * Accuracy test for the Method
     * <code>void installChooserPanel(JColorChooser enclosingChooser)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testInstallChooserPanelJColorChooserAccuracy() throws Exception {
        panel.installChooserPanel(enclosingChooser);
    }

    /**
     * Accuracy test for the Method <code>void buildChooser()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testBuildChooserAccuracy() throws Exception {
        panel.installChooserPanel(enclosingChooser);
        panel.buildChooser();
    }

    /**
     * Accuracy test for the Method
     * <code>void uninstallChooserPanel(JColorChooser enclosingChooser)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testUninstallChooserPanelJColorChooserAccuracy() throws Exception {
        panel.installChooserPanel(enclosingChooser);
        panel.uninstallChooserPanel(enclosingChooser);
    }

    /**
     * Accuracy test for the Method <code>void updateChooser()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testUpdateChooserAccuracy() throws Exception {
        panel.updateChooser();
    }

}
