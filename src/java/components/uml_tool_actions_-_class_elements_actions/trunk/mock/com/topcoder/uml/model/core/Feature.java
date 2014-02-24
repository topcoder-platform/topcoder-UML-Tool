/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Feature extends com.topcoder.uml.model.core.ModelElement {
    /**
     * <p>
     * Sets the owner of the current object.
     * </p>
     *
     * @param owner
     *            the owner to be set for this object
     */
    public void setOwner(Classifier owner);

    /**
     * <p>
     * Gets the owner of the current object.
     * </p>
     *
     * @return the owner of this object
     */
    public Classifier getOwner();

    /**
     * <p>
     * Sets the owner scope of the current object.
     * </p>
     *
     * @param ownerScope
     *            the owner scope to be set for this object
     */
    public void setOwnerScope(ScopeKind ownerScope);

    /**
     * <p>
     * Gets the owner scope of the current object.
     * </p>
     *
     * @return the owner scope of this object
     */
    public ScopeKind getOwnerScope();
}