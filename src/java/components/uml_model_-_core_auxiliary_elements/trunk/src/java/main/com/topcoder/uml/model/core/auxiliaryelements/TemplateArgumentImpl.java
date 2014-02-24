/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Binding;


/**
 * <p>This is a simple, concrete implementation of TemplateArgument interface.
 * Reifies the relationship between a Binding and one of its arguments
 * (a ModelElement)</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class TemplateArgumentImpl implements TemplateArgument {
    /**
     * <p>Represents The actual argument for the subject Binding.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private ModelElement modelElement = null;

    /**
     * <p>Represents The Binding that owns the template argument.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Binding binding = null;

    /**
     * <p>Empty constructor.</p>
     *
     */
    public TemplateArgumentImpl() {
    }

    /**
     * Gets the modelElement field value. Could be null.
     *
     *
     * @return modelElement field value
     */
    public ModelElement getModelElement() {
        return modelElement;
    }

    /**
     * Sets the modelElement field value. Null is allowed.
     *
     *
     * @param modelElement modelElement field value
     */
    public void setModelElement(ModelElement modelElement) {
        this.modelElement = modelElement;
    }

    /**
     * Gets the binding field value. Could be null.
     *
     *
     * @return binding field value
     */
    public Binding getBinding() {
        return binding;
    }

    /**
     * Sets the binding field value. Null is allowed.
     *
     *
     * @param binding binding field value
     */
    public void setBinding(Binding binding) {
        this.binding = binding;
    }
}
