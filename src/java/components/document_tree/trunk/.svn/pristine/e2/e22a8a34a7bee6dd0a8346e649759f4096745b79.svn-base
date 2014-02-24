/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 * <p>
 * This class implements the <code>Transferable</code> interface to transfer arrays of
 * <code>DocumentTreeNode</code> objects.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class DocumentTreeNodeArrayTransferable implements Transferable {
    /**
     * <p>
     * This variable represents the only data flavor supported by this transferable object.
     * </p>
     *
     * <p>
     * It is frozen as it will not change and it is static as it is common
     * to all instances of this class.
     * </p>
     */
    public static final DataFlavor DATA_FLAVOR = createDefaultDataFlavor();

    /**
     * <p>
     * Represents the data to be transferred.
     * </p>
     *
     * <p>
     * It is possibly null. May possibly contain null elements too.
     * </p>
     *
     * <p>
     * It is frozen as it will not change after initialization.
     * </p>
     *
     * <p>
     * It is set by the constructor and retrieved by the getTransferData method.
     * </p>
     */
    private final DocumentTreeNode[] transferData;

    /**
     * <p>
     * Creates this transferable as holding the given transfer data.
     * </p>
     *
     * @param transferData The data to be transferred. Possibly null.
     * May possibly contain null elements too.
     */
    public DocumentTreeNodeArrayTransferable(DocumentTreeNode[] transferData) {
        this.transferData = transferData;
    }

    /**
     * <p>
     * Gets the transfer data in the given flavor.
     * </p>
     *
     * @param dataFlavor The data flavor of the transfer data to return.
     * Must not be null.
     * @return the transfer data in the given flavor.
     *
     * @throws IllegalArgumentException If the flavor is null.
     * @throws UnsupportedFlavorException If the flavor is not supported.
     */
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException {
        if (!isDataFlavorSupported(dataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }

        return this.transferData;
    }

    /**
     * <p>
     * Returns the supported data flavors in an array.
     * </p>
     *
     * @return An array of supported data flavors.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {DATA_FLAVOR};
    }

    /**
     * <p>
     * Gets whether the given data flavor is supported.
     * </p>
     *
     * @param dataFlavor The data favor to check support for. Must not be null.
     * @return whether the given data flavor is supported
     *
     * @throws IllegalArgumentException If dataFlavor is null
     */
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        Util.checkNull(dataFlavor, "dataFlavor");

        return DATA_FLAVOR.equals(dataFlavor);
    }

    /**
     * <p>
     * Creates a default data flavor.
     * </p>
     *
     * <p>
     * The <code>DataFlavor</code> returned is the only data flavor supported by this transferable object.
     * </p>
     *
     * @return the default data flavor.
     */
    private static DataFlavor createDefaultDataFlavor() {
        try {
            return new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\""
                + DocumentTreeNode[].class.getName() + "\"");
        } catch (ClassNotFoundException e) {
            // this will never happen
            return null;
        }
    }
}
