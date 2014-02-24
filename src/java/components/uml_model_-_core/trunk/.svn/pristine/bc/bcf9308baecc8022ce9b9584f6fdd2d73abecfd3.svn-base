/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>MethodImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class MethodImplUnitTests extends TestCase {
    /**
     * <p>
     * Represents the <code>MethodImpl</code> instance used for tests.
     * </p>
     */
    private MethodImpl testMethodImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testMethodImpl = new MethodImpl();
    }

    /**
     * <p>
     * Test the <code>MethodImpl()</code> constructor. MethodImpl instance should be created.
     * </p>
     */
    public void testMethodImplConstructor() {
        assertNotNull("Create MethodImpl object incorrectly.", new MethodImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setBody(ProcedureExpression)</code>, the <code>Body</code> field
     * should be set.
     * </p>
     */
    public void testSetBody() {
        ProcedureExpression body = new ProcedureExpressionImpl();
        testMethodImpl.setBody(body);
        assertEquals("The Body field should be set.", body, testMethodImpl.getBody());

        testMethodImpl.setBody(null);
        assertNull("The Body field should be null.", testMethodImpl.getBody());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getBody()</code>, the <code>Body</code> field should be returned.
     * </p>
     */
    public void testGetBody() {
        ProcedureExpression body = new ProcedureExpressionImpl();
        testMethodImpl.setBody(body);
        assertEquals("The Body field should be get.", body, testMethodImpl.getBody());

        testMethodImpl.setBody(null);
        assertNull("The Body field should be null.", testMethodImpl.getBody());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setSpecification(Operation)</code>, the <code>Specification</code>
     * field should be set.
     * </p>
     */
    public void testSetSpecification() {
        Operation specification = new OperationImpl();
        testMethodImpl.setSpecification(specification);
        assertEquals("The Specification field should be set.", specification, testMethodImpl.getSpecification());

        testMethodImpl.setSpecification(null);
        assertNull("The Specification field should be null.", testMethodImpl.getSpecification());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getSpecification()</code>, the <code>Specification</code> field should
     * be returned.
     * </p>
     */
    public void testGetSpecification() {
        Operation specification = new OperationImpl();
        testMethodImpl.setSpecification(specification);
        assertEquals("The Specification field should be get.", specification, testMethodImpl.getSpecification());

        testMethodImpl.setSpecification(null);
        assertNull("The Specification field should be null.", testMethodImpl.getSpecification());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setProcedure(Procedure)</code>, the <code>Procedure</code> field
     * should be set.
     * </p>
     */
    public void testSetProcedure() {
        Procedure procedure = new ProcedureImpl();
        testMethodImpl.setProcedure(procedure);
        assertEquals("The Procedure field should be set.", procedure, testMethodImpl.getProcedure());

        testMethodImpl.setProcedure(null);
        assertNull("The Procedure field should be null.", testMethodImpl.getProcedure());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getProcedure()</code>, the <code>Procedure</code> field should be
     * returned.
     * </p>
     */
    public void testGetProcedure() {
        Procedure procedure = new ProcedureImpl();
        testMethodImpl.setProcedure(procedure);
        assertEquals("The Procedure field should be get.", procedure, testMethodImpl.getProcedure());

        testMethodImpl.setProcedure(null);
        assertNull("The Procedure field should be null.", testMethodImpl.getProcedure());
    }
}
