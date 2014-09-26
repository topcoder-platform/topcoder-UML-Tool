/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

/**
 * <p>
 * A call state is an action state that calls a single operation. It is useful
 * in object flow modeling to reduce notational ambiguity over which action is
 * taking input or providing output.
 * </p>
 *
 * <p>
 * <b>Thread Safety: </b><br/>Implementations do not have to be thread-safe. In
 * fact, method synchronization is discouraged. Thread safety will be provided
 * by the application using these implementations.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public interface CallState extends ActionState {
}
