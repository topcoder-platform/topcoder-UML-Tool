/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JList;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;
import com.topcoder.uml.actions.project.ExportDiagramToImageAction;

/**
 * <p>
 * Accuracy test for <code>{@link ExportDiagramToImageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ExportDiagramToImageActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the location used in tests.
     * </p>
     */
    private static final String LOCATION = "test_files/";

    /**
     * <p>
     * Represents the format of the image to generate.
     * </p>
     */
    private static final String FORMAT = "JPEG";

    /**
     * <p>
     * Represents the image exporter used in tests.
     * </p>
     */
    private static ImageExporter IMAGE_EXPORTER;

    /**
     * <p>
     * Represents the size of the list to created.
     * </p>
     */
    private static final int SIZE = 10;

    static
    {
        try {
            IMAGE_EXPORTER = new ImageExporter();
        } catch (ImageExporterConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ExportDiagramToImageAction#ExportDiagramToImageAction(Component, String, String, String, ImageExporter)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        JComponent component = new JList();
        String fileName = "TopCoder";

        ExportDiagramToImageAction exportDiagramToImageAction = new ExportDiagramToImageAction(component, LOCATION,
            fileName, FORMAT, IMAGE_EXPORTER);

        // verify
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "location"));
        assertEquals("format field not set.", FORMAT, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "format"));
        assertSame("image exporter not set correctly.", IMAGE_EXPORTER, AccuracyTestHelper.getFieldValue(
            exportDiagramToImageAction, "imageExporter"));
        List internalComponents = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "components");
        assertTrue("the size is incorrect.", 1 == internalComponents.size());
        assertTrue("the component not contained", internalComponents.contains(component));
        List internalFileNames = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "fileNames");
        assertTrue("the size is incorrect.", 1 == internalFileNames.size());
        assertTrue("the file name not contained", internalFileNames.contains(fileName));
        List internalViewPorts = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "viewports");
        assertTrue("the size is incorrect.", 0 == internalViewPorts.size());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ExportDiagramToImageAction#ExportDiagramToImageAction(Component, Rectangle, String, String, String, ImageExporter)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        JComponent component = new JList();
        String fileName = "TopCoder";
        Rectangle rectangle = new Rectangle();

        ExportDiagramToImageAction exportDiagramToImageAction = new ExportDiagramToImageAction(component, rectangle,
            LOCATION, fileName, FORMAT, IMAGE_EXPORTER);

        // verify
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "location"));
        assertEquals("format field not set.", FORMAT, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "format"));
        assertSame("image exporter not set correctly.", IMAGE_EXPORTER, AccuracyTestHelper.getFieldValue(
            exportDiagramToImageAction, "imageExporter"));
        List internalComponents = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "components");
        assertTrue("the size is incorrect.", 1 == internalComponents.size());
        assertTrue("the component not contained", internalComponents.contains(component));
        List internalFileNames = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "fileNames");
        assertTrue("the size is incorrect.", 1 == internalFileNames.size());
        assertTrue("the file name not contained", internalFileNames.contains(fileName));
        List internalViewPorts = (List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "viewports");
        assertTrue("the size is incorrect.", 1 == internalViewPorts.size());
        assertTrue("the file name not contained", internalViewPorts.contains(rectangle));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ExportDiagramToImageAction#ExportDiagramToImageAction(List, String, List, String, ImageExporter)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_3_Accuracy() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        List<String> fileNames = new ArrayList<String>();
        for (int i = 0; i < SIZE; i++) {
            components.add(new JList());
            fileNames.add("TopCoder" + i);
        }

        ExportDiagramToImageAction exportDiagramToImageAction = new ExportDiagramToImageAction(components, LOCATION,
            fileNames, FORMAT, IMAGE_EXPORTER);

        // verify
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "location"));
        assertEquals("format field not set.", FORMAT, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "format"));
        assertSame("image exporter not set correctly.", IMAGE_EXPORTER, AccuracyTestHelper.getFieldValue(
            exportDiagramToImageAction, "imageExporter"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "components"), components);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "fileNames"), fileNames);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "viewports"),
            new ArrayList());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ExportDiagramToImageAction#ExportDiagramToImageAction(List, String, List, String, ImageExporter)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_4_Accuracy() throws Exception {
        List<JComponent> components = new ArrayList<JComponent>();
        List<String> fileNames = new ArrayList<String>();
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        for (int i = 0; i < SIZE; i++) {
            components.add(new JList());
            fileNames.add("TopCoder" + i);
            viewports.add(new Rectangle());
        }

        ExportDiagramToImageAction exportDiagramToImageAction = new ExportDiagramToImageAction(components, viewports,
            LOCATION, fileNames, FORMAT, IMAGE_EXPORTER);

        // verify
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "location"));
        assertEquals("format field not set.", FORMAT, AccuracyTestHelper.getFieldValue(exportDiagramToImageAction,
            "format"));
        assertSame("image exporter not set correctly.", IMAGE_EXPORTER, AccuracyTestHelper.getFieldValue(
            exportDiagramToImageAction, "imageExporter"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "components"), components);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "fileNames"), fileNames);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(exportDiagramToImageAction, "viewports"), viewports);
    }

}
