package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityEdge;

import junit.framework.TestCase;

public class AbstractZUMLActivityEdgeFailureTest extends TestCase {

    private AbstractZUMLActivityEdge instance = new MockZUMLActivityEdge();

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityEdge#setTarget(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode)}.
     * target is null and IAE is expected.
     */
    public void testSetTarget_Failure() {
        try {
            instance.setTarget(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityEdge#setSource(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode)}.
     * source is null and IAE is expected.
     */
    public void testSetSource_Failure() {
        try {
            instance.setSource(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityEdge#setGuard(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression)}.
     * guard is null and IAE is expected.
     */
    public void testSetGuard_Failure() {
        try {
            instance.setGuard(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
