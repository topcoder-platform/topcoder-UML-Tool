/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.Multiplicity;

/**
 * <p>
 * TagDefinition interface extends the ModelElement interface, and it contains a
 * set of the tagged value that can be attached to the model element. From the
 * UML spec, it is used to define the meta attributes of the stereotype to which
 * it is attached to, and in other words, the stereotype is the owner of the tag
 * definition.
 * </p>
 * <p>
 * Thread-safety: The implementation doesn't need to be thread-safe.
 * </p>
 *
 * @author Standlove, BLE
 * @version 1.0
 */
public interface TagDefinition extends ModelElement {
    /**
     * <p>
     * Return the tag type of this tag definition.
     * </p>
     *
     * @return the tag type of this tag definition.
     */
    public String getTagType();

    /**
     * <p>
     * Set the tag type of this tag definition. The argument could be null or
     * empty string.
     * </p>
     *
     * @param tagType the tag type of this tag definition.
     */
    public void setTagType(String tagType);

    /**
     * <p>
     * Return the Multiplicity object indicating the number of tagged values
     * this tag definition can have.
     * </p>
     *
     * @return the Multiplicity object indicating the number of tagged values
     *         this tag definition can have.
     */
    public Multiplicity getMultiplicity();

    /**
     * <p>
     * Set the Multiplicity object indicating the number of tagged values this
     * tag definition can have. The argument could be null.
     * </p>
     *
     * @param multiplicity the Multiplicity object indicating the number of
     *            tagged values this tag definition can have.
     */
    public void setMultiplicity(Multiplicity multiplicity);

    /**
     * <p>
     * Return the Stereotype object owning this tag definition.
     * </p>
     *
     * @return the Stereotype object owning this tag definition.
     */
    public Stereotype getOwner();

    /**
     * <p>
     * Set the Stereotype object owning this tag definition. The argument could
     * be null.
     * </p>
     *
     * @param owner the Stereotype object owning this tag definition.
     */
    public void setOwner(Stereotype owner);

    /**
     * <p>
     * Add tagged value to this tag definition. Once this method is called, it
     * will automatically remove the TaggedValue object from its original owner
     * (identified by its type attribute) if it gets one and it is different
     * from this TagDefinition object, and then change its owner to this
     * TagDefinition object.
     * <p>
     * </p>
     * NOTE: Duplication is allowed.
     * </p>
     *
     * @param typedValue the TaggedValue object to add.
     * @throws IllegalArgumentException if the argument is null.
     */
    public void addTypedValue(TaggedValue typedValue);

    /**
     * <p>
     * Remove the given TaggedValue object from this tag definition. Return true
     * if the value to remove exists, return false otherwise. If the given
     * TaggedValue object exists, its type attribute will be set to null after
     * it is removed.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in this tag definition,
     * nothing is removed, and false is returned.
     * </p>
     *
     * @param typedValue the TaggedValue object to remove.
     * @return true if the value to remove exists, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeTypedValue(TaggedValue typedValue);

    /**
     * <p>
     * Clear all tagged values from this tag definition, and all TaggedValue
     * objects' type attributes will be set to null.
     * </p>
     */
    public void clearTypedValues();

    /**
     * <p>
     * Return an unmodifiable view of tagged values of this tag definition. An
     * empty collection is returned if there are no tagged values.
     * </p>
     *
     * @return an unmodifiable view of tagged values of this tag definition.
     */
    public Collection<TaggedValue> getTypedValues();

    /**
     * <p>
     * Return true if the given TaggedValue object exists in this tag
     * definition, return false otherwise.
     * </p>
     *
     * @param typedValue the TaggedValue object to check for existence.
     * @return true if the given TaggedValue object exists in this tag
     *         definition, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean containsTypedValue(TaggedValue typedValue);

    /**
     * <p>
     * Return the number of tagged values for this tag definition.
     * </p>
     *
     * @return the number of tagged values for this tag definition
     */
    public int countTypedValues();

}
