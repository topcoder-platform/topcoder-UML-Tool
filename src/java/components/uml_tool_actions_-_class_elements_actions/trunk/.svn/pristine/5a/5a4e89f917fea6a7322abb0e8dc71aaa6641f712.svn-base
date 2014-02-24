/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PasteAssociationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteAssociationActionTest extends TestCase {

    /**
     * The Association instance used for test.
     */
    private final Association association = new AssociationImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(association);

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
        PasteAssociationAction pasteAction = new PasteAssociationAction(transferable, namespace);

        assertEquals("Should return Association instance.", association, pasteAction.getModelElement());
    }

    /**
     * Test Constructor, with null transferable. InvalidDataContentException is
     * expected.
     */
    public void testCtorWithWrongTransferable() {
        try {
            new PasteAssociationAction(new ClassElementsTransfer(new DependencyImpl()), namespace);
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
            new PasteAssociationAction(null, namespace);
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
            new PasteAssociationAction(transferable, null);
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
        PasteAssociationAction pasteAction = new PasteAssociationAction(transferable, namespace);

        assertEquals("Should return PRESENTATION_NAME.", "Paste Association", pasteAction.getPresentationName());
    }
}