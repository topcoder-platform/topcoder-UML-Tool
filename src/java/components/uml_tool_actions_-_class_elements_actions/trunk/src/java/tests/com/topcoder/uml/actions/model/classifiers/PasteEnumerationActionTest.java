/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PasteEnumerationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteEnumerationActionTest extends TestCase {

    /**
     * The Enumeration instance used for test.
     */
    private final Enumeration enumeration = new EnumerationImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(enumeration);

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
        PasteEnumerationAction pasteAction = new PasteEnumerationAction(transferable, namespace);

        assertEquals("Should return Enumeration instance.", enumeration, pasteAction.getModelElement());
    }

    /**
     * Test Constructor, with null transferable. InvalidDataContentException is
     * expected.
     */
    public void testCtorWithWrongTransferable() {
        try {
            new PasteEnumerationAction(new ClassElementsTransfer(new DependencyImpl()), namespace);
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
            new PasteEnumerationAction(null, namespace);
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
            new PasteEnumerationAction(transferable, null);
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
        PasteEnumerationAction pasteAction = new PasteEnumerationAction(transferable, namespace);

        assertEquals("Should return PRESENTATION_NAME.", "Paste Enumeration", pasteAction.getPresentationName());
    }
}