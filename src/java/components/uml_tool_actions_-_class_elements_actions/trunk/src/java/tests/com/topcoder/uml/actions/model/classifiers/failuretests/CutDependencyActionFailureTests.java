/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;

/**
 * <p>
 * Failure test for <code>{@link CopyDependencyAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutDependencyActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyDependencyAction#CopyDependencyAction(Dependency)}</code> constructor.
     * method.
     * </p>
     */
    public void testCtor_1_NullDependency() {
        assertConstructorException(CopyDependencyAction.class, new Class[] {Dependency.class}, new Object[] {null},
            IllegalArgumentException.class, "If the dependency is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyDependencyAction#CopyDependencyAction(Dependency, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullDependency() {
        assertConstructorException(CopyDependencyAction.class, new Class[] {Dependency.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the dependency is null, should throw IllegalArgumentException.");
    }
}
