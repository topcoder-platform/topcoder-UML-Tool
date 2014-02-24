/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * In the metamodel, ParameterDirectionKind defines an enumeration that denotes if a Parameter is
 * used for supplying an argument and/or for returning a value.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum ParameterDirectionKind {

    /**
     * <p>
     * An input Parameter (may not be modified).
     * </p>
     *
     */
    IN,

    /**
     * <p>
     * An output Parameter (may be modified to communicate information to the caller).
     * </p>
     *
     */
    INOUT,

    /**
     * <p>
     * An input Parameter that may be modified.
     * </p>
     *
     */
    OUT,

    /**
     * <p>
     * A return value of a call.
     * </p>
     *
     */
    RETURN
}
