/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * Mock class.
 * 
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class GeneralizableElementAbstractImpl extends ModelElementAbstractImpl implements GeneralizableElement {

    /**
     * Mock attriubte.
     */
    private Collection<Generalization> generalizations = new ArrayList<Generalization>();

    /**
     * Mock attriubte.
     */
    private Collection<Generalization> specializations = new ArrayList<Generalization>();

    /**
     * Mock attriubte.
     */
    private boolean isRoot;

    /**
     * Mock attriubte.
     */
    private boolean isLeaf;

    /**
     * Mock attriubte.
     */
    private boolean isAbstract;

    /**
     * Mock method.
     * 
     * @param isRoot
     */
    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    /**
     * Mock method.
     * 
     * @return
     */
    public boolean isRoot() {
        return this.isRoot;
    }

    /**
     * Mock method.
     * 
     * @param isLeaf
     */
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * Mock method.
     * 
     * @return
     */
    public boolean isLeaf() {
        return this.isLeaf;
    }

    /**
     * Mock method.
     * 
     * @param isAbstract
     */
    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     * Mock method.
     * 
     * @return
     */
    public boolean isAbstract() {
        return this.isAbstract;
    }

    /**
     * <p>
     * Adds a generalization to the collection of the current object.
     * </p>
     * 
     * @param generalization
     *            the generalization to be added
     * @throws IllegalArgumentException
     *             if <code>generalization</code> is null
     */
    public void addGeneralization(Generalization generalization) {
        this.generalizations.add(generalization);
    }

    /**
     * <p>
     * Removes a generalization from the collection of the current object.
     * </p>
     * 
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         generalization
     * @param generalization
     *            the generalization to be removed
     * @throws IllegalArgumentException
     *             if <code>generalization</code> is null
     */
    public boolean removeGeneralization(Generalization generalization) {
        return this.generalizations.remove(generalization);
    }

    /**
     * <p>
     * Removes all the objects of type "generalization" from the collection of
     * the current object.
     * </p>
     */
    public void clearGeneralizations() {
    }

    /**
     * <p>
     * Gets all the objects of type "generalization" previously added to the
     * collection of the current object.
     * </p>
     * 
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Generalization</code> added to the
     *         collection of current object
     */
    public Collection<Generalization> getGeneralizations() {
        return this.generalizations;
    }

    /**
     * <p>
     * Checks if a generalization is contained in the collection of the current
     * object.
     * </p>
     * 
     * @return <code>true</code> if <code>generalization</code> is contained
     *         in the collection of the current object
     * @param generalization
     */
    public boolean containsGeneralization(Generalization generalization) {
        return this.generalizations.contains(generalization);
    }

    /**
     * <p>
     * Returns the number of objects of type "generalization" previously added
     * to the collection of the current object.
     * </p>
     * 
     * @return the quantity of objects of type <code>Generalization</code>
     *         inserted in the collection of the current object
     */
    public int countGeneralizations() {
        return 0;
    }

    /**
     * <p>
     * Adds a specialization to the collection of the current object.
     * </p>
     * 
     * @param specialization
     *            the specialization to be added
     * @throws IllegalArgumentException
     *             if <code>specialization</code> is null
     */
    public void addSpecialization(Generalization specialization) {
        this.specializations.add(specialization);
    }

    /**
     * <p>
     * Removes a specialization from the collection of the current object.
     * </p>
     * 
     * @return <code>true</code> if the current object state changed because
     *         of the removal, i.e. its collection contained the specified
     *         specialization
     * @param specialization
     *            the specialization to be removed
     * @throws IllegalArgumentException
     *             if <code>specialization</code> is null
     */
    public boolean removeSpecialization(Generalization specialization) {
        return this.specializations.remove(specialization);
    }

    /**
     * <p>
     * Removes all the objects of type "specialization" from the collection of
     * the current object.
     * </p>
     */
    public void clearSpecializations() {
    }

    /**
     * <p>
     * Gets all the objects of type "specialization" previously added to the
     * collection of the current object.
     * </p>
     * 
     * @return a <code>java.util.Collection</code> instance, containing all
     *         the objects of type <code>Generalization</code> added to the
     *         collection of current object
     */
    public Collection<Generalization> getSpecializations() {
        return this.specializations;
    }

    /**
     * <p>
     * Checks if a specialization is contained in the collection of the current
     * object.
     * </p>
     * 
     * @return <code>true</code> if <code>specialization</code> is contained
     *         in the collection of the current object
     * @param specialization
     */
    public boolean containsSpecialization(Generalization specialization) {
        return this.specializations.contains(specialization);
    }

    /**
     * <p>
     * Returns the number of objects of type "specialization" previously added
     * to the collection of the current object.
     * </p>
     * 
     * @return the quantity of objects of type <code>Generalization</code>
     *         inserted in the collection of the current object
     */
    public int countSpecializations() {
        return 0;
    }
}