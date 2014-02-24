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
public interface TemplateParameter {
    /**
     * Gets the ModelElement parameter field value. Could be null.
     *
     * @return parameter field value
     */
    public ModelElement getParameter();

    /**
     * Sets the ModelElement parameter field value. Null is allowed.
     *
     * @param parameter
     *            parameter field value
     */
    public void setParameter(ModelElement parameter);

    /**
     * Gets the ModelElement defaultElement field value. Could be null.
     *
     * @return defaultElement field value
     */
    public ModelElement getDefaultElement();

    /**
     * Sets the ModelElement defaultElement field value. Null is allowed.
     *
     * @param defaultElement
     *            defaultElement field value
     */
    public void setDefaultElement(ModelElement defaultElement);

    /**
     * Gets the ModelElement template field value. Could be null.
     *
     * @return template field value
     */
    public ModelElement getTemplate();

    /**
     * Sets the ModelElement template field value. Null is allowed.
     *
     * @param template
     *            template field value
     */
    public void setTemplate(ModelElement template);
}