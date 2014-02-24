/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>
 * This class can trigger selection when some edge is clicked. A {@link BaseEdge} instance should be given to
 * this class to understand which edge should be selected.
 * </p>
 *
 * <p>
 * For example, this trigger can be registered to a dependency edge, and the text field representing name compartment
 * will be associated with this trigger. As a result, when the dependency edge is clicked, the edge and its
 * compartments will be selected.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class EdgeSelectionTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the edge which will be selected.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and never changed later. It should not be null. When this trigger is notified,
     * the edge gets selected.
     * </p>
     */
    private final BaseEdge edge;

    /**
     * <p>
     * Simple constructor.
     * </p>
     *
     * @param edge
     *            the edge to be selected.
     *
     * @throws IllegalArgumentException if edge is null
     */
    public  EdgeSelectionTrigger(BaseEdge edge) {
        Utils.checkObjectNotNull(edge, "edge");
        this.edge = edge;
    }

    /**
     * <p>
     * Handle the <code>MOUSE_CLICKED</code> event.
     * </p>
     *
     * @param event
     *            the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent event) {
        if (event == null || event.getButton() != MouseEvent.BUTTON1 || event.getClickCount() != 1) {
            return;
        }

        //Select edge and compartments
//        edge.notifySelected();
        // This requires an change on Diagram Edges component
        //FIXME
    }

}
