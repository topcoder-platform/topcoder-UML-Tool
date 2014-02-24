/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import java.io.File;

import com.topcoder.diagraminterchange.Property;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Helper class used for providing utility method for the development of stress test of StylePane component.
 * </p>
 * 
 * @author cmax
 * @version 1.0
 */
public class TestHelper {

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Use the given file to config the given namespace the format of the config file is
     * ConfigManager.CONFIG_XML_FORMAT.
     * </p>
     * 
     * @param namespace use the namespace to load config information to ConfigManager
     * @param fileName config file to set up environment
     * 
     * @throws Exception when any exception occurs
     */
    public static void loadSingleXMLConfig(String namespace, String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * <p>
     * Remove the given namespace in the ConfigManager.
     * </p>
     * 
     * @param namespace namespace use to remove the config information in ConfigManager
     * 
     * @throws Exception when any exception occurs
     */
    public static void clearConfigFile(String namespace) throws Exception {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }


    /**
     * <p>
     * Create a property with the given key and value.
     * </p>
     *
     * @param key the key for the property
     * @param value the value for the property
     * @return a property with the given key and value
     */
    public static Property createProperty(String key, String value) {
        Property prop = new Property();
        prop.setKey(key);
        prop.setValue(value);

        return prop;
    }
    
    /**
     * <p>
     * This method creates the GraphNode instance for testing.
     * </p>
     * 
     * @param stylePanel the StylePanel instance used to create the corresponding property of the GraphNode.
     * @return a GraphNode instance for testing.
     */
    public static GraphNode createGraphNode(StylePanel stylePanel) {
        GraphNode node = new GraphNode();
        node.addProperty(TestHelper.createProperty(stylePanel.getXKey(), "10"));
        node.addProperty(TestHelper.createProperty(stylePanel.getYKey(), "11"));
        node.addProperty(TestHelper.createProperty(stylePanel.getWidthKey(), "12"));
        node.addProperty(TestHelper.createProperty(stylePanel.getHeightKey(), "13"));
        node.addProperty(TestHelper.createProperty(stylePanel.getFillColorKey(), "#00FF00"));
        node.addProperty(TestHelper.createProperty(stylePanel.getOutlineColorKey(), "#FF0000"));
        node.addProperty(TestHelper.createProperty(stylePanel.getTextColorKey(), "#0000FF"));
        node.addProperty(TestHelper.createProperty(stylePanel.getFontNameKey(), "Arial"));
        node.addProperty(TestHelper.createProperty(stylePanel.getFontSizeKey(), "8"));
        return node;
    }
}