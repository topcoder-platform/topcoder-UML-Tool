/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.handlers.UnsupportedVersionException;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.xmi.reader.DefaultXMIHandler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class ZUMLHeaderHandler.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class ZUMLHeaderHandlerAccuracyTest extends TestCase {

    /**
     * <p>The qname of version element.</p>
     */
    private static final String VERSION_QNAME = "XMI.metaModelVersion";

    /**
     * The instance of ZUMLHeaderHandler for testing.
     */
    private ZUMLHeaderHandler handler;

    /**
     * Array of acceptable versions.
     */
    private String[] acceptableVersions;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLHeaderHandlerAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        acceptableVersions = new String[] {"1.4.5", "1.4.6" };
        handler = new ZUMLHeaderHandler(acceptableVersions);
    }

    /**
     * <p>
     * Accuracy test for the base class.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testBase_Accuracy() throws Exception {
        assertTrue("Should implement DefaultXMIHandler", handler instanceof DefaultXMIHandler);
    }

    /**
     * <p>
     * Accuracy test for <code>ZUMLHeaderHandler(String[])</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>ZUMLHeaderHandler(String[])</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should not be null", handler);
    }

    /**
     * <p>
     * Accuracy test for <code>startElement(String, String, String, Attributes)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>startElement(String, String, String, Attributes)</code> is
     * correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testStartElement_Accuracy() throws Exception {
        handler.startElement(null, null, VERSION_QNAME, null);

        // test the side-effect of startElement
        try {
            handler.characters(new char[0], 0, 0);
            fail("startElement(String, String, String, Attributes) should set inMetaModelVersionElement to true.");
        } catch (UnsupportedVersionException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>endElement(String, String, String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>endElement(String, String, String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testEndElement_Accuracy() throws Exception {
        handler.endElement(null, null, VERSION_QNAME);

        // test the side-effect of endElement
        handler.characters(new char[0], 0, 0);
        // should succeed
    }

    /**
     * <p>
     * Accuracy test for <code>characters(char[], int, int)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>characters(char[], int, int)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCharacters_Accuracy() throws Exception {
        handler.startElement(null, null, VERSION_QNAME, null);

        char[] ch = acceptableVersions[0].toCharArray();
        handler.characters(ch, 0, ch.length);
        // should succeed
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
     * @throws Exception
     *             to JUnit.
     */
    public void testGetAcceptableVersions_Accuracy() throws Exception {
        for (int idx = 0; idx < acceptableVersions.length; idx++) {
            assertEquals("Expected version:", acceptableVersions[idx], handler
                    .getAcceptableVersions()[idx]);
        }
    }
}
