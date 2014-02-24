/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class TaggedValueImpl extends com.topcoder.uml.model.core.ModelElementAbstractImpl implements TaggedValue {

    /**
     * Mock attribute. Could be null or empty string.
     */
    private String dataValue;

    /**
     * Mock attribute. Could be null.
     */
    private TagDefinition type;

    /**
     * Mock attribute. Could be null.
     */
    private com.topcoder.uml.model.core.ModelElement modelElement;

    /**
     * Mock attribute.
     */
    private final Collection<ModelElement> referenceValues = new ArrayList<ModelElement>();

    /**
     * Mock method.
     *
     * @return
     */
    public String getDataValue() {
        return this.dataValue;
    }

    /**
     * Mock method.
     *
     * @param dataValue
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public TagDefinition getType() {
        return this.type;
    }

    /**
     * Mock method.
     *
     * @param type
     */
    public void setType(TagDefinition type) {
        this.type = type;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public com.topcoder.uml.model.core.ModelElement getModelElement() {
        return this.modelElement;
    }

    /**
     * Mock method.
     *
     * @param element
     */
    public void setModelElement(com.topcoder.uml.model.core.ModelElement element) {
        this.modelElement = element;
    }

    /**
     * Mock method.
     *
     * @param value
     */
    public void addReferenceValue(com.topcoder.uml.model.core.ModelElement value) {
        this.referenceValues.add(value);
    }

    /**
     * <p>
     * Remove the given reference value from this tagged value. Simply return
     * referenceVaues.remove(value). Return true if the value to remove exists,
     * return false otherwise. NOTE: if the object to remove doesn't exist in
     * this tagged value, nothing is removed, and false is returned. If the
     * collection contains more than one such element, only the first one
     * encountered is removed.
     * </p>
     *
     * @param value
     *            the reference value to remove.
     * @return true if the value to remove exists, return false otherwise.
     */
    public boolean removeReferenceValue(com.topcoder.uml.model.core.ModelElement value) {
        return false;
    }

    /**
     * <p>
     * Clear all reference values from this tagged value, simply call
     * referenceValues.clear().
     * </p>
     */
    public void clearReferenceValues() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<ModelElement> getReferenceValues() {
        return this.referenceValues;
    }

    /**
     * Mock method.
     *
     * @param value
     * @return
     */
    public boolean containsReferenceValue(com.topcoder.uml.model.core.ModelElement value) {
        return this.referenceValues.contains(value);
    }

    /**
     * <p>
     * Return the number of reference values for this tagged value. Simply
     * return this.referenceValues.size().
     * </p>
     *
     * @return the number of reference values for this tagged value
     */
    public int countReferenceValues() {
        return 0;
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