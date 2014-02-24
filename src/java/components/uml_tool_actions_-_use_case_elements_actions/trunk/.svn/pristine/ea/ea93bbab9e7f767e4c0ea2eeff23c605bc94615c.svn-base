/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CutExtendAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutExtendAction extends TestCase {

    /**
     * The <code>Extend</code> instance used for test.
     */
    private Extend extend;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * The <code>CutExtendAction</code> instance used to test against.
     */
    private CutExtendAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        extend = new ExtendImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        action = new CutExtendAction(extend);
    }

    /**
     * Test the constructor <code>CutExtendAction(Extend)</code>.
     */
    public void testConstructor() {
        CutExtendAction cutExtendAction = new CutExtendAction(extend);
        assertNotNull("Instance of CutExtendAction should be created.", cutExtendAction);
    }

    /**
     * Test the constructor <code>CutExtendAction(Extend, Clipboard)</code>.
     */
    public void testConstructorWithNamespace() {
        CutExtendAction cutExtendAction = new CutExtendAction(extend, clipboard);
        assertNotNull("Instance of CutExtendAction should be created.", cutExtendAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Cut Extend"));
    }
}
