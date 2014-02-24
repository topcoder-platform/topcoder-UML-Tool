/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This is the basic implementation of BezierPoint and extends Point. Control points are defined relative to
 * base (x, y). So if controls are all (0, 0) for all waypoints of a GraphEdge, a simple polygon line will be
 * drawn instead of a bezier curve.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class BezierPoint extends Point {

    /**
     * <p>
     * The maximum number of control points.
     * </p>
     */
    private static final int MAX_SIZE = 2;

    /**
     * <p>
     * Represents the two control points of this BezierPoint. Can never be null. Can be empty. Elements cannot
     * be null. There can be duplicated elements. Default to empty.
     * </p>
     */
    private final List<Point> controls = new ArrayList<Point>();

    /**
     * <p>
     * Creates an instance of BezierPoint.
     * </p>
     */
    public BezierPoint() {
        super();
    }

    /**
     * <p>
     * Appends a control point to this BezierPoint at the end. There should be at most two control points.
     * </p>
     *
     * @param control the control point to be appended
     * @throws IllegalStateException if there are already two control points
     * @throws IllegalArgumentException if control is null
     */
    public void addControl(Point control) {
        if (controls.size() == MAX_SIZE) {
            throw new IllegalStateException("there are already two control points");
        }
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        controls.add(control);
    }

    /**
     * <p>
     * Inserts a control point to this BezierPoint at the given position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices). There should be
     * at most two control points.
     * </p>
     *
     * @param index the index at which the control point is to be inserted
     * @param control the control point to be inserted
     * @throws IllegalStateException if there are already two control points
     * @throws IllegalArgumentException if control is null, or index is out of range (index < 0 || index >
     *         countControls())
     */
    public void addControl(int index, Point control) {
        if (controls.size() == MAX_SIZE) {
            throw new IllegalStateException("there are already two control points");
        }
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index > controls.size()) {
            throw new IllegalArgumentException("index can not be larger than size");
        }
        controls.add(index, control);
    }

    /**
     * <p>
     * Replaces the control point in this BezierPoint at the given position with the specified one.
     * </p>
     *
     * @param index the index of the control point to replace
     * @param control the control point to be stored
     * @throws IllegalArgumentException if control is null, or index is out of range (index < 0 || index >=
     *         countControls())
     */
    public void setControl(int index, Point control) {
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= controls.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        controls.set(index, control);
    }

    /**
     * <p>
     * Removes the control point from this BezierPoint at the specified position. All subsequent elements are
     * shifted to the left. Returns the removed control point.
     * </p>
     *
     * @param index the index of the control point to be removed
     * @return the removed control point
     * @throws IllegalArgumentException if index is out of range (index < 0 || index >= countControls())
     */
    public Point removeControl(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= controls.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        return controls.remove(index);
    }

    /**
     * <p>
     * Removes the control point from this BezierPoint. If the control point is a duplicated element, only the
     * first one is removed. Returns true if the control point is removed, false otherwise.
     * </p>
     *
     * @param control the control point to be removed
     * @return true if the control point is removed, false otherwise
     * @throws IllegalArgumentException if control is null
     */
    public boolean removeControl(Point control) {
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        return controls.remove(control);
    }

    /**
     * <p>
     * Removes all the control points of this BezierPoint.
     * </p>
     */
    public void clearControls() {
        controls.clear();
    }

    /**
     * <p>
     * Returns a copy of the control points of this BezierPoint.
     * </p>
     *
     * @return a copy of the control points of this BezierPoint
     */
    public List<Point> getControls() {
        return new ArrayList<Point>(controls);
    }

    /**
     * <p>
     * Returns true if the control point is in this BezierPoint, false otherwise.
     * </p>
     *
     * @param control the control point to be checked for inclusion
     * @return true if the control point is in this BezierPoint, false otherwise
     * @throws IllegalArgumentException if control is null
     */
    public boolean containsControl(Point control) {
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        return controls.contains(control);
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the given control point in this BezierPoint.
     * </p>
     *
     * @param control the control point to search for
     * @return the position of the control point, -1 if not found
     * @throws IllegalArgumentException if control is null
     */
    public int indexOfControl(Point control) {
        if (control == null) {
            throw new IllegalArgumentException("the control point can not be null");
        }
        return controls.indexOf(control);
    }

    /**
     * <p>
     * Returns the number of control points of this BezierPoint.
     * </p>
     *
     * @return the number of control points of this BezierPoint
     */
    public int countControls() {
        return controls.size();
    }
}