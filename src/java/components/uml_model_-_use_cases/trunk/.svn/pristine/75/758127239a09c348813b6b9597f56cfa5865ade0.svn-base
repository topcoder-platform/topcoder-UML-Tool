/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;

/**
 * <p>
 * This abstract class provides the basic implementation of both the Include and the Extend interfaces,
 * as it stores both a base UseCase and a "target" (either the 'addition' or the 'extension' UseCase).
 * </p>
 *
 * <p>
 * It will be the base class for the IncludeImpl and ExtendImpl concrete classes.
 * It extends the RelationshipAbstractImpl class so it implements the Relationship interface as well.
 * </p>
 *
 * <p>
 * Thread Safety - This class is not required to be thread-safe, since thread safety is required to
 * be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
abstract class UseCaseRelationshipAbstractImpl extends RelationshipAbstractImpl {
    /**
     * <p>
     * Represents the 'base' use case in this relationship, i.e., the one that includes the target,
     * or the one that is extended by the target.
     * </p>
     *
     * <p>
     * May be null if not set. Set by the two-arg constructor or setBase.
     * </p>
     */
    private UseCase base;

    /**
     * <p>
     * Represents the 'target' use case in this relationship, i.e., the one that is being included
     * by the base, or the one that extends the base.
     * </p>
     *
     * <p>
     * May be null if not set. Set by the two-arg constructor or setTarget.
     * </p>
     */
    private UseCase target;

    /**
     * <p>
     * Default constructor. Does nothing.
     * </p>
     */
    protected UseCaseRelationshipAbstractImpl() {
        // empty
    }

    /**
     * <p>
     * Construct this object with the given base and target use cases.
     * </p>
     *
     * <p>
     * Note, null arguments are accepted here.
     * </p>
     *
     * @param base the base UseCase in this relationship (i.e., the one that includes the
     * target, or the one that is extended by the target)
     * @param target the "target" UseCase in this relationship (i.e., the one that is being
     * included by the base, or the one that extends the base)
     */
    protected UseCaseRelationshipAbstractImpl(UseCase base, UseCase target) {
        this.base = base;
        this.target = target;
    }

    /**
     * <p>
     * Set the value of the 'base' property to the given argument.
     * </p>
     *
     * @param base the new value of the 'base' property. May be null.
     */
    public void setBase(UseCase base) {
        this.base = base;
    }

    /**
     * <p>
     * Set the value of the 'target' property to the given argument.
     * </p>
     *
     * <p>
     * Note, this method is protected because it is not intended to be part of the "public API"
     * of concrete subclasses.
     * </p>
     *
     * @param target the new value of the 'target' property. May be null.
     */
    protected void setTarget(UseCase target) {
        this.target = target;
    }

    /**
     * <p>
     * Retrieve the value of the 'base' property.
     * </p>
     *
     * @return the value of the 'base' property. May be null.
     */
    public UseCase getBase() {
        return this.base;
    }

    /**
     * <p>
     * Retrieve the value of the 'target' property.
     * </p>
     *
     * <p>
     * Note, this method is protected because it is not intended to be part of the "public API"
     * of concrete subclasses.
     * </p>
     *
     * @return the value of the 'target' property. May be null.
     */
    protected UseCase getTarget() {
        return this.target;
    }
}
