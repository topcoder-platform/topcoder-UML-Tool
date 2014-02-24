/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.event.MouseEvent;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class represents a Class node (with default 'Exception' stereotype) in UML diagram. It is an extension of
 * ClassNode, which defines the most features for a node. This class only provides some specific methods to support the
 * mouse events processing.
 * </p>
 * <p>
 * This class is not thread safe, because the ClassNode class is not thread safe.
 * </p>
 * <p>
 * This node is almost the same with ClassNode. Even the same element from UML Model is used (Class). Therefore, only
 * consumeEvent and constructor are overridden.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class ExceptionNode extends ClassNode {

    /**
     * <p>
     * Creates an ExceptionNode.
     * </p>
     * @param graphNode
     *            the graphNode representing this ExceptionNode
     * @param properties
     *            the properties name mapping
     */
    public ExceptionNode(GraphNode graphNode, Map<String, String> properties) {
        super(graphNode, properties);
    }

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element. The concrete edge type checking
     * is implemented here.
     * </p>
     * @param event
     *            the mouse event
     * @return a flag indicating whether the event is consumed
     */
    protected boolean consumeEvent(MouseEvent event) {
        return super.consumeEvent(event);
    }
}
