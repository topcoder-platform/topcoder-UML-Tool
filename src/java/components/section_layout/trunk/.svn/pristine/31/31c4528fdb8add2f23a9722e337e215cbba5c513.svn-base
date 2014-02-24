/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.Helper;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;

/**
 * <p>
 * It is a convenient class to wrap a swing component which doesn't implement the <code>Dockable</code> yet.
 * </p>
 *
 * <p>
 * The typcial usage is like this:
 * <code>Dockable dockableComponent = new DockableWrapper(component);</code>
 * </p>
 *
 * <p>
 * So that the resulted component can be dockable.
 * It just register the <code>MouseListener</code> to listen mousePressed event on the whose component.
 * If the mouse is pressed on the wrapped component, the drag is started.
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
public class DockableWrapper extends JPanel implements Dockable {

    /**
     * <p>
     * Represents the DragInitListener instance which listens to the drag start event.
     * Default to null, can be accessed/set in getter/setter.
     * Can be null.
     * </p>
     */
    private DragInitListener listener = null;

    /**
     * <p>
     * Whether this component is floating. True, the dockable component is floating now.
     * Default to false, can be accessed/set in getter/setter.
     * </p>
     */
    private boolean floating = false;

    /**
     * <p>
     * Constructs a DockableWrapper instance with swing component.
     * </p>
     *
     * @param component
     *        the swing component need to support dockable
     * @throws IllegalArgumentException
     *         if component is null
     */
    public DockableWrapper(Component component) {
        Helper.checkNull(component, "component");

        this.setLayout(new BorderLayout());
        this.add(component, BorderLayout.CENTER);
        // register the MouseListener to listen mousePressed event
        component.addMouseListener(new MouseAdapter() {
            /**
             * <p>
             * The method is invoked when the mouse pressed.
             * </p>
             *
             * @param e
             *        the mouse event
             */
            public void mousePressed(MouseEvent e) {
                // if the mouse is pressed and the DragInitListener is not null, the drag is started
                if (listener != null) {
                    listener.dragInitialized(e, DockableWrapper.this);
                    e.consume();
                }
            }
        });
    }

    /**
     * <p>
     * Return the corresponding swing component.
     * </p>
     *
     * @return the corresponding swing component
     */
    public Component getDockableComponent() {
        return this;
    }

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
    public void setDragInitListener(DragInitListener listener) {
        this.listener = listener;
    }

    /**
     * <p>
     * Return the dock type of this dockable component.
     * The dock type is used by dock container to determine whether to dock it.
     * The return type can't be null.
     * </p>
     *
     * @return the dock type of this dockable component
     */
    public String getDockType() {
        return DockableWrapper.class.getSimpleName();
    }

    /**
     * <p>
     * Setter of the floating property of this dockable component.
     * </p>
     *
     * @param floating
     *        True, the dockable component is floating now
     */
    public void setFloating(boolean floating) {
        this.floating = floating;
    }

    /**
     * <p>
     * Getter of the floating property of this dockable component.
     * Default to false.
     * </p>
     *
     * @return True, the dockable component is floating now
     */
    public boolean isFloating() {
        return floating;
    }
}
