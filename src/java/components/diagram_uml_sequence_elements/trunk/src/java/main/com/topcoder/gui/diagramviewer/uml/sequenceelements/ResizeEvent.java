/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.util.EventObject;


/**
 * <p>
 * The event for resizing message. It includes an instance of the ObjectNode.
 * Therefore the top-level component can easily perform needed actions on it.
 * </p>
 *
 * <p>
 * Thread Safety : The class is immutable and so is thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ResizeEvent extends EventObject {
    /**
     * <p>
     * Represents the instance of the ObjectNode.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable. It will never be null.
     * </p>
     *
     * <p>
     * Getter method is provided.
     * </p>
     */
    private final ObjectNode node;

    /**
     * <p>
     * Represents the reason string describing why the node would like to be resized.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable.
     * It will never be null or empty.
     * </p>
     *
     * <p>
     * Getter method is provided.
     * </p>
     */
    private final String reason;

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * </p>
     *
     * @param node The instance of the ObjectNode class.
     * @param reason The reason - why the event is fired.
     *
     * @throws IllegalArgumentException if any argument is null, or if the reason is empty
     */
    public ResizeEvent(ObjectNode node, String reason) {
        super(node);

        Util.checkString(reason, "reason");

        this.node = node;
        this.reason = reason;
    }

    /**
     * <p>
     * Gets the object node in this event.
     * </p>
     *
     * @return The instance of the ObjectNode class.
     */
    public ObjectNode getNode() {
        return this.node;
    }

    /**
     * <p>
     * Gets the reason for this event.
     * </p>
     *
     * @return The reason - why the event is fired.
     */
    public String getReason() {
        return this.reason;
    }
}
