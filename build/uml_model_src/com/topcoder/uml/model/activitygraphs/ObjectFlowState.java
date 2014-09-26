/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * An object flow state defines an object flow between actions in an activity
 * graph that represents the passing of an object from the output of actions in
 * one state to the input of actions in another state. An instance of a
 * particular classifier, possibly in a particular state, is available when an
 * object flow state is occupied. The generation of an object by an action in an
 * action state may be modeled by an object flow state that is triggered by the
 * completion of the action state. The use of the object in a subsequent action
 * state may be modeled by connecting the output transition of the object flow
 * state as an input transition to the action state. Generally each action
 * places the object in a different state that is modeled as a distinct object
 * flow state.
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
public interface ObjectFlowState extends SimpleState {
    /**
     * <p>
     * Sets a boolean value indicating whether this state is synchronous.
     * </p>
     *
     * @param isSynch
     *            a boolean value indicating whether this state is synchronous.
     */
    void setSynch(boolean isSynch);

    /**
     * <p>
     * Gets a boolean value indicating whether this state is synchronous.
     * </p>
     *
     * @return true if this state is synchronous, false otherwise.
     */
    boolean isSynch();

    /**
     * <p>
     * Sets the object being passed through this state. Note the object could be
     * null.
     * </p>
     *
     * @param type
     *            the object being passed through this state.
     */
    void setType(Classifier type);

    /**
     * <p>
     * Gets the object being passed through this state. Note the object could be
     * null.
     * </p>
     *
     * @return the object being passed through this state.
     */
    Classifier getType();
}
