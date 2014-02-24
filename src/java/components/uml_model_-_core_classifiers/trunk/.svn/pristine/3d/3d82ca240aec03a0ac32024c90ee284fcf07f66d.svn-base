/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>ClassImpl</code> class. It addresses the functionality
 * provided by the <code>ClassImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class ClassImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>ClassImpl</code> for test.</p>
     */
    private ClassImpl classImpl = null;

    /**
     * <p>Test suite of <code>ClassImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>ClassImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ClassImplAccuracyTest.class);
    }

    /**
     * <p>Detail test of <code>ClassImpl()</code> constructor. Creates a instance and get
     * its attributes for test.</p>
     */
    public void testCtor_ClassImpl() {
        classImpl = new ClassImpl();

        // check null here.
        assertNotNull("Create ClassImpl failed.", classImpl);

        // check the value here.
        assertFalse("The ctor of ClassImpl is incorrect.", classImpl.isActive());
    }

    /**
     * <p>Accuracy test of the <code>ClassImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_ClassImpl() {
        assertTrue("ClassImpl class should extend from the Class.",
            Class.class.isAssignableFrom(ClassImpl.class));
        assertTrue("ClassImpl class should extend from the ClassifierAbstractImpl.",
            ClassifierAbstractImpl.class.isAssignableFrom(ClassImpl.class));
    }

    /**
     * <p>Basic test of the <code>isActive()</code> method.</p>
     */
    public void testMethod_isActive() {
        classImpl = new ClassImpl();

        assertFalse("The isActive method is incorrect.", classImpl.isActive());

        // set to true and test it.
        classImpl.setActive(true);
        assertTrue("The isActive method is incorrect.", classImpl.isActive());
    }

    /**
     * <p>Basic test of the <code>setActive(boolean active)</code> method.</p>
     */
    public void testMethod_setActive() {
        classImpl = new ClassImpl();

        // set to true and test it.
        classImpl.setActive(true);
        assertTrue("The isActive method is incorrect.", classImpl.isActive());

        // set to false and test it.
        classImpl.setActive(false);
        assertFalse("The isActive method is incorrect.", classImpl.isActive());
    }
}
