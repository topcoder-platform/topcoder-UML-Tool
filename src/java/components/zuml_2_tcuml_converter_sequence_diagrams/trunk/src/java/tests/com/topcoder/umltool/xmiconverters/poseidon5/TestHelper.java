/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.io.File;

import java.util.Iterator;


/**
 * <p>
 * A utility class for unit test cases.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
        //do nothing
    }

    /**
     * <p> A utility method for removing all namespace in ConfigManager.</p>
     */
    public static void resetConfig() {
        ConfigManager manager = ConfigManager.getInstance();
        Iterator it = manager.getAllNamespaces();

        while (it.hasNext()) {
            try {
                manager.removeNamespace((String) it.next());
            } catch (UnknownNamespaceException e) {
                //do nothing here
            }
        }
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
    public static void loadSingleXMLConfig(String namespace, String fileName)
        throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(),
            ConfigManager.CONFIG_XML_FORMAT);
    }
}
