/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;

/**
 * <p>
 * This is a simple concrete implementation of Package interface and extends
 * GeneralizableElementAbstractImpl from the Core Requirements component. To
 * facilitate complete implementation of methods in the interface, the methods
 * in Namespace interface are implemented but all they do is defer to in
 * internal concrete implementation of that Namespace. In fact, it will be a
 * simple inner concrete extension of NamespaceAbstractImpl, which also comes
 * from the Core Requirements component. As such, all methods in Collaboration
 * are supported.
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
public class PackageImpl extends GeneralizableElementAbstractImpl implements Package {

    /**
     * Represents the Namespace branch of the inheritance. Due to inheritance
     * limitations to just one branch, we need to use the other branch via
     * delegation. All Namespace method calls implemented in this class will be
     * routed to this instance. Note that this class uses its own concrete
     * extension of NamespaceAbstractImpl so it can be instantiated.
     */
    private Namespace innerNamespace = new NamespaceImpl();

    /**
     * <p>
     * Represents The collection of all imports in this package. It will support
     * ElementImport elements.
     * </p>
     * <p>
     * This collection will be initialized upon construction, and will have many
     * accessors methods, including adding and removing an element or elements,
     * checking if the element is in the collection (by reference), counting the
     * number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the
     * collection. Null values will not be allowed.
     * </p>
     */
    private final Collection<ElementImport> elementImports = new ArrayList<ElementImport>();

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public PackageImpl() {
    }

    /**
     * Adds the ElementImport into the elementImports collection. It allows
     * duplicates. Null values are not allowed.
     * @param elementImport The ElementImport to add to this collection
     * @throws IllegalArgumentException if elementImport is null
     */
    public void addElementImport(ElementImport elementImport) {
        if (elementImport == null) {
            throw new IllegalArgumentException("parameter elementImport must not be null");
        }
        elementImports.add(elementImport);
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
        if (elementImports == null) {
            throw new IllegalArgumentException("parameter elementImports must not be null");
        }
        if (elementImports.contains(null)) {
            throw new IllegalArgumentException("collection elementImports must not contain nulls");
        }
        this.elementImports.addAll(elementImports);
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
        if (elementImport == null) {
            throw new IllegalArgumentException("parameter elementImport must not be null");
        }
        return removeElementImportByReference(elementImport);
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
        if (elementImports == null) {
            throw new IllegalArgumentException("parameter elementImports must not be null");
        }
        if (elementImports.contains(null)) {
            throw new IllegalArgumentException("collection elementImports must not contain nulls");
        }
        boolean removed = false;
        for (ElementImport elementImport:elementImports) {
            if (removeElementImportByReference(elementImport)) {
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes all elements from the elementImports collection.
     */
    public void clearElementImports() {
        this.elementImports.clear();
    }

    /**
     * Returns a shallow copy of the elementImports collection.
     * @return shallow copy of the elementImports collection
     */
    public Collection<ElementImport> getElementImports() {
        return new ArrayList<ElementImport>(elementImports);
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
        if (elementImport == null) {
            throw new IllegalArgumentException("parameter elementImport must not be null");
        }
        for (ElementImport currentElementImport:elementImports) {
            if (currentElementImport == elementImport) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the size of the elementImports collection.
     * @return the number of elements in the collection
     */
    public int countElementImports() {
        return this.elementImports.size();
    }

    /**
     * Adds the ModelElement into the ownedElements collection. It allows
     * duplicates. Null values are not allowed.
     * @param ownedElement The ModelElement to add to this collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public void addOwnedElement(ModelElement ownedElement) {
        innerNamespace.addOwnedElement(ownedElement);
    }

    /**
     * <p>
     * Removes the first instance, by reference, of the passed ModelElement,
     * from the ownedElements collection.
     * </p>
     * <p>
     * Since this is a collection, this operation does not guarantee which
     * instance of the referenced ModelElement will be removed if there are
     * multiple references to the same instance in the collection.
     * </p>
     * @return true if the instance was in the collection and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         collection
     * @param ownedElement The ModelElement to remove from this collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        return innerNamespace.removeOwnedElement(ownedElement);
    }

    /**
     * Removes all elements from the ownedElements collection.
     */
    public void clearOwnedElements() {
        innerNamespace.clearOwnedElements();
    }

    /**
     * Returns a shallow copy of the ownedElements collection.
     * @return shallow copy of the ownedElements collection
     */
    public Collection<ModelElement> getOwnedElements() {
        return innerNamespace.getOwnedElements();
    }

    /**
     * Checks if the ModelElement is contained in the ownedElements collection.
     * The check is done by reference.
     * @return true if the ModelElement is in the collection, false otherwise
     * @param ownedElement The ModelElement to check for its presence in this
     *            collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("parameter ownedElement must not be null");
        }
        return innerNamespace.containsOwnedElement(ownedElement);
    }

    /**
     * Returns the size of the ownedElements collection.
     * @return the number of elements in the collection
     */
    public int countOwnedElements() {
        return innerNamespace.countOwnedElements();
    }

    /**
     * Inner class that represents a concrete extension of Namespace. It simply
     * provides a concrete wrapper of the NamespaceAbstractImpl for this class
     * so it can make use of the logic in the Namespace branch of
     * implementation.
     * <p>
     * <strong>Thread Safety</strong>
     * </p>
     * <p>
     * This class is mutable and not thread-safe.
     * </p>
     * <p>
     * </p>
     */
    private class NamespaceImpl extends NamespaceAbstractImpl {

        /**
         * <p>
         * Empty constructor.
         * </p>
         */
        public NamespaceImpl() {
        }
    }

    /**
     * Removing the element import from collection by reference.
     * @param elementImport instance to be removed
     * @return whether element import was removed
     */
    private boolean removeElementImportByReference(ElementImport elementImport) {
        // iterating through existing collection
        for (Iterator<ElementImport> iter = elementImports.iterator(); iter.hasNext();) {
            // in case element import is found by reference, then remove
            if (iter.next() == elementImport) {
                iter.remove();
                return true;
            }
        }
        return false;
    }
}