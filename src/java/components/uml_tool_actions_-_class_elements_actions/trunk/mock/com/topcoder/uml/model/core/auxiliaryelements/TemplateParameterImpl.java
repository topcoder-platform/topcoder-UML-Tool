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
public class TemplateParameterImpl implements TemplateParameter {

    /**
     * Mock attribute.
     */
    private ModelElement parameter;

    /**
     * Mock attribute.
     */
    private ModelElement defaultElement;

    /**
     * Mock attribute.
     */
    private ModelElement template;

    /**
     * Mock method. Could be null.
     *
     * @return parameter field value
     */
    public ModelElement getParameter() {
        return this.parameter;
    }

    /**
     * Mock method. Null is allowed.
     *
     * @param parameter
     */
    public void setParameter(ModelElement parameter) {
        this.parameter = parameter;
    }

    /**
     * Mock method. Could be null.
     *
     * @return defaultElement field value
     */
    public ModelElement getDefaultElement() {
        return this.defaultElement;
    }

    /**
     * Mock method. Null is allowed.
     *
     * @param defaultElement
     */
    public void setDefaultElement(ModelElement defaultElement) {
        this.defaultElement = defaultElement;
    }

    /**
     * Mock method. Could be null.
     *
     * @return template field value
     */
    public ModelElement getTemplate() {
        return this.template;
    }

    /**
     * Mock method. Null is allowed.
     *
     * @param template
     */
    public void setTemplate(ModelElement template) {
        this.template = template;
    }
}