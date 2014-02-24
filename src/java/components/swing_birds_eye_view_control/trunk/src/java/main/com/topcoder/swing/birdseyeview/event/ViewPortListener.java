/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for view port actions. This interface defines a public
 * contract for ViewPort listeners. It simply defines one method - viewPortMoved -
 * to be consumed by external code. The manager of the input object should
 * register for this viewPortMoved event to be notified when the view port has
 * moved over the zoom panel.
 * </p>
 *
 * <p>
 * Thread safety: There is no need to make concrete implementations to be
 * thread-safe. It is just a GUI control, which usually are not thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public interface ViewPortListener extends EventListener {
    /**
     * <p>
     * The method to be invoked, then the view port has been moved. The new
     * position of the input object view port will be provided to the consumer
     * of this method in the external code.
     * </p>
     *
     * @param event
     *            an instance of the ViewPortEvent class with the data about the
     *            view port moving. It can not be null.
     */
    public void viewPortMoved(ViewPortEvent event);
}
