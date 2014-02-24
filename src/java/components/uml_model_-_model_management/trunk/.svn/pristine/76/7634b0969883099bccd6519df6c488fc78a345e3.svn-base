/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * Aggregates all test for SubsystemImpl class.
 * @author vilain
 * @version 1.0
 */
public class SubsystemImplTest extends TestCase {

    /**
     * Instance of instantiable for testing.
     */
    private boolean instantiable = false;

    /**
     * Instance of ElementImport for testing.
     */
    private ElementImport elementImport;

    /**
     * Collection of ElementImport for testing.
     */
    private Collection<ElementImport> elementImports;

    /**
     * Instance of Subsystem of testing.
     */
    private Subsystem subsystem;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        elementImport = new ElementImportImpl();
        elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < 3; i++) {
            elementImports.add(new ElementImportImpl());
        }
        subsystem = new SubsystemImpl();
    }

    /**
     * Constructor under test SubsystemImpl(). Testing of successful running.
     */
    public final void testSubsystemImpl() {
        // run successful
        new SubsystemImpl();
    }

    /**
     * Method under test SubsystemImpl.setInstantiable(boolean). Accuracy
     * testing of correctly assigned instantiable.
     */
    public final void testSetSpecification() {
        subsystem.setInstantiable(instantiable);
        assertEquals("instantiables must be equal", instantiable, subsystem.isInstantiable());
    }

    /**
     * Method under test SubsystemImpl.isInstantiable(). Accuracy testing of
     * correctly retrieved specification.
     */
    public final void testIsSpecification() {
        subsystem.setInstantiable(instantiable);
        assertEquals("instantiables must be equal", instantiable, subsystem.isInstantiable());
    }

    /**
     * Method under test SubsystemImpl.addElementImport(ElementImport). Failure
     * testing of exception in case element import is null.
     */
    public final void testAddElementImportFailure() {
        try {
            subsystem.addElementImport(null);
            fail("IllegalArgumentException is expected since element import is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.addElementImport(ElementImport). Accuracy
     * testing of correctly added element import.
     */
    public final void testAddElementImportAccuracy() {
        subsystem.addElementImport(elementImport);
        assertTrue("element import was not added", subsystem.getElementImports().contains(elementImport));
    }

    /**
     * Method under test SubsystemImpl.addElementImports(Collection). Failure
     * testing of exception in case element imports is null.
     */
    public final void testAddElementImportsFailureNull() {
        try {
            subsystem.addElementImports(null);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.addElementImports(Collection). Failure
     * testing of exception in case element imports contains null values.
     */
    public final void testAddElementImportsFailureContainsNull() {
        elementImports.add(null);
        try {
            subsystem.addElementImports(elementImports);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.addElementImports(Collection). Accuracy
     * testing of correctly added element imports.
     */
    public final void testAddElementImportsAccuracy() {
        subsystem.addElementImports(elementImports);
        assertEquals("element imports were not successfully added", 3, subsystem.getElementImports().size());
    }

    /**
     * Method under test SubsystemImpl.removeElementImport(ElementImport).
     * Failure testing of exception in case element imports is null.
     */
    public final void testRemoveElementImportFailure() {
        try {
            subsystem.removeElementImport(null);
            fail("IllegalArgumentException is expected since elementImport is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.removeElementImport(ElementImport).
     * Accuracy testing of removal in case element import exists.
     */
    public final void testRemoveElementImportAccuracyExist() {
        // adding elementImport
        subsystem.addElementImport(elementImport);
        assertTrue("the collection must be changed", subsystem.removeElementImport(elementImport));
    }

    /**
     * Method under test SubsystemImpl.removeElementImport(ElementImport).
     * Accuracy testing of removal in case element import does not exist.
     */
    public final void testRemoveElementImportAccuracyNotExist() {
        assertFalse("the collection must be left unchanged", subsystem.removeElementImport(elementImport));
    }

    /**
     * Method under test SubsystemImpl.removeElementImports(Collection). Failure
     * testing of exception in case element imports is null.
     */
    public final void testRemoveElementImportsFailureNull() {
        try {
            subsystem.removeElementImports(null);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.removeElementImports(Collection). Failure
     * testing of exception in case element imports contains null values.
     */
    public final void testRemoveElementImportsFailureContainsNull() {
        elementImports.add(null);
        try {
            subsystem.removeElementImports(elementImports);
            fail("IllegalArgumentException is expected since element imports is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.removeElementImports(Collection).
     * Accuracy testing of removal in case element imports exist.
     */
    public final void testRemoveElementImportsAccuracyExist() {
        // adding elementImport
        subsystem.addElementImports(elementImports);
        assertTrue("the collection must be changed", subsystem.removeElementImports(elementImports));
    }

    /**
     * Method under test SubsystemImpl.removeElementImports(Collection).
     * Accuracy testing of removal in case element imports do not exist.
     */
    public final void testRemoveElementImportsAccuracyNotExist() {
        assertFalse("the collection must be left  unchanged", subsystem.removeElementImports(elementImports));
    }

    /**
     * Method under test SubsystemImpl.clearElementImports(). Accuracy testing
     * of clearing participating element imports.
     */
    public final void testClearElementImports() {
        subsystem.addElementImports(elementImports);
        // run successfully
        subsystem.clearElementImports();
        assertTrue("the collection must be empty", subsystem.getElementImports().isEmpty());
    }

    /**
     * Method under test SubsystemImpl.getElementImports(). Accuracy testing of
     * correctly retrieved element imports.
     */
    public final void testGetElementImportsAccuracy() {
        subsystem.addElementImports(elementImports);
        // run successfully
        assertEquals("number of elements in collections must be equal", elementImports.size(), subsystem
            .getElementImports().size());
    }

    /**
     * Method under test SubsystemImpl.getElementImports(). Testing that
     * returned elementImports is shallow copy.
     */
    public final void testGetElementImportsShallow() {
        subsystem.addElementImports(elementImports);
        // run successfully
        Collection<ElementImport> currentElementImports = subsystem.getElementImports();
        subsystem.addElementImport(new ElementImportImpl());
        assertFalse("number elements in collections must be different", currentElementImports.size() == subsystem
            .getElementImports().size());
    }

    /**
     * Method under test SubsystemImpl.containsElementImport(ElementImport).
     * Failure testing of exception in case element import is null.
     */
    public final void testContainsElementImportFailure() {
        try {
            subsystem.containsElementImport(null);
            fail("IllegalArgumentException is expected since element import is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test SubsystemImpl.containsElementImport(ElementImport).
     * Accuracy test of element import existing.
     */
    public final void testContainsElementImportAccuracyExist() {
        subsystem.addElementImport(elementImport);
        assertTrue("element import must exist", subsystem.containsElementImport(elementImport));
    }

    /**
     * Method under test SubsystemImpl.containsElementImport(ElementImport).
     * Accuracy test of missed element import.
     */
    public final void testContainsElementImportAccuracyNotExist() {
        assertFalse("element import must not exist", subsystem.containsElementImport(elementImport));
    }

    /**
     * Method under test SubsystemImpl.countElementImports(). Accuracy testing
     * of empty element imports.
     */
    public final void testCountElementImportsEmpty() {
        assertEquals("number of element imports must be 0", 0, subsystem.countElementImports());
    }

    /**
     * Method under test SubsystemImpl.countElementImports(). Accuracy testing
     * of not empty element imports.
     */
    public final void testCountElementImportsNotEmpty() {
        subsystem.addElementImports(elementImports);
        assertEquals("number of element imports must be 3", 3, subsystem.countElementImports());
    }
}