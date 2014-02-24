/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.expressions.Expression;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AttributeImpl extends StructuralFeatureAbstractImpl implements Attribute {

    /**
     * An Expression specifying the value of the attribute upon initialization.
     * This attribute is initially left set to null; after construction, it can
     * be set to any value (null included) through the appropriate setter.
     */
    private Expression initialValue;

    /**
     * Designates the optional AssociationEnd that owns a qualifier attribute.
     * This attribute is initially left set to null; after construction, it can
     * be set to any value (null included) through the appropriate setter.
     */
    private AssociationEnd associationEnd;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     *
     * <p>
     * This constructor doen't actually initialize nothing; the non-collection
     * attributes of the class are simply left assigned to <code>null</code>
     * references, while the collection attributes are instantiated to
     * <code>ArrayList</code>s or <code>LinkedList</code>s with
     * initialization clauses specified in the declaration of the attributes
     * theirselves. That is, the JVM should have already set the attributes to
     * the correct references before the execution of this constructor occurs.
     * </p>
     *
     * <p>
     * In case of boolean attributes, they're set to <code>false</code>.
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
     *            the initial value to be set for this object
     */
    public void setInitialValue(Expression initialValue) {
    }

    /**
     * <p>
     * Gets the initial value of the current object.
     * </p>
     *
     * @return the initial value of this object
     */
    public Expression getInitialValue() {
        return null;
    }

    /**
     * <p>
     * Sets the association end of the current object.
     * </p>
     *
     * @param associationEnd
     *            the association end to be set for this object
     */
    public void setAssociationEnd(AssociationEnd associationEnd) {
    }

    /**
     * <p>
     * Gets the association end of the current object.
     * </p>
     *
     * @return the association end of this object
     */
    public AssociationEnd getAssociationEnd() {
        return null;
    }
}