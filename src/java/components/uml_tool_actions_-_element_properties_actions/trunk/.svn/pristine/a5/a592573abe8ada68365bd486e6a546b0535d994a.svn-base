/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.Collection;
import java.util.Iterator;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action is for changing style properties
 * of a diagram element. The properties are added as Property elements to the diagram element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action. If any exception prevents
 * redo/undo methods from completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class ChangeStyleAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the property of the style. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction
     * and executeAction methods.
     * </p>
     */
    private final Property property;

    /**
     * <p>
     * Represents the old value of the property before this action performed. This variable is set
     * in the constructor, is immutable (the reference). This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final String oldValue;

    /**
     * <p>
     * Represents the new value of the property after this action performed. This variable is set in
     * the constructor, is immutable (the reference). This variable is referenced in the redoAction
     * and executeAction methods.
     * </p>
     */
    private final String newValue;

    /**
     * <p>
     * Constructor of the change style action.
     * </p>
     *
     * @param diagram
     *        the non null diagram element to change style
     * @param name
     *        the non null name of the style
     * @param value
     *        the non null new value of the style
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public ChangeStyleAction(DiagramElement diagram, String name, String value) {
        super("Change style " + name + " to " + value);
        Helper.checkNotNull(diagram, "diagram");
        Helper.checkNotNull(name, "name");
        Helper.checkNotNull(value, "value");
        // get all of the properties.
        Collection<Property> properties = diagram.getProperties();
        Iterator<Property> iter = properties.iterator();
        Property theProperty = null;
        // get the target style according to the name.
        while (iter.hasNext()) {
            theProperty = iter.next();
            if (theProperty.getKey().equals(name)) {
                break;
            }
            theProperty = null;
        }

        // if we can't find the property, create a new one, add it to the diagram.
        if (theProperty == null) {
            property = new Property();
            property.setKey(name);
            diagram.addProperty(property);
        } else {
            property = theProperty;
        }
        oldValue = property.getValue();
        newValue = value;
    }

    /**
     * <p>
     * Redo the change style action.
     * </p>
     */
    public void redoAction() {
        property.setValue(newValue);
    }

    /**
     * <p>
     * Undo the change style action.
     * </p>
     */
    public void undoAction() {
        property.setValue(oldValue);
    }

    /**
     * <p>
     * Execute the change style action.
     * </p>
     */
    public void executeAction() {
        property.setValue(newValue);
    }
}
