/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PasteClassAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteClassActionTest extends TestCase {

    /**
     * The Class instance used for test.
     */
    private final com.topcoder.uml.model.core.classifiers.Class classs = new ClassImpl();

    /**
     * The Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(classs);

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
        PasteClassAction pasteAction = new PasteClassAction(transferable, namespace);

        assertEquals("Should return Class instance.", classs, pasteAction.getModelElement());
    }

    /**
     * Test Constructor, with null transferable. InvalidDataContentException is
     * expected.
     */
    public void testCtorWithWrongTransferable() {
        try {
            new PasteClassAction(new ClassElementsTransfer(new DependencyImpl()), namespace);
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
            new PasteClassAction(null, namespace);
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
            new PasteClassAction(transferable, null);
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
        PasteClassAction pasteAction = new PasteClassAction(transferable, namespace);

        assertEquals("Should return PRESENTATION_NAME.", "Paste Class", pasteAction.getPresentationName());
    }
}