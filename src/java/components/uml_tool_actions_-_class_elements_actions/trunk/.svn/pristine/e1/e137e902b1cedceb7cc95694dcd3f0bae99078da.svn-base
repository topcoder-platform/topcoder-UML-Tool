/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class extends from ClassUndoableAction. It implements all logic
 * of paste action for all elements in component. It contains three methods -
 * execute(), redo(), undo().
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class PasteAction extends ClassUndoableAction {

    /**
     * <p>
     * Represent Namespace instance for currnt action. It used for setting this
     * namespace into execute() method
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Constructor which provide configuration for paste action.
     * </p>
     *
     * @param transferable
     *            Transfarable instance, null impossible
     * @param dataFlavor
     *            DataFlavor instance, null impossible
     * @param classToolUtil
     *            classToolUtil instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws InvalidDataContentException
     *             if requested data flavor is not supported
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    protected PasteAction(Transferable transferable, DataFlavor dataFlavor, ClassToolUtil classToolUtil,
            Namespace namespace) throws InvalidDataContentException {
        super(transferable, dataFlavor, classToolUtil);

        if (namespace == null) {
            throw new IllegalArgumentException("Param namespace should not be null.");
        }

        this.namespace = namespace;
    }

    /**
     * <p>
     * This method provide adding current instance of ModelElement to namespace.
     * </p>
     */
    public void execute() {
        getClassToolUtil().addElementToModel(getModelElement(), namespace);

    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo
     * functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getClassToolUtil().addElementToModel(getModelElement(), namespace);
            super.redo();
        } else {
            getLog().log(Level.WARN, "Impossible provide redo paste action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo
     * functionality.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            if (!getClassToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in the namespace.");
            }
            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo paste action.");
        }
    }
}