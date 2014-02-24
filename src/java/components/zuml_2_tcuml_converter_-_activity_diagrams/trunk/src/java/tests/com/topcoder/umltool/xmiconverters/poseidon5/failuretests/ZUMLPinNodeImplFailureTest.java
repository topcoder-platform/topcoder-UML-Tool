package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImpl;

import junit.framework.TestCase;

public class ZUMLPinNodeImplFailureTest extends TestCase {

    private ZUMLPinNodeImpl instance = new ZUMLPinNodeImpl();

    /**
     * Failure Test for
     * {@link ZUMLPinNodeImpl#setUpperBound(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression)}.
     * bound is null and IAE is expected.
     */
    public void testSetUpperBound_Failure() {
        try {
            instance.setUpperBound(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
