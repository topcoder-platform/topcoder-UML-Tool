/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.undo.AbstractUndoableEdit;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This abstract class extends from {@linkplain AbstractUndoableEdit} and implements
 * {@linkplain UndoableAction}. It is base for all undoable Object actions (except {@link CopyObjectAction})
 * and contains their common methods and attributes
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class ObjectUndoableAction extends AbstractUndoableEdit implements UndoableAction {

    /**
     * <p>
     * Represents Object instance for current action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Object object;

    /**
     * <p>
     * Represents objectUtil instance for current action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final ObjectUtil objectUtil = new ObjectUtil();

    /**
     * <p>
     * Represents Log instance for current action.
     * </p>
     */
    private final Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * <p>
     * Constructs the <code>ObjectUndoableAction</code> with the given object.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    protected ObjectUndoableAction(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUndoableAction#ObjectUndoableAction");
        this.object = object;
    }

    /**
     * <p>
     * Constructs the ObjectUndoableAction using the <code>transferable</code>. The object is retrieved
     * using {@linkplain Transferable#getTransferData(DataFlavor)}, where Data flavor corresponds to
     * <code>CollaborationTransfer.OBJECT_FLAVOR</code>
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>transferable</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if transferable contains incorrect data flavor
     */
    protected ObjectUndoableAction(Transferable transferable) throws SequenceConfigurationException {
        // check if transferable is null
        Helper.checkObjectNotNull(transferable, "transferable in ObjectUndoableAction#ObjectUndoableAction");
        try {
            this.object = (Object) transferable.getTransferData(CollaborationTransfer.OBJECT_FLAVOR);
        } catch (UnsupportedFlavorException e) {
            throw new SequenceConfigurationException(
                "The data flavor is not supported by the transferable instance", e);
        } catch (IOException e) {
            throw new SequenceConfigurationException(
                "The requested data in the transferable is no longer available in the requested flavor.", e);
        }
    }

    /**
     * <p>
     * Returns the object for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return object attribute, Will not be <code>null</code>.
     */
    protected Object getObject() {
        return object;
    }

    /**
     * <p>
     * Returns the objectUtil for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return objectUtil attribute, Will not be <code>null</code>.
     */
    protected ObjectUtil getObjectUtil() {
        return objectUtil;
    }

    /**
     * <p>
     * Returns the log attribute. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return Log attribute, Will not be <code>null</code>.
     */
    protected Log getLog() {
        return log;
    }
}
