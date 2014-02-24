/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>InterfaceImpl</code> class. It addresses the
 * functionality provided by the <code>InterfaceImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class InterfaceImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>InterfaceImpl</code> for test.</p>
     */
    private InterfaceImpl interfaceImpl = null;

    /**
     * <p>Test suite of <code>InterfaceImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>InterfaceImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(InterfaceImplAccuracyTest.class);
    }

    /**
     * <p>Detail test of <code>InterfaceImpl()</code> constructor. Creates a instance and
     * get its attributes for test.</p>
     */
    public void testCtor_InterfaceImpl() {
        interfaceImpl = new InterfaceImpl();

        // check null here.
        assertNotNull("Create InterfaceImpl failed.", interfaceImpl);
    }

    /**
     * <p>Accuracy test of the <code>InterfaceImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_InterfaceImpl() {
        assertTrue("InterfaceImpl class should extend from the DataType.",
            Interface.class.isAssignableFrom(InterfaceImpl.class));
        assertTrue("InterfaceImpl class should extend from the ClassifierAbstractImpl.",
            ClassifierAbstractImpl.class.isAssignableFrom(InterfaceImpl.class));
    }
}
