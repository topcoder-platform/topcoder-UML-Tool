/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ ActionAbstractImplAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.ActionAbstractImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>ActionAbstractImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>ActionAbstractImpl</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ActionAbstractImplAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>ActionAbstractImpl</code> used for tests.
     * </p>
     */
    private ActionAbstractImpl test = null;

    /**
     * <p>
     * The instance of <code>Procedure</code> used for tests.
     * </p>
     */
    private Procedure procedure = null;

    /**
     * <p>
     * Test suite of <code>ActionAbstractImplAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ActionAbstractImplAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ActionAbstractImplAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>Procedure</code>
     * and <code>ActionAbstractImpl</code>.
     * </p>
     */
    protected void setUp() {
        test = new MockActionImpl();
        procedure = new ProcedureImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>ActionAbstractImpl()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new MockActionImpl());

        // get the original value of procedure to check the constructor
        assertNull("The procedure expected to be null", test.getProcedure());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getProcedure()</code> method and
     * <code>setProcedure(Procedure)</code>.
     * </p>
     */
    public void testProcedure_Operation() {
        // get the original value of procedure.
        assertNull("The procedure expected to be null", test.getProcedure());

        // set the procedure.
        test.setProcedure(procedure);

        // get the procedure to check it's value.
        assertSame("The two procedures expected to be same", procedure,
            test.getProcedure());
    }

    /**
     * <p>
     * Accuracy Test of the <code>ActionAbstractImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship() {
        // test class inheritance.
        assertTrue("This class should extend from ModelElementAbstractImpl",
            test instanceof ModelElementAbstractImpl);

        // test class interface.
        assertTrue("This class should implement Action interface",
            test instanceof Action);
    }

    /**
     * <p>
     * A inner class which extends the <code>ActionAbstractImpl</code> class, used for
     * accuracy test only.
     * </p>
     */
    class MockActionImpl extends ActionAbstractImpl {
        // use default constructor.
    }
}
