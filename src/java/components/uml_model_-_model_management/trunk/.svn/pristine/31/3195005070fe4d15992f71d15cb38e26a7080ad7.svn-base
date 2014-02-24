/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * SubsystemImplFailureTest.java
 */
package com.topcoder.uml.model.modelmanagement.failuretests;

import junit.framework.TestCase;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;

import java.util.Collection;
import java.util.ArrayList;

/**
 * <p>
 * Failure tests for <code>SubsystemImpl</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class SubsystemImplFailureTest extends TestCase {

    /**SubsystemImpl instance that will be tested.*/
    private SubsystemImpl subsystem;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
    }
    /**
     * <p>
     * Test method addElementImport(elementImport) if elementImport is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddElementImportIfNull() {
        try {
            subsystem.addElementImport(null);
            fail("IllegalArgumentException is expected because elementImport cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method addElementImports(elementImports) if elementImports collection is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddElementImportsIfNull() {
        try {
            subsystem.addElementImports(null);
            fail("IllegalArgumentException is expected because elementImports collection cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method addElementImports(elementImports) if elementImports collection contains null element.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddElementImportsIfContainsNull() {
        try {
            Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
            elementImports.add(null);
            subsystem.addElementImports(elementImports);
            fail("IllegalArgumentException is expected because elementImports collection cannot contain null element.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method removeElementImport(elementImport) if elementImport is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveElementImportIfNull() {
        try {
            subsystem.removeElementImport(null);
            fail("IllegalArgumentException is expected because elementImport cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method removeElementImports(elementImports) if elementImports collection is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveElementImportsIfNull() {
        try {
            subsystem.removeElementImports(null);
            fail("IllegalArgumentException is expected because elementImports collection cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method removeElementImports(elementImports) if elementImports collection contains null element.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveElementImportsIfContainsNull() {
        try {
            Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
            elementImports.add(null);
            subsystem.removeElementImports(elementImports);
            fail("IllegalArgumentException is expected because elementImports collection cannot contain null element.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method containsElementImport(elementImport) if elementImport is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsElementImportIfNull() {
        try {
            subsystem.containsElementImport(null);
            fail("IllegalArgumentException is expected because elementImport cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}