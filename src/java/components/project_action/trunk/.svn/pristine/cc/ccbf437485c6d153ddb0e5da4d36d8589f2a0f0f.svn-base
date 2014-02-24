/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * <code>ExportDiagramToImageAction</code> exports a <code>diagram</code> to an image file. The
 * <code>diagram</code> should be received as a JComponent, not as a <code>Diagram</code>. The diagram
 * JComponent should be the graphical representation of the diagram. It will be passed to the Image Exporter
 * component.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, and its thread-safety depends on the Image Exporter
 * component.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class ExportDiagramToImageAction implements TransientAction {

    /**
     * <p>
     * Represents a list of JComponent objects to export to images in the execute method. Initialized when it
     * is declared to an ArrayList&lt;JComponent&gt; object, and its reference is never changed afterwards. It
     * will never be empty.
     * </p>
     */
    private final List<JComponent> components = new ArrayList<JComponent>();

    /**
     * <p>
     * Represents a list of <code>Rectangle</code> objects used as viewports in the execute method.
     * Initialized when it is declared to an ArrayList&lt;Rectangle&gt; object, and its reference is never
     * changed afterwards. It will be empty if it is not used, if it is used, it must contain the same number
     * of elements as the components list.
     * </p>
     */
    private final List<Rectangle> viewports = new ArrayList<Rectangle>();

    /**
     * <p>
     * Represents the location (path) to store the generated image files in the execute method. Initialized in
     * the constructor, and never changed afterwards. It must be non-null, non-empty string.
     * </p>
     */
    private final String location;

    /**
     * <p>
     * Represents a list of String objects used as the file names of the generated images in the execute
     * method. Initialized to an empty ArrayList&lt;String&gt; object when it is declared, and its reference
     * is never changed afterwards. It will never be empty,and it must contains the same number of elements as
     * the components list.
     * </p>
     */
    private final List<String> fileNames = new ArrayList<String>();

    /**
     * <p>
     * Represents the format of the images to generate in the execute method. Initialized in the constructor,
     * and never changed afterwards. It must be non-null, non-empty string.
     * </p>
     */
    private final String format;

    /**
     * <p>
     * Represents the <code>ImageExporter</code> object used to export diagrams to images in the execute method.
     * Initialized in the constructor and never changed afterwards. It must be non-null.
     * </p>
     */
    private final ImageExporter imageExporter;

    /**
     * <p>
     * Creates the instance with the given component, location, filename, format and the image exporter.
     * </p>
     *
     * @param component
     *            the JComponent object to export as an image.
     * @param location
     *            the location (path) to store the generated image files
     * @param fileName
     *            the file name of the exported image.
     * @param format
     *            the format of the images to generate
     * @param imageExporter
     *            the ImageExporter object to export the diagrams.
     * @throws IllegalArgumentException
     *             if any argument is null, or location, fileName or format is empty string.
     */
    public ExportDiagramToImageAction(JComponent component, String location, String fileName, String format,
            ImageExporter imageExporter) {
        // check if component is null
        Helper.checkObjectNotNull(component, "component in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if imageExporter is null
        Helper.checkObjectNotNull(imageExporter,
            "imageExporter in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the location string is null or empty
        Helper.checkStringNotNullOrEmpty(location,
            "location in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the fileName string is null or empty
        Helper.checkStringNotNullOrEmpty(fileName,
            "fileName in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the format string is null or empty
        Helper.checkStringNotNullOrEmpty(format, "format in ExportDiagramToImageAction#ExportDiagramToImageAction");
        this.components.add(component);
        this.location = location;
        this.fileNames.add(fileName);
        this.format = format;
        this.imageExporter = imageExporter;
    }

    /**
     * <p>
     * Creates the instance with the given component, viewport, location, filename, format and the image
     * exporter.
     * </p>
     *
     * @param component
     *            the JComponent object to export as an image.
     * @param viewport
     *            the Rectangle object used as the viewport
     * @param location
     *            the location (path) to store the generated image files
     * @param fileName
     *            the file name of the exported image.
     * @param format
     *            the format of the images to generate
     * @param imageExporter
     *            the ImageExporter object to export the diagrams.
     * @throws IllegalArgumentException
     *             if any argument is null, or location, fileName or format is empty string.
     */
    public ExportDiagramToImageAction(JComponent component, Rectangle viewport, String location, String fileName,
            String format, ImageExporter imageExporter) {
        this(component, location, fileName, format, imageExporter);
        // check if viewport is null
        Helper.checkObjectNotNull(viewport, "viewport in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // initialize the class variables.
        this.viewports.add(viewport);
    }

    /**
     * <p>
     * Creates the instance with the given list of component, location, list of filenames, format and the
     * image exporter.
     * </p>
     *
     * @param components
     *            a list of JComponent objects to export.
     * @param location
     *            the location (path) to store the generated image files
     * @param fileNames
     *            a list of file names for the exported image files.
     * @param format
     *            the format of the images to generate
     * @param imageExporter
     *            the ImageExporter object to export the diagrams.
     * @throws IllegalArgumentException
     *             if any argument is null, or location or format is empty string, or components or fileNames
     *             list is empty or contains null/empty elements, or components and fileNames lists don't
     *             contain the same number of elements.
     */
    public ExportDiagramToImageAction(List<JComponent> components, String location, List<String> fileNames,
            String format, ImageExporter imageExporter) {
        // check if the components list is null/empty or contains any null element
        Helper.checkObjectListNotNull(components,
            "components in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the location string is null or empty
        Helper.checkStringNotNullOrEmpty(location,
            "location in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the fileNames list is null/empty or contains any null/ empty element
        Helper
            .checkObjectListNotNull(fileNames, "fileNames in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if the format string is null or empty
        Helper.checkStringNotNullOrEmpty(format, "format in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if imageExporter is null
        Helper.checkObjectNotNull(imageExporter,
            "imageExporter in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if components and fileNames same number of elements
        if (fileNames.size() != components.size()) {
            throw new IllegalArgumentException("JComponents and FileNames should contain the same number of elements");
        }
        this.components.addAll(components);
        this.location = location;
        this.fileNames.addAll(fileNames);
        this.format = format;
        this.imageExporter = imageExporter;
    }

    /**
     * <p>
     * Creates the instance with the given list of component, list of viewport, location, list of filenames,
     * format and the image exporter.
     * </p>
     *
     * @param components
     *            a list of JComponent objects to export.
     * @param viewports
     *            a list of Rectangle objects used as viewports.
     * @param location
     *            the location (path) to store the generated image files
     * @param fileNames
     *            a list of file names for the exported image files.
     * @param format
     *            the format of the images to generate
     * @param imageExporter
     *            the ImageExporter object to export the diagrams.
     * @throws IllegalArgumentException
     *             if any argument is null, or location or format is empty string, or components or viewports
     *             or fileNames list argument is empty or contains null/empty elements, or components and
     *             fileNames and viewports list arguments don't contain the same number of elements.
     */
    public ExportDiagramToImageAction(List<JComponent> components, List<Rectangle> viewports, String location,
            List<String> fileNames, String format, ImageExporter imageExporter) {
        this(components, location, fileNames, format, imageExporter);
        // check if the viewports list is null/empty or contains any null element
        Helper
            .checkObjectListNotNull(viewports, "viewports in ExportDiagramToImageAction#ExportDiagramToImageAction");
        // check if components and fileNames same number of elements
        if (fileNames.size() != components.size() || viewports.size() != components.size()) {
            throw new IllegalArgumentException(
                "JComponents, viewports and fileNames should contain the same number of elements");
        }
        this.viewports.addAll(viewports);
    }

    /**
     * <p>
     * Exports the <code>diagram</code> to an image file. The diagram will be received as a
     * <code>JComponent</code>, not as a Diagram. The diagram <code>JComponent</code> should be the
     * graphical representation of the diagram. It will be passed to the Image Exporter component.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        try {
            // export the components and location to the image.
            // if the viewports is not present
            if (viewports.isEmpty()) {
                imageExporter.exportComponent(components, location, fileNames, format);
            } else {
                //imageExporter.exportComponent(components, viewports, location, fileNames, format);
                // TODO
            }
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while writing the data into image", e);
        }
    }
}
