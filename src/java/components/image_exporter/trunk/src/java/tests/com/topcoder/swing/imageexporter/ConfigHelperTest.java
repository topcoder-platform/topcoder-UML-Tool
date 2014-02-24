/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.objectfactory.ObjectFactory;

import junit.framework.TestCase;

import java.util.Arrays;


/**
 * Test case for helper class ConfigHelper.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigHelperTest extends TestCase {
    /**
     * Test {@link ConfigHelper#createObjectFactory(String, String)} given with valid namespace and property
     * name, ObjectFactory should be created.
     *
     * @throws Exception to junit
     */
    public void testCreateObjectFactory() throws Exception {
        ObjectFactory factory = ConfigHelper.createObjectFactory("config_helper", "object_factory");
        assertNotNull("ObjectFactory should be instantiated successfully", factory);
    }

    /**
     * Test {@link ConfigHelper#createObjectFactory(String, String)} given with invalid namespace and
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testCreateObjectFactoryInvalidNamespace()
        throws Exception {
        try {
            ConfigHelper.createObjectFactory("not_existent_namespace", "object_factory");
            fail("namespace does not exist and ImageExporterConfigurationException will be thrown");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ConfigHelper#createObjectFactory(String, String)} given with invalid property and
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testCreateObjectFactoryInvalidProperty()
        throws Exception {
        try {
            ConfigHelper.createObjectFactory("config_helper", "not_existent_property");
            fail("property does not exist and ImageExporterConfigurationException will be thrown");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ConfigHelper#getArrayProperty(String, String)} given with valid namespace and property name,
     * value should equal with the expected one.
     *
     * @throws Exception to junit
     */
    public void testGetArrayProperty() throws Exception {
        String[] result = ConfigHelper.getArrayProperty("config_helper", "string_array");
        String[] expected = {"value1", "value2", "value3", "" };

        assertTrue("result should be equal with expected value", Arrays.equals(result, expected));

        result = ConfigHelper.getArrayProperty("config_helper", "not_existent_string_array");
        assertNull("property does not exist and result should be null", result);
    }

    /**
     * Test {@link ConfigHelper#getArrayProperty(String, String)} given with invalid namespace and
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testGetArrayPropertyInvalidNamespace()
        throws Exception {
        try {
            ConfigHelper.getArrayProperty("not_existent_namespace", "string_array");
            fail("namespace does not exist and ImageExporterConfigurationException will be thrown");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ConfigHelper#getStringProperty(String, String)} with valid namespace and property name.
     *
     * @throws Exception to junit
     */
    public void testGetStringProperty() throws Exception {
        String result = ConfigHelper.getStringProperty("config_helper", "string1");

        assertEquals("result should equal", "value", result);

        result = ConfigHelper.getStringProperty("config_helper", "string2");

        assertNull("property does not exist, null should be returned", result);
    }

    /**
     * Test {@link ConfigHelper#getStringProperty(String, String)} with invalid namespace and
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testGetStringPropertyInvalidNamespace()
        throws Exception {
        try {
            ConfigHelper.getStringProperty("not_existent_namespace", "string1");
            fail("namespace does not exist and ImageExporterConfigurationException is expected");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig("ConfigHelperTest.xml");
    }

    /**
     * Clears test environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig();
    }
}
