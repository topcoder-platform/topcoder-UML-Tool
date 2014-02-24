/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Point;

import java.util.EventObject;


/**
 * <p>
 * The event for starting name edit action. The position and current name of
 * the ObjectNode are enough for external component to implement editing.
 * </p>
 *
 * <p>
 * Thread safety: This class is immutable and so is thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EditNameEvent extends EventObject {
    /**
     * <p>
     * Represents the position where to display the edit name control.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable. It cannot be null.
     * </p>
     *
     * <p>
     * Getter method is provided.
     * </p>
     */
    private final Point position;

    /**
     * <p>
     * Represents the current name of the node.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable.
     * It will never be null but can be empty.
     * </p>
     *
     * <p>
     * Getter method is provided.
     * </p>
     */
    private final String name;

    /**
     * <p>
     * Constructs the class and set related class variables by using the
     * arguments.
     * </p>
     *
     * <p>
     * Note, the name can be empty.
     * </p>
     *
     * @param position The position of the node name.
     * @param name The name of node.
     * @param node The instance of the ObjectNode class.
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public EditNameEvent(Point position, String name, ObjectNode node) {
        super(node);

        Util.checkNull(position, "position");
        Util.checkNull(name, "name");

        this.position = position;
        this.name = name;
    }

    /**
     * <p>
     * Gets the position of the node name.
     * </p>
     *
     * @return The position of the node name.
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * <p>
     * Gets the name of the node.
     * </p>
     *
     * @return The name of node.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>
     * Gets the source of this edit name event.
     * </p>
     *
     * @return the source of this edit name event.
     */
    public ObjectNode getNode() {
        return (ObjectNode) source;
    }
}
