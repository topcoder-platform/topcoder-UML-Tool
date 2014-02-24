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
public class GeneralizationImpl extends com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl implements
        com.topcoder.uml.model.core.relationships.Generalization {

    /**
     * Designates the partition to which the Generalization link belongs. All of
     * the Generalization links that share a given parent GeneralizableElement
     * are divided into disjoint sets (that is, partitions) by their
     * discriminator names. Each partition (a set of links sharing a
     * discriminator name) represents an orthogonal dimension of specialization
     * of the parent GeneralizableElement. The discriminator need not be unique.
     * The empty string is also considered as a partition name, therefore all
     * Generalization links have a discriminator. If the set of Generalization
     * links that have the same parent all have the same name, then the children
     * in the Generalization links are GeneralizableElements that specialize the
     * parent, and an instance of any of them is a legal instance of the parent.
     * Otherwise an indirect instance of the parent must be a (direct or
     * indirect) instance of at least one element from each of the partitions.
     * Initial value is null. This field can be set using the setter and its
     * value can be queried using the getter. Null and empty string are valid
     * values. The field is mutable.
     */
    private String discriminator = null;

    /**
     * Designates a GeneralizableElement that is the specialized version of the
     * parent GeneralizableElement. It can be set using the setter and its value
     * can be queried using the getter. Initial value is null. Null is a valid
     * value. It is mutable. Only a comment: if the parent is null and the child
     * is not null we have a situation that doesn't make sense; however these
     * issues are not a concern for this component, the application should take
     * care of such issues.
     */
    private com.topcoder.uml.model.core.GeneralizableElement child = null;

    /**
     * Designates a GeneralizableElement that is the generalized version of the
     * child GeneralizableElement. It can be set using the setter and its value
     * can be queried using the getter. Initial value is null. Null is a valid
     * value. It is mutable.
     */
    private com.topcoder.uml.model.core.GeneralizableElement parent = null;

    /**
     * Designates a Classifier that serves as a powertype for the child element
     * along the dimension of generalization expressed by the Generalization.
     * The child element is therefore an instance of the powertype element. It
     * can be set using the setter and its value can be queried using the
     * getter. Initial value is null. Null is a valid value. It is mutable.
     */
    private com.topcoder.uml.model.core.Classifier powertype = null;

    /**
     * Empty constructor.
     */
    public GeneralizationImpl() {
    }

    /**
     * Setter for the discriminator field. Simply set the field.Null and empty
     * string are valid values.
     * 
     * @param discriminator
     *            the discriminator
     */
    public void setDiscriminator(String discriminator) {
    }

    /**
     * Getter for the discriminator field. Simply return the field.
     * 
     * @return the discriminator
     */
    public String getDiscriminator() {
        return null;
    }

    /**
     * Setter for the child field. Simply set the field. Null is a valid value.
     * 
     * @param child
     *            the child
     */
    public void setChild(com.topcoder.uml.model.core.GeneralizableElement child) {
        this.child = child;
    }

    /**
     * Getter for the child field. Simply return the field.
     * 
     * @return the child
     */
    public com.topcoder.uml.model.core.GeneralizableElement getChild() {
        return this.child;
    }

    /**
     * Setter for the parent field. Simply set the field.Null is a valid value.
     * 
     * @param parent
     *            the parent
     */
    public void setParent(com.topcoder.uml.model.core.GeneralizableElement parent) {
        this.parent = parent;
    }

    /**
     * Getter for the parent field. Simply return the field.
     * 
     * @return the parent
     */
    public com.topcoder.uml.model.core.GeneralizableElement getParent() {
        return this.parent;
    }

    /**
     * Setter for the powertype field. Simply set the field.Null is a valid
     * value.
     * 
     * @param powertype
     *            the powertype
     */
    public void setPowertype(com.topcoder.uml.model.core.Classifier powertype) {
    }

    /**
     * Getter for the powertype field. Simply return the field.
     * 
     * @return the powertype
     */
    public com.topcoder.uml.model.core.Classifier getPowertype() {
        return null;
    }

    /**
     * Mock method.
     * 
     * @return
     */
    public int countBehaviors() {
        return 0;
    }
}