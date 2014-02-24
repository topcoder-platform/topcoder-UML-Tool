/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import java.io.File;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Base stress test.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public abstract class BaseStressTests extends TestCase {

    /**
     * The File separator.
     */
    private static final String FS = File.separator;

    /**
     * Directory to the stress test files.
     */
    private static final String TEST_FILES_DIR = "stresstests" + FS;

    /**
     * <p>
     * The start timestamp.
     * </p>
     */
    private long start;

    /**
     * <p>
     * Begin the stress test.
     * </p>
     */
    protected void begin() {
        start = System.currentTimeMillis();
    }

    /**
     * <p>
     * Prints test result.
     * </p>
     *
     * @param name
     *            the test name
     * @param count
     *            the run times
     */
    protected void printResult(String name, int count) {
        System.out.println("The test [" + name + "] run " + count + " times, took time: "
                + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * <p>
     * Add the given config file.
     * </p>
     *
     * @param filename
     *            the config file name.
     * @throws Exception
     *             to JUnit.
     */
    protected void addConfig(String filename) throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add(TEST_FILES_DIR + filename);
    }

    /**
     * <p>
     * Clear the config.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iterator = cm.getAllNamespaces(); iterator.hasNext();) {
            cm.removeNamespace((String) iterator.next());
        }
    }

    /**
     * <p>
     * Get the file with the given filename.
     * </p>
     *
     * @param filename
     *            the file name
     * @return the file created with the filename.
     */
    protected File getFile(String filename) {
        return new File("test_files" + File.separator + "stresstests" + File.separator + filename);
    }
}
