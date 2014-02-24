/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractRemoveGraphElementActionImpl.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.impls;

import com.topcoder.uml.actions.auxiliary.AbstractRemoveGraphElementAction;
import com.topcoder.diagraminterchange.GraphElement;

/**
 * <p>
 * Extends AbstractRemoveGraphElementAction. Used for testing.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractRemoveGraphElementActionImpl extends AbstractRemoveGraphElementAction {

    /**
     * <p>
     * Constructs AbstractRemoveGraphElementAction.
     * </p>
     *
     * @param name the presentation name of the undoable action
     * @param node the child graph element to remove from its parent graph node
     * @throws IllegalArgumentException if any argument is null, or name argument is empty string, or node's
     *                                  container is null.
     */
    public AbstractRemoveGraphElementActionImpl(String name, GraphElement node) {
        super(name, node);
    }
}