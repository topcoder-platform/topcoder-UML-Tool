/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;

import java.awt.Rectangle;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


/**
 * Test case for ImageExporter#exportComponent(...)}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporterExportTest extends TestCase {
    /** Default config file used in this test. */
    private static final String CONFIG = "ImageExporter.xml";

    /** Default namespace for exporter. */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.swing.imageexporter";

    /** Default output directory. */
    private static final String OUTPUT_DIR = TestHelper.getOutputPath();

    /** Default ImageExporter instance used in this test. */
    private ImageExporter exporter;

    /** Default JFrame used in this test. */
    private PrintFrame jframe;

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. components is empty and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentEmptyListOfJComponentStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();

        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("components contains null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. components's size differs from
     * fileNames's.
     *
     * @throws Exception to junit
     */
    public void testExportComponentInvalidListOfJComponentStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());

        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("components's size differs from fileNames's.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, OutputStream, String)}. viewport is not
     * inside component area and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentInvalidRectangleOutputStreamString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();

        Rectangle viewport = new Rectangle(0, 0, 500, 10);
        OutputStream os = new ByteArrayOutputStream();
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, os, format);
            fail("viewport is not inside component area and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, String, String, String)}. viewport is
     * invalid and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentInvalidRectangleStringStringString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        Rectangle viewport = new Rectangle(-1, 0, 10, 20); //rectangle outside the component area
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentRectangleStringStringString_fail.txt";
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, location, filename, format);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, OutputStream, String)}. os is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentNullOutputStreamString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        OutputStream os = null;
        String format = "txt";

        try {
            exporter.exportComponent(component, os, format);
            fail("os is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, OutputStream, String)}. format is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentOutputStreamNullString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        OutputStream os = new ByteArrayOutputStream();
        String format = null;

        try {
            exporter.exportComponent(component, os, format);
            fail("format is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, OutputStream, String)}. Expected to be success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentOutputStreamString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        OutputStream os = new ByteArrayOutputStream();
        String format = "txt";

        exporter.exportComponent(component, os, format);

        //success
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, OutputStream, String)}. outputstream is
     * null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleNullOutputStreamString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();

        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        OutputStream os = null;
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, os, format);
            fail("outputstream is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, OutputStream, String)}. format is null
     * and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleOutputStreamNullString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();

        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        OutputStream os = new ByteArrayOutputStream();

        String format = null;

        try {
            exporter.exportComponent(component, viewport, os, format);
            fail("format is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, OutputStream, String)}. Expected to be
     * success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleOutputStreamString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        OutputStream os = new ByteArrayOutputStream();
        String format = "txt";

        exporter.exportComponent(component, viewport, os, format);
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, String, String, String)}. filename is
     * null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleStringNullStringString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;
        String filename = null;
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, location, filename, format);
            fail("filename is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, String, String, String)}. format is
     * null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleStringStringNullString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentRectangleStringStringString_fail.txt";
        String format = null;

        try {
            exporter.exportComponent(component, viewport, location, filename, format);
            fail("format is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, String, String, String)}. Expected to
     * be success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentRectangleStringStringString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentRectangleStringStringString.txt";

        String format = "txt";

        exporter.exportComponent(component, viewport, location, filename, format);
    }

    /**
     * Test {@link ImageExporter#exportComponent(javax.swing.JComponent, String, String, String)}, given null
     * filename and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentStringNullStringString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        String location = OUTPUT_DIR;
        String filename = null;
        String format = "txt";

        try {
            exporter.exportComponent(component, location, filename, format);
            fail("filename is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(javax.swing.JComponent, String, String, String)}, given null
     * format and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentStringStringNullString()
        throws Exception {
        JComponent component = jframe.getPrintingComponent();
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentStringStringString_fail.txt";

        String format = null;

        try {
            exporter.exportComponent(component, location, filename, format);
            fail("filename is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(javax.swing.JComponent, String, String, String)}. Expected to
     * be successful.
     *
     * @throws Exception to junit
     */
    public void testExportComponentJComponentStringStringString()
        throws Exception {
        exporter.exportComponent(jframe.getPrintingComponent(), OUTPUT_DIR,
            "testExportComponentJComponentStringStringString.txt", "txt");

        //success
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, List, String)}. viewport is invalid and IAE
     * is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentInvalidRectangleListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(-1, 0, 20, 20);

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, outputStreams, format);
            fail("viewport is invalid and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, String, List, String)}. Rectangle is not
     * inside all the components, IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentInvalidRectangleStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 300, 20);
        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, location, fileNames, format);
            fail("components contains null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, List, String)}. format is null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentListOfOutputStreamNullString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = null;

        try {
            exporter.exportComponent(components, outputStreams, format);
            fail("outputStreams is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, List, String)}. Expected to be success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = "txt";

        exporter.exportComponent(components, outputStreams, format);

        //success
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, List, String)}. outputStreams is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentNullListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        List<OutputStream> outputStreams = null;
        String format = "txt";

        try {
            exporter.exportComponent(components, outputStreams, format);
            fail("outputStreams is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, List, String)}. format is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleListOfOutputStreamNullString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 20, 20);

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = null;

        try {
            exporter.exportComponent(components, viewport, outputStreams, format);
            fail("outputStreams is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, List, String)}. Expected to be success
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 20, 20);

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = "txt";

        exporter.exportComponent(components, viewport, outputStreams, format);
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, List, String)}. outputStreams is null and IAE
     * is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleNullListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 20, 20);

        List<OutputStream> outputStreams = null;
        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, outputStreams, format);
            fail("outputStreams is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, String, List, String)}. fileNames is null and
     * IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleNullStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 20, 20);
        String location = OUTPUT_DIR;

        List<String> fileNames = null;
        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, location, fileNames, format);
            fail("fileNames is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, String, List, String)}. format is null and
     * IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleStringListOfStringNullString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 20, 20);
        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_2_fail.txt");

        String format = null;

        try {
            exporter.exportComponent(components, viewport, location, fileNames, format);
            fail("format is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, String, List, String)}. Expected to be
     * success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentRectangleStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_1.txt");
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_2.txt");

        String format = "txt";

        exporter.exportComponent(components, viewport, location, fileNames, format);
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. format is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentStringListOfStringNullString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());

        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1_fail.txt");

        String format = null;

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("format is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. Expected to be success.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());
        components.add(new PrintFrame(200, 200, "new frame", true).getPrintingComponent());

        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1.txt");
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_2.txt");

        String format = "txt";

        exporter.exportComponent(components, location, fileNames, format);

        //should be success
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. fileNames is empty and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentListOfJComponentStringNullListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(jframe.getPrintingComponent());

        String location = OUTPUT_DIR;

        List<String> fileNames = null;
        String format = "txt";

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("fileNames is empty and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. components contains null and IAE
     * is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullElemListOfJComponentStringListOfStringString()
        throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(null);

        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("components contains null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, OutputStream, String)}. component is null and IAE
     * is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullJComponentOutputStreamString()
        throws Exception {
        JComponent component = null;
        OutputStream os = new ByteArrayOutputStream();
        String format = "txt";

        try {
            exporter.exportComponent(component, os, format);
            fail("component is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, OutputStream, String)}. component is
     * null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullJComponentRectangleOutputStreamString()
        throws Exception {
        JComponent component = null;
        Rectangle viewport = new Rectangle(0, 0, 10, 10);
        OutputStream os = new ByteArrayOutputStream();
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, os, format);
            fail("component is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(JComponent, Rectangle, String, String, String)}. component is
     * null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullJComponentRectangleStringStringString()
        throws Exception {
        JComponent component = null;
        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentRectangleStringStringString_fail.txt";
        String format = "txt";

        try {
            exporter.exportComponent(component, viewport, location, filename, format);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(javax.swing.JComponent, String, String, String)}, given null
     * component and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullJComponentStringStringString()
        throws Exception {
        JComponent component = null;
        String location = OUTPUT_DIR;
        String filename = "testExportComponentJComponentStringStringString_fail.txt";
        String format = "txt";

        try {
            exporter.exportComponent(component, location, filename, format);
            fail("component is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, List, String)}. components is null and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullListOfJComponentListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = null;

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = "txt";

        try {
            exporter.exportComponent(components, outputStreams, format);
            fail("components is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, List, String)}. components is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullListOfJComponentRectangleListOfOutputStreamString()
        throws Exception {
        List<JComponent> components = null;

        Rectangle viewport = new Rectangle(0, 0, 20, 20);

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(new ByteArrayOutputStream());
        outputStreams.add(new ByteArrayOutputStream());

        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, outputStreams, format);
            fail("components is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, Rectangle, String, List, String)}. components is null
     * and IAE is expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullListOfJComponentRectangleStringListOfStringString()
        throws Exception {
        List<JComponent> components = null;

        Rectangle viewport = new Rectangle(0, 0, 10, 20);
        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentRectangleStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, viewport, location, fileNames, format);
            fail("components is null and IAE is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#exportComponent(List, String, List, String)}. components is null and IAE is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testExportComponentNullListOfJComponentStringListOfStringString()
        throws Exception {
        List<JComponent> components = null;
        String location = OUTPUT_DIR;

        List<String> fileNames = new ArrayList<String>();
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_1_fail.txt");
        fileNames.add("testExportComponentListOfJComponentStringListOfStringString_2_fail.txt");

        String format = "txt";

        try {
            exporter.exportComponent(components, location, fileNames, format);
            fail("components is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig(CONFIG); // load config file
        TestHelper.backupConfig(CONFIG); // back config file preventing it from being modified during the test
                                         //add custom exporter

        TestHelper.setProperty(DEFAULT_NAMESPACE, "exportersMap", "custom_exporter");

        //add custom visible maker
        TestHelper.setProperty(DEFAULT_NAMESPACE, "jComponentVisibleMaker", "custom_visible_maker");
        exporter = new ImageExporter();
        jframe = new PrintFrame(400, 400, "abcdefghijklmn", true);
    }

    /**
     * Clears test environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig(); // clear all config
        TestHelper.restoreConfig(CONFIG); // restore the backup config file
        jframe.dispose();
    }
}
