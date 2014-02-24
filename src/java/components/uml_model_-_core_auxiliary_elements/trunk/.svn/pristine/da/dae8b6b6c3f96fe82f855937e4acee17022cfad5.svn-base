/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>This is a simple, concrete implementation of TemplateParameter interface.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class TemplateParameterImpl implements TemplateParameter {
    /**
     * <p>Represents the real ModelElement that is set during binding. This value will be the ame
     * kind/descendant of the dummy ModelElement (held in the template attribute here). If binding
     * does not provide an argument corresponding to the dummy, the default is used during binding.
     * If default then is also not set, the constructo is invalid.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private ModelElement parameter = null;

    /**
     * <p>Represents An optional default value ModelElement.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private ModelElement defaultElement = null;

    /**
     * <p>Represents A template value ModelElement. This relatiohsip represents a dummy placeholder
     * for a real ModelElement to be substituted during binding.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private ModelElement template = null;

    /**
     * <p>Default constructor.</p>
     *
     */
    public TemplateParameterImpl() {
    }

    /**
     * Gets the parameter field value. Could be null.
     *
     *
     * @return parameter field value
     */
    public ModelElement getParameter() {
        return parameter;
    }

    /**
     * Sets the parameter field value. Null is allowed.
     *
     *
     * @param parameter parameter field value
     */
    public void setParameter(ModelElement parameter) {
        this.parameter = parameter;
    }

    /**
     * Gets the default element field value. Could be null.
     *
     *
     * @return defaultElement field value
     */
    public ModelElement getDefaultElement() {
        return defaultElement;
    }

    /**
     * Sets the default element field value. Null is allowed.
     *
     *
     * @param defaultElement defaultElement field value
     */
    public void setDefaultElement(ModelElement defaultElement) {
        this.defaultElement = defaultElement;
    }

    /**
     * Gets the template field value. Could be null.
     *
     *
     * @return template field value
     */
    public ModelElement getTemplate() {
        return template;
    }

    /**
     * Sets the template field value. Null is allowed.
     *
     *
     * @param template template field value
     */
    public void setTemplate(ModelElement template) {
        this.template = template;
    }
}
