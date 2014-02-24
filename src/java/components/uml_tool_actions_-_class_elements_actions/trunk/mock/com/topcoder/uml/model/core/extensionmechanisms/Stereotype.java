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
public interface Stereotype extends com.topcoder.uml.model.core.GeneralizableElement {
    /**
     * <p>
     * Return the baseClass - the name of UML modeling element the steretype
     * apply to.
     * </p>
     *
     * @return the name of UML modeling element the steretype apply to
     */
    public String getBaseClass();

    /**
     * <p>
     * Set the baseClass - the name of UML modeling element the steretype apply
     * to. The argument could be null or empty string.
     * </p>
     *
     * @param baseClass
     *            the name of UML modeling element the steretype apply to
     */
    public void setBaseClass(String baseClass);

    /**
     * <p>
     * Add a tag definition to this stereotype as a defined tag. Once this
     * method is called, it will automatically remove the TagDefinition object
     * from its original owner if it gets one and it is different from this
     * stereotype, and then change its owner to this stereotype.
     * </p>
     *
     * @param tagDef
     *            a new tag definition added to this stereotype as a defined
     *            tag.
     */
    public void addDefinedTag(TagDefinition tagDef);

    /**
     * <p>
     * Remove a defined tag from this stereotype. Return true if the value to
     * remove exists, return false otherwise. If the given TagDefinition object
     * exists, its owner will be set to null after it is removed.
     * </p>
     *
     * @param tagDef
     *            a defined tag from this stereotype to remove.
     * @return true if the value to remove exists, return false otherwise.
     */
    public boolean removeDefinedTag(TagDefinition tagDef);

    /**
     * <p>
     * Clear all defined tags from this stereotype, and all TagDefiition
     * objects' owner attributes will be set to null.
     * </p>
     */
    public void clearDefinedTags();

    /**
     * <p>
     * Return an unmodifiable view of defined tags in this stereotype. An empty
     * collection is returned if there are no defined tags.
     * </p>
     *
     * @return an unmodifiable view of defined tags of this stereotype.
     */
    public Collection<TagDefinition> getDefinedTags();

    /**
     * <p>
     * Return true if the given TagDefinition object exists as a defined tag in
     * this stereotype, return false otherwise.
     * </p>
     *
     * @param tagDef
     *            The TagDefinition to check for existence.
     * @return true if the given TagDefinition object exists in this stereotype,
     *         return false otherwise.
     */
    public boolean containsDefinedTag(TagDefinition tagDef);

    /**
     * <p>
     * Return the number of defined tags for this stereotype
     * </p>
     *
     * @return the number of defined tags for this stereotype.
     */
    public int countDefinedTags();

    /**
     * <p>
     * Add a ModelElement object to this stereotype as an extended element.
     * </p>
     *
     * @param element
     *            the ModelElement object to add.
     */
    public void addExtendedElement(com.topcoder.uml.model.core.ModelElement element);

    /**
     * <p>
     * Remove an extended element from this stereotype. Return true if the value
     * to remove exists, return false otherwise. NOTE: if the object to remove
     * doesn't exist in this stereotype, nothing is removed, and false is
     * returned. If the collection contains more than one such element, only the
     * first one encountered is removed.
     * </p>
     *
     * @param element
     *            the ModelElement object to remove.
     * @return true if the value to remove exists, return false otherwise.
     */
    public boolean removeExtendedElement(com.topcoder.uml.model.core.ModelElement element);

    /**
     * <p>
     * Clear all extended elements for this stereotype.
     * </p>
     */
    public void clearExtendedElements();

    /**
     * <p>
     * Return an unmodifiable view of extended elements in this stereotype. An
     * empty collection is returned if there are no extended elements.
     * </p>
     *
     * @return an unmodifiable view of extended elements in this stereotype.
     */
    public Collection<ModelElement> getExtendedElements();

    /**
     * <p>
     * Return true if the given ModelElement object exists as an extended
     * element in this stereotype, return false otherwise.
     * </p>
     *
     * @param element
     *            the ModelElement object to check for existence.
     * @return true if the given ModelElement object exists as an extended
     *         element in this stereotype, return false otherwise.
     */
    public boolean containsExtendedElement(com.topcoder.uml.model.core.ModelElement element);

    /**
     * <p>
     * Return the number of extended elements for this stereotype.
     * </p>
     *
     * @return the number of extended elements for this stereotype.
     */
    public int countExtendedElements();
}