/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;


/**
 * <p>
 * This abstract class implements the ZUMLOpaqueExpression interface and extends the ModelElementAbstractImpl class.
 * It defines the common methods of any type of ZUMLOpaqueExpression to lessen the implementation contract. It also
 * defines methods to set and get the body and language of an OpaqueExpression model element.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable and not thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 */
public abstract class AbstractZUMLOpaqueExpression
    extends ModelElementAbstractImpl implements ZUMLOpaqueExpression {
    /**
     * <p>
     * This field represents the body of the current OpaqueExpression instance. The body is
     * the String describing the expression value. It can be empty String as it is not out
     * of common to have empty names in uml diagrams. It's intialized with empty string in
     * constructor. It can be accessed in getBody() and set with setBody(). It cannot be null.
     * </p>
     */
    private String body;

    /**
     * <p>
     * This field represents the language of the current OpaqueExpression instance. The language
     * of an OpaqueExpression represents the language employed to write the body of the expression.
     * Intialized with empty string in constructor. Can be accessed in getBody() and set with setBody().
     * It cannot be null or empty String.
     * </p>
     */
    private String language;

    /**
     * <p>
     * Intializes the body and language variables with empty String values.
     * </p>
     */
    protected AbstractZUMLOpaqueExpression() {
        body = "";
        language = "";
    }

    /**
     * <p>
     * Gets the body of the current OpaqueExpression instance.
     * </p>
     *
     * @return the body of the current OpaqueExpression
     */
    public String getBody() {
        return body;
    }

    /**
     * <p>
     * Sets a new body value. Empty String is allowed as it is not out of common to have
     * empty names in uml diagrams.
     * </p>
     *
     * @param body the new body value
     * @throws IllegalArgumentException if the argument is null
     */
    public void setBody(String body) {
        Helper.checkNull(body, "body");

        this.body = body;
    }

    /**
     * <p>
     * Gets the language of the current OpaqueExpression instance.
     * </p>
     *
     * @return the language of the current OpaqueExpression
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <p>
     * Sets a new body value. Empty or null String is not allowed for this variable.
     * </p>
     *
     * @param language the new language to be set
     * @throws IllegalArgumentException if the argument is null or empty String
     */
    public void setLanguage(String language) {
        Helper.checkString(language, "language");

        this.language = language;
    }

    /**
     * <p>
     * Abstract methods for converting the current activity diagram element to its tcuml
     * equivalent model representation. The returned object is a ModelElement instance
     * which means it can be used to construct a tcuml model.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public abstract ModelElement convertToTCUML();
}
