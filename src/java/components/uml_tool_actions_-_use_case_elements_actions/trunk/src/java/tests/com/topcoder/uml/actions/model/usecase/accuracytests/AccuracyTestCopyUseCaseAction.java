/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CopyUseCaseAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopyUseCaseAction extends TestCase {

    /**
     * The <code>UseCase</code> instance used for test.
     */
    private UseCase useCase;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test the constructor <code>CopyUseCaseAction(UseCase)</code>.
     */
    public void testConstructor() {
        CopyUseCaseAction copyUseCaseAction = new CopyUseCaseAction(useCase);
        assertNotNull("Instance of CopyUseCaseAction should be created.", copyUseCaseAction);
    }

    /**
     * Test the constructor <code>CopyUseCaseAction(UseCase, Clipboard)</code>.
     */
    public void testConstructorWithClipboard() {
        CopyUseCaseAction copyUseCaseAction = new CopyUseCaseAction(useCase, clipboard);
        assertNotNull("Instance of CopyUseCaseAction should be created.", copyUseCaseAction);
    }
}
