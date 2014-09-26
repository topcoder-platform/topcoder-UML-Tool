/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * <p>
 * TaggedValueImpl class implements the TaggedValue interface and extends the
 * ModelElementAbstractImpl abstract class, It is used to attach information to
 * model element in conformance with its tag definition. The information could
 * contain code generation options, model management information, or
 * user-specified semantics. The tagged value must be associated with a tag
 * definition, and its reference values should follow the constraint set by the
 * tagType of the tag definition it belongs to.
 * </p>
 * <p>
 * Thread-safety: This class is mutable and not thread-safe.
 * </p>
 *
 * @author Standlove, BLE
 * @version 1.0
 */
public class TaggedValueImpl extends ModelElementAbstractImpl implements TaggedValue {

    /**
     * <p>
     * Represents the data value of the tag, the type of this value must conform
     * to the type specified in the tagType attribute of its associated tag
     * definition. It is initially null, and accessed and changed through its
     * getter and setter. It could be null or empty string.
     * </p>
     */
    private String dataValue = null;

    /**
     * <p>
     * Represents the tag definition owns this tagged value. It is initially
     * null, and accessed and changed through its getter and setter. It could be
     * null.
     * </p>
     */
    private TagDefinition type = null;

    /**
     * <p>
     * Represents the model element associated with this tagged value. It is
     * initially null, and accessed and changed through its getter and setter.
     * It could be null.
     * </p>
     */
    private ModelElement modelElement = null;

    /**
     * <p>
     * Represents a collection of ModelElement objects this tagged value
     * references. The number of references is defined by the multiplicity of
     * its associated tag definition. It is initialized in place to an empty
     * ArrayList&lt;ModelElement&gt; object, and this reference would never be
     * changed afterwards. It has a bunch of corresponding methods to
     * update/access the content of this collection.
     * </p>
     */
    private final Collection<ModelElement> referenceValues = new ArrayList<ModelElement>();

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public TaggedValueImpl() {
    }

    /**
     * <p>
     * Constructor with all attributes.
     * </p>
     *
     * @param dataValue the data value of the tagged value.
     * @param type the TagDefinition object indicating the type of this tagged
     *            value
     * @param modelElement the ModelElement object associated with this tagged
     *            value.
     * @param referenceValues a collection of ModelElement objects referenced by
     *            it.
     * @throws IllegalArgumentException if referenceValues argument is null or
     *             contains null elements. NOTE: referenceValues argument could
     *             be empty. The dataValue could be null or empty string, and
     *             type/modelElement arguments could be null.
     */
    public TaggedValueImpl(String dataValue, TagDefinition type, ModelElement modelElement,
            Collection<ModelElement> referenceValues) {
        Helper.assertNotNullOrContainsNull(referenceValues, "referenceValues");

        setDataValue(dataValue);
        setType(type);
        setModelElement(modelElement);
        this.referenceValues.addAll(referenceValues);
    }

    /**
     * <p>
     * Return the data value of the tagged value.
     * </p>
     *
     * @return the data value of the tagged value.
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * <p>
     * Set the data value of the tagged value. The argument could be null or
     * empty string.
     * </p>
     *
     * @param dataValue the data value of the tagged value.
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * <p>
     * Return the TagDefinition object indicating the type of this tagged value.
     * </p>
     *
     * @return the TagDefinition object indicating the type of this tagged
     *         value.
     */
    public TagDefinition getType() {
        return type;
    }

    /**
     * <p>
     * Set the TagDefinition object indicating the type of this tagged value.
     * The argument could be null.
     * </p>
     *
     * @param type the TagDefinition object indicating the type of this tagged
     *            value
     */
    public void setType(TagDefinition type) {
        this.type = type;
    }

    /**
     * <p>
     * Return the ModelElement object associated with this tagged value.
     * </p>
     *
     * @return the ModelElement object associated with this tagged value.
     */
    public ModelElement getModelElement() {
        return modelElement;
    }

    /**
     * <p>
     * Set the ModelElement object associated with this tagged value. The
     * argument could be null.
     * </p>
     *
     * @param element the ModelElement object associated with this tagged value.
     */
    public void setModelElement(ModelElement element) {
        this.modelElement = element;
    }

    /**
     * <p>
     * Add reference value to this tagged value.
     * <p>
     * </p>
     * NOTE: Duplication is allowed.
     * </p>
     *
     * @param value the reference value to add.
     * @throws IllegalArgumentException if the argument is null.
     */
    public void addReferenceValue(ModelElement value) {
        Helper.assertNotNull(value, "value");

        referenceValues.add(value);
    }

    /**
     * <p>
     * Remove the given reference value from this tagged value. Return true if
     * the value to remove exists, return false otherwise.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in this tagged value, nothing
     * is removed, and false is returned. If the collection contains more than
     * one such element, only the first one encountered is removed.
     * </p>
     *
     * @param value the reference value to remove.
     * @return true if the value to remove exists, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeReferenceValue(ModelElement value) {
        Helper.assertNotNull(value, "value");

        return referenceValues.remove(value);
    }

    /**
     * <p>
     * Clear all reference values from this tagged value.
     * </p>
     */
    public void clearReferenceValues() {
        referenceValues.clear();
    }

    /**
     * <p>
     * Return an unmodifiable view of reference values of this tagged value. An
     * empty collection is returned if there are no tagged values.
     * </p>
     *
     * @return an unmodifiable view of reference values of this tagged value.
     */
    public Collection<ModelElement> getReferenceValues() {
        return Collections.unmodifiableCollection(referenceValues);
    }

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
    public boolean containsReferenceValue(ModelElement value) {
        Helper.assertNotNull(value, "value");

        return referenceValues.contains(value);
    }

    /**
     * <p>
     * Return the number of reference values for this tagged value.
     * </p>
     *
     * @return the number of reference values for this tagged value
     */
    public int countReferenceValues() {
        return referenceValues.size();
    }
}
