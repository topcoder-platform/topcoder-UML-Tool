/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * <p>
 * This abstract class is a default implementation of the <code>Feature</code> interface.
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
public abstract class FeatureAbstractImpl extends ModelElementAbstractImpl implements Feature {

    /**
     * <p>
     * The Classifier declaring the Feature.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Classifier owner;

    /**
     * <p>
     * Specifies whether Feature appears in each Instance of the Classifier or whether there is just a single instance
     * of the Feature for the entire Classifier.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private ScopeKind ownerScope;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected FeatureAbstractImpl() {
    }

    /**
     * <p>
     * Sets the owner of the current object.
     * </p>
     *
     * @param owner
     *            the owner to be set for this object.
     */
    public void setOwner(Classifier owner) {
        this.owner = owner;
    }

    /**
     * <p>
     * Gets the owner of the current object.
     * </p>
     *
     * @return the owner of this object.
     */
    public Classifier getOwner() {
        return owner;
    }

    /**
     * <p>
     * Sets the owner scope of the current object.
     * </p>
     *
     * @param ownerScope
     *            the owner scope to be set for this object.
     */
    public void setOwnerScope(ScopeKind ownerScope) {
        this.ownerScope = ownerScope;
    }

    /**
     * <p>
     * Gets the owner scope of the current object.
     * </p>
     *
     * @return the owner scope of this object.
     */
    public ScopeKind getOwnerScope() {
        return ownerScope;
    }
}
