/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.ProgrammingLanguageDataType;
import com.topcoder.uml.model.core.classifiers.ProgrammingLanguageDataTypeImpl;
import com.topcoder.uml.model.datatypes.expressions.TypeExpression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>The accuracy tests of the <code>ProgrammingLanguageDataTypeImpl</code> class. It
 * addresses the functionality provided by the <code>ProgrammingLanguageDataTypeImpl</code>
 * class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class ProgrammingLanguageDataTypeImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>TypeExpression</code> for test.</p>
     */
    private TypeExpression expression = new SimpleTypeExpression();

    /**
     * <p>The instance of <code>ProgrammingLanguageDataTypeImpl</code> for test.</p>
     */
    private ProgrammingLanguageDataTypeImpl plDataTypeImpl = null;

    /**
     * <p>Test suite of <code>ProgrammingLanguageDataTypeImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>ProgrammingLanguageDataTypeImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ProgrammingLanguageDataTypeImplAccuracyTest.class);
    }

    /**
     * <p>Detail test of <code>ProgrammingLanguageDataTypeImpl()</code> constructor.
     * Creates a instance and get its attributes for test.</p>
     */
    public void testCtor_ProgrammingLanguageDataTypeImpl() {
        plDataTypeImpl = new ProgrammingLanguageDataTypeImpl();

        // check null here.
        assertNotNull("Create ProgrammingLanguageDataTypeImpl failed.", plDataTypeImpl);

        // check the value here.
        assertNull("Create ProgrammingLanguageDataTypeImpl failed.", plDataTypeImpl.getExpression());
    }

    /**
     * <p>Accuracy test of the <code>ProgrammingLanguageDataTypeImpl</code> class'
     * Inheritance.</p>
     */
    public void testInheritance_DataTypeImpl() {
        assertTrue("ProgrammingLanguageDataTypeImpl class should extend from the DataTypeImpl.",
            DataTypeImpl.class.isAssignableFrom(ProgrammingLanguageDataTypeImpl.class));
        assertTrue("ProgrammingLanguageDataTypeImpl class should extend from the ProgrammingLanguageDataType.",
            ProgrammingLanguageDataType.class.isAssignableFrom(
                ProgrammingLanguageDataTypeImpl.class));
    }

    /**
     * <p>Basic test of the <code>getExpression()</code> method.</p>
     */
    public void testMethod_getExpression() {
        plDataTypeImpl = new ProgrammingLanguageDataTypeImpl();

        assertNull("The getExpression method is incorrect.", plDataTypeImpl.getExpression());

        // set expression and test it.
        plDataTypeImpl.setExpression(expression);
        assertEquals("The getExpression method is incorrect.", expression,
            plDataTypeImpl.getExpression());
    }

    /**
     * <p>Basic test of the <code>setExpression(TypeExpression expression)</code> method.</p>
     */
    public void testMethod_setExpression() {
        plDataTypeImpl = new ProgrammingLanguageDataTypeImpl();

        // set expression and test it.
        plDataTypeImpl.setExpression(expression);
        assertEquals("The setExpression method is incorrect.", expression,
            plDataTypeImpl.getExpression());

        // set expression to null and test it.
        plDataTypeImpl.setExpression(null);
        assertNull("The setExpression method is incorrect.", plDataTypeImpl.getExpression());
    }
}
