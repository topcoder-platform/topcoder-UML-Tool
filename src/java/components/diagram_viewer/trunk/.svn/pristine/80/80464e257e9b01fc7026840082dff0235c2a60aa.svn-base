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
 * This event indicates that the selection rectangle of a DiagramView is
 * changed. It is triggered when the user drags mouse on the DiagramView when
 * the state of DiagramViewer is DiagramState.SELECT_ELEMENT.
 * </p>
 * <p>
 * It has only one property that is a rectangle which represents the selection
 * rectangle.
 * </p>
 * <p>
 * Thread safety: This class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SelectionEvent extends EventObject {

    /**
     * <p>
     * Represents the selection rectangle.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null. Can be
     * accessed by getter.
     * </p>
     */
    private final Rectangle selectionRectangle;

    /**
     * <p>
     * Constructor, simply assigns the arguments to corresponding fields.
     * </p>
     *
     * @param source the DiagramView where this event occurs
     * @param rectangle the selection rectangle
     * @throws IllegalArgumentException if any arg is null.
     */
    public SelectionEvent(DiagramView source, Rectangle rectangle) {
        super(source);
        DVHelper.validateNotNull(rectangle, "rectangle");
        this.selectionRectangle = rectangle;
    }

    /**
     * <p>
     * Getter of the selectionRectangle, see field doc for explanation.
     * </p>
     *
     * @return current selection rectangle
     */
    public Rectangle getSelectionRectangle() {
        return selectionRectangle;
    }
}
