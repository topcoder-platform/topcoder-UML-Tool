/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractCutGraphElementActionImpl.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.impls;

import com.topcoder.uml.actions.auxiliary.AbstractCutGraphElementAction;
import com.topcoder.diagraminterchange.GraphElement;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * Extends AbstractCutGraphElementAction. Used for testing.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractCutGraphElementActionImpl extends AbstractCutGraphElementAction {

    /**
     * <p>
     * Constructs AbstractCutGraphElementAction.
     * </p>
     *
     * @param name      the presentation name of the undoable action
     * @param node      the child graph element to remove from its parent graph node
     * @param clipboard the clipboard the child graph element is copied to
     * @throws IllegalArgumentException if any argument is null, or name argument is empty string, or node's
     *                                  container is null.
     */
    public AbstractCutGraphElementActionImpl(String name, GraphElement node, Clipboard clipboard) {
        super(name, node, clipboard);
    }

    /**
     * <p>
     * Does nothing.
     * </p>
     *
     * @param node      the graph element to copy to clipboard.
     * @param clipboard the clipboard to copy the graph element to.
     */
    protected void copyToClipboard(GraphElement node, Clipboard clipboard) {
        //does nothing
    }
}
