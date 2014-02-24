/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ ImageAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Image;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Image</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Image</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ImageAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Image</code> used for tests.
     * </p>
     */
    private Image test = null;

    /**
     * <p>
     * Test suite of <code>ImageAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ImageAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ImageAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Image();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Image()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Image());

        // get the original value of mimeType to check the constructor
        assertNull("The mimeType expected to be null", test.getMimeType());

        // get the original value of uri to check the constructor
        assertNull("The uri expected to be null", test.getUri());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setMimeType(String)</code> method and
     * <code>getMimeType()</code>.
     * </p>
     */
    public void testMimeType_Operation() {
        // set the mimeType.
        test.setMimeType("Top Coder");

        // get the mimeType.
        assertEquals("The mimeType expected to be equal", "Top Coder",
            test.getMimeType());

        // set the mimeType to null.
        test.setMimeType(null);

        // get the mimeType.
        assertNull("The mimeType expected to be null", test.getMimeType());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setUri(String)</code> method and
     * <code>getUri()</code>.
     * </p>
     */
    public void testUri_Operation() {
        // set the uri.
        test.setUri("Top Coder");

        // get the uri.
        assertEquals("The uri expected to be equal", "Top Coder", test.getUri());

        // set the uri to null.
        test.setUri(null);

        // get the uri.
        assertNull("The uri expected to be null", test.getUri());
    }
}
