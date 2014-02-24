/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElement;


/**
 * This interface defines the contract for a generalization. A generalization is a taxonomic relationship between a more
 * general element and a more specific element. The more specific element is fully consistent with the more general
 * element (it has all of its properties, members, and relationships) and may contain additional information. This
 * interface extends Relationship interface and add more specific methods that apply to a generalization Implementations
 * are not required to be thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public interface Generalization extends Relationship {
    /**
     * Sets the discriminator. Null is a valid value.
     *
     * @param discriminator the new discriminator to be set.
     */
    public void setDiscriminator(String discriminator);

    /**
     * Returns the discriminator.
     *
     * @return the discriminator of current object.
     */
    public String getDiscriminator();

    /**
     * Sets the child. Null is a valid value.
     *
     * @param child the new child to be set.
     */
    public void setChild(GeneralizableElement child);

    /**
     * Returns the child.
     *
     * @return the child of current object.
     */
    public GeneralizableElement getChild();

    /**
     * Sets the parent. Null is a valid value.
     *
     * @param parent the new parent to be set.
     */
    public void setParent(GeneralizableElement parent);

    /**
     * Returns the parent.
     *
     * @return the parent of current object.
     */
    public GeneralizableElement getParent();

    /**
     * Sets the powertype. Null is a valid value.
     *
     * @param powertype the new powertype to be set.
     */
    public void setPowertype(Classifier powertype);

    /**
     * Returns the powertype.
     *
     * @return the powertype of current object.
     */
    public Classifier getPowertype();
}
