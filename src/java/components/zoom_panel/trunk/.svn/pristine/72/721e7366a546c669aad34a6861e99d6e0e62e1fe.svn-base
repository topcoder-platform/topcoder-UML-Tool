/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 * ZoomTransform is the transform need to be applied onto coordinate system to achieve zooming effect. The ZoomPane
 * class will use this interface to zoom in and/or out the enclosed JComponent.
 *
 * <p>
 * <strong>Thread-safety</strong>: This class is not thread safe, since this component is supposed to used in the Swing
 * system, there would be only one thread access the component's state.
 * </p>
 *
 * @author smell, 80x86
 * @version 1.0
 */
public interface ZoomTransform {
    /**
     * Sets the zoom factor of the transform.
     *
     * @param zoomFactor
     *            the zoom to set, it must be positive
     * @throws IllegalArgumentException
     *             if zoomFactor is none positive
     */
    public void setZoomFactor(double zoomFactor);

    /**
     * Returns the zoom factor.
     *
     * @return the zoom factor
     */
    public double getZoomFactor();

    /**
     * Applies the zoom transform upon the given graphics. This method will be called when rendering(painting) the
     * zoomed component.
     *
     * @param graphics
     *            the graphics to apply the transform, it must not be null
     * @throws IllegalArgumentException
     *             if graphics is null
     */
    public void applyTransform(Graphics2D graphics);

    /**
     * Applies the inverse transform to the given event. It will return a MouseEvent with position recomputed based on
     * the transform, such that the zoomed component will not be noticed it has been zoomed.
     *
     * @return the MouseEvent with position inverse transformed to the original coordinate system
     * @param event
     *            the MouseEvent occured, its position is in the transformed coordinate system
     * @throws IllegalArgumentException
     *             if event is null
     */
    public MouseEvent applyInverseTransform(MouseEvent event);

    /**
     * Whether this transform has no zooming effect, i.e. the component will not be zoomed after applying this
     * transform.
     *
     * @return true if it is no zoom, false otherwise
     */
    public boolean isNoZoom();
}
