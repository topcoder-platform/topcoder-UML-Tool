/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.Collection;

import com.topcoder.uml.model.core.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface TaggedValue extends com.topcoder.uml.model.core.ModelElement {
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
     * @param dataValue
     *            the data value of the tagged value.
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
     * @param type
     *            the TagDefinition object indicating the type of this tagged
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
    public com.topcoder.uml.model.core.ModelElement getModelElement();

    /**
     * <p>
     * Set the ModelElement object associated with this tagged value. The
     * argument could be null.
     * </p>
     *
     * @param element
     *            the ModelElement object associated with this tagged value.
     */
    public void setModelElement(com.topcoder.uml.model.core.ModelElement element);

    /**
     * <p>
     * Add reference value to this tagged value. NOTE: Duplication is allowed.
     * </p>
     *
     * @param value
     *            the referenece value to add.
     */
    public void addReferenceValue(com.topcoder.uml.model.core.ModelElement value);

    /**
     * <p>
     * Remove the given reference value from this tagged value. Return true if
     * the value to remove exists, return false otherwise. NOTE: if the object
     * to remove doesn't exist in this tagged value, nothing is removed, and
     * false is returned.
     * </p>
     *
     * @param value
     *            the reference value to remove.
     * @return true if the value to remove exists, return false otherwise.
     */
    public boolean removeReferenceValue(com.topcoder.uml.model.core.ModelElement value);

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
     * @param value
     *            the reference value to check for existence.
     * @return true if the given reference value exists in this tagged value,
     *         return false otherwise.
     */
    public boolean containsReferenceValue(com.topcoder.uml.model.core.ModelElement value);

    /**
     * <p>
     * Return the number of reference values for this tagged value
     * </p>
     *
     * @return the number of reference values for this tagged value
     */
    public int countReferenceValues();
}