/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * AccuracyTest for PackageImpl class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class PackageImplAccuracyTest extends TestCase {

    /**
     * This instance is used in the test.
     */
    private PackageImpl packageImpl = new PackageImpl();

    /**
     * This instance is used in the test.
     */
    private ElementImport elementImport1 = new ElementImportImpl();

    /**
     * This instance is used in the test.
     */
    private ElementImport elementImport2 = new ElementImportImpl();

    /**
     * This instance is used in the test.
     */
    private ElementImport elementImport3 = new ElementImportImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<ElementImport> elementImports = new ArrayList<ElementImport>();

    /**
     * This instance is used in the test.
     */
    private ModelElement modelElement1 = new ModelElementAbstractImpl() {
    };

    /**
     * This instance is used in the test.
     */
    private ModelElement modelElement2 = new ModelElementAbstractImpl() {
    };

    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(PackageImplAccuracyTest.class);
    }

    /**
     * Accuracy test of <code>PackageImpl()</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPackageImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", packageImpl);
        assertEquals("elementImports should be empty.", 0, packageImpl.countElementImports());
        assertEquals("ownedElements should be empty.", 0, packageImpl.countOwnedElements());
    }

    /**
     * Accuracy test of <code>SubsystemImpl()</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSubsystemImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", packageImpl);
        assertEquals("subsystem should be empty.", 0, packageImpl.countElementImports());
    }

    /**
     * Accuracy test of
     * <code>addElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddElementImportAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        assertTrue("elementImport1 should be contained.", packageImpl.containsElementImport(elementImport1));
    }

    /**
     * Accuracy test of
     * <code>addElementImports(Collection &lt;ElementImport&gt; elementImports)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddElementImportsAccuracy() throws Exception {
        elementImports.add(elementImport1);
        elementImports.add(elementImport2);
        packageImpl.addElementImports(elementImports);

        assertTrue("elementImport1 should be contained.", packageImpl.containsElementImport(elementImport1));
        assertTrue("elementImport2 should be contained.", packageImpl.containsElementImport(elementImport2));
    }

    /**
     * Accuracy test of
     * <code>removeElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveElementImportAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport1);
        assertTrue("it should be removed successful.", packageImpl.removeElementImport(elementImport1));
        assertTrue("it should be removed successful.", packageImpl.removeElementImport(elementImport1));
        assertFalse("it should be false indicated that elementImport1 is not exist.", packageImpl
            .removeElementImport(elementImport1));

    }

    /**
     * Accuracy test of
     * <code>removeElementImports(Collection &lt;ElementImport&gt; elementImports)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveElementImportsAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport2);
        packageImpl.addElementImport(elementImport3);

        elementImports.add(elementImport1);
        elementImports.add(elementImport3);

        packageImpl.removeElementImports(elementImports);
        assertEquals("should remain 2 element.", 2, packageImpl.countElementImports());
        assertTrue("elementImport1 should be contained.", packageImpl.containsElementImport(elementImport1));
        assertTrue("elementImport2 should be contained.", packageImpl.containsElementImport(elementImport2));
    }

    /**
     * Accuracy test of <code>clearElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClearElementImportsAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport2);
        packageImpl.clearElementImports();
        assertEquals("elementImports is not clear.", 0, packageImpl.countElementImports());
    }

    /**
     * Accuracy test of <code>getElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetElementImportsAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport2);
        packageImpl.addElementImport(elementImport3);

        elementImports = packageImpl.getElementImports();
        Collection<ElementImport> expectElementImports = new ArrayList<ElementImport>();
        expectElementImports.add(elementImport1);
        expectElementImports.add(elementImport1);
        expectElementImports.add(elementImport2);
        expectElementImports.add(elementImport3);

        assertEquals("result is incorrect.", expectElementImports, elementImports);

        // test if it is a copy of elementImports.
        elementImports.clear();
        assertEquals("elements should not clear.", 4, packageImpl.countElementImports());
    }

    /**
     * Accuracy test of
     * <code>containsElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsElementImportAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        assertTrue("elementImport1 should be contained.", packageImpl.containsElementImport(elementImport1));
    }

    /**
     * Accuracy test of <code>countElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCountElementImportsAccuracy() throws Exception {
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport1);
        packageImpl.addElementImport(elementImport2);
        packageImpl.addElementImport(elementImport3);
        assertEquals("count should be 4.", 4, packageImpl.countElementImports());
    }

    /**
     * Accuracy test of <code>addOwnedElement(ModelElement ownedElement)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddOwnedElementAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        assertTrue("modelElement1 should be contained.", packageImpl.containsOwnedElement(modelElement1));
    }

    /**
     * Accuracy test of
     * <code>removeOwnedElement(ModelElement ownedElement)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveOwnedElementAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.addOwnedElement(modelElement1);

        assertTrue("first modelElement1 should be removed.", packageImpl.removeOwnedElement(modelElement1));
        assertTrue("second modelElement1 should be removed.", packageImpl.removeOwnedElement(modelElement1));
        assertFalse("modelElement1 is not exist, so should return false.", packageImpl
            .removeOwnedElement(modelElement1));
    }

    /**
     * Accuracy test of <code>clearOwnedElements()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClearOwnedElementsAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.clearOwnedElements();
        assertEquals("owedElements should be clear.", 0, packageImpl.countOwnedElements());
    }

    /**
     * Accuracy test of <code>getOwnedElements()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetOwnedElementsAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.addOwnedElement(modelElement2);
        Collection<ModelElement> ownedElements = packageImpl.getOwnedElements();
        Collection<ModelElement> expectOwnedElements = new ArrayList<ModelElement>();
        expectOwnedElements.add(modelElement1);
        expectOwnedElements.add(modelElement1);
        expectOwnedElements.add(modelElement2);

        assertEquals("ownedElements is incorrect.", expectOwnedElements, ownedElements);
    }

    /**
     * Accuracy test of
     * <code>containsOwnedElement(ModelElement ownedElement)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsOwnedElementAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        assertTrue("modelElement1 should be contained.", packageImpl.containsOwnedElement(modelElement1));
    }

    /**
     * Accuracy test of <code>countOwnedElements()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCountOwnedElementsAccuracy() throws Exception {
        packageImpl.addOwnedElement(modelElement1);
        packageImpl.addOwnedElement(modelElement1);
        assertEquals("count should be 2.", 2, packageImpl.countOwnedElements());
    }
}
