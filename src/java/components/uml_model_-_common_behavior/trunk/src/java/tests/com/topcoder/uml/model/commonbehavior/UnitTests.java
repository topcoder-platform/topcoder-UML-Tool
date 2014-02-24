/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.commonbehavior;

import com.topcoder.uml.model.commonbehavior.HelperTest;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImplTest;
import com.topcoder.uml.model.commonbehavior.instances.InstanceTest;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImplTest;
import com.topcoder.uml.model.commonbehavior.instances.ObjectTest;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImplTest;
import com.topcoder.uml.model.commonbehavior.instances.StimulusTest;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImplTest;
import com.topcoder.uml.model.commonbehavior.links.LinkEndTest;
import com.topcoder.uml.model.commonbehavior.links.LinkImplTest;
import com.topcoder.uml.model.commonbehavior.links.LinkTest;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImplTest;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureTest;

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
     * Gets the suite containing all the tests.
     *
     * @return suite created.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(HelperTest.suite());
        suite.addTest(Demo.suite());
        suite.addTest(HelperTest.suite());
        suite.addTest(InstanceTest.suite());
        suite.addTest(InstanceAbstractImplTest.suite());
        suite.addTest(ObjectTest.suite());
        suite.addTest(ObjectImplTest.suite());
        suite.addTest(StimulusTest.suite());
        suite.addTest(StimulusImplTest.suite());
        suite.addTest(LinkTest.suite());
        suite.addTest(LinkEndTest.suite());
        suite.addTest(LinkEndImplTest.suite());
        suite.addTest(LinkImplTest.suite());
        suite.addTest(ProcedureTest.suite());
        suite.addTest(ProcedureImplTest.suite());

        return suite;
    }
}
