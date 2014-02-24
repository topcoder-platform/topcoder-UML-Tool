/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an FreeTextNode to the diagram view. It will create model element and graph element, then
 * add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddFreeTextNodeAction extends AddNodeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add FreeText Node";

    /**
     * <p>
     * Represents the uml model manager.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Position of the graph node for this node.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Size of the graph node for this node.
     * </p>
     */
    private Dimension size;

    /**
     * <p>
     * Text to display for this node.
     * </p>
     */
    private String text;

    /**
     * <p>
     * Graph node for this node.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Creates an instance of <code>AddFreeTextNodeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param position
     *            position of the graph node for added node
     * @param size
     *            size of the graph node for added node
     * @param text
     *            name of the model element for added node
     */
    public AddFreeTextNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, String text) {
        super(PRESENTATION_NAME, mainFrame, view);
        this.position = position;
        this.size = size;
        this.text = text;

        modelManager = UMLModelManager.getInstance();

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates the model element for new node. Empty as there's no model element for FreeTextNode.
     * </p>
     */
    protected void createModelElement() {
    }

    /**
     * <p>
     * Creates the graph node for new node.
     * </p>
     */
    protected void createGraphNode() {
        graphNode = DeployHelper.createGraphNodeForFreeText(position, size, text);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphNode, modelManager
                .getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates a new FreeTextNode.
     * </p>
     */
    protected void createNode() {
        FreeTextNode node = DeployHelper.createFreeTextNode(getMainFrame(), graphNode);
        setNode(node);
    }
}
