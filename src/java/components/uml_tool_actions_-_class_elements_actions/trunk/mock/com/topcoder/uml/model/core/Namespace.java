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
public interface Namespace extends com.topcoder.uml.model.core.ModelElement {

    /**
     * Mock method.
     *
     * @param ownedElement
     */
    public void addOwnedElement(ModelElement ownedElement);

    /**
     * Mock method.
     *
     * @param ownedElement
     * @return
     */
    public boolean removeOwnedElement(ModelElement ownedElement);

    /**
     * Mock method.
     */
    public void clearOwnedElements();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<ModelElement> getOwnedElements();

    /**
     * Mock method.
     *
     * @param ownedElement
     * @return
     */
    public boolean containsOwnedElement(ModelElement ownedElement);

    /**
     * Mock method.
     *
     * @return
     */
    public int countOwnedElements();
}