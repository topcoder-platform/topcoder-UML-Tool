/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;

import java.awt.Rectangle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * Test case for {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}. This
 * test case covers the accuray and failure tests for only export().
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageManipulationImageExporterExportTest extends TestCase {
    /** Default config file used in this test. */
    private static final String CONFIG = "ImageManipulationImageExporter.xml";

    /** Default output directory. */
    private static final String OUTPUT_DIR = TestHelper.getOutputPath();

    /** Default exporter used in this test. */
    private ImageManipulationImageExporter exporter;

    /** Default JFrame used in this test. */
    private PrintFrame jframe;

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with empty string format and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportEmptyFormat() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = " ";

        try {
            exporter.export(jframe.getPrintingComponent(), os, viewport, format);
            fail("format is trimmed empty string and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with not supported format and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportIllegalFormat() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = "not_existent_format";

        try {
            exporter.export(jframe.getPrintingComponent(), os, viewport, format);
            fail("format does not exist component area and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with viewport that larger then the component and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportIllegalViewport() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 500, 10);
        String format = "bmp";

        try {
            exporter.export(jframe.getPrintingComponent(), os, viewport, format);
            fail("viewport is not inside component area and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with a not displayable component and ImageExporterException is expected.
     *
     * @throws Exception to junit
     */
    public void testExportNotDisplayableComponent() throws Exception {
        JComponent component = new JPanel();
        assertFalse("component should be not displayable", component.isDisplayable());

        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = "bmp";

        try {
            exporter.export(component, os, viewport, format);
            fail("component is not displayable and ImageExporterException is expected");
        } catch (ImageExporterException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with null component and IllegalArgumentException is expected.
     *
     * @throws Exception to junit
     */
    public void testExportNullComponent() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = "bmp";

        try {
            exporter.export(null, os, viewport, format);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with null format and IllegalArgumentException is expected.
     *
     * @throws Exception to junit
     */
    public void testExportNullFormat() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = null;

        try {
            exporter.export(jframe.getPrintingComponent(), os, viewport, format);
            fail("format is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle, String)}, given
     * with null outputstream and IllegalArgumentException is expected.
     *
     * @throws Exception to junit
     */
    public void testExportNullOutputStream() throws Exception {
        OutputStream os = null;
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        String format = "bmp";

        try {
            exporter.export(jframe.getPrintingComponent(), os, viewport, format);
            fail("outputStream is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test accuracy of {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle,
     * String)}. It will export the component within the given viewport with all supported formats, results will also
     * be generated so that the accuracy of the exporting can be observed.
     *
     * @throws Exception to junit
     */
    public void testExport_with_viewport() throws Exception {
        String filename = "ImageManipulationImageExporterExportTest_testExport_with_viewport";
        String[] formats = exporter.getSupportedFormats();
        Rectangle viewport = new Rectangle(59, 54, 41, 22);

        for (int i = 0; i < formats.length; i++) {
            String file = OUTPUT_DIR + filename + "." + formats[i];
            OutputStream os = new FileOutputStream(new File(file));
            exporter.export(jframe.getPrintingComponent(), os, viewport, formats[i]);
            os.close();
            System.out.println("exported component to :" + file + " success");
        }
    }

    /**
     * Test accuracy of {@link ImageManipulationImageExporter#export(JComponent, OutputStream, Rectangle,
     * String)}. It will export the component without any viewport with all supported formats, results will also be
     * generated so that the accuracy of the exporting can be observed.
     *
     * @throws Exception to junit
     */
    public void testExport_without_viewport() throws Exception {
        String filename = "ImageManipulationImageExporterExportTest_testExport_without_viewport";
        String[] formats = exporter.getSupportedFormats();

        for (int i = 0; i < formats.length; i++) {
            String file = OUTPUT_DIR + filename + "." + formats[i];
            OutputStream os = new FileOutputStream(new File(file));
            exporter.export(jframe.getPrintingComponent(), os, null, formats[i]);
            os.close();
            System.out.println("exported component to :" + file + " success");
        }
    }

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig(CONFIG); //load config file
        TestHelper.backupConfig(CONFIG); //back config file preventing it from being modified during the test

        exporter = new ImageManipulationImageExporter();
        jframe = new PrintFrame(400, 400, "abcdefghijklmn", true);
    }

    /**
     * Clears test environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig(); //clear all config
        TestHelper.restoreConfig(CONFIG); //restore the backup config file
        jframe.dispose();
    }
}
