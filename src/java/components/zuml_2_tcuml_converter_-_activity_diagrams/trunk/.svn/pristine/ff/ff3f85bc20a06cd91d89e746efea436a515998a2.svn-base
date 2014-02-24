package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLOpaqueExpression;

import junit.framework.TestCase;

public class AbstractZUMLOpaqueExpressionFailureTest extends TestCase {

    private AbstractZUMLOpaqueExpression instance = new MockZUMLOpaqueExpression();

    /**
     * Failure Test for {@link AbstractZUMLOpaqueExpression#setBody(String)}. body is null and IAE is expected.
     */
    public void testSetBody_Failure() {
        try {
            instance.setBody(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLOpaqueExpression#setLanguage(String)}. language is null and IAE is
     * expected.
     */
    public void testSetLanguage_Failure1() {
        try {
            instance.setLanguage(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLOpaqueExpression#setLanguage(String)}. language is empty and IAE is
     * expected.
     */
    public void testSetLanguage_Failure2() {
        try {
            instance.setLanguage(" ");
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
