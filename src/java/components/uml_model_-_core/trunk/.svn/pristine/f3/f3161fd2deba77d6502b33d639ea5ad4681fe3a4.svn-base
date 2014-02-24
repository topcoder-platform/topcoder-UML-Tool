/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.expressions.Expression;

/**
 * <p>
 * An attribute is a named slot within a classifier that describes a range of values that instances of the classifier
 * may hold.
 * </p>
 * <p>
 * In the meta model, an Attribute is a named piece of the declared state of a Classifier, particularly the range of
 * values that Instances of the Classifier may hold.
 * </p>
 * <p>
 * An Attribute has the following properties:
 * <ul>
 * <li>initialValue: An Expression specifying the value of the attribute upon initialization.</li>
 * <li>associationEnd: Designates the optional AssociationEnd that owns a qualifier attribute. If the value is empty,
 * the attribute is not a qualifier attribute. </li>
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
public interface Attribute extends StructuralFeature {

    /**
     * <p>
     * Sets the initial value of the current object.
     * </p>
     *
     * @param initialValue
     *            the initial value to be set for this object.
     */
    void setInitialValue(Expression initialValue);

    /**
     * <p>
     * Gets the initial value of the current object.
     * </p>
     *
     * @return the initial value of this object.
     */
    Expression getInitialValue();

    /**
     * <p>
     * Sets the association end of the current object.
     * </p>
     *
     * @param associationEnd
     *            the association end to be set for this object.
     */
    void setAssociationEnd(AssociationEnd associationEnd);

    /**
     * <p>
     * Gets the association end of the current object.
     * </p>
     *
     * @return the association end of this object.
     */
    AssociationEnd getAssociationEnd();
}
