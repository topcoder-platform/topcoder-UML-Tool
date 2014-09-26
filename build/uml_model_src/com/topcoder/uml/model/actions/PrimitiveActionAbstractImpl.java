/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

/**
 * <p>
 * This class is a simple implementation of <code>PrimitiveAction</code> interface
 * and extends <code>ActionAbstractImpl</code> class.
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>: This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public abstract class PrimitiveActionAbstractImpl extends ActionAbstractImpl implements PrimitiveAction {

    /**
     * <p>
     * Creates an instance of <code>PrimitiveActionAbstractImpl</code>.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: It is an empty constructor.
     * </p>
     */
    protected PrimitiveActionAbstractImpl() {
        // Empty constructor.
    }
}
