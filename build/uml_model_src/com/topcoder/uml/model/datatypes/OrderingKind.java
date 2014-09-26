/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * Defines an enumeration that specifies how the elements of a set are arranged. Used in conjunction
 * with elements that have a multiplicity in cases when the multiplicity value is greater than one.
 * The ordering must be determined and maintained by operations that modify the set. The intent is
 * that the set of enumeration literals be open for new values to be added by tools for purposes of
 * design, code generation, etc. For example, a value of sorted might be used for a design
 * specification.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum OrderingKind {

    /**
     * <p>
     * The elements of the set have no inherent ordering.
     * </p>
     *
     */
    UNORDERED,

    /**
     * <p>
     * The elements of the set have a sequential ordering. Other possibilities (such as sorted) may
     * be defined later by declaring additional keywords. As with user-defined stereotypes, this
     * would be a private extension supported by particular editing tools.
     * </p>
     *
     */
    ORDERED
}
