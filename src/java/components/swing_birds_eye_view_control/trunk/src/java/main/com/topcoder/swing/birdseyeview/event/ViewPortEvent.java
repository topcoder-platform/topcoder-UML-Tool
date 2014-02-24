/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.event;

/**
 * <p>
 * An event which indicates that an view port action occurred in a component.
 * This is a simple data container class for storing information about view
 * port. It has an information about new coordinates of the input object view
 * port.
 * </p>
 *
 * <p>
 * Thread safety: This class is immutable and therefore is fully thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class ViewPortEvent {
    /**
     * <p>
     * Represents the X coordinate of the new position of the input view port
     * origin.
     * </p>
     *
     * <p>
     * It can be any value. It is initialized in the constructor and is
     * never changed later. Use related getter method to retrieve this field
     * value.
     * </p>
     */
    private final int inputObjectViewX;
    /**
     * <p>
     * Represents the Y coordinate of the new position of the input view port
     * origin.
     * </p>
     *
     * <p>
     * It can be any value. It is initialized in the constructor and is
     * never changed later. Use related getter method to retrieve this field
     * value.
     * </p>
     */
    private final int inputObjectViewY;

    /**
     * <p>
     * A simple initialization constructor.
     * </p>
     *
     * @param inputObjectViewY
     *            the new value of the Y coordinate of the new position of the
     *            input view port origin. It can be any value.
     * @param inputObjectViewX
     *            the new value of the X coordinate of the new position of the
     *            input view port origin. It can be any value.
     */
    public ViewPortEvent(int inputObjectViewX, int inputObjectViewY) {
        this.inputObjectViewX = inputObjectViewX;
        this.inputObjectViewY = inputObjectViewY;
    }

    /**
     * <p>
     * A simple getter method for the &quot;inputObjectViewX&quot; internal field. Please
     * refer to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the X coordinate of the new position of
     *         the input view port origin. It can be any value.
     */
    public int getInputObjectViewX() {
        return this.inputObjectViewX;
    }

    /**
     * <p>
     * A simple getter method for the &quot;inputObjectViewY&quot; internal field. Please
     * refer to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the Y coordinate of the new position of
     *         the input view port origin. It can be any value.
     */
    public int getInputObjectViewY() {
        return this.inputObjectViewY;
    }
}
