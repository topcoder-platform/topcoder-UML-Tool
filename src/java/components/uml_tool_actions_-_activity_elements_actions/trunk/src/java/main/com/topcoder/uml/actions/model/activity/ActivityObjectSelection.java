/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

/**
 * <p>
 * ActivityObjectSelection class implements the Transferable interface, and it is used to transfer the
 * activity objects (which are serializable) to the clipboard.
 * </p>
 *
 * <p>
 * This class is used by all cut/copy actions in this design.
 * </p>
 *
 * <p>
 * Thread Safety: This class is immutable, but its obj variable maybe changed externally,
 * so it is not guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class ActivityObjectSelection implements Transferable {
    /**
     * <p>
     * Represents the Serializable object to transfer to the clip board.
     * </p>
     *
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null object.
     * </p>
     *
     * <p>
     * Returned in the getTransferData method.
     * </p>
     */
    private final Serializable obj;

    /**
     * <p>
     * Represents the DataFlavor object to identify the object transferred to the clip board.
     * </p>
     *
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null object.
     * </p>
     */
    private final DataFlavor dataFlavor;

    /**
     * <p>
     * Construct an ActivityObjectSelection with the serializable object and the data flavor specified.
     * </p>
     *
     * @param obj the Serializable object to transfer to the clip board
     * @param dataFlavor the DataFlavor object to identify the object transferred to the clip board
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public ActivityObjectSelection(Serializable obj, DataFlavor dataFlavor) {
        Util.checkNull(obj, "obj");
        Util.checkNull(dataFlavor, "dataFlavor");

        this.obj = obj;
        this.dataFlavor = dataFlavor;
    }

    /**
     * <p>
     * Return all supported DataFlavor objects.
     * </p>
     *
     * @return all supported DataFlavor objects
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {dataFlavor};
    }

    /**
     * <p>
     * Returns whether or not the specified data flavor is supported for this object.
     * </p>
     *
     * <p>
     * Note, the representation class and human presentable name are used to check
     * whether the given data flavor is supported or not.
     * </p>
     *
     * @param flavor the DataFlavor object to check.
     * @return whether or not the specified data flavor is supported for this object.
     *
     * @throws IllegalArgumentException if the argument is null
     */
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        Util.checkNull(flavor, "flavor");

        return dataFlavor.getRepresentationClass().equals(flavor.getRepresentationClass())
            && dataFlavor.getHumanPresentableName().equals(flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Returns an object which represents the data to be transferred.
     * </p>
     *
     * <p>
     * Note, the class of the object returned is defined by the representation
     * class of the flavor.
     * </p>
     *
     * @param flavor the requested flavor for the data
     * @return an object which represents the data to be transferred
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws IOException if any IO error
     * @throws UnsupportedFlavorException if the requested data flavor is not supported
     */
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }

        return obj;
    }
}
