/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Element;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * This class is used for transporting model elements through a system clipboard. It contains 7 custom
 * {@link DataFlavor} instances - each element has its own {@link DataFlavor}. This is needed for the
 * creation of paste action for different elements. This Class also implement interface {@link ClipboardOwner}
 * for providing the ability to be owner for the elements in clipboard. It has two public constructors for
 * setting different types of data flavors without using instanceof operator.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class CollaborationTransfer implements ClipboardOwner, Transferable {

    /**
     * <p>
     * Represents DataFlavor for Object implementation.
     * </p>
     */
    public static final DataFlavor OBJECT_FLAVOR = new DataFlavor(Object.class,
        "Represents DataFlavor for Object implementation");

    /**
     * <p>
     * Represents DataFlavor for Asynchronous message.
     * </p>
     */
    public static final DataFlavor ASYNCHRONOUS_MESSAGE_FLAVOR = new DataFlavor(Stimulus.class,
        "Represents DataFlavor for Asynchronous message");

    /**
     * <p>
     * Represents DataFlavor for Create message type.
     * </p>
     */
    public static final DataFlavor CREATE_MESSAGE_FLAVOR = new DataFlavor(Stimulus.class,
        "Represents DataFlavor for Create message type");

    /**
     * <p>
     * Represents DataFlavor for Return message type.
     * </p>
     */
    public static final DataFlavor RETURN_MESSAGE_FLAVOR = new DataFlavor(Stimulus.class,
        "Represents DataFlavor for Return message type");

    /**
     * <p>
     * Represents DataFlavor for Send Signal message type.
     * </p>
     */
    public static final DataFlavor SEND_SIGNAL_MESSAGE_FLAVOR = new DataFlavor(Stimulus.class,
        "Represents DataFlavor for Send Signal message type");

    /**
     * <p>
     * Represents DataFlavor for Synchronous message type.
     * </p>
     */
    public static final DataFlavor SYNCHRONOUS_MESSAGE_FLAVOR = new DataFlavor(Stimulus.class,
        "Represents DataFlavor for Synchronous message type");

    /**
     * <p>
     * Represents one of possible values for data flavor objects. Cannot be <code>null</code>, set in
     * constructor
     * </p>
     */
    private final Element element;

    /**
     * <p>
     * Represents supported DataFlavor for current instance of this class. Cannot be <code>null</code> and it is set
     * in constructor. This will contain one of static data flavor of this class.
     * </p>
     */
    private final DataFlavor currentFlavor;

    /**
     * <p>
     * Constructs the Collaboration Transfer for the Object instance. The Current Flavor is set to
     * {@linkplain #OBJECT_FLAVOR}.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>.
     */
    public CollaborationTransfer(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in CollaborationTransfer#CollaborationTransfer");
        this.element = object;
        this.currentFlavor = OBJECT_FLAVOR;
    }

    /**
     * <p>
     * Constructs the Collaboration Transfer for the Stimulus instance. The Current Flavor is set depending on
     * the type of the message. The type of the stimulus is determined by using the utility methods in the
     * <code>MessageUtil</code> class.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code> or it is not a valid message type.
     */
    public CollaborationTransfer(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in CollaborationTransfer#CollaborationTransfer");
        this.element = stimulus;
        MessageUtil messageUtil = new MessageUtil();
        if (messageUtil.checkAsynchronousMessage(stimulus)) {
            currentFlavor = ASYNCHRONOUS_MESSAGE_FLAVOR;
        } else if (messageUtil.checkCreateMessage(stimulus)) {
            currentFlavor = CREATE_MESSAGE_FLAVOR;
        } else if (messageUtil.checkReturnMessage(stimulus)) {
            currentFlavor = RETURN_MESSAGE_FLAVOR;
        } else if (messageUtil.checkSendSignalMessage(stimulus)) {
            currentFlavor = SEND_SIGNAL_MESSAGE_FLAVOR;
        } else if (messageUtil.checkSynchronousMessage(stimulus)) {
            currentFlavor = SYNCHRONOUS_MESSAGE_FLAVOR;
        } else {
            throw new IllegalArgumentException("The stimulus is not of the data flavors supported by this class");
        }
    }

    /**
     * <p>
     * Notifies this object that it is no longer the clipboard owner. This method will be called when another
     * application or another object within this application asserts ownership of the clipboard.
     * </p>
     *
     * @param clipboard
     *            Clipboard instance, not null
     * @param transferable
     *            Transferable instance, not null
     * @throws IllegalArgumentException
     *             if the clipboard or transferable is <code>null</code>.
     */
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in CollaborationTransfer#lostOwnership");
        // check if transferable is null
        Helper.checkObjectNotNull(transferable, "transferable in CollaborationTransfer#lostOwnership");
        LogFactory.getLog().log(
            Level.INFO,
            "The clipboard '" + clipboard.getName() + "' lost ownership of the transferable data '"
                    + transferable.getTransferDataFlavors()[0].getHumanPresentableName() + "'");
    }

    /**
     * <p>
     * Returns the currentFlavour in an array form.
     * </p>
     *
     * @return array with 1 element which contains the {@linkplain #currentFlavor} of this instance.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {currentFlavor };
    }

    /**
     * <p>
     * Checks whether the given DataFlavor instance is supported by this instance.
     * </p>
     *
     * @param dataFlavor
     *            Some DataFlavor instance, Cannot be <code>null</code>
     * @return true if this given dataFlavor is equal to current flavor, otherwise returns false
     * @throws IllegalArgumentException
     *             if the dataFlavor is <code>null</code>.
     */
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        // check if dataFlavor is null
        Helper.checkObjectNotNull(dataFlavor, "dataFlavor in CollaborationTransfer#isDataFlavorSupported");
        return dataFlavor == currentFlavor;
    }

    /**
     * <p>
     * Returns the element attribute of the flavor.
     * </p>
     *
     * @param dataFlavor
     *            Some DataFlavor instance, Cannot be <code>null</code>
     * @return element attribute
     * @throws UnsupportedFlavorException
     *             if the given data flavor is not supported
     * @throws IllegalArgumentException
     *             if the <code>dataFlavor</code> is <code>null</code>.
     */
    public java.lang.Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException {
        // check if dataFlavor is null
        Helper.checkObjectNotNull(dataFlavor, "dataFlavor in CollaborationTransfer#getTransferData");
        if (!isDataFlavorSupported(dataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        return element;
    }

}
