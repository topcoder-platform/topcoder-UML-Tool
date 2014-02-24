/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.undo.AbstractUndoableEdit;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This abstract class extends from {@linkplain AbstractUndoableEdit} and implements
 * {@linkplain UndoableAction}. It is base for all message actions(except <code>CopyMessageAction</code>).
 * It contain two common attributes - {@link Stimulus} instance and instance of {@link MessageUtil}
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class MessageUndoableAction extends AbstractUndoableEdit implements UndoableAction {

    /**
     * <p>
     * Represents stimulus instance for current action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Stimulus stimulus;

    /**
     * <p>
     * Represents messageUtil instance for current action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final MessageUtil messageUtil = new MessageUtil();

    /**
     * <p>
     * Represents Log instance for current action.
     * </p>
     */
    private final Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * <p>
     * Constructs the MessageUndoableAction the given <code>stimulus</code>.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the stimulus is <code>null</code>.
     */
    protected MessageUndoableAction(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUndoableAction#MessageUndoableAction");
        this.stimulus = stimulus;
    }

    /**
     * <p>
     * Constructs the MessageUndoableAction using the <code>transferable</code> and <code>dataFlavor</code>.
     * The stimulus is retrieved using {@linkplain Transferable#getTransferData(DataFlavor)}.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param dataFlavor
     *            DataFlavor instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>transferable, dataFlavor</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if transferable contains incorrect data flavor
     */
    protected MessageUndoableAction(Transferable transferable, DataFlavor dataFlavor)
        throws SequenceConfigurationException {
        // check if transferable is null
        Helper.checkObjectNotNull(transferable, "transferable in MessageUndoableAction#MessageUndoableAction");
        // check if dataFlavor is null
        Helper.checkObjectNotNull(dataFlavor, "dataFlavor in MessageUndoableAction#MessageUndoableAction");
        try {
            stimulus = (Stimulus) transferable.getTransferData(dataFlavor);
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
     * Returns the stimulus for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return stimulus attribute, Cannot be <code>null</code>
     */
    protected Stimulus getStimulus() {
        return stimulus;
    }

    /**
     * <p>
     * Returns the messageUtil for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return messageUtil attribute, Cannot be <code>null</code>
     */
    protected MessageUtil getMessageUtil() {
        return messageUtil;
    }

    /**
     * <p>
     * Returns the log for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return Log attribute, Cannot be <code>null</code>
     */
    protected Log getLog() {
        return log;
    }
}
