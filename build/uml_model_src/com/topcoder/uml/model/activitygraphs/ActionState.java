/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * An action state represents the execution of an atomic action, typically the
 * invocation of an operation. An action state is a simple state with an entry
 * action whose only exit transition is triggered by the implicit event of
 * completing the execution of the entry action. The state therefore corresponds
 * to the execution of the entry action itself and the outgoing transition is
 * activated as soon as the action has completed its execution. An ActionState
 * may perform more than one action as part of its entry action. An action state
 * may not have an exit action, do activity, or internal transitions.
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
public interface ActionState extends SimpleState {
}
