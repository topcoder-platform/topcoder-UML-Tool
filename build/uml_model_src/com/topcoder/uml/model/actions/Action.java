/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This interface is the fundamental unit of behavior specification.
 * An action takes a set of input values and uses them to produce a set of output values.
 * The input set and output set may be empty. If both sets are missing, the action must have some kind
 * of fixed, non parameterized effect on the system state, or be performing some effect external to the system.
 * </p>
 *
 * <p>
 * <strong>Note</strong>:
 * Actions may access or modify accessible, mutable objects which is given as an input values,
 * Composite actions may include data-transformation actions as
 * well as object-access actions.
 * </p>
 *
 * <p>
 * This interface extends <code>ModelElement</code> interface.
 * Currently there is one implementation - <code>ActionAbstractImpl</code>
 * </p>
 *
 * <p>
 * Operations supported by the <code>Action</code> interface are:
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
 * <strong>Thread Safety</strong>: Implementations of this interface do not have to be thread-safe.
 * In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public interface Action extends ModelElement {
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
    public Procedure getProcedure();

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
    public void setProcedure(Procedure procedure);
}


