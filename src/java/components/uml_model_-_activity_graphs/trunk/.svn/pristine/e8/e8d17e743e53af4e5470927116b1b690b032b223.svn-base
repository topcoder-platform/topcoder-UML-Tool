/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * This is a simple concrete implementation of ObjectFlowState interface and
 * extends SimpleStateImpl from the State Machines component. As such, all
 * methods in ObjectFlowState and SimpleStateImpl are supported.
 * </p>
 *
 * <p>
 * <b>Thread Safety: </b><br/>This class is not thread-safe because its
 * superclass implementation are not thread-safe. Thread safety will be provided
 * by the application using it if desired.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class ObjectFlowStateImpl extends SimpleStateImpl implements
        ObjectFlowState {
    /**
     * <p>
     * Represents whether this flow state is a synchronous state or not. If
     * true, it means this flow state is a synchronous state. It defaults to
     * false, can be set via the setSynch(boolean) method and accessed via the
     * isSynch() method.
     * </p>
     */
    private boolean isSynch = false;

    /**
     * <p>
     * Represents the object being passed through this state. It may be null if
     * not set. It defaults to null, can be set via the setType(Classifier)
     * method or the one-arg constructor and accessed via the getType() method.
     * </p>
     */
    private Classifier type = null;

    /**
     * <p>
     * Creates a new instance of <code>ObjectFlowStateImpl</code>.
     * </p>
     */
    public ObjectFlowStateImpl() {
    }

    /**
     * <p>
     * Creates a new instance of <code>ObjectFlowStateImpl</code> with the
     * given type. Note the type parameter is allowed to be null.
     * </p>
     *
     * @param type
     *            the object being passed through this state.
     */
    public ObjectFlowStateImpl(Classifier type) {
        this.type = type;
    }

    /**
     * <p>
     * Sets a boolean value indicating whether this state is synchronous.
     * </p>
     *
     * @param isSynch
     *            a boolean value indicating whether this state is synchronous.
     */
    public void setSynch(boolean isSynch) {
        this.isSynch = isSynch;
    }

    /**
     * <p>
     * Gets a boolean value indicating whether this state is synchronous.
     * </p>
     *
     * @return true if this state is synchronous, false otherwise.
     */
    public boolean isSynch() {
        return isSynch;
    }

    /**
     * <p>
     * Sets the object being passed through this state. Note the object could be
     * null.
     * </p>
     *
     * @param type
     *            the object being passed through this state.
     */
    public void setType(Classifier type) {
        this.type = type;
    }

    /**
     * <p>
     * Gets the object being passed through this state. Note the object could be
     * null.
     * </p>
     *
     * @return the object being passed through this state.
     */
    public Classifier getType() {
        return type;
    }
}
