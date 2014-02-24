/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import java.util.HashSet;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * Aggregates all failure tests for SetEntityStereotypesAction class.
 * @author vilain
 * @version 1.0
 */
public class SetEntityStereotypesActionFailureTest extends TestCase {

    /**
     * Constructor under test SetEntityStereotypesAction(ModelElement, Set,
     * SetEntityStereotypesOperationType). Failure testing of exception in case
     * element is null.
     */
    public final void testSetEntityStereotypesActionFailureDiagramNull() {
        try {
            new SetEntityStereotypesAction(null, new HashSet<Stereotype>(), SetEntityStereotypesOperationType.ADD);
            fail("IllegalArgumentException is expected since diagram is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test SetEntityStereotypesAction(ModelElement, Set,
     * SetEntityStereotypesOperationType). Failure testing of exception in case
     * stereotypes is null.
     */
    public final void testSetEntityStereotypesActionFailureNameNull() {
        try {
            new SetEntityStereotypesAction(new ModelElementAbstractImpl() {
            }, null, SetEntityStereotypesOperationType.ADD);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test SetEntityStereotypesAction(ModelElement, Set,
     * SetEntityStereotypesOperationType). Failure testing of exception in case
     * operation type is null.
     */
    public final void testSetEntityStereotypesActionFailureStyleNull() {
        try {
            new SetEntityStereotypesAction(new ModelElementAbstractImpl() {
            }, new HashSet<Stereotype>(), null);
            fail("IllegalArgumentException is expected since value is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}