/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.stresstests;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * Stress tests cases for PropertyMapping.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class PropertyMappingStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 10000;

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        StressTestHelper.clearConfig();
        StressTestHelper.loadXMLConfig(StressTestHelper.CONFIG_FILE);
        mapping = new PropertyMapping();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
        mapping = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PropertyMappingStressTests.class);
    }

    /**
     * <p>
     * Stress tests PropertyMapping#addPropertyKey(String name, String key) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PropertyMapping#addPropertyKey(String name, String key) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            mapping.addPropertyKey("Property" + i, "Key" + i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "PropertyMapping#addPropertyKey(String name, String key) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Stress tests PropertyMapping#removePropertyKey(String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PropertyMapping#removePropertyKey(String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        for (int i = 0; i < TIMES; i++) {
            mapping.addPropertyKey("Property" + i, "Key" + i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            mapping.removePropertyKey("Property" + i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "PropertyMapping#removePropertyKey(String name) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }
}
