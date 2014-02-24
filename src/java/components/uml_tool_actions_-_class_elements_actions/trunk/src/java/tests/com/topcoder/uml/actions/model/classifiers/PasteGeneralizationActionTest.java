/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PasteGeneralizationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteGeneralizationActionTest extends TestCase {

    /**
     * The Generalization instance used for test.
     */
    private final Generalization generalization = new GeneralizationImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(generalization);

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
        PasteGeneralizationAction pasteAction = new PasteGeneralizationAction(transferable, namespace);

        assertEquals("Should return Generalization instance.", generalization, pasteAction.getModelElement());
    }

    /**
     * Test Constructor, with null transferable. InvalidDataContentException is
     * expected.
     */
    public void testCtorWithWrongTransferable() {
        try {
            new PasteGeneralizationAction(new ClassElementsTransfer(new DependencyImpl()), namespace);
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
            new PasteGeneralizationAction(null, namespace);
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
            new PasteGeneralizationAction(transferable, null);
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
        PasteGeneralizationAction pasteAction = new PasteGeneralizationAction(transferable, namespace);

        assertEquals("Should return PRESENTATION_NAME.", "Paste Generalization", pasteAction.getPresentationName());
    }
}