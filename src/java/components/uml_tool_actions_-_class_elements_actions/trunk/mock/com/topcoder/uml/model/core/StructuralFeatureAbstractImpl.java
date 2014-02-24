/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class StructuralFeatureAbstractImpl extends FeatureAbstractImpl implements StructuralFeature {

    /**
     * The possible number of data values for the feature that may be held by an
     * instance. This attribute is initially left set to null; after
     * construction, it can be set to any value (null included) through the
     * appropriate setter.
     */
    private Multiplicity multiplicity;

    /**
     * Whether the value may be modified after the object is initialized. This
     * attribute is initially left set to null; after construction, it can be
     * set to any value (null included) through the appropriate setter.
     */
    private ChangeableKind changeability;

    /**
     * Specifies whether the targets are ordinary Instances or Classifiers. This
     * attribute is initially left set to null; after construction, it can be
     * set to any value (null included) through the appropriate setter.
     */
    private ScopeKind targetScope;

    /**
     * Designates the classifier whose instances are values of the feature. This
     * attribute is initially left set to null; after construction, it can be
     * set to any value (null included) through the appropriate setter.
     */
    private Classifier type;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected StructuralFeatureAbstractImpl() {
    }

    /**
     * <p>
     * Sets the multiplicity of the current object.
     * </p>
     *
     * @param multiplicity
     *            the multiplicity to be set for this object
     */
    public void setMultiplicity(Multiplicity multiplicity) {
    }

    /**
     * <p>
     * Gets the multiplicity of the current object.
     * </p>
     *
     * @return the multiplicity of this object
     */
    public Multiplicity getMultiplicity() {
        return null;
    }

    /**
     * <p>
     * Sets the changeability of the current object.
     * </p>
     *
     * @param changeability
     *            the changeability to be set for this object
     */
    public void setChangeability(ChangeableKind changeability) {
    }

    /**
     * <p>
     * Gets the changeability of the current object.
     * </p>
     *
     * @return the changeability of this object
     */
    public ChangeableKind getChangeability() {
        return null;
    }

    /**
     * <p>
     * Sets the target scope of the current object.
     * </p>
     *
     * @param targetScope
     *            the target scope to be set for this object
     */
    public void setTargetScope(ScopeKind targetScope) {
    }

    /**
     * <p>
     * Gets the target scope of the current object.
     * </p>
     *
     * @return the target scope of this object
     */
    public ScopeKind getTargetScope() {
        return null;
    }

    /**
     * <p>
     * Sets the type of the current object.
     * </p>
     *
     * @param type
     *            the type to be set for this object
     */
    public void setType(Classifier type) {
    }

    /**
     * <p>
     * Gets the type of the current object.
     * </p>
     *
     * @return the type of this object
     */
    public Classifier getType() {
        return null;
    }
}