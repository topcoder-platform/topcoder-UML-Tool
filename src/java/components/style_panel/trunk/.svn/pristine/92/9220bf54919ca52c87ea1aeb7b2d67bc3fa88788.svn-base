/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import com.topcoder.gui.panels.style.styleobject.MockAbstractStyleObject;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StyleEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StyleEventTests extends TestCase {
    /**
     * <p>
     * The constant represents the changed key for testing.
     * </p>
     */
    private static final String CHANGEDKEY = "key";

    /**
     * <p>
     * The constant represents the old value for testing.
     * </p>
     */
    private static final String OLDVALUE = "oldValue";

    /**
     * <p>
     * The constant represents the new value for testing.
     * </p>
     */
    private static final String NEWVALUE = "newValue";

    /**
     * <p>
     * The StyleEvent instance for testing.
     * </p>
     */
    private StyleEvent styleEvent;

    /**
     * <p>
     * The StyleObject instance for testing.
     * </p>
     */
    private StyleObject styleObject;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        styleObject = new MockAbstractStyleObject();
        styleEvent = new StyleEvent(styleObject, CHANGEDKEY, OLDVALUE, NEWVALUE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        styleEvent = null;
        styleObject = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(StyleEventTests.class);
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created StyleEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new StyleEvent instance.", styleEvent);
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when styleObject is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullStyleObject() {
        try {
            new StyleEvent(null, CHANGEDKEY, OLDVALUE, NEWVALUE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when changedKey is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullChangedKey() {
        try {
            new StyleEvent(styleObject, null, OLDVALUE, NEWVALUE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when changedKey is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyChangedKey() {
        try {
            new StyleEvent(styleObject, " ", OLDVALUE, NEWVALUE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldValue is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullOldValue() {
        try {
            new StyleEvent(styleObject, CHANGEDKEY, null, NEWVALUE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldValue is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyOldValue() {
        try {
            new StyleEvent(styleObject, CHANGEDKEY, " ", NEWVALUE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newValue is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewValue() {
        try {
            new StyleEvent(styleObject, CHANGEDKEY, OLDVALUE, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor StyleEvent#StyleEvent(StyleObject,String,String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newValue is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNewValue() {
        try {
            new StyleEvent(styleObject, CHANGEDKEY, OLDVALUE, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StyleEvent#getStyleObject() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StyleEvent#getStyleObject() returns the correct style object.
     * </p>
     */
    public void testGetStyleObject() {
        assertSame("Failed to return correct value.", styleObject, styleEvent.getStyleObject());
    }

    /**
     * <p>
     * Tests StyleEvent#getChangedKey() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StyleEvent#getChangedKey() returns the correct changed key.
     * </p>
     */
    public void testGetChangedKey() {
        assertEquals("Failed to return correct value.", CHANGEDKEY, styleEvent.getChangedKey());
    }

    /**
     * <p>
     * Tests StyleEvent#getNewValue() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StyleEvent#getNewValue() returns the correct new value.
     * </p>
     */
    public void testGetNewValue() {
        assertEquals("Failed to return correct value.", NEWVALUE, styleEvent.getNewValue());
    }

    /**
     * <p>
     * Tests StyleEvent#getOldValue() for accuracy.
     * </p>
     *
     * <p>
     * Verify : StyleEvent#getOldValue() returns the correct old value.
     * </p>
     */
    public void testGetOldValue() {
        assertEquals("Failed to return correct value.", OLDVALUE, styleEvent.getOldValue());
    }

}