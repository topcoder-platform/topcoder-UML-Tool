/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class MethodImpl extends BehavioralFeatureAbstractImpl implements Method {

    /**
     * The implementation of the Method as a ProcedureExpression. This attribute
     * is initially left set to null; after construction, it can be set to any
     * value (null included) through the appropriate setter.
     */
    private ProcedureExpression body;

    /**
     * Designates an Operation that the Method implements. This attribute is
     * initially left set to null; after construction, it can be set to any
     * value (null included) through the appropriate setter.
     */
    private Operation specification;

    /**
     * A Procedure instance referenced by the Method. This attribute is
     * initially left set to null; after construction, it can be set to any
     * value (null included) through the appropriate setter.
     */
    private Procedure procedure;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    public MethodImpl() {
    }

    /**
     * <p>
     * Sets the body of the current object.
     * </p>
     *
     * @param body
     *            the body to be set for this object
     */
    public void setBody(ProcedureExpression body) {
    }

    /**
     * <p>
     * Gets the body of the current object.
     * </p>
     *
     * @return the body of this object
     */
    public ProcedureExpression getBody() {
        return null;
    }

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object
     */
    public void setSpecification(Operation specification) {
    }

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object
     */
    public Operation getSpecification() {
        return null;
    }

    /**
     * <p>
     * Sets the procedure of the current object.
     * </p>
     *
     * @param procedure
     *            the procedure to be set for this object
     */
    public void setProcedure(Procedure procedure) {
    }

    /**
     * <p>
     * Gets the procedure of the current object.
     * </p>
     *
     * @return the procedure of this object
     */
    public Procedure getProcedure() {
        return null;
    }
}