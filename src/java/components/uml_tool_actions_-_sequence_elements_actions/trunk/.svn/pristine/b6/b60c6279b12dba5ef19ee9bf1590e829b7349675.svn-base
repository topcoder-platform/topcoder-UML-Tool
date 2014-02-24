/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved. Web Site Statistics 1.0
 */
package com.topcoder.uml.actions.model.sequence.stresstests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Stress test helper class for this component.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public final class StressTestHelper {
    /** Represents the number of requests to process, used in stress tests. */
    public static final int MAX_COUNT = 10000;

    /**
     * <p>
     * Creates a new instance of <code>AccuracyTestHelper</code> class.
     * </p>
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>
     * Load a config file to the <code>ConfigManager</code>.
     * </p>
     * 
     * @throws Exception
     *         exception to the caller.
     */
    public static void loadConfig() throws Exception {
        clearConfig();
        ConfigManager.getInstance().add("stress/stressConfig.xml");
    }

    /**
     * <p>
     * Clear all the configuration.
     * </p>
     * 
     * @throws Exception
     *         exception to the caller.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();
        while (it.hasNext()) {
            cm.removeNamespace(it.next().toString());
        }
    }
}
