/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.AddReturnMessageAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Accuracy test for <code>{@link AddReturnMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class AddReturnMessageActionAccuracyTests extends BaseTestCase {
    /**
     * Represents the <code>Stimulus</code> instance used in tests.
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Represents the <code>Collaboration</code> instance used in tests.
     * </p>
     */
    private Collaboration collaboration;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> instance used in tests.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Represents the <code>AddReturnMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private AddReturnMessageAction action;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        stimulus = AccuracyTestHelper.createStimulusForReturnMessage();

        collaboration = new CollaborationImpl();
        umlModelManager = new UMLModelManager();
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link AddReturnMessageAction#AddReturnMessageAction(Stimulus, Collaboration, UMLModelManager)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtorAccuracy() throws Exception {
        action = new AddReturnMessageAction(stimulus, collaboration, umlModelManager);

        assertNotNull("should successfully create instance.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link AddReturnMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new AddReturnMessageAction(stimulus, collaboration, umlModelManager);

        assertEquals("incorrect presentation name", "Add Return Message Action", action.getPresentationName());
    }
}
