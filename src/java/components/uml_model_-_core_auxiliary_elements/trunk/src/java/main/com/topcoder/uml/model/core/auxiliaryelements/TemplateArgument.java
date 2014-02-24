/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import java.io.Serializable;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Binding;


/**
 * <p>Simple, base interface. Reifies the relationship between a Binding and one of its arguments
 * (a ModelElement).</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface TemplateArgument extends Serializable
{
	/**
     * Gets the modelElement field value. Could be null.
	 *
	 *
	 * @return modelElement field value
	 */
	ModelElement getModelElement();

	/**
     * Sets the modelElement field value. Null is allowed.
	 *
	 *
	 * @param modelElement modelElement field value
	 */
	void setModelElement(ModelElement modelElement);

	/**
     * Gets the binding field value. Could be null.
	 *
	 *
	 * @return binding field value
	 */
	Binding getBinding();

	/**
     * Sets the binding field value. Null is allowed.
	 *
	 *
	 * @param binding binding field value
	 */
	void setBinding(Binding binding);
}
