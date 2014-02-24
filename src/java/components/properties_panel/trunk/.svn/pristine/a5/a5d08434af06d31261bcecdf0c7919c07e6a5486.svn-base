/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the accuracy tests.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class AccuracyTestsHelper {
    /**
     * <p>
     * The sample configuration file for this component.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files" + File.separator + "accuracy" + File.separator + "config.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private AccuracyTestsHelper() {
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
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
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

    public static Component[] getChildComponents(Container container, Class type) {
        List<Component> childComponents = new ArrayList<Component>();

        LinkedList<Component> openComponents = new LinkedList<Component>();
        openComponents.add(container);

        while (openComponents.size() > 0) {
            Component comp = openComponents.removeFirst();
            if (comp instanceof Container) {
                container = (Container) comp;
                for (int i = 0; i < container.getComponentCount(); i++) {
                    Component child = container.getComponent(i);
                    openComponents.add(child);
                    if (type.isInstance(child)) {
                        childComponents.add(child);
                    }
                }
            }
        }

        return childComponents.toArray(new Component[childComponents.size()]);
    }
}
