/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.failuretests;

import com.topcoder.uml.stubclassgenerator.CodeWriterFailureTest;
import com.topcoder.uml.stubclassgenerator.GeneratorFactoryFailureTest;
import com.topcoder.uml.stubclassgenerator.failuretests.csharp.CSharpGeneratorFailureTest;
import com.topcoder.uml.stubclassgenerator.failuretests.java.JavaGeneratorFailureTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all failure test cases.
 *
 * @author vividmxx
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Aggregates all failure test cases.
     *
     * @return the aggregated failure test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(CodeWriterFailureTest.class);
        suite.addTestSuite(GeneratorFactoryFailureTest.class);
        suite.addTestSuite(AbstractGeneratorFailureTest.class);
        suite.addTestSuite(CSharpGeneratorFailureTest.class);
        suite.addTestSuite(JavaGeneratorFailureTest.class);
        suite.addTestSuite(CodeGeneratorFailureTest.class);
        return suite;
    }

}
