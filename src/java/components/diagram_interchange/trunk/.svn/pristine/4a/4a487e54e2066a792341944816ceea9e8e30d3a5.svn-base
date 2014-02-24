/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ PropertyAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Property;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Property</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Property</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class PropertyAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Property</code> used for tests.
     * </p>
     */
    private Property test = null;

    /**
     * <p>
     * Test suite of <code>PropertyAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>PropertyAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(PropertyAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Property();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Property()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Property());

        // get the original value of key to check the constructor
        assertNull("The key expected to be null", test.getKey());
        // get the original value of value to check the constructor
        assertNull("The value expected to be null", test.getValue());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setKey(String)</code> method and
     * <code>getKey()</code>.
     * </p>
     */
    public void testKey_Operation() {
        String [] keys = new String [] {"Top", "Coder", "Dev", "Des"};
        for (String key : keys) {
            // set the key.
            test.setKey(key);
            // get the key.
            assertEquals("The key expected to be equal", key,
                test.getKey());
        }
        // set the key to null.
        test.setKey(null);
         // get the key.
        assertNull("The key expected to be null", test.getKey());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setValue(String)</code> method and
     * <code>getValue()</code>.
     * </p>
     */
    public void testValue_Operation() {
        String [] values = new String [] {"Top", "Coder", "Dev", "Des"};
        for (String value : values) {
            // set the value.
            test.setValue(value);
            // get the value.
            assertEquals("The value expected to be equal", value,
                test.getValue());
        }
        // set the value to null.
        test.setValue(null);
         // get the value.
        assertNull("The value expected to be null", test.getValue());
    }
}
