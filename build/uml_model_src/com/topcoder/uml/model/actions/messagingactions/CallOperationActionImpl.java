/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.messagingactions;

import com.topcoder.uml.model.core.Operation;


/**
 * <p>
 * This class is a simple implementation of <code>CallOperationAction</code> interface and
 * extends <code>ExplicitInvocationActionAbstractImpl</code> class.
 *
 * <p>
 * Operations supported by the <code>CallOperationActionImpl</code> class are:
 * <ul>
 * <li>
 * Gets the value of asynchronous field. It represents whether the operation of this action
 * will be called asynchronously or not.
 * </li>
 * <li>
 * Sets the asynchronous field with the given value. It represents whether the operation this action
 * will be called asynchronously or not.
 * </li>
 * <li>
 * Gets the operation that will be invoked by this action.
 * </li>
 * <li>
 * Sets the operation that will be invoked by this action with the given value.
 * </li>
 * </ul>
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>: This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public class CallOperationActionImpl extends ExplicitInvocationActionAbstractImpl implements CallOperationAction {
    /**
     * <p>
     * Represents whether the operation will be called asynchronously or not.
     * </p>
     *
     * <p>
     * <strong>Note</strong>:
     * If it is <c>false</c>, the call is synchronous and the caller waits for completion and a reply.
     * If it is <c>true</c>, the call is asynchronous and the caller proceeds immediately and does
     * not expect a reply.
     * </p>
     *
     * <p>
     * This field is mutable, it can be modified by the setter, and accessed with the getter.
     * </p>
     */
    private boolean asynchronous;

    /**
     * <p>
     * Represents the operation that will be invoked by this action.
     * </p>
     *
     * <p>
     * This field is mutable, it can be modified by the setter, and accessed with the getter.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: <code>Null</code> value for this field is acceptable.
     * </p>
     */
    private Operation operation;

    /**
     * <p>
     * Creates an instance of <code>CallOperationActionImpl</code>.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: It is an empty constructor.
     * </p>
     */
    public CallOperationActionImpl() {
        // Empty constructor.
    }

    /**
     * <p>
     * Gets the value of asynchronous field of this class. It represents whether the operation
     * will be called asynchronously or not.
     * </p>
     *
     * @return true if the operation will be called asynchronous, false otherwise.
     */
    public boolean isAsynchronous() {
        return asynchronous;
    }

    /**
     * <p>
     * Sets the asynchronous field of this class with the given value. It represents whether the operation
     * will be called asynchronously or not.
     * </p>
     *
     * @param asynchronous a <code>boolean</code> value, which represents whether the operation
     *        will be called asynchronously or not.
     */
    public void setAsynchronous(boolean asynchronous) {
        this.asynchronous = asynchronous;
    }

    /**
     * <p>
     * Gets the operation that will be invoked by this action.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: The returned value can be <code>null</code>
     * </p>
     *
     * @return the operation that will be invoked by this action.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * <p>
     * Sets the operation that will be invoked by this action with the given value.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: The value of the <c>operation</c> can be <code>null</code>.
     * </p>
     *
     * @param operation the operation that will be set to this action.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
