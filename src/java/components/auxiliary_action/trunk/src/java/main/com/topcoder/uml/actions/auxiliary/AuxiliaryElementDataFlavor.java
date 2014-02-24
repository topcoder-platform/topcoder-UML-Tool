/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.DataFlavor;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;

/**
 * <p>
 * This class defines all the <code>DataFlavor</code> constants used in this design.
 * </p>
 * <p>
 * Thread-safe: As <code>DataFlavor</code> class is immutable, so this class is thread-safe,
 * and all its constants are immutable.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AuxiliaryElementDataFlavor {
    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>Comment</b>
     * cut/copy/paste actions.
     * </p>
     */
    public static final DataFlavor COMMENT = new DataFlavor(Comment.class, "Comment");

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>Noterelationship</b>
     * cut/copy/paste actions.
     * </p>
     */
    public static final DataFlavor NOTE_RELATIONSHIP = new DataFlavor(Comment.class,
            "NoteRelationship");

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>Comment GraphNode</b>
     * cut/copy/paste actions.
     * </p>
     *
     */
    public static final DataFlavor COMMENT_GRAPH_NODE = new DataFlavor(GraphNode.class,
            "CommentGraphNode");

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>Comment Relationship GraphEdge</b>
     * cut/copy/paste actions.
     * </p>
     */
    public static final DataFlavor COMMENT_RELATIONSHIP_GRAPH_EDGE = new DataFlavor(
            GraphEdge.class, "CommentRelationshipGraphEdge");

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>FreeText GraphNode</b>
     * cut/copy/paste actions.
     * </p>
     */
    public static final DataFlavor FREE_TEXT = new DataFlavor(GraphNode.class, "FreeText");

    /**
     * <p>
     * Represents the <code>DataFlavor</code> object for the <b>Polyline GraphNode</b>
     * cut/copy/paste actions.
     * </p>
     */
    public static final DataFlavor POLYLINE = new DataFlavor(GraphEdge.class, "Polyline");

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private AuxiliaryElementDataFlavor() {
    }
}
