/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import java.awt.Rectangle;

import java.io.OutputStream;

import javax.swing.JComponent;


/**
 * <p>
 * This interface defines the contract for exporting a jComponent's image. Object Factory is used for extensibility.
 * It's expected that those classes that implements this interface have an empty constructor.
 * </p>
 * <p>
 * Thread-Safety: The implementations are required to be thread-safe.
 * </p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
 */
public interface JComponentImageExporter {
    /**
     * <p>It's the main method: export the jComponent's image to an outputStream with image format, capturing
     * the viewport area.</p>
     *
     * @param jComponent the jComponent to export, should not be null
     * @param outputStream the outputStream to write the image, should not be null
     * @param viewport the viewport to capture of the image's area, should be inside the component area,can be null
     * @param format the image format, should not be null or empty
     *
     * @throws ImageExporterException if any error occurs during the exporting process
     * @throws IllegalArgumentException if any argument is invalid
     */
    public void export(JComponent jComponent, OutputStream outputStream, Rectangle viewport, String format)
        throws ImageExporterException;

    /**
     * <p>Return the image formats supported by this JComponentImageExporter. It's used by ImageExporter for
     * selecting the correct exporter.</p>
     *
     * @return the image formats supported by this JComponentImageExporter
     */
    public String[] getSupportedFormats();
}
