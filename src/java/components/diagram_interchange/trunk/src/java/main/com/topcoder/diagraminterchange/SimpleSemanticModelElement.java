/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * SimpleSemanticModelElement is the semantic model of the elements that have no corresponding semantic model
 * element in UML.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class SimpleSemanticModelElement extends SemanticModelBridge {

    /**
     * <p>
     * Represents the type information of the GraphElement or Diagram associated to this
     * SimpleSemanticModelElement. Can be null. Can be empty. Default to null.
     * </p>
     */
    private String typeInfo;

    /**
     * <p>
     * Creates an instance of SimpleSemanticModelElement.
     * </p>
     */
    public SimpleSemanticModelElement() {
        super();
    }

    /**
     * <p>
     * Gets the type information of the GraphElement or Diagram associated to this SimpleSemanticModelElement.
     * </p>
     *
     * @return the type information of the GraphElement or Diagram associated to this
     *         SimpleSemanticModelElement
     */
    /*
     * Bugfix: UML-9503
     * typeinfo is changed to typeInfo
     */
    public String getTypeInfo() {
        return typeInfo;
    }

    /**
     * <p>
     * Sets the type information of the GraphElement or Diagram associated to this SimpleSemanticModelElement.
     * Can be null.
     * </p>
     *
     * @param typeInfo the type information of the GraphElement or Diagram associated to this
     *        SimpleSemanticModelElement
     */
    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }
}