/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PasteDependencyAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteDependencyActionTest extends TestCase {

    /**
     * The Dependency instance used for test.
     */
    private final Dependency dependency = new DependencyImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(dependency);

    /**
     * The Namespace instance used for test.
     */
    private final Model namespace = new ModelImpl();

    /**
     * Test Constructor, with correct transferable and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor() throws Exception {
        PasteDependencyAction pasteAction = new PasteDependencyAction(transferable, namespace);

        assertEquals("Should return Dependency instance.", dependency, pasteAction.getModelElement());
    }

    /**
     * Test Constructor, with null transferable. InvalidDataContentException is
     * expected.
     */
    public void testCtorWithWrongTransferable() {
        try {
            new PasteDependencyAction(new ClassElementsTransfer(new AbstractionImpl()), namespace);
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor, with null transferable. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullTransferable() throws Exception {
        try {
            new PasteDependencyAction(null, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor, with null namespace. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullNamespace() throws Exception {
        try {
            new PasteDependencyAction(transferable, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testGetPresentationName() throws Exception {
        PasteDependencyAction pasteAction = new PasteDependencyAction(transferable, namespace);

        assertEquals("Should return PRESENTATION_NAME.", "Paste Dependency", pasteAction.getPresentationName());
    }
}