/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import org.xml.sax.SAXException;

import com.topcoder.umltool.xmiconverters.poseidon5.handlers.UnsupportedVersionException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class UnsupportedVersionException.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class UnsupportedVersionExceptionAccuracyTest extends TestCase {

    /**
     * The instance of UnsupportedVersionException for testing.
     */
    private UnsupportedVersionException exception;

    /**
     * Represents the currentVersion.
     */
    private String currentVersion = "curVersion";

    /**
     * Array of acceptable versions.
     */
    private String[] acceptableVersions = new String[] {"ver1,ver2" };

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        exception = new UnsupportedVersionException(currentVersion, acceptableVersions);
    }

    /**
     * Cleans up the environment.
     */
    protected void tearDown() {
        exception = null;
    }

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UnsupportedVersionExceptionAccuracyTest.class);
    }

    /**
     * <p>
     * Test for base class.
     * </p>
     *
     * <p>
     * Tests it for accuracy.
     * </p>
     */
    public void testBase_Accuracy() {
        assertTrue("Should extends SAXException", exception instanceof SAXException);
    }

    /**
     * <p>
     * Test for constructor.
     * </p>
     *
     * <p>
     * Tests it for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("The acceptableVersions should have been set.", exception
                .getAcceptableVersions());
    }

    /**
     * <p>
     * Accuracy test for <code>getCurrentVersion()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getCurrentVersion()</code> is correct.
     * </p>
     *
     */
    public void testGetCurrentVersion_Accuracy() {
        assertEquals("Expected currentVersion: ", currentVersion, exception.getCurrentVersion());
    }

    /**
     * <p>
     * Accuracy test for <code>getAcceptableVersions()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getAcceptableVersions()</code> is correct.
     * </p>
     *
     */
    public void testGetAcceptableVersions_Accuracy1() {
        for (int idx = 0; idx < acceptableVersions.length; idx++) {
            assertEquals("Expected version:", acceptableVersions[idx], exception
                    .getAcceptableVersions()[idx]);
        }
    }
}
