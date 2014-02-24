/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateAssociationEndAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateAssociationEndActionUnitTests extends TestCase {
    /**
     * Represents the UpdateAssociationEndAction instance used for tests.
     */
    private UpdateAssociationEndAction testUpdateAssociationEndAction;

    /**
     * Represents the association end to update the attributes.
     */
    private AssociationEnd associationEnd;

    /**
     * Represents the new visibility of the association end after this action performed.
     */
    private VisibilityKind newVisibility;

    /**
     * Represents the new name of the association end after this action performed.
     */
    private String newName;

    /**
     * Represents the new changeability of the association end after this action performed.
     */
    private ChangeableKind newChangeability;

    /**
     * Represents the new multiplicity of the association end after this action performed.
     */
    private Multiplicity newMultiplicity;

    /**
     * Represents the new ordering of the association end after this action performed.
     */
    private OrderingKind newOrdering;

    /**
     * Represents the new aggregation of the association end after this action performed.
     */
    private AggregationKind newAggregationKind;

    /**
     * Represents the old multiplicity of the association end before this action performed.
     */
    private Multiplicity oldMultiplicity;

    /**
     * Represents the old name of the association end before this action performed.
     */
    private String oldName;

    /**
     * Represents the old ordering of the association end before this action performed.
     */
    private OrderingKind oldOrdering;

    /**
     * Represents the old visibility of the association end before this action performed.
     */
    private VisibilityKind oldVisibility;

    /**
     * Represents the old changeability of the association end before this action performed.
     */
    private ChangeableKind oldChangeability;

    /**
     * Represents the old aggregation of the association end before this action performed.
     */
    private AggregationKind oldAggregationKind;

    /**
     * Represents the new target kind(isStatic) of the association end after this action performed.
     */
    private ScopeKind newTargetKind;

    /**
     * Represents the old target kind of the association end before this action performed.
     */
    private ScopeKind oldTargetKind;

    /**
     * Represents the old navigable of the association end before this action performed.
     */
    private boolean oldNavigable;

    /**
     * Represents the new navigable of the association end after this action performed.
     */
    private boolean newNavigable;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        associationEnd = new AssociationEndImpl();

        oldVisibility = VisibilityKind.PACKAGE;
        newVisibility = VisibilityKind.PUBLIC;
        associationEnd.setVisibility(oldVisibility);

        newName = "newName";
        oldName = "oldName";
        associationEnd.setName(oldName);

        oldChangeability = ChangeableKind.ADD_ONLY;
        newChangeability = ChangeableKind.FROZEN;
        associationEnd.setChangeability(oldChangeability);

        newMultiplicity = new MultiplicityImpl();
        oldMultiplicity = new MultiplicityImpl();
        associationEnd.setMultiplicity(oldMultiplicity);

        oldOrdering = OrderingKind.ORDERED;
        newOrdering = OrderingKind.UNORDERED;
        associationEnd.setOrdering(oldOrdering);

        oldTargetKind = ScopeKind.CLASSIFIER;
        newTargetKind = ScopeKind.INSTANCE;
        associationEnd.setTargetKind(oldTargetKind);

        oldAggregationKind = AggregationKind.AGGREGATE;
        newAggregationKind = AggregationKind.COMPOSITE;
        associationEnd.setAggregation(oldAggregationKind);

        oldNavigable = false;
        newNavigable = true;
        associationEnd.setNavigable(oldNavigable);

        testUpdateAssociationEndAction = new UpdateAssociationEndAction(associationEnd, newVisibility, newName,
                newChangeability, newMultiplicity, newOrdering, newAggregationKind, newTargetKind, newNavigable);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. Each field of the associationEnd
     * will be set to old|field|.
     */
    public void testUndoAction() {
        testUpdateAssociationEndAction.undoAction();
        assertEquals("UpdateAssociationEndAction undoAction incorrectly",
                oldVisibility, associationEnd.getVisibility());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldName, associationEnd.getName());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldChangeability, associationEnd
                .getChangeability());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldMultiplicity, associationEnd
                .getMultiplicity());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldOrdering, associationEnd.getOrdering());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly",
                oldTargetKind, associationEnd.getTargetKind());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldNavigable, associationEnd.isNavigable());
        assertEquals("UpdateAssociationEndAction undoAction incorrectly", oldAggregationKind, associationEnd
                .getAggregation());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. Each field of the associationEnd
     * will be set to new|field|.
     */
    public void testRedoAction() {
        testUpdateAssociationEndAction.redoAction();
        assertEquals("UpdateAssociationEndAction redoAction incorrectly",
                newVisibility, associationEnd.getVisibility());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newName, associationEnd.getName());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newChangeability, associationEnd
                .getChangeability());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newMultiplicity, associationEnd
                .getMultiplicity());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newOrdering, associationEnd.getOrdering());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly",
                newTargetKind, associationEnd.getTargetKind());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newNavigable, associationEnd.isNavigable());
        assertEquals("UpdateAssociationEndAction redoAction incorrectly", newAggregationKind, associationEnd
                .getAggregation());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. Each field of the
     * associationEnd will be set to new|field|.
     */
    public void testExecuteAction() {
        testUpdateAssociationEndAction.executeAction();
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newVisibility, associationEnd
                .getVisibility());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newName, associationEnd.getName());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newChangeability, associationEnd
                .getChangeability());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newMultiplicity, associationEnd
                .getMultiplicity());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newOrdering, associationEnd
                .getOrdering());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newTargetKind, associationEnd
                .getTargetKind());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newNavigable, associationEnd
                .isNavigable());
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newAggregationKind, associationEnd
                .getAggregation());
    }

    /**
     * Test UpdateAssociationEndAction constructor.
     */
    public void testUpdateAssociationEndAction() {
        assertNotNull("Create UpdateAssociationEndAction incorrectly.", testUpdateAssociationEndAction);
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", associationEnd,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "associationEnd"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newVisibility,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newVisibility"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newName,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newName"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newChangeability,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newChangeability"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newMultiplicity,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newMultiplicity"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newOrdering,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newOrdering"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newTargetKind,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newTargetKind"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newNavigable,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newNavigable"));
        assertEquals("UpdateAssociationEndAction executeAction incorrectly", newAggregationKind,
                UnitTestsHelper.getObjectFieldValue(testUpdateAssociationEndAction, "newAggregationKind"));
    }

    /**
     * Test UpdateAssociationEndAction constructor with null associationEnd.
     */
    public void testUpdateAssociationEndActionNullAssociationEnd() {
        try {
            new UpdateAssociationEndAction(null, newVisibility, newName, newChangeability, newMultiplicity,
                    newOrdering, newAggregationKind, newTargetKind, newNavigable);
            fail("IllegalArgumentException should be thrown when the passed associationEnd is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateAssociationEndAction constructor with null name.
     */
    public void testUpdateAssociationEndActionNullNewName() {
        try {
            new UpdateAssociationEndAction(associationEnd, newVisibility, null, newChangeability, newMultiplicity,
                    newOrdering, newAggregationKind, newTargetKind, newNavigable);
            fail("IllegalArgumentException should be thrown when the passed newName is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
