/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.actions.general.ChangeStyleAction;

/**
 * Aggregates all failure tests for ChangeStyleAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeStyleActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeStyleAction(DiagramElement, String, String).
     * Failure testing of exception in case diagram is null.
     */
    public final void testChangeStyleActionFailureDiagramNull() {
        try {
            new ChangeStyleAction(null, "name", "value");
            fail("IllegalArgumentException is expected since diagram is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeStyleAction(DiagramElement, String, String).
     * Failure testing of exception in case name is null.
     */
    public final void testChangeStyleActionFailureNameNull() {
        try {
            new ChangeStyleAction(new DiagramElement() {
            }, null, "value");
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeStyleAction(DiagramElement, String, String).
     * Failure testing of exception in case value is null.
     */
    public final void testChangeStyleActionFailureStyleNull() {
        try {
            new ChangeStyleAction(new DiagramElement() {
            }, "name", null);
            fail("IllegalArgumentException is expected since value is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}