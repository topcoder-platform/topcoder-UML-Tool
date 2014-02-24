/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import javax.swing.undo.UndoableEdit;

/**
 * <p>
 * This interface extends the Action interface and the javax.swing.undo.UndoableEdit interface and is a marker
 * interface and defines no methods as a part of the interface definition.
 * </p>
 *
 * <p>
 * This interface marks the class of Action(s) that can be un-done and re-done.
 * </p>
 *
 * <p>
 * When such an Action is executed using the ActionManager, the ActionManager will be add these Actions to the
 * AdvancedUndoManager it maintains and will use it for un-doing/re-doing such Actions.
 * </p>
 *
 * <p>
 * Examples of UndoableActions:
 * <ul>
 * <li>Add a class to the diagram</li>
 * <li>Move an element on the diagram</li>
 * <li>Remove an element</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note, though CannotUndoException/CannotRedoException are thrown by the undo() and redo() methods of the
 * javax.swing.undo.UndoableEdit interface, the undo() and the redo() in this interface which are from the
 * UndoableEdit interface are not supposed to throw any exceptions, but the concrete classes should provide
 * error handling either through logging, or by storing the last exception or both.
 * </p>
 *
 * <p>
 * Thread-Safety: This interface follows the Action interface with regards to the thread-safety requirements
 * and the implementations of this interface does not need to be thread-safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public interface UndoableAction extends Action, UndoableEdit {
}
