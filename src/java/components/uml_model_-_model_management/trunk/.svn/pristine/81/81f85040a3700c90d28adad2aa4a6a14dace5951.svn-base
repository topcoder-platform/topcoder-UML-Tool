/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * PackageImplFailureTest.java
 */
package com.topcoder.uml.model.modelmanagement.failuretests;

import junit.framework.TestCase;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;

import java.util.Collection;
import java.util.ArrayList;

/**
 * <p>
 * Failure tests for <code>PackageImpl</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PackageImplFailureTest extends TestCase {

    /**PackageImpl instance that will be tested.*/
    private PackageImpl packageImpl;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        packageImpl = new PackageImpl();
    }

    /**
     * <p>
     * Test method addElementImport(elementImport) if elementImport is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddElementImportIfNull() {
        try {
            packageImpl.addElementImport(null);
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
            packageImpl.addElementImports(null);
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
            packageImpl.addElementImports(elementImports);
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
            packageImpl.removeElementImport(null);
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
            packageImpl.removeElementImports(null);
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
            packageImpl.removeElementImports(elementImports);
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
            packageImpl.containsElementImport(null);
            fail("IllegalArgumentException is expected because elementImport cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method addOwnedElement(ownedElement) if ownedElement is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOwnedElementIfNull() {
        try {
            packageImpl.addOwnedElement(null);
            fail("IllegalArgumentException is expected because ownedElement cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method removeOwnedElement(ownedElement) if ownedElement is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOwnedElementIfNull() {
        try {
            packageImpl.removeOwnedElement(null);
            fail("IllegalArgumentException is expected because ownedElement cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Test method containsOwnedElement(ownedElement) if ownedElement is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsOwnedElementIfNull() {
        try {
            packageImpl.containsOwnedElement(null);
            fail("IllegalArgumentException is expected because ownedElement cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
