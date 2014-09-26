/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.ScopeKind;

/**
 * <p>
 * A feature is a property, like operation or attribute, which is encapsulated within a Classifier.
 * </p>
 * <p>
 * In the meta model, a Feature declares a behavioral or structural characteristic of an Instance of a Classifier or of
 * the Classifier itself. Feature is an abstract meta class.
 * </p>
 * <p>
 * A Feature has the following properties:
 * <ul>
 * <li>name: (Inherited from ModelElement) The name used to identify the Feature within the Classifier or Instance. It
 * must be unique across inheritance of names from ancestors including names of outgoing AssociationEnd. (See more
 * specific rules for the exact details. Attributes, discriminators, and opposite association ends must have unique
 * names in the set of inherited names. There may be multiple declarations of the same operation. Multiple operations
 * may have the same name but different signatures; see the rules for precise details.) </li>
 * <li>owner: The Classifier declaring the Feature. Note that an Attribute may be owned by a Classifier (in which case
 * it is a feature) or an AssociationEnd (in which case it is a qualifier) but not both. </li>
 * <li>ownerScope: Specifies whether Feature appears in each Instance of the Classifier or whether there is just a
 * single instance of the Feature for the entire Classifier. Possibilities are: (1) instance - Each Instance of the
 * Classifier holds its own value for the Feature; (2) classifier - There is just one value of the Feature for the
 * entire Classifier. </li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface Feature extends ModelElement {
    /**
     * <p>
     * Sets the owner of the current object.
     * </p>
     *
     * @param owner
     *            the owner to be set for this object.
     */
    void setOwner(Classifier owner);

    /**
     * <p>
     * Gets the owner of the current object.
     * </p>
     *
     * @return the owner of this object.
     */
    Classifier getOwner();

    /**
     * <p>
     * Sets the owner scope of the current object.
     * </p>
     *
     * @param ownerScope
     *            the owner scope to be set for this object.
     */
    void setOwnerScope(ScopeKind ownerScope);

    /**
     * <p>
     * Gets the owner scope of the current object.
     * </p>
     *
     * @return the owner scope of this object.
     */
    ScopeKind getOwnerScope();
}
