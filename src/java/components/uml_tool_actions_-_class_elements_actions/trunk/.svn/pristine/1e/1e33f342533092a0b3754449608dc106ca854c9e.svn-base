/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface StateMachine extends com.topcoder.uml.model.core.ModelElement {
    /**
     * <p>
     * Returns the context for this StateMachine. This is basically some other
     * UML element which contains this state machine.
     * </p>
     *
     * @return the context of this state machine
     */
    public com.topcoder.uml.model.core.ModelElement getContext();

    /**
     * <p>
     * Sets the context for this StateMachine. This is basically some other UML
     * element which contains this state machine.
     * </p>
     *
     * @param context
     *            the context to be set for this state machine
     */
    public void setContext(com.topcoder.uml.model.core.ModelElement context);

    /**
     * <p>
     * Remove all transitions from this state machine. after this the count
     * should be 0.
     * </p>
     */
    public void clearTransitions();

    /**
     * <p>
     * return the current number of transitions in the state machine. Note that
     * some transitions might be duplicated.
     * </p>
     *
     * @return count of transitions contained in this state machine
     */
    public int countTransitions();
}