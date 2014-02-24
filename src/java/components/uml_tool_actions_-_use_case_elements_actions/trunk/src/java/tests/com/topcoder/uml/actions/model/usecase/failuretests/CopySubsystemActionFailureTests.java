/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopySubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

/**
 * <p>
 * Failure test for <code>{@link CopySubsystemAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopySubsystemActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullSubsystem() {
        assertConstructorException(CopySubsystemAction.class, new Class[] {Subsystem.class}, new Object[] {null},
            IllegalArgumentException.class, "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullSubsystem() {
        assertConstructorException(CopySubsystemAction.class, new Class[] {Subsystem.class, Clipboard.class},
            new Object[] {null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CopySubsystemAction.class, new Class[] {Subsystem.class, Clipboard.class},
            new Object[] {new SubsystemImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
