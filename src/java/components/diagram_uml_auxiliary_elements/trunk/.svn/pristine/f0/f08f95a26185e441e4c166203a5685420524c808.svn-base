/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.util.errorhandling.BaseRuntimeException;


/**
 * <p>
 * This exception is used to indicate some <code>GraphNode</code> is illegal in specific situation.
 * For example, a name compartment <code>GraphNode</code> is given to stereotype compact constructor.
 * It could be thrown from the constructors which accepts a <code>GraphNode</code> as parameter.
 * </p>
 *
 * <p>
 * Because this exception may be thrown in many places of application,
 * we make it as a runtime exception.
 * The other reason is that this exception can never happen in normal usage.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphNodeException extends BaseRuntimeException {
    /**
     * <p>
     * Represents the illegal graphNode.
     * Initialized in constructor, never changed later.
     * Maybe <code>null</code>, because we don't validate it in constructor.
     * </p>
     */
    private final GraphNode graphNode;

    /**
     * <p>
     * Creates a new instance of <code>IllegalGraphNodeException</code> class with the graphNode
     * and a detail error message.
     * </p>
     *
     * @param graphNode - the illegal grpah node.
     * @param message - error message
     */
    public IllegalGraphNodeException(GraphNode graphNode, String message) {
        super(message);
        this.graphNode = graphNode;
    }

    /**
     * <p>
     * Creates a new instance of <code>ConfigurationException</code> class with the graphNode
     * , a detail error message and the original exception causing the error.
     * </p>
     *
     * @param graphNode - the illegal grpah node.
     * @param message - error message
     * @param cause - the inner cause of this exception.
     */
    public IllegalGraphNodeException(GraphNode graphNode, String message, Throwable cause) {
        super(message, cause);
        this.graphNode = graphNode;
    }

    /**
     * <p>
     * Gets the the illegal graphNode.
     * </p>
     *
     * @return the illegal graphNode.
     */
    public GraphNode getGraphNode() {
        return this.graphNode;
    }
}
