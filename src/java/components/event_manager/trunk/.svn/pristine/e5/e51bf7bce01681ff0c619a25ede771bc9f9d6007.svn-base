/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.Action;

import java.util.EventObject;


/**
 * <p>
 * The action event extends EventObject and has a reference to the action to be executed. The action will be executed
 * by the action manager.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * </p>
 *
 * <p>
 * This class is thread safe by being immutable.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class ActionEvent extends EventObject {
    /**
     * <p>
     * Represents the action carried by this event. This variable is set in the constructor, is immutable and will
     * never be null.
     * </p>
     */
    private final Action action;

    /**
     * <p>
     * The Constructor of the <code>ActionEvent</code>.
     * </p>
     *
     * @param action the action carried by this event
     * @param source the event source
     *
     * @throws IllegalArgumentException if the action or source is null
     */
    public ActionEvent(Action action, Object source) {
        super(source);

        if (action == null) {
            throw new IllegalArgumentException("The argument 'action' should not be null.");
        }

        this.action = action;
    }

    /**
     * <p>
     * Get the action carried by this event.
     * </p>
     *
     * @return the action carried by this event
     */
    public Action getAction() {
        return action;
    }
}
