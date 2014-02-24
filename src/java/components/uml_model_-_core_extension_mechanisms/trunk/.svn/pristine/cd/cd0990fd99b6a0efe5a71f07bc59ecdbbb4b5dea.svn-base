/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Faliure Test for TagDefinitionImpl.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class TagDefinitionImplFailureTest extends TestCase {

    /**
     * <p>
     * TagDefinitionImpl instance created for testing.
     * </p>
     */
    TagDefinitionImpl tag = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        tag = new TagDefinitionImpl();
    }


    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor1() {
        try {
            new TagDefinitionImpl(null, null, null, null);
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
            new TagDefinitionImpl(null, null, null, col);
            fail("referenceValues contains null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for addTypedValue(TaggedValue typedValue).
     * </p>
     */
    public void testAddTypedValue() {
        try {
            tag.addTypedValue(null);
            fail("typedValue is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for removeTypedValue(TaggedValue typedValue).
     * </p>
     */
    public void testRemoveTypedValue() {
        try {
            tag.removeTypedValue(null);
            fail("typedValue is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for containsTypedValue(TaggedValue typedValue).
     * </p>
     */
    public void testContainsTypedValue() {
        try {
            tag.containsTypedValue(null);
            fail("typedValue is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
