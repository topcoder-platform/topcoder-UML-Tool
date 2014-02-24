/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * This is a mock implementation of <code>TextChangeListener</code>.
 * </p>
 * <p>
 * It is only used for accuracy test.
 * </p>
 * @author moonli
 * @version 1.0
 */
public class MockTextChangedListener implements TextChangedListener {

    /**
     * <p>
     * Handles the text change event.
     * </p>
     * <p>
     * This method is called before the text is actually changed.
     * </p>
     * <p>
     * The event parameter could tell which <code>TextField</code> text is changed, and what is
     * the old text and new text value.
     * </p>
     * @param e
     *            the text change event
     * @throws IllegalArgumentException
     *             If given parameter is null
     */
    public void textChanged(TextChangedEvent e) {
        System.out.println("Received TextChangeEvent!");
        TestCase.assertEquals("Old text mismatched.", "old text", e.getOldText());
        TestCase.assertEquals("New text mismatched.", "new text", e.getNewText());
    }

}
