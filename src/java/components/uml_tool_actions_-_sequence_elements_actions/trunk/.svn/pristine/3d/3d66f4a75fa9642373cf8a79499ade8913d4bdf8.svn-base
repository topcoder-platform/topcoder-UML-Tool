/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CutObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * Accuracy test for <code>{@link CutObjectAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CutObjectActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>CutObjectAction</code> instance used in tests.
     * </p>
     */
    private CutObjectAction cutObjectAction;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        Object object = new ObjectImpl();
        object.setNamespace(new CollaborationImpl());
        object.getNamespace().addOwnedElement(object);
        cutObjectAction = new CutObjectAction(object);

    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutObjectAction#CutObjectAction(Object)}</code>
     * constructor.
     * </p>
     */
    public void testCutObjectActionAccuracy1() {
        cutObjectAction = new CutObjectAction(new ObjectImpl());
        assertNotNull(cutObjectAction);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutObjectAction#CutObjectAction(Object, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCutObjectActionAccuracy2() {
        cutObjectAction = new CutObjectAction(new ObjectImpl(), Toolkit.getDefaultToolkit().getSystemClipboard());
        assertNotNull(cutObjectAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutObjectAction#execute()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        cutObjectAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        cutObjectAction.die();
        cutObjectAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        cutObjectAction.execute();
        cutObjectAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        cutObjectAction.die();
        cutObjectAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        cutObjectAction.execute();
        cutObjectAction.undo();
        cutObjectAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutObjectAction#getPresentationName()}</code> method.
     * </p>
     */
    public void testGetPresentationNameAccuracy() {
        assertEquals("incorrect presentation name", "Cut Object", cutObjectAction.getPresentationName());
    }
}
