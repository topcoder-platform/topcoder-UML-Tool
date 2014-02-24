/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.accuracytests;

import com.topcoder.swing.imageexporter.ImageManipulationImageExporter;
import com.topcoder.util.config.ConfigManager;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import junit.framework.TestCase;

/**
 * Accuracy Test for ImageManipulationImageExporter.
 *
 * @author smallka
 * @version 1.0
 */
public class ImageManipulationImageExporterAccuracyTest extends TestCase {

    /** A config file for testing. */
    private static final String DEFAULT_CONFIG = "accuracy/AccuracyConfig.xml";

    /** A empty config file for testing. */
    private static final String EMPTY_CONFIG = "accuracy/Empty.xml";

    /** An instance of JComponent for testing. */
    private JComponent component;

    /** An instance of Rectangle for testing. */
    private Rectangle viewport;

    /** An instance of OutputStream for testing. */
    private OutputStream output;

    /** The directory of image file to be stored. */
    private static final String DIR = "test_files/accuracy/images/";

    /** An instance of ImageManipulationImageExporter for testing. */
    private ImageManipulationImageExporter exporter;

    /**
     * Sets up the environment.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(DEFAULT_CONFIG);

        component = new JLabel("ImageManipulationImageExporter");

        // make it displayable
        JDialog dialog = new JDialog();
        dialog.add(component);
        dialog.pack();

        component.setSize(200, 200);
        component.setForeground(Color.white);

        viewport = new Rectangle(100, 200);
        exporter = new ImageManipulationImageExporter();
    }

    /**
     * Clears the environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }

        if (output != null) {
            output.close();
        }
    }

    /**
     * Tests the constructor.
     *
     * @throws Exception to JUnit
     */
    public void testImageManipulationImageExporterAccuracy() throws Exception {
        assertNotNull("fail to construct the instance", exporter);
    }

    /**
     * Tests the constructor with empty config.
     *
     * @throws Exception to JUnit
     */
    public void testImageManipulationImageExporterEmptyConfigAccuracy() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.removeNamespace("ImageManipulationImageExporterProperties");
        cm.add(EMPTY_CONFIG);

        exporter = new ImageManipulationImageExporter();
        assertNotNull("fail to construct the instance", exporter);
        assertEquals("incorrect number of formats", 6, exporter.getSupportedFormats().length);
    }

    /**
     * Tests method getSupportedFormats.
     */
    public void testGetSupportedFormatsAccuracy() {
        String[] expecteds = {"jpeg", "gif", "tiff", "bmp", "pnm", "png", "my_format"};
        String[] formats = exporter.getSupportedFormats();
        assertEquals("incorrect number of formats", expecteds.length, formats.length);
        for (int i = 0; i < expecteds.length; i++) {
            int j = 0;
            while (j < formats.length && !formats[j].equals(expecteds[i])) {
                j++;
            }
            if (j == formats.length) {
                fail(expecteds[i] + " format is missing");
            }
        }
    }

    /**
     * Tests method export.
     *
     * @throws Exception to JUnit
     */
    public void testExportAccuracy() throws Exception {
        output = new FileOutputStream(DIR + "export_with_viewport.gif");
        exporter.export(component, output, viewport, "gif");
    }

    /**
     * Tests method export with null viewport.
     *
     * @throws Exception to JUnit
     */
    public void testExportNullViewportAccuracy() throws Exception {
        output = new FileOutputStream(DIR + "export_without_viewport.gif");
        exporter.export(component, output, null, "gif");
    }
}