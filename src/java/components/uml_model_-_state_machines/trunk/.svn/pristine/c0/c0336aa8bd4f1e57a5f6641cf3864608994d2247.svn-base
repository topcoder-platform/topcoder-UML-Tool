/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.datatypes.PseudostateKind;

/**
 * <p>
 * Pseudostate are choice vertices which, when reached, result in the dynamic evaluation of the guards of the triggers
 * of its outgoing transitions. This realizes a dynamic conditional branch. It allows splitting of transitions into
 * multiple outgoing paths such that the decision on which path to take may be a function of the results of prior
 * actions performed in the same run-to-completion step.(OMG Unified Modeling Language Specification - UML 2.0
 * Superstructure Specification, p. 592)
 * </p>
 * <p>
 * Another quick way of defining it would be to state that it is a vertex in a state machine that has the form of a
 * state, but doesn't behave as a state.
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 * 
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface Pseudostate extends StateVertex {
    /**
     * <p>
     * Returns the type (kind) of Pseudostate that this state represents.
     * </p>
     * <p>
     * It determines the precise type of the Pseudostate and can be one of: *
     * <ul>
     * <li> initial </li>
     * <li> deepHistory </li>
     * <li> shallowHistory </li>
     * <li> join </li>
     * <li> fork</li>
     * <li> junction</li>
     * <li> choice</li>
     * </ul>
     * </p>
     * 
     * @return the 'kind' of pseudostate that we have
     */
    public PseudostateKind getKind();

    /**
     * <p>
     * Sets the type (kind) of Pseudostate that this state represents.
     * </p>
     * <p>
     * We can set kind to only one of these values (Defined in the PseudostateKind enum) *
     * <ul>
     * <li> initial </li>
     * <li> deepHistory </li>
     * <li> shallowHistory </li>
     * <li> join </li>
     * <li> fork</li>
     * <li> junction</li>
     * <li> choice</li>
     * </ul>
     * </p>
     * 
     * @param kind
     *            the 'kind' of pseudostate that we would like to have here
     */
    public void setKind(PseudostateKind kind);
}
