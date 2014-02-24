/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ PrimitiveActionAbstractImplAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.ActionAbstractImpl;
import com.topcoder.uml.model.actions.PrimitiveAction;
import com.topcoder.uml.model.actions.PrimitiveActionAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>PrimitiveActionAbstractImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>PrimitiveActionAbstractImpl</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class PrimitiveActionAbstractImplAccuracyTests extends TestCase {
    /**
     * <p>
     * Test suite of <code>PrimitiveActionAbstractImplAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>PrimitiveActionAbstractImplAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(PrimitiveActionAbstractImplAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>PrimitiveActionAbstractImpl()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.",
            new MockPrimitiveActionImpl());
    }

    /**
     * <p>
     * Accuracy Test of the <code>PrimitiveActionAbstractImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship() {
        PrimitiveActionAbstractImpl action = new MockPrimitiveActionImpl();

        // test class inheritance.
        assertTrue("This class should extend from ActionAbstractImpl",
            action instanceof ActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement PrimitiveAction interface",
            action instanceof PrimitiveAction);
    }

    /**
     * <p>
     * A inner class which extends the <code>PrimitiveActionAbstractImpl</code> class, used for
     * accuracy test only.
     * </p>
     */
    class MockPrimitiveActionImpl extends PrimitiveActionAbstractImpl {
        // use default constructor.
    }
}
