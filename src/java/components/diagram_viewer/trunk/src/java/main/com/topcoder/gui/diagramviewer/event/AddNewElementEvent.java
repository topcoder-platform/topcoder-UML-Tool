/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.event;

import java.awt.Rectangle;
import java.util.EventObject;

import com.topcoder.gui.diagramviewer.DVHelper;
import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This event indicates that a new element should be added to the DiagramView.
 * It is triggered when the state of the Diagram Viewer is
 * DiagramState.ADD_ELEMENT_BY_CLICK or
 * DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE, and the user finished the
 * adding action (either by clicking or by dragging a rectangle on the
 * DiagramView, the listener who is interest in this event should add the
 * element to the DiagramView finally.
 * </p>
 * <p>
 * It has tow properties, one represents the type of the new element, another
 * represents the DiagramView. Note, the DiagramView can be retrieved by method
 * getSource().
 * </p>
 * <p>
 * Thread safety: This class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class AddNewElementEvent extends EventObject {

    /**
     * <p>
     * Represents the type of the new element to be added to the Diagram View.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null but can be
     * empty. Can be accessed by getter. Must be sub class of
     * com.topcoder.gui.diagramviewer.elements.Node or
     * com.topcoder.gui.diagramviewer.edges.Edge.
     * </p>
     */
    private final Class newElementType;

    /**
     * <p>
     * Represents the bounds of the new element. The bounds may be specified by
     * the user by dragging a rectangle on the DiagramView.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null, can be an
     * empty rectangle that indicates there is no bounds specified for the new
     * element. Can be accessed by getter.
     * </p>
     */
    private final Rectangle newElementBounds;

    /**
     * <p>
     * Constructor, simply assigns the arguments to fields, and initialize the
     * newElementBounds to an empty rectangle.
     * </p>
     *
     * @param source the DiagramView to where the new element should be added
     * @param type the type of the new element
     * @throws IllegalArgumentException if any argument is null, or if the type
     *             is not sub class of
     *             com.topcoder.gui.diagramviewer.elements.Node or
     *             com.topcoder.gui.diagramviewer.edges.Edge
     */
    public AddNewElementEvent(DiagramView source, Class type) {
        this(source, type, new Rectangle());
    }

    /**
     * <p>
     * Constructor, simply assigns the arguments to fields. Note the
     * newElementBounds should be assigned to a copy of the argument to prevent
     * unexpected modification.
     * </p>
     *
     * @param source the DiagramView to where the new element should be added
     * @param type the type of the new element
     * @param bounds the bounds of the new element
     * @throws IllegalArgumentException if any argument is null, or if the type
     *             is not sub class of
     *             com.topcoder.gui.diagramviewer.elements.Node or
     *             com.topcoder.gui.diagramviewer.edges.Edge
     */
    public AddNewElementEvent(DiagramView source, Class type, Rectangle bounds) {
        super(source);
        DVHelper.validateClassType(type, "type");
        DVHelper.validateNotNull(bounds, "bounds");
        this.newElementType = type;
        this.newElementBounds = new Rectangle(bounds);
    }

    /**
     * <p>
     * Getter of the newElementType, see field doc for explanation.
     * </p>
     *
     * @return the type of new element to be added
     */
    public Class getNewElementType() {
        return newElementType;
    }

    /**
     * <p>
     * Getter of the newElementBounds, see field doc for explanation.
     * </p>
     *
     * @return the bounds of the new element
     */
    public Rectangle getNewElementBounds() {
        return newElementBounds;
    }
}
