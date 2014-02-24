/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.util.EventListener;


/**
 * <p>
 * This interface defines the contract that every text change event listener must follow.
 * Note, the event would be triggered before the text is actually changed.
 * </p>
 *
 * <p>
 * It contains only one method to process the text change event
 * With a single <code>TextChangeEvent</code> parameter.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface TextChangeListener extends EventListener {
    /**
     * <p>
     * Handles the text change event.
     * The event parameter could tell which node's text is changed,
     * And what is the old text and new text value.
     * </p>
     *
     * @param e - the text change event (null should be ignored)
     */
    public void textChanged(TextChangeEvent e);
}
