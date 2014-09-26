/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.expressions.Expression;

/**
 * <p>
 * This class is a default implementation of the <code>Attribute</code> interface. The non-collection attributes
 * described by the interface are implemented by simple references to objects, that are set to <code>null</code> by
 * default; the unordered collection attributes are implemented with instances of <code>ArrayList</code>, while the
 * ordered collection attributes are implemented with instances of <code>LinkedList</code>.
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
public class AttributeImpl extends StructuralFeatureAbstractImpl implements Attribute {

    /**
     * <p>
     * An Expression specifying the value of the attribute upon initialization.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private Expression initialValue;

    /**
     * <p>
     * Designates the optional AssociationEnd that owns a qualifier attribute.
     * </p>
     * <p>
     * This attribute is initially left set to null; after construction, it can be set to any value (null included)
     * through the appropriate setter.
     * </p>
     */
    private AssociationEnd associationEnd;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    public AttributeImpl() {
    }

    /**
     * <p>
     * Sets the initial value of the current object.
     * </p>
     *
     * @param initialValue
     *            the initial value to be set for this object.
     */
    public void setInitialValue(Expression initialValue) {
        this.initialValue = initialValue;
    }

    /**
     * <p>
     * Gets the initial value of the current object.
     * </p>
     *
     * @return the initial value of this object.
     */
    public Expression getInitialValue() {
        return initialValue;
    }

    /**
     * <p>
     * Sets the association end of the current object.
     * </p>
     *
     * @param associationEnd
     *            the association end to be set for this object.
     */
    public void setAssociationEnd(AssociationEnd associationEnd) {
        this.associationEnd = associationEnd;
    }

    /**
     * <p>
     * Gets the association end of the current object.
     * </p>
     *
     * @return the association end of this object.
     */
    public AssociationEnd getAssociationEnd() {
        return associationEnd;
    }
}
