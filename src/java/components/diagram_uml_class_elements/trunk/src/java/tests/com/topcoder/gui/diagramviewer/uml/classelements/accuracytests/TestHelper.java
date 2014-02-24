/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.accuracytests;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;

/**
 * <p>
 * This is a helper class for test.
 * </p>
 * @author moonli
 * @version 1.0
 */
public class TestHelper {

    /**
     * <p>
     * Private constructor.
     * </p>
     */
    private TestHelper() {

    }

    /**
     * <p>
     * Prepares for properties map for GraphNode.
     * </p>
     * @return the properties map
     */
    public static Map<String, String> prepareProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("stroke_color", "StrokeColor");
        properties.put("fill_color", "FillColor");
        properties.put("font_color", "FontColor");
        return properties;
    }

    /**
     * <p>
     * Sets properties of GraphNode.
     * </p>
     * @param graphNode
     *            the graph node
     */
    public static void setPropertiesForGraphNode(GraphNode graphNode) {
        Property property = new Property();
        property.setKey("StrokerColor");
        property.setValue("000000"); // black
        graphNode.addProperty(property);
        property = new Property();
        property.setKey("FillColor");
        property.setValue("FFFF00"); // yellow
        graphNode.addProperty(property);
        property = new Property();
        property.setKey("FontColor");
        property.setValue("FF0000"); // red
        graphNode.addProperty(property);
    }
}
