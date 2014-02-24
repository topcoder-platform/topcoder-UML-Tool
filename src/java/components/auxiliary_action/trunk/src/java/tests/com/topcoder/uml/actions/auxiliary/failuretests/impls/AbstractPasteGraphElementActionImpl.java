/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractPasteGraphElementActionImpl.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.impls;

import com.topcoder.uml.actions.auxiliary.AbstractPasteGraphElementAction;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * Extends AbstractPasteGraphElementAction. Used for testing.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractPasteGraphElementActionImpl extends AbstractPasteGraphElementAction {

    /**
     * <p>
     * Constructs AbstractPasteGraphElementAction.
     * </p>
     *
     * @param name    the presentation name of the undoable action
     * @param content the child graph element to paste.
     * @param parent  the parent graph node the child graph element to add to
     * @throws IllegalArgumentException if any argument is null, or name argument is empty string, or the content
     *                                  is not of GraphElement type.
     */
    public AbstractPasteGraphElementActionImpl(String name, Object content, GraphNode parent) {
        super(name, content, parent);
    }
}
