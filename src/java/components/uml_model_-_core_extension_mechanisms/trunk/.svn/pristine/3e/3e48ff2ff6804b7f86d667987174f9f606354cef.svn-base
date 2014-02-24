/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;

/**
 * <p>
 * TagDefinitionImpl class implements TagDefinition interface and extends the
 * ModelElementAbstractImpl abstract class, it contains a set of the tagged
 * value that can be attached to the model element. From the UML spec, it is
 * used to define the meta attributes of the stereotype to which it is attached
 * to, and in other words, the stereotype is the owner of the tag definition.
 * </p>
 * <p>
 * Thread-safety: This class is mutable and not thread-safe.
 * </p>
 *
 * @author Standlove, BLE
 * @version 1.0
 */
public class TagDefinitionImpl extends ModelElementAbstractImpl implements TagDefinition {

    /**
     * <p>
     * Represents the data type indicating the range of values of the tagged
     * values associated with the tag definition in the general case. It can
     * also refer to a metaclass in special cases while the tag values represent
     * the model elements of such metaclass. It is initially null, and accessed
     * and changed through its getter and setter. It could be null or empty
     * string.
     * </p>
     */
    private String tagType = null;

    /**
     * <p>
     * Represents the number of data values this tag can have, or represents the
     * number of model elements can associated to related tagged values. It is
     * initially null, and accessed and changed through its getter and setter.
     * It could be null.
     * </p>
     */
    private Multiplicity multiplicity = null;

    /**
     * <p>
     * Represents stereotype owning this tag definition. It is initially null,
     * and accessed and changed through its getter and setter. It could be null.
     * </p>
     */
    private Stereotype owner = null;

    /**
     * <p>
     * Represents a collection of TaggedValues objects, each element in the
     * collection represents the tagged value conforms to this tag definition.
     * It is initialized in place to an empty ArrayList&lt;TaggedValue&gt;
     * object, and this reference would never be changed afterwards. It has a
     * bunch of corresponding methods to update/access the content of this
     * collection.
     * </p>
     */
    private final Collection<TaggedValue> typedValues = new ArrayList<TaggedValue>();

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public TagDefinitionImpl() {
    }

    /**
     * <p>
     * Constructor with all attributes.
     * </p>
     *
     * @param tagType the tag type of this tag definition.
     * @param multiplicity the Multiplicity object indicating the number of
     *            tagged values this tag definition can have.
     * @param owner the Stereotype object owning this tag definition.
     * @param typedValues a collection of TaggedValue objects.
     * @throws IllegalArgumentException if typedValues argument is null or
     *             contains null elements. NOTE: typedValues argument could be
     *             empty, the tagType could be null or empty string, and the
     *             multiplicity/owner could be null.
     */
    public TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
            Collection<TaggedValue> typedValues) {
        Helper.assertNotNullOrContainsNull(typedValues, "typedValues");

        setTagType(tagType);
        setMultiplicity(multiplicity);
        setOwner(owner);

        // Add typedValues
        for (TaggedValue tag : typedValues) {
            addTypedValue(tag);
        }
    }

    /**
     * <p>
     * Return the tag type of this tag definition.
     * </p>
     *
     * @return the tag type of this tag definition.
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * <p>
     * Set the tag type of this tag definition. The argument could be null or
     * empty string.
     * </p>
     *
     * @param tagType the tag type of this tag definition.
     */
    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    /**
     * <p>
     * Return the Multiplicity object indicating the number of tagged values
     * this tag definition can have.
     * </p>
     *
     * @return the Multiplicity object indicating the number of tagged values
     *         this tag definition can have.
     */
    public Multiplicity getMultiplicity() {
        return multiplicity;
    }

    /**
     * <p>
     * Set the Multiplicity object indicating the number of tagged values this
     * tag definition can have. The argument could be null.
     * </p>
     *
     * @param multiplicity the Multiplicity object indicating the number of
     *            tagged values this tag definition can have.
     */
    public void setMultiplicity(Multiplicity multiplicity) {
        this.multiplicity = multiplicity;
    }

    /**
     * <p>
     * Return the Stereotype object owning this tag definition.
     * </p>
     *
     * @return the Stereotype object owning this tag definition.
     */
    public Stereotype getOwner() {
        return owner;
    }

    /**
     * <p>
     * Set the Stereotype object owning this tag definition. The argument could
     * be null.
     * </p>
     *
     * @param owner the Stereotype object owning this tag definition.
     */
    public void setOwner(Stereotype owner) {
        this.owner = owner;
    }

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
    public void addTypedValue(TaggedValue typedValue) {
        Helper.assertNotNull(typedValue, "typedValue");

        TagDefinition tag = typedValue.getType();

        // Remove the TaggedValue object from its original owner
        if (tag != null && tag != this) {
            tag.removeTypedValue(typedValue);
        }

        // Add tagged value to this tag definition
        typedValue.setType(this);
        typedValues.add(typedValue);
    }

    /**
     * <p>
     * Remove the given TaggedValue object from this tag definition. Return true
     * if the value to remove exists, return false otherwise. If the given
     * TaggedValue object exists and is unique in this tag definition, its type
     * attribute will be set to null after it is removed.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in this tag definition,
     * nothing is removed, and false is returned. If the collection contains
     * more than one such element, only the first one encountered is removed.
     * </p>
     *
     * @param typedValue the TaggedValue object to remove.
     * @return true if the value to remove exists, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeTypedValue(TaggedValue typedValue) {
        Helper.assertNotNull(typedValue, "typedValue");
        boolean ret = typedValues.remove(typedValue);
        if (ret && !typedValues.contains(typedValue)) {
            typedValue.setType(null);
        }
        return ret;
    }

    /**
     * <p>
     * Clear all tagged values from this tag definition, and all TaggedValue
     * objects' type attributes will be set to null.
     * </p>
     */
    public void clearTypedValues() {
        for (TaggedValue tag : typedValues) {
            tag.setType(null);
        }
        typedValues.clear();
    }

    /**
     * <p>
     * Return an unmodifiable view of tagged values of this tag definition. An
     * empty collection is returned if there are no tagged values.
     * </p>
     *
     * @return an unmodifiable view of tagged values of this tag definition.
     */
    public Collection<TaggedValue> getTypedValues() {
        return Collections.unmodifiableCollection(typedValues);
    }

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
    public boolean containsTypedValue(TaggedValue typedValue) {
        Helper.assertNotNull(typedValue, "typedValue");

        return typedValues.contains(typedValue);
    }

    /**
     * <p>
     * Return the number of tagged values for this tag definition.
     * </p>
     *
     * @return the number of tagged values for this tag definition
     */
    public int countTypedValues() {
        return typedValues.size();
    }
}
