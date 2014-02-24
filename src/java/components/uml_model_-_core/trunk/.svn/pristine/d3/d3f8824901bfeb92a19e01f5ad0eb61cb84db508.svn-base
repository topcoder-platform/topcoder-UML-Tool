/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImpl;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>MethodImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class MethodImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>MethodImpl</code> instance used for testing. */
    private MethodImpl method;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the MethodImpl instance
        method = new MethodImpl();
    }

    /**
     * Accuracy test of method <code>setBody(ProcedureExpression)</code> and <code>getBody()</code>.
     */
    public void testBodySetterAndGetter() {
        //initial value is null
        assertNull(method.getBody());
        //set the Body with specified ProcedureExpression
        method.setBody(new ProcedureExpressionImpl());
        assertNotNull(method.getBody());
        //set the Body with null
        method.setBody(null);
        assertNull(method.getBody());
    }

    /**
     * Accuracy test of method <code>setSpecification(Operation)</code> and <code>getSpecification()</code>.
     */
    public void testSpecificationSetterAndGetter() {
        //initial value is null
        assertNull(method.getSpecification());
        //set the Specification with specified Operation
        method.setSpecification(new OperationImpl());
        assertNotNull(method.getSpecification());
        //set the Specification with null
        method.setSpecification(null);
        assertNull(method.getSpecification());
    }

    /**
     * Accuracy test of method <code>setProcedure(Procedure)</code> and <code>getProcedure()</code>.
     */
    public void testProcedureSetterAndGetter() {
        //initial value is null
        assertNull(method.getProcedure());
        //set the Procedure with specified Procedure
        method.setProcedure(new ProcedureImpl());
        assertNotNull(method.getProcedure());
        //set the Procedure with null
        method.setProcedure(null);
        assertNull(method.getProcedure());
    }
}
