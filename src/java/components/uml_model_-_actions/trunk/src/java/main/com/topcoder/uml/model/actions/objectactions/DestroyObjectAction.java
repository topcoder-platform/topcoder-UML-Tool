/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.objectactions;

import com.topcoder.uml.model.actions.PrimitiveAction;
/**
 * <p>
 * This interface represents the action which is used to destroy an object.
 * The classifiers of the object will be are removed, and the object is destroyed.
 * After that, the action has no other effect. In particular, no destructors are executed,
 * no state machines transitions are triggered, and references to the objects are unchanged.
 * Obviously, destroying an object that is already destroyed will have no effect.
 * </p>
 *
 * <p>
 * This interface extends <code>PrimitiveAction</code> interface.
 * Currently there is one implementation - <code>DestroyObjectActionImpl</code>.
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
public interface DestroyObjectAction extends PrimitiveAction {
  // NO IMPLEMENTATION.
}


