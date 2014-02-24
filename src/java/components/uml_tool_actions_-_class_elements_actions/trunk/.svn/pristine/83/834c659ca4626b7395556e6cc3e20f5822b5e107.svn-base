/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CutAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;

/**
 * <p>
 * Failure test for <code>{@link CutAbstractionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutAbstractionActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutAbstractionAction#CutAbstractionAction(Abstraction)}</code> constructor.
     * method.
     * </p>
     */
    public void testCtor_1_NullAbstraction() {
        assertConstructorException(CutAbstractionAction.class, new Class[] {Abstraction.class}, new Object[] {null},
            IllegalArgumentException.class, "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CutAbstractionAction#CutAbstractionAction(Abstraction, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullAbstraction() {
        assertConstructorException(CutAbstractionAction.class, new Class[] {Abstraction.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the abstraction is null, should throw IllegalArgumentException.");
    }
}
