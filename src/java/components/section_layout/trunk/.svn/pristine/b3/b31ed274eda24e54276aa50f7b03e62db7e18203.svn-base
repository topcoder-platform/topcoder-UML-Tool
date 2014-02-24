/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.dndimpl.BasicDockContainer;

/**
 * <p>
 * The default implementation of dock container in this component,
 * it supports the dock functionality for <code>Section</code>s.
 * It use <code>BoxLayout</code> to layout the docks.
 * </p>
 *
 * <p>
 * The typical usage is like :
 * <pre>
 * SectionDockContainer container = new SectionDockContainer(sideMenu);
 * container.dock(new Dock(section1));
 * container.dock(new Dock(section2));
 * </pre>
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class SectionDockContainer extends BasicDockContainer {

    /**
     * <p>
     * The native swing container to dock the dockable components.
     * Initialized in constructor, can't be null, never changed later.
     * </p>
     */
    private final DockContainerPanel container;

    /**
     * <p>
     * Whether this container is vertical.
     * Initialized in constructor, never changed later.
     * </p>
     */
    private final boolean vertical;

    /**
     * <p>
     * The docks docked in this container.
     * Initialized to empty list, can't be null, the element can't be null. never changed.
     * The elements can be accessed in dock/undock methods.
     * </p>
     */
    private final List<Dock> docks = new ArrayList<Dock>();

    /**
     * <p>
     * Constructs a SectionContainer instance with outer swing container.
     * It means making the outer container dockable.
     * </p>
     *
     * @param outerContainer
     *        the native swing container to dock the other components
     * @throws IllegalArgumentException
     *         if the argument is null
     */
    public SectionDockContainer(Container outerContainer) {
        this(outerContainer, true);
    }

    /**
     * <p>
     * Constructs a SectionContainer instance with outer swing container and orientation.
     * It means making the outer container dockable.
     * </p>
     *
     * @param outerContainer
     *        the native swing container to dock the other components
     * @param vertical
     *        whether the container is vertical
     * @throws IllegalArgumentException
     *         if the argument is null
     */
    public SectionDockContainer(Container outerContainer, boolean vertical) {
        Helper.checkNull(outerContainer, "outerContainer");

        container = new DockContainerPanel();
        this.vertical = vertical;
        container.setLayout(new BoxLayout(container, vertical ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS));
        // make it scollable
        JScrollPane scrollPane = new JScrollPane(container);

        outerContainer.setLayout(new BorderLayout());
        outerContainer.add(scrollPane, BorderLayout.CENTER);
        scrollPane.revalidate();
        outerContainer.repaint();
    }

    /**
     * <p>
     * Return whether the given dock can be docked.
     * </p>
     *
     * @param dock
     *        the given dock
     * @return whether the given dock can be docked in this container,
     *         if the dock is null, false is returned.
     */
    public boolean canDock(Dock dock) {
        if (dock == null) {
            return false;
        }
        Dockable dockable = dock.getDockable();
        if (!(dockable.getDockType().equals(Section.DOCK_TYPE))) {
            return false;
        }
        if (((Section) dockable.getDockableComponent()).isVertical() != vertical) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * Return the size of current docked docks.
     * </p>
     *
     * @return the size of current docked docks
     */
    public int getDockSize() {
        return docks.size();
    }

    /**
     * <p>
     * Dock the specific dock instance.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @throws IllegalArgumentException
     *         if the dock is null
     */
    public void dock(Dock dock) {
        this.dock(dock, getDockSize());
    }

    /**
     * <p>
     * Dock the specific dock instance to specific location.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param location
     *        the preferred location in the container where the dock should be docked
     * @throws IllegalArgumentException
     *         if dock is null or location is null, or location x, y is negative
     */
    public void dock(Dock dock, Point location) {
        Helper.checkNull(dock, "dock");
        Helper.checkPoint(location, "location");

        // if can't dock, simply return
        if (!canDock(dock)) {
            return;
        }
        // if this is the first dock, dock it
        if (this.getDockSize() == 0) {
            dock(dock, 0);
        }
        // calculate index and dock if index is not negative
        int index = calculateIndex(location);
        if (index < 0) {
            return;
        }
        dock(dock, index);
    }

    /**
     * <p>
     * Dock the specific dock instance to specific index.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param index
     *        the preferred index in the container where the dock should be docked
     * @throws IllegalArgumentException
     *         if dock is null or index is negative
     */
    public void dock(Dock dock, int index) {
        Helper.checkNull(dock, "dock");
        Helper.checkNegative(index, "index");

        // if can't dock, simply return
        if (!canDock(dock)) {
            return;
        }
        // if dock already in the docks and with same index, simply return
        if (dock.getCurrentDockContainer() == this && dock.getCurrentIndexInContainer() == index) {
            return;
        }

        // if the current dock container of dock is not this, undock first
        // else undock without repaint
        DockContainer currentDockContainer = dock.getCurrentDockContainer();
        if (currentDockContainer != null) {
            if (currentDockContainer != this) {
                currentDockContainer.undock(dock);
            } else {
                undockWithoutRepaint(dock);
            }
        }

        // dock this dock and repaint
        index = Math.min(index, getDockSize());
        docks.add(index, dock);
        Component comp = dock.getDockable().getDockableComponent();
        container.add(comp, index);
        container.revalidate();
        container.repaint();

        // fire the docked event both in the container and the dock
        Rectangle bounds = comp.getBounds();
        Point location = new Point(bounds.x, bounds.y);
        DockEvent event = new DockEvent(dock, this, location, index);
        this.fireDocked(event);
        dock.fireDocked(event);
    }

    /**
     * <p>
     * Dock the specific dock instance to specific location or index(up to the implementation).
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param location
     *        the preferred location in the container where the dock should be docked
     * @param index
     *        the preferred index in the container where the dock should be docked
     * @throws IllegalArgumentException
     *         if dock is null or index is negative
     */
    public void dock(Dock dock, Point location, int index) {
        // we just ignore the location
        dock(dock, index);
    }

    /**
     * <p>
     * Undock the specific dock instance from this container.
     * It should also fire the undocked event both in the container and the dock.
     * If the dock is not docked before, do nothing.
     * </p>
     *
     * @param dock
     *        the dock instance to be undocked
     * @throws IllegalArgumentException
     *         if dock is null
     */
    public void undock(Dock dock) {
        undockWithoutRepaint(dock);
        container.invalidate();
        container.repaint();
    }

    /**
     * <p>
     * Return native swing container where the dockable components docked.
     * </p>
     *
     * @return native swing container where the dockable components docked
     */
    public Container getDockTarget() {
        return container;
    }

    /**
     * <p>
     * Return the current docks in this container.
     * </p>
     *
     * @return the shallow copy of the current docks in this container
     */
    public List<Dock> getCurrentDocks() {
        return new ArrayList<Dock>(docks);
    }

    /**
     * <p>
     * Mark the dock gesture to the location for the given dock instance.
     * There should be a visual indicator when docking to
     * show the user where the given dock is going to be placed in the dock container.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param location
     *        the preferred location in the container where the dock should be docked
     * @throws IllegalArgumentException
     *         if dock is null or location is null, or location x, y is negative
     */
    public void markDockGesture(Dock dock, Point location) {
        Helper.checkNull(dock, "dock");
        Helper.checkPoint(location, "location");

        // calculate the index first, if index is negative, simply return
        int index = calculateIndex(location);
        if (index < 0) {
            return;
        }

        // calculate the gesture rectangle
        if (index == 0) { // if the dock will be the first dock in docks
            Rectangle rect = docks.get(index).getDockable().getDockableComponent().getBounds();
            container.setGestureRect(new Rectangle(rect.x, rect.y, rect.width, rect.height / 2));
        } else if (index == getDockSize()) { // if the dock will be the last dock in docks
            Rectangle rect = docks.get(index - 1).getDockable().getDockableComponent().getBounds();
            container.setGestureRect(
                    new Rectangle(rect.x, rect.y + rect.height / 2, rect.width, rect.height / 2 + 1));
        } else { // if the dock will in the middle of the docks
            Rectangle r1 = docks.get(index - 1).getDockable().getDockableComponent().getBounds();
            Rectangle r2 = docks.get(index).getDockable().getDockableComponent().getBounds();
            container.setGestureRect(new Rectangle(r1.x, r1.y + r1.height / 2,
                    Math.max(r1.width, r2.width), (r1.height + r2.height) / 2));
        }

        // repaint
        this.container.repaint();
    }

    /**
     * <p>
     * Clear the gesture (the visual indicator) marked in markDockGesture method.
     * </p>
     */
    public void clearDockGesture() {
        container.setGestureRect(null);
        container.repaint();
    }

    /**
     * <p>
     * Set the gesture color of this container.
     * </p>
     *
     * @param gestureColor
     *        the gesture color
     */
    public void setGestureColor(Color gestureColor) {
        container.setGestureColor(gestureColor);
    }

    /**
     * <p>
     * Calculate the index of the docks to be docked at according the given location.
     * (The location is relative to the container)
     * If the location is at the lower part of a section, it will docked after it, otherwise, before it.
     * Note, the location should be valid(not null, x and y are zero or positive).
     * </p>
     *
     * @param location
     *        the dock need to dock at
     * @return the index of the docks to be docked
     * @throws IllegalArgumentException
     *         if location is null
     */
    protected int calculateIndex(Point location) {
        Helper.checkNull(location, "location");

        int size = docks.size();
        for (int i = 0; i < size; i++) {
            Rectangle bounds = docks.get(i).getDockable().getDockableComponent().getBounds();
            Rectangle b1, b2;
            // get lower part and higher part of i-th dock
            if (vertical) {
                b1 = new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height / 2);
                b2 = new Rectangle(bounds.x, bounds.y + bounds.height / 2, bounds.width, bounds.height / 2 + 1);
            } else {
                b1 = new Rectangle(bounds.x, bounds.y, bounds.width / 2, bounds.height);
                b2 = new Rectangle(bounds.x + bounds.width / 2, bounds.y, bounds.width / 2 + 1, bounds.height);
            }
            // if the location is at the lower part of a section, it will docked after it, otherwise, before it
            if (b1.contains(location)) {
                return i;
            }
            if (b2.contains(location)) {
                return i + 1;
            }
        }
        // invalid location
        return -1;
    }

    /**
     * <p>
     * Undock the dock without repainting current container.
     * </p>
     *
     * @param dock
     *        the dock to undock
     * @throws IllegalArgumentException
     *         if argument is null
     */
    protected void undockWithoutRepaint(Dock dock) {
        Helper.checkNull(dock, "dock");

        for (int i = 0; i < docks.size(); i++) {
            // if found the dock in docks
            if (docks.get(i) == dock) {
                // undock this dock
                docks.remove(i);
                container.remove(i);
                // fire the undocked event both in the container and the dock
                Rectangle bounds = dock.getDockable().getDockableComponent().getBounds();
                Point location = new Point(bounds.x, bounds.y);
                DockEvent event = new DockEvent(dock, this, location, i);
                this.fireUndocked(event);
                dock.fireUndocked(event);
                break;
            }
        }
    }
}
