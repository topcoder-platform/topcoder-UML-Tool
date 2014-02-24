/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.errorhandling.BaseException;;

/**
 * <p>
 * This exception is used to indicate some GraphEdge is illegal in specific situation. For example, an Association
 * GraphEdge is given to GeneralizationEdge constructor. It could be thrown when retrieving graph information from
 * GraphEdge.
 * </p>
 *
 * <p>
 * Because this exception may be thrown in many places of application, we make it as a runtime exception. The other
 * reason is that this exception can never happen in normal usage.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class IllegalGraphElementException extends BaseException {

    /**
     * <p>
     * Represents the illegal graphElement.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Maybe null, because we don't validate it in constructor.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Constructor with graphElement and error message.
     * </p>
     *
     * @param graphElement
     *            the illegal graphElement.
     * @param message
     *            error message
     */
    public IllegalGraphElementException(GraphElement graphElement, String message) {
        super(message);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Constructor with graphElement, error message, and inner cause.
     * </p>
     *
     * @param graphElement
     *            the illegal graphElement.
     * @param message
     *            error message
     * @param cause
     *            the inner cause of this exception.
     */
    public IllegalGraphElementException(GraphElement graphElement, String message, Throwable cause) {
        super(message, cause);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Getter of the illegal graphElement.
     * </p>
     *
     * @return the illegal graphElement.
     */
    public GraphElement getGraphElement() {
        return this.graphElement;
    }
}
