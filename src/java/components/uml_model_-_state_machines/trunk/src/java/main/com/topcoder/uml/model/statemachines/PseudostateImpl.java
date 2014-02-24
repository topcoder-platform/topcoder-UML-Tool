/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.datatypes.PseudostateKind;

import java.util.Collection;

/**
 * <p>
 * Pseudostate are choice vertices which, when reached, result in the dynamic evaluation of the guards of the triggers
 * of its outgoing transitions. This realizes a dynamic conditional branch. It allows splitting of transitions into
 * multiple outgoing paths such that the decision on which path to take may be a function of the results of prior
 * actions performed in the same run-to-completion step.(OMG Unified Modeling Language Specification - UML 2.0
 * Superstructure Specification, p. 592) Another quick way of defining it would be to state that it is a vertex in a
 * state machine that has the form of a state, but doesn't behave as a state.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This implementation is mutable, and thus NOT thread-safe.
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class PseudostateImpl extends StateVertexAbstractImpl implements Pseudostate {
    /**
     * <p>
     * Represents the type (kind) of Pseudostate that this state represents. It determines the precise type of the
     * Pseudostate and can be one of: - initial - deepHistory -shallowHistory -join -fork -junction -choice.
     * </p>
     * <p>
     * It is initialized through the 2nd constructor or through a dedicated setter.It can be null and is mutable through
     * a setter
     * </p>
     */
    private PseudostateKind kind;

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public PseudostateImpl() {
        // do nothing
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a Pseudostate instance.
     * </p>
     *
     * @param container
     *            the composite state that contains this state
     * @param outgoingTransitions
     *            a collection of outgoing transitions
     * @param incomingTransitions
     *            a collection of incoming transitions
     * @param kind
     *            the 'kind' of pseudostate that we would like to have here
     * @throws IllegalArgumentException
     *             if the passed collections is null or contain null element
     */
    public PseudostateImpl(CompositeState container, Collection<Transition> outgoingTransitions,
            Collection<Transition> incomingTransitions, PseudostateKind kind) {
        super(container, outgoingTransitions, incomingTransitions);
        setKind(kind);
    }

    /**
     * <p>
     * Returns the type (kind) of Pseudostate that this state represents.
     * </p>
     *
     * @return the 'kind' of pseudostate that we have
     */
    public PseudostateKind getKind() {
        return kind;
    }

    /**
     * <p>
     * Sets the type (kind) of Pseudostate that this state represents.
     * </p>
     *
     * @param kind
     *            the 'kind' of pseudostate that we would like to have here
     */
    public void setKind(PseudostateKind kind) {
        this.kind = kind;
    }
}
