/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;


/**
 * <p>
 * This interface provides the functions to make a invisible component visible and restore it's original visible state.
 * </p>
 * <p>
 * The implementation of this interface needn't to be thread-safe.
 * </p>
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public interface ComponentVisibleMaker {
    /**
     * <p>Make given invisible component visible.</p>
     *
     * @param component the given invisible component
     * @throws IllegalArgumentException if component is null
     */
    public void makeVisible(Component component);

    /**
     * <p>Make the given visible component back to its original invisible state. This method should be called
     * after invocation of makeVisible() method, otherwise, this method will throw IllegalArgumentException.</p>
     *
     * @param component the visible component need to back to original invisible state
     * @throws IllegalArgumentException if component is null
     */
    public void makeInvisible(Component component);

    /**
     * <p>It will do necessary operations to clear up history state.</p>
     */
    public void clear();
}
