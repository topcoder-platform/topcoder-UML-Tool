/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveObjectAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveObjectActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveObjectAction</code> instance used in tests.
     * </p>
     */
    private RemoveObjectAction removeObjectAction;

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
        removeObjectAction = new RemoveObjectAction(object);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveObjectAction#RemoveObjectAction(Object)}</code>
     * constructor.
     * </p>
     */
    public void testRemoveObjectActionAccuracy1() {
        removeObjectAction = new RemoveObjectAction(new ObjectImpl());
        assertNotNull(removeObjectAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveObjectAction#exeremovee()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testExeremoveeAccuracy() throws Exception {
        removeObjectAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveObjectAction#undo()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        removeObjectAction.die();
        removeObjectAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveObjectAction#undo()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        removeObjectAction.execute();
        removeObjectAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveObjectAction#redo()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        removeObjectAction.die();
        removeObjectAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveObjectAction#redo()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        removeObjectAction.execute();
        removeObjectAction.undo();
        removeObjectAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveObjectAction#getPresentationName()}</code> method.
     * </p>
     */
    public void testGetPresentationNameAccuracy() {
        assertEquals("incorrect presentation name", "Remove Object", removeObjectAction.getPresentationName());
    }
}
