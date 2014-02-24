/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutSubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CutSubsystemAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutSubsystemAction extends TestCase {

    /**
     * The <code>Subsystem</code> instance used for test.
     */
    private Subsystem subsystem;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * The <code>CutSubsystemAction</code> instance used to test against.
     */
    private CutSubsystemAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        action = new CutSubsystemAction(subsystem);
    }

    /**
     * Test the constructor <code>CutSubsystemAction(Subsystem)</code>.
     */
    public void testConstructor() {
        CutSubsystemAction cutSubsystemAction = new CutSubsystemAction(subsystem);
        assertNotNull("Instance of CutSubsystemAction should be created.", cutSubsystemAction);
    }

    /**
     * Test the constructor <code>CutSubsystemAction(Subsystem, Clipboard)</code>.
     */
    public void testConstructorWithNamespace() {
        CutSubsystemAction cutSubsystemAction = new CutSubsystemAction(subsystem, clipboard);
        assertNotNull("Instance of CutSubsystemAction should be created.", cutSubsystemAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Cut Subsystem"));
    }
}
