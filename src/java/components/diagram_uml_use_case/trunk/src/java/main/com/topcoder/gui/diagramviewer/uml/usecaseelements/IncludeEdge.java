/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.diagraminterchange.GraphEdge;

/**
 * <p>
 * This class represents an Include edge in UML diagram. It is an extension of BaseEdge, which defines all features
 * required by an Include edge. The only specific configuration of Include edge is keyword metaclass. Keyword metaclass
 * value for Include edge is defined as "include".
 * </p>
 * <p>
 * The structure of the GraphEdge that corresponds to an Include is as follows:
 * </p>
 * <p>
 * Uml1SemanticModelBridge.element = UML:Include
 *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
 *   SimpleSemanticModelElement.typeInfo = "Name"
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is not thread safe, because the BaseEdge class is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class IncludeEdge extends BaseEdge {

    /**
     * <p>
     * Constant field. Represents the keyword metaclass of include edge. It will be displayed in stereotype compartment.
     * </p>
     */
    public static final String KEYWORD_METACLASS = "include";

    /**
     * <p>
     * Construct an instance of IncludeEdge which represents an include edge.
     * </p>
     *
     * @param graphEdge the graphEdge representing this edge.
     * @throws IllegalArgumentException if <code>graphEdge</code> is null.
     * @throws IllegalGraphElementException if <code>graphEdge</code> has bad structure.
     */
    public IncludeEdge(GraphEdge graphEdge) throws IllegalGraphElementException {
        super(graphEdge, KEYWORD_METACLASS);
    }
}
