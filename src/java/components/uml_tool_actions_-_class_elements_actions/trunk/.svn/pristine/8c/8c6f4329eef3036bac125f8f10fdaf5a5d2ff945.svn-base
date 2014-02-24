/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.util.log.Log;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ClassUndoableAction. Since ClassUndoableAction is
 * abstract class the simple sub-class MockClassUndoableAction will be used for
 * testing. You can refer to MockClassUndoableAction for more detail.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassUndoableActionTest extends TestCase {

    /**
     * A ModelElement instance used for test.
     */
    private final Abstraction modelElement = new AbstractionImpl();

    /**
     * A ClassToolUtil instance used for test.
     */
    private final AbstractionUtil classToolUtil = new AbstractionUtil();

    /**
     * A Transferable instance used for test.
     */
    private final ClassElementsTransfer transferable = new ClassElementsTransfer(modelElement);

    /**
     * Test constructor(ModelElement, ClassToolUtil), with correct modelElement
     * and classToolUtil.
     */
    public void testCtor1() {
        ClassUndoableAction undoableAction = new MockClassUndoableAction(modelElement, classToolUtil);

        assertEquals("Should return modelElement.", modelElement, undoableAction.getModelElement());
        assertEquals("Should return classToolUtil.", classToolUtil, undoableAction.getClassToolUtil());
    }

    /**
     * Test constructor(ModelElement, ClassToolUtil), with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullModelElement() {
        try {
            new MockClassUndoableAction(null, classToolUtil);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor(ModelElement, ClassToolUtil), with null classToolUtil.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullClassToolUtil() {
        try {
            new MockClassUndoableAction(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor(Transferable, DataFlavor, ClassToolUtil), with correct
     * transferable, dataFlavor and classToolUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2() throws Exception {
        ClassUndoableAction undoableAction = new MockClassUndoableAction(transferable,
                ClassElementsTransfer.ABSTRACTION_FLAVOR, classToolUtil);

        assertEquals("Should return modelElement.", modelElement, undoableAction.getModelElement());
        assertEquals("Should return classToolUtil.", classToolUtil, undoableAction.getClassToolUtil());
    }

    /**
     * Test constructor(Transferable, DataFlavor, ClassToolUtil), with null
     * transferable. IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullTransferable() throws Exception {
        try {
            new MockClassUndoableAction(null, ClassElementsTransfer.ABSTRACTION_FLAVOR, classToolUtil);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor(Transferable, DataFlavor, ClassToolUtil), with null
     * dataFlavor. IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullDataFlavor() throws Exception {
        try {
            new MockClassUndoableAction(transferable, null, classToolUtil);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor(Transferable, DataFlavor, ClassToolUtil), with null
     * dataFlavor. IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullClassToolUtil() throws Exception {
        try {
            new MockClassUndoableAction(transferable, ClassElementsTransfer.ABSTRACTION_FLAVOR, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor(Transferable, DataFlavor, ClassToolUtil), with wrong
     * dataFlavor. InvalidDataContentException is expected.
     */
    public void testCtor2WithWrongDataFlavor() {
        try {
            new MockClassUndoableAction(transferable, ClassElementsTransfer.GENERALIZATION_FLAVOR, classToolUtil);
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test getClassToolUtil.
     */
    public void testGetClassToolUtil() {
        ClassUndoableAction undoableAction = new MockClassUndoableAction(modelElement, classToolUtil);

        assertEquals("Should return modelElement.", modelElement, undoableAction.getModelElement());
    }

    /**
     * Test getModelElement.
     */
    public void testGetModelElement() {
        ClassUndoableAction undoableAction = new MockClassUndoableAction(modelElement, classToolUtil);

        assertEquals("Should return classToolUtil.", classToolUtil, undoableAction.getClassToolUtil());
    }

    /**
     * Test getLog.
     */
    public void testGetLog() {
        ClassUndoableAction undoableAction = new MockClassUndoableAction(modelElement, classToolUtil);

        assertTrue("Should return a Log instance.", undoableAction.getLog() instanceof Log);
        assertNotNull("The returned log should not be null.", undoableAction.getLog());
    }
}