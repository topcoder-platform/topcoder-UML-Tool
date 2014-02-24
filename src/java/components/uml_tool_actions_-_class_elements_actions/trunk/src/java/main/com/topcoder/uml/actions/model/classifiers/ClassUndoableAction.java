/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.undo.AbstractUndoableEdit;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This abstract class extends from AbstractUndoableEdit and implements
 * UndoableAction interface. This class is base for all rest action classes in
 * component. It contains who attributes and their protected getter. Attributes
 * represent all possible instances of ModelElement for this component and their
 * utility classes.
 * </p>
 * <p>
 * Thread-safety: Class contains reference to some model element which is
 * mutable and also it extends from mutable super class. That is why it is not
 * thread safety.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class ClassUndoableAction extends AbstractUndoableEdit implements UndoableAction {

    /**
     * <p>
     * Represent ClassToolUtil instance for current action. This is used to keep
     * current utility class instance for add, paste, cut and remove actions.
     * </p>
     */
    private final ClassToolUtil classToolUtil;

    /**
     * <p>
     * Represent ModelElement instance for current action. This is used to keep
     * current element instance for add, paste, cut and remove actions.
     * </p>
     */
    private final ModelElement modelElement;

    /**
     * <p>
     * Represent Log instance for current action.
     * </p>
     */
    private final Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * <p>
     * Constructor which provide setting attributes modelElement and
     * classToolUtil.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @throws IllegalArgumentException
     *             when modelElement or classToolUtil is null
     */
    protected ClassUndoableAction(ModelElement modelElement, ClassToolUtil classToolUtil) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Param modelElement should not be null.");
        }
        if (classToolUtil == null) {
            throw new IllegalArgumentException("Param classToolUtil should not be null.");
        }

        this.modelElement = modelElement;
        this.classToolUtil = classToolUtil;
    }

    /**
     * <p>
     * Constructor which provide setting attribute element from transferable
     * instance. DataFlavor recieved from concrete action child and contain
     * concrete information about element.
     * </p>
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
    protected ClassUndoableAction(Transferable transferable, DataFlavor dataFlavor, ClassToolUtil classToolUtil)
            throws InvalidDataContentException {
        if (transferable == null) {
            throw new IllegalArgumentException("Param transferable should not be null.");
        }
        if (dataFlavor == null) {
            throw new IllegalArgumentException("Param dataFlavor should not be null.");
        }
        if (classToolUtil == null) {
            throw new IllegalArgumentException("Param classToolUtil should not be null.");
        }

        try {
            modelElement = (ModelElement) transferable.getTransferData(dataFlavor);
        } catch (IOException ioe) {
            throw new InvalidDataContentException("The data is no longer available in the requested flavor.", ioe);
        } catch (UnsupportedFlavorException ufe) {
            throw new InvalidDataContentException("The requested data flavor is not supported.", ufe);
        } catch (ClassCastException cce) {
            throw new InvalidDataContentException("The requested data flavor is not supported.", cce);
        }

        this.classToolUtil = classToolUtil;
    }

    /**
     * <p>
     * Simple getter for classToolUtil attribute.
     * </p>
     *
     * @return classToolUtil attribute, null impossible
     */
    protected ClassToolUtil getClassToolUtil() {
        return classToolUtil;
    }

    /**
     * <p>
     * Simple getter for modelElementl attribute.
     * </p>
     *
     * @return modelElement attribute, null impossible
     */
    protected ModelElement getModelElement() {
        return modelElement;
    }

    /**
     * <p>
     * Simple getter for log attribute.
     * </p>
     *
     * @return log attribute, null impossible
     */
    protected Log getLog() {
        return log;
    }
}