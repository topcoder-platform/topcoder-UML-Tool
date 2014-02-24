/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CopyDependencyAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyDependencyActionTest extends TestCase {

    /**
     * The Dependency instance for the test.
     */
    private Dependency dependency = new DependencyImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Dependency), with correct dependency.
     */
    public void testCtor1() {
        CopyDependencyAction copyAction = new CopyDependencyAction(dependency);

        assertTrue("Should be a CopyDependencyAction instance.", copyAction instanceof CopyDependencyAction);
    }

    /**
     * Test Constructor(Dependency), with null dependency.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullDependency() {
        try {
            new CopyDependencyAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Dependency, Clipboard), with correct dependency and
     * clipboard.
     */
    public void testCtor2() {
        CopyDependencyAction copyAction = new CopyDependencyAction(dependency, clipboard);

        assertTrue("Should be a CopyDependencyAction instance.", copyAction instanceof CopyDependencyAction);
    }

    /**
     * Test Constructor(Dependency, Clipboard), with null dependency.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullDependency() {
        try {
            new CopyDependencyAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Dependency, Clipboard), with null clipboard. Do the same
     * as it is not null, for the constructor will assign the default clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyDependencyAction(dependency, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}