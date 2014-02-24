/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.procedure;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.commonbehavior.CollectionVariableTest;
import com.topcoder.uml.model.commonbehavior.ValueVariableTest;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>ProcedureImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ProcedureImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private ProcedureImpl procedureImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(ProcedureImplTest.class);
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "List", boolean.class,
                new Object[] {false, true}).getSuite());
        suite.addTest(new CollectionVariableTest("dummy", ProcedureImpl.class, "Stimulus", "Stimuli", Stimulus.class,
                StimulusImpl.class).getSuite());
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "Action", Action.class,
                new Object[] {null, new SendSignalActionImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "Expression", Expression.class,
                new Object[] {null, new ExpressionImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "Language", String.class,
                new Object[] {"", " ", "\t\n", "abc"}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "Method", Method.class,
                new Object[] {null, new MethodImpl()}).getSuite());
        suite.addTest(new ValueVariableTest("dummy", ProcedureImpl.class, "Body", String.class,
                new Object[] {"", " ", "\t\n", "abc"}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        procedureImpl = new ProcedureImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        procedureImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>ProcedureImpl</code>.
     * <code>ProcedureImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testProcedureImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("ProcedureImpl should inherit from ModelElementAbstractImpl.",
            procedureImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>ProcedureImpl</code>.
     * <code>ProcedureImpl</code> should inherit from <code>Procedure</code>.
     * </p>
     */
    public void testProcedureImplAccuracyInheritProcedure() {
        assertTrue("ProcedureImpl should inherit from Procedure.", procedureImpl instanceof Procedure);
    }

    /**
     * <p>
     * Tests accuracy of <code>ProcedureImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testProcedureImplAccuracy() {
        assertFalse("Variable should be set correctly.", procedureImpl.isList());
        assertEquals("Variable should be set correctly.", 0, procedureImpl.getStimuli().size());
        assertNull("Variable should be set correctly.", procedureImpl.getAction());
        assertNull("Variable should be set correctly.", procedureImpl.getExpression());
        assertNull("Variable should be set correctly.", procedureImpl.getLanguage());
        assertNull("Variable should be set correctly.", procedureImpl.getMethod());
        assertNull("Variable should be set correctly.", procedureImpl.getBody());
    }
}
