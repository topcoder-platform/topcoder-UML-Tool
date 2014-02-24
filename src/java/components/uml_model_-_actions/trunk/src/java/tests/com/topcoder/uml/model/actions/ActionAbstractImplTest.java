/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * This class tests the <code>ActionAbstractImpl</code> class.
 * It addresses the functionality provided by the<code>ActionAbstractImpl</code> class.
 * It tests the methods: ActionAbstractImpl(), getProcedure(), setProcedure(Procedure).
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActionAbstractImplTest extends TestCase {
    /**
     * <p>
     * The instance of <code>ActionAbstractImpl</code> for test.
     * </p>
     */
    private ActionAbstractImpl test = null;

    /**
     * <p>
     * The instance of <code>Procedure</code> for test.
     * </p>
     */
    private Procedure procedure = null;

    /**
     * <p>
     * Test suite of <code>ActionAbstractImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>ActionAbstractImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ActionAbstractImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    protected void setUp() {
        test = new MockActionAbstractImpl();
        procedure = new ProcedureImpl();
    }

    /**
     * <p>
     * Basic test of <code>ActionAbstractImpl()</code> Constructor.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     *
     * @see #MockActionAbstractImpl()
     */
    public void testActionAbstractImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>ActionAbstractImpl()</code> Constructor.
     * It creates the instance of <code>MockActionAbstractImpl</code> for several times,
     * like a stress test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     *
     * @see #MockActionAbstractImpl()
     */
    public void testActionAbstractImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new MockActionAbstractImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>ActionAbstractImpl()</code> Constructor.
     * We get the attribute : procedure for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     *
     * @see #MockActionAbstractImpl()
     */
    public void testActionAbstractImplCtor_Detail() {
        assertNotNull("Create failed.", test);
        assertNull("The procedure should be null", test.getProcedure());
    }

    /**
     * <p>
     * Basic test of <code>getProcedure()</code> method.
     * It gets the procedure for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testgetProcedure_Basic() {
        assertNull("The procedure should be null", test.getProcedure());
    }

    /**
     * <p>
     * Basic test of <code>getProcedure()</code> method.
     * It creates the instance of <code>MockActionAbstractImpl</code> for several times,
     * then gets the procedure for test, like a stress test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testgetProcedure_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            ActionAbstractImpl action = new MockActionAbstractImpl();
            assertNull("The procedure should be null", action.getProcedure());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>getProcedure()</code> method.
     * It sets the procedure and then gets it for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testgetProcedure_Detail() {
        // set the procedure to the test.
        test.setProcedure(procedure);
        // equal value expected.
        assertEquals("The two procedures should be equal", procedure, test.getProcedure());
    }

    /**
     * <p>
     * Accuracy test of <code>getProcedure()</code> method.
     * It sets the procedure with <code>null</code>
     * and then gets it for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testgetProcedure_Detail_Null() {
        // set the procedure with null.
        test.setProcedure(null);
        // the procedure should be null.
        assertNull("The procedure should be null", test.getProcedure());
    }

    /**
     * <p>
     * Basic test of <code>setProcedure(Procedure)</code> method.
     * It sets the procedure and then gets it for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testsetProcedure_Basic() {
        assertNull("The procedure should be null", test.getProcedure());
        // set the procedure to the test.
        test.setProcedure(procedure);
        // equal value expected.
        assertEquals("The two procedures should be equal", procedure, test.getProcedure());
    }

    /**
     * <p>
     * Accuracy test of <code>setProcedure(Procedure)</code> method.
     * It creates the instance of <code>MockActionAbstractImpl</code> for several times,
     * then sets the procedure and gets it for test, like a stress test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testsetProcedure_Detail() {
        for (int i = 0; i < 3; i++) {
            ActionAbstractImpl action = new MockActionAbstractImpl();
             // set the procedure to the action.
            action.setProcedure(procedure);
            // equal value expected.
            assertEquals("The two procedures should be equal", procedure, action.getProcedure());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>setProcedure(Procedure)</code> method.
     * It sets the procedure with <code>null</code>
     * and then gets it for test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testsetProcedure_Detail_Null() {
        ActionAbstractImpl action = new MockActionAbstractImpl();
        // set the procedure to the action.
        action.setProcedure(null);
        // the procedure should be null.
        assertNull("The procedure should be null", action.getProcedure());
    }

    /**
     * <p>
     * Accuracy test of <code>ActionAbstractImpl</code> class, the class should be
     * a subclass of <code>ModelElementAbstractImpl</code>.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("ActionAbstractImpl class should be a subclass of ModelElementAbstractImpl",
            test instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>ActionAbstractImpl</code> class, the class should
     * implement <code>Action</code> interface.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ActionAbstractImpl</code> class is abstract, we use
     * <code>MockActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("ActionAbstractImpl class should implement Action interface",
            test instanceof Action);
    }
}