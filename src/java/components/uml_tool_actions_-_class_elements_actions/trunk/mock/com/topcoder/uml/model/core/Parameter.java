/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Parameter extends com.topcoder.uml.model.core.ModelElement {
    /**
     * <p>
     * Sets the default value of the current object.
     * </p>
     *
     * @param defaultValue
     *            the default value to be set for this object
     */
    public void setDefaultValue(Expression defaultValue);

    /**
     * <p>
     * Gets the default value of the current object.
     * </p>
     *
     * @return the default value of this object
     */
    public Expression getDefaultValue();

    /**
     * <p>
     * Sets the kind of the current object.
     * </p>
     *
     * @param kind
     *            the kind to be set for this object
     */
    public void setKind(ParameterDirectionKind kind);

    /**
     * <p>
     * Gets the kind of the current object.
     * </p>
     *
     * @return the kind of this object
     */
    public ParameterDirectionKind getKind();

    /**
     * <p>
     * Sets the type of the current object.
     * </p>
     *
     * @param type
     *            the type to be set for this object
     */
    public void setType(Classifier type);

    /**
     * <p>
     * Gets the type of the current object.
     * </p>
     *
     * @poseidon-object-id [I6a868a04m10e5cf1ec66mm6f88]
     * @return the type of this object
     */
    public Classifier getType();

    /**
     * <p>
     * Sets the behavioral feature of the current object.
     * </p>
     *
     * @param behavioralFeature
     *            the behavioral feature to be set for this object
     */
    public void setBehavioralFeature(BehavioralFeature behavioralFeature);

    /**
     * <p>
     * Gets the behavioral feature of the current object.
     * </p>
     *
     * @return the behavioral feature of this object
     */
    public BehavioralFeature getBehavioralFeature();
}