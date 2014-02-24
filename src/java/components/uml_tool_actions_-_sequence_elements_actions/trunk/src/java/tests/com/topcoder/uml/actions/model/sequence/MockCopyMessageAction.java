/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This class is the mock extension of CopyMessageAction used for testing.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MockCopyMessageAction extends CopyMessageAction {

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus is <code>null</code>.
     */
    public MockCopyMessageAction(Stimulus stimulus) {
        super(stimulus);
    }

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus, clipboard is <code>null</code>.
     */
    public MockCopyMessageAction(Stimulus stimulus, Clipboard clipboard) {
        super(stimulus, clipboard);
    }

}
