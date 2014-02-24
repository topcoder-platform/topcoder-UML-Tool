/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

/**
 * <p>
 * This is the interface that has to be implemented by object that wants to be
 * acknowledged when some changes in style happen.
 * </p>
 *
 * <p>
 * Listeners' scope is handled by the programmer of the application that uses this component.
 * </p>
 *
 * <p>
 * Thread safety: The implementation of this interface is not required to be thread safe.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public interface StyleListener {
    /**
     * <p>
     * This is the method that has to be implemented by class that wants
     * to be notified on style change.
     * </p>
     *
     * @param styleEvent the event that is sent to the listener
     */
    public void styleChanged(StyleEvent styleEvent);
}
