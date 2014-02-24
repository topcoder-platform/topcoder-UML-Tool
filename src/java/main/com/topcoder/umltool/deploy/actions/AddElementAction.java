/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This is an action to be used to add element to diagram view.
 * </p>
 * @author ly
 * @version 1.0
 */
public class AddElementAction extends AbstractAction {

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 525843238473204472L;

    /**
     * <p>
     * Reference to name of the adding element.
     * </p>
     */
    private final String name;

    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the class of the start node.
     * </p>
     */
    private final Class<?> nodeClass;

    /**
     * <p>
     * Represents the class of the edge.
     * </p>
     */
    private final Class<?> edgeClass;

    /**
     * <p>
     * Represents the diagram view to add element.
     * </p>
     */
    private final DiagramView diagramView;

    /**
     * <p>
     * Defines an <code>AddElementAction</code> object with the specified description string for specified component.
     * </p>
     * @param name
     *            name of the menu item
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            diagram view to add element
     * @param nodeClass
     *            class type of start node
     */
    public AddElementAction(String name, MainFrame mainFrame, DiagramView diagramView, Class<?> nodeClass) {
        this(name, mainFrame, diagramView, nodeClass, null);
    }

    /**
     * <p>
     * Defines an <code>AddElementAction</code> object with the specified description string for specified component.
     * </p>
     * @param name
     *            name of the menu item
     * @param mainFrame
     *            reference to main frame
     * @param diagramView
     *            diagram view to add element
     * @param nodeClass
     *            class type of start node
     * @param edgeClass
     *            class type of edge
     */
    public AddElementAction(String name, MainFrame mainFrame, DiagramView diagramView, Class<?> nodeClass, Class<?> edgeClass) {
        super(name);
        this.name = name;
        this.mainFrame = mainFrame;
        this.diagramView = diagramView;
        this.nodeClass = nodeClass;
        this.edgeClass = edgeClass;
    }

    /**
     * <p>
     * Adds the component to diagram view.
     * </p>
     * @param e
     *            the action event (ignore null)
     */
    public void actionPerformed(ActionEvent e) {
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        Rectangle bound = new Rectangle(mainFrame.getPopupPosition());
        if (edgeClass == null) {
            viewer.fireNewElementAdded(diagramView, nodeClass, bound);
        } else {
            if (name.equals("New Association")) {
                mainFrame.setAssociationType(NoArrow.class);
            } else if (name.equals("New Aggregation")) {
                mainFrame.setAssociationType(Aggregation.class);
            } else if (name.equals("New Composition")) {
                mainFrame.setAssociationType(Composition.class);
            }
            viewer.setNewElementType(edgeClass);
            diagramView.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            if (edgeClass == DependencyEdge.class || edgeClass == AbstractionEdge.class
                    || edgeClass == IncludeEdge.class || edgeClass == ExtendEdge.class
                    || edgeClass == CommentLinkEdge.class) {
                viewer.setState(DiagramState.ADD_DASHED_EDGE);
            } else {
                viewer.setState(DiagramState.ADD_SOLID_EDGE);
            }
        }
    }
}
