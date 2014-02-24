/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

/**
 * <p>
 * This interface extends the Action interface and is a marker interface and defines no methods as a part of the
 * interface definition.
 * </p>
 *
 * <p>
 * This interface marks the class of Action(s) that should not affect the state of the undo/redo manager.
 * This marker interface indicates to the ActionManager that on executing such an Action, no change should be done
 * to the state of the AdvancedUndoManager.
 * </p>
 *
 * <p>
 * Examples of TransientAction:
 * <ul>
 * <li>Print a diagram</li>
 * <li>Copy an element to the clipboard</li>
 * <li>Save the project</li>
 * </ul>
 * </p>
 *
 * <p>
 * Thread-Safety: This interface follows the Action interface with regards to the thread-safety requirements and
 * the implementations of this interface do not need to be thread-safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public interface TransientAction extends Action {
}
