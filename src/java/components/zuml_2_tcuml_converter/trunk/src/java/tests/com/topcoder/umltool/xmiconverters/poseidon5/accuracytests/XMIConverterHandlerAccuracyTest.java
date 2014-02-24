/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import org.xml.sax.helpers.LocatorImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.AccuracyXMIConverterHandlerWrapper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.handlers.ZUMLHeaderHandler;
import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class XMIConverterHandler.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class XMIConverterHandlerAccuracyTest extends TestCase {

    /**
     * The instance of AccuracyXMIConverterHandlerAdapter for testing..
     */
    private AccuracyXMIConverterHandlerWrapper handler;

    /**
     * The instance of XMIHandler for testing..
     */
    private XMIHandler innerHandler;

    /**
     * The instance of XMIReader for testing..
     */
    private XMIReader reader;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMIConverterHandlerAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        // create a XMIReader and XMIHandler instance for testing
        reader = new XMIReader();

        innerHandler = new ZUMLHeaderHandler(new String[] {"1.4.5", "1.4.6" });

        // create the XMIConverterHandler for testing
        handler = new AccuracyXMIConverterHandlerWrapper(innerHandler, reader);
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
        assertTrue("Should implement XMIHandler", handler instanceof XMIHandler);
    }

    /**
     * <p>
     * Accuracy test for <code>XMIConverterHandler(XMIHandler, XMIReader)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>XMIConverterHandler(XMIHandler, XMIReader)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should not be null.", handler);
    }

    /**
     * <p>
     * Accuracy test for <code>addConverter(XMIConverter)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>addConverter(XMIConverter)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAddConverter_Accuracy() throws Exception {
        XMIConverter converter = new AccuracyMockDefaultXMIConverter();
        handler.addConverter(converter);
        // should succeed
    }

    /**
     * <p>
     * Accuracy test for <code>setXMIReader(XMIReader)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>setXMIReader(XMIReader)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testSetXMIReader_Accuracy() throws Exception {
        handler.setXMIReader(new XMIReader());
        // should be succeed
    }

    /**
     * <p>
     * Accuracy test for <code>getLastRefObject()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getLastRefObject()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testGetLastRefObject_Accuracy() throws Exception {
        assertNull("Should be null.", handler.getLastRefObject());
    }

    /**
     * <p>
     * Accuracy test for <code>getLastProperty()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getLastProperty()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testGetLastProperty_Accuracy() throws Exception {
        assertNull("Should be null.", handler.getLastProperty());
        // should succeed
    }

    /**
     * <p>
     * Accuracy test for <code>setDocumentLocator(Locator)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>setDocumentLocator(Locator)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testSetDocumentLocator_Accuracy() throws Exception {
        handler.setDocumentLocator(new LocatorImpl());
        // should succeed
    }
}
