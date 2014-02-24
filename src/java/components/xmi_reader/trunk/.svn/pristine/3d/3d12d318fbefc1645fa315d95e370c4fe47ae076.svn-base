/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class DefaultXMIHandle. Since DefaultXMIHandle is abstract class the simple
 * sub-class MockClassSimpleXMIHandler will be used for testing. You can refer to
 * MockClassSimpleXMIHandler for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultXMIHandlerUnitTests extends TestCase {
    /**
     * The DefaultXMIHandler instance for testing(actually it is of class
     * MockClassSimpleXMIHandler).
     */
    private DefaultXMIHandler handler;

    /**
     * XMIReader instance for testing.
     */
    private XMIReader reader;

    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        handler = new MockClassSimpleXMIHandler();
        reader = new XMIReader();
    }

    /**
     * Test of constructor DefaultXMIHandler() for accuracy. The object is created successfully and
     * also all the properties are set to null.
     */
    public void testCtor1Accuracy() {
        // just use object created in set Up method
        // tests creation
        assertNotNull("Failed to implement constructor with no-argument for DefaultXMIHandler.",
            handler);

        // tests default values for properties
        assertNull("Failed to initialize properties with default value.", handler.getXMIReader());
        assertNull("Failed to initialize properties with default value.", handler.getLastRefObject());
        assertNull("Failed to initialize properties with default value.", handler.getLastProperty());
    }

    /**
     * Test of constructor DefaultXMIHandler(XMIReader) for accuracy. The object is created
     * successfully, reader is set and all other properties are set to null.
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy() throws Exception {
        handler = new MockClassSimpleXMIHandler(reader);
        assertNotNull("Failed to implement constructor with reader for DefaultXMIHandler.", handler);

        // tests values for properties
        assertEquals("Failed to implement constructor with reader for DefaultXMIHandler.", reader,
            handler.getXMIReader());
        assertNull("Failed to initialize properties with default value.", handler.getLastRefObject());
        assertNull("Failed to initialize properties with default value.", handler.getLastProperty());
    }

    /**
     * Test of constructor DefaultXMIHandler(XMIReader) with null input. IllegalArgumentException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithNullReader() throws Exception {
        try {
            new MockClassSimpleXMIHandler(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of methods getXMIReader for accuracy. Tries to get the value initialized in
     * constructor.
     *
     * @throws Exception when error occurs
     */
    public void testGetXMIReaderAccuracy() throws Exception {
        handler = new MockClassSimpleXMIHandler(reader);
        assertEquals("Getter for XMIReader is not implemented correctly.", reader,
            handler.getXMIReader());
    }

    /**
     * Test of methods setXMIReader for accuracy.
     *
     * @throws Exception when error occurs
     */
    public void testSetXMIReaderAccuracy() throws Exception {
        handler.setXMIReader(reader);
        assertEquals("Setter for XMIReader is not implemented correctly.", reader,
            handler.getXMIReader());
    }

    /**
     * Test of methods setXMIReader with null input. IllegalArgumentException is expected.
     */
    public void testSetXMIReaderWithNullInput() {
        try {
            handler.setXMIReader(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of methods setXMIReader with reader being set. IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testSetXMIReaderWithReaderBeingSet() throws Exception {
        handler.setXMIReader(reader);

        try {
            //sets again
            handler.setXMIReader(reader);
            fail("IllegalStateException is expected.");
        } catch (IllegalStateException ise) {
            // good
        }
    }

    /**
     * Test of getLastRefObject for accuracy. Tests getting the default value.
     */
    public void testGetLastRefObjectAccuracy() {
        assertNull("Failed to implement getLastRefObject.", handler.getLastRefObject());
    }

    /**
     * Test of setLastRefObject for accuracy. Input is normal value. The value will be get after
     * setting.
     */
    public void testSetLastRefObjectAccuracy1() {
        Object lastRefObject = new Object();
        handler.setLastRefObject(lastRefObject);
        assertEquals("Setter for lastRefObject is not implemented correctly.", lastRefObject,
            handler.getLastRefObject());
    }

    /**
     * Test of setLastRefObject for accuracy. Input is null value. All works well.
     */
    public void testSetLastRefObjectAccuracy2() {
        // first, let's overwrite the default value
        handler.setLastRefObject("overwrite");

        // sets null
        handler.setLastRefObject(null);
        assertNull("Setter for lastRefObject is not implemented correctly.",
            handler.getLastRefObject());
    }

    /**
     * Test of getLastProperty for accuracy. Test getting the default value.
     */
    public void testGetLastPropertyAccuracy() {
        assertNull("Failed to implement getLastProperty.", handler.getLastProperty());
    }

    /**
     * Test of setLastProperty for accuracy. Tests setting normal String value.
     */
    public void testSetLastPropertyAccuracy1() {
        handler.setLastProperty("Reviewers");
        assertEquals("Setter for lastProperty is not implemented correctly.", "Reviewers",
            handler.getLastProperty());
    }

    /**
     * Test of setLastProperty for accuracy. Tests setting normal null value.
     */
    public void testSetLastPropertyAccuracy2() {
        // first, let's overwrite the default value
        handler.setLastProperty("overwrite");

        // sets null
        handler.setLastProperty(null);
        assertNull("Setter for lastProperty is not implemented correctly.",
            handler.getLastProperty());
    }

    /**
     * Test of setLastProperty with empty String (trimmed). IllegalArgumentException is expected.
     */
    public void testSetLastPropertyWithTrimmedEmptyString() {
        try {
            handler.setLastProperty("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of setLastProperty with empty String. IllegalArgumentException is expected.
     */
    public void testSetLastPropertyWithEmptyString() {
        try {
            handler.setLastProperty("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
