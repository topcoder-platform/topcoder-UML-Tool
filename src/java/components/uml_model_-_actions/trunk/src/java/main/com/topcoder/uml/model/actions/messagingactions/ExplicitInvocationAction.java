/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.messagingactions;
import com.topcoder.uml.model.actions.PrimitiveAction;

/**
 * <p>
 * This interface indicates sending a request object to a target object using an explicit argument list.
 * This action will create a request that is transmitted to the target object, and then the request will be
 * resolved into a behavioral effect by the target object or its class based on the type of the request.
 * Depending on the kind of action, the requester may or may not wait for a reply.
 * </p>
 *
 * <p>
 * This interface extends <code>PrimitiveAction</code> interface.
 * Currently there is one implementation - <code>ExplicitInvocationActionAbstractImpl</code>.
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
public interface ExplicitInvocationAction extends PrimitiveAction {
  // NO IMPLEMENTATION.
}


