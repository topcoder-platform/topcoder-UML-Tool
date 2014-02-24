/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure testing helper class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
class FailureTestHelper {

    /**
     * <p>
     * private constructor preventing instantiation.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * clear the testing namespaces.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    static void clearNamespaces() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }
    }

    /**
     * <p>
     * Loads the testing namespaces.
     * </p>
     * @param filename
     *            the file name
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    static void loadNamesapces(String filename) throws Exception {
        ConfigManager.getInstance().add(filename);
    }
}
