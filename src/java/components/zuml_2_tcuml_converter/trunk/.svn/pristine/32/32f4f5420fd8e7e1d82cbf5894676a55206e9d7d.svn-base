/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import java.util.regex.PatternSyntaxException;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers.RegexToLowerPropertyValueTransformer;

/**
 * <p>
 * Failure test fixture for <code>RegexToLowerPropertyValueTransformer</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class RegexToLowerPropertyValueTransformerFailureTests extends TestCase {
    /**
     * <p>
     * Tests the ctor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     * <p>
     * When the expression is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Null() {
        try {
            new RegexToLowerPropertyValueTransformer(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     * <p>
     * When the expression is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor_Empty() {
        try {
            new RegexToLowerPropertyValueTransformer("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>RegexToLowerPropertyValueTransformer(String)</code>.
     * </p>
     * <p>
     * When the expression is invalid, PatternSyntaxException is expected.
     * </p>
     */
    public void testCtor_InvalidPattern() {
        try {
            new RegexToLowerPropertyValueTransformer("**");
            fail("PatternSyntaxException is expected.");
        } catch (PatternSyntaxException e) {
            // success
        }
    }
}
