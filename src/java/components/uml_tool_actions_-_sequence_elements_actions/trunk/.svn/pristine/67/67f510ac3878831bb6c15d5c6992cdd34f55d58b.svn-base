/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CutReturnMessageAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CutReturnMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CutReturnMessageActionAccuracyTests extends BaseTestCase {

    /**
     * Represents the <code>Stimulus</code> instance used in tests.
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Represents the <code>CutReturnMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private CutReturnMessageAction action;

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
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutReturnMessageAction#CutReturnMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        action = new CutReturnMessageAction(stimulus);

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutReturnMessageAction#CutReturnMessageAction(Stimulus, Clipboard)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        action = new CutReturnMessageAction(stimulus, Toolkit.getDefaultToolkit().getSystemClipboard());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutReturnMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new CutReturnMessageAction(stimulus);

        assertEquals("incorrect presentation name", "Cut Return Message Action", action.getPresentationName());
    }
}
