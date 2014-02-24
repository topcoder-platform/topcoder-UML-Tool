/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CopyAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyActionTest extends TestCase {

    /**
     * The ModelElement instance for the test.
     */
    private ModelElement modelElement = new DependencyImpl();

    /**
     * The ClassToolUtil instance for the test.
     */
    private ClassToolUtil classToolUtil = new DependencyUtil();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test constructor, with correct modelElement, classToolUtil and clipboard.
     */
    public void testCtor() {
        CopyAction copyAction = new MockCopyAction(modelElement, classToolUtil, clipboard);

        assertTrue("Should return CopyAction instance.", copyAction instanceof CopyAction);
    }

    /**
     * Test constructor, with null modelElement. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullModelElement() {
        try {
            new MockCopyAction(null, classToolUtil, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null classToolUtil. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullClassToolUtil() {
        try {
            new MockCopyAction(modelElement, null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor, with null clipboard. No IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullClipboard() {
        try {
            new MockCopyAction(modelElement, classToolUtil, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test execute.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testExecute() throws Exception {
        CopyAction copyAction = new MockCopyAction(modelElement, classToolUtil, clipboard);
        copyAction.execute();

        assertEquals("A new modelElement should be added to the clipboard.", ClassElementsTransfer.DEPENDENCY_FLAVOR,
                clipboard.getContents(new Object()).getTransferDataFlavors()[0]);
        assertFalse("A new not the old modelElement should be added to the clipboard.", clipboard.getContents(
                new Object()).getTransferData(ClassElementsTransfer.DEPENDENCY_FLAVOR).equals(modelElement));
    }
}