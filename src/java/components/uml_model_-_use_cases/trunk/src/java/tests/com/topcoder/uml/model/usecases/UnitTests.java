/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

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

    /**
     * <p>
     * Aggregats all the unit tests.
     * </p>
     *
     * @return the aggregated unit tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.uml.model.usecases
        suite.addTest(ExtendImplTests.suite());
        suite.addTest(IncludeImplTests.suite());
        suite.addTest(ActorImplTests.suite());
        suite.addTest(UseCaseUtilTests.suite());
        suite.addTest(UseCaseRelationshipAbstractImplTests.suite());
        suite.addTest(UseCaseImplTests.suite());

        suite.addTest(Demo.suite());

        return suite;
    }

}
