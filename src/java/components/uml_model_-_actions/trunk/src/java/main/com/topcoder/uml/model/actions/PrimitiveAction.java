/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.actions;

/**
 * <p>
 * This interface represents an action which does not contain any nested actions.
 * It is a primitive action.
 * </p>
 *
 * <p>
 * This interface extends <code>Action</code> interface.
 * Currently there is one implementation - <code>PrimitiveActionAbstractImpl</code>
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>: Implementations of this interface do not have to be thread-safe.
 * In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public interface PrimitiveAction extends Action {
  // NO IMPLEMENTATION.
}


