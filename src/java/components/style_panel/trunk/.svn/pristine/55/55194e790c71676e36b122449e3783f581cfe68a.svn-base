/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import java.io.File;

import com.topcoder.gui.panels.style.StylePanel;

import junit.framework.TestCase;

import javax.swing.JColorChooser;

import java.awt.Color;

import com.topcoder.gui.panels.style.ColorChooserPanel;

import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 * <p>
 * Stress test case for ColorChooserPanel clas.
 * </p>
 * 
 * @author cmax
 * @version 1.0
 */
public class ColorChooserPanelStressTest extends TestCase {

    /**
     * <p>
     * Represents the smal scale of stress test.
     * </p>
     */
    private final int SMALL = 10;

    /**
     * <p>
     * Represents the middle scale of stress test.
     * </p>
     */
    private final int MIDDLE = 100;

    /**
     * <p>
     * Represents the large scale of stress test.
     * </p>
     */
    private final int LARGE = 1000;

    /**
     * <p>
     * The JColorChooser instance used to contain the ColorChooserPanel.
     * </p>
     */
    private JColorChooser colorChooser;

    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "stresstests" + File.separator
            + "config.xml";

    /**
     * <p>
     * The namespace used for this component.
     * </p>
     */
    public static final String NAMESPACE = StylePanel.class.getName();

    /**
     * <p>
     * Setup test environment.
     * </p>
     * 
     * @throws Exception to JUnit
     *  
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, CONFIG_FILE);
        colorChooser = new JColorChooser(Color.RED);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * 
     * @throws Exception to JUnit
     *  
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(NAMESPACE);
    }

    /**
     * <p>
     * Stress test of the install and build of ColorChooserPanel class.
     * </p>
     *  
     */
    public void testInstallAndBuild() {
        int i;

        ColorChooserPanel panel = new ColorChooserPanel();

        long start = System.currentTimeMillis();

        for (i = 0; i < SMALL; i++) {
            colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {panel});
        }
        
        System.out.println("Install and build " + SMALL + " ColorChooserPanel will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");

        start = System.currentTimeMillis();

        for (i = 0; i < MIDDLE; i++) {
            colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {panel});
        }
        
        System.out.println("Install and build " + MIDDLE + " ColorChooserPanel will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
        
        start = System.currentTimeMillis();

        for (i = 0; i < LARGE; i++) {
            colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {panel});
        }
        
        System.out.println("Install and build " + LARGE + " ColorChooserPanel will cost "
                + (System.currentTimeMillis() - start) + " milliseconds.");
    }

}