/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.actions;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * <p>
 * This class is a simple implementation of <code>Action</code> interface
 * and extends <code>ModelElementAbstractImpl</code> class.
 * </p>
 *
 * <p>
 * Operations supported by the <code>ActionAbstractImpl</code> abstract class are:
 * <ul>
 * <li>
 * Gets the procedure that belongs to this action.
 * </li>
 * <li>
 * Sets the procedure that belongs to this action with the given value.
 * </li>
 * </ul>
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>: This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public abstract class ActionAbstractImpl extends ModelElementAbstractImpl implements Action {

    /**
     * <p>
     * Represents the <code>Procedure</code> instance of this class. This action is also a part of the procedure.
     * </p>
     *
     * <p>
     * This field is mutable, it can be modified by the setter, and accessed with the getter.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: <code>Null</code> value for this field is acceptable.
     * </p>
     */
    private Procedure procedure;

   /**
    * <p>
    * Creates an instance of <code>ActionAbstractImpl</code>.
    * </p>
    *
    * <p>
    * <strong>Note</strong>: It is an empty constructor.
    * </p>
    */
    protected ActionAbstractImpl() {
        // Empty constructor.
    }

    /**
     * <p>
     * Gets the procedure that belongs to this action.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: The returned value can be <code>null</code>
     * </p>
     *
     * @return the instance of <code>Procedure</code> belongs to this action.
     */
    public Procedure getProcedure() {
        return procedure;
    }

    /**
     * <p>
     * Sets the procedure that belongs to this action with the given value.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: The value of the <c>procedure</c> can be <code>null</code>.
     * </p>
     *
     * @param procedure an instance of <code>Procedure</code> used to set the procedure of this action.
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
}
