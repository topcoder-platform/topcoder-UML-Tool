/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.accuracytests;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.util.config.ConfigManager;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Accuracy Test for ImageExporter.
 *
 * @author smallka
 * @version 1.0
 */
public class ImageExporterAccuracyTest extends TestCase {

    /** A config file for testing. */
    private static final String DEFAULT_CONFIG = "accuracy/AccuracyConfig.xml";

    /** A empty config file for testing. */
    private static final String EMPTY_CONFIG = "accuracy/Empty.xml";

    /** A string representing the location for testing. */
    private static final String LOCATION = "test_files/accuracy/images/";

    /** A string representing the format for testing. */
    private static final String FORMAT = "gif";

    /** An instance of JComponent for testing. */
    private JComponent component;

    /** An instance of Rectangle for testing. */
    private Rectangle viewport;

    /** An instance of OutputStream for testing. */
    private OutputStream output;

    /** An instance of ImageExporter for testing. */
    private ImageExporter exporter;

    /**
     * Sets up the environment.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(DEFAULT_CONFIG);

        component = new JLabel("ImageExporter");

        // make it displayable
        JDialog dialog = new JDialog();
        dialog.add(component);
        dialog.pack();

        component.setSize(200, 200);
        component.setForeground(Color.white);

        viewport = new Rectangle(100, 200);
        exporter = new ImageExporter();
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
     * Tests the constructor with default namespace.
     *
     * @throws Exception to JUnit
     */
    public void testImageExporterDefaultNamespaceAccuracy() throws Exception {
        assertNotNull("fail to construct the instance", exporter);
    }

    /**
     * Tests the constructor with custom namespace.
     *
     * @throws Exception to JUnit
     */
    public void testImageExporterCustomNamespaceAccuracy() throws Exception {
        assertNotNull("fail to construct the instance", new ImageExporter("CustomImageExporter"));
    }

    /**
     * Tests the constructor with empty config.
     *
     * @throws Exception to JUnit
     */
    public void testImageExporterEmptyConfigAccuracy() throws Exception {
        assertNotNull("fail to construct the instance", new ImageExporter("EmptyImageExporter"));
    }

    /**
     * Tests method exportComponent(JComponent, String, String, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy1() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponent1.gif", FORMAT);
    }

    /**
     * Tests method exportComponent(JComponent, Rectangle, String, String, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy2() throws Exception {
        exporter.exportComponent(component, viewport, LOCATION, "exportComponent2.gif", FORMAT);
    }

    /**
     * Tests method exportComponent(List<JComponent>, String, List<String>, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy3() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> filenames = new ArrayList<String>();
        filenames.add("exportComponent3.gif");

        exporter.exportComponent(components, LOCATION, filenames, FORMAT);
    }

    /**
     * Tests method exportComponent(List<JComponent>, Rectangle, String, List<String>, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy4() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> filenames = new ArrayList<String>();
        filenames.add("exportComponent4.gif");

        exporter.exportComponent(components, viewport, LOCATION, filenames, FORMAT);
    }

    /**
     * Tests method exportComponent(JComponent, OutputStream, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy5() throws Exception {
        output = new FileOutputStream(LOCATION + "exportComponent5.gif");

        exporter.exportComponent(component, output, FORMAT);
    }

    /**
     * Tests method exportComponent(JComponent, Rectangle, OutputStream, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy6() throws Exception {
        output = new FileOutputStream(LOCATION + "exportComponent6.gif");

        exporter.exportComponent(component, viewport, output, FORMAT);
    }

    /**
     * Tests method exportComponent(List<JComponent>, String, List<OutputStream>, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy7() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<OutputStream> outputs = new ArrayList<OutputStream>();
        outputs.add(new FileOutputStream(LOCATION + "exportComponent7.gif"));

        exporter.exportComponent(components, outputs, FORMAT);
    }

    /**
     * Tests method exportComponent(List<JComponent>, Rectangle, String, List<OutputStream>, String).
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentAccuracy8() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<OutputStream> outputs = new ArrayList<OutputStream>();
        outputs.add(new FileOutputStream(LOCATION + "exportComponent8.gif"));

        exporter.exportComponent(components, viewport, outputs, FORMAT);
    }

    /**
     * Tests method exportComponent with null Location.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentNullLocationAccuracy() throws Exception {
        exporter.exportComponent(component, null, LOCATION + "exportComponentNullLocation.gif", FORMAT);
    }

    /**
     * Tests method exportComponent with null viewport.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentNullViewportAccuracy() throws Exception {
        exporter.exportComponent(component, null, LOCATION, "exportComponentEmptyViewport.gif", FORMAT);
    }

    /**
     * Tests method exportComponent with jpeg format.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentJpegAccuracy() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponentJpeg.jpeg", "jpeg");
    }

    /**
     * Tests method exportComponent with tiff format.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentTiffAccuracy() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponentTiff.tiff", "tiff");
    }

    /**
     * Tests method exportComponent with bmp format.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentBmpAccuracy() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponentBmp.bmp", "bmp");
    }

    /**
     * Tests method exportComponent with pnm format.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentPnmAccuracy() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponentPnm.pnm", "pnm");
    }

    /**
     * Tests method exportComponent with png format.
     *
     * @throws Exception to JUnit
     */
    public void testExportComponentPngAccuracy() throws Exception {
        exporter.exportComponent(component, LOCATION, "exportComponentPng.png", "png");
    }
}
