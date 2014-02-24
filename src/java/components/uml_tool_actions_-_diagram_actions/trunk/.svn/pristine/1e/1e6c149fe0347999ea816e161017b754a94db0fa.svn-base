/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class is an implementation of <code>TransientAction</code>.
 * </p>
 *
 * <p>
 * This action will change the viewport property of a diagram.
 * </p>
 *
 * <p>
 * This class will be created by application directly. The application will call <code>execute</code> to perform the
 * action.
 * </p>
 *
 * <p>
 * <b>Usage demo:</b>
 * </p>
 * <pre>
 * // Create a new view port (10, 20)
 * Point viewport = new Point();
 * viewport.setX(10);
 * viewport.setY(20);
 *
 * // Create a scroll diagram view action which will change view port of the diagram to (10,20)
 * ScrollDiagramViewAction scrollDiagramViewAction = new ScrollDiagramViewAction(diagram, viewport);
 *
 * // Execute the action
 * scrollDiagramViewAction.execute();
 * </pre>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is thread safe by being immutable.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class ScrollDiagramViewAction implements TransientAction {
    /**
     * <p>
     * Represents the diagram to change the viewport.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>execute</code> method.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Represents the new viewport.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference).
     * </p>
     *
     * <p>
     * This variable is referenced in the execute method.
     * </p>
     */
    private final Point newViewport;

    /**
     * <p>
     * Constructor of the scroll diagram view action.
     * </p>
     *
     * <p>
     * An IllegalArgumentException will be thrown if the diagram is null or if the newViewport is null.
     * </p>
     *
     * @param diagram the non null diagram
     * @param newViewport the view port of the diagram
     *
     * @throws IllegalArgumentException if the diagram is null or the newViewport is null
     */
    public ScrollDiagramViewAction(Diagram diagram, Point newViewport) {
        Helper.checkNotNull(diagram, "Diagram");
        Helper.checkNotNull(newViewport, "new viewport");
        this.diagram = diagram;
        this.newViewport = newViewport;
    }

    /**
     * <p>
     * Performs the actions. Change the viewport property of the diagram.
     * </p>
     */
    public void execute() {
        diagram.setViewport(newViewport);
    }
}
