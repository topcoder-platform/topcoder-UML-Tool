/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Accuracy test for <code>{@link AddMessageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>AddMessageAction</code> instance used in tests.
     * </p>
     */
    private AddMessageAction addMessageAction;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link AddMessageAction#AddMessageAction(Stimulus, Collaboration, UMLModelManager)}</code> constructor.
     * </p>
     */
    public void testAddMessageActionAccruracy() {
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(),
            new UMLModelManager());

        assertNotNull("object not created", addMessageAction);

    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddMessageAction#execute()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(), umlModelManager);
        addMessageAction.execute();
        assertFalse("should not logged.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(), umlModelManager);
        addMessageAction.die();
        addMessageAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(), umlModelManager);
        addMessageAction.execute();
        addMessageAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(), umlModelManager);
        addMessageAction.die();
        addMessageAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link AddMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        UMLModelManager umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        addMessageAction = new AccuracyAddMessageAction(new StimulusImpl(), new CollaborationImpl(), umlModelManager);
        addMessageAction.execute();
        addMessageAction.undo();
        addMessageAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Mock class only used for testing purpose.
     * </p>
     */
    private class AccuracyAddMessageAction extends AddMessageAction {

        /**
         * <p>
         * Constructs an instance.
         * </p>
         * @param stimulus
         *            the stimulus instance.
         * @param collaboration
         *            the collaboration instance.
         * @param manager
         *            the uml model manager.
         */
        protected AccuracyAddMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager) {
            super(stimulus, collaboration, manager);
        }
    }
}
