/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.relationships.Relationship;

/**
 * <p>
 * This interface, which extends the Relationship interface, describes an "Include" relationship
 * between two Use Cases.
 * </p>
 *
 * <p>
 * This interface captures the "base" use case as well as the UseCase that it includes,
 * the "addition" UseCase.
 * </p>
 *
 * <p>
 * Thread Safety - Implementations of this interface is not required to be thread-safe, since thread
 * safety should be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public interface Include extends Relationship {
    /**
     * <p>
     * Set the "base" of this relationship.
     * </p>
     *
     * <p>
     * This is the UseCase that includes the "addition" UseCase.
     * </p>
     *
     * @param base the "base" UseCase of this relationship. It can be null.
     */
    public void setBase(UseCase base);

    /**
     * <p>
     * Retrieve the "base" of this relationship as set by setBase.
     * </p>
     *
     * <p>
     * This is the UseCase that includes the "addition" UseCase.
     * </p>
     *
     * @return the "base" UseCase of this relationship. It can be null.
     */
    public UseCase getBase();

    /**
     * <p>
     * Set the "addition" of this relationship.
     * This is the UseCase that is included by the "base" UseCase.
     * </p>
     *
     * @param addition the "addition" UseCase of this relationship. It can be null.
     */
    public void setAddition(UseCase addition);

    /**
     * <p>
     * Retrieve the "addition" UseCase of this relationship as set by setAddition.
     * </p>
     *
     * <p>
     * This is the UseCase that is included by the "base" UseCase.
     * </p>
     *
     * @return the "addition" UseCase of this relationship. It can be null.
     */
    public UseCase getAddition();
}
