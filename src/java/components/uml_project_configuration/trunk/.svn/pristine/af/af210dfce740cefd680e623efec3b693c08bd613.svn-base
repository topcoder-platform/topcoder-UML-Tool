/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import java.util.Date;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * This class is a helper class used in stress tests.
 *
 * @author vividmxx
 * @version 1.0
 */
public final class TestHelper {
    /**
     * The run time or thread number used in stress test.
     */
    public static final int NUMBER = 1000;

    /**
     * The <code>Date</code> instance used in the test to record the time.
     */
    private static Date timer = null;

    /**
     * The private constructor prevents creation.
     */
    private TestHelper() {
    }

    /**
     * Starts the timer. Simply sets the timer to the current time.
     */
    public static void startTimer() {
        timer = new Date();
    }

    /**
     * Loads config file into Config Manager.
     *
     * @throws Exception
     *             throws exceptions to JUnit
     */
    public static void setUpConfigManager() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("stresstests/config.xml");
    }

    /**
     * Clears config file from Config Manager.
     *
     * @throws Exception
     *             throws exceptions to JUnit
     */
    public static void tearDownConfigManager() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            cm.removeNamespace((String) it.next());
        }
    }

    /**
     * Prints the test result.
     *
     * @param methodName
     *            the name of the target method
     */
    public static void printResultMulTimes(String methodName) {
        System.out.println("Calling " + methodName + " for " + NUMBER + " times costs "
                + (new Date().getTime() - timer.getTime()) + " milliseconds.");
    }
}
