/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an ActorNode to the diagram view. It will create model element and graph element, then add
 * them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddActorNodeAction extends AddNodeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Actor Node";

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
     * Name of the model element for this node.
     * </p>
     */
    private String name;

    /**
     * <p>
     * Model element for this node.
     * </p>
     */
    private Actor actor;

    /**
     * <p>
     * Graph node for this node.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Creates an instance of <code>AddActorNodeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param position
     *            position of the graph node for added node
     * @param size
     *            size of the graph node for added node
     * @param name
     *            name of the model element for added node
     */
    public AddActorNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, String name) {
        this(mainFrame, view, position, size, name, null);
    }

    /**
     * <p>
     * Creates an instance of <code>AddActorNodeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param position
     *            position of the graph node for added node
     * @param size
     *            size of the graph node for added node
     * @param element
     *            specified model element for added node
     */
    public AddActorNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, Actor element) {
        super(PRESENTATION_NAME, mainFrame, view, null);
        this.position = position;
        this.size = size;
        this.name = element.getName();
        this.actor = element;

        modelManager = UMLModelManager.getInstance();

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates an instance of <code>AddActorNodeAction</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param position
     *            position of the graph node for added node
     * @param size
     *            size of the graph node for added node
     * @param name
     *            name of the model element for added node
     * @param nodeContainer
     *            the NodeContainer which the new node should add to
     */
    public AddActorNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, String name,
        NodeContainer nodeContainer) {
        super(PRESENTATION_NAME, mainFrame, view, nodeContainer);
        this.position = position;
        this.size = size;
        this.name = name;

        modelManager = UMLModelManager.getInstance();

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates the model element for new node.
     * </p>
     */
    protected void createModelElement() {
        if (actor == null) {
            actor = new ActorImpl();
            actor.setName(name);
            NodeContainer nodeContainer = getNodeContainer();
            if (nodeContainer != null) {
                setAddModelElementAction(new AddActorAction(actor, modelManager, (Namespace) DeployHelper
                        .getElement(nodeContainer)));
            } else {
                setAddModelElementAction(new AddActorAction(actor, modelManager));
            }
        }
    }

    /**
     * <p>
     * Creates the graph node for new node.
     * </p>
     */
    protected void createGraphNode() {
        graphNode = DeployHelper.createGraphNodeForActor(actor, position, size);

        NodeContainer nodeContainer = getNodeContainer();
        if (nodeContainer != null) {
            GraphNode container = nodeContainer.getGraphNode();
            GraphNode bodyCompartment = (GraphNode) container.getContaineds().get(1);
            setAddDiagramElementAction(new AddDiagramElementAction(bodyCompartment, graphNode, modelManager
                    .getProjectConfigurationManager()));
        } else {
            setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphNode,
                    modelManager.getProjectConfigurationManager()));
        }
    }

    /**
     * <p>
     * Creates a new ActorNode node.
     * </p>
     */
    protected void createNode() {
        ActorNode node = DeployHelper.createActorNode(getMainFrame(), graphNode);
        setNode(node);
    }
}
