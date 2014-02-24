/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * In the metamodel, PseudostateKind defines an enumeration that discriminates the kind of
 * Pseudostate.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum PseudostateKind {

    /**
     * <p>
     * Splits an incoming transition into several disjoint outgoing transitions. Each outgoing
     * transition has a guard condition that is evaluated after prior actions on the incoming path
     * have been completed. At least one outgoing transition must be enabled or the model is ill
     * formed.
     * </p>
     *
     */
    CHOICE,

    /**
     * <p>
     * When reached as the target of a transition, restores the full state configuration that was
     * active just before the enclosing composite state was last exited.
     * </p>
     *
     */
    DEEP_HISTORY,

    /**
     * <p>
     * Splits an incoming transition into several concurrent outgoing transitions. All of the
     * transitions fire together.
     * </p>
     *
     */
    FORK,

    /**
     * <p>
     * The default target of a transition to the enclosing composite state.
     * </p>
     *
     */
    INITIAL,

    /**
     * <p>
     * Merges transitions from concurrent regions into a single outgoing transition. All the
     * transitions fire together.
     * </p>
     *
     */
    JOIN,

    /**
     * <p>
     * Chains together transitions into a single run-to-completion path. May have multiple input
     * and/or output transitions. Each complete path involving a junction is logically independent
     * and only one such path fires at one time. May be used to construct branches and merges.
     * </p>
     *
     */
    JUNCTION,

    /**
     * <p>
     * When reached as the target of a transition, restores the state within the enclosing composite
     * state that was active just before the enclosing state was last exited. Does not restore any
     * substates of the last active state.
     * </p>
     *
     */
    SHALLOW_HISTORY
}
