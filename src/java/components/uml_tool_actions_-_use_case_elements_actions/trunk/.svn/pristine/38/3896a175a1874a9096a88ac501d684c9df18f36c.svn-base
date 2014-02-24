/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CutIncludeAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutIncludeAction extends TestCase {

    /**
     * The <code>Include</code> instance used for test.
     */
    private Include include;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * The <code>CutIncludeAction</code> instance used to test against.
     */
    private CutIncludeAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        include = new IncludeImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        action = new CutIncludeAction(include);
    }

    /**
     * Test the constructor <code>CutIncludeAction(Include)</code>.
     */
    public void testConstructor() {
        CutIncludeAction cutIncludeAction = new CutIncludeAction(include);
        assertNotNull("Instance of CutIncludeAction should be created.", cutIncludeAction);
    }

    /**
     * Test the constructor <code>CutIncludeAction(Include, Clipboard)</code>.
     */
    public void testConstructorWithNamespace() {
        CutIncludeAction cutIncludeAction = new CutIncludeAction(include, clipboard);
        assertNotNull("Instance of CutIncludeAction should be created.", cutIncludeAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Cut Include"));
    }
}
