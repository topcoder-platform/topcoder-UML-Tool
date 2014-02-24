/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import com.topcoder.gui.sectionlayout.Helper;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.FloatContainer;

/**
 * <p>
 * The Defalut implementation of the <code>FloatContainer</code> by using the <code>JDialog</code> component as the
 * native swing component. The created <code>JDialog</code> instance will not be resizable. If this container is
 * closed, it will also redock the containing dock back to the original dock container.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>: It is mutable and not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DialogFloatContainer extends BasicDockContainer implements FloatContainer {

    /**
     * <p>
     * The dock in this float container. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final Dock dock;

    /**
     * <p>
     * The native JDialog instance in this float container. Initialized in constructor, never changed later. Can't
     * be null.
     * </p>
     */
    private final JDialog dialog;

    /**
     * <p>
     * Whether this container have docked something. Initialized to false.
     * </p>
     */
    private boolean docked = false;

    /**
     * <p>
     * Represents the dock's original dock container. Initialized to null, modified in dock/undock methods.
     * </p>
     */
    private DockContainer previousContainer = null;

    /**
     * <p>
     * Represents the dock's location in original dock container. Initialized to null, modified in dock/undock
     * methods.
     * </p>
     */
    private Point previousLocationInContainer = null;

    /**
     * <p>
     * Represents the dock's index in original dock container. Initialized to -1, modified in dock/undock methods.
     * </p>
     */
    private int previousIndexInContainer = -1;

    /**
     * <p>
     * Constructs a DialogFloatContainer instance with Dock instance.
     * </p>
     *
     * @param dock
     *            the dock instance
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public DialogFloatContainer(Dock dock) {
        this(dock, false);
    }

    /**
     * <p>
     * Constructs a DialogFloatContainer instance with Dock instance.
     * </p>
     *
     * @param dock
     *            the dock instance
     * @param resizable
     *            whether the dock is resizable or not
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public DialogFloatContainer(Dock dock, boolean resizable) {
        Helper.checkNull(dock, "dock");

        // set dock and previous properties
        this.dock = dock;
        // previousContainer = dock.getCurrentDockContainer();

        // get the owner of the dock
        Window window = SwingUtilities.getWindowAncestor(dock.getDockable().getDockableComponent());
        // initialize the dialog, if window is Frame or Dialog, set it as dialog's owner
        if (window instanceof Frame) {
            dialog = new JDialog((Frame) window, false);
        } else if (window instanceof Dialog) {
            dialog = new JDialog((Dialog) window, false);
        } else {
            dialog = new JDialog((Frame) null, false);
        }
        // set dialog not resizeable and not visible
        dialog.setResizable(resizable);
        dialog.setVisible(false);
        // add window listener to dialog so that if it is closed, the close method will be called
        dialog.addWindowListener(new WindowAdapter() {
            /**
             * <p>
             * Closes the window.
             * </p>
             *
             * @param w
             *            the window event
             */
            public void windowClosing(WindowEvent w) {
                close();
            }
        });
    }

    /**
     * <p>
     * Return whether the given dock can be docked in this container.
     * </p>
     *
     * @param dock
     *            the dock instance
     * @return whether the given dock can be docked in this container
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public boolean canDock(Dock dock) {
        Helper.checkNull(dock, "dock");
        return this.dock == dock && !docked;
    }

    /**
     * <p>
     * Clear the gesture (the visual indictor) marked in markDockGesture method.
     * </p>
     */
    public void clearDockGesture() {
        // do nothing
    }

    /**
     * <p>
     * Dock the specific dock instance. It should also undock the dock first if necessary. It should also fire the
     * docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *            the dock instance
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public void dock(Dock dock) {
        Helper.checkNull(dock, "dock");

        // if this container can't dock this dock, simply return
        if (!canDock(dock)) {
            return;
        }

        // get previous container the dock docked in
        DockContainer previous = dock.getCurrentDockContainer();
        // if previousContainer is not this container
        if (previous != this) {
            previousContainer = previous;
            previousIndexInContainer = dock.getCurrentIndexInContainer();
            previousLocationInContainer = dock.getCurrentLocationInContainer();
            // if previousContainer is not null, undock the dock
            if (previous != null) {
                previous.undock(dock);
            }
            // dock the dock in this container
            dialog.getContentPane().add(dock.getDockable().getDockableComponent());
            dialog.pack();
            // fire the docked event both in the container and the dock
            dock.fireDocked(new DockEvent(dock, this, null, 0));
            this.fireDocked(new DockEvent(dock, this, null, 0));
        }
        // set docked flag to true
        docked = true;
    }

    /**
     * <p>
     * Dock the specific dock instance to specific location. It should also undock the dock first if necessary. It
     * should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *            the dock instance to be docked
     * @param location
     *            the preferred location in the container where the dock should be docked
     * @throws IllegalArgumentException
     *             if dock is null or if location is null or x, y is negative
     */
    public void dock(Dock dock, Point location) {
        Helper.checkPoint(location, "location");
        dock(dock);
        dialog.setLocation(location);
    }

    /**
     * <p>
     * Dock the specific dock instance to specific index. It should also undock the dock first if necessary. It
     * should also fire the docked event both in the container and the dock. Note, the index is not used in this
     * implementation.
     * </p>
     *
     * @param dock
     *            the dock instance to be docked
     * @param index
     *            the preferred index in the container where the dock should be docked
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public void dock(Dock dock, int index) {
        dock(dock);
    }

    /**
     * <p>
     * Dock the specific dock instance to specific location or index(up to the implementation). It should also
     * undock the dock first if necessary. It should also fire the docked event both in the container and the dock.
     * Note, the index is not used in this implementation.
     * </p>
     *
     * @param dock
     *            the dock instance to be docked
     * @param location
     *            the preferred location in the container where the dock should be docked
     * @param index
     *            the preferred index in the container where the dock should be docked
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public void dock(Dock dock, Point location, int index) {
        dock(dock, location);
    }

    /**
     * <p>
     * Return the current docks in this container.
     * </p>
     *
     * @return the shallow copy of the current docks in this container
     */
    public List<Dock> getCurrentDocks() {
        List<Dock> ret = new ArrayList<Dock>();
        if (dialog.isVisible()) {
            ret.add(dock);
        }
        return ret;
    }

    /**
     * <p>
     * Return native swing container where the dockable components docked.
     * </p>
     *
     * @return native swing container where the dockable components docked
     */
    public Container getDockTarget() {
        return dialog;
    }

    /**
     * <p>
     * Mark the dock gesture to the location for the given dock instance. There should be a visual indicator when
     * docking to show the user where the given dock is going to be placed in the dock container.
     * </p>
     *
     * @param dock
     *            the given dock being docked
     * @param location
     *            the location of the dock being docked
     */
    public void markDockGesture(Dock dock, Point location) {
        // do nothing
    }

    /**
     * <p>
     * Undock the specific dock instance from this container. It should also fire the undocked event both in the
     * container and the dock. If the dock is not docked before, do nothing.
     * </p>
     *
     * @param dock
     *            the specific dock to be undocked
     * @throws IllegalArgumentException
     *             if dock is null
     */
    public void undock(Dock dock) {
        Helper.checkNull(dock, "dock");
        // if the dock is docked in this container, undock it
        if (this.dock == dock && docked) {
            dialog.getContentPane().remove(dock.getDockable().getDockableComponent());
            dialog.pack();
            dialog.setVisible(false);
            dock.fireUndocked(new DockEvent(dock, this, null, 0));
            docked = false;
        }
    }

    /**
     * <p>
     * Close the float container. It should also undock the containing docks and redock the docks back to there
     * original dock containers. If it is already closed, do nothing.
     * </p>
     */
    public void close() {
        // unlock first
        undock(dock);
        if (previousContainer != this && previousContainer != null) {
            previousContainer.dock(dock, previousLocationInContainer, previousIndexInContainer);
        }
    }

    /**
     * <p>
     * Open a closed float container, if it is already opened, do nothing.
     * </p>
     */
    public void open() {
        dialog.setVisible(true);
    }

    /**
     * <p>
     * Move the floating dock container to the specific location, the location is the absolute location in the
     * screen.
     * </p>
     *
     * @param location
     *            the absolute location where the float container should be moved to
     * @throws IllegalArgumentException
     *             if location is null or x, y is negative
     */
    public void setLocation(Point location) {
        Helper.checkPoint(location, "location");
        dialog.setLocation(location);
    }

    /**
     * <p>
     * Return whether any dock has been docked in this dialog float container. Default to false.
     * </p>
     *
     * @return whether any dock has been docked in this dialog float container
     */
    public boolean isDocked() {
        return docked;
    }
}
