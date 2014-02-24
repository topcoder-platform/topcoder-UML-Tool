/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import java.awt.datatransfer.Transferable;

/**
 * <p>
 * This class handles transfers in the document tree view component, irrespective of the
 * underlying implementation.
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its base class is not thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class DocumentTreeViewTransferHandler extends TransferHandler {
    /**
     * <p>
     * Holds the document tree tabbed pane from which the transfer is to take place.
     * </p>
     *
     * <p>
     * It is frozen as it will not change.
     * </p>
     *
     * <p>
     * It is set by the constructor and referred to by the sole protected method of this class.
     * </p>
     */
    private final DocumentTreeTabbedPane documentTreeTabbedPane;

    /**
     * <p>
     * Constructs this handler, to transfer from the given document tree tabbed pane.
     * </p>
     *
     * @param documentTreeTabbedPane The tabbed pane to transfer from. Must not be null.
     *
     * @throws IllegalArgumentException If documentTreeTabbedPane is null.
     */
    public DocumentTreeViewTransferHandler(DocumentTreeTabbedPane documentTreeTabbedPane) {
        Util.checkNull(documentTreeTabbedPane, "documentTreeTabbedPane");

        this.documentTreeTabbedPane = documentTreeTabbedPane;
    }

    /**
     * <p>
     * Creates the <code>Transferable</code> instance for dragging from the given JComponent.
     * </p>
     *
     * <p>
     * This method will wrap the selected tree nodes on the tree tabbed pane as a
     * <code>DocumentTreeNodeArrayTransferable</code> for dragging.
     * </p>
     *
     * @param component The JComponent being dragged from.
     * @return the transferable for dragging from the given JComponent.
     */
    protected Transferable createTransferable(JComponent component) {
        return new DocumentTreeNodeArrayTransferable(documentTreeTabbedPane.getSelectedTreeNodes());
    }

    /**
     * <p>
     * Returns the type of transfer actions supported by the source.
     * </p>
     *
     * <p>
     * Always return COPY to allow dragging.
     * </p>
     *
     * @param c
     *            the component holding the data to be transferred
     * @return <code>COPY</code>
     */
    public int getSourceActions(JComponent c) {
        return COPY;
    }
}
