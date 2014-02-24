/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Component;

import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;

/**
 * <p>
 * A mock implementation of <code>Dockable</code> for failure test.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DockableImpl implements Dockable {

    /**
     * <p>
     * The constructor.
     * </p>
     */
    public DockableImpl() {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public String getDockType() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public Component getDockableComponent() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return false
     */
    public boolean isFloating() {
        return false;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param listener the parameter
     */
    public void setDragInitListener(DragInitListener listener) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param floating the parameter
     */
    public void setFloating(boolean floating) {
        // empty
    }

}
