/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 *
 * <p>
 * A helper class provides utilities for accuracy test.
 * </p>
 *
 *
 * @author abram
 * @version 1.0
 */
public final class AccuracyTestHelper {

    /**
     * Represents the path of test file folder for accuracy tests.
     */
    public static final String ACCURACY_TEST_FOLDER = "test_files" + File.separator
            + "accuracyTests" + File.separator;

    /**
     * Represents the path of sample xmi file.
     */
    public static final String SAMPLE_XMI = ACCURACY_TEST_FOLDER + "sample.xmi";

    /**
     * Represents the default namespace used in the tests.
     */
    public static final String DEFAULT_NAME_SPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>
     * Default constructor for preventing instantiating.
     * </p>
     */
    private AccuracyTestHelper() {
        // do nothing
    }

    /**
     * <p>
     * Add the config files for testing.
     * </p>
     *
     * @param namespace
     *            the namespace
     * @param fileName
     *            the name of the config file(it should be relative to the accuracy test file
     *            folder)
     *
     * @throws Exception
     *             to JUnit.
     */
    public static void loadConfig(String namespace, String fileName) throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        if (configManager.existsNamespace(namespace)) {
            configManager.removeNamespace(namespace);
        }

        configManager.add(namespace, new File(ACCURACY_TEST_FOLDER + fileName).getCanonicalPath(),
                ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * <p>
     * Add the config files for testing.
     * </p>
     *
     * @param fileName
     *            the name of the config file(it should be relative to the accuracy test file
     *            folder)
     *
     * @throws Exception
     *             to JUnit.
     */
    public static void loadConfig(String fileName) throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.add(new File(ACCURACY_TEST_FOLDER + fileName).getCanonicalPath());
    }

    /**
     * <p>
     * Clear the config.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager configManager = ConfigManager.getInstance();

        for (Iterator iter = configManager.getAllNamespaces(); iter.hasNext();) {
            configManager.removeNamespace((String) iter.next());
        }
    }

    /**
     * <p>
     * Gets the value of a private field the given instance.
     * </p>
     *
     * @param instance
     *            the instance whose field value is retrieved.
     * @param type
     *            the type which contains the given field.
     * @param fieldName
     *            the field name.
     * @return the field value of the given instance.
     *
     * @throws Exception
     *             to JUnit
     */
    public static Object getField(Object instance, Class type, String fieldName) throws Exception {
        Field info = type.getDeclaredField(fieldName);
        info.setAccessible(true);

        try {
            return info.get(instance);
        } finally {
            info.setAccessible(false);
        }
    }
}