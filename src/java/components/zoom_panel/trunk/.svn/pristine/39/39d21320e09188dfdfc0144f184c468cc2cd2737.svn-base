/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.transform;

import com.topcoder.gui.panels.zoom.Helper;
import com.topcoder.gui.panels.zoom.ZoomTransform;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

/**
 * Implementation of ZoomTransform interface by affine transform. It utilizes the Java system AffineTransform class to
 * perform the zoom transform. The affine transform applied by this class is usually a scaling transform with equal x
 * and y scaling factor. However, the user may perform any custom affine transform via setting the AffineTransform
 * instance itself. This allows the user to perform sophisticated zoom transforms (such us with different zoom factors
 * along x and y axes). Some of this transform may be beyond simply zooming the JComponent, since even rotation and
 * translation of JComponent is possible.
 *
 * <p>
 * <strong>Thread-safety</strong>: This class is not thread safe, since it is mutable and not synchronized.
 * </p>
 *
 * @author smell, 80x86
 * @version 1.0
 */
public class AffineZoomTransform implements ZoomTransform {

    /**
     * The AffineTransform instance used to perform the zoom transform. It's initialized in constructor, and accessed by
     * getter and setter. setZoomFactor will modify it and getZoomFactor and isNoZoom will read it. It will never be
     * null. Usually it will be a scaling transform with equal x and y scaling factors. But the user may set it to any
     * kind of instance of transform.
     */
    private AffineTransform transform;

    /**
     * Constructors a AffineZoomTransform instance with identity affine transform.
     */
    public AffineZoomTransform() {
        this(1.0);
    }

    /**
     * Constructors a AffineZoomTransform instance with the given zoom factor.
     *
     * @param zoomFactor
     *            the given zoom factor
     * @throws IllegalArgumentException
     *             if zoomFactor is not positive
     */
    public AffineZoomTransform(double zoomFactor) {
        this(AffineTransform.getScaleInstance(Helper.validateDouble(zoomFactor, "zoomFactor"), Helper.validateDouble(
                zoomFactor, "zoomFactor")));
    }

    /**
     * Constructors a AffineZoomTransform instance with the given affine transform's clone copy.
     *
     * @param transform
     *            the given transform
     * @throws IllegalArgumentException
     *             if transform is null
     */
    public AffineZoomTransform(AffineTransform transform) {
        Helper.validateObject(transform, "transform");
        this.transform = Helper.validateAffineTransform(transform);
    }

    /**
     * Sets the zoom factor of the transform.
     *
     * @param zoomFactor
     *            the zoom factor to set
     * @throws IllegalArgumentException
     *             if zoomFactor is not positive
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#setZoomFactor(double)
     */
    public void setZoomFactor(double zoomFactor) {
        Helper.validateDouble(zoomFactor, "zoomFactor");
        transform.setToScale(zoomFactor, zoomFactor);
    }

    /**
     * Returns the zoom factor. The implementation treats the x scale factor as the zoom factor, this is equal to the
     * actual zoom factor performed when applying this transform in most cases. However, the user may customize the
     * actual affine transform to apply, in that case, the transform may be beyond the meaning of zooming, and it's
     * possible that the return value is not positive.
     *
     * @return the zoom factor
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#getZoomFactor()
     */
    public double getZoomFactor() {
        return transform.getScaleX();
    }

    /**
     * Applies the transform onto the given graphics.
     *
     * @param graphics
     *            the given graphics
     * @throws IllegalArgumentException
     *             if graphics is null
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#applyTransform(java.awt.Graphics2D)
     */
    public void applyTransform(Graphics2D graphics) {
        Helper.validateObject(graphics, "graphics");
        graphics.transform(transform);
    }

    /**
     * Applies the inverse transform to the given event. It will return a MouseEvent with position recomputed based on
     * the transform, such that the zoomed component will not be noticed it has been zoomed.
     *
     * @return the MouseEvent with position inverse transformed to the original coordinate system
     * @param event
     *            the MouseEvent occured, its position is in the transformed coordinate system
     * @throws IllegalArgumentException
     *             if event is null
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#applyInverseTransform(java.awt.event.MouseEvent)
     */
    public MouseEvent applyInverseTransform(MouseEvent event) {
        Helper.validateObject(event, "event");

        // get x and y from the event
        int x = event.getX();
        int y = event.getY();

        // perform inverse transform
        Point2D ptSrc = new Point2D.Double(x, y);
        Point2D ptDst = null;
        try {
            ptDst = transform.inverseTransform(ptSrc, null);
        } catch (NoninvertibleTransformException e) {
            throw new AssertionError("exception happens when doing inverse transformation.");
        }
        x = Helper.castDouble2Int(ptDst.getX());
        y = Helper.castDouble2Int(ptDst.getY());

        return new MouseEvent(event.getComponent(), event.getID(), event.getWhen(), event.getModifiers(), x, y, event
                .getClickCount(), event.isPopupTrigger(), event.getButton());
    }

    /**
     * Whether this transform has no zooming effect, for example the component will not be zoomed after applying this
     * transform.
     *
     * @return true if it is no zoom, false otherwise
     * @see com.topcoder.gui.panels.zoom.ZoomTransform#isNoZoom()
     */
    public boolean isNoZoom() {
        return transform.isIdentity();
    }

    /**
     * Returns the cloned affine transform instance used to perform the zoom transform.
     *
     * @return Returns the transform.
     */
    public AffineTransform getTransform() {
        return (AffineTransform) transform.clone();
    }

    /**
     * Sets the affine transform used to perform the zoom transform. The user can use this method to customize the
     * actual zooming effect. If the transform instance is modified via this method, sophisticated transform may be
     * performed, and the transform may be beyond the meaning of zoom. The transform is checked to be able to inverse
     * before being set. And the setting is using the transform's cloned object.
     *
     * @param transform
     *            The transform to set
     * @throws IllegalArgumentException
     *             if transform is null
     */
    public void setTransform(AffineTransform transform) {
        Helper.validateObject(transform, "transform");
        this.transform = Helper.validateAffineTransform(transform);
    }
}
