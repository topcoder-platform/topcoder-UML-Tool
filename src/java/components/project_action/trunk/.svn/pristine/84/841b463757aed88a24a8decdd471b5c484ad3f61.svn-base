/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;

/**
 * <p>
 * This is a mock extension of ImageExporter for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockImageExporter extends ImageExporter {

    /**
     * <p>
     * Represents a list of Component objects.
     * </p>
     */
    private final List<Component> components = new ArrayList<Component>();

    /**
     * <p>
     * Represents a list of Rectangle objects used as viewports.
     * </p>
     */
    private List<Rectangle> viewports = new ArrayList<Rectangle>();

    /**
     * <p>
     * Represents the location (path) to store.
     * </p>
     */
    private String location;

    /**
     * <p>
     * Represents a list of String objects used as the file names.
     * </p>
     */
    private final List<String> fileNames = new ArrayList<String>();

    /**
     * <p>
     * Represents the format of the images.
     * </p>
     */
    private String format;

    /**
     * TODO
     * @throws ImageExporterConfigurationException
     */
    public MockImageExporter() throws ImageExporterConfigurationException {
    }

    /**
     * <p>
     * Mock Stub implementation. Sets all the variable for testing.
     * </p>
     *
     * @param components
     *            a list of Component objects to export.
     * @param location
     *            the location (path) to store the generated image files
     * @param fileNames
     *            a list of file names for the exported image files.
     * @param format
     *            the format of the images to generate
     */
    public void exportComponents(List<JComponent> components, String location, List<String> fileNames, String format) {
        this.components.addAll(components);
        this.location = location;
        this.fileNames.addAll(fileNames);
        this.format = format;
    }

    /**
     * <p>
     * Mock Stub implementation. Sets all the variable for testing.
     * </p>
     *
     * @param components
     *            a list of Component objects to export.
     * @param viewports
     *            a list of Rectangle objects used as viewports.
     * @param location
     *            the location (path) to store the generated image files
     * @param fileNames
     *            a list of file names for the exported image files.
     * @param format
     *            the format of the images to generate
     * @throws IllegalArgumentException
     *          when the location equals exception, used for exception testing.
     */
    public void exportComponents(List<JComponent> components, List<Rectangle> viewports, String location,
            List<String> fileNames, String format) {
        if (location.equals("exception")) {
            throw new IllegalArgumentException("testing exception");
        }
        this.components.addAll(components);
        this.location = location;
        this.fileNames.addAll(fileNames);
        this.format = format;
        this.viewports.addAll(viewports);
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the components list.
     * </p>
     *
     * @return the components list.
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the location.
     * </p>
     *
     * @return the location.
     */
    public String getlocation() {
        return location;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the fileNames list.
     * </p>
     *
     * @return the fileNames list.
     */
    public List<String> getfileNames() {
        return fileNames;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the format.
     * </p>
     *
     * @return the format.
     */
    public String getformat() {
        return format;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the viewports list.
     * </p>
     *
     * @return the viewports list.
     */
    public List<Rectangle> getviewports() {
        return viewports;
    }
}
