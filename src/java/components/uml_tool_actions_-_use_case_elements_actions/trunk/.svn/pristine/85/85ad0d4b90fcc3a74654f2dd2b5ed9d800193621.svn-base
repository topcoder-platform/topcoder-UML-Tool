/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CopyExtendAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopyExtendAction extends TestCase {

    /**
     * The <code>Extend</code> instance used for test.
     */
    private Extend extend;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        extend = new ExtendImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test the constructor <code>CopyExtendAction(Extend)</code>.
     */
    public void testConstructor() {
        CopyExtendAction copyExtendAction = new CopyExtendAction(extend);
        assertNotNull("Instance of CopyExtendAction should be created.", copyExtendAction);
    }

    /**
     * Test the constructor <code>CopyExtendAction(Extend, Clipboard)</code>.
     */
    public void testConstructorWithClipboard() {
        CopyExtendAction copyExtendAction = new CopyExtendAction(extend, clipboard);
        assertNotNull("Instance of CopyExtendAction should be created.", copyExtendAction);
    }
}
