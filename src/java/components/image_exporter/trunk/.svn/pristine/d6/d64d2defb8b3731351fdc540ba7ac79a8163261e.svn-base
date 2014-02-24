/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import javax.swing.JComponent;


/**
 * <p>
 * This interface defines the contract for rendering the visibility of a jComponent. First a jComponent is made visible
 * by makeVisibile(), and after being printed, it should be restored to it's original status by restoreVisibility().
 * </p>
 * <p>
 * Thread-Safety: It is necessary that the classes that implement this interface are thread safe, for avoiding errors in
 * multiple threads during printing process.
 * </p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
 */
public interface JComponentVisibleMaker {
    /**
     * <p>Makes a JComponent visible if it isn't. This method is called before the printing of a JComponent.</p>
     *
     * @param component the jComponent of which visibility will be set to visible
     *
     * @throws IllegalArgumentException if component is null
     * @throws JComponentVisibleMakerException if any error occurs
     */
    public void makeVisible(JComponent component) throws JComponentVisibleMakerException;

    /**
     * <p>Restores the JComponent's visible status to its original one after being printed.</p>
     *
     * @param component the jComponent of which visibility will be restored
     *
     * @throws IllegalArgumentException if component is null or it's not made visible by makeVisible() previously
     * @throws JComponentVisibleMakerException if any error occurs
     */
    public void restoreVisibility(JComponent component) throws JComponentVisibleMakerException;
}
