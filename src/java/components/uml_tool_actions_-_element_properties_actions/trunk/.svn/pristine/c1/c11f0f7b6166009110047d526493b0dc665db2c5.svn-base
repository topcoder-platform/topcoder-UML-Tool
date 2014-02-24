/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Aggregates all failure tests for ChangeEntityVisibilityAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeEntityVisibilityActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeEntityVisibilityAction(ModelElement,
     * VisibilityKind). Failure testing of exception in case element is null.
     */
    public final void testChangeEntityVisibilityActionFailureElementNull() {
        try {
            new ChangeEntityVisibilityAction(null, VisibilityKind.PACKAGE);
            fail("IllegalArgumentException is expected since element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeEntityVisibilityAction(ModelElement,
     * VisibilityKind ). Failure testing of exception in case visibility is
     * null.
     */
    public final void testChangeEntityVisibilityActionFailureVisibilityNull() {
        try {
            new ChangeEntityVisibilityAction(new ModelElementAbstractImpl() {
            }, null);
            fail("IllegalArgumentException is expected since visibility is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}