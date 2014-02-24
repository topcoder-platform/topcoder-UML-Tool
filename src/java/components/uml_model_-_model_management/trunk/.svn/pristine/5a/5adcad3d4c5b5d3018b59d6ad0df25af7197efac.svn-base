/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * AccuracyTest for SubsystemImpl class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class SubsystemImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private Subsystem subsystem = new SubsystemImpl();

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
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(SubsystemImplAccuracyTest.class);
    }

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        // do nothing
    }

    /**
     * Tears down the environment for the TestCase.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // do nothing
    }

    /**
     * Accuracy test of <code>SubsystemImpl()</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSubsystemImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", subsystem);
        assertEquals("subsystem should be empty.", 0, subsystem.countElementImports());
    }

    /**
     * Accuracy test of <code>isInstantiable()</code> and
     * <code>setInstantiable(boolean instantiable)</code> methods.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsSetInstantiableAccuracy() throws Exception {
        assertFalse("result is incorrect.", subsystem.isInstantiable());
        subsystem.setInstantiable(true);
        assertTrue("result is incorrect.", subsystem.isInstantiable());
    }

    /**
     * Accuracy test of
     * <code>addElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddElementImportAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        assertTrue("elementImport1 should be contained.", subsystem.containsElementImport(elementImport1));
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
        subsystem.addElementImports(elementImports);

        assertTrue("elementImport1 should be contained.", subsystem.containsElementImport(elementImport1));
        assertTrue("elementImport2 should be contained.", subsystem.containsElementImport(elementImport2));
    }

    /**
     * Accuracy test of
     * <code>removeElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveElementImportAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport1);
        assertTrue("it should be removed successful.", subsystem.removeElementImport(elementImport1));
        assertTrue("it should be removed successful.", subsystem.removeElementImport(elementImport1));
        assertFalse("it should be false indicated that elementImport1 is not exist.", subsystem
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
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport2);
        subsystem.addElementImport(elementImport3);

        elementImports.add(elementImport1);
        elementImports.add(elementImport3);

        subsystem.removeElementImports(elementImports);
        assertEquals("should remain 2 element.", 2, subsystem.countElementImports());
        assertTrue("elementImport1 should be contained.", subsystem.containsElementImport(elementImport1));
        assertTrue("elementImport2 should be contained.", subsystem.containsElementImport(elementImport2));
    }

    /**
     * Accuracy test of <code>clearElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClearElementImportsAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport2);
        subsystem.clearElementImports();
        assertEquals("elementImports is not clear.", 0, subsystem.countElementImports());
    }

    /**
     * Accuracy test of <code>getElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetElementImportsAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport2);
        subsystem.addElementImport(elementImport3);

        elementImports = subsystem.getElementImports();
        Collection<ElementImport> expectElementImports = new ArrayList<ElementImport>();
        expectElementImports.add(elementImport1);
        expectElementImports.add(elementImport1);
        expectElementImports.add(elementImport2);
        expectElementImports.add(elementImport3);

        assertEquals("result is incorrect.", expectElementImports, elementImports);

        // test if it is a copy of elementImports.
        elementImports.clear();
        assertEquals("elements should not clear.", 4, subsystem.countElementImports());
    }

    /**
     * Accuracy test of
     * <code>containsElementImport(ElementImport elementImport)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsElementImportAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        assertTrue("elementImport1 should be contained.", subsystem.containsElementImport(elementImport1));
    }

    /**
     * Accuracy test of <code>countElementImports()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCountElementImportsAccuracy() throws Exception {
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport1);
        subsystem.addElementImport(elementImport2);
        subsystem.addElementImport(elementImport3);
        assertEquals("count should be 4.", 4, subsystem.countElementImports());
    }
}
