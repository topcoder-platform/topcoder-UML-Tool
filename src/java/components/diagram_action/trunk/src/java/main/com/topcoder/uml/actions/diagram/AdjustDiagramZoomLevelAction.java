/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class is an implementation of <code>TransientAction</code>.
 * </p>
 *
 * <p>
 * This action will change the zoom attribute of a diagram.
 * <p>
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
 * Diagram diagram = new Diagram();
 * // Create an adjust diagram zoom level action which will change zoom level of the diagram to 200%
 * AdjustDiagramZoomLevelAction adjustDiagramZoomLevelAction = new AdjustDiagramZoomLevelAction(diagram, 2.0);
 *
 * // Execute the action
 * adjustDiagramZoomLevelAction.execute();
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
public class AdjustDiagramZoomLevelAction implements TransientAction {

    /**
     * <p>
     * Represents the diagram to change the zoom level.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the execute method.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Represents the new zoom level.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference).
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>execute</code> method.
     * </p>
     */
    private final Double newZoomLevel;

    /**
     * <p>
     * Constructor of the adjust diagram zoom level action.
     * </p>
     *
     * @param diagram the non null diagram
     * @param newZoomLevel the zoom level of the diagram
     *
     * @throws IllegalArgumentException if the diagram is null, or if newZoomLevel is null or negative
     */
    public AdjustDiagramZoomLevelAction(Diagram diagram, Double newZoomLevel) {
        Helper.checkNotNull(diagram, "diagram");
        Helper.checkNotNull(newZoomLevel, "newZoomLevel");
        // simply compare them, as -0.0 is also a valid Double value according to designer.
        if (newZoomLevel < 0) {
            throw new IllegalArgumentException("The newZoomLevel should not be negative.");
        }
        this.diagram = diagram;
        this.newZoomLevel = newZoomLevel;
    }

    /**
     * <p>
     * Performs the actions.
     * </p>
     *
     * <p>
     * Adjust diagram's zoom level to the newZoomLevel.
     * </p>
     */
    public void execute() {
        diagram.setZoom(newZoomLevel);
    }
}
