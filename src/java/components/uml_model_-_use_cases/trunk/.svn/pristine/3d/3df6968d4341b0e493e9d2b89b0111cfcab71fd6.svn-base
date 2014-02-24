/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;

/**
 * <p>
 * This interface, which extends the Relationship interface, describes an "Extends" relationship
 * between two Use Cases.
 * </p>
 *
 * <p>
 * This interface captures the "base" use case as well as the UseCase that extends it, the "extension"
 * UseCase. ("extension extends base")
 * </p>
 *
 * <p>
 * Thread Safety : Implementations of this interface is not required to be thread-safe, since thread
 * safety should be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public interface Extend extends Relationship {
    /**
     * <p>
     * Set the "base" of this relationship.
     * This is the UseCase that is extended by the "extension" UseCase.
     * </p>
     *
     * <p>
     * Note, it can be null.
     * </p>
     *
     * @param base the "base" UseCase of this relationship.
     */
    public void setBase(UseCase base);

    /**
     * <p>
     * Retrieve the "base" of this relationship as set by setBase.
     * This is the UseCase that is extended by the "extension" UseCase.
     * </p>
     *
     * <p>
     * Note, it can be null.
     * </p>
     *
     * @return the "base" UseCase of this relationship.
     */
    public UseCase getBase();

    /**
     * <p>
     * Set the "extension" of this relationship.
     * This is the UseCase that extends the "base" UseCase.
     * </p>
     *
     * @param extension the "extension" UseCase of this relationship. It can be null.
     */
    public void setExtension(UseCase extension);

    /**
     * <p>
     * Retrieve the "extension" UseCase of this relationship as set by setExtension.
     * This is the UseCase that extends the "base" UseCase.
     * </p>
     *
     * @return the "extension" UseCase of this relationship.  It can be null.
     */
    public UseCase getExtension();

    /**
     * <p>
     * Set the "condition" of this Extends relationship.
     * </p>
     *
     * <p>
     * This indicates that the extension UseCase only extends the
     * base when the BooleanExpression is true.
     * </p>
     *
     * @param condition the condition under which this relationship will be in effect. It can be null.
     */
    public void setCondition(BooleanExpression condition);

    /**
     * <p>
     * Retrieve the "condition" of this Extends relationship as set by setCondition.
     * </p>
     *
     * <p>
     * This indicates that the extension UseCase only extends the
     * base when the BooleanExpression is true.
     * </p>
     *
     * @return the condition under which this relationship will be in effect. It can be null.
     */
    public BooleanExpression getCondition();
}
