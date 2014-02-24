/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeListener;

/**
 * <p>
 * Mock class for <code>TextChangeListener</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class MockTextChangeListener implements TextChangeListener {

    /**
     * public integer used for recording the number of text change events.
     */
    public int flag = 0;

    /**
     * Each time text changed, the flag increases by one.
     */
    public void textChanged(TextChangeEvent e) {
        flag++;
    }
}
