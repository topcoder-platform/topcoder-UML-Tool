/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.failuretests;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;
import com.topcoder.swing.imageexporter.ImageExporterException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * Failure test for ImageExporter class.
 *
 * @author iamajia
 * @version 1.0
 */
public class ImageExporterFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ImageExporter imageExporter;

    /**
     * This instance is used in the test.
     */
    private JComponent component;

    /**
     * This instance is used in the test.
     */
    private OutputStream outputStream;

    /**
     * This instance is used in the test.
     */
    private String format = ImageExporter.GIF_FORMAT;

    /**
     * This instance is used in the test.
     */
    private List<JComponent> components = new ArrayList<JComponent>();

    /**
     * This instance is used in the test.
     */
    private List<OutputStream> outputStreams = new ArrayList<OutputStream>();

    /**
     * This instance is used in the test.
     */
    private String fileName = "test_files/failure/images/test.gif";

    /**
     * This instance is used in the test.
     */
    private List<String> fileNames = new ArrayList<String>();

    /**
     * This instance is used in the test.
     */
    private String location = null;

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle viewport;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.loadSingleXMLConfig("failure/config.xml");
        imageExporter = new ImageExporter();
        FailureTestHelper.clearConfigFile();
        component = new JLabel("FailureTest");
        component.setSize(10, 10);
        outputStream = new FileOutputStream(new File(fileName));
        components.add(component);
        outputStreams.add(outputStream);
        fileNames.add(fileName);
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
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ImageExporterFailureTest.class);
    }

    /**
     * <p>
     * Failure test of ImageExporter#ImageExporter(String).
     * </p>
     * <p>
     * namespace is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testImageExporter_null_namespace() throws Exception {
        try {
            new ImageExporter(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#ImageExporter(String).
     * </p>
     * <p>
     * namespace is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testImageExporter_empty_namespace() throws Exception {
        try {
            new ImageExporter("    ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#ImageExporter(String).
     * </p>
     * <p>
     * namespace is not exist.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testImageExporter_not_exist_namespace() throws Exception {
        try {
            new ImageExporter("not_exist");
            fail("ImageExporterConfigurationException expected.");
        } catch (ImageExporterConfigurationException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,OutputStream,String).
     * </p>
     * <p>
     * component is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent1Failure_null_component() throws Exception {
        try {
            imageExporter.exportComponent(null, outputStream, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,OutputStream,String).
     * </p>
     * <p>
     * outputStream is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent1Failure_null_outputStream() throws Exception {
        try {
            imageExporter.exportComponent(component, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,OutputStream,String).
     * </p>
     * <p>
     * format is null
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent1Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(component, outputStream, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,OutputStream,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent1Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(component, outputStream, "  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,OutputStream,String).
     * </p>
     * <p>
     * outputStream is closed.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent1Failure_other_error() throws Exception {
        outputStream.close();
        try {
            imageExporter.exportComponent(component, outputStream, format);
            fail("ImageExporterException expected.");
        } catch (ImageExporterException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * components is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_null_components() throws Exception {
        try {
            imageExporter.exportComponent(null, viewport, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * components contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_components_contains_null() throws Exception {
        components.set(0, null);
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * outputStreams is nul.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_null_outputStreams() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * outputStreams contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_outputStreams_contains_null() throws Exception {
        outputStreams.set(0, null);
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * format is not exist.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_not_exist_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, "Failure");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * list size is different.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_list_size_different() throws Exception {
        outputStreams.add(outputStream);
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,List,String).
     * </p>
     * <p>
     * outputStream is closed
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent2Failure_other_error() throws Exception {
        outputStream.close();
        try {
            imageExporter.exportComponent(components, viewport, outputStreams, format);
            fail("ImageExporterException expected.");
        } catch (ImageExporterException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,String,String,String).
     * </p>
     * <p>
     * component is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent3Failure_null_component() throws Exception {
        try {
            imageExporter.exportComponent(null, location, fileName, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,String,String,String).
     * </p>
     * <p>
     * fileName is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent3Failure_null_fileName() throws Exception {
        try {
            imageExporter.exportComponent(component, location, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,String,String,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent3Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(component, location, fileName, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,String,String,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent3Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(component, location, fileName, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,String,String,String).
     * </p>
     * <p>
     * component is null
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent4Failure_null_component() throws Exception {
        try {
            imageExporter.exportComponent(null, viewport, location, fileName, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,String,String,String).
     * </p>
     * <p>
     * fileName is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent4Failure_null_fileName() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, location, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,String,String,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent4Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, location, fileName, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,String,String,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent4Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, location, fileName, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * components is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_null_components() throws Exception {
        try {
            imageExporter.exportComponent(null, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * components contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_components_contains_null() throws Exception {
        components.set(0, null);
        try {
            imageExporter.exportComponent(components, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * fileNames is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_null_fileNames() throws Exception {
        try {
            imageExporter.exportComponent(components, location, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * fileNames contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_fileNames_contains_null() throws Exception {
        fileNames.set(0, null);
        try {
            imageExporter.exportComponent(components, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(components, location, fileNames, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(components, location, fileNames, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,String,List,String).
     * </p>
     * <p>
     * list size are different.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent5Failure_list_size_different() throws Exception {
        components.add(component);
        try {
            imageExporter.exportComponent(components, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * components is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_null_components() throws Exception {
        try {
            imageExporter.exportComponent(null, viewport, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * components contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_components_contains_null() throws Exception {
        components.set(0, null);
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * fileNames is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_null_fileNames() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, location, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * fileNames contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_fileNames_contains_null() throws Exception {
        fileNames.set(0, null);
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * format is not exist.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_not_exist_format() throws Exception {
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, "Failure");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(List,Rectangle,String,List,String).
     * </p>
     * <p>
     * list size are defferent.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent6Failure_list_size_different() throws Exception {
        components.add(component);
        try {
            imageExporter.exportComponent(components, viewport, location, fileNames, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * component is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_null_component() throws Exception {
        try {
            imageExporter.exportComponent(null, viewport, outputStream, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * outputStream is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_null_outputStream() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, outputStream, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, outputStream, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * format is not exist.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_not_exist_format() throws Exception {
        try {
            imageExporter.exportComponent(component, viewport, outputStream, "Failure");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of
     * ImageExporter#exportComponent(JComponent,Rectangle,OutputStream,String).
     * </p>
     * <p>
     * outputStream is closed.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent7Failure_other_error() throws Exception {
        outputStream.close();
        try {
            imageExporter.exportComponent(component, viewport, outputStream, format);
            fail("ImageExporterException expected.");
        } catch (ImageExporterException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * components is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_null_components() throws Exception {
        try {
            imageExporter.exportComponent(null, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * components contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_components_contains_null() throws Exception {
        components.set(0, null);
        try {
            imageExporter.exportComponent(components, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * outputStreams is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_null_outputStreams() throws Exception {
        try {
            imageExporter.exportComponent(components, null, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * outputStreams contains null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_outputStreams_contains_null() throws Exception {
        outputStreams.set(0, null);
        try {
            imageExporter.exportComponent(components, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * format is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_null_format() throws Exception {
        try {
            imageExporter.exportComponent(components, outputStreams, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * format is empty.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_empty_format() throws Exception {
        try {
            imageExporter.exportComponent(components, outputStreams, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * list size is differenct.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_list_size_different() throws Exception {
        components.add(component);
        try {
            imageExporter.exportComponent(components, outputStreams, format);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // expect.
        }
    }

    /**
     * <p>
     * Failure test of ImageExporter#exportComponent(List,List,String).
     * </p>
     * <p>
     * outputStream is closed.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testExportComponent8Failure_other_error() throws Exception {
        outputStream.close();
        try {
            imageExporter.exportComponent(components, outputStreams, format);
            fail("ImageExporterException expected.");
        } catch (ImageExporterException e) {
            // expect.
        }
    }

}