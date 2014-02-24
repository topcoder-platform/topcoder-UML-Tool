/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>
 * This exception is used to indicate some GraphNode or GraphEdge is illegal in specific situation. For example, a
 * UseCase GraphNode is given to ActorNode constructor. It could be thrown when retrieving graph information from
 * GraphNode or GraphEdge.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementException extends BaseRuntimeException {

    /**
     * <p>
     * Represents the illegal <code>graphElement</code>. Initialized in constructor, never changed later. Maybe null,
     * because we don't validate it in constructor.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Constructor with the illegal <code>graphElement</code> and error message.
     * </p>
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param graphElement the illegal <code>graphElement</code>
     * @param message error message
     */
    public IllegalGraphElementException(GraphElement graphElement, String message) {
        super(message);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Constructor with the illegal <code>graphElement</code>, error message, and inner cause.
     * </p>
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param graphElement the illegal <code>graphElement</code>
     * @param message error message
     * @param cause the inner cause of this exception
     */
    public IllegalGraphElementException(GraphElement graphElement, String message, Throwable cause) {
        super(message, cause);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Getter of the illegal <code>graphElement</code>.
     * </p>
     *
     * @return the illegal <code>graphElement</code>
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }
}
