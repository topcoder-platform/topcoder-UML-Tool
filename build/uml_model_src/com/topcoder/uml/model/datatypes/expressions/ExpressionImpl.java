/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * <p>
 * This is a simple, concrete implementation of Expression interface.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public class ExpressionImpl implements Expression {

    /**
     * <p>
     * Represents the Names the language in which the expression body is represented. The
     * interpretation of the expression depends on the language. If the language name is omitted, no
     * interpretation for the expression can be assumed by UML.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null and empty values are
     * acceptable. There is no validation performed on the setter.
     * </p>
     *
     */
    private String language;

    /**
     * <p>
     * Represents the text of the expression expressed in the given language..
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null and empty values are
     * acceptable. There is no validation performed on the setter.
     * </p>
     *
     */
    private String body;

    /**
     * <p>
     * Represents the procedure associated with this expression.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.
     * </p>
     *
     */
    private Procedure procedure;

    /**
     * <p>
     * Empty constructor.
     * </p>
     *
     */
    public ExpressionImpl() {
    }

    /**
     * <p>
     * Gets the String language field value. It could be null/empty.
     * </p>
     *
     * @return language field value
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <p>
     * Sets the String language field value. Null/empty is allowed.
     * </p>
     *
     * @param language
     *            language field value
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * <p>
     * Gets the String body field value. It could be null/empty.
     * </p>
     *
     * @return body field value
     */
    public String getBody() {
        return body;
    }

    /**
     * <p>
     * Sets the String body field value. Null/empty is allowed.
     * </p>
     *
     * @param body
     *            body field value
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * <p>
     * Gets the Procedure procedure field value. It could be null.
     * </p>
     *
     * @return procedure field value
     */
    public Procedure getProcedure() {
        return procedure;
    }

    /**
     * <p>
     * Sets the Procedure procedure field value. Null is allowed.
     * </p>
     *
     * @param procedure
     *            procedure field value
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
}
