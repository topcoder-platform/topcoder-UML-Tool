/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>EnumerationLiteralImpl</code> class. It addresses the
 * functionality provided by the <code>EnumerationLiteralImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class EnumerationLiteralImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>Enumeration</code> for test.</p>
     */
    private Enumeration enumImpl = new EnumerationImpl();

    /**
     * <p>The instance of <code>EnumerationLiteralImpl</code> for test.</p>
     */
    private EnumerationLiteralImpl enumLitImpl = null;

    /**
     * <p>Test suite of <code>EnumerationLiteralImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>EnumerationLiteralImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(EnumerationLiteralImplAccuracyTest.class);
    }

    /**
     * <p>Accuracy test of the <code>EnumerationLiteralImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_EnumerationImpl() {
        assertTrue("EnumerationLiteralImpl class should extend from the EnumerationLiteral.",
            EnumerationLiteral.class.isAssignableFrom(EnumerationLiteralImpl.class));
        assertTrue("EnumerationLiteralImpl class should extend from the ModelElementAbstractImpl.",
            ModelElementAbstractImpl.class.isAssignableFrom(EnumerationLiteralImpl.class));
    }

    /**
     * <p>Detail test of <code>EnumerationLiteralImpl()</code> constructor. Creates a
     * instance and get its attributes for test.</p>
     */
    public void testCtor_EnumerationImpl() {
        enumLitImpl = new EnumerationLiteralImpl();

        // check null here.
        assertNotNull("Create EnumerationLiteralImpl failed.", enumLitImpl);

        // check the value here.
        assertNull("Create EnumerationLiteralImpl failed.", enumLitImpl.getEnumeration());
    }

    /**
     * <p>Basic test of the <code>getEnumeration()</code> method.</p>
     */
    public void testMethod_getEnumeration() {
        enumLitImpl = new EnumerationLiteralImpl();

        assertNull("The getEnumeration method is incorrect.", enumLitImpl.getEnumeration());

        // set and test it.
        enumLitImpl.setEnumeration(enumImpl);
        assertEquals("The getEnumeration method is incorrect.", enumImpl,
            enumLitImpl.getEnumeration());
    }

    /**
     * <p>Basic test of the <code>setEnumeration(Enumeration enumeration)</code> method.</p>
     */
    public void testMethod_setEnumeration() {
        enumLitImpl = new EnumerationLiteralImpl();

        // set and test it.
        enumLitImpl.setEnumeration(enumImpl);
        assertEquals("The setEnumeration method is incorrect.", enumImpl,
            enumLitImpl.getEnumeration());

        // set to null and test it.
        enumLitImpl.setEnumeration(null);
        assertNull("The setEnumeration method is incorrect.", enumLitImpl.getEnumeration());
    }
}
