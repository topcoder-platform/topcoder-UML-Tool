/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeAction;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

/**
 * Aggregates all failure tests for UpdateAttributeAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateAttributeActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateAttributeAction(Attribute, VisibilityKind,
     * String, Classifier, Expression, ChangeableKind, Multiplicity, ScopeKind,
     * boolean). Failure testing of exception in case attribute is null.
     */
    public final void testUpdateAttributeActionFailureAttributeNull() {
        try {
            new UpdateAttributeAction(null, VisibilityKind.PACKAGE, "name", new ClassifierAbstractImpl() {
            }, new ExpressionImpl(), ChangeableKind.ADD_ONLY, new MultiplicityImpl(), ScopeKind.CLASSIFIER, false);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateAttributeAction(Attribute, VisibilityKind,
     * String, Classifier, Expression, ChangeableKind, Multiplicity, ScopeKind,
     * boolean). Failure testing of exception in case name is null.
     */
    public final void testUpdateAttributeActionFailureNameNull() {
        try {
            new UpdateAttributeAction(new AttributeImpl(), VisibilityKind.PACKAGE, null, new ClassifierAbstractImpl() {
            }, new ExpressionImpl(), ChangeableKind.ADD_ONLY, new MultiplicityImpl(), ScopeKind.CLASSIFIER, false);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}