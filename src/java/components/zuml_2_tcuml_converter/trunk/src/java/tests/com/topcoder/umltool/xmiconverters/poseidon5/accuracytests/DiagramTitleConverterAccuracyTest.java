/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.util.Map;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramTitleConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class DiagramTitleConverter.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class DiagramTitleConverterAccuracyTest extends TestCase {

    /**
     * Represents the default namespace.
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * The instance of DiagramTitleConverter for testing..
     */
    private DiagramTitleConverter converter;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DiagramTitleConverterAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.clearConfig();
        AccuracyTestHelper.loadConfig("config_diagram_title_converter.xml");
        converter = new DiagramTitleConverter();
    }

    /**
     * Cleans up the environment.
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy test for the base class.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testStaticFields_Accuracy() throws Exception {
        assertEquals("Expected Namespace:", DEFAULT_NAMESPACE,
                DiagramTitleConverter.DEFAULT_NAMESPACE);
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
        assertTrue("Should implement DefaultXMIConverter",
                converter instanceof DefaultXMIConverter);
    }

    /**
     * <p>
     * Accuracy test for <code>DiagramTitleConverter(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>DiagramTitleConverter(String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor1_Accuracy() throws Exception {
        converter = new DiagramTitleConverter(DEFAULT_NAMESPACE);
        assertNotNull("Should not be null", converter);
        // test the value of the fields
        boolean convertToTextElement = (Boolean) AccuracyTestHelper.getField(converter, converter
                .getClass(), "convertToTextElement");
        assertTrue("Should be true.", convertToTextElement);
        Map textElementProperties = (Map) AccuracyTestHelper.getField(converter, converter
                .getClass(), "textElementProperties");
        assertEquals("Expected number of properties: ", 2, textElementProperties.size());
    }

    /**
     * <p>
     * Accuracy test for <code>DiagramTitleConverter()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>DiagramTitleConverter()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor2_Accuracy() throws Exception {
        assertNotNull("Should not be null", converter);
        // test the value of the fields
        boolean convertToTextElement = (Boolean) AccuracyTestHelper.getField(converter, converter
                .getClass(), "convertToTextElement");
        assertTrue("Should be true.", convertToTextElement);
        Map textElementProperties = (Map) AccuracyTestHelper.getField(converter, converter
                .getClass(), "textElementProperties");
        assertEquals("Expected number of properties: ", 2, textElementProperties.size());
    }
}
