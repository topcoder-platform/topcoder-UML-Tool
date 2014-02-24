/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Unit test for <code>OperationImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class OperationImplUnitTests extends TestCase {
    /**
     * <p>
     * Represents the <code>OperationImpl</code> instance used for tests.
     * </p>
     */
    private OperationImpl testOperationImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testOperationImpl = new OperationImpl();
    }

    /**
     * <p>
     * Accuracy test the OperationImpl constructor.
     * </p>
     */
    public void testOperationImplConstructor() {
        assertNotNull("Create OperationImpl object incorrectly.", new OperationImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setConcurrency(CallConcurrencyKind)</code>, the <code>Concurrency</code>
     * field should be set.
     * </p>
     */
    public void testSetConcurrency() {
        CallConcurrencyKind callConcurrency = CallConcurrencyKind.GUARDED;
        testOperationImpl.setConcurrency(callConcurrency);
        assertEquals("The Concurrency field should be set.", callConcurrency, testOperationImpl.getConcurrency());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getConcurrency()</code>, the <code>Concurrency</code> field should be
     * returned.
     * </p>
     */
    public void testGetConcurrency() {
        CallConcurrencyKind callConcurrency = CallConcurrencyKind.SEQUENTIAL;
        testOperationImpl.setConcurrency(callConcurrency);
        assertEquals("The Concurrency field should be get.", callConcurrency, testOperationImpl.getConcurrency());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setRoot(boolean)</code>, the <code>Root</code> field should be set.
     * </p>
     */
    public void testSetRoot() {
        testOperationImpl.setRoot(true);
        assertTrue("The Root field should be set.", testOperationImpl.isRoot());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isRoot()</code>, the <code>Root</code> field should be returned.
     * </p>
     */
    public void testIsRoot() {
        testOperationImpl.setRoot(false);
        assertFalse("The Root field should be get.", testOperationImpl.isRoot());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setLeaf(boolean)</code>, the <code>Leaf</code> field should be set.
     * </p>
     */
    public void testSetLeaf() {
        testOperationImpl.setLeaf(true);
        assertTrue("The Leaf field should be set.", testOperationImpl.isLeaf());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isLeaf()</code>, the <code>Leaf</code> field should be returned.
     * </p>
     */
    public void testIsLeaf() {
        testOperationImpl.setLeaf(false);
        assertFalse("The Leaf field should be get.", testOperationImpl.isLeaf());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setAbstract(boolean)</code>, the <code>Abstract</code> field should be
     * set.
     * </p>
     */
    public void testSetAbstract() {
        testOperationImpl.setAbstract(true);
        assertTrue("The Abstract field should be set.", testOperationImpl.isAbstract());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isAbstract()</code>, the <code>Abstract</code> field should be
     * returned.
     * </p>
     */
    public void testIsAbstract() {
        testOperationImpl.setAbstract(false);
        assertFalse("The Abstract field should be get.", testOperationImpl.isAbstract());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setSpecification(String)</code>, the <code>Specification</code> field
     * should be set.
     * </p>
     */
    public void testSetSpecification() {
        String specification = "newSpecification";
        testOperationImpl.setSpecification(specification);
        assertEquals("The Specification field should be set.", specification, testOperationImpl.getSpecification());

        testOperationImpl.setSpecification(null);
        assertNull("The Specification field should be null.", testOperationImpl.getSpecification());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getSpecification()</code>, the <code>Specification</code> field should
     * be returned.
     * </p>
     */
    public void testGetSpecification() {
        String specification = "newSpecification";
        testOperationImpl.setSpecification(specification);
        assertEquals("The Specification field should be get.", specification, testOperationImpl.getSpecification());

        testOperationImpl.setSpecification(null);
        assertNull("The Specification field should be null.", testOperationImpl.getSpecification());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addMethod(Method)</code>.
     * </p>
     */
    public void testAddMethod() {
        Method method = new MethodImpl();
        testOperationImpl.addMethod(method);
        assertTrue("Add method incorrectly.", testOperationImpl.removeMethod(method));
    }

    /**
     * <p>
     * Test the method of <code>addMethod(Method)</code> with null method. Should throw IllegalArgumentException.
     * </p>
     */
    public void testAddMethodNullMethod() {
        try {
            testOperationImpl.addMethod(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeMethod(Method)</code>.
     * </p>
     */
    public void testRemoveMethod() {
        Method method = new MethodImpl();
        testOperationImpl.addMethod(method);
        assertTrue("Remove method incorrectly.", testOperationImpl.removeMethod(method));
    }

    /**
     * <p>
     * Test the method of <code>removeMethod(Method)</code> with null method. Should throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveMethodNullMethod() {
        try {
            testOperationImpl.removeMethod(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearMethods()</code>.
     * <p>
     */
    public void testClearMethods() {
        testOperationImpl.clearMethods();
        assertEquals("The count of method should be 0.", 0, testOperationImpl.countMethods());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getMethods()</code>.
     * </p>
     */
    public void testGetMethods() {
        testOperationImpl.clearMethods();
        Collection<Method> methods = new ArrayList<Method>();
        for (int i = 0; i < 3; ++i) {
            Method method = new MethodImpl();
            methods.add(method);
            testOperationImpl.addMethod(method);
        }
        assertEquals("Get methods incorrectly.", methods, testOperationImpl.getMethods());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsMethod(Method)</code>.
     * </p>
     */
    public void testContainsMethod() {
        Method method = new MethodImpl();
        testOperationImpl.addMethod(method);
        assertTrue("Contains method incorrectly.", testOperationImpl.containsMethod(method));

        assertFalse("Contains Method incorrectly.", testOperationImpl.containsMethod(new MethodImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsMethod(Method)</code> with null method. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsMethodNullMethod() {
        try {
            testOperationImpl.containsMethod(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countMethods()</code>.
     * </p>
     */
    public void testCountMethods() {
        testOperationImpl.clearMethods();
        assertEquals("The count of methods should be 0.", 0, testOperationImpl.countMethods());

        testOperationImpl.addMethod(new MethodImpl());
        assertEquals("The count of methods should be 1.", 1, testOperationImpl.countMethods());
    }
}
