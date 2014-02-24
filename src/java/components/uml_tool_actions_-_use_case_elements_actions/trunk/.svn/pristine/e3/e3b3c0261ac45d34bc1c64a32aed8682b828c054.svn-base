/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CutUseCaseAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutUseCaseAction extends TestCase {

    /**
     * The <code>UseCase</code> instance used for test.
     */
    private UseCase useCase;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * The <code>CutUseCaseAction</code> instance used to test against.
     */
    private CutUseCaseAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        action = new CutUseCaseAction(useCase);
    }

    /**
     * Test the constructor <code>CutUseCaseAction(UseCase)</code>.
     */
    public void testConstructor() {
        CutUseCaseAction cutUseCaseAction = new CutUseCaseAction(useCase);
        assertNotNull("Instance of CutUseCaseAction should be created.", cutUseCaseAction);
    }

    /**
     * Test the constructor <code>CutUseCaseAction(UseCase, Clipboard)</code>.
     */
    public void testConstructorWithNamespace() {
        CutUseCaseAction cutUseCaseAction = new CutUseCaseAction(useCase, clipboard);
        assertNotNull("Instance of CutUseCaseAction should be created.", cutUseCaseAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Cut Use Case"));
    }
}
