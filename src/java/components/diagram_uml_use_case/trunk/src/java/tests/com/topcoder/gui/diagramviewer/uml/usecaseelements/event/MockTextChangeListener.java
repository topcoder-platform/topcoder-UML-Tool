/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

/**
 * <p>
 * This is a mock implementation of TextChangeEvent interface. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockTextChangeListener implements TextChangeListener {
    /**
     * <p>
     * The flag denotes whether textChange(TextChangeEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * The instance to hold the TextChangeEvent.
     * </p>
     */
    private TextChangeEvent textChangeEvent;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param e The instance of the TextChangeEvent class.
     */
    public void textChange(TextChangeEvent e) {
        isExecute = true;
        textChangeEvent = e;
        if (e.getSource() instanceof TextField) {
            TextField textField = (TextField) e.getSource();
            textField.setText(e.getNewText());
        }
    }

    /**
     * <p>
     * Returns the state of isExecute.
     * </p>
     *
     * @return the state of isExecute.
     */
    public boolean getIsExecute() {
        return isExecute;
    }

    /**
     * <p>
     * Return the instance of TextChangeEvent.
     * </p>
     *
     * @return the instance of TextChangeEvent
     */
    public TextChangeEvent getTextChangeEvent() {
        return textChangeEvent;
    }
}
