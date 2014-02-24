/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.util.EventObject;

/**
 * <p>
 * The event for name setting message. It includes an instance of the ObjectNode.
 * Therefore the top-level component can easily perform needed actions on it.
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
public class SetNameEvent extends EventObject {
    /**
     * <p>
     * Represents the old name of the node.
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
    private final String oldName;

    /**
     * <p>
     * Represents the new name of the node.
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
    private final String newName;

    /**
     * <p>
     * Represents the instance of the ObjectNode.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable.
     * It will never be null.
     * </p>
     *
     * <p>
     * Getter method is provided.
     * </p>
     */
    private final ObjectNode node;

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * The oldName and the newName can be empty.
     * </p>
     *
     * @param oldName The old name of the node.
     * @param newName The new name for the node.
     * @param node The instance of the ObjectNode class.
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public SetNameEvent(String oldName, String newName, ObjectNode node) {
        super(node);

        Util.checkNull(oldName, "oldName");
        Util.checkNull(newName, "newName");

        this.oldName = oldName;
        this.newName = newName;
        this.node = node;
    }

    /**
     * <p>
     * Gets the old name of the node.
     * </p>
     *
     * @return The old name of the node.
     */
    public String getOldName() {
        return this.oldName;
    }

    /**
     * <p>
     * Gets the new name for the node.
     * </p>
     *
     * @return The new name for the node.
     */
    public String getNewName() {
        return this.newName;
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
}
