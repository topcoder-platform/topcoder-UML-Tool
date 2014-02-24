/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopySubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CopySubsystemAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopySubsystemAction extends TestCase {

    /**
     * The <code>Subsystem</code> instance used for test.
     */
    private Subsystem subsystem;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        subsystem = new SubsystemImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test the constructor <code>CopySubsystemAction(Subsystem)</code>.
     */
    public void testConstructor() {
        CopySubsystemAction copySubsystemAction = new CopySubsystemAction(subsystem);
        assertNotNull("Instance of CopySubsystemAction should be created.", copySubsystemAction);
    }

    /**
     * Test the constructor <code>CopySubsystemAction(Subsystem, Clipboard)</code>.
     */
    public void testConstructorWithClipboard() {
        CopySubsystemAction copySubsystemAction = new CopySubsystemAction(subsystem, clipboard);
        assertNotNull("Instance of CopySubsystemAction should be created.", copySubsystemAction);
    }
}
