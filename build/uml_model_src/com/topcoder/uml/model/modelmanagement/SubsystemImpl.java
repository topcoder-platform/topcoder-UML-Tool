/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.util.Collection;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;

/**
 * <p>
 * This is a simple concrete implementation of Subsystem interface and extends
 * ClassifierAbstractImpl from the Core Requirements component. To facilitate
 * complete implementation of methods in the interface, the methods in Package
 * interface are implemented but all they do is defer to in internal concrete
 * implementation of that Package ? PackageImpl. As such, all methods in
 * Subsystem are supported.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * This class is mutable and not thread-safe.
 * </p>
 * @author argolite, vilain
 * @version 1.0
 */
public class SubsystemImpl extends ClassifierAbstractImpl implements Subsystem {

    /**
     * <p>
     * States whether a Subsystem is instantiable or not. If false, the
     * Subsystem represents a unique part of the physical system; otherwise,
     * there may be several system parts with the same definition..
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter.
     * </p>
     */
    private boolean instantiable;

    /**
     * Represents the Package implementation that handles the Package's branch
     * of method actions. This allows this class to implement multiple
     * interfaces and support all methods, and still utilize the default
     * implementations, but using delegation instead of inheritance. Thus, all
     * Package-related methods will be deferred to it.
     */
    private final Package packageImpl = new PackageImpl();

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public SubsystemImpl() {
    }

    /**
     * Gets the boolean instantiable field value.
     * @return instantiable field value
     */
    public boolean isInstantiable() {
        return instantiable;
    }

    /**
     * Sets the boolean instantiable field value.
     * @param instantiable instantiable field value
     */
    public void setInstantiable(boolean instantiable) {
        this.instantiable = instantiable;
    }

    /**
     * Adds the ElementImport into the elementImports collection. It allows
     * duplicates. Null values are not allowed.
     * @param elementImport The ElementImport to add to this collection
     * @throws IllegalArgumentException if elementImport is null
     */
    public void addElementImport(ElementImport elementImport) {
        packageImpl.addElementImport(elementImport);
    }

    /**
     * Adds the ElementImport instances into the elementImports collection. It
     * allows duplicates. The collection must not be null or contain null
     * elements.
     * @param elementImports Collection of ElementImport instances to add to the
     *            contained collection
     * @throws IllegalArgumentException if elementImports is null or it contains
     *             null elements
     */
    public void addElementImports(Collection<ElementImport> elementImports) {
        packageImpl.addElementImports(elementImports);
    }

    /**
     * <p>
     * Removes the first instance, by reference, of the passed ElementImport,
     * from the elementImports collection.
     * </p>
     * <p>
     * Since this is a collection, this operation does not guarantee which
     * instance of the referenced ElementImport will be removed if there are
     * multiple references to the same instance in the collection.
     * </p>
     * @return true if the instance was in the collection and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         collection
     * @param elementImport The ElementImport to remove from this collection
     * @throws IllegalArgumentException if elementImport is null
     */
    public boolean removeElementImport(ElementImport elementImport) {
        return packageImpl.removeElementImport(elementImport);
    }

    /**
     * <p>
     * Removes the first instance, by reference, of each passed ElementImport
     * from the contained elementImports collection.
     * </p>
     * <p>
     * Since this is a collection, this operation does not guarantee which
     * instance of the referenced ElementImport will be removed if there are
     * multiple references to the same instance in the collection.
     * </p>
     * <p>
     * This equally applies to the case if there are multiple duplicates in the
     * passed collection.
     * </p>
     * @return boolean True if the state of the contained elementImports
     *         collection has changed, false otherwise.
     * @param elementImports Collection of ElementImport instances to remove
     *            from the contained collection
     * @throws IllegalArgumentException if elementImports is null or it contains
     *             null elements
     */
    public boolean removeElementImports(Collection<ElementImport> elementImports) {
        return packageImpl.removeElementImports(elementImports);
    }

    /**
     * Removes all elements from the elementImports collection.
     */
    public void clearElementImports() {
        packageImpl.clearElementImports();
    }

    /**
     * Returns a shallow copy of the elementImports collection.
     * @return shallow copy of the elementImports collection
     */
    public Collection<ElementImport> getElementImports() {
        return packageImpl.getElementImports();
    }

    /**
     * Checks if the ElementImport is contained in the elementImports
     * collection. The check is done by reference.
     * @return true if the ElementImport is in the collection, false otherwise
     * @param elementImport The ElementImport to check for its presence in this
     *            collection
     * @throws IllegalArgumentException if elementImport is null
     */
    public boolean containsElementImport(ElementImport elementImport) {
        return packageImpl.containsElementImport(elementImport);
    }

    /**
     * Returns the size of the elementImports collection.
     * @return the number of elements in the collection
     */
    public int countElementImports() {
        return packageImpl.countElementImports();
    }
}