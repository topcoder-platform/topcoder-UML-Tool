/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

import java.io.Serializable;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * <p>
 * Simple, base interface. In the metamodel, an Expression defines a statement which will evaluate
 * to a (possibly empty) set of instances when executed in a context. An Expression does not modify
 * the environment in which it is evaluated. An expression contains an expression string and the
 * name of an interpretation language with which to evaluate the string.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public interface Expression extends Serializable {

    /**
     * <p>
     * Gets the String language field value. It could be null/empty.
     * </p>
     *
     * @return language field value
     */
    public String getLanguage();

    /**
     * <p>
     * Sets the String language field value. Null/empty is allowed.
     * </p>
     *
     * @param language
     *            language field value
     */
    public void setLanguage(String language);

    /**
     * <p>
     * Gets the String body field value. It could be null/empty.
     * </p>
     *
     * @return body field value
     */
    public String getBody();

    /**
     * <p>
     * Sets the String body field value. Null/empty is allowed.
     * </p>
     *
     * @param body
     *            body field value
     */
    public void setBody(String body);

    /**
     * <p>
     * Gets the Procedure procedure field value. It could be null.
     * </p>
     *
     * @return procedure field value
     */
    public Procedure getProcedure();

    /**
     * <p>
     * Sets the Procedure procedure field value. Null is allowed.
     * </p>
     *
     * @param procedure
     *            procedure field value
     */
    public void setProcedure(Procedure procedure);
}
