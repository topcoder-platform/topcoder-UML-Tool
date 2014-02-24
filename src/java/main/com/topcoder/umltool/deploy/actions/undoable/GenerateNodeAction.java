/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.actions.general.UndoableAbstractAction;

/**
 * <p>
 * This is the base class of all actions which can generate a new node.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public abstract class GenerateNodeAction extends UndoableAbstractAction {

    /**
     * <p>
     * Creates an instance of GenerateNodeAction.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @throws IllegalArgumentException
     *             if presentationName is null or empty
     */
    protected GenerateNodeAction(String presentationName) {
        super(presentationName);
    }

    /**
     * <p>
     * Gets the node generated.
     * </p>
     * @return the node generated
     */
    public abstract Node getNode();
}
