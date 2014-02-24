package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLJoinNodeImpl;

import junit.framework.TestCase;

public class ZUMLJoinNodeImplFailureTest extends TestCase {

    private ZUMLJoinNodeImpl instance = new ZUMLJoinNodeImpl();

    /**
     * Failure Test for
     * {@link ZUMLJoinNodeImpl#setJoinSpec(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression)}.
     * joinSpec is null and IAE is expected.
     */
    public void testSetJoinSpec_Failure() {
        try {
            instance.setJoinSpec(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
