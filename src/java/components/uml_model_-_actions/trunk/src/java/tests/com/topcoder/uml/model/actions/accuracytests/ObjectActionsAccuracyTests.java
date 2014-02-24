/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ ObjectActionsAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.PrimitiveActionAbstractImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.actions.objectactions.DestroyObjectAction;
import com.topcoder.uml.model.actions.objectactions.DestroyObjectActionImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>CreateObjectActionImpl</code> and <code>DestroyObjectActionImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CreateObjectActionImpl</code> class and <code>DestroyObjectActionImpl</code>.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ObjectActionsAccuracyTests extends TestCase {
    /**
     * <p>
     * Test suite of <code>ObjectActionsAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ObjectActionsAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ObjectActionsAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateObjectActionImpl()</code> constructor.
     * </p>
     */
    public void testConstructor_CreateObject() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.",
            new CreateObjectActionImpl());
    }

    /**
     * <p>
     * Accuracy Test of the <code>DestroyObjectActionImpl()</code> constructor.
     * </p>
     */
    public void testConstructor_DestroyObject() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.",
            new DestroyObjectActionImpl());
    }

    /**
     * <p>
     * Accuracy Test of the <code>CreateObjectActionImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship_CreateObject() {
        // creat a new instance
        CreateObjectActionImpl action = new CreateObjectActionImpl();

        // test class inheritance.
        assertTrue("This class should extend from PrimitiveActionAbstractImpl",
            action instanceof PrimitiveActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement CreateObjectAction interface",
            action instanceof CreateObjectAction);
    }

    /**
     * <p>
     * Accuracy Test of the <code>DestroyObjectActionImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship_DestroyObject() {
        // creat a new instance
        DestroyObjectActionImpl action = new DestroyObjectActionImpl();

        // test class inheritance.
        assertTrue("This class should extend from PrimitiveActionAbstractImpl",
            action instanceof PrimitiveActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement DestroyObjectAction interface",
            action instanceof DestroyObjectAction);
    }
}
