package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;



import java.util.HashSet;
import java.util.Set;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.umltool.xmiconverters.poseidon5.XMISequenceDiagramConverterUtil;

import junit.framework.TestCase;

public class XMISequenceDiagramConverterUtilFailureTest extends TestCase {

    /**
     * Failure Test for
     * {@link XMISequenceDiagramConverterUtil#convertCollaborationInModel(com.topcoder.uml.model.modelmanagement.Model)}.
     * model is null and IAE is expected.
     */
    public void testConvertCollaborationInModel_Failure() {
        try {
            XMISequenceDiagramConverterUtil.convertCollaborationInModel(null);
            fail("model is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link XMISequenceDiagramConverterUtil#convertSequenceDiagrams(java.util.Collection)}.
     * diagrams is null and IAE is expected.
     */
    public void testConvertSequenceDiagrams_Failure1() {
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(null);
            fail("diagrams is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link XMISequenceDiagramConverterUtil#convertSequenceDiagrams(java.util.Collection)}.
     * diagrams is empty and IAE is expected.
     */
    public void testConvertSequenceDiagrams_Failure2() {
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(new HashSet<Diagram>());
            fail("diagrams is empty and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link XMISequenceDiagramConverterUtil#convertSequenceDiagrams(java.util.Collection)}.
     * diagrams contains null element and IAE is expected.
     */
    public void testConvertSequenceDiagrams_Failure3() {
        Set<Diagram> diagrams = new HashSet<Diagram>();
        diagrams.add(null);
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diagrams);
            fail("diagrams contains null element and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link XMISequenceDiagramConverterUtil#convertSequenceDiagram(Diagram)}. diagram is null and
     * IAE is expected.
     */
    public void testConvertSequenceDiagram_Failure() {
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagram(null);
            fail("diagram is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
