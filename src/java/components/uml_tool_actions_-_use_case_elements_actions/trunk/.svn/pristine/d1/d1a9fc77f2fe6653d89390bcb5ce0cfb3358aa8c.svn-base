/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutSubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

/**
 * <p>
 * Failure test for <code>{@link CutSubsystemAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutSubsystemActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullSubsystem() {
        assertConstructorException(CutSubsystemAction.class, new Class[] {Subsystem.class}, new Object[] {null},
            IllegalArgumentException.class, "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullSubsystem() {
        assertConstructorException(CutSubsystemAction.class, new Class[] {Subsystem.class, Clipboard.class},
            new Object[] {null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutSubsystemAction#CutSubsystemAction(Subsystem, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CutSubsystemAction.class, new Class[] {Subsystem.class, Clipboard.class},
            new Object[] {new SubsystemImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
