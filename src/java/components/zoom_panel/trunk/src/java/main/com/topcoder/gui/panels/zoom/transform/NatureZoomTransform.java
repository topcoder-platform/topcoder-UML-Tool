/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.transform;

import com.topcoder.gui.panels.zoom.Helper;
import com.topcoder.gui.panels.zoom.ZoomTransform;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * A nature implementation of the ZoomTransform interface. Both components (x, y) of in the zoomed coordinates system
 * will simply be the x, y coordinates multiplied by the zoom factor.
 *
 * <p>
 * <strong>Thread-safety</strong>: This class is not thread safe, since it is mutable and not synchronized.
 * </p>
 *
 * @author smell, 80x86
 * @version 1.0
 */
public class NatureZoomTransform implements ZoomTransform {

    /**
     * The zoom factor of this transform. It should be positive number. It is set in the constructor and defaults to 1.0
     * if not specified.
     */
    private double zoomFactor = 1.0;

    /**
     * Position of the zoom component.
     *
     */
    private Point position;

    /*
     * BugFix: UML-10111
     */
    /**
     * Constructs a new NatureZoomTransform with the given zoom component point.
     */
    public NatureZoomTransform(Point position) {
        this.position = new Point(position);
    }

    /**
     * Constructs a new NatureZoomTransform with zoomFactor defaulting to 1.0.
     */
    public NatureZoomTransform() {
        this(new Point(0, 0));
    }

    /**
     * Constructs a new NatureZoomTransform with the given zoomFactor.
     *
     * @param zoomFactor
     *            the given zoomFactor
     * @throws IllegalArgumentException
     *             if zoomFactor is not positive
     */
    public NatureZoomTransform(double zoomFactor) {
        this();
        this.zoomFactor = Helper.validateDouble(zoomFactor, "zoomFactor");
    }

    /**
     * Sets the zoom factor of this transform.
     *
     * @param zoomFactor
     *            the zoom factor to set
     * @throws IllegalArgumentException
     *             is zoomFactor is not positive
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#setZoomFactor(double)
     */
    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = Helper.validateDouble(zoomFactor, "zoomFactor");
    }

    /**
     * Returns the zoom factor of this transform.
     *
     * @return the zoom factor of this transform
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#getZoomFactor()
     */
    public double getZoomFactor() {
        return zoomFactor;
    }

    /**
     * Applies the transform to the given graphics by multiply each component of (x, y) by the zoom factor.
     *
     * @param graphics
     *            the graphics
     * @throws IllegalArgumentException
     *             if graphics is null
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#applyTransform(java.awt.Graphics2D)
     */
    public void applyTransform(Graphics2D graphics) {
        Helper.validateObject(graphics, "graphics");
        /*
         * BugFix: UML-10111
         * Translate the graphics first.
         */
        graphics.translate(position.x, position.y);
        graphics.scale(zoomFactor, zoomFactor);
    }

    /**
     * Transforms the position of the event back to unzoomed coordinates system by dividing each component of (x, y) by
     * the zoom factor.
     *
     * @return a MouseEvent with positive in unzoomed coordinates system
     * @param event
     *            the MouseEvent in zoomed coordinates system
     * @throws IllegalArgumentException
     *             if event is null
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#applyInverseTransform(java.awt.event.MouseEvent)
     */
    public MouseEvent applyInverseTransform(MouseEvent event) {
        Helper.validateObject(event, "event");

        /*
         * BugFix: UML-10111
         * Event's coordinate should be decreased with translated value first
         */
        // old code
//        double x = event.getX() / zoomFactor;
//        double y = event.getY() / zoomFactor;
        double x = (event.getX() - position.x) / zoomFactor;
        double y = (event.getY() - position.y) / zoomFactor;
        return new MouseEvent(event.getComponent(), event.getID(), event.getWhen(), event.getModifiers(), (int) x,
                (int) y, event.getClickCount(), event.isPopupTrigger(), event.getButton());
    }

    /**
     * Whether this transform has no zooming effect, for example the component will not be zoomed after applying this
     * transform.
     *
     * @return true if it is no zoom, false otherwise
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#isNoZoom()
     */
    public boolean isNoZoom() {
        return Math.abs(zoomFactor - 1.0) < Helper.EPSILON;
    }
}
