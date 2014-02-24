/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * A utility class for unit test cases.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class FailureTestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * A utility method for removing all namespace in ConfigManager.
     * </p>
     * @throws UnknownNamespaceException to JUnit
     */
    public static void clearConfig() throws UnknownNamespaceException {
        ConfigManager manager = ConfigManager.getInstance();

        for (Iterator it = manager.getAllNamespaces(); it.hasNext();) {
            manager.removeNamespace((String) it.next());
        }
    }
}
