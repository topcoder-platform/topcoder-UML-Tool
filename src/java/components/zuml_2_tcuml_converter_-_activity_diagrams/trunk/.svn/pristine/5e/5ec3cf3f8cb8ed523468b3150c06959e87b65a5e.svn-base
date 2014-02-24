/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity;


/**
 * <p>
 * This interface defines the Opaque Expression in the Activity Diagram. An OpaqueExpression
 * is composed of a body that represents the expression and a language that defines the language
 * in which the expression is expressed. This interface defines only methods to retrieve the body
 * and language, this being the minimal contract required by a layered conversion framework
 * for this element. It extends ZUML2TCUMLConvertible interface to allow implementations to
 * be converted in the same way.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * Implementations of this interface are not required to be thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 */
public interface ZUMLOpaqueExpression extends ZUML2TCUMLConvertible {
    /**
     * <p>Gets the body of the current OpaqueExpression instance.</p>
     *
     * @return the body of the current OpaqueExpression
     */
    public String getBody();

    /**
     * <p>Gets the language of the current OpaqueExpression instance.</p>
     *
     * @return the language of the current OpaqueExpression
     */
    public String getLanguage();
}
