/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.errorhandling.BaseRuntimeException;

/**
 * <p>
 * This exception is used to indicate some <code>GraphNode</code> or <code>GraphEdge</code> is illegal in specific
 * situation. It could be thrown when retrieving graph information from <code>GraphNode</code> or
 * <code>GraphEdge</code>.
 * </p>
 * <p>
 * It is a runtime exception since this exception may be thrown in many places of application, and it can never be
 * thrown in normal usage. This exception is thrown from many places in this package.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementException extends BaseRuntimeException {

    /**
     * <p>
     * Represents the illegal graph element.
     * </p>
     * <p>
     * Initialized in the constructor, never changed later, can be retrieved by <code>getGraphElement()</code>. Can
     * be null.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Creates an <code>IllegalGraphElementException</code> instance.
     * </p>
     * @param graphElement
     *            the illegal graphElement.
     * @param msg
     *            error message
     */
    public IllegalGraphElementException(GraphElement graphElement, String msg) {
        super(msg);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Creates an instance of <code>IllegalGraphElementException</code>
     * </p>
     * @param graphElement
     *            the illegal graphElement.
     * @param msg
     *            error message
     * @param cause
     *            the inner cause of this exception.
     */
    public IllegalGraphElementException(GraphElement graphElement, String msg, Throwable cause) {
        super(msg, cause);
        this.graphElement = graphElement;
    }

    /**
     * <p>
     * Getter of the illegal graph element.
     * </p>
     * @return the illegal graph element.
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }
}
