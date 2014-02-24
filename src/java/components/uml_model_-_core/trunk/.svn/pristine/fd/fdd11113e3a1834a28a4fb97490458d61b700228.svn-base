/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;

/**
 * <p>
 * A parameter is an unbound variable that can be changed, passed, or returned. A parameter may include a name, type,
 * and direction of communication. Parameters are used in the specification of operations, messages and events,
 * templates, etc.
 * </p>
 * <p>
 * In the meta model, a Parameter is a declaration of an argument to be passed to, or returned from, an Operation, a
 * Signal, etc.
 * </p>
 * <p>
 * A Parameter has the following properties:
 * <ul>
 * <li>defaultValue: An Expression whose evaluation yields a value to be used when no argument is supplied for the
 * Parameter. </li>
 * <li>kind: Specifies what kind of a Parameter is required. Possibilities are:
 *
 * <pre>
 *      (1) in - An input Parameter (may not be modified).
 *      (2) out - An output Parameter (may be modified to communicate information to the caller).
 *      (3) in/out - An input Parameter that may be modified. (4) return -A return value of a call.
 * </pre>
 *
 * </li>
 * <li>type: Designates a Classifier to which an argument value must conform.</li>
 * <li>behavioralFeature: A BehavioralFeature instance referenced by the Parameter</li>
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
public interface Parameter extends ModelElement {
    /**
     * <p>
     * Sets the default value of the current object.
     * </p>
     *
     * @param defaultValue
     *            the default value to be set for this object.
     */
    public void setDefaultValue(Expression defaultValue);

    /**
     * <p>
     * Gets the default value of the current object.
     * </p>
     *
     * @return the default value of this object
     */
    Expression getDefaultValue();

    /**
     * <p>
     * Sets the kind of the current object.
     * </p>
     *
     * @param kind
     *            the kind to be set for this object.
     */
    void setKind(ParameterDirectionKind kind);

    /**
     * <p>
     * Gets the kind of the current object.
     * </p>
     *
     * @return the kind of this object.
     */
    ParameterDirectionKind getKind();

    /**
     * <p>
     * Sets the type of the current object.
     * </p>
     *
     * @param type
     *            the type to be set for this object.
     */
    void setType(Classifier type);

    /**
     * <p>
     * Gets the type of the current object.
     * </p>
     *
     * @return the type of this object.
     */
    Classifier getType();

    /**
     * <p>
     * Sets the behavioral feature of the current object.
     * </p>
     *
     * @param behavioralFeature
     *            the behavioral feature to be set for this object.
     */
    void setBehavioralFeature(BehavioralFeature behavioralFeature);

    /**
     * <p>
     * Gets the behavioral feature of the current object.
     * </p>
     *
     * @return the behavioral feature of this object.
     */
    BehavioralFeature getBehavioralFeature();
}
