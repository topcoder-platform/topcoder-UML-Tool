/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.sequence.AddObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used for add an object node to the diagram view.
 * </p>
 * <p>
 * AddObjectAction and AddDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddObjectNodeAction extends AddNodeAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Object Node";

    /**
     * <p>
     * Represents the default y-coordinate of object nodes.
     * </p>
     */
    private static final int DEFAULT_OBJECTNODE_Y = 80;

    /**
     * <p>
     * Reference to UMLModelManager. Used for create predefined actions.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Position to add the object node.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Object implementation encapsulated in ObjectNode.
     * </p>
     */
    private Object object;

    /**
     * <p>
     * Graph node for ObjectNode.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Counter used for naming the created lifelines.
     * </p>
     */
    private static int counter = 1;

    /**
     * <p>
     * Creates an instance of AddObjectNodeAction and creates object, graph node, ObjectNode.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param view
     *            reference to diagram view
     * @param position
     *            adding position of ObjectNode
     */
    public AddObjectNodeAction(MainFrame mainFrame, DiagramView view, Point position) {
        super(PRESENTATION_NAME, mainFrame, view);
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(view, "view");
        DeployHelper.checkNotNull(position, "position");
        this.position = new Point(position);
        List<ObjectNode> nodes = DeployHelper.getObjectNodes(view);
        if (nodes.isEmpty()) {
            this.position.y = DEFAULT_OBJECTNODE_Y;
        } else {
            this.position.y = (int) nodes.get(0).getGraphNode().getPosition().getY();
        }

        modelManager = UMLModelManager.getInstance();

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates an instance of AddObjectNodeAction and creates object, graph node, ObjectNode.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param view
     *            reference to diagram view
     * @param position
     *            adding position of ObjectNode
     * @param element
     *            specified model element for added node
     */
    public AddObjectNodeAction(MainFrame mainFrame, DiagramView view, Point position, Object element) {
        super(PRESENTATION_NAME, mainFrame, view);
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(view, "view");
        DeployHelper.checkNotNull(position, "position");
        this.position = new Point(position);
        List<ObjectNode> nodes = DeployHelper.getObjectNodes(view);
        if (nodes.isEmpty()) {
            this.position.y = DEFAULT_OBJECTNODE_Y;
        } else {
            this.position.y = (int) nodes.get(0).getGraphNode().getPosition().getY();
        }
        this.object = element;

        modelManager = UMLModelManager.getInstance();

        createModelElement();
        createGraphNode();
        createNode();
    }

    /**
     * <p>
     * Creates the object and the AddObjectAction.
     * </p>
     */
    protected void createModelElement() {
        if (object == null) {
            object = new ObjectImpl();
            object.setName("Lifeline" + (counter++));
            Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) getDiagramView().getDiagram().getOwner();
            setAddModelElementAction(new AddObjectAction(object, (Collaboration) bridge.getElement(), modelManager));
        }
    }

    /**
     * <p>
     * Creates the graph node and the AddDiagramElementAction.
     * </p>
     */
    protected void createGraphNode() {
        graphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point umlPosition = new com.topcoder.diagraminterchange.Point();
        umlPosition.setX(position.x);
        umlPosition.setY(position.y);
        graphNode.setPosition(umlPosition);
        graphNode.setSize(new Dimension());

        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(object);
        graphNode.setSemanticModel(uml1ModelBridge);

        setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphNode, modelManager
                .getProjectConfigurationManager()));
    }

    /**
     * <p>
     * Creates the object node.
     * </p>
     */
    protected void createNode() {
        ObjectNode objectNode = DeployHelper.createObjectNode(getMainFrame(), graphNode);
        DiagramView view = super.getDiagramView();
        Diagram diagram = view.getDiagram();
        DeployHelper.getLifeLine(objectNode).setSize((int) diagram.getSize().getWidth(),
                (int) diagram.getSize().getHeight());
        setNode(objectNode);
    }

    /**
     * <p>
     * Performs the adding action of object, graph node and object node.
     * </p>
     */
    private void performAction() {
        DeployHelper.layoutSequenceEdges(getMainFrame(), getDiagramView());
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        super.executeAction();
        performAction();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        super.redoAction();
        performAction();
    }
}
