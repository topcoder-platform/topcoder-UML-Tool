/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.core.relationships.Generalization;

import java.util.Collection;
import java.util.ArrayList;

/**
 * <p>
 * This abstract class is a default implementation of the <code>GeneralizableElement</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that are
 * set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously be
 * <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
 * <code>null</code> references while they can contain duplicate entries.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread-safe, since thread safety should be handled by the application
 * itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public abstract class GeneralizableElementAbstractImpl extends ModelElementAbstractImpl implements
    GeneralizableElement {

    /**
     * <p>
     * Specifies whether the GeneralizableElement is a root GeneralizableElement with no ancestors.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isRoot;

    /**
     * <p>
     * Specifies whether the GeneralizableElement is a GeneralizableElement with no descendants.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isLeaf;

    /**
     * <p>
     * Specifies whether the GeneralizableElement may not have a direct instance.
     * </p>
     * <p>
     * This value is initially left set to false; after construction, it can be set to either true or false through the
     * appropriate setter.
     * </p>
     */
    private boolean isAbstract;

    /**
     * <p>
     * Designates a Generalization whose parent GeneralizableElement is the immediate ancestor of the current
     * GeneralizableElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Generalization> generalizations = new ArrayList<Generalization>();

    /**
     * <p>
     * Designates a Generalization whose child GeneralizableElement is the immediate descendant of the current
     * GeneralizableElement.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<Generalization> specializations = new ArrayList<Generalization>();

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected GeneralizableElementAbstractImpl() {
    }

    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root.
     */
    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise <code>false</code>.
     */
    public boolean isRoot() {
        return isRoot;
    }

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf.
     */
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise <code>false</code>.
     */
    public boolean isLeaf() {
        return isLeaf;
    }

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract.
     */
    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise <code>false</code>.
     */
    public boolean isAbstract() {
        return isAbstract;
    }

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
    public void addGeneralization(Generalization generalization) {
        if (generalization == null) {
            throw new IllegalArgumentException("The generalization to be added can't be null.");
        }
        generalizations.add(generalization);
    }

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
    public boolean removeGeneralization(Generalization generalization) {
        if (generalization == null) {
            throw new IllegalArgumentException("The generalization to be removed can't be null.");
        }
        return generalizations.remove(generalization);
    }

    /**
     * <p>
     * Removes all the objects of type "generalization" from the collection of the current object.
     * </p>
     */
    public void clearGeneralizations() {
        generalizations.clear();
    }

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
    public Collection<Generalization> getGeneralizations() {
        return new ArrayList<Generalization>(generalizations);
    }

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
    public boolean containsGeneralization(Generalization generalization) {
        if (generalization == null) {
            throw new IllegalArgumentException("The generalization to be tested can't be null.");
        }
        return generalizations.contains(generalization);
    }

    /**
     * <p>
     * Returns the number of objects of type "generalization" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    public int countGeneralizations() {
        return generalizations.size();
    }

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
    public void addSpecialization(Generalization specialization) {
        if (specialization == null) {
            throw new IllegalArgumentException("The specialization to be added can't be null.");
        }
        specializations.add(specialization);
    }

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
    public boolean removeSpecialization(Generalization specialization) {
        if (specialization == null) {
            throw new IllegalArgumentException("The specialization to be removed can't be null.");
        }
        return specializations.remove(specialization);
    }

    /**
     * <p>
     * Removes all the objects of type "specialization" from the collection of the current object.
     * </p>
     */
    public void clearSpecializations() {
        specializations.clear();
    }

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
    public Collection<Generalization> getSpecializations() {
        return new ArrayList<Generalization>(specializations);
    }

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
    public boolean containsSpecialization(Generalization specialization) {
        if (specialization == null) {
            throw new IllegalArgumentException("The specialization to be tested can't be null.");
        }
        return specializations.contains(specialization);
    }

    /**
     * <p>
     * Returns the number of objects of type "specialization" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Generalization</code> inserted in the collection of the current
     *         object.
     */
    public int countSpecializations() {
        return specializations.size();
    }
}
