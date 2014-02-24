/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class implements the <code>TransientAction</code> interface, and it is responsible
 * for copying the polyline graph edge to the clipboard.
 * </p>
 * <p>
 * Note that if the provided clipboard is null, system clipboard is used instead.
 * </p>
 * <p>
 * Thread-safety: The internal state of its variables (polylineGraphEdge) could be
 * changed externally, so it is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class CopyPolylineAction implements TransientAction {

    /**
     * <p>
     * Represents the polyline graph edge to copy to clipboard in execute
     * method.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final GraphEdge polylineGraphEdge;

    /**
     * <p>
     * Represents the clipboard to copy the polyline graph edge in execute
     * method.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed
     * afterwards. Could be null if system-clipboard is used instead.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Create a new <code>CopyPolylineAction</code> with given polylineGraphEdge
     * and clipboard.
     * </p>
     * @param polylineGraphEdge
     *            polyline graph edge.
     * @param clipboard
     *            the clipboard to copy.
     * @throws llegalArgumentException if the polylineGraphEdge
     *          argument is null, or the polylineGraphEdge doesn't contain a Polyline
     *          object. in its contained attribute.
     */
    public CopyPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard) {
        // Validate the polylineGraphEdge
        Helper.validateGraphEdgeForPolylineAction(polylineGraphEdge);

        this.polylineGraphEdge = polylineGraphEdge;
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, copy the poly graph edge to the clipboard.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(this.polylineGraphEdge, this.clipboard);
    }
}
