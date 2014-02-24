/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every text changed event listener must follow. Note, the event would be
 * triggered before the text is actually changed. This kind of listener can be registered to TextField instances.
 * </p>
 * <p>
 * It contains only one method to process the text changed event with a single TextChangedEvent parameter.
 * </p>
 * <p>
 * For example, application can register a listener to a TextField, which represents name compartment.
 * </p>
 * <p>
 * The implementations of this interface not required to be thread-safe. They could be used in a thread safe manner in
 * this component.
 * </p>
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */
public interface TextChangedListener extends EventListener {
    /**
     * <p>
     * Handles the text changed event. This method is called before the text is actually changed.
     * </p>
     * <p>
     * The event parameter could tell which TextField text is changed, and what is the old text and new text value.
     * </p>
     * @param e the text changed event
     * @throws IllegalArgumentException if e is null
     */
    public void textChanged(TextChangedEvent e);
}
