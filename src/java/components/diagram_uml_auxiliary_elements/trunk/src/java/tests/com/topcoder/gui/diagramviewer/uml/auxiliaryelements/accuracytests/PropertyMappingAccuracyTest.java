/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.util.Set;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Accuracy test for <code>PropertyMapping</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class PropertyMappingAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance of PropertyMapping used for test.
     * </p>
     */
    private PropertyMapping propertyMapping;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void setUp() throws Exception {
        ConfigHelper.clearConfigration();
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        propertyMapping = new PropertyMapping(ConfigHelper.ACC_NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        ConfigHelper.clearConfigration();
        propertyMapping = null;
    }

    /**
     * <p>
     * Tests accuracy of <code>PropertyMapping(String)</code>.
     * </p>
     */
    public void testPropertyMappingStringAccuracy() {

        // creation
        assertNotNull("Instance should be created correctly.", propertyMapping);

        // keys
        assertTrue("Instance should contain the key of " + PropertyMapping.STROKE_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.STROKE_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FILL_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.FILL_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_FAMILY, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_FAMILY));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_SIZE, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_SIZE));

        // values
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.STROKE_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FILL_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_FAMILY,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_FAMILY));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_SIZE,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_SIZE));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_COLOR));
    }

    /**
     * <p>
     * Test accuracy of <code>ContainsPropertyKey(String)</code>.
     * </p>
     */
    public void testContainsPropertyKeyAccuracy() {
        // contains
        assertTrue("Instance should contain the key of " + PropertyMapping.STROKE_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.STROKE_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FILL_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.FILL_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_COLOR, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_COLOR));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_FAMILY, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_FAMILY));
        assertTrue("Instance should contain the key of " + PropertyMapping.FONT_SIZE, propertyMapping
            .containsPropertyKey(PropertyMapping.FONT_SIZE));

        // not contain
        assertFalse("The mapping should not contains other properties.", propertyMapping
            .containsPropertyKey("NonExist"));
    }

    /**
     * <p>
     * Test accuracy of <code>GetPropertyKey(String)</code>.
     * </p>
     */
    public void testGetPropertyKeyStringAccuracy() {
        // values
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.STROKE_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FILL_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_FAMILY,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_FAMILY));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_SIZE,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_SIZE));
        assertEquals("value should be loaded to PropertyMapping correctly.", PropertyMapping.FONT_COLOR,
            propertyMapping.getPropertyKey(PropertyMapping.FONT_COLOR));
    }

    /**
     * <p>
     * Test accuracy of <code>AddPropertyKey(String, String)</code>.
     * </p>
     */
    public void testAddPropertyKeyStringStringAccuracy() {
        // firstly get key for an non-existing name;
        assertEquals("Value should be returned correctly.", "NonExist", propertyMapping
            .getPropertyKey("NonExist"));
        // add new name-key
        assertNull("null value should be returned.", propertyMapping.addPropertyKey("ABC", "ABCD"));
        // validate
        assertEquals("key should be added correctly.", "ABCD", propertyMapping.getPropertyKey("ABC"));

        // add again
        assertEquals("Old value should be returned when adding.", "ABCD", propertyMapping.addPropertyKey(
            "ABC", "EFG"));
        // validate
        assertEquals("New value should be returned after adding.", "EFG", propertyMapping
            .getPropertyKey("ABC"));
    }

    /**
     * <p>
     * Test accuracy of <code>RemovePropertyKey(String)</code>.
     * </p>
     */
    public void testRemovePropertyKeyStringAccuracy() {

        // remove existing name
        assertEquals("value should be returned correctly", PropertyMapping.STROKE_COLOR, propertyMapping
            .removePropertyKey(PropertyMapping.STROKE_COLOR));
        // validate
        assertFalse("value should be removed correctly.", propertyMapping
            .containsPropertyKey(PropertyMapping.STROKE_COLOR));

        // remove non-existing name and return old name
        assertNull("null value should be returned", propertyMapping.removePropertyKey("ABC"));
    }

    /**
     * <p>
     * Test accuracy of <code>GetPropertyName()</code>.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetPropertyNames() throws Exception {
        Set keySet = propertyMapping.getPropertyNames();
        assertEquals("size of returned set should be correct", keySet.size(), 5);
        assertTrue(PropertyMapping.STROKE_COLOR + " should be contained in the set", keySet
            .contains(PropertyMapping.STROKE_COLOR));
        assertTrue(PropertyMapping.FILL_COLOR + " should be contained in the set", keySet
            .contains(PropertyMapping.FILL_COLOR));
        assertTrue(PropertyMapping.FONT_COLOR + " should be contained in the set", keySet
            .contains(PropertyMapping.FONT_COLOR));
        assertTrue(PropertyMapping.FONT_FAMILY + " should be contained in the set", keySet
            .contains(PropertyMapping.FONT_FAMILY));
        assertTrue(PropertyMapping.FONT_SIZE + " should be contained in the set", keySet
            .contains(PropertyMapping.FONT_SIZE));

        // TODO: removable ?
    }
}
