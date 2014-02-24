/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ZUMLHeaderHandler</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZUMLHeaderHandlerUnitTest extends TestCase {
    /**
     * <p>Qname for version element.</p>
     */
    private static final String QNAME = "XMI.metaModelVersion";

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLHeaderHandlerUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     */
    public void testCtor() {
        //test with empty string array
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);
        assertNotNull("Unable to create ZUMLHeaderHandler instance.", handler);

        handler = new ZUMLHeaderHandler(new String[] {"1.0", "2.0"});
        assertNotNull("Unable to create ZUMLHeaderHandler instance.", handler);
    }

    /**
     * <p>
     * Failure test for <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the acceptableVersions is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure1() {
        try {
            new ZUMLHeaderHandler(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the acceptableVersions contains null string,
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure2() {
        try {
            new ZUMLHeaderHandler(new String[] {null});
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the acceptableVersions contains empty string,
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure3() {
        try {
            new ZUMLHeaderHandler(new String[] {"   "});
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testStartElement1() {
        //It support none version
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        try {
            handler.characters("1.0".toCharArray(), 0, 3);
            fail("UnsupportedVersionException is expected.");
        } catch (UnsupportedVersionException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testStartElement2() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[] {"1.0"});
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        try {
            //It should process successfully, 1.0 is allowed
            handler.characters("1.0".toCharArray(), 0, 3);
        } catch (UnsupportedVersionException e) {
            fail("UnsupportedVersionException is unexpected.");
        }

        //Leave the version element
        handler.endElement(null, null, QNAME);

        // It should not set isMetaModelVersion to true
        handler.startElement(null, null, "other element", null);
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testStartElement3() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[] {"1.0"});

        // It should not set isMetaModelVersion to true
        handler.startElement(null, null, "other element", null);

        try {
            //Although 2.0 is not allowed, it should not check
            handler.characters("2.0".toCharArray(), 0, 3);
        } catch (UnsupportedVersionException e) {
            fail("UnsupportedVersionException is unexpected.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testEndElement1() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        try {
            //1.0 is not allowed, UnsupportedVersion is expected.
            handler.characters("1.0".toCharArray(), 0, 3);
            fail("UnsupportedVersionException is expected.");
        } catch (UnsupportedVersionException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testEndElement2() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        //Leave the header element, should set isMetaModelVersion to false
        handler.endElement(null, null, QNAME);

        try {
            //1.0 is not allowed, but it's not in version element now.
            //It should process successfully
            handler.characters("1.0".toCharArray(), 0, 3);
        } catch (UnsupportedVersionException e) {
            fail("UnsupportedVersionException is unexpected.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String, Attributes)</code>.
     * </p>
     */
    public void testEndElement3() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);

        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);
        //It should not leave version element
        handler.endElement(null, null, "other element");

        try {
            //1.0 is not allowed, UnsupportedVersion is expected.
            handler.characters("1.0".toCharArray(), 0, 3);
            fail("UnsupportedVersionException is expected.");
        } catch (UnsupportedVersionException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>character(char[], int, int)</code>.
     * </p>
     */
    public void testCharacter1() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[] {"1.0"});
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        try {
            //It should process successfully, 1.0 is allowed
            handler.characters("1.0".toCharArray(), 0, 3);
        } catch (UnsupportedVersionException e) {
            fail("UnsupportedVersionException is unexpected.");
        }
    }

    /**
     * <p>
     * Accuracy test for <code>character(char[], int, int)</code>.
     * </p>
     */
    public void testCharacter2() {
        //Set acceptable versions to 1.0
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[] {"1.0"});
        //It should set isMetaModelVersion to true
        handler.startElement(null, null, QNAME, null);

        try {
            //It should process successfully, 2.0 is not allowed, UnsupportedVersionException is expected.
            handler.characters("2.0".toCharArray(), 0, 3);
            fail("UnsupportedVersionException is expected.");
        } catch (UnsupportedVersionException e) {
            //sucess
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getAcceptableVersions()</code>.
     * </p>
     */
    public void testGetAcceptableVersions() {
        ZUMLHeaderHandler handler = new ZUMLHeaderHandler(new String[0]);
        assertEquals("The acceptableVersions' size should be 0.", 0,
            handler.getAcceptableVersions().length);

        handler = new ZUMLHeaderHandler(new String[] {"1.0", "2.0"});
        assertEquals("The acceptableVersions's size should be 2.", 2,
            handler.getAcceptableVersions().length);
        assertEquals("The versions should match.", "1.0",
            handler.getAcceptableVersions()[0]);
        assertEquals("The versions should match.", "2.0",
            handler.getAcceptableVersions()[1]);
    }
}
