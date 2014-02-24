/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>PrimitiveImpl</code> class. It addresses the
 * functionality provided by the <code>PrimitiveImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class PrimitiveImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>PrimitiveImpl</code> for test.</p>
     */
    private PrimitiveImpl primitiveImpl = null;

    /**
     * <p>Test suite of <code>PrimitiveImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>PrimitiveImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(PrimitiveImplAccuracyTest.class);
    }

    /**
     * <p>Detail test of <code>PrimitiveImpl()</code> constructor. Creates a instance and
     * get its attributes for test.</p>
     */
    public void testCtor_PrimitiveImpl() {
        primitiveImpl = new PrimitiveImpl();

        // check null here.
        assertNotNull("Create PrimitiveImpl failed.", primitiveImpl);
    }

    /**
     * <p>Accuracy test of the <code>PrimitiveImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_DataTypeImpl() {
        assertTrue("PrimitiveImpl class should extend from the DataTypeImpl.",
            DataTypeImpl.class.isAssignableFrom(PrimitiveImpl.class));
        assertTrue("PrimitiveImpl class should extend from the Primitive.",
            Primitive.class.isAssignableFrom(PrimitiveImpl.class));
    }
}
