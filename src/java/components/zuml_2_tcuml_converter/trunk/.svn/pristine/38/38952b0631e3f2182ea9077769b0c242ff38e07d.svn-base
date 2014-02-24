/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>UnsupportedVersionException</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnsupportedVersionExceptionUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(UnsupportedVersionExceptionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>UnsupportedVersionException(String, String[])</code>.
     * </p>
     */
    public void testCtor() {
        String version = "1.0";
        String[] acceptableVersions = new String[] {"1.0"};

        UnsupportedVersionException exception = new UnsupportedVersionException(version,
                acceptableVersions);
        assertNotNull("Unable to create UnsupportedVersionException.", exception);

        exception = new UnsupportedVersionException(null, acceptableVersions);
        assertNotNull("Unable to create UnsupportedVersionException instance.");

        exception = new UnsupportedVersionException(version, null);
        assertNotNull("Unable to create UnsupportedVersionException instance.");

        acceptableVersions[0] = null;

        exception = new UnsupportedVersionException(version, acceptableVersions);
        assertNotNull("Unable to create UnsupportedVersionException instance.");

        exception = new UnsupportedVersionException(" ", new String[0]);
        assertNotNull("Unable to create UnsupportedVersionException instance.");
    }

    /**
     * <p>
     * Accuracy test for <code>getCurrentVersion()</code>.
     * </p>
     */
    public void testGetCurrentVersion() {
        String version = "1.0";

        UnsupportedVersionException exception = new UnsupportedVersionException(version,
                null);
        assertNotNull("Unable to create UnsupportedVersionException.", exception);

        assertEquals("The version should be matched.", version,
            exception.getCurrentVersion());
    }

    /**
     * <p>
     * Accuracy test for <code>getAcceptableVersions()</code>.
     * </p>
     */
    public void testGetAcceptableVersions() {
        String version = "1.0";
        String[] acceptableVersions = new String[] {"1.0"};

        UnsupportedVersionException exception = new UnsupportedVersionException(version,
                acceptableVersions);
        assertNotNull("Unable to create UnsupportedVersionException.", exception);

        String[] vs = exception.getAcceptableVersions();
        assertEquals("The versions should match.", acceptableVersions[0], vs[0]);
    }
}
