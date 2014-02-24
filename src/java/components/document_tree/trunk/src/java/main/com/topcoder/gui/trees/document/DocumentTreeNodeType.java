/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This class enumerates the different types of nodes in the document tree view.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it has no state.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public enum DocumentTreeNodeType {
    /**
     * <p>
     * This enum instance represents a node type of <code>GraphElement</code>.
     * </p>
     */
    GRAPH_ELEMENT,

    /**
     * <p>
     * This enum instance represents a node type of <code>ModelElement</code>.
     * </p>
     */
    MODEL_ELEMENT,

    /**
     * <p>
     * This enum instance represents a node type of diagram category.
     * </p>
     */
    DIAGRAM_CATEGORY;

    /**
     * <p>
     * Constructs an instance of a node type.
     * </p>
     *
     * <p>
     * Note, it is private as this class is an enum and this object will
     * not be instantiated externally.
     * </p>
     */
    private DocumentTreeNodeType() {
        // empty
    }
}
