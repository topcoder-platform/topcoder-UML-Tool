/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;

/**
 * <p>
 * This class implements the Extend interface. It uses its base class, UseCaseRelationshipAbstractImpl,
 * to provide the get/setBase functionality; the get/setAddition methods are delegated to the get/setTarget
 * methods of the superclass.
 * </p>
 *
 * <p>
 * Thread Safety - this class is mutable and then not thread-safe.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class ExtendImpl extends UseCaseRelationshipAbstractImpl implements Extend {
    /**
     * <p>
     * The condition under which this relationship will be in effect.
     * </p>
     *
     * <p>
     * It can be null. Set by setCondition and accessed by getCondition.
     * </p>
     */
    private BooleanExpression condition;

    /**
     * <p>
     * Default constructor. Does nothing.
     * </p>
     */
    public ExtendImpl() {
        // empty
    }

    /**
     * <p>
     * Construct this object with the given base and addition use cases.
     * </p>
     *
     * <p.
     * Note, null arguments are accepted here.
     * </p>
     *
     * @param base the base UseCase in this relationship (i.e., the one that is extended by "extension")
     * @param extension the "extension" UseCase of this relationship. (i.e., the one that extends the "base".)
     */
    public ExtendImpl(UseCase base, UseCase extension) {
        super(base, extension);
    }

    /**
     * <p>
     * Set the "extension" of this relationship.
     * </p>
     *
     * <p>
     * This is the UseCase that extends the "base" UseCase.
     * </p>
     *
     * @param extension the "extension" UseCase of this relationship. It can be null.
     */
    public void setExtension(UseCase extension) {
        super.setTarget(extension);
    }

    /**
     * <p>
     * Retrieve the "extension" UseCase of this relationship as set by setExtension.
     * </p>
     *
     * <p>
     * This is the UseCase that is extended by the "base" UseCase.
     * </p>
     *
     * @return the "extension" UseCase of this relationship. It can be null.
     */
    public UseCase getExtension() {
        return super.getTarget();
    }

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
     * @param condition the condition under which this relationship will be in effect.
     * It can be null.
     */
    public void setCondition(BooleanExpression condition) {
        this.condition = condition;
    }

    /**
     * <p>
     * Retrieve the "condition" of this Extends relationship as set by setCondition.
     * </p>
     *
     * <p>
     * This indicates that the extension UseCase only extends the base when the BooleanExpression
     * is true.
     * </p>
     *
     * @return the condition under which this relationship will be in effect. It can be null.
     */
    public BooleanExpression getCondition() {
        return this.condition;
    }
}
