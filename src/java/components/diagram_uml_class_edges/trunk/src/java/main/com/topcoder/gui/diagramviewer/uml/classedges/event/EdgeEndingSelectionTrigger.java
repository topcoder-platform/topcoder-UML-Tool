/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.Utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>
 * This class can trigger selection when some edge ending is clicked. An {@link ActiveEdgeEnding} instance should be
 * given to this class to understand which edge ending should be selected.
 * </p>
 *
 * <p>
 * For example, this trigger can be registered to a composition edge ending, and the text field representing name
 * compartment will be associated with this trigger. As a result, when the composition edge ending is clicked, the edge
 * edge ending and its compartments will be selected.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class EdgeEndingSelectionTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the edge ending which will be selected. When this trigger is notified, the edge ending gets selected.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and never changed later. It should not be null.
     * </p>
     */
    private final ActiveEdgeEnding edgeEnding;

    /**
     * <p>
     * Simple constructor.
     * </p>
     *
     * @param edgeEnding
     *            the edgeEnding to be selected.
     *
     * @throws IllegalArgumentException
     *             if edgeEnding is null
     */
    public EdgeEndingSelectionTrigger(ActiveEdgeEnding edgeEnding) {
        Utils.checkObjectNotNull(edgeEnding, "edgeEnding");
        this.edgeEnding = edgeEnding;
    }

    /**
     * <p>
     * Handle the MOUSE_CLICKED event.
     * </p>
     *
     * @param event
     *            the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent event) {
        if (event == null || event.getButton() != MouseEvent.BUTTON1 || event.getClickCount() != 1) {
            return;
        }

        //Select the edge ending
        edgeEnding.selected(true);
    }
}
