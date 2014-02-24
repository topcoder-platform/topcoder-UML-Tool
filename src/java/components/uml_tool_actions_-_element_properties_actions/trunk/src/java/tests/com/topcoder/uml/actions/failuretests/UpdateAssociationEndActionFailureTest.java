/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.UpdateAssociationEndAction;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Aggregates all failure tests for UpdateAssociationEndAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateAssociationEndActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateAssociationEndAction(AssociationEnd,
     * VisibilityKind, String, ChangeableKind, Multiplicity, OrderingKind,
     * AggregationKind, ScopeKind, boolean). Failure testing of exception in
     * case association end is null.
     */
    public final void testUpdateAssociationEndActionFailureAssociationEndNull() {
        try {
            new UpdateAssociationEndAction(null, VisibilityKind.PACKAGE, "name", ChangeableKind.ADD_ONLY,
                new MultiplicityImpl(), OrderingKind.ORDERED, AggregationKind.AGGREGATE, ScopeKind.CLASSIFIER, false);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateAssociationEndAction(AssociationEnd,
     * VisibilityKind, String, ChangeableKind, Multiplicity, OrderingKind,
     * AggregationKind, ScopeKind, boolean). Failure testing of exception in
     * case name is null.
     */
    public final void testUpdateAssociationEndActionFailureNameNull() {
        try {
            new UpdateAssociationEndAction(new AssociationEndImpl(), VisibilityKind.PACKAGE, null,
                ChangeableKind.ADD_ONLY, new MultiplicityImpl(), OrderingKind.ORDERED, AggregationKind.AGGREGATE,
                ScopeKind.CLASSIFIER, false);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}