/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import com.topcoder.uml.model.core.*;
import java.util.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Package extends Namespace, GeneralizableElement {

    /**
     * Adds the ElementImport into the elementImports collection. It allows
     * duplicates. Null values are not allowed.
     *
     * @param elementImport
     *            The ElementImport to add to this collection
     * @throws IllegalArgumentException
     *             if elementImport is null
     */
    public void addElementImport(ElementImport elementImport);

    /**
     * Adds the ElementImport instances into the elementImports collection. It
     * allows duplicates. The collection must not be null or contain null
     * elements.
     *
     * @param elementImports
     *            Collection of ElementImport instances to add to the contained
     *            collection
     * @throws IllegalArgumentException
     *             if elementImports is null or it contains null elements
     */
    public void addElementImports(Collection<ElementImport> elementImports);

    /**
     * Removes the first instance, by reference, of the passed ElementImport,
     * from the elementImports collection. Since this is a collection, this
     * operation does not guarantee which instance of the referenced
     * ElementImport will be removed if there are multiple references to the
     * same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         collection
     * @param elementImport
     *            The ElementImport to remove from this collection
     * @throws IllegalArgumentException
     *             if elementImport is null
     */
    public boolean removeElementImport(ElementImport elementImport);

    /**
     * Removes the first instance, by reference, of each passed ElementImport
     * from the contained elementImports collection. Since this is a collection,
     * this operation does not guarantee which instance of the referenced
     * ElementImport will be removed if there are multiple references to the
     * same instance in the collection. This equally applies to the case if
     * there are multiple duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained elementImports
     *         collection has changed, false otherwise.
     * @param elementImports
     *            Collection of ElementImport instances to remove from the
     *            contained collection
     * @throws IllegalArgumentException
     *             if elementImports is null or it contains null elements
     */
    public boolean removeElementImports(Collection<ElementImport> elementImports);

    /**
     * Removes all elements from the elementImports collection.
     */
    public void clearElementImports();

    /**
     * Returns a shallow copy of the elementImports collection.
     *
     * @return shallow copy of the elementImports collection
     */
    public Collection<ElementImport> getElementImports();

    /**
     * Checks if the ElementImport is contained in the elementImports
     * collection. The check is done by reference.
     *
     * @return true if the ElementImport is in the collection, false otherwise
     * @param elementImport
     *            The ElementImport to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if elementImport is null
     */
    public boolean containsElementImport(ElementImport elementImport);

    /**
     * Returns the size of the elementImports collection.
     *
     * @return the number of elements in the collection
     */
    public int countElementImports();
}