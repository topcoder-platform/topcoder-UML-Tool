/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CopyIncludeAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopyIncludeAction extends TestCase {

    /**
     * The <code>Include</code> instance used for test.
     */
    private Include include;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        include = new IncludeImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test the constructor <code>CopyIncludeAction(Include)</code>.
     */
    public void testConstructor() {
        CopyIncludeAction copyIncludeAction = new CopyIncludeAction(include);
        assertNotNull("Instance of CopyIncludeAction should be created.", copyIncludeAction);
    }

    /**
     * Test the constructor <code>CopyIncludeAction(Include, Clipboard)</code>.
     */
    public void testConstructorWithClipboard() {
        CopyIncludeAction copyIncludeAction = new CopyIncludeAction(include, clipboard);
        assertNotNull("Instance of CopyIncludeAction should be created.", copyIncludeAction);
    }
}
