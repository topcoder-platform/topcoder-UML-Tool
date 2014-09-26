/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * <p>
 * This class is a default implementation of the <code>Method</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that are
 * set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously be
 * <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
 * <code>null</code> references while they can contain duplicate entries.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread-safe, since thread safety should be handled by the application
 * itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public class MethodImpl extends BehavioralFeatureAbstractImpl implements Method {
    /**
     * <p>
     * The implementation of the Method as a ProcedureExpression.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private ProcedureExpression body;

    /**
     * <p>
     * Designates an Operation that the Method implements.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Operation specification;

    /**
     * <p>
     * A Procedure instance referenced by the Method.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
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
     *            the body to be set for this object.
     */
    public void setBody(ProcedureExpression body) {
        this.body = body;
    }

    /**
     * <p>
     * Gets the body of the current object.
     * </p>
     *
     * @return the body of this object.
     */
    public ProcedureExpression getBody() {
        return body;
    }

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object.
     */
    public void setSpecification(Operation specification) {
        this.specification = specification;
    }

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object.
     */
    public Operation getSpecification() {
        return specification;
    }

    /**
     * <p>
     * Sets the procedure of the current object.
     * </p>
     *
     * @param procedure
     *            the procedure to be set for this object.
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    /**
     * <p>
     * Gets the procedure of the current object.
     * </p>
     *
     * @return the procedure of this object.
     */
    public Procedure getProcedure() {
        return procedure;
    }
}
