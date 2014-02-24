/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.util.config.ConfigManager;

import java.io.File;

import java.util.Iterator;


/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
        // empty
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        clearConfig();

        //set up environment
        ConfigManager cm = ConfigManager.getInstance();
        File file = new File(fileName);

        cm.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     *
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    public static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
    }
}
