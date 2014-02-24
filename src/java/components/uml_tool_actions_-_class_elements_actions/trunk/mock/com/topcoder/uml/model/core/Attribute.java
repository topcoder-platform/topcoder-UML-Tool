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
public interface Attribute extends StructuralFeature {
    /**
     * <p>
     * Sets the initial value of the current object.
     * </p>
     *
     * @param initialValue
     *            the initial value to be set for this object
     */
    public void setInitialValue(Expression initialValue);

    /**
     * <p>
     * Gets the initial value of the current object.
     * </p>
     *
     * @return the initial value of this object
     */
    public Expression getInitialValue();

    /**
     * <p>
     * Sets the association end of the current object.
     * </p>
     *
     * @param associationEnd
     *            the association end to be set for this object
     */
    public void setAssociationEnd(AssociationEnd associationEnd);

    /**
     * <p>
     * Gets the association end of the current object.
     * </p>
     *
     * @return the association end of this object
     */
    public AssociationEnd getAssociationEnd();
}