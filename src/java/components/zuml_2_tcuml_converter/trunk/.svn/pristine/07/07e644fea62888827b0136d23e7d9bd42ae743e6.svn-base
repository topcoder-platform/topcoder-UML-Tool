/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers;

import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * <p>
 * Unit tests for <code>RegexToLowerPropertyValueTransformer</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RegexToLowerPropertyValueTransformerUnitTest extends TestCase {
    /**
     * <p>The regular expression used in this unit test.</p>
     */
    private static final String EXPRESSION = "plainText";

    /**
     * <p>RegexToLowerPropertyValueTransformer instance for test.</p>
     */
    private RegexToLowerPropertyValueTransformer transformer;

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        transformer = new RegexToLowerPropertyValueTransformer(EXPRESSION);
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RegexToLowerPropertyValueTransformerUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Unable to create RegexToLowerPropertyValueTransformer instance.",
            transformer);
        assertTrue("The class should implements PropertyValueTransformer interface.",
            transformer instanceof PropertyValueTransformer);
    }

    /**
     * <p>
     * Failure test for constructor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the expression is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure1() {
        try {
            new RegexToLowerPropertyValueTransformer(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the expression is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Failure2() {
        try {
            new RegexToLowerPropertyValueTransformer("  ");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for constructor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the expression is invalid, PatternSyntaxException is expected.
     * </p>
     */
    public void testCtor_Failure3() {
        try {
            //Pattern *[ is invalid
            new RegexToLowerPropertyValueTransformer("*[");

            fail("PatternSyntaxException is expected.");
        } catch (PatternSyntaxException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>transform(String)</code>.
     * </p>
     */
    public void testTransform() {
        String value = null;
        assertNull("The tranform for null is null.",
            transformer.transform(value));

        value = "LETTER";

        String lower = "letter";
        assertEquals("The value should be transformed to lower case.", lower,
            transformer.transform(value));
    }

    /**
     * <p>
     * Accuracy test for <code>match(String)</code>.
     * </p>
     */
    public void testMatch() {
        assertFalse("The expression should not match.",
            transformer.match("unmatch"));
        assertTrue("The expression should match.", transformer.match(EXPRESSION));
        assertFalse("The expression should not match.", transformer.match(null));
        transformer = new RegexToLowerPropertyValueTransformer(".*");
        assertTrue("The expression null should match *.",
            transformer.match(null));
        assertTrue("The expression should match.",
            transformer.match("any thing"));
    }

    /**
     * <p>
     * Accuracy test for <code>getPattern()</code>.
     * </p>
     */
    public void testGetKeyPattern() {
        Pattern pattern = transformer.getKeyPattern();
        assertNotNull("The pattern should be valid.", pattern);

        assertEquals("The pattern is plainText.", EXPRESSION, pattern.pattern());
    }
}
