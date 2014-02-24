/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.procedure;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Procedure</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ProcedureTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ProcedureTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Procedure</code>.
     * <code>Procedure</code> should inherit from <code>ModelElement</code>.
     * </p>
     */
    public void testProcedureAccuracyInheritModelElement() {
        assertTrue("Procedure should inherit from ModelElement",
            Procedure.class.getInterfaces()[0].equals(ModelElement.class));
    }
}
