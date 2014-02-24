/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests.mock;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.swing.imageexporter.ImageExporterConfigurationException;

/**
 * <p>
 * Mock ImageExporter class used in failure test only.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class MockImageExporter extends ImageExporter {

    public MockImageExporter() throws ImageExporterConfigurationException {
    }

    public void exportComponents(List<JComponent> components, String location,
        List<String> fileNames, String format) {
        throw new IllegalArgumentException();
    }
    
    public void exportComponents(List<JComponent> components,
            List<Rectangle> viewports, String location, List<String> fileNames,
            String format) {
        throw new IllegalArgumentException();
    }

}
