/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

/**
 * <p>
 * This interface, which extends the Relationship interface, describes an "Include" relationship
 * between two Use Cases.
 * </p>
 *
 * <p>
 * Therefore this interface captures the "base" use case as well as the
 * UseCase that it includes, the "addition" UseCase.
 * </p>
 *
 * <p>
 * Thread Safety - Implementations of this interface is not required to be thread-safe,
 * since thread safety should be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class IncludeImpl extends UseCaseRelationshipAbstractImpl implements Include {
    /**
     * Default constructor. Does nothing.
     *
     */
    public IncludeImpl() {
        // empty
    }

    /**
     * <p>
     * Construct this object with the given base and addition use cases.
     * </p>
     *
     * <p>
     * Note, null arguments are accepted here.
     * </p>
     *
     * @param base the base UseCase in this relationship
     * @param addition the addition UseCase in this relationship
     */
    public IncludeImpl(UseCase base, UseCase addition) {
        super(base, addition);
    }

    /**
     * <p>
     * Set the "addition" of this relationship.
     * </p>
     *
     * <p>
     * This is the UseCase that is included by the "base" UseCase.
     * </p>
     *
     * @param addition the "addition" UseCase of this relationship. It can be null.
     */
    public void setAddition(UseCase addition) {
        super.setTarget(addition);
    }

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
    public UseCase getAddition() {
        return super.getTarget();
    }
}
