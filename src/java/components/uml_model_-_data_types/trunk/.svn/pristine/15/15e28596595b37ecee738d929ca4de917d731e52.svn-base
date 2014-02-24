/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImplTest;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionTest;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImplTest;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImplTest;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionTest;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImplTest;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionTest;
import com.topcoder.uml.model.datatypes.expressions.TypeExpressionImplTest;
import com.topcoder.uml.model.datatypes.expressions.TypeExpressionTest;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // data types
        suite.addTestSuite(AggregationKindTest.class);
        suite.addTestSuite(CallConcurrencyKindTest.class);
        suite.addTestSuite(ChangeableKindTest.class);
        suite.addTestSuite(HelperTest.class);
        suite.addTestSuite(MultiplicityImplTest.class);
        suite.addTestSuite(MultiplicityRangeImplTest.class);
        suite.addTestSuite(OrderingKindTest.class);
        suite.addTestSuite(ParameterDirectionKindTest.class);
        suite.addTestSuite(PseudostateKindTest.class);
        suite.addTestSuite(ScopeKindTest.class);
        suite.addTestSuite(VisibilityKindTest.class);

        // expressions test
        suite.addTestSuite(BooleanExpressionImplTest.class);
        suite.addTestSuite(BooleanExpressionTest.class);
        suite.addTestSuite(ExpressionImplTest.class);
        suite.addTestSuite(MappingExpressionImplTest.class);
        suite.addTestSuite(MappingExpressionTest.class);
        suite.addTestSuite(ProcedureExpressionImplTest.class);
        suite.addTestSuite(ProcedureExpressionTest.class);
        suite.addTestSuite(TypeExpressionImplTest.class);
        suite.addTestSuite(TypeExpressionTest.class);

        // demo
        suite.addTestSuite(Demo.class);

        return suite;
    }

}
