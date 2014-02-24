/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * <p>
 * This is a mocked implementation of Transferable.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class TransferableImpl implements Transferable {

    /**
     * <p>
     * This is a mocked method.
     * </p>
     *
     * @param dataFlavor the parameter
     * @throws UnsupportedFlavorException never
     * @throws IOException never
     * @return null always
     */
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        return null;
    }

    /**
     * <p>
     * This is a mocked method.
     * </p>
     *
     * @return null always
     */
    public DataFlavor[] getTransferDataFlavors() {
        return null;
    }

    /**
     * <p>
     * This is a mocked method.
     * </p>
     *
     * @param dataFlavor the parameter
     * @return false always
     */
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        return false;
    }
}
