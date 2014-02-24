/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

/**
 * <p>
 * ZoomPanel adds scroll bars, viewport control and other facilities to the ZoomPane, so they can work as a whole as the
 * familiar zoom window. This implementation use Swing JScrollPane as the base to support the scroll bars and viewport
 * control. It also contains convenient API to access the zooming functionality.
 * </p>
 * <p>
 * 1. To control and configure the scroll bar, please use the API provided by JScrollPane, these include:
 * getVerticalScrollBarPolicy setVerticalScrollBarPolicy getHorizontalScrollBarPolicy setHorizontalScrollBarPolicy the
 * above set whether the scroll bars are shown, if the user wants to set the scroll increment of the scroll bar, use
 * getVerticalScrollBar/getHorizontalScrollBar to get the reference to the scroll bar and use the API provided by
 * JScrollBar class.
 * </p>
 * <p>
 * 2. To control and configure the viewport, use getViewport to gain the reference to the JViewport instance and use the
 * API provided by JViewport to set the viewport (including but not limited to the view position, viewport size, scroll
 * mode)
 * </p>
 * <p>
 * 3. An API is added to control the background color of the zoom zone, if the zoomed component can occupy the whole
 * region.
 * </p>
 * <p>
 * 4. API is provided as convenience To set the zoom factor and/or the zoom transform from the ZoomPanel directly.
 * </p>
 * <p>
 * <strong>Thread-safety</strong>: This class is not thread safe, since it is mutable and not synchronized.
 * </p>
 *
 * @author smell, 80x86
 * @version 1.0
 */
public class ZoomPanel extends JScrollPane {

    /**
     * The ZoomPane instance to hold the zoom component and perform the zooming operation. It is initialized in the
     * constructor and not changed afterwards. It should never be null.
     */
    private final ZoomPane zoomPane;

    /**
     * Constructs ZoomPanel for the given zoomComponent, with the given transform.
     *
     * @param zoomComponent the given zoom component
     * @param transform the given transform
     * @throws IllegalArgumentException if either argument is null
     */
    public ZoomPanel(JComponent zoomComponent, ZoomTransform transform) {
        Helper.validateObject(zoomComponent, "zoomComponent");
        Helper.validateObject(transform, "transform");

        zoomPane = new ZoomPane(zoomComponent, transform);
        setViewportView(zoomPane);
    }

    /**
     * Constructs ZoomPanel for the given zoomComponent.
     *
     * @param zoomComponent the given zoom component
     * @throws IllegalArgumentException if the argument is null
     */
    public ZoomPanel(JComponent zoomComponent) {
        /*
         * BugFix: UML-10111
         */
        // old code
//        this(zoomComponent, new NatureZoomTransform());
        Helper.validateObject(zoomComponent, "zoomComponent");
        zoomPane = new ZoomPane(zoomComponent, new NatureZoomTransform(zoomComponent.getLocation()));
        setViewportView(zoomPane);
    }

    /**
     * Returns the ZoomTransform instance to perform zoom.
     *
     * @return the transform instance
     */
    public ZoomTransform getTransform() {
        return zoomPane.getTransform();
    }

    /**
     * Returns the zoom factor of this zoom panel.
     *
     * @return the zoom factor
     */
    public double getZoomFactor() {
        return zoomPane.getZoomFactor();
    }

    /**
     * Sets the ZoomTransform instance to perform zoom.
     *
     * @param transform the new transform
     * @throws IllegalArgumentException if transform is null
     */
    public void setTransform(ZoomTransform transform) {
        Helper.validateObject(transform, "transform");
        zoomPane.setTransform(transform);
    }

    /**
     * Sets the zoomFactor of this zoom panel.
     *
     * @param zoomFactor the zoom factor to set
     * @throws IllegalArgumentException if zoomFactor is not positive
     */
    public void setZoomFactor(double zoomFactor) {
        zoomPane.setZoomFactor(Helper.validateDouble(zoomFactor, "zoomFactor"));
    }

    /**
     * Sets the background color of the zoom region.
     *
     * @param background the background color, it can be null to mean resetting the background to default color
     */
    public void setZoomBackground(Color background) {
        getViewport().setBackground(background);
    }

    /**
     * Returns the background color of the zoom region.
     *
     * @return the background color
     */
    public Color getZoomBackground() {
        return getViewport().getBackground();
    }
}
