/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This utility class is used to copy specific auxiliary element to the
 * clipboard.
 * </p>
 * <p>
 * It is used by all the cut/copy actions, the clipboard argument of
 * all the <code>copyXXX</code> methods could be null, and in this case,
 * the system clipboard retrieved from <code>Toolkit.getDefaultToolkit().getSystemClipboard()</code>
 * is used instead.
 * </p>
 * <p>
 * Thread-safe: this class is stateless and thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AuxiliaryElementClipboardUtility {
    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private AuxiliaryElementClipboardUtility() {
    }

    /**
     * <p>
     * Copy the comment object to the clipboard.
     * </p>
     * @param comment
     *            the comment to copy to clipboard.
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If comment is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyComment(Comment comment, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE comment will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the comment
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.cloneComment(comment),
                    AuxiliaryElementDataFlavor.COMMENT);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the note relationship object to the clipboard.
     * </p>
     * @param comment
     *            the comment to copy to clipboard.
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If comment is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyNoteRelationship(Comment comment, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE comment will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the comment
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.cloneComment(comment),
                    AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the comment graph node to the clipboard.
     * </p>
     * @param node
     *            the comment graph node to copy
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If node is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyCommentGraphNode(GraphNode node, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE node will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the node
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.cloneCommentGraphNode(node),
                    AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the note relationship to the clipboard.
     * </p>
     * @param edge
     *            the comment graph edge to copy.
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If edge is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyCommentRelationshipGraphEdge(GraphEdge edge, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE edge will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the edge
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.cloneCommentRelationshipGraphEdge(edge),
                    AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the free text graph node to the clipboard.
     * </p>
     * @param node
     *            the free text graph node to copy.
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If node is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyFreeTextGraphNode(GraphNode node, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE node will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the node
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.cloneFreeTextGraphNode(node),
                    AuxiliaryElementDataFlavor.FREE_TEXT);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the polyline graph edge to the clipboard.
     * </p>
     * @param edge
     *            the polyline graph node to copy.
     * @param clipboard
     *            the clipboard to copy to.
     * @throws IllegalArgumentException If edge is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public static void copyPolylineGraphEdge(GraphEdge edge, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        // NOTE edge will be validated by the AuxiliaryElementCloneUtility class
        // Create an AuxiliaryElementSelection with the clone of the edge
        AuxiliaryElementSelection selection =
            new AuxiliaryElementSelection(AuxiliaryElementCloneUtility.clonePolylineGraphEdge(edge),
                    AuxiliaryElementDataFlavor.POLYLINE);
        // Copy to the clipboard
        copyToClipboard(selection, clipboard);
    }

    /**
     * <p>
     * Copy the given <code>AuxiliaryElementSelection</code> object to the clipboard, if the
     * passed in clipboard is null, the system clipboard will be used instead.
     * </p>
     * @param selection The object to copy.
     * @param clipboard the clipboard to copy to.
     * @throws ActionExecutionException If error occurs while performing the copy operation,
     *          (e.g. fails to get the system clipboard).
     */
    private static void copyToClipboard(AuxiliaryElementSelection selection, Clipboard clipboard)
        throws ActionExecutionException {
        try {
            clipboard = clipboard == null ? Toolkit.getDefaultToolkit().getSystemClipboard() : clipboard;
            clipboard.setContents(selection, null);
        } catch (Throwable t) {
            // note that AWTError might be thrown in Toolkit.getDefaultToolkit().getSystemClipboard(),
            // so here we try to catch Throwable instead of Exception
            throw new ActionExecutionException("Error occurs while performing the copy operation!", t);
        }
    }
}
