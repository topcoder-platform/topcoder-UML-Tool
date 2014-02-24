/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.io.Serializable;

/**
 * <p>
 * Every GraphElement has an associated semantic model, represented by a concrete implementation of this
 * class. This version of Diagram Interchange provide 3 concrete classes: SimpleSemanticModelElement,
 * Uml1SemanticModelBridge and CoreSemanticModelBridge. Some Elements have different standard presentations.
 * For example, an actor can be represented by a rectangle or by a stickman. In order to distinguish these
 * cases, you can set the presentation attribute.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is abstract but has no abstract methods. This class is mutable and is not
 * thread-safe, since thread safety is not required. Instead, the calling application is required to ensure
 * thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public abstract class SemanticModelBridge implements Serializable {

    /**
     * <p>
     * Represents the presentation of the GraphElement associated to this SemanticModelBridge. Can be null.
     * Can be empty. Default to null.
     * </p>
     */
    private String presentation;

    /**
     * <p>
     * Represents the diagram associated with this SemanticModelBridge. Can be null. Default to null.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * Represents the GraphElement associated to this SemanticModelBridge. Can be null. Default to null.
     * </p>
     */
    private GraphElement graphElement;

    /**
     * <p>
     * Creates an instance of SemanticModelBridge.
     * </p>
     */
    protected SemanticModelBridge() {
        // empty constructor
    }

    /**
     * <p>
     * Gets the presentation of the GraphElement associated to this SemanticModelBridge.
     * </p>
     *
     * @return the presentation of the GraphElement associated to this SemanticModelBridge
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * <p>
     * Sets the presentation of the GraphElement associated to this SemanticModelBridge. Can be null. Can be
     * empty.
     * </p>
     *
     * @param presentation the presentation of the GraphElement associated to this SemanticModelBridge
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    /**
     * <p>
     * Gets the diagram associated with this SemanticModelBridge.
     * </p>
     *
     * @return the diagram associated with this SemanticModelBridge
     */
    public Diagram getDiagram() {
        return diagram;
    }

    /**
     * <p>
     * Sets the diagram associated with this SemanticModelBridge. Can be null.
     * </p>
     *
     * @param diagram the diagram associated with this SemanticModelBridge
     */
    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }

    /**
     * <p>
     * Gets the GraphElement associated to this SemanticModelBridge.
     * </p>
     *
     * @return the GraphElement associated to this SemanticModelBridge
     */
    public GraphElement getGraphElement() {
        return graphElement;
    }

    /**
     * <p>
     * Sets the GraphElement associated to this SemanticModelBridge. Can be null.
     * </p>
     *
     * @param graphElement the GraphElement associated to this SemanticModelBridge
     */
    public void setGraphElement(GraphElement graphElement) {
        this.graphElement = graphElement;
    }
}