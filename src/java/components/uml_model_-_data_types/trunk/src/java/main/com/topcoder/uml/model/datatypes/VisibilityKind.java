/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * In the metamodel, VisibilityKind defines an enumeration that denotes how the element to which it
 * refers is seen outside the enclosing name space.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum VisibilityKind {

    /**
     * <p>
     * Other elements may see and use the target element.
     * </p>
     *
     */
    PUBLIC,

    /**
     * <p>
     * Descendants of the source element may see and use the target element.
     * </p>
     *
     */
    PROTECTED,

    /**
     * <p>
     * Only the source element may see and use the target element.
     * </p>
     *
     */
    PRIVATE,

    /**
     * <p>
     * Elements declared in the same package as the target element may see and use the target
     * element.
     * </p>
     *
     */
    PACKAGE
}
