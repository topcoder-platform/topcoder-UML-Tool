/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * Aggregates all test for PackageImpl class.
 * @author vilain
 * @version 1.0
 */
public class PackageImplTest extends TestCase {

    /**
     * Instance of ElementImport for testing.
     */
    private ElementImport elementImport;

    /**
     * Collection of ElementImport for testing.
     */
    private Collection<ElementImport> elementImports;

    /**
     * Instance of ModelElement for testing.
     */
    private ModelElement ownedElement;

    /**
     * Instance of Package of testing.
     */
    private Package aPackage;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        elementImport = new ElementImportImpl();
        elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < 3; i++) {
            elementImports.add(new ElementImportImpl());
        }
        ownedElement = new ModelElementImpl();
        aPackage = new PackageImpl();
    }

    /**
     * Constructor under test PackageImpl(). Testing of successful running.
     */
    public final void testPackageImpl() {
        // run successful
        new PackageImpl();
    }

    /**
     * Method under test PackageImpl.addElementImport(ElementImport). Failure
     * testing of exception in case element import is null.
     */
    public final void testAddElementImportFailure() {
        try {
            aPackage.addElementImport(null);
            fail("IllegalArgumentException is expected since element import is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.addElementImport(ElementImport). Accuracy
     * testing of correctly added element import.
     */
    public final void testAddElementImportAccuracy() {
        aPackage.addElementImport(elementImport);
        assertTrue("element import was not added", aPackage.getElementImports().contains(elementImport));
    }

    /**
     * Method under test PackageImpl.addElementImports(Collection). Failure
     * testing of exception in case element imports is null.
     */
    public final void testAddElementImportsFailureNull() {
        try {
            aPackage.addElementImports(null);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.addElementImports(Collection). Failure
     * testing of exception in case element imports contains null values.
     */
    public final void testAddElementImportsFailureContainsNull() {
        elementImports.add(null);
        try {
            aPackage.addElementImports(elementImports);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.addElementImports(Collection). Accuracy
     * testing of correctly added element imports.
     */
    public final void testAddElementImportsAccuracy() {
        aPackage.addElementImports(elementImports);
        assertEquals("element imports were not successfully added", 3, aPackage.getElementImports().size());
    }

    /**
     * Method under test PackageImpl.removeElementImport(ElementImport). Failure
     * testing of exception in case element imports is null.
     */
    public final void testRemoveElementImportFailure() {
        try {
            aPackage.removeElementImport(null);
            fail("IllegalArgumentException is expected since elementImport is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.removeElementImport(ElementImport).
     * Accuracy testing of removal in case element import exists.
     */
    public final void testRemoveElementImportAccuracyExist() {
        // adding elementImport
        aPackage.addElementImport(elementImport);
        assertTrue("the collection must be changed", aPackage.removeElementImport(elementImport));
    }

    /**
     * Method under test PackageImpl.removeElementImport(ElementImport).
     * Accuracy testing of removal in case element import does not exist.
     */
    public final void testRemoveElementImportAccuracyNotExist() {
        assertFalse("the collection must be left unchanged", aPackage.removeElementImport(elementImport));
    }

    /**
     * Method under test PackageImpl.removeElementImports(Collection). Failure
     * testing of exception in case element imports is null.
     */
    public final void testRemoveElementImportsFailureNull() {
        try {
            aPackage.removeElementImports(null);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.removeElementImports(Collection). Failure
     * testing of exception in case element imports contains null values.
     */
    public final void testRemoveElementImportsFailureContainsNull() {
        elementImports.add(null);
        try {
            aPackage.removeElementImports(elementImports);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.removeElementImports(Collection). Accuracy
     * testing of removal in case element imports exist.
     */
    public final void testRemoveElementImportsAccuracyExist() {
        // adding elementImport
        aPackage.addElementImports(elementImports);
        assertTrue("the collection must be changed", aPackage.removeElementImports(elementImports));
    }

    /**
     * Method under test PackageImpl.removeElementImports(Collection). Accuracy
     * testing of removal in case element imports do not exist.
     */
    public final void testRemoveElementImportsAccuracyNotExist() {
        assertFalse("the collection must be left  unchanged", aPackage.removeElementImports(elementImports));
    }

    /**
     * Method under test PackageImpl.clearElementImports(). Accuracy testing of
     * clearing participating element imports.
     */
    public final void testClearElementImports() {
        aPackage.addElementImports(elementImports);
        // run successfully
        aPackage.clearElementImports();
        assertTrue("the collection must be empty", aPackage.getElementImports().isEmpty());
    }

    /**
     * Method under test PackageImpl.getElementImports(). Accuracy testing of
     * correctly retrieved element imports.
     */
    public final void testGetElementImportsAccuracy() {
        aPackage.addElementImports(elementImports);
        // run successfully
        assertEquals("number of elements in collections must be equal", elementImports.size(), aPackage
            .getElementImports().size());
    }

    /**
     * Method under test PackageImpl.getElementImports(). Testing that returned
     * elementImports is shallow copy.
     */
    public final void testGetElementImportsShallow() {
        aPackage.addElementImports(elementImports);
        // run successfully
        Collection<ElementImport> currentElementImports = aPackage.getElementImports();
        aPackage.addElementImport(new ElementImportImpl());
        assertFalse("number elements in collections must be different", currentElementImports.size() == aPackage
            .getElementImports().size());
    }

    /**
     * Method under test PackageImpl.containsElementImport(ElementImport).
     * Failure testing of exception in case element import is null.
     */
    public final void testContainsElementImportFailure() {
        try {
            aPackage.containsElementImport(null);
            fail("IllegalArgumentException is expected since element import is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.containsElementImport(ElementImport).
     * Accuracy test of element import existing.
     */
    public final void testContainsElementImportAccuracyExist() {
        aPackage.addElementImport(elementImport);
        assertTrue("element import must exist", aPackage.containsElementImport(elementImport));
    }

    /**
     * Method under test PackageImpl.containsElementImport(ElementImport).
     * Accuracy test of missed element import.
     */
    public final void testContainsElementImportAccuracyNotExist() {
        assertFalse("element import must not exist", aPackage.containsElementImport(elementImport));
    }

    /**
     * Method under test PackageImpl.countElementImports(). Accuracy testing of
     * empty element imports.
     */
    public final void testCountElementImportsEmpty() {
        assertEquals("number of element imports must be 0", 0, aPackage.countElementImports());
    }

    /**
     * Method under test PackageImpl.countElementImports(). Accuracy testing of
     * not empty element imports.
     */
    public final void testCountElementImportsNotEmpty() {
        aPackage.addElementImports(elementImports);
        assertEquals("number of element imports must be 3", 3, aPackage.countElementImports());
    }

    /**
     * Method under test PackageImpl.addOwnedElement(ModelElement). Failure
     * testing of exception in case owned element is null.
     */
    public final void testAddOwnedElementFailure() {
        try {
            aPackage.addOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.addOwnedElement(ModelElement). Accuracy
     * testing of correctly added owned element.
     */
    public final void testAddOwnedElementAccuracy() {
        aPackage.addOwnedElement(ownedElement);
        assertTrue("ownedElement was not added", aPackage.getOwnedElements().contains(ownedElement));
    }

    /**
     * Method under test PackageImpl.removeOwnedElement(ModelElement). Failure
     * testing of exception in case owned element is null.
     */
    public final void testRemoveOwnedElementFailure() {
        try {
            aPackage.removeOwnedElement(null);
            fail("IllegalArgumentException is expected since ownedElement is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.removeOwnedElement(ModelElement). Accuracy
     * testing of removal in case owned element exists.
     */
    public final void testRemoveOwnedElementAccuracyExist() {
        // adding ownedElement
        aPackage.addOwnedElement(ownedElement);
        assertTrue("the collection must be changed", aPackage.removeOwnedElement(ownedElement));
    }

    /**
     * Method under test PackageImpl.removeOwnedElement(ModelElement). Accuracy
     * testing of removal in case owned element does not exist.
     */
    public final void testRemoveOwnedElementAccuracyNotExist() {
        assertFalse("the collection must be left unchanged", aPackage.removeOwnedElement(ownedElement));
    }

    /**
     * Method under test PackageImpl.clearOwnedElements(). Accuracy testing of
     * clearing participating ownedElements.
     */
    public final void testClearOwnedElements() {
        aPackage.addOwnedElement(ownedElement);
        // run successfully
        aPackage.clearOwnedElements();
        assertTrue("the collection must be empty", aPackage.getOwnedElements().isEmpty());
    }

    /**
     * Method under test PackageImpl.getOwnedElements(). Accuracy testing of
     * correctly retrieved ownedElements.
     */
    public final void testGetOwnedElementsAccuracy() {
        aPackage.addOwnedElement(ownedElement);
        // run successfully
        assertEquals("number of elements in collection must be 1", 1, aPackage.getOwnedElements().size());
    }

    /**
     * Method under test PackageImpl.getOwnedElements(). Testing that returned
     * ownedElements is shallow copy.
     */
    public final void testGetOwnedElementsShallow() {
        aPackage.addOwnedElement(ownedElement);
        // run successfully
        Collection<ModelElement> currentOwnedElements = aPackage.getOwnedElements();
        aPackage.addOwnedElement(new ModelElementImpl());
        assertFalse("number elements in collections must be different", currentOwnedElements.size() == aPackage
            .getOwnedElements().size());
    }

    /**
     * Method under test PackageImpl.containsOwnedElement(OwnedElement). Failure
     * testing of exception in case owned element is null.
     */
    public final void testContainsOwnedElementFailure() {
        try {
            aPackage.containsOwnedElement(null);
            fail("IllegalArgumentException is expected since owned element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test PackageImpl.containsOwnedElement(OwnedElement).
     * Accuracy test of owned element existing.
     */
    public final void testContainsOwnedElementAccuracyExist() {
        aPackage.addOwnedElement(ownedElement);
        assertTrue("ownedElement must exist", aPackage.containsOwnedElement(ownedElement));
    }

    /**
     * Method under test PackageImpl.containsOwnedElement(OwnedElement).
     * Accuracy test of missed owned element.
     */
    public final void testContainsOwnedElementAccuracyNotExist() {
        assertFalse("ownedElement must not exist", aPackage.containsOwnedElement(ownedElement));
    }

    /**
     * Method under test PackageImpl.countOwnedElements(). Accuracy testing of
     * empty ownedElements.
     */
    public final void testCountOwnedElementsEmpty() {
        assertEquals("number of ownedElements must be 0", 0, aPackage.countOwnedElements());
    }

    /**
     * Method under test PackageImpl.countOwnedElements(). Accuracy testing of
     * not empty ownedElements.
     */
    public final void testCountOwnedElementsNotEmpty() {
        aPackage.addOwnedElement(ownedElement);
        assertEquals("number of ownedElements must be 1", 1, aPackage.countOwnedElements());
    }

    /**
     * The simple implementation of ModelElementAbstractImpl.
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class ModelElementImpl extends ModelElementAbstractImpl {
    }
}