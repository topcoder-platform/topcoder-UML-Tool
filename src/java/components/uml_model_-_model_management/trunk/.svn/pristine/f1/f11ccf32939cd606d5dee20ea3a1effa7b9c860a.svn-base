/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Aggregates all test for GeneralizationImpl class.
 * @author vilain
 * @version 1.0
 */
public class ElementImportImplTest extends TestCase {

    /**
     * Instance of Package for testing.
     */
    private Package aPackage;

    /**
     * Instance of VisibilityKind for testing.
     */
    private VisibilityKind visibility;

    /**
     * Instance of alias for testing.
     */
    private String alias;

    /**
     * Instance of specification for testing.
     */
    private boolean specification = false;

    /**
     * Instance of ModelElement for testing.
     */
    private ModelElement importedElement;

    /**
     * Instance of ElementImport for testing.
     */
    private ElementImport elementImport;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        aPackage = new PackageImpl();
        visibility = VisibilityKind.PACKAGE;
        alias = "alias";
        importedElement = new ModelElementAbstractImpl() {
        };
        elementImport = new ElementImportImpl();
    }

    /**
     * Constructor under test ElementImportImpl(). Testing of successful
     * running.
     */
    public final void testElementImportImpl() {
        new ElementImportImpl();
    }

    /**
     * Method under test ElementImportImpl.setPackage(Package). Accuracy testing
     * of correctly assigned package.
     */
    public final void testSetPackageAccuracy() {
        elementImport.setPackage(aPackage);
        assertEquals("packages must be equal", aPackage, elementImport.getPackage());
    }

    /**
     * Method under test ElementImportImpl.setPackage(Package). Testing of
     * successful running in case package is null.
     */
    public final void testSetPackageValidNull() {
        elementImport.setPackage(null);
        assertNull("packages must be null", elementImport.getPackage());
    }

    /**
     * Method under test ElementImportImpl.getPackage(). Accuracy testing of
     * correctly retrieved package.
     */
    public final void testGetPackage() {
        elementImport.setPackage(aPackage);
        assertEquals("packages must be equal", aPackage, elementImport.getPackage());
    }

    /**
     * Method under test ElementImportImpl.setVisibility(Visibility). Accuracy
     * testing of correctly assigned visibility.
     */
    public final void testSetVisibilityAccuracy() {
        elementImport.setVisibility(visibility);
        assertEquals("visibilities must be equal", visibility, elementImport.getVisibility());
    }

    /**
     * Method under test ElementImportImpl.setVisibility(Visibility). Testing of
     * successful running in case visibility is null.
     */
    public final void testSetVisibilityValidNull() {
        elementImport.setVisibility(null);
        assertNull("visibilities must be null", elementImport.getVisibility());
    }

    /**
     * Method under test ElementImportImpl.getVisibility(). Accuracy testing of
     * correctly retrieved visibility.
     */
    public final void testGetVisibility() {
        elementImport.setVisibility(visibility);
        assertEquals("visibilities must be equal", visibility, elementImport.getVisibility());
    }

    /**
     * Method under test ElementImportImpl.setAlias(String). Accuracy testing of
     * correctly assigned alias.
     */
    public final void testSetAliasAccuracy() {
        elementImport.setAlias(alias);
        assertEquals("aliases must be equal", alias, elementImport.getAlias());
    }

    /**
     * Method under test ElementImportImpl.setAlias(String). Testing of
     * successful running in case alias is null.
     */
    public final void testSetAliasValidNull() {
        elementImport.setAlias(null);
        assertNull("aliases must be null", elementImport.getAlias());
    }

    /**
     * Method under test ElementImportImpl.setAlias(String). Testing of
     * successful running in case alias is empty.
     */
    public final void testSetAliasValidEmpty() {
        elementImport.setAlias("");
        assertTrue("aliases must be empty", elementImport.getAlias().length() == 0);
    }

    /**
     * Method under test ElementImportImpl.setAlias(String). Testing of
     * successful running in case alias is empty trimmed.
     */
    public final void testSetAliasValidEmptyTrimmed() {
        elementImport.setAlias("   ");
        assertTrue("aliases must be empty trimmed", elementImport.getAlias().trim().length() == 0);
    }

    /**
     * Method under test ElementImportImpl.getAlias(). Accuracy testing of
     * correctly retrieved alias.
     */
    public final void testGetAlias() {
        elementImport.setAlias(alias);
        assertEquals("aliases must be equal", alias, elementImport.getAlias());
    }

    /**
     * Method under test ElementImportImpl.isSpecification(). Accuracy testing
     * of correctly retrieved specification.
     */
    public final void testSetSpecification() {
        elementImport.setSpecification(specification);
        assertEquals("specifications must be equal", specification, elementImport.isSpecification());
    }

    /**
     * Method under test ElementImportImpl.setSpecification(boolean). Accuracy
     * testing of correctly assigned specification.
     */
    public final void testIsSpecification() {
        elementImport.setSpecification(specification);
        assertEquals("specifications must be equal", specification, elementImport.isSpecification());
    }

    /**
     * Method under test ElementImportImpl.setImportedElement(ImportedElement).
     * Accuracy testing of correctly assigned imported element.
     */
    public final void testSetImportedElementAccuracy() {
        elementImport.setImportedElement(importedElement);
        assertEquals("imported elements must be equal", importedElement, elementImport.getImportedElement());
    }

    /**
     * Method under test ElementImportImpl.setImportedElement(ImportedElement).
     * Testing of successful running in case imported element is null.
     */
    public final void testSetImportedElementValidNull() {
        elementImport.setImportedElement(null);
        assertNull("imported elements must be null", elementImport.getImportedElement());
    }

    /**
     * Method under test ElementImportImpl.getImportedElement(). Accuracy
     * testing of correctly retrieved imported element.
     */
    public final void testGetImportedElement() {
        elementImport.setImportedElement(importedElement);
        assertEquals("imported elements must be equal", importedElement, elementImport.getImportedElement());
    }
}