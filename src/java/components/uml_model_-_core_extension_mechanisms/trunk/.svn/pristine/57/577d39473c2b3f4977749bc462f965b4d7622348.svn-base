/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;

import junit.framework.TestCase;

/**
 * <p>
 * Faliure Test for StereotypeImpl.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class StereotypeImplFaliureTest extends TestCase {

    /**
     * <p>
     * StereotypeImpl instance created for testing.
     * </p>
     */
    StereotypeImpl stereo = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        stereo = new StereotypeImpl();
    }

    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor1() {
        try {
            Collection<TagDefinition> col = new ArrayList<TagDefinition>();
            new StereotypeImpl(null, col, null);
            fail("extendedElements is null, IllegalArgumentException is expected");
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
            Collection<ModelElement> col = new ArrayList<ModelElement>();
            new StereotypeImpl(null, null, col);
            fail("definedTags is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor3() {
        try {
            Collection<TagDefinition> col = new ArrayList<TagDefinition>();
            col.add(null);
            Collection<ModelElement> col2 = new ArrayList<ModelElement>();
            new StereotypeImpl(null, col, col2);
            fail("definedTags contains null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * <p>
     * Failure test for Constructor.
     * </p>
     */
    public void testCtor4() {
        try {
            Collection<TagDefinition> col = new ArrayList<TagDefinition>();
            Collection<ModelElement> col2 = new ArrayList<ModelElement>();
            col2.add(null);
            new StereotypeImpl(null, col, col2);
            fail("extendedElements contains null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * <p>
     * Failure test for addDefinedTag(TagDefinition tagDef).
     * </p>
     */
    public void testAddDefinedTag() {
        try {
            stereo.addDefinedTag(null);
            fail("tagDef is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for removeDefinedTag(TagDefinition tagDef).
     * </p>
     */
    public void testRemoveDefinedTag() {
        try {
            stereo.removeDefinedTag(null);
            fail("tagDef is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for containsDefinedTag(TagDefinition tagDef).
     * </p>
     */
    public void testContainsDefinedTag() {
        try {
            stereo.containsDefinedTag(null);
            fail("tagDef is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for addExtendedElement(ModelElement element).
     * </p>
     */
    public void testAddExtendedElement() {
        try {
            stereo.addExtendedElement(null);
            fail("element is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for removeExtendedElement(ModelElement element).
     * </p>
     */
    public void testRemoveExtendedElement() {
        try {
            stereo.removeExtendedElement(null);
            fail("element is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for containsExtendedElement(ModelElement element).
     * </p>
     */
    public void testContainsExtendedElement() {
        try {
            stereo.containsExtendedElement(null);
            fail("element is null, IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
