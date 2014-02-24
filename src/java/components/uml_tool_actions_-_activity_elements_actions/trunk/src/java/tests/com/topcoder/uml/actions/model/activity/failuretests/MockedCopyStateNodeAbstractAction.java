/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.activity.CopyStateNodeAbstractAction;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * This is a mocked implementation of <code>CopyStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedCopyStateNodeAbstractAction extends CopyStateNodeAbstractAction {
    /**
     * <p>
     * Constructor.
     *
     * @param state
     *            the StateVertex object to copy to clipboard
     * @param clipboard
     *            the Clipboard object the StateVertex object is copied to. Can be <code>null</code>.
     * @throws IllegalArgumentException
     *             if the state argument is <code>null</code>.
     */
    protected MockedCopyStateNodeAbstractAction(StateVertex state, Clipboard clipboard) {
        super(state, clipboard);
    }

}
