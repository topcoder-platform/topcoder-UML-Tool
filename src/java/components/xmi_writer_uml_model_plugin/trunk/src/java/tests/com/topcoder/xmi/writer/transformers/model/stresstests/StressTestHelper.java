/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.stresstests;

import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This Helper Class of this component.
 * </p>
 *
 * @author haozhangr
 * @version 1.0
 */
public final class StressTestHelper {
    /**
     * The stress load of the stress test.
     */
    public static final int TIMES = 400;
    /**
     * <p>
     * The private constructor of the helper class.
     * </p>
     *
     */
    private StressTestHelper() {
        //empty
    }

    /**
     * The helper method that clear all the configuration in the memroy.
     *
     * @throws Exception to JUnit
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }
    }
    /**
     * The helper method that add the configuration for unit test.
     *
     * @throws Exception to JUnit
     */
    public static void addConfig() throws Exception {
        ConfigManager.getInstance().add("stress/config.xml");
        ConfigManager.getInstance().add("stress/objectfactory.xml");
    }
}
