/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;

import javax.swing.undo.AbstractUndoableEdit;


/**
 * <p>
 * This abstract class extends from AbstractUndoableEdit and implements UndoableAction interface. This class is base
 * for all rest action classes in component. It contains who attributes and  their protected getter. Attributes
 * represent all possible instances of ModelElement for this component  and their utility classes.
 * </p>
 *
 * <p>
 * Class contains reference to some model element which is mutable and also it extends from mutable super class. That
 * is why it is not thread safety.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class UsecaseUndoableAction extends AbstractUndoableEdit implements UndoableAction {
    /** Represent UsecaseToolUtil instance for current action. */
    private final UsecaseToolUtil usecaseToolUtil;

    /** Represent ModelElement instance for current action. */
    private final ModelElement modelElement;

    /** Represent Log instance for current action. */
    private final Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * <p>
     * Constructor which provides setting attributes modelElement and usecaseToolUtil.
     * </p>
     *
     * @param modelElement ModelElement instance should not be null.
     * @param usecaseToolUtil UsecaseToolUtil instance should not be null.
     *
     * @throws IllegalArgumentException if any parameter is null.
     */
    protected UsecaseUndoableAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("usecaseToolUtil", usecaseToolUtil);
        this.modelElement = modelElement;
        this.usecaseToolUtil = usecaseToolUtil;
    }

    /**
     * <p>
     * Constructor which provides setting attribute element from transferable instance. DataFlavor received from
     * concrete action child and contain concrete information about element.
     * </p>
     *
     * @param transferable Transferable instance, should not be null.
     * @param dataFlavor UsecaseToolUtil instance, should not be null.
     * @param usecaseToolUtil DataFlavor instance, should not be null.
     *
     * @throws InvalidDataContentException when transferable contain incorrect data flavor
     * @throws IllegalArgumentException if any parameter is null.
     */
    protected UsecaseUndoableAction(Transferable transferable, DataFlavor dataFlavor, UsecaseToolUtil usecaseToolUtil)
        throws InvalidDataContentException {
        Helper.checkNull("transferable", transferable);
        Helper.checkNull("dataFlavor", dataFlavor);
        Helper.checkNull("usecaseToolUtil", usecaseToolUtil);

        if (transferable.isDataFlavorSupported(dataFlavor)) {
            try {
                this.modelElement = (ModelElement) transferable.getTransferData(dataFlavor);
            } catch (IOException ioe) {
                throw new InvalidDataContentException("Unable to get the model element.", ioe);
            } catch (UnsupportedFlavorException ufe) {
                throw new InvalidDataContentException("Unable to get the model element.", ufe);
            } catch (ClassCastException cce) {
                throw new InvalidDataContentException("Unable to get the model element.", cce);
            }
        } else {
            throw new InvalidDataContentException("The given data flavor is not the data flavor supported.");
        }

        this.usecaseToolUtil = usecaseToolUtil;
    }

    /**
     * <p>
     * Simple getter for usecaseToolUtil attribute. This is used by children of class.
     * </p>
     *
     * @return usecaseToolUtil attribute, should not be null.
     */
    protected UsecaseToolUtil getUsecaseToolUtil() {
        return usecaseToolUtil;
    }

    /**
     * <p>
     * Simple getter for modelElement attribute. This is used by children of class.
     * </p>
     *
     * @return modelElement attribute, should not be null.
     */
    protected ModelElement getModelElement() {
        return modelElement;
    }

    /**
     * <p>
     * Simple getter for log attribute. This is used by children of class.
     * </p>
     *
     * @return Log attribute, should not be null.
     */
    protected Log getLog() {
        return log;
    }
}
