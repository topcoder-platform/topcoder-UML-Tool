/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.objectactions;

import com.topcoder.uml.model.actions.PrimitiveAction;

/**
 * <p>
 * This interface represents the action which is used to create a new object by instantiating a concrete classifier.
 * After the new object is created, and the classifier of the object is set to the given classifier,
 * the new object is returned as the value of the action. After that, the action has no other effect.
 * In particular, no constructors are executed; no initial expressions are evaluated,
 * and no state machines transitions are triggered.
 * </p>
 *
 * <p>
 * <strong>Note</strong>:
 * The created object has no attributes values and participates in no links. The semantics is undefined for creating
 * objects from abstract classifiers or from association classes.
 * </p>
 *
 * <p>
 * This interface extends <code>PrimitiveAction</code> interface.
 * Currently there is one implementation - <code>CreateObjectActionImpl</code>.
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
public interface CreateObjectAction extends PrimitiveAction {
  // NO IMPLEMENTATION.
}


