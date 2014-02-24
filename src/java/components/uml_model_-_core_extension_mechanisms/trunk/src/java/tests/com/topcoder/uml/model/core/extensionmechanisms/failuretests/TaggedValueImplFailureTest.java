/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Faliure Test for TaggedValueImpl.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class TaggedValueImplFailureTest extends TestCase {

    /**
     * <p>
     * TaggedValueImpl instance created for testing.
     * </p>
     */
    TaggedValueImpl tagged = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        tagged = new TaggedValueImpl();
    }

    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor1() {
        try {
            new TaggedValueImpl(null, null, null, null);
            fail("referenceValues is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor2() {
        try {
            Collection col = new ArrayList<ModelElement>();
            col.add(null);
            new TaggedValueImpl(null, null, null, col);
            fail("referenceValues contains null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for addReferenceValue(ModelElement value).
     * </p>
     */
    public void testAddReferenceValue() {
        try {
            tagged.addReferenceValue(null);
            fail("value is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for removeReferenceValue(ModelElement value).
     * </p>
     */
    public void testRemoveReferenceValue() {
        try {
            tagged.removeReferenceValue(null);
            fail("value is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for containsReferenceValue(ModelElement value).
     * </p>
     */
    public void testContainsReferenceValue() {
        try {
            tagged.containsReferenceValue(null);
            fail("value is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
