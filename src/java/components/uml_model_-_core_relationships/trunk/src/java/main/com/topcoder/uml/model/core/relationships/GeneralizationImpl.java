/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElement;


/**
 * This is the default implementation of the Generalization interface. A generalization is a taxonomic relationship
 * between a more general element and a more specific element. The more specific element is fully consistent with the
 * more general element (it has all of its properties, members, and relationships) and may contain additional
 * information. This class also extends RelationshipAbstractImpl to reuse the code that exists in the abstract class.
 * This class has several simple attributes(discriminator,child, parent, powertype) that describe a generalization.
 * For these simple attributes setters and getters are provided. This class is mutable and not thread safe.
 * Since it is a data class it doesn't really makes sense to make it thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public class GeneralizationImpl extends RelationshipAbstractImpl
    implements Generalization {
    /**
     * Designates the partition to which the Generalization link belongs. All of the Generalization links that share a
     * given parent GeneralizableElement are divided into disjoint sets (that is, partitions) by their discriminator
     * names. Each partition (a set of links sharing a discriminator name) represents an orthogonal dimension of
     * specialization of the parent GeneralizableElement. The discriminator need not be unique. The empty string is also
     * considered as a partition name, therefore all Generalization links have a discriminator. If the set of
     * Generalization links that have the same parent all have the same name, then the children in the Generalization
     * links are GeneralizableElements that specialize the parent, and an instance of any of them is a legal instance of
     * the parent. Otherwise an indirect instance of the parent must be a (direct or indirect) instance of at least one
     * element from each of the partitions. Initial value is null. This field can be set using the setter and its value
     * can be queried using the getter. Null and empty string are valid values. The field is mutable.
     */
    private String discriminator = null;

    /**
     * Designates a GeneralizableElement that is the specialized version of the parent GeneralizableElement. It can be
     * set using the setter and its value can be queried using the getter. Initial value is null. Null is a valid value.
     * It is mutable. Only a comment: if the parent is null and the child is not null we have a situation that doesn't
     * make sense; however these issues are not a concern for this component, the application should take care of such
     * issues.
     */
    private GeneralizableElement child = null;

    /**
     * Designates a GeneralizableElement that is the generalized version of the child GeneralizableElement. It can be
     * set using the setter and its value can be queried using the getter. Initial value is null. Null is a valid value.
     * It is mutable.
     */
    private GeneralizableElement parent = null;

    /**
     * Designates a Classifier that serves as a powertype for the child element along the dimension of generalization
     * expressed by the Generalization. The child element is therefore an instance of the powertype element. It can be
     * set using the setter and its value can be queried using the getter. Initial value is null. Null is a valid value.
     * It is mutable.
     */
    private Classifier powertype = null;

    /**
     * Empty constructor.
     */
    public GeneralizationImpl() {
    }

    /**
     * Setter for the discriminator field. Null and empty string are valid values.
     *
     * @param discriminator the new discriminator to be set.
     */
    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    /**
     * Getter for the discriminator field.
     *
     * @return the discriminator of current object.
     */
    public String getDiscriminator() {
        return this.discriminator;
    }

    /**
     * Setter for the child field. Null is a valid value.
     *
     * @param child the new child to be set.
     */
    public void setChild(GeneralizableElement child) {
        this.child = child;
    }

    /**
     * Getter for the child field.
     *
     * @return the child of current object.
     */
    public GeneralizableElement getChild() {
        return this.child;
    }

    /**
     * Setter for the parent field. Null is a valid value.
     *
     * @param parent the new parent to be set.
     */
    public void setParent(GeneralizableElement parent) {
        this.parent = parent;
    }

    /**
     * Getter for the parent field.
     *
     * @return the parent of current object.
     */
    public GeneralizableElement getParent() {
        return this.parent;
    }

    /**
     * Setter for the powertype field. Null is a valid value.
     *
     * @param powertype the new powertype to be set.
     */
    public void setPowertype(Classifier powertype) {
        this.powertype = powertype;
    }

    /**
     * Getter for the powertype field.
     *
     * @return the powertype of current object.
     */
    public Classifier getPowertype() {
        return this.powertype;
    }
}
