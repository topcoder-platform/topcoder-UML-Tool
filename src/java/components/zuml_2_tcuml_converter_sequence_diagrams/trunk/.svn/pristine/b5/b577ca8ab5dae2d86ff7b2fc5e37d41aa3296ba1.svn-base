/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.EventOccurrenceImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.HelperUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImplUnitTest;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImplUnitTest;

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
     * <p>Return the unit test cases.</p>
     * @return the unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(XMISequenceDiagramConverterUtilUnitTest.suite());
        suite.addTest(Demo.suite());

        suite.addTest(EventOccurrenceImplUnitTest.suite());
        suite.addTest(HelperUnitTest.suite());
        suite.addTest(InteractionImplUnitTest.suite());
        suite.addTest(LifelineImplUnitTest.suite());
        suite.addTest(MessageImplUnitTest.suite());

        return suite;
    }
}
