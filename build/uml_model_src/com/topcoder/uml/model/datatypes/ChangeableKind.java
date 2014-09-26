/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * In the metamodel, ChangeableKind defines an enumeration that denotes how an AttributeLink or
 * LinkEnd may be modified.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum ChangeableKind {

    /**
     * <p>
     * No restrictions on modification.
     * </p>
     */
    CHANGEABLE,

    /**
     * <p>
     * The value may not be changed from the source end after the creation and initialization of the
     * source object. Operations on the other end may change a value.
     * </p>
     */
    FROZEN,

    /**
     * <p>
     * If the multiplicity is not fixed, values may be added at any time from the source object, but
     * once created a value may not be removed from the source end. Operations on the other end may
     * change a value.
     * </p>
     */
    ADD_ONLY
}
