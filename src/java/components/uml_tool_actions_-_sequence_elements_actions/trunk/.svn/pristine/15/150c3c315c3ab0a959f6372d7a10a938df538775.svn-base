/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.AddObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Accuracy test for <code>{@link AddObjectAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class AddObjectActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>AddObjectAction</code> instance used in tests.
     * </p>
     */
    private AddObjectAction addObjectAction;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link AddObjectAction#AddObjectAction(Stimulus, Collaboration, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testAddObjectActionAccruracy() {
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), new UMLModelManager());

        assertNotNull("object not created", addObjectAction);

    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddObjectAction#execute()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), umlModelManager);
        addObjectAction.execute();
        assertFalse("should not logged.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), umlModelManager);
        addObjectAction.die();
        addObjectAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), umlModelManager);
        addObjectAction.execute();
        addObjectAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), umlModelManager);
        addObjectAction.die();
        addObjectAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), umlModelManager);
        addObjectAction.execute();
        addObjectAction.undo();
        addObjectAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link AddObjectAction#getPresentationName()}</code> method.
     * </p>
     */
    public void testGetPresentationNameAccuracy() {
        addObjectAction = new AddObjectAction(new ObjectImpl(), new CollaborationImpl(), new UMLModelManager());
        assertEquals("incorrect presentation name", "Add Object", addObjectAction.getPresentationName());
    }
}
