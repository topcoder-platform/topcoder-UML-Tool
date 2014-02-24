/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.datatypes.expressions.TypeExpression;
import com.topcoder.uml.model.datatypes.expressions.TypeExpressionImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>ProgrammingLanguageDataTypeImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ProgrammingLanguageDataTypeImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private ProgrammingLanguageDataTypeImpl programmingLanguageDataTypeImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ProgrammingLanguageDataTypeImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", ProgrammingLanguageDataTypeImpl.class, "Expression",
                TypeExpression.class, new Object[] {null, new TypeExpressionImpl()}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        programmingLanguageDataTypeImpl = new ProgrammingLanguageDataTypeImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        programmingLanguageDataTypeImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>ProgrammingLanguageDataTypeImpl</code>.
     * <code>ProgrammingLanguageDataTypeImpl</code> should inherit from <code>DataTypeImpl</code>.
     * </p>
     */
    public void testProgrammingLanguageDataTypeImplAccuracyInheritDataTypeImpl() {
        assertTrue("ProgrammingLanguageDataTypeImpl should inherit from DataTypeImpl.",
            programmingLanguageDataTypeImpl instanceof DataTypeImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>ProgrammingLanguageDataTypeImpl</code>.
     * <code>ProgrammingLanguageDataTypeImpl</code> should inherit from <code>ProgrammingLanguageDataType</code>.
     * </p>
     */
    public void testProgrammingLanguageDataTypeImplAccuracyInheritProgrammingLanguageDataType() {
        assertTrue("ProgrammingLanguageDataTypeImpl should inherit from ProgrammingLanguageDataType.",
            programmingLanguageDataTypeImpl instanceof ProgrammingLanguageDataType);
    }

    /**
     * <p>
     * Tests accuracy of <code>ProgrammingLanguageDataTypeImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testProgrammingLanguageDataTypeImplAccuracy() {
        assertNull("Variable should be set correctly.", programmingLanguageDataTypeImpl.getExpression());
    }
}
