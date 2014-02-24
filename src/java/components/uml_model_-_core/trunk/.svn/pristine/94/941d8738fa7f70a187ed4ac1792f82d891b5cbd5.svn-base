/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;

/**
 * <p>
 * A structural feature refers to a static feature of a model element, such as an attribute. In the meta model, a
 * StructuralFeature declares a structural aspect of an Instance of a Classifier, such as an Attribute. For example, it
 * specifies the multiplicity and changeability of the StructuralFeature. StructuralFeature is an abstract meta class.
 * </p>
 * <p>
 * A StructuralFeature has the following properties:
 * <ul>
 * <li> changeability: Whether the value may be modified after the object is initialized. Possibilities are:
 *
 * <pre>
 *   (1) changeable - No restrictions on modification.
 *   (2) frozen - No values may be added or removed after the object is initialized.
 *   (3) addOnly - Values may be added any time. No values may be removed after the object is initialized.
 * </pre>
 *
 * </li>
 * <li> multiplicity: The possible number of data values for the feature that may be held by an instance. The
 * cardinality of the set of values is an implicit part of the feature. In the common case in which the multiplicity is
 * 1..1, then the feature is a scalar (i.e., it holds exactly one value). </li>
 * <li> targetScope: Specifies whether the targets are ordinary Instances or Classifiers. Possibilities are:
 *
 * <pre>
 *   (1) instance - Each value contains a reference to an Instance of the target Classifier.
 *       This is the setting for a normal Attribute.
 *   (2) classifier - Each value contains a reference to the target Classifier itself.
 *       This represents a way to store meta-information.
 * </pre>
 *
 * </li>
 * <li>type: Designates the classifier whose instances are values of the feature. Must be a Class, Interface, or
 * DataType. The actual type may be a descendant of the declared type or (for an Interface) a Class that realizes the
 * declared type. </li>
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
public interface StructuralFeature extends Feature {
    /**
     * <p>
     * Sets the multiplicity of the current object.
     * </p>
     *
     * @param multiplicity
     *            the multiplicity to be set for this object.
     */
    void setMultiplicity(Multiplicity multiplicity);

    /**
     * <p>
     * Gets the multiplicity of the current object.
     * </p>
     *
     * @return the multiplicity of this object.
     */
    Multiplicity getMultiplicity();

    /**
     * <p>
     * Sets the changeability of the current object.
     * </p>
     *
     * @param changeability
     *            the changeability to be set for this object.
     */
    void setChangeability(ChangeableKind changeability);

    /**
     * <p>
     * Gets the changeability of the current object.
     * </p>
     *
     * @return the changeability of this object.
     */
    ChangeableKind getChangeability();

    /**
     * <p>
     * Sets the target scope of the current object.
     * </p>
     *
     * @param targetScope
     *            the target scope to be set for this object.
     */
    void setTargetScope(ScopeKind targetScope);

    /**
     * <p>
     * Gets the target scope of the current object.
     * </p>
     *
     * @return the target scope of this object.
     */
    ScopeKind getTargetScope();

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
}
