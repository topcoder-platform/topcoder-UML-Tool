/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <code>TestHelper</code> class is used to help the tests.
 *
 * @author enefem21
 * @version 1.0
 */
final class TestHelper {

    /**
     * Private method is used to avoid being initialized.
     */
    private TestHelper() {
    }

    /**
     * <p>
     * A helper method to be used to initialize the specified configuration namespace with the configuration
     * properties provided by specified file. If specified namespace is already loaded to
     * <code>ConfigurationManager</code> then it is re-loaded with new configuration properties.
     * </p>
     *
     * @param filename
     *            a <code>String</code> providing the name of the file to load configuration file from.
     *
     * @throws Exception
     *             exception while loading configuration.
     */
    static final void loadConfiguration(String filename) throws Exception {
        clearNamespaces();
        ConfigManager.getInstance().add(filename);
    }

    /**
     * <p>
     * Deletes specified configuration namespace from Config Manager.
     * </p>
     */
    static final void clearNamespaces() {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            String namespace = (String) iter.next();

            if (configManager.existsNamespace(namespace)) {
                try {
                    configManager.removeNamespace(namespace);
                } catch (UnknownNamespaceException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
