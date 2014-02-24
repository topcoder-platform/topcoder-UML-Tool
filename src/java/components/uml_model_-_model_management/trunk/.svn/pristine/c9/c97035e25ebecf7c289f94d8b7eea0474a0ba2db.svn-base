/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement.accuracytests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * AccuracyTest for ElementImportImpl class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class ElementImportImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ElementImportImpl elementImport = new ElementImportImpl();

    /**
     * This instance is used in the test.
     */
    private Package p = new PackageImpl();

    /**
     * This instance is used in the test.
     */
    private ModelElement modelElement = new ModelElementAbstractImpl() {
    };

    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ElementImportImplAccuracyTest.class);
    }

    /**
     * Accuracy test of <code>ElementImportImpl()</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testElementImportImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", elementImport);
    }

    /**
     * Accuracy test of <code>getPackage()</code> and
     * <code>setPackage(Package aPackage)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetPackageAccuracy() throws Exception {
        assertNull("result is incorrect.", elementImport.getPackage());
        elementImport.setPackage(p);
        assertEquals("result is incorrect.", p, elementImport.getPackage());
    }

    /**
     * Accuracy test of <code>getVisibility()</code> and
     * <code>setVisibility(VisibilityKind visibility)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetVisibilityAccuracy() throws Exception {
        assertNull("result is incorrect.", elementImport.getVisibility());
        elementImport.setVisibility(VisibilityKind.PACKAGE);
        assertEquals("result is incorrect.", VisibilityKind.PACKAGE, elementImport.getVisibility());
    }

    /**
     * Accuracy test of <code>getAlias()</code> and
     * <code>setAlias(String alias)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetAliasAccuracy() throws Exception {
        assertNull("result is incorrect.", elementImport.getAlias());
        elementImport.setAlias("test");
        assertEquals("result is incorrect.", "test", elementImport.getAlias());
    }

    /**
     * Accuracy test of <code>isSpecification()</code> and
     * <code>setSpecification(boolean specification)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsSetSpecificationAccuracy() throws Exception {
        assertFalse("result is incorrect.", elementImport.isSpecification());
        elementImport.setSpecification(true);
        assertTrue("result is incorrect.", elementImport.isSpecification());
    }

    /**
     * Accuracy test of <code>getImportedElement()</code> and
     * <code>setImportedElement(ModelElement importedElement)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetImportedElementAccuracy() throws Exception {
        assertNull("result is incorrect.", elementImport.getImportedElement());
        elementImport.setImportedElement(modelElement);
        assertEquals("result is incorrect.", modelElement, elementImport.getImportedElement());
    }
}
