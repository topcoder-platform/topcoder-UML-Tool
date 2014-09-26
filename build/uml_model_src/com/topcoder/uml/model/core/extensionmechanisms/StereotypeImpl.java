/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * StereotypeImpl class implements Stereotype interface and extends the
 * GeneralizableElementAbstractImpl abstract class. it is mainly used to
 * differentiate the model elements so that they could have different meanings
 * or usages even if they have identical structure, the stereotype could specify
 * tag definitions to the model elements such as the attributes, associations,
 * operations etc. And a stereotype could also be a subclass of another
 * stereotype, in this case, it will inherit all the constraints and tagged
 * values from its supertype, but the parent-child stereotype must have the same
 * kind of base class.
 * </p>
 * <p>
 * Thread-safety: This class is mutable and not thread-safe.
 * </p>
 *
 * @author Standlove, BLE
 * @version 1.0
 */
public class StereotypeImpl extends GeneralizableElementAbstractImpl implements Stereotype {

    /**
     * <p>
     * Represents the name of UML modeling element the stereotype apply to. It
     * should be the name of a metaclass in the UML metamodel, like Class,
     * Association, etc, rather than the user model class. It is initially null,
     * and accessed and changed through its getter and setter. It could be null
     * or empty string.
     * </p>
     */
    private String baseClass = null;

    /**
     * <p>
     * Represents a collection of TagDefinition objects, each element in the
     * collection specifies the tags the stereotype can have. It is initialized
     * in place to an empty ArrayList&lt;TagDefinition&gt; object, and this
     * reference would never be changed afterwards. It has a bunch of
     * corresponding methods to update/access the content of this collection.
     * </p>
     */
    private final Collection<TagDefinition> definedTags = new ArrayList<TagDefinition>();

    /**
     * <p>
     * Represents a collection of ModelElement objects affected by this
     * stereotype, each element in this collection must be a kind of model
     * element specified by the baseClass attribute. It is initialized in place
     * to an empty ArrayList&lt;ModelElement&gt; object, and this reference
     * would never be changed afterwards. It has a bunch of corresponding
     * methods to update/access the content of this collection.
     * </p>
     */
    private final Collection<ModelElement> extendedElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public StereotypeImpl() {
    }

    /**
     * <p>
     * Constructor with all attributes.
     * </p>
     *
     * @param baseClass the name of UML modeling element the stereotype apply to
     * @param definedTags a collection of TagDefinition objects.
     * @param extendedElements a collection of ModelElement objects.
     * @throws IllegalArgumentException if any collection argument is null, or
     *             any collection argument contains null element. NOTE: the
     *             collection arguments could contain 0 elements. the baseClass
     *             argument could be null or empty string.
     */
    public StereotypeImpl(String baseClass, Collection<TagDefinition> definedTags,
            Collection<ModelElement> extendedElements) {
        Helper.assertNotNullOrContainsNull(definedTags, "definedTags");
        Helper.assertNotNullOrContainsNull(extendedElements, "extendedElements");
        setBaseClass(baseClass);

        // Add definedTags
        for (TagDefinition tag : definedTags) {
            addDefinedTag(tag);
        }

        // Add extendedElements
        this.extendedElements.addAll(extendedElements);
    }

    /**
     * <p>
     * Return the baseClass attribute - the name of UML modeling element the
     * stereotype apply to.
     * </p>
     *
     * @return the name of UML modeling element the stereotype apply to
     */
    public String getBaseClass() {
        return baseClass;
    }

    /**
     * <p>
     * Set the baseClass attribute - the name of UML modeling element the
     * stereotype apply to. The argument could be null or empty string.
     * </p>
     *
     * @param baseClass the name of UML modeling element the stereotype apply to
     */
    public void setBaseClass(String baseClass) {
        this.baseClass = baseClass;
    }

    /**
     * <p>
     * Add a tag definition to this stereotype as a defined tag. Once this
     * method is called, it will automatically remove the TagDefinition object
     * from its original owner if it gets one and it is different from this
     * stereotype, and then change its owner to this stereotype.
     * <p>
     * </p>
     * NOTE: Duplication is allowed.
     * </p>
     *
     * @param tagDef The TagDefinition object to add.
     * @throws IllegalArgumentException if the argument is null.
     */
    public void addDefinedTag(TagDefinition tagDef) {
        Helper.assertNotNull(tagDef, "tagDef");

        Stereotype owner = tagDef.getOwner();

        // Remove the TagDefinition object from its original owner
        if (owner != null && owner != this) {
            owner.removeDefinedTag(tagDef);
        }

        // Add the tag definition to this stereotype
        tagDef.setOwner(this);
        definedTags.add(tagDef);
    }

