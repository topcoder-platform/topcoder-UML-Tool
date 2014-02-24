/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.core.classifiers;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(HelperTest.suite());
        suite.addTest(Demo.suite());
        suite.addTest(ClassTest.suite());
        suite.addTest(ClassImplTest.suite());
        suite.addTest(DataTypeTest.suite());
        suite.addTest(DataTypeImplTest.suite());
        suite.addTest(EnumerationTest.suite());
        suite.addTest(EnumerationImplTest.suite());
        suite.addTest(EnumerationLiteralTest.suite());
        suite.addTest(EnumerationLiteralImplTest.suite());
        suite.addTest(InterfaceTest.suite());
        suite.addTest(InterfaceImplTest.suite());
        suite.addTest(PrimitiveTest.suite());
        suite.addTest(PrimitiveImplTest.suite());
        suite.addTest(ProgrammingLanguageDataTypeTest.suite());
        suite.addTest(ProgrammingLanguageDataTypeImplTest.suite());

        return suite;
    }

}
