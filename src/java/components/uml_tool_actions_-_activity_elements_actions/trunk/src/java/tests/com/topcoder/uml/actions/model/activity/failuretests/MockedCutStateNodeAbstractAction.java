/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.activity.CutStateNodeAbstractAction;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * This is a mocked implementation of <code>CutStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedCutStateNodeAbstractAction extends CutStateNodeAbstractAction {
    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param name
     *            the presentation name.
     * @param state
     *            the <code>StateVertex</code> object to copy to clipboard
     * @param clipboard
     *            the <code>Clipboard</code> object the <code>StateVertex</code> object is copied to.
     * @throws IllegalArgumentException
     *             if the <code>state, name</code> is <code>null</code> or name is empty or container in
     *             the state is null.
     */
    protected MockedCutStateNodeAbstractAction(String name, StateVertex state, Clipboard clipboard) {
        super(name, state, clipboard);
    }

}
