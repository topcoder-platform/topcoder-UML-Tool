/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.stresstests;

import com.topcoder.swing.imageexporter.ImageExporter;

import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/**
 * <p>The stress tests for ImageExporter class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StressTestImageExporter extends TestCase {
    /** The path of files used in the stress test. */
    private static final String PATH = "test_files/stresstests";

    /** The instance of ImageExporter used for stress test. */
    private ImageExporter imageExporter;

    /** The instance of JComponent used for stress test. */
    private JComponent component;

    /**
     * Set up the test environment.
     *
     * @throws Exception to JUnit.
     */
    public void setUp() throws Exception {
        clearNamespaces();

        ConfigManager.getInstance().add("stresstests/config.xml");

        imageExporter = new ImageExporter();

        component = buildLargeComponent();
    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception to JUnit.
     */
    public void tearDown() throws Exception {
        clearNamespaces();
    }

    /**
     * Removes all namespaces in the config manager.
     *
     * @throws Exception to Junit.
     */
    private void clearNamespaces() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        Iterator iter = cm.getAllNamespaces();

        while (iter.hasNext()) {
            cm.removeNamespace((String) iter.next());
        }
    }

    /**
     * Tests exporting a large component to different image files.
     *
     * @throws Exception to Junit.
     */
    public void testExportLargeComponent() throws Exception {
        long timeStart = 0;
        long timeEnd = 0;

        System.out.println("Tests exporting a large component to different image files.");

        timeStart = System.currentTimeMillis();

        imageExporter.exportComponent(component, PATH, "image.bmp", ImageExporter.BMP_FORMAT);
        imageExporter.exportComponent(component, PATH, "image.gif", ImageExporter.GIF_FORMAT);
        imageExporter.exportComponent(component, PATH, "image.jpg", ImageExporter.JPEG_FORMAT);
        imageExporter.exportComponent(component, PATH, "image.png", ImageExporter.PNG_FORMAT);
        imageExporter.exportComponent(component, PATH, "image.pnm", ImageExporter.PNM_FORMAT);
        imageExporter.exportComponent(component, PATH, "image.tiff", ImageExporter.TIFF_FORMAT);

        timeEnd = System.currentTimeMillis();

        System.out.println(" ---- Operation took " + (timeEnd - timeStart) + " ms.");

        // validate the image files
        validateFile(PATH, "image.bmp");
        validateFile(PATH, "image.gif");
        validateFile(PATH, "image.jpg");
        validateFile(PATH, "image.png");
        validateFile(PATH, "image.pnm");
        validateFile(PATH, "image.tiff");

        // remove all image files
        new File(PATH + File.separator + "image.bmp").delete();
        new File(PATH + File.separator + "image.gif").delete();
        new File(PATH + File.separator + "image.jpg").delete();
        new File(PATH + File.separator + "image.png").delete();
        new File(PATH + File.separator + "image.pnm").delete();
        new File(PATH + File.separator + "image.tiff").delete();
    }

    /**
     * Tests exporting many components to image files.
     *
     * @throws Exception to Junit.
     */
    public void testExportNumerousComponentsToFiles() throws Exception {
        final int repeatTimes = 100;

        List<JComponent> components = new ArrayList<JComponent>();
        List<String> filenames = new ArrayList<String>();

        for (int i = 0; i < repeatTimes; i++) {
            components.add(buildSmallComponent("Label" + i));
            filenames.add("image" + i + ".bmp");
        }

        long timeStart = 0;
        long timeEnd = 0;

        System.out.println("Tests exporting many components to image files.");

        timeStart = System.currentTimeMillis();

        imageExporter.exportComponent(components, PATH, filenames, ImageExporter.BMP_FORMAT);

        timeEnd = System.currentTimeMillis();

        System.out.println(" ---- Operation took " + (timeEnd - timeStart) + " ms.");

        for (int i = 0; i < repeatTimes; i++) {
            // validate the image file
            validateFile(PATH, "image" + i + ".bmp");

            // remove the image file
            new File(PATH + File.separator + "image" + i + ".bmp").delete();
        }
    }

    /**
     * Tests exporting many components to output streams.
     *
     * @throws Exception to Junit.
     */
    public void testExportNumerousComponentsToOutputStream()
        throws Exception {
        final int repeatTimes = 100;

        List<JComponent> components = new ArrayList<JComponent>();
        List<OutputStream> streams = new ArrayList<OutputStream>();

        for (int i = 0; i < repeatTimes; i++) {
            components.add(buildSmallComponent("Label" + i));
            streams.add(new FileOutputStream(PATH + File.separator + "image" + i + ".gif"));
        }

        long timeStart = 0;
        long timeEnd = 0;

        System.out.println("Tests exporting many components to output streams.");

        timeStart = System.currentTimeMillis();

        imageExporter.exportComponent(components, streams, ImageExporter.GIF_FORMAT);

        timeEnd = System.currentTimeMillis();

        System.out.println(" ---- Operation took " + (timeEnd - timeStart) + " ms.");

        for (OutputStream stream : streams) {
            stream.close();
        }

        for (int i = 0; i < repeatTimes; i++) {
            // validate the image file
            validateFile(PATH, "image" + i + ".gif");

            // remove the image file
            new File(PATH + File.separator + "image" + i + ".gif").delete();
        }
    }

    /**
     * Tests exporting a large components to image files with different viewpoints.
     *
     * @throws Exception to Junit.
     */
    public void testExportComponentsWithDifferentViewpoints()
        throws Exception {
        final int repeatTimes = 100;
        final int step = 5;

        long timeStart = 0;
        long timeEnd = 0;

        System.out.println("Tests exporting a large components to image files with different viewpoints.");

        timeStart = System.currentTimeMillis();

        for (int i = 0; i < repeatTimes; i++) {
            int size = step * (i + 1);

            imageExporter.exportComponent(component, new Rectangle(size, size), PATH, "image" + i + ".jpg",
                ImageExporter.JPEG_FORMAT);
        }

        timeEnd = System.currentTimeMillis();

        System.out.println(" ---- Operation took " + (timeEnd - timeStart) + " ms.");

        for (int i = 0; i < repeatTimes; i++) {
            // validate the image file
            validateFile(PATH, "image" + i + ".jpg");

            // remove the image file
            new File(PATH + File.separator + "image" + i + ".jpg").delete();
        }
    }

    /**
     * Validates the output image file. The file should exist and not be 0 length.
     *
     * @param path the path of the image file.
     * @param name the name of the image file.
     */
    private void validateFile(String path, String name) {
        File file = new File(PATH + File.separator + name);

        assertTrue("invalid file", file.exists());
        assertTrue("invalid flle length", file.length() > 0);
    }

    /**
     * Creates a large JComponent object which contains other JComponent objects.
     *
     * @return JComponent a large JComponent which contains other JComponent objects.
     */
    private JComponent buildLargeComponent() {
        final int total = 100;
        final int rows = 10;
        final int cols = 10;

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(2, 2));

        // create a labels panel
        JPanel labelPanel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < total; i++) {
            JLabel label = new JLabel("Label" + i);

            label.setBackground(Color.lightGray);
            label.setBorder(BorderFactory.createEtchedBorder());
            label.setOpaque(true);

            labelPanel.add(label);
        }

        // create a buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < total; i++) {
            buttonPanel.add(new JButton("Button" + i));
        }

        // create a radios panel
        JPanel radioPanel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < total; i++) {
            radioPanel.add(new JRadioButton("Radio" + i));
        }

        // create a checkboxs panel
        JPanel checkBoxPanel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < total; i++) {
            checkBoxPanel.add(new JCheckBox("CheckBox" + i));
        }

        // add the labels, buttons, radios and checkbox panel
        panel.add(labelPanel);
        panel.add(buttonPanel);
        panel.add(radioPanel);
        panel.add(checkBoxPanel);

        // set the panel visible
        panel.setVisible(true);

        // create a dialog
        JDialog dialog = new JDialog();

        // add the panel to the dialog
        dialog.add(panel);

        // pack the dialog
        dialog.pack();

        return panel;
    }

    /**
     * Creates a small JComponent object.
     *
     * @param text the text of the label.
     *
     * @return JComponent a small JComponent.
     */
    private JComponent buildSmallComponent(String text) {
        JLabel label = new JLabel(text);

        label.setBackground(Color.lightGray);
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setOpaque(true);

        // set the label visible
        label.setVisible(true);

        // create a dialog
        JDialog dialog = new JDialog();

        // add the label to the dialog
        dialog.add(label);

        // pack the dialog
        dialog.pack();

        return label;
    }
}
