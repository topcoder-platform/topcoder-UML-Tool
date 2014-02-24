/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every text change event listener must follow. Note, the event would be
 * triggered before the text is actually changed. This kind of listener can be registered to <code>TextField</code>
 * instances.
 * </p>
 *
 * <p>
 * It contains only one method to process the text change event with a single <code>TextChangeEvent</code> parameter.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> The implementations of this interface not required to be thread-safe. They could be used in a
 * thread safe manner in this component.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public interface TextChangeListener extends EventListener {
    /**
     * <p>
     * Handle the text change event.
     * </p>
     *
     * <p>
     * This method is called before the text is actually changed. The event parameter could tell which TextField text is
     * changed, and what is the old text and new text value.
     * </p>
     *
     * @param event
     *            the text change event
     *
     * @throws IllegalArgumentException
     *             if event is null
     */
    public void textChange(TextChangeEvent event);
}
