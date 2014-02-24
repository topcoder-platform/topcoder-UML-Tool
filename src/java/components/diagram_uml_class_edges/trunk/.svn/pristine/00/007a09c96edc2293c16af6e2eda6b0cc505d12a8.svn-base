/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputListener;


import junit.framework.TestCase;


/**
 * <p>Test the accuracy of EditBoxListener class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class TextInputListenerAccuracyTests extends TestCase {
    /** <code>EditBoxListener</code> instance for testing. */
    private TextInputListener listener;

    /** <code>TextField</code> instance for testing. */
    private TextField textField;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        textField = new TextField(new GraphNode());
        listener = new TextInputListener(textField);
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        textField = null;
        listener = null;
    }

    /**
     * <p>Accuracy test of constructor. Should create the instance successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", listener);
    }
}
