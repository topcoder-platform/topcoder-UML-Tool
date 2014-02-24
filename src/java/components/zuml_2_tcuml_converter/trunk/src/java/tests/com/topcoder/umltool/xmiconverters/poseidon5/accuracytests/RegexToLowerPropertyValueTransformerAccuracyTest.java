/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Accuracy test cases for class RegexToLowerPropertyValueTransformer.
 * </p>
 *
 * @author abram
 * @version 1.0
 */
public class RegexToLowerPropertyValueTransformerAccuracyTest extends TestCase {

    /**
     * Represents the regular expression.
     */
    private static final String REGULAR_EXPRESSION = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";

    /**
     * The instance of RegexToLowerPropertyValueTransformer for testing.
     */
    private RegexToLowerPropertyValueTransformer transformer;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RegexToLowerPropertyValueTransformerAccuracyTest.class);
    }

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        transformer = new RegexToLowerPropertyValueTransformer(REGULAR_EXPRESSION);
    }

    /**
     * Cleans up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
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
        assertTrue("Should implement PropertyValueTransformer",
            transformer instanceof PropertyValueTransformer);
    }

    /**
     * <p>
     * Accuracy test for <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>RegexToLowerPropertyValueTransformer(String)</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should not be null.", transformer);
    }

    /**
     * <p>
     * Accuracy test for <code>transform(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>transform(String)</code> is correct when the value is null.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testTransform_Accuracy1() throws Exception {
        assertNull("Should return null.", transformer.transform(null));
    }

    /**
     * <p>
     * Accuracy test for <code>transform(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>transform(String)</code> is correct when the value is not null.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testTransform_Accuracy2() throws Exception {
        assertEquals("Expected value: ", "abcabc", transformer.transform("ABCabc"));
    }

    /**
     * <p>
     * Accuracy test for <code>match(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>match(String)</code> is correct when the key is null and
     * keyPattern is "*".
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testMatch_Accuracy1() throws Exception {
        transformer = new RegexToLowerPropertyValueTransformer(".*");
        assertTrue("Should be true.", transformer.match(null));

        transformer = new RegexToLowerPropertyValueTransformer(".");
        assertFalse("Should be false.", transformer.match(null));
    }

    /**
     * <p>
     * Accuracy test for <code>match(String)</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>match(String)</code> is correct when the key is not null.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testMatch_Accuracy2() throws Exception {
        assertFalse("Should be false.", transformer.match("NoMatch"));
        assertTrue("Should be true.", transformer.match("aaa@bbb.com"));
    }

    /**
     * <p>
     * Accuracy test for <code>getKeyPattern()</code>.
     * </p>
     *
     * <p>
     * Target: Verify that <code>getKeyPattern()</code> is correct.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testGetKeyPattern_Accuracy() throws Exception {
        assertEquals("Expected pattern:", REGULAR_EXPRESSION, transformer.getKeyPattern().pattern());
    }
}
