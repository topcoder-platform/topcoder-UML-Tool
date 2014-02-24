/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.UpdateAssociationEndAction;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Accuracy test cases for UpdateAssociationEndAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateAssociationEndActionAccuracyTests extends TestCase {
    /**
     * Represents the UpdateAssociationEndAction instance used for tests.
     */
    private UpdateAssociationEndAction instance;

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
        AccuracyHelper.loadDefaultConfig();
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

        instance = new UpdateAssociationEndAction(associationEnd, newVisibility, newName,
            newChangeability, newMultiplicity, newOrdering, newAggregationKind, newTargetKind,
            newNavigable);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldVisibility, associationEnd.getVisibility());
        assertEquals("undoAction() is incorrect.", oldName, associationEnd.getName());
        assertEquals("undoAction() is incorrect.", oldChangeability, associationEnd
            .getChangeability());
        assertEquals("undoAction() is incorrect.", oldMultiplicity, associationEnd
            .getMultiplicity());
        assertEquals("undoAction() is incorrect.", oldOrdering, associationEnd.getOrdering());
        assertEquals("undoAction() is incorrect.", oldTargetKind, associationEnd.getTargetKind());
        assertEquals("undoAction() is incorrect.", oldNavigable, associationEnd.isNavigable());
        assertEquals("undoAction() is incorrect.", oldAggregationKind, associationEnd
            .getAggregation());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newVisibility, associationEnd.getVisibility());
        assertEquals("redoAction() is incorrect.", newName, associationEnd.getName());
        assertEquals("redoAction() is incorrect.", newChangeability, associationEnd
            .getChangeability());
        assertEquals("redoAction() is incorrect.", newMultiplicity, associationEnd
            .getMultiplicity());
        assertEquals("redoAction() is incorrect.", newOrdering, associationEnd.getOrdering());
        assertEquals("redoAction() is incorrect.", newTargetKind, associationEnd.getTargetKind());
        assertEquals("redoAction() is incorrect.", newNavigable, associationEnd.isNavigable());
        assertEquals("redoAction() is incorrect.", newAggregationKind, associationEnd
            .getAggregation());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newVisibility, associationEnd.getVisibility());
        assertEquals("executeAction() is incorrect.", newName, associationEnd.getName());
        assertEquals("executeAction() is incorrect.", newChangeability, associationEnd
            .getChangeability());
        assertEquals("executeAction() is incorrect.", newMultiplicity, associationEnd
            .getMultiplicity());
        assertEquals("executeAction() is incorrect.", newOrdering, associationEnd.getOrdering());
        assertEquals("executeAction() is incorrect.", newTargetKind, associationEnd.getTargetKind());
        assertEquals("executeAction() is incorrect.", newNavigable, associationEnd.isNavigable());
        assertEquals("executeAction() is incorrect.", newAggregationKind, associationEnd
            .getAggregation());
    }

    /**
     * Test constructor.
     */
    public void testUpdateAssociationEndAction() {
        assertEquals("associationEnd is incorrect.", associationEnd, AccuracyHelper
            .getObjectFieldValue(instance, "associationEnd"));
        assertEquals("oldVisibility is incorrect.", oldVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "oldVisibility"));
        assertEquals("newVisibility is incorrect.", newVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "newVisibility"));
        assertEquals("oldName is incorrect.", oldName, AccuracyHelper.getObjectFieldValue(instance,
            "oldName"));
        assertEquals("newName is incorrect.", newName, AccuracyHelper.getObjectFieldValue(instance,
            "newName"));
        assertEquals("oldChangeability is incorrect.", oldChangeability, AccuracyHelper
            .getObjectFieldValue(instance, "oldChangeability"));
        assertEquals("newChangeability is incorrect.", newChangeability, AccuracyHelper
            .getObjectFieldValue(instance, "newChangeability"));
        assertEquals("oldMultiplicity is incorrect.", oldMultiplicity, AccuracyHelper
            .getObjectFieldValue(instance, "oldMultiplicity"));
        assertEquals("newMultiplicity is incorrect.", newMultiplicity, AccuracyHelper
            .getObjectFieldValue(instance, "newMultiplicity"));
        assertEquals("oldOrdering is incorrect.", oldOrdering, AccuracyHelper.getObjectFieldValue(
            instance, "oldOrdering"));
        assertEquals("newOrdering is incorrect.", newOrdering, AccuracyHelper.getObjectFieldValue(
            instance, "newOrdering"));
        assertEquals("oldAggregationKind is incorrect.", oldAggregationKind, AccuracyHelper
            .getObjectFieldValue(instance, "oldAggregationKind"));
        assertEquals("newAggregationKind is incorrect.", newAggregationKind, AccuracyHelper
            .getObjectFieldValue(instance, "newAggregationKind"));
        assertEquals("oldTargetKind is incorrect.", oldTargetKind, AccuracyHelper
            .getObjectFieldValue(instance, "oldTargetKind"));
        assertEquals("newTargetKind is incorrect.", newTargetKind, AccuracyHelper
            .getObjectFieldValue(instance, "newTargetKind"));
        assertEquals("oldNavigable is incorrect.", oldNavigable, AccuracyHelper
            .getObjectFieldValue(instance, "oldNavigable"));
        assertEquals("newNavigable is incorrect.", newNavigable, AccuracyHelper
            .getObjectFieldValue(instance, "newNavigable"));

    }
}