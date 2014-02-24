/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for receiving text input event occurs in the
 * TextInputBox. The class that is interested in processing the event implements
 * this interface. And the object created with that class is registered with a
 * TextInputBox. When the text is entered (by pressing "Enter") that object's
 * textEntered method is invoked. When the text input is cancelled (by pressing
 * "Esc") that object's textCancelled method is invoked.
 * </p>
 * <p>
 * Thread safety: The implementations of this interface are not required to be
 * thread-safe. They could be used in a thread safe manner in this component.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface TextInputListener extends EventListener {

    /**
     * <p>
     * Invoked when the text is entered into the TextInputBox. The event tells
     * the text entered in the TextInputBox.
     * </p>
     *
     * @param event the text input event
     */
    public void textEntered(TextInputEvent event);

    /**
     * <p>
     * Invoked when the text in the TextInputBox is cancelled. The event tells
     * the text in the TextInputBox.
     * </p>
     *
     * @param event the text input event
     */
    public void textCancelled(TextInputEvent event);
}
