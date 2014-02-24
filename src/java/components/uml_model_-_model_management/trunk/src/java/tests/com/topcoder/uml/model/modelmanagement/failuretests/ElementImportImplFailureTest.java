/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * ElementImportImplFailureTest.java
 */
package com.topcoder.uml.model.modelmanagement.failuretests;

import junit.framework.TestCase;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;

/**
 * <p>
 * Failure tests for <code>ElementImportImpl</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class ElementImportImplFailureTest extends TestCase {

    /**ElementImportImpl instance that will be tested.*/
    private ElementImportImpl elementImport;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        elementImport = new ElementImportImpl();
    }

    /**
     * <p>
     * Test method setPackage(package) if package is null.
     * As package can be null, no exception is expected.
     * </p>
     */
    public void testSetPackageIfNull() {
        try {
            elementImport.setPackage(null);
            //success
        } catch (Exception e) {
            fail("Null package must be allowed.");
        }
    }

    /**
     * <p>
     * Test method setVisibility(visibility) if visibility is null.
     * As visibility can be null, no exception is expected.
     * </p>
     */
    public void testSetVisibilityIfNull() {
        try {
            elementImport.setVisibility(null);
            //success
        } catch (Exception e) {
            fail("Null visibility must be allowed.");
        }
    }

    /**
     * <p>
     * Test method setAlias(alias) if alias is null.
     * As alias can be null, no exception is expected.
     * </p>
     */
    public void testSetAliasIfNull() {
        try {
            elementImport.setAlias(null);
            //success
        } catch (Exception e) {
            fail("Null alias must be allowed.");
        }
    }

    /**
     * <p>
     * Test method setAlias(alias) if alias is empty.
     * As alias can be empty, no exception is expected.
     * </p>
     */
    public void testSetAliasIfEmpty() {
        try {
            elementImport.setAlias("   ");
            //success
        } catch (Exception e) {
            fail("Empty alias must be allowed.");
        }
    }

    /**
     * <p>
     * Test method setImportedElement(importedElement) if importedElement is null.
     * As importedElement can be null, no exception is expected.
     * </p>
     */
    public void testSetImportedElementIfNull() {
        try {
            elementImport.setImportedElement(null);
            //success
        } catch (Exception e) {
            fail("Null alias must be allowed.");
        }
    }
}