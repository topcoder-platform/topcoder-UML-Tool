/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class TemplateArgumentImpl implements TemplateArgument {

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public TemplateArgumentImpl() {
    }

    /**
     * <p>
     * Represents The actual argument for the subject Binding..
     * </p>
     */
    private ModelElement modelElement;

    /**
     * Gets the ModelElement modelElement field value. Could be null.
     *
     * @return modelElement field value
     */
    public ModelElement getModelElement() {
        return this.modelElement;
    }

    /**
     * Sets the ModelElement modelElement field value. Null is allowed.
     *
     * @param modelElement
     *            modelElement field value
     */
    public void setModelElement(ModelElement modelElement) {
        this.modelElement = modelElement;
    }
}