    /**
     * <p>
     * Remove a defined tag from this stereotype. Return true if the value to
     * remove exists, return false otherwise. If the given TagDefinition object
     * exists and is unique in this stereotype, its owner will be set to null
     * after it is removed.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in this stereotype, nothing
     * is removed, and false is returned. If the collection contains more than
     * one such element, only the first one encountered is removed.
     * </p>
     *
     * @param tagDef The TagDefinition object to remove
     * @return true if the tag is removed successfully, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeDefinedTag(TagDefinition tagDef) {
        Helper.assertNotNull(tagDef, "tagDef");
        boolean ret = definedTags.remove(tagDef);
        if (ret && !definedTags.contains(tagDef)) {
            tagDef.setOwner(null);
        }
        return ret;
    }

    /**
     * <p>
     * Clear all defined tags for this stereotype. and all TagDefiition objects'
     * owner attributes will be set to null.
     * </p>
     */
    public void clearDefinedTags() {
        for (Iterator it = definedTags.iterator(); it.hasNext();) {
            ((TagDefinition) it.next()).setOwner(null);
        }
        definedTags.clear();
    }

    /**
     * <p>
     * Return an unmodifiable view of definedTags collection of this stereotype.
     * An empty collection is returned if there are no defined tags.
     * </p>
     *
     * @return an unmodifiable view of definedTags collection of this
     *         stereotype.
     */
    public Collection<TagDefinition> getDefinedTags() {
        return Collections.unmodifiableCollection(definedTags);
    }

    /**
     * <p>
     * Return true if the given TagDefinition object exists in the definedTags
     * collection, return false otherwise.
     * </p>
     *
     * @param tagDef The TagDefinition to check for existence.
     * @return true if the given TagDefinition object exists in the definedTags
     *         collection, return false otherwise
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean containsDefinedTag(TagDefinition tagDef) {
        Helper.assertNotNull(tagDef, "tagDef");

        return definedTags.contains(tagDef);
    }

    /**
     * <p>
     * Return the number of defined tags for this stereotype.
     * </p>
     *
     * @return the number of defined tags for this stereotype
     */
    public int countDefinedTags() {
        return definedTags.size();
    }

    /**
     * <p>
     * Add a ModelElement object to this stereotype as an extended element.
     * <p>
     * </p>
     * NOTE: Duplication is allowed.
     * </p>
     *
     * @param element The ModelElement object to add.
     * @throws IllegalArgumentException if the argument is null.
     */
    public void addExtendedElement(ModelElement element) {
        Helper.assertNotNull(element, "element");

        extendedElements.add(element);
    }

    /**
     * <p>
     * Remove an extended element from this stereotype. Return true if the value
     * to remove exists, return false otherwise.
     * <p>
     * </p>
     * NOTE: if the object to remove doesn't exist in the collection, nothing
     * happens. If the collection contains more than one such element, only the
     * first one encountered is removed.
     * </p>
     *
     * @param element the ModelElement object to remove.
     * @return true if the value to remove exists, return false otherwise.
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean removeExtendedElement(ModelElement element) {
        Helper.assertNotNull(element, "element");

        return extendedElements.remove(element);
    }

    /**
     * <p>
     * Clear all ModelElement objects in extendedElements collection.
     * </p>
     */
    public void clearExtendedElements() {
        extendedElements.clear();
    }

    /**
     * <p>
     * Return an unmodifiable view of extendedElements collection of this
     * stereotype. An empty collection is returned if there are no defined tags.
     * </p>
     *
     * @return an unmodifiable view of extendedElements collection of this
     *         stereotype.
     */
    public Collection<ModelElement> getExtendedElements() {
        return Collections.unmodifiableCollection(extendedElements);
    }

    /**
     * <p>
     * Return true if the given ModelElement object exists in the
     * extendedElements collection, return false otherwise.
     * </p>
     *
     * @param element The ModelElement object to check for existence.
     * @return true if the given ModelElement object exists in the
     *         extendedElements collection, return false otherwise
     * @throws IllegalArgumentException if the argument is null.
     */
    public boolean containsExtendedElement(ModelElement element) {
        Helper.assertNotNull(element, "element");

        return extendedElements.contains(element);
    }

    /**
     * <p>
     * Return the number of extended elements for this stereotype.
     * </p>
     *
     * @return the number of extended elements for this stereotype
     */
    public int countExtendedElements() {
        return extendedElements.size();
    }
}
