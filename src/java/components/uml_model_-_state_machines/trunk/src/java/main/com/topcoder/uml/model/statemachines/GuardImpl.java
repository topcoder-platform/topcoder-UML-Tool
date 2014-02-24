/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;

/**
 * <p>
 * A guard is a condition that must be true in order to traverse a transition. It prevents the transition being taken
 * unless the condition evaluates to true. To expand on this concept: A guard is a boolean expression that is attached
 * to a transition as a fine-grained control over its firing. NOTE: Guards Should Not Overlap. The guards on similar
 * transitions leaving a state must be consistent with one another. For example guards such as [x &lt;0], [x = 0], and
 * [x &gt; 0] are consistent whereas guard such as [x &lt;= 0] and [x &gt;= 0] are not consistent because they overlap.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This implementation is mutable and has not been thread-safe as this is not required/desirable.
 * </p>
 * 
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public class GuardImpl extends ModelElementAbstractImpl implements Guard {

    /**
     * <p>
     * Represents the boolean expression for this guard.
     * </p>
     * <p>
     * This expression is initialized through the 2nd constructor or through a dedicated setter. It can be null and is
     * mutable through a setter.
     * </p>
     */
    private BooleanExpression booleanExpression;

    /**
     * <p>
     * Represents the transition that this guard is set for.
     * </p>
     * <p>
     * This transition is initialized through the 2nd constructor or through a dedicated setter.It can be null and is
     * mutable through a setter.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public GuardImpl() {
        // do nothing
    }

    /**
     * <p>
     * General constructor which allows for complete initialization of a Guard instance.
     * </p>
     * 
     * @param expression
     *            boolean expression defining this guard
     * @param transition
     *            the transition that this guard applies to
     */
    public GuardImpl(BooleanExpression expression, Transition transition) {
        setExpression(expression);
        setTransition(transition);
    }

    /**
     * <p>
     * Sets the expression that defines this guard.
     * </p>
     * <p>
     * This is a simple expression that evaluates to true/false (thus a boolean expression) which will be used to ensure
     * that a condition has been met before a transition is allowed to proceed.
     * </p>
     * 
     * @param expression
     *            the guard expression
     */
    public void setExpression(BooleanExpression expression) {
        this.booleanExpression = expression;
    }

    /**
     * <p>
     * Gets the expression that defines this guard.
     * </p>
     * <p>
     * This is a simple expression that evaluates to true/false (thus a boolean expression) which will be used to ensure
     * that a condition has been met before a transition is allowed to proceed.
     * </p>
     * 
     * @return boolean expression for this guard
     */
    public BooleanExpression getExpression() {
        return booleanExpression;
    }

    /**
     * <p>
     * Get the transition that this guard is defined for.
     * </p>
     * 
     * @return the transition associated with this guard
     */
    public Transition getTransition() {
        return transition;
    }

    /**
     * <p>
     * Set the transition that this guard is defined for.
     * </p>
     * 
     * @param transition
     *            the transition to be associated with this guard
     */
    public void setTransition(Transition transition) {
        this.transition = transition;
    }

}
