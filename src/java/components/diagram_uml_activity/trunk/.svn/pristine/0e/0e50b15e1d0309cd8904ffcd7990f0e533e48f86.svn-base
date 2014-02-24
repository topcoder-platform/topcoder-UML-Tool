/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;

/**
 * A dummy class extends the class: TextChangedListener.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class DummyTextChangedListener implements TextChangedListener {


    /**
     * Represents the original value.
     */
    private String oldValue;

    /**
     * Represents the new value.
     */
    private String newValue;

    /**
     * Handles the event.
     * 
     * @param event the event
     */
    public void textChanged(TextChangedEvent event) {
        oldValue = event.getOldValue();
        newValue = event.getNewValue();
        TextField textField = (TextField) event.getSource();
        textField.setText(newValue);
    }

    /**
     * Gets the value.
     * 
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value.
     * 
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }
    
    /**
     * Checks if the text is changed.
     * 
     * @return true if it is, false otherwise
     */
    public boolean isChanged() {
        return !newValue.equals(oldValue);
    }
}
