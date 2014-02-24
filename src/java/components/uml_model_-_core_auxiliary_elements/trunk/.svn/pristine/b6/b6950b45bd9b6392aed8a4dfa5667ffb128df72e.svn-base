/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import java.io.Serializable;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>Simple, base interface. Defines the relationship between a template (a ModelElement) and its
 * parameter (a ModelElement). A ModelElement with at least one templateParameter association is
 * a template (by definition). In the metamodel, TemplateParameter reifies the relationship between
 * a ModelElement that is a template and a ModelElement that is a dummy placeholder for a template
 * argument.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface TemplateParameter extends Serializable {
    /**
     * Gets the parameter field value. Could be null.
     *
     *
     * @return parameter field value
     */
    ModelElement getParameter();

    /**
     * Sets the parameter field value. Null is allowed.
     *
     *
     * @param parameter parameter field value
     */
    void setParameter(ModelElement parameter);

    /**
     * Gets the default element field value. Could be null.
     *
     *
     * @return defaultElement field value
     */
    ModelElement getDefaultElement();

    /**
     * Sets the default element field value. Null is allowed.
     *
     *
     * @param defaultElement defaultElement field value
     */
    void setDefaultElement(ModelElement defaultElement);

    /**
     * Gets the template field value. Could be null.
     *
     *
     * @return template field value
     */
    ModelElement getTemplate();

    /**
     * Sets the template field value. Null is allowed.
     *
     *
     * @param template template field value
     */
    void setTemplate(ModelElement template);
}
