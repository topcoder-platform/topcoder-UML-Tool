/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentGraphNodeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentRelationshipGraphEdgeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentGraphNodeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentRelationshipGraphEdgeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentGraphNodeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentGraphNodeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentRelationshipGraphEdgeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentGraphNodeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentRelationshipGraphEdgeActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.AddCommentActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.AddNoteRelationshipActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyNoteRelationshipActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.CutCommentActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.CutNoteRelationshipActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteNoteRelationshipActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentActionTest;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveNoteRelationshipActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.AddFreeTextActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.AddPolylineActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.CopyFreeTextActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.CopyPolylineActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.CutFreeTextActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.CutPolylineActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.PasteFreeTextActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.PastePolylineActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.RemoveFreeTextActionTest;
import com.topcoder.uml.actions.auxiliary.diagram.RemovePolylineActionTest;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * Aggregates all unit test cases.
     * </p>
     * @return the aggregated unit test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // Unit tests on custom exceptions
        suite.addTestSuite(AuxiliaryElementCloneExceptionTest.class);

        // Unit tests on beans
        suite.addTestSuite(AuxiliaryElementDataFlavorTest.class);
        suite.addTestSuite(AuxiliaryElementSelectionTest.class);

        // Unit tests on utility classes
        suite.addTestSuite(AuxiliaryElementCloneUtilityTest.class);
        suite.addTestSuite(AuxiliaryElementClipboardUtilityTest.class);

        // Unit tests on abstract actions
        suite.addTestSuite(AbstractAuxiliaryUndoableActionTest.class);
        suite.addTestSuite(AbstractAddGraphElementActionTest.class);
        suite.addTestSuite(AbstractRemoveGraphElementActionTest.class);
        suite.addTestSuite(AbstractCutGraphElementActionTest.class);
        suite.addTestSuite(AbstractPasteGraphElementActionTest.class);

        // Unit tests on diagram actions
        suite.addTestSuite(com.topcoder.uml.actions.auxiliary.diagram.HelperTest.class);
        suite.addTestSuite(AddFreeTextActionTest.class);
        suite.addTestSuite(AddPolylineActionTest.class);
        suite.addTestSuite(CopyFreeTextActionTest.class);
        suite.addTestSuite(CopyPolylineActionTest.class);
        suite.addTestSuite(CutFreeTextActionTest.class);
        suite.addTestSuite(CutPolylineActionTest.class);
        suite.addTestSuite(PasteFreeTextActionTest.class);
        suite.addTestSuite(PastePolylineActionTest.class);
        suite.addTestSuite(RemoveFreeTextActionTest.class);
        suite.addTestSuite(RemovePolylineActionTest.class);

        // Unit tests on comment model actions
        suite.addTestSuite(AddCommentActionTest.class);
        suite.addTestSuite(AddNoteRelationshipActionTest.class);
        suite.addTestSuite(ChangeCommentTextActionTest.class);
        suite.addTestSuite(CopyCommentActionTest.class);
        suite.addTestSuite(CopyNoteRelationshipActionTest.class);
        suite.addTestSuite(CutCommentActionTest.class);
        suite.addTestSuite(CutNoteRelationshipActionTest.class);
        suite.addTestSuite(PasteCommentActionTest.class);
        suite.addTestSuite(PasteNoteRelationshipActionTest.class);
        suite.addTestSuite(RemoveCommentActionTest.class);
        suite.addTestSuite(RemoveNoteRelationshipActionTest.class);

        // Unit tests on comment diagram actions
        suite.addTestSuite(com.topcoder.uml.actions.auxiliary.comment.diagram.HelperTest.class);
        suite.addTestSuite(AddCommentGraphNodeActionTest.class);
        suite.addTestSuite(AddCommentRelationshipGraphEdgeActionTest.class);
        suite.addTestSuite(CopyCommentGraphNodeActionTest.class);
        suite.addTestSuite(CopyCommentRelationshipGraphEdgeActionTest.class);
        suite.addTestSuite(CutCommentGraphNodeActionTest.class);
        suite.addTestSuite(CutCommentRelationshipGraphEdgeActionTest.class);
        suite.addTestSuite(PasteCommentGraphNodeActionTest.class);
        suite.addTestSuite(PasteCommentRelationshipGraphEdgeActionTest.class);
        suite.addTestSuite(RemoveCommentGraphNodeActionTest.class);
        suite.addTestSuite(RemoveCommentRelationshipGraphEdgeActionTest.class);

        // Demonstration
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
