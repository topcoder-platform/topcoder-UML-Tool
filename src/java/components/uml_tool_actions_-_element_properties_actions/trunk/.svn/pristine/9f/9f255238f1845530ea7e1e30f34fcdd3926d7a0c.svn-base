/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeEntityNameAction;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * Aggregates all failure tests for ChangeEntityNameAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeEntityNameActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeEntityNameAction(ModelElement, String).
     * Failure testing of exception in case element is null.
     */
    public final void testChangeEntityNameActionFailureElementNull() {
        try {
            new ChangeEntityNameAction(null, "name");
            fail("IllegalArgumentException is expected since element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeEntityNameAction(ModelElement, String).
     * Failure testing of exception in case name is null.
     */
    public final void testChangeEntityNameActionFailureNameNull() {
        try {
            new ChangeEntityNameAction(new ModelElementAbstractImpl() {
            }, null);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}