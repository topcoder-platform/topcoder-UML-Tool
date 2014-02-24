/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.core.auxiliaryelements;


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
        suite.addTest(CommentTest.suite());
        suite.addTest(CommentImplTest.suite());
        suite.addTest(HelperTest.suite());
        suite.addTest(TemplateArgumentTest.suite());
        suite.addTest(TemplateArgumentImplTest.suite());
        suite.addTest(TemplateParameterTest.suite());
        suite.addTest(TemplateParameterImplTest.suite());

        return suite;
    }

}
