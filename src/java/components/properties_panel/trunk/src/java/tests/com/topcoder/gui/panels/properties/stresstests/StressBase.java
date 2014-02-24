/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.stresstests;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.util.config.ConfigManager;

/**
 * The base class for stress unit tests.
 *
 * @author kinfkong
 * @version 1.0
 */
public class StressBase extends TestCase {

    /**
     * Represents the path of the configuration files.
     */
    private static final String PATH = "test_files" + File.separator + "stresstests";

    /**
     * Represents the execute number of the stress tests.
     */
    protected static final int STRESS_TEST_NUM = 10000;

    /**
     * Represents the starting time of the stress test.
     */
    private Date startTime = null;

    /**
     * Sets up the stress test environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        // load the config files
        loadConfigFile("config1.xml");
        loadConfigFile("config2.xml");
        loadConfigFile("config3.xml");
    }

    /**
     * Clears the test environment.
     */
    public void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            String namespace = (String) it.next();
            if (cm.existsNamespace(namespace)) {
                cm.removeNamespace(namespace);
            }
        }
    }

    /**
     * Loads the configuration file.
     *
     * @param fileName the file name
     *
     * @throws Exception to JUnit
     */
    private void loadConfigFile(String fileName) throws Exception {
        File file = new File(PATH, fileName);
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(file.getAbsolutePath());

    }

    /**
     * Start the stress test and mark the start time.
     *
     */
    protected void startIt() {
        startTime = new Date();
    }

    /**
     * Finishes the stress test and mark the finishing time and output
     * the corresponding message.
     *
     */
    protected void stopIt(String testName) {

        System.out.println("Running " + testName + " for " + STRESS_TEST_NUM
            + " times costs " + (new Date().getTime() - startTime.getTime()) + " milliseconds.");
    }
}
