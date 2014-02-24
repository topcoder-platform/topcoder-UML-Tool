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
public class StereotypeImpl extends com.topcoder.uml.model.core.GeneralizableElementAbstractImpl implements Stereotype {

    /**
     * Mock attribute.
     */
    private String baseClass;

    /**
     * Mock attribute.
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
     * Constructor.
     * </p>
     *
     * @param baseClass
     *            the name of UML modeling element the steretype apply to
     * @param definedTags
     *            a collection of TagDefinition objects.
     * @param extendedElements
     *            a collection of ModelElement objects.
     */
    public StereotypeImpl(String baseClass, Collection<TagDefinition> definedTags,
            Collection<ModelElement> extendedElements) {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public String getBaseClass() {
        return this.baseClass;
    }

    /**
     * Mock method.
     *
     * @param
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
     * </p>
     *
     * @param tagDef
     *            The TagDefinition object to add.
     */
    public void addDefinedTag(TagDefinition tagDef) {
    }

    /**
     * <p>
     * Remove a defined tag from this stereotype. Return true if the value to
     * remove exists, return false otherwise. If the given TagDefinition object
     * exists, its owner will be set to null after it is removed.
     * </p>
     *
     * @param tagDef
     *            The TagDefinition object to remove
     * @return true if the tag is removed successfully, return false otherwise.
     */
    public boolean removeDefinedTag(TagDefinition tagDef) {
        return false;
    }

    /**
     * <p>
     * Clear all defined tags for this stereotype. and all TagDefiition objects'
     * owner attributes will be set to null. Foreach element in definedTags
     * collection, set its owner attribute to null, and then call
     * definedTags.clear().
     * </p>
     */
    public void clearDefinedTags() {
    }

    /**
     * <p>
     * Return an unmodifiable view of definedTags collection of this stereotype.
     * Simply return Collections.unmodifiableCollection(this.definedTags) An
     * empty collection is returned if there are no defined tags.
     * </p>
     *
     * @return an unmodifiable view of definedTags collection of this
     *         stereotype.
     */
    public Collection<TagDefinition> getDefinedTags() {
        return null;
    }

    /**
     * <p>
     * Return true if the given TagDefinition object exists in the definedTags
     * collection, return false otherwise, Simply return
     * definedTags.contains(tagDef).
     * </p>
     *
     * @param tagDef
     *            The TagDefinition to check for existence.
     * @return true if the given TagDefinition object exists in the definedTags
     *         collection, return false otherwise
     */
    public boolean containsDefinedTag(TagDefinition tagDef) {
        return false;
    }

    /**
     * <p>
     * Return the number of defined tags for this stereotype, simply return
     * this.definedTags.size().
     * </p>
     *
     * @return the number of defined tags for this stereotype
     */
    public int countDefinedTags() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @param element
     */
    public void addExtendedElement(com.topcoder.uml.model.core.ModelElement element) {
        this.extendedElements.add(element);
    }

    /**
     * <p>
     * Remove an extended element from this stereotype. Return true if the value
     * to remove exists, return false otherwise. Simply call
     * extendedElements.remove(element). NOTE: if the object to remove doesn't
     * exist in the collection, nothing happens. If the collection contains more
     * than one such element, only the first one encountered is removed.
     * </p>
     *
     * @param element
     *            the ModelElement object to remove.
     * @return true if the value to remove exists, return false otherwise.
     */
    public boolean removeExtendedElement(com.topcoder.uml.model.core.ModelElement element) {
        return false;
    }

    /**
     * <p>
     * Clear all ModelElement objects in extendedElements collection. Simply
     * call extendedElements.clear().
     * </p>
     */
    public void clearExtendedElements() {
    }

    /**
     * <p>
     * Return an unmodifiable view of extendedElements collection of this
     * stereotype. Simply return
     * Collections.unmodifiableCollection(this.extendedElements) An empty
     * collection is returned if there are no defined tags.
     * </p>
     *
     * @return an unmodifiable view of extendedElements collection of this
     *         stereotype.
     */
    public Collection<ModelElement> getExtendedElements() {
        return null;
    }

    /**
     * Mock method.
     *
     * @param element
     * @return
     */
    public boolean containsExtendedElement(com.topcoder.uml.model.core.ModelElement element) {
        return this.extendedElements.contains(element);
    }

    /**
     * <p>
     * Return the number of extended elements for this stereotype, simply return
     * this.extendedElements.size().
     * </p>
     *
     * @return the number of extended elements for this stereotype
     */
    public int countExtendedElements() {
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