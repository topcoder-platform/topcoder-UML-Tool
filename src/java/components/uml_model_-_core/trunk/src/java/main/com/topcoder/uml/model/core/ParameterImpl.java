/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;

/**
 * <p>
 * This class is a default implementation of the <code>Parameter</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that
 * are set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously
 * be <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
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
public class ParameterImpl extends ModelElementAbstractImpl implements Parameter {

    /**
     * <p>
     * An Expression whose evaluation yields a value to be used when no argument is supplied for the Parameter.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Expression defaultValue;

    /**
     * <p>
     * Specifies what kind of a Parameter is required.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private ParameterDirectionKind kind;

    /**
     * <p>
     * Designates a Classifier to which an argument value must conform.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Classifier type;

    /**
     * <p>
     * A BehavioralFeature instance referenced by the Parameter.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private BehavioralFeature behavioralFeature;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    public ParameterImpl() {
    }

    /**
     * <p>
     * Sets the default value of the current object.
     * </p>
     *
     * @param defaultValue
     *            the default value to be set for this object.
     */
    public void setDefaultValue(Expression defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * <p>
     * Gets the default value of the current object.
     * </p>
     *
     * @return the default value of this object.
     */
    public Expression getDefaultValue() {
        return defaultValue;
    }

    /**
     * <p>
     * Sets the kind of the current object.
     * </p>
     *
     * @param kind
     *            the kind to be set for this object.
     */
    public void setKind(ParameterDirectionKind kind) {
        this.kind = kind;
    }

    /**
     * <p>
     * Gets the kind of the current object.
     * </p>
     *
     * @return the kind of this object.
     */
    public ParameterDirectionKind getKind() {
        return kind;
    }

    /**
     * <p>
     * Sets the type of the current object.
     * </p>
     *
     * @param type
     *            the type to be set for this object.
     */
    public void setType(Classifier type) {
        this.type = type;
    }

    /**
     * <p>
     * Gets the type of the current object.
     * </p>
     *
     * @return the type of this object.
     */
    public Classifier getType() {
        return type;
    }

    /**
     * <p>
     * Sets the behavioral feature of the current object.
     * </p>
     *
     * @param behavioralFeature
     *            the behavioral feature to be set for this object.
     */
    public void setBehavioralFeature(BehavioralFeature behavioralFeature) {
        this.behavioralFeature = behavioralFeature;
    }

    /**
     * <p>
     * Gets the behavioral feature of the current object.
     * </p>
     *
     * @return the behavioral feature of this object.
     */
    public BehavioralFeature getBehavioralFeature() {
        return behavioralFeature;
    }

    /**
     * Forcing two way association.
     *
     * @param parameter
     * @param type
     */
    public static void setType(Parameter parameter, Classifier type) {
        // forcing two way associations
        if (parameter.getType() != null) {
            parameter.getType().removeTypedParameter(parameter);
        }
        parameter.setType(type);
        if (type != null) {
            if (!type.containsTypedParameter(parameter)) {
                type.addTypedParameter(parameter);
            }
        }
    }

    /**
     * Forcing two way association.
     *
     * @param parameter
     * @param type
     */
    public static void setBehavioralFeature(Parameter parameter, BehavioralFeature behavioralFeature) {
        if (parameter.getBehavioralFeature() != null) {
            parameter.getBehavioralFeature().removeParameter(parameter);
        }
        parameter.setBehavioralFeature(behavioralFeature);
        if (behavioralFeature != null) {
            if (!behavioralFeature.containsParameter(parameter)) {
                behavioralFeature.addParameter(parameter);
            }
        }
    }
}
