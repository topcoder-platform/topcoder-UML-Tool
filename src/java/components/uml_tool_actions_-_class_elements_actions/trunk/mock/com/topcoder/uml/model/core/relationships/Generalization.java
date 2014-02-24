/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Generalization extends com.topcoder.uml.model.core.relationships.Relationship {
    /**
     * Sets the discriminator. Null is a valid value.
     *
     * @param discriminator
     *            the discriminator
     */
    public void setDiscriminator(String discriminator);

    /**
     * Returns the discriminator.
     *
     * @return the discriminator
     */
    public String getDiscriminator();

    /**
     * Sets the child. Null is a valid value.
     *
     * @param child
     *            the child
     */
    public void setChild(com.topcoder.uml.model.core.GeneralizableElement child);

    /**
     * Returns the child.
     *
     * @return the child
     */
    public com.topcoder.uml.model.core.GeneralizableElement getChild();

    /**
     * Sets the parent. Null is a valid value.
     *
     * @param parent
     *            the parent
     */
    public void setParent(com.topcoder.uml.model.core.GeneralizableElement parent);

    /**
     * Returns the parent.
     *
     * @return the parent
     */
    public com.topcoder.uml.model.core.GeneralizableElement getParent();

    /**
     * Sets the powertype. Null is a valid value.
     *
     * @param powertype
     *            the powertype
     */
    public void setPowertype(com.topcoder.uml.model.core.Classifier powertype);

    /**
     * Returns the powertype.
     *
     * @return the powertype
     */
    public com.topcoder.uml.model.core.Classifier getPowertype();
}