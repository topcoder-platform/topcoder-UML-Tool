/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Component;

/**
 * <p>
 * This interface is designed to be implemented by any swing component supporting docking functionality.
 * It defines method to accept a <code>DragInitListener</code> which used to trigger the start of dragging,
 * it also defines method that return the dock type, can be determined by dock container whether to dock or not.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface Dockable {

    /**
     * <p>
     * Return the corresponding swing component.
     * </p>
     *
     * @return the corresponding swing component
     */
    public Component getDockableComponent();

    /**
     * <p>
     * Set the DragInitListener to this dockable component.
     * This method will replace the original listener with the new listener.
     * Setting null means remove the original listener.
     * </p>
     *
     * @param listener
     *        the listener to listen whether the drag is started
     */
    public void setDragInitListener(DragInitListener listener);

    /**
     * <p>
     * Return the dock type of this dockable component.
     * The dock type is used by dock container to determine whether to dock it.
     * The return type can't be null.
     * </p>
     *
     * @return the dock type of this dockable component
     */
    public String getDockType();

    /**
     * <p>
     * Setter of the floating property of this dockable component.
     * </p>
     *
     * @param floating
     *        True, the dockable component is floating now
     */
    public void setFloating(boolean floating);

    /**
     * <p>
     * Getter of the floating property of this dockable component.
     * </p>
     *
     * @return True, the dockable component is floating now
     */
    public boolean isFloating();
}
