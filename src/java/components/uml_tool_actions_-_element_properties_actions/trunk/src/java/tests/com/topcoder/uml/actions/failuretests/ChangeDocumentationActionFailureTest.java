/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeDocumentationAction;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * Aggregates all failure tests for ChangeDocumentationAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeDocumentationActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeDocumentationAction(ModelElement, String).
     * Failure testing of exception in case element is null.
     */
    public final void testChangeDocumentationActionFailureElementNull() {
        try {
            new ChangeDocumentationAction(null, "documentation");
            fail("IllegalArgumentException is expected since element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeDocumentationAction(ModelElement , String).
     * Failure testing of exception in case documentation is null.
     */
    public final void testChangeDocumentationActionFailureDocumentationNull() {
        try {
            new ChangeDocumentationAction(new ModelElementAbstractImpl() {
            }, null);
            fail("IllegalArgumentException is expected since documentation is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}