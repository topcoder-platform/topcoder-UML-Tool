/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityDiagramUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityEdgeUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityNodeUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLOpaqueExpressionUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.HelperUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLAcceptEventActionImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityFinalNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLCallActionImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLDecisionNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLExceptionHandlerImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLForkNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLJoinNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLMergeNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLSendSignalActionImplUnitTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>Returns the suite of all unit test cases.</p>
     *
     * @return the suite of all unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(ActivityDiagramConversionFacadeUnitTest.suite());
        suite.addTest(Demo.suite());
        suite.addTest(AbstractZUMLActivityDiagramUnitTest.suite());
        suite.addTest(AbstractZUMLActivityEdgeUnitTest.suite());
        suite.addTest(AbstractZUMLActivityNodeUnitTest.suite());
        suite.addTest(AbstractZUMLOpaqueExpressionUnitTest.suite());
        suite.addTest(HelperUnitTest.suite());
        suite.addTest(ZUMLAcceptEventActionImplUnitTest.suite());
        suite.addTest(ZUMLActivityDiagramImplUnitTest.suite());
        suite.addTest(ZUMLActivityEdgeImplUnitTest.suite());
        suite.addTest(ZUMLActivityFinalNodeImplUnitTest.suite());
        suite.addTest(ZUMLCallActionImplUnitTest.suite());
        suite.addTest(ZUMLDecisionNodeImplUnitTest.suite());
        suite.addTest(ZUMLExceptionHandlerImplUnitTest.suite());
        suite.addTest(ZUMLFlowFinalNodeImplUnitTest.suite());
        suite.addTest(ZUMLForkNodeImplUnitTest.suite());
        suite.addTest(ZUMLInitialNodeImplUnitTest.suite());
        suite.addTest(ZUMLJoinNodeImplUnitTest.suite());
        suite.addTest(ZUMLMergeNodeImplUnitTest.suite());
        suite.addTest(ZUMLOpaqueExpressionImplUnitTest.suite());
        suite.addTest(ZUMLPinNodeImplUnitTest.suite());
        suite.addTest(ZUMLSendSignalActionImplUnitTest.suite());

        return suite;
    }
}
