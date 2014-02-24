package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityDiagram;

import junit.framework.TestCase;

public class AbstractZUMLActivityDiagramFailureTest extends TestCase {

    private AbstractZUMLActivityDiagram instance = new MockZUMLActivityDiagram();

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addNode(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode)}.
     * node is null and IAE is expected.
     */
    public void testAddNode_Failure() {
        try {
            instance.addNode(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addNodes(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode[])}.
     * nodes is null and IAE is expected.
     */
    public void testAddNodes_Failure1() {
        try {
            instance.addNodes(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addNodes(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode[])}.
     * nodes contains null element and IAE is expected.
     */
    public void testAddNodes_Failure2() {
        try {
            instance.addNodes(new ZUMLActivityNode[]{null});
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLActivityDiagram#removeNode(ZUMLActivityNode)}. node is null and IAE is
     * expected.
     */
    public void testRemoveNode_Failure() {
        try {
            instance.removeNode(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addEdge(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge)}.
     * edge is null and IAE is expected.
     */
    public void testAddEdge_Failure() {
        try {
            instance.addEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges is null and IAE is expected.
     */
    public void testAddEdges_Failure1() {
        try {
            instance.addEdges(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link AbstractZUMLActivityDiagram#addEdges(com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge[])}.
     * edges contains null element and IAE is expected.
     */
    public void testAddEdges_Failure2() {
        try {
            instance.addEdges(new ZUMLActivityEdge[]{null});
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link AbstractZUMLActivityDiagram#removeEdge(ZUMLActivityEdge)}. edge is null and IAE is
     * expected.
     */
    public void testRemoveEdge_Failure() {
        try {
            instance.removeEdge(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
