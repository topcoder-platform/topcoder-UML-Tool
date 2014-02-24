/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * <p>
 * A method is the implementation of an operation. It specifies the algorithm or procedure that effects the results of
 * an operation.
 * </p>
 * <p>
 * In the meta model, a Method is a declaration of a named piece of behavior in a Classifier and realizes one (directly)
 * or a set (indirectly) of Operations of the Classifier.
 * </p>
 * <p>
 * There may be at most one method for a particular classifier (as owner of the method) and operation (as specification
 * of the method) pairing.
 * </p>
 * <p>
 * A Method has the following properties:
 * <ul>
 * <li>body: The implementation of the Method as a ProcedureExpression.</li>
 * <li>specification: Designates an Operation that the Method implements. The Operation must be owned by the Classifier
 * that owns the Method or be inherited by it. The signatures of the Operation and Method must match. </li>
 * <li>procedure: A Procedure instance referenced by the Method.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface Method extends BehavioralFeature {
    /**
     * <p>
     * Sets the body of the current object.
     * </p>
     *
     * @param body
     *            the body to be set for this object.
     */
    void setBody(ProcedureExpression body);

    /**
     * <p>
     * Gets the body of the current object.
     * </p>
     *
     * @return the body of this object.
     */
    ProcedureExpression getBody();

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object.
     */
    void setSpecification(Operation specification);

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object.
     */
    Operation getSpecification();

    /**
     * <p>
     * Sets the procedure of the current object.
     * </p>
     *
     * @param procedure
     *            the procedure to be set for this object.
     */
    void setProcedure(Procedure procedure);

    /**
     * <p>
     * Gets the procedure of the current object.
     * </p>
     *
     * @return the procedure of this object.
     */
    Procedure getProcedure();
}
