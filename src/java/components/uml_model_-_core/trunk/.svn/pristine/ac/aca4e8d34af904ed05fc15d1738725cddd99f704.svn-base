/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.Generalization;

import java.util.Collection;

/**
 * <p>
 * A generalizable element is a model element that may participate in a generalization relationship.
 * </p>
 * <p>
 * In the meta model, a GeneralizableElement can be a generalization of other GeneralizableElements (i.e., all Features
 * defined in and all ModelElements contained in the ancestors are also present in the GeneralizableElement).
 * GeneralizableElement is an abstract meta class.
 * </p>
 * <p>
 * A GeneralizableElement has the following properties:
 * <ul>
 * <li>isRoot: Specifies whether the GeneralizableElement is a root GeneralizableElement with no ancestors. True
 * indicates that it may not have ancestors, false indicates that it may have ancestors (whether or not it actually has
 * any ancestors at the moment). </li>
 * <li>isLeaf: Specifies whether the GeneralizableElement is a GeneralizableElement with no descendants. True indicates
 * that it may not have descendants, false indicates that it may have descendants (whether or not it actually has any
 * descendants at the moment). </li>
 * <li>isAbstract: Specifies whether the GeneralizableElement may not have a direct instance. True indicates that an
 * instance of the GeneralizableElement must be an instance of a child of the GeneralizableElement. False indicates that
 * there may be an instance of the GeneralizableElement that is not an instance of a child. An abstract
 * GeneralizableElement is not instantiable since it does not contain all necessary information. </li>
 * <li>generalization: Designates a Generalization whose parent GeneralizableElement is the immediate ancestor of the
 * current GeneralizableElement. </li>
 * <li>specialization: Designates a Generalization whose child GeneralizableElement is the immediate descendant of the
 * current GeneralizableElement. </li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface GeneralizableElement extends ModelElement {
    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root.
     */
    void setRoot(boolean isRoot);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise <code>false</code>.
     */
    boolean isRoot();

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf.
     */
    public void setLeaf(boolean isLeaf);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise <code>false</code>.
     */
    boolean isLeaf();

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract.
     */
    void setAbstract(boolean isAbstract);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise <code>false</code>.
     */
    boolean isAbstract();

    /**
     * <p>
     * Adds a generalization to the collection of the current object.
     * </p>
     *
     * @param generalization
     *            the generalization to be added.
     * @throws IllegalArgumentException
     *             if <code>generalization</code> is null.
     */
    void addGeneralization(Generalization generalization);

    /**
     * <p>
     * Removes a generalization from the collection of the current object.
     * </p>
     *
     * @param generalization
     *            the generalization to be removed.
     * @throws IllegalArgumentException
     *             if <code>generalization</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeGeneralization(Generalization generalization);

    /**
     * <p>
     * Removes all the objects of type "generalization" from the collection of the current object.
     * </p>
     */
    void clearGeneralizations();

    /**
     * <p>
     * Gets all the objects of type "generalization" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Generalization</code> added to the collection of current object.
     */
    Collection<Generalization> getGeneralizations();

    /**
     * <p>
     * Checks if a generalization is contained in the collection of the current object.
     * </p>
     *
     * @param generalization
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>generalization</code> is null.
     * @return <code>true</code> if <code>generalization</code> is contained in the collection of the current
     *         object.
     */
    boolean containsGeneralization(Generalization generalization);

    /**
     * <p>
     * Returns the number of objects of type "generalization" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    int countGeneralizations();

    /**
     * <p>
     * Adds a specialization to the collection of the current object.
     * </p>
     *
     * @param specialization
     *            the specialization to be added.
     * @throws IllegalArgumentException
     *             if <code>specialization</code> is null.
     */
    void addSpecialization(Generalization specialization);

    /**
     * <p>
     * Removes a specialization from the collection of the current object.
     * </p>
     *
     * @param specialization
     *            the specialization to be removed.
     * @throws IllegalArgumentException
     *             if <code>specialization</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeSpecialization(Generalization specialization);

    /**
     * <p>
     * Removes all the objects of type "specialization" from the collection of the current object.
     * </p>
     */
    void clearSpecializations();

    /**
     * <p>
     * Gets all the objects of type "specialization" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>Generalization</code> added to the collection of current object.
     */
    Collection<Generalization> getSpecializations();

    /**
     * <p>
     * Checks if a specialization is contained in the collection of the current object.
     * </p>
     *
     * @param specialization
     *            the element to be tested.
     * @throws IllegalArgumentException
     *             if <code>specialization</code> is null.
     * @return <code>true</code> if <code>specialization</code> is contained in the collection of the current
     *         object.
     */
    boolean containsSpecialization(Generalization specialization);

    /**
     * <p>
     * Returns the number of objects of type "specialization" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    int countSpecializations();
}
