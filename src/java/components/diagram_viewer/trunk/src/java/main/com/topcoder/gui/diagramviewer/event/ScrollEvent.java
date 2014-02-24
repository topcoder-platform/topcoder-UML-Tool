/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventObject;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DVHelper;

/**
 * <p>
 * This event indicates that a DiagramView is scrolled.
 * </p>
 * <p>
 * Note, the DiagramView can be retrieved by getSource().
 * </p>
 * <p>
 * Thread safety: This class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ScrollEvent extends EventObject {
    /**
     * <p>
     * Represents the diagram for which this event is triggered.
     * </p>
     * <p>
     * Initialized in ctor, and never changed later. Can not be null. Can be
     * accessed by getter.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param source the new JViewport
     * @param diagram the diagram that is scrolled
     * @throws IllegalArgumentException if any arg is null
     */
    public ScrollEvent(JViewport source, Diagram diagram) {
        super(source);
        DVHelper.validateNotNull(diagram, "diagram");
        this.diagram = diagram;
    }

    /**
     * <p>
     * Getter of the diagram, see field doc for explanation.
     * </p>
     *
     * @return the diagram that is scrolled
     */
    public Diagram getDiagram() {
        return diagram;
    }
}
