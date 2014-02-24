/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.failuretests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;
import com.topcoder.swing.imageexporter.ImageExporterException;
import com.topcoder.swing.imageexporter.ImageManipulationImageExporter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for ImageManipulationImageExporter class.
 *
 * @author iamajia
 * @version 1.0
 */
public class ImageManipulationImageExporterFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ImageManipulationImageExporter imageManipulationImageExporter;

    /**
     * This instance is used in the test.
     */
    private JComponent component;

    /**
     * This instance is used in the test.
     */
    private OutputStream outputStream;

    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ImageManipulationImageExporterFailureTest.class);
    }

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        FailureTestHelper.loadSingleXMLConfig("failure/config.xml");
        imageManipulationImageExporter = new ImageManipulationImageExporter();
        FailureTestHelper.clearConfigFile();
        component = new JLabel("FailureTest");
        component.setSize(10, 10);
        outputStream = new FileOutputStream(new File("test_files/failure/images/test.gif"));
    }

    /**
     * Tears down the environment for the TestCase.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.clearConfigFile();
        outputStream.close();
    }

    /**
     * Failure test of <code>ImageManipulationImageExporter()</code>
     * constructor.
     * <p>
     * namespace is not exist.
     * </p>
     * <p>
     * Expect ImageExporterConfigurationException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testImageManipulationImageExporterFailure_no_namespace() throws Exception {
        try {
            new ImageManipulationImageExporter();
            fail("Expect ImageExporterConfigurationException.");
        } catch (ImageExporterConfigurationException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * component is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_null_component() throws Exception {
        try {
            imageManipulationImageExporter.export(null, outputStream, null,
                ImageManipulationImageExporter.BMP_FORMAT);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * outputStream is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_null_outputstream() throws Exception {
        try {
            imageManipulationImageExporter
                .export(component, null, null, ImageManipulationImageExporter.BMP_FORMAT);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * format is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_null_format() throws Exception {
        try {
            imageManipulationImageExporter.export(component, outputStream, null, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * format is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_empty_format() throws Exception {
        try {
            imageManipulationImageExporter.export(component, outputStream, null, "  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * format is invalid
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_invalid_format() throws Exception {
        try {
            imageManipulationImageExporter.export(component, outputStream, null, "Failure");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)</code>
     * method.
     * <p>
     * outputStream is closed.
     * </p>
     * <p>
     * Expect ImageExporterException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testExportFailure_other_error() throws Exception {
        outputStream.close();
        try {
            imageManipulationImageExporter.export(component, outputStream, null,
                ImageManipulationImageExporter.BMP_FORMAT);
            fail("Expect ImageExporterException.");
        } catch (ImageExporterException e) {
            // expect
        }
    }
}
