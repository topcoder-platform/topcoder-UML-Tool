package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityNode;

import junit.framework.TestCase;

public class AbstractZUMLActivityNodeFailureTest extends TestCase {

    private AbstractZUMLActivityNode instance = new MockZUMLActivityNode();

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addIncomingEdge(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge)}.
     * edge is null and IAE is expected.
     */
    public void testAddIncomingEdge_Failure() {
        try {
            instance.addIncomingEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addIncomingEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges is null and IAE is expected.
     */
    public void testAddIncomingEdges_Failure1() {
        try {
            instance.addIncomingEdges(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addIncomingEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges contains null element and IAE is expected.
     */
    public void testAddIncomingEdges_Failure2() {
        try {
            instance.addIncomingEdges(new ZUMLActivityEdge[]{null});
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLActivityNode#removeIncomingEdge(ZUMLActivityEdge)}. edge is null and IAE is
     * expected.
     */
    public void testRemoveIncomingEdge_Failure() {
        try {
            instance.removeIncomingEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addOutgoingEdge(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge)}.
     * edge is null and IAE is expected.
     */
    public void testAddOutgoingEdge_Failure() {
        try {
            instance.addOutgoingEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addOutgoingEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges is null and IAE is expected.
     */
    public void testAddOutgoingEdges_Failure1() {
        try {
            instance.addOutgoingEdges(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityNode#addOutgoingEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges contains null element and IAE is expected.
     */
    public void testAddOutgoingEdges_Failure2() {
        try {
            instance.addOutgoingEdges(new ZUMLActivityEdge[]{null});
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLActivityNode#removeOutgoingEdge(ZUMLActivityEdge)}. edge is null and IAE is
     * expected.
     */
    public void testRemoveOutgoingEdge_Failure() {
        try {
            instance.removeOutgoingEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
