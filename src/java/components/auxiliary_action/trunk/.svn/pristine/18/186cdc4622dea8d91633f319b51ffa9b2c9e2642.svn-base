/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

/**
 * <p>
 * This class implements the <code>Transferable</code> interface, and it is used to
 * transfer the auxiliary objects (which are serializable) to the clipboard.
 * </p>
 * <p>
 * Thread-safety: This class is immutable, but its obj variable maybe changed
 * externally, so it is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AuxiliaryElementSelection implements Transferable {

    /**
     * <p>
     * Represents the <code>Serializable</code> object to transfer to the clip board.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null object.
     * </p>
     */
    private final Serializable obj;

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object to identify the object transferred to
     * the clip board.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed afterwards.
     * It must be non-null object.
     * </p>
     */
    private final DataFlavor dataFlavor;

    /**
     * <p>
     * Create a new <code>AuxiliaryElementSelection</code> with given serializable
     * object and the data flavor.
     * </p>
     * @param obj
     *            the Serializable object to transfer to the clip board
     * @param dataFlavor
     *            the <code>DataFlavor</code> object to identify the object transferred to
     *            the clip board
     * @throws IllegalArgumentException If any argument is null.
     */
    public AuxiliaryElementSelection(Serializable obj, DataFlavor dataFlavor) {
        if (obj == null) {
            throw new IllegalArgumentException("obj cannot be null!");
        }
        if (dataFlavor == null) {
            throw new IllegalArgumentException("dataFlavor cannot be null!");
        }
        this.obj = obj;
        this.dataFlavor = dataFlavor;
    }

    /**
     * <p>
     * Return all supported <code>DataFlavor</code> objects.
     * </p>
     * <p>
     * Note that here, only one <code>DataFlavor</code> will be returned.
     * </p>
     * @return all supported <code>DataFlavor</code> objects.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {this.dataFlavor};
    }

    /**
     * <p>
     * Returns whether or not the specified data flavor is supported for this
     * object.
     * </p>
     * @param flavor
     *            the <code>DataFlavor</code> object to check.
     * @return whether or not the specified data flavor is supported for this
     *         object.
     * @throws IllegalArgumentException If flavor is null.
     */
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        if (flavor == null) {
            throw new IllegalArgumentException("flavor cannot be null!");
        }
        return this.dataFlavor.equals(flavor)
            && this.dataFlavor.getHumanPresentableName().equals(flavor.getHumanPresentableName());
    }

    /**
     * <p>
     * Returns an object which represents the data to be transferred.
     * </p>
     * <p>
     * The class of the object returned is defined by the representation class of the
     * flavor.
     * </p>
     * @param flavor
     *            the requested flavor for the data
     * @return an object which represents the data to be transferred
     * @throws IllegalArgumentException If flavor is null.
     * @throws UnsupportedFlavorException If the requested data flavor is not supported.
     * @throws IOException If the data is no longer available in the requested flavor, note that
     *          it will never happen in this specific implementation.
     */
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (this.isDataFlavorSupported(flavor)) {
            return this.obj;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
