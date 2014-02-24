/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>
 * This exception is used to indicate some GraphNode is illegal in a specific situation. For example, an Interface
 * GraphNode is given to EnumerationNode constructor. It could be thrown when retrieving graph information from
 * GraphNode.
 * </p>
 * <p>
 * Because this exception may be thrown in many places of application, we make it as a runtime exception. The other
 * reason is that this exception can never happen in normal usage.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * <p>
 * This exception is thrown from many places in this package.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementException extends BaseRuntimeException {

    /**
     * <p>
     * Represents the illegal graphElement. Initialized in constructor, never changed later. Maybe null, because we
     * don't validate it in constructor.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Creates an <code>IllegalGraphElementException</code> instance.
     * </p>
     * @param graphElement
     *            the illegal graphElement
     * @param message
     *            error message
     */
    public IllegalGraphElementException(GraphElement graphElement, String message) {
        super(message);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Creates an <code>IllegalGraphElementException</code> instance.
     * </p>
     * @param graphElement
     *            the illegal graphElement
     * @param message
     *            error message
     * @param cause
     *            the inner cause of this exception
     */
    public IllegalGraphElementException(GraphElement graphElement, String message, Throwable cause) {
        super(message, cause);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Getter of the illegal graphElement.
     * </p>
     * @return the illegal graphElement
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }
}
