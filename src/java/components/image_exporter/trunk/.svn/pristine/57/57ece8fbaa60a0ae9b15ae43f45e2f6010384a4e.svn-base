/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import java.awt.Rectangle;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JComponent;


/**
 * Mock implementation for JComponentImageExporter used in test. This mock object strictly follows the contract of
 * its interfact so that it can behave as expected.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockJComponentImageExporter implements JComponentImageExporter {
    /** Format support for this exporter. */
    private static final String[] FORMATS = {"txt" };

    /**
     * write to ourputStream with exporting infomation string.
     *
     * @param component the jComponent to export, should not be null
     * @param outputStream the outputStream to write the image, should not be null
     * @param viewport the viewport to capture of the image's area, should be inside the component area,can be null
     * @param format the image format, should not be null or empty
     *
     * @throws ImageExporterException if any error occurs during the exporting process
     * @throws IllegalArgumentException if any argument is invalid
     */
    public void export(JComponent component, OutputStream outputStream, Rectangle viewport, String format)
        throws ImageExporterException {
        if ((component == null) || (outputStream == null) || (format == null) || (format.trim().length() == 0)) {
            throw new IllegalArgumentException();
        }

        Rectangle printArea = calPrintingArea(component, viewport);
        String result = "export component:" + component.getWidth() + "(w) " + component.getHeight()
             + "(h) within rectangle [" + printArea.x + "," + printArea.y + "," + printArea.width + ","
             + printArea.height + "]";

        try {
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            throw new ImageExporterException("error", e);
        }
    }

    /**
     * return supported formats.
     *
     * @return {"txt"}
     */
    public String[] getSupportedFormats() {
        return FORMATS;
    }

    /**
     * Calculate the printing area according to the given JComponent and viewport. If viewport exists and it's
     * inside the component area, use it as printing area, otherwise use the JComponent area.
     *
     * @param jComponent JComponent to be printed
     * @param viewport viewport to be printed
     *
     * @return the area to be printed after printingArea
     *
     * @throws ImageExporterException if jComponent is not displayable or the printing area after calculation is 0 size
     * @throws IllegalArgumentException if viewport exists and is not inside the jComponent
     */
    private Rectangle calPrintingArea(JComponent jComponent, Rectangle viewport)
        throws ImageExporterException {
        //check if the component is displayable
        if (!jComponent.isDisplayable()) {
            throw new ImageExporterException("given component is not displayable");
        }

        //default printing area is set to be the whole component
        Rectangle printingArea = new Rectangle(0, 0, jComponent.getWidth(), jComponent.getHeight());

        //if viewport specified, use it as printing area
        if (viewport != null) {
            // viewport should be inside the component area
            if (printingArea.contains(viewport)) {
                //set the viewport as printing area
                printingArea = viewport;
            } else {
                throw new IllegalArgumentException("viewport is not inside component area");
            }
        }

        return printingArea;
    }
}
