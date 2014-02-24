/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.auxiliary.AbstractCutGraphElementAction;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractCutGraphElementAction</code> abstract class, and it
 * is responsible for removing the polyline graph edge from its contained
 * diagram graph node, and copying it to the clipboard.
 * </p>
 * <p>
 * Note that if the provided clipboard is null, system clipboard is used instead.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not thread-safe, it is not
 * thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class CutPolylineAction extends AbstractCutGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Cut Polyline";
    /**
     * <p>
     * Create a new <code>CutPolylineAction</code> with the child graph element to cut,
     * and the clipboard.
     * </p>
     * @param polylineGraphEdge
     *            the polyline graph edge.
     * @param clipboard
     *            the clipboard to copy.
     * @throws IllegalArgumentException if the polylineGraphEdge
     *          argument is null, or its container is null, or the polylineGraphEdge doesn't contain a Polyline
     *          object. in its contained attribute.
     */
    public CutPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard) {
        super(NAME, polylineGraphEdge, clipboard);
        // Validate the polylineGraphEdge
        Helper.validateGraphEdgeForPolylineAction(polylineGraphEdge);
    }

    /**
     * <p>
     * Copy the poly graph edge to the clipboard.
     * </p>
     * @param node
     *            the polyline graph edge.
     * @param clipboard
     *            the clipboard to copy.
     * @throws IllegalArgumentException If node is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    protected void copyToClipboard(GraphElement node, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyPolylineGraphEdge((GraphEdge) node, clipboard);
    }
}
