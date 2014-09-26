/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * TaggedValue interface extends ModelElement interface, and it is used to
 * attach information to model element in conformance with its tag definition.
 * The information could contain code generation options, model management
 * information, or user-specified semantics. The tagged value must be associated
 * with a tag definition, and its reference values should follow the constraint
 * set by the tagType of the tag definition it belongs to.
 * </p>
 * <p>
 * Thread-safety: The implementation doesn't need to be thread-safe.
 * </p>
 *
 * @author Standlove, BLE
 * @version 1.0
 */
public interface TaggedValue extends ModelElement {
    /**
     * <p>
     * Return the data value of the tagged value.
     * </p>
     *
     * @return the data value of the tagged value.
     */
    public String getDataValue();

    /**
     * <p>
     * Set the data value of the tagged value. The argument could be null or
     * empty string.
     * </p>
     *
     * @param dataValue the data value of the tagged value.
     */
    public void setDataValue(String dataValue);

    /**
     * <p>
     * Return the TagDefinition object indicating the type of this tagged value.
     * </p>
     *
     * @return the TagDefinition object indicating the type of this tagged value
     */
    public TagDefinition getType();

    /**
     * <p>
     * Set the TagDefinition object indicating the type of this tagged value.
     * The argument could be null.
     * </p>
     *
     * @param type the TagDefinition object indicating the type of this tagged
     *            value
     */
    public void setType(TagDefinition type);

    /**
     * <p>
     * Return the ModelElement object associated with this tagged value.
     * </p>
     *
     * @return the ModelElement object associated with this tagged value.
     */
    public ModelElement getModelElement();

    /**
     * <p>
     * Set the ModelElement object associated with this tagged value. The
     * argument could be null.
     * </p>
     *
     * @param element the ModelElement object associated with this tagged value.
     */
    public void setModelElement(ModelElement element);

    /**
     * <p>
     * Add reference value to this tagged value.
     * <p>
     * </p>
     * NOTE: Duplication is allowed.
     * </p>
     *
     * @param value the referenece value to add.
     * @throws IllegalArgumentException if the argument is null.
     */
    public void addReferenceValue(ModelElement value);

    /**
     * <p>
     * Remove the given reference value from this tagged value. Return true if
     * the value to remove exists, return false otherwise.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in this tagged value, nothing
     * is removed, and false is returned.
     * </p>
     *
     * @param value the reference value to remove.
     * @return true if the value to remove exists, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeReferenceValue(ModelElement value);

    /**
     * <p>
     * Clear all reference values from this tagged value.
     * </p>
     */
    public void clearReferenceValues();

    /**
     * <p>
     * Return an unmodifiable view of reference values of this tagged value. An
     * empty collection is returned if there are no tagged values.
     * </p>
     *
     * @return an unmodifiable view of reference values of this tagged value.
     */
    public Collection<ModelElement> getReferenceValues();

    /**
     * <p>
     * Return true if the given reference value exists in this tagged value,
     * return false otherwise.
     * </p>
     *
     * @param value the reference value to check for existence.
     * @return true if the given reference value exists in this tagged value,
     *         return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean containsReferenceValue(ModelElement value);

    /**
     * <p>
     * Return the number of reference values for this tagged value.
     * </p>
     *
     * @return the number of reference values for this tagged value
     */
    public int countReferenceValues();
}
