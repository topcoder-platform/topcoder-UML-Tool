/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.Collection;

import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>OperationImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class OperationImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>OperationImpl</code> instance used for testing. */
    private OperationImpl operation;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the OperationImpl instance
        operation = new OperationImpl();
    }

    /**
     * Accuracy test of method <code>setConcurrency(CallConcurrencyKind)</code> and <code>getConcurrency()</code>.
     */
    public void testConcurrencySetterAndGetter() {
        //initial value is null
        assertNull(operation.getConcurrency());
        //set the Concurrency with specified CallConcurrencyKind
        operation.setConcurrency(CallConcurrencyKind.CONCURRENT);
        assertNotNull(operation.getConcurrency());
        //set the visibility with null
        operation.setConcurrency(null);
        assertNull(operation.getConcurrency());
    }

    /**
     * Accuracy test of method <code>setRoot(boolean)</code> and <code>isRoot()</code>.
     */
    public void testRootSetterAndGetter() {
        //initial value is false
        assertFalse(operation.isRoot());
        //sets the Root with true
        operation.setRoot(true);
        assertTrue(operation.isRoot());
        //sets the Root with false
        operation.setRoot(false);
        assertFalse(operation.isRoot());
    }

    /**
     * Accuracy test of method <code>setLeaf(boolean)</code> and <code>isLeaf()</code>.
     */
    public void testLeafSetterAndGetter() {
        //initial value is false
        assertFalse(operation.isLeaf());
        //sets the Leaf with true
        operation.setLeaf(true);
        assertTrue(operation.isLeaf());
        //sets the Leaf with false
        operation.setLeaf(false);
        assertFalse(operation.isLeaf());
    }

    /**
     * Accuracy test of method <code>setAbstract(boolean)</code> and <code>isAbstract()</code>.
     */
    public void testAbstractSetterAndGetter() {
        //initial value is false
        assertFalse(operation.isAbstract());
        //sets the Abstract with true
        operation.setAbstract(true);
        assertTrue(operation.isAbstract());
        //sets the Abstract with false
        operation.setAbstract(false);
        assertFalse(operation.isAbstract());
    }

    /**
     * Accuracy test of method <code>setSpecification(String)</code> and <code>getSpecification()</code>.
     */
    public void testSpecificationSetterAndGetter() {
        //initial value is null
        assertNull(operation.getSpecification());
        //sets the specification with valid String
        operation.setSpecification("some");
        assertNotNull(operation.getSpecification());
        //sets the specification with empty String
        operation.setSpecification("");
        assertEquals("", operation.getSpecification());
        //sets the specification with null
        operation.setSpecification(null);
        assertNull(operation.getSpecification());
    }

    /**
     * Accuracy test of method <code>addMethod(Method)</code>, <code>removeMethod(Method)</code>,
     * <code>containsMethod(Method)</code>, <code>clearMethods()</code>, <code>getMethods()</code>
     * and <code>countMethods()</code>.
     */
    public void testMethodOperations() {
        //initial value is an empty ArrayList
        assertEquals(0, operation.countMethods());
        //add a Method
        Method method0 = new MethodImpl();
        operation.addMethod(method0);
        assertEquals(1, operation.countMethods());
        assertTrue(operation.containsMethod(method0));
        //add another two Methods
        Method method1 = new MethodImpl();
        operation.addMethod(method1);
        Method method2 = method1;
        operation.addMethod(method2);
        assertEquals(3, operation.countMethods());
        //get all the Methods
        Collection<Method> methods = operation.getMethods();
        assertEquals(3, methods.size());
        //remove a Method
        assertTrue(operation.removeMethod(method1));
        assertEquals(2, operation.countMethods());
        assertFalse(operation.removeMethod(new MethodImpl()));
        //clear all the Methods
        operation.clearMethods();
        assertEquals(0, operation.countMethods());
    }
}
