/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * <p>
 * This abstract class is a default implementation of the <code>StructuralFeature</code> interface.
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
public abstract class StructuralFeatureAbstractImpl extends FeatureAbstractImpl implements StructuralFeature {

    /**
     * <p>
     * The possible number of data values for the feature that may be held by an instance.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Multiplicity multiplicity;

    /**
     * <p>
     * Whether the value may be modified after the object is initialized.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private ChangeableKind changeability;

    /**
     * <p>
     * Specifies whether the targets are ordinary Instances or Classifiers.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * <p>
     */
    private ScopeKind targetScope;

    /**
     * <p>
     * Designates the classifier whose instances are values of the feature.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
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
     *            the multiplicity to be set for this object.
     */
    public void setMultiplicity(Multiplicity multiplicity) {
        this.multiplicity = multiplicity;
    }

    /**
     * <p>
     * Gets the multiplicity of the current object.
     * </p>
     *
     * @return the multiplicity of this object.
     */
    public Multiplicity getMultiplicity() {
        return multiplicity;
    }

    /**
     * <p>
     * Sets the changeability of the current object.
     * </p>
     *
     * @param changeability
     *            the changeability to be set for this object.
     */
    public void setChangeability(ChangeableKind changeability) {
        this.changeability = changeability;
    }

    /**
     * <p>
     * Gets the changeability of the current object.
     * </p>
     *
     * @return the changeability of this object.
     */
    public ChangeableKind getChangeability() {
        return changeability;
    }

    /**
     * <p>
     * Sets the target scope of the current object.
     * </p>
     *
     * @param targetScope
     *            the target scope to be set for this object.
     */
    public void setTargetScope(ScopeKind targetScope) {
        this.targetScope = targetScope;
    }

    /**
     * <p>
     * Gets the target scope of the current object.
     * </p>
     *
     * @return the target scope of this object.
     */
    public ScopeKind getTargetScope() {
        return targetScope;
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
     * Forcing two way association.
     *
     * @param structuralFeature
     * @param type
     */
    public static void setType(StructuralFeature structuralFeature, Classifier type) {
        // forcing two way associations
        if (structuralFeature.getType() != null) {
            structuralFeature.getType().removeTypedFeature(structuralFeature);
        }
        structuralFeature.setType(type);
        if (type != null) {
            if (!type.containsTypedFeature(structuralFeature)) {
                type.addTypedFeature(structuralFeature);
            }
        }
    }
}
