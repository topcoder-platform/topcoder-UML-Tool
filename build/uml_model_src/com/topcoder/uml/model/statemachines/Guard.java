/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;

/**
 * <p>
 * A guard is a condition that must be true in order to traverse a transition. It prevents the transition being taken
 * unless the condition evaluates to true.
 * </p>
 * <p>
 * To expand on this concept: A guard is a boolean expression that is attached to a transition as a fine-grained control
 * over its firing. The guard is evaluated when an event instance is dispatched by the state machine. If the guard is
 * true at that time, the transition is enabled, otherwise, it is disabled. Guards should be pure expressions without
 * side effects.
 * </p>
 * <p>
 * Guard expressions with side effects are ill formed. NOTE: Guards Should Not Overlap. The guards on similar
 * transitions leaving a state must be consistent with one another. For example guards such as [x &lt;0], [x = 0], and
 * [x &gt; 0] are consistent whereas guard such as [x &lt;= 0] and [x &gt;= 0] are not consistent because they overlap.
 * </p>
 * <p>
 * <b>Thread Safety</b>:Implementations are mutable, there is no requirement to make implementations of this interface
 * thread-safe.
 * </p>
 * 
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface Guard extends ModelElement {
    /**
     * <p>
     * Sets the expression that defines this guard. This is a simple expression that evaluates to true/false (thus a
     * boolean expression) which will be used to ensure that a condition has been met before a transition is allowed to
     * proceed.
     * </p>
     * 
     * @param expression
     *            the guard expression
     */
    public void setExpression(BooleanExpression expression);

    /**
     * <p>
     * Gets the expression that defines this guard.
     * </p>
     * 
     * @return the current guard expression
     */
    public BooleanExpression getExpression();

    /**
     * <p>
     * Get the transition that this guard is defined for.
     * </p>
     * 
     * @return the transition associated with this guard
     */
    public Transition getTransition();

    /**
     * <p>
     * Set the transition that this guard is defined for.
     * </p>
     * 
     * @param transition
     *            the transition to be associated with this guard
     */
    public void setTransition(Transition transition);
}
