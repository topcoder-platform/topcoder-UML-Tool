/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

/**
 * <p>
 * This is an enumeration that stands for states of DiagramViewer.
 * </p>
 *
 * <pre>
 *          The DiagramViewer has three states currently:
 *          1) ADD_ELEMENT_BY_CLICK: user can add new element to the DiagramView by clicking on it.
 *          2) ADD_ELEMENT_BY_DRAGGING_RECTANGLE: user can add new element to the DiagramView by dragging a bounds
 *             rectangle on the it.
 *          3) SELECT_ELEMENT: user can select elements on the DiagramView by dragging a selection rectangle
 *               on it.
 * </pre>
 *
 * <p>
 * Thread safety: this is enumeration so is thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public enum DiagramState {
    /**
     * <p>
     * Represents the state that user can select elements on the DiagramView by
     * dragging a selection rectangle on it.
     * </p>
     */
     SELECT_ELEMENT,

    /**
     * <p>
     * Represents the state that user can add new element to the DiagramView by
     * clicking on it.
     * </p>
     */
    ADD_ELEMENT_BY_CLICK,

    /**
     * <p>
     * Represents the state that user can add new element to the DiagramView by
     * dragging a bounds rectangle on the it.
     * </p>
     */
    ADD_ELEMENT_BY_DRAGGING_RECTANGLE,

    /*
	 * BugFix: BUGID UML-7695
	 * Description:
	 * When adding edges in Diagram Viewer, a bounds rectangle is drawn between the
	 * elements being linked, instead of showing the edge directly.  This is confusing
	 * to the user and needs to be changed.
	 *
	 * In the requirements:
	 * "1.2.7.3    Add new element (add element state for the diagram)
	 *
	 * The application should be able to change the state of the diagram (using some
	 * flag) so that if an element is selected to be added to the diagram, the mouse
	 * events will be processed differently. The graphical element will be obtained
	 * from a pluggable source.
	 * There are two ways of adding elements:
	 * -    when the mouse is clicked
	 * -    after the mouse draws a bounds rectangle for the element.
	 * The option about how to add the element should be configurable also through
	 * the API (meaning that when an element should be added, the application should
	 * have a way to configure how the element will be added)."
	 *
	 * Should have been like this:
	 * "There are four ways of adding elements:
	 * -    when the mouse is clicked
	 * -    after the mouse draws a bounds rectangle for the element
	 * -    after the mouse draws a continuous line for the edge
	 * -    after the mouse draws a dashed line for the edge."
	 */
    /**
     * <p>
     * Represents the state that user can add new edge to the DiagramView by
     * dragging a continous line on it.
     * </p>
     */
    ADD_SOLID_EDGE,

    /**
     * <p>
     * Represents the state that user can add new edge to the DiagramView by
     * dragging a dashed line on it.
     * </p>
     */
    ADD_DASHED_EDGE;
}
