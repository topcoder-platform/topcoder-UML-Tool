/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class AbstractZUMLActivityEdge.
 *
 * @author KLW
 * @version 1.0
 */
public class AbstractZUMLActivityEdgeAccuracyTests extends TestCase {
    /**
     * the AbstractZUMLActivityEdge instance for test.
     */
    private AbstractZUMLActivityEdge instance;

    /**
     * set up the test environment.
     */
    protected void setUp() {
        instance = new ZUMLActivityEdgeImpl();
    }

    /**
     * tear down the test environment.
     */
    protected void tearDown() {
        instance = null;
    }

    /**
     * the accuracy test for the constructor.
     *
     */
    public void testCtor() {
        assertNotNull("The instance should not be null.", instance);
        assertNull(instance.getSource());
        assertNull(instance.getTarget());
        assertNull(instance.getGuard());
    }

    /**
     * the accuracy test for the getter and setter of the source.
     *
     */
    public void testSourcet() {
        ZUMLActivityNode source = new ZUMLInitialNodeImpl();
        assertNull(instance.getSource());
        instance.setSource(source);
        assertEquals(source, instance.getSource());
    }

    /**
     * the accuracy test for the getter and setter of the target.
     *
     */
    public void testTarget() {
        ZUMLActivityNode target = new ZUMLInitialNodeImpl();
        assertNull(instance.getTarget());
        instance.setTarget(target);
        assertEquals(target, instance.getTarget());
    }

    /**
     * the accuracy test for the getter and setter of the guard.
     *
     */
    public void testGuard() {
        ZUMLOpaqueExpression guard = new ZUMLOpaqueExpressionImpl();
        assertNull(instance.getGuard());
        instance.setGuard(guard);
        assertEquals(guard, instance.getGuard());
    }
}
