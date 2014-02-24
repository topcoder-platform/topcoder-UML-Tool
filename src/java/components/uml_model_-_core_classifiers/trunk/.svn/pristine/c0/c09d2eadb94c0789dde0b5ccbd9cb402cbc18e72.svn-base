/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>DataTypeImpl</code> class. It addresses the functionality
 * provided by the <code>DataTypeImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DataTypeImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>DataTypeImpl</code> for test.</p>
     */
    private DataTypeImpl dataTypeImpl = null;

    /**
     * <p>Test suite of <code>DataTypeImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>DataTypeImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DataTypeImplAccuracyTest.class);
    }

    /**
     * <p>Detail test of <code>DataTypeImpl()</code> constructor. Creates a instance and
     * get its attributes for test.</p>
     */
    public void testCtor_DataTypeImpl() {
        dataTypeImpl = new DataTypeImpl();

        // check null here.
        assertNotNull("Create DataTypeImpl failed.", dataTypeImpl);
    }

    /**
     * <p>Accuracy test of the <code>DataTypeImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_DataTypeImpl() {
        assertTrue("DataTypeImpl class should extend from the DataType.",
            DataType.class.isAssignableFrom(DataTypeImpl.class));
        assertTrue("DataTypeImpl class should extend from the ClassifierAbstractImpl.",
            ClassifierAbstractImpl.class.isAssignableFrom(DataTypeImpl.class));
    }
}
