/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * This is a mock extends of CopyStateNodeAbstractAction class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockCopyStateNodeAbstractAction extends CopyStateNodeAbstractAction {

    /**
     * <p>
     * Call the super construct.
     * </P>
     *
     * @param state the StateVertex object to copy to clipboard
     * @param clipboard the Clipboard object the StateVertex object is copied to
     *
     * @throws IllegalArgumentException if the state argument is null,
     * or fail to get the system clip board
     */
    public MockCopyStateNodeAbstractAction(StateVertex state, Clipboard clipboard) {
        super(state, clipboard);
    }

}
