/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.ConfigurationException;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TestHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>PropertyMapping</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class PropertyMappingFailureTest extends TestCase {

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
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor1() throws Exception {
        try {
            new PropertyMapping(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor2() throws Exception {
        try {
            new PropertyMapping("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor3() throws Exception {
        try {
            new PropertyMapping("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor4() throws Exception {
        try {
            new PropertyMapping("invalid_namespace");
            fail("ConfigurationException expected.");
        } catch (ConfigurationException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor5() throws Exception {
        try {
            new PropertyMapping(NULLNAME_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor6() throws Exception {
        try {
            new PropertyMapping(EMPTYNAME_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor7() throws Exception {
        try {
            new PropertyMapping(NULLKEY_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PropertyMapping(String namespace) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPropertyMappingCtor8() throws Exception {
        try {
            new PropertyMapping(EMPTYKEY_NAMESPACE);
            fail("ConfigurationException expected.");
        } catch (ConfigurationException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method containsPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey1() throws Exception {
        try {
            mapping.containsPropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method containsPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey2() throws Exception {
        try {
            mapping.containsPropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method containsPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContainsPropertyKey3() throws Exception {
        try {
            mapping.containsPropertyKey("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method getPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey1() throws Exception {
        try {
            mapping.getPropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method containsPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey2() throws Exception {
        try {
            mapping.getPropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method containsPropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPropertyKey3() throws Exception {
        try {
            mapping.getPropertyKey("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey1() throws Exception {
        try {
            mapping.addPropertyKey(null, "key");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey2() throws Exception {
        try {
            mapping.addPropertyKey("", "key");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey3() throws Exception {
        try {
            mapping.addPropertyKey("  ", "key");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey4() throws Exception {
        try {
            mapping.addPropertyKey("name", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey5() throws Exception {
        try {
            mapping.addPropertyKey("name", "");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method addPropertyKey(String name, String key) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddPropertyKey6() throws Exception {
        try {
            mapping.addPropertyKey("name", "   ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method removePropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey1() throws Exception {
        try {
            mapping.removePropertyKey(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method removePropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey2() throws Exception {
        try {
            mapping.removePropertyKey("");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests method removePropertyKey(String name) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemovePropertyKey3() throws Exception {
        try {
            mapping.removePropertyKey("  ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
}
