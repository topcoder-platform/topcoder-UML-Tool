/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * The class provides a list item wrapper for <code>Transition</code> object, to be used in
 * <code>Incoming/OutgoingTransitionPropertyPanel</code>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is thread-safe as it is immutable.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
class TransitionListItem {
    /**
     * <p>
     * The Transition stored.
     * </p>
     *
     * <p>
     * Set in the constructor and will not change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * The presentation string.
     * </p>
     *
     * <p>
     * Set in the constructor and will not change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Creates a new <code>TransitionListItem</code>.
     * </p>
     *
     * @param transition the <code>Transition</code> object corresponding to this transition
     *
     * @throws IllegalArgumentException if transition is null
     */
    TransitionListItem(Transition transition) {
        Util.checkNull(transition, "transition");

        this.transition = transition;

        StateVertex source = transition.getSource();
        StateVertex target = transition.getTarget();

        if (source != null && target != null) {
            this.presentationName = source.getName() + "->" + target.getName();
        } else {
            this.presentationName = "";
        }
    }

    /**
     * <p>
     * Retrieves the stored <code>Transition</code>.
     * </p>
     *
     * @return the <code>Transition</code> object corresponding to this instance
     */
    Transition getTransition() {
        return transition;
    }

    /**
     * <p>
     * Retrieves the string representation of the <code>Transition</code> stored.
     * </p>
     *
     * @return the string representation of the <code>Transition</code> stored.
     */
    public String toString() {
        return presentationName;
    }
}