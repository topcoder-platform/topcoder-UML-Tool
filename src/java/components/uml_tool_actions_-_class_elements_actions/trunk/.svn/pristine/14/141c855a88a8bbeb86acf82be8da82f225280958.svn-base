/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This is the mock class of ClassUndoableAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockClassUndoableAction extends ClassUndoableAction {

    /**
     * Mock constructor(ModelElement, ClassToolUtil).
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @throws IllegalArgumentException
     *             when modelElement or classToolUtil is null
     */
    public MockClassUndoableAction(ModelElement modelElement, ClassToolUtil classToolUtil) {
        super(modelElement, classToolUtil);
    }

    /**
     * Mock constructor(Transferable, DataFlavor, ClassToolUtil).
     *
     * @param transferable
     *            Transferable instance, null impossible
     * @param dataFlavor
     *            DataFlavor instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @throws InvalidDataContentException
     *             if requested data flavor is not supported or data is no
     *             longer available in the requested flavor
     * @throws IllegalArgumentException
     *             when transferable, dataFlavor or classToolUtil is null
     */
    public MockClassUndoableAction(Transferable transferable, DataFlavor dataFlavor, ClassToolUtil classToolUtil)
            throws InvalidDataContentException {
        super(transferable, dataFlavor, classToolUtil);
    }

    /**
     * Mock method. Do nothing.
     */
    public void execute() throws ActionExecutionException {
    }
}