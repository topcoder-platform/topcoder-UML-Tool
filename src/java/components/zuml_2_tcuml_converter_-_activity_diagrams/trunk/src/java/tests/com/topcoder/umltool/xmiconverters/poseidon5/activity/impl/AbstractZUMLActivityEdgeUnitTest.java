/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>AbstractZUMLActivityEdge</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class AbstractZUMLActivityEdgeUnitTest extends TestCase {
    /**
     * <p>The AbstractZUMLActivityEdge instance for test.</p>
     */
    private AbstractZUMLActivityEdge edge;

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        edge = new MockZUMLActivityEdge();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractZUMLActivityEdgeUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>AbstractZUMLActivityEdge()</code>.
     * </p>
     *
     * <p>
     * Verify that the source, target and guard are initialized as null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Unable to create MockZUMLActivityEdge instance.", edge);

        assertNull("The source is initialized as null.", edge.getSource());
        assertNull("The target is initialized as null.", edge.getTarget());
        assertNull("The guard is initialized as null.", edge.getGuard());
    }

    /**
     * <p>
     * Accuracy test for <code>getSource()</code>.
     * </p>
     * <p>
     * Verify that the source is got successfully.
     * </p>
     */
    public void testGetSource() {
        assertNull("The source is initialized as null.", edge.getSource());

        ZUMLActivityNode source = new ZUMLInitialNodeImpl();
        edge.setSource(source);

        assertEquals("The source should match.", source, edge.getSource());
    }

    /**
     * <p>
     * Accuracy test for <code>setSource(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that the source is set to the edge.
     * </p>
     */
    public void testSetSource() {
        ZUMLActivityNode source = new ZUMLInitialNodeImpl();
        edge.setSource(source);

        assertEquals("The source should match.", source, edge.getSource());
    }

    /**
     * <p>
     * Failure test for <code>setSource(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the source node is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetSource_Failure() {
        try {
            edge.setSource(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getTarget()</code>.
     * </p>
     * <p>
     * Verify that the target is got successfully.
     * </p>
     */
    public void testGetTarget() {
        assertNull("The target is initialized as null.", edge.getTarget());

        ZUMLActivityNode target = new ZUMLInitialNodeImpl();
        edge.setTarget(target);

        assertEquals("The target should match.", target, edge.getTarget());
    }

    /**
     * <p>
     * Accuracy test for <code>setTarget(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that the target is set to the edge.
     * </p>
     */
    public void testSetTarget() {
        ZUMLActivityNode target = new ZUMLInitialNodeImpl();
        edge.setTarget(target);

        assertEquals("The target should match.", target, edge.getTarget());
    }

    /**
     * <p>
     * Failure test for <code>setTarget(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the target node is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTarget_Failure() {
        try {
            edge.setTarget(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getGuard()</code>.
     * </p>
     * <p>
     * Verify that the guard is got successfully.
     * </p>
     */
    public void testGetGuard() {
        assertNull("The guard is initialized as null.", edge.getGuard());

        ZUMLOpaqueExpression guard = new ZUMLOpaqueExpressionImpl();
        edge.setGuard(guard);

        assertEquals("The guard should match.", guard, edge.getGuard());
    }

    /**
     * <p>
     * Accuracy test for <code>setGuard(ZUMLOpaqueExpression)</code>.
     * </p>
     *
     * <p>
     * Verify that the guard is set successfully.
     * </p>
     */
    public void testSetGuard() {
        ZUMLOpaqueExpression guard = new ZUMLOpaqueExpressionImpl();
        edge.setGuard(guard);

        assertEquals("The guard should match.", guard, edge.getGuard());
    }

    /**
     * <p>
     * Failure test for <code>setGuard(ZUMLOpaqueExpression)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the guard to set is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetGuard_Failure() {
        try {
            edge.setGuard(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
