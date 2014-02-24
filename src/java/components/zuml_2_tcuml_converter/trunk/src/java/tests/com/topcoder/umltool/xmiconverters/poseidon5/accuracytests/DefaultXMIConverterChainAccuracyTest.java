/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.AccuracyDefaultXMIConverterChainWrapper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class DefaultXMIConverterChain.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class DefaultXMIConverterChainAccuracyTest extends TestCase {

    /**
     * The instance of XMIConverterChain for testing..
     */
    private XMIConverterChain next;

    /**
     * The instance of XMIConverter for testing..
     */
    private XMIConverter converter;

    /**
     * The instance of DefaultXMIConverterChain for testing..
     */
    private AccuracyDefaultXMIConverterChainWrapper chain;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultXMIConverterChainAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        // create next and converter
        next = new AccuracyDefaultXMIConverterChainWrapper();
        converter = new AccuracyMockDefaultXMIConverter();

        // create the XMIConverterChain
        chain = new AccuracyDefaultXMIConverterChainWrapper(next, converter);
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
        assertTrue("Should implement XMIConverterChain", chain instanceof XMIConverterChain);
    }

    /**
     * <p>
     * Accuracy test for <code>DefaultXMIConverterChain()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>DefaultXMIConverterChain()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor1_Accuracy() throws Exception {
        chain = new AccuracyDefaultXMIConverterChainWrapper();
        assertNull("Next should be null.", chain.getNext());
        assertNull("Converter should be null.", chain.getConverter());
    }

    /**
     * <p>
     * Accuracy test for <code>DefaultXMIConverterChain(XMIConverterChain, XMIConverter)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>DefaultXMIConverterChain(XMIConverterChain, XMIConverter)</code>
     * is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor2_Accuracy() throws Exception {
        assertNotNull("Should be created", chain);
    }

    /**
     * <p>
     * Accuracy test for <code>getNext()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getNext()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testGetNext_Accuracy() throws Exception {
        assertSame("Expected Next: ", next, chain.getNext());
    }

    /**
     * <p>
     * Accuracy test for <code>getConverter()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getConverter()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testGetConverter_Accuracy() throws Exception {
        assertSame("Expected Converter: ", converter, chain.getConverter());
    }
}
