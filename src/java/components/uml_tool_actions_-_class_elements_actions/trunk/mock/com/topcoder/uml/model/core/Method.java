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
public interface Method extends BehavioralFeature {
    /**
     * <p>
     * Sets the body of the current object.
     * </p>
     *
     * @param body
     *            the body to be set for this object
     */
    public void setBody(ProcedureExpression body);

    /**
     * <p>
     * Gets the body of the current object.
     * </p>
     *
     * @return the body of this object
     */
    public ProcedureExpression getBody();

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object
     */
    public void setSpecification(Operation specification);

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object
     */
    public Operation getSpecification();

    /**
     * <p>
     * Sets the procedure of the current object.
     * </p>
     *
     * @param procedure
     *            the procedure to be set for this object
     */
    public void setProcedure(Procedure procedure);

    /**
     * <p>
     * Gets the procedure of the current object.
     * </p>
     *
     * @return the procedure of this object
     */
    public Procedure getProcedure();
}