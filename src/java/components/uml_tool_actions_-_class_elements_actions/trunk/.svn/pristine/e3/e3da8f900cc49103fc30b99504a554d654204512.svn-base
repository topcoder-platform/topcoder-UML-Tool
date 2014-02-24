/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class NamespaceAbstractImpl extends ModelElementAbstractImpl implements Namespace {

    /**
     * Mock attribute.
     */
    private final Collection<ModelElement> ownedElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected NamespaceAbstractImpl() {
    }

    /**
     * Mock method.
     *
     * @param ownedElement
     */
    public void addOwnedElement(ModelElement ownedElement) {
        ownedElements.add(ownedElement);
    }

    /**
     * Mock method.
     *
     * @return
     * @param ownedElement
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        return ownedElements.remove(ownedElement);
    }

    /**
     * <p>
     * Removes all the objects of type "owned element" from the collection of
     * the current object.
     * </p>
     */
    public void clearOwnedElements() {
    }

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<ModelElement> getOwnedElements() {
        return ownedElements;
    }

    /**
     * Mock method.
     *
     * @param ownedElement
     * @return
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        return ownedElements.contains(ownedElement);
    }

    /**
     * <p>
     * Returns the number of objects of type "owned element" previously added to
     * the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ModelElement</code>
     *         inserted in the collection of the current object
     */
    public int countOwnedElements() {
        return 0;
    }
}