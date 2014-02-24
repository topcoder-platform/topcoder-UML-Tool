/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * Unit test cases for PropertyMapping.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyMappingTests extends TestCase {
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * Static final String for nullname namespace.
     * </p>
     */
    private static final String NULLNAME_NAMESPACE = "nullname".intern();

    /**
     * <p>
     * Static final String for emptyname namespace.
     * </p>
     */
    private static final String EMPTYNAME_NAMESPACE = "emptyname".intern();

    /**
     * <p>
     * Static final String for nullkey namespace.
     * </p>
     */
    private static final String NULLKEY_NAMESPACE = "nullkey".intern();

    /**
     * <p>
     * Static final String for emptykey namespace.
     * </p>
     */
    private static final String EMPTYKEY_NAMESPACE = "emptykey".intern();

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
        TestHelper.clearConfig();
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
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
        TestHelper.clearConfig();
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
        return new TestSuite(PropertyMappingTests.class);
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PropertyMapping instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor1() throws Exception {
        assertNotNull("Failed to create a new PropertyMapping instance.", mapping);
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PropertyMapping instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        assertNotNull("Failed to create a new PropertyMapping instance.", mapping);
        assertEquals("The newly created PropertyMapping instance should have same records with VALID_NAMESPACE.",
                mapping.getPropertyNames().size(), 5);
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullNamespace() throws Exception {
        try {
            new PropertyMapping(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_EmptyNamespace() throws Exception {
        try {
            new PropertyMapping("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is unknown and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_UnknownNamespace() throws Exception {
        try {
            new PropertyMapping("unknownnamespace");
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace contains null name and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullName() throws Exception {
        try {
            new PropertyMapping(NULLNAME_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace contains empty name and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_EmptyName() throws Exception {
        try {
            new PropertyMapping(EMPTYNAME_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace contains null key and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullKey() throws Exception {
        try {
            new PropertyMapping(NULLKEY_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping#PropertyMapping(String namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace contains empty key and expects ConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_EmptyKey() throws Exception {
        try {
            TestHelper.loadXMLConfig("test_files" + File.separator + "EmptyKeyConfig.xml");
            new PropertyMapping(EMPTYKEY_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException ce) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#containsPropertyKey(String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PropertyMapping#containsPropertyKey(String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        assertTrue("The mapping should contains property name " + PropertyMapping.FILL_COLOR + ".",
                mapping.containsPropertyKey(PropertyMapping.FILL_COLOR));
        assertTrue("The mapping should contains property name " + PropertyMapping.FONT_COLOR + ".",
                mapping.containsPropertyKey(PropertyMapping.FONT_COLOR));
        assertTrue("The mapping should contains property name " + PropertyMapping.FONT_FAMILY + ".",
                mapping.containsPropertyKey(PropertyMapping.FONT_FAMILY));
        assertTrue("The mapping should contains property name " + PropertyMapping.FONT_SIZE + ".",
                mapping.containsPropertyKey(PropertyMapping.FONT_SIZE));
        assertTrue("The mapping should contains property name " + PropertyMapping.STROKE_COLOR + ".",
                mapping.containsPropertyKey(PropertyMapping.STROKE_COLOR));
        assertFalse("The mapping should not contains property name Font.", mapping.containsPropertyKey("Font"));
    }

    /**
     * <p>
     * Tests PropertyMapping#containsPropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey_NullName() throws Exception {
        try {
            mapping.containsPropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#containsPropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey_EmptyName() throws Exception {
        try {
            mapping.containsPropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#getPropertyKey(String name) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PropertyMapping#getPropertyKey(String name) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        assertEquals("The property key of " + PropertyMapping.FILL_COLOR + " should be fillColor.",
                mapping.getPropertyKey(PropertyMapping.FILL_COLOR), "fillColor");
        assertEquals("The property key of " + PropertyMapping.FONT_COLOR + " should be FontColorProperty.",
                mapping.getPropertyKey(PropertyMapping.FONT_COLOR), "FontColorProperty");
        assertEquals("The property key of " + PropertyMapping.FONT_FAMILY + " should be FontFamily.",
                mapping.getPropertyKey(PropertyMapping.FONT_FAMILY), "FontFamily");
        assertEquals("The property key of " + PropertyMapping.FONT_SIZE + " should be Font_Size.",
                mapping.getPropertyKey(PropertyMapping.FONT_SIZE), "Font_Size");
        assertEquals("The property key of " + PropertyMapping.STROKE_COLOR + " should be stroke_color.",
                mapping.getPropertyKey(PropertyMapping.STROKE_COLOR), "stroke_color");
        assertEquals("The property key of Font should be Font.", mapping.getPropertyKey("Font"), "Font");
    }

    /**
     * <p>
     * Tests PropertyMapping#getPropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey_NullName() throws Exception {
        try {
            mapping.getPropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#getPropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey_EmptyName() throws Exception {
        try {
            mapping.getPropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#addPropertyKey(String name, String key) for accuracy.
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
        assertNull("Add pair of a new name, the return value should be null.",
                mapping.addPropertyKey("Font", "FontKey"));
        assertEquals("The key of Font should be FontKey.", mapping.getPropertyKey("Font"), "FontKey");
        assertEquals("After add, the length of map should increased.", mapping.getPropertyNames().size(), 6);
        assertEquals("Add pair of a existed name, the old key should returned.",
                mapping.addPropertyKey("Font", "Font_Key"), "FontKey");
        assertEquals("The key of Font should be FontKey.", mapping.getPropertyKey("Font"), "Font_Key");
        assertEquals("After add, the length of map should increased.", mapping.getPropertyNames().size(), 6);
    }

    /**
     * <p>
     * Tests PropertyMapping#addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey_NullName() throws Exception {
        try {
            mapping.addPropertyKey(null, "key");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey_EmptyName() throws Exception {
        try {
            mapping.addPropertyKey("", "key");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey_NullKey() throws Exception {
        try {
            mapping.addPropertyKey("name", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey_EmptyKey() throws Exception {
        try {
            mapping.addPropertyKey("name", "");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#removePropertyKey(String name) for accuracy.
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
        assertEquals("PropertyMapping#removePropertyKey should return the key of the removed name.",
                mapping.removePropertyKey(PropertyMapping.FILL_COLOR), "fillColor");
        assertEquals("After remove, the size of the map should decreased.", mapping.getPropertyNames().size(), 4);
        assertNull("PropertyMapping#removePropertyKey should return null if the removed name doesn't in the map.",
                mapping.removePropertyKey("Font"));
        assertEquals("After remove not existed name, the size of the map should not change.",
                mapping.getPropertyNames().size(), 4);
    }

    /**
     * <p>
     * Tests PropertyMapping#removePropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey_NullName() throws Exception {
        try {
            mapping.removePropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#removePropertyKey(String name) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey_EmptyName() throws Exception {
        try {
            mapping.removePropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PropertyMapping#getPropertyNames() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PropertyMapping#getPropertyNames() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyNames() throws Exception {
        mapping = new PropertyMapping(VALID_NAMESPACE);
        assertEquals("The size of names set should equal with the map.", mapping.getPropertyNames().size(), 5);
        assertTrue("The names set should contain " + PropertyMapping.FILL_COLOR + ".",
                mapping.getPropertyNames().contains(PropertyMapping.FILL_COLOR));
        assertTrue("The names set should contain " + PropertyMapping.FONT_COLOR + ".",
                mapping.getPropertyNames().contains(PropertyMapping.FONT_COLOR));
        assertTrue("The names set should contain " + PropertyMapping.FONT_FAMILY + ".",
                mapping.getPropertyNames().contains(PropertyMapping.FONT_FAMILY));
        assertTrue("The names set should contain " + PropertyMapping.FONT_SIZE + ".",
                mapping.getPropertyNames().contains(PropertyMapping.FONT_SIZE));
        assertTrue("The names set should contain " + PropertyMapping.STROKE_COLOR + ".",
                mapping.getPropertyNames().contains(PropertyMapping.STROKE_COLOR));
    }
}
