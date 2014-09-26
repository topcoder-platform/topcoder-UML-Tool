/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * <p>
 * An activity graph is a special case of a state machine that defines a
 * computational process in terms of the control-flow and object-flow among its
 * constituent activities. It does not extend the semantics of state machines in
 * a major way but it does define shorthand forms that are convenient for
 * modeling control-flow and object-flow in organizational processes. The
 * primary purpose of activity graphs is to describe the states of an activity
 * or process involving one or more classifiers. Activity graphs can be attached
 * to packages, classifiers (including use cases) and behavioral features. As in
 * any state machine, if an outgoing transition is not explicitly triggered by
 * an event then it is implicitly triggered by the completion of the contained
 * actions. A sub-activity state represents a nested activity that has some
 * duration and internally consists of a set of actions or more sub-activities.
 * That is, a sub-activity state is a "hierarchical action" with an embedded
 * activity sub-graph that ultimately resolves to individual actions.
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
public interface ActivityGraph extends StateMachine {
}
