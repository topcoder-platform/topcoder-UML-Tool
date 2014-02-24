/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.model.classifiers.AddExceptionAction;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used to add an ExceptionNode to the diagram view. It will create model element and graph element, then
 * add them to uml model manager and diagram first. This action is an UndoableAction.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddExceptionNodeAction extends AddNodeAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Exception Node";

    /**
     * <p>
     * Counter for created node instance, its value will be used as default index for new node.
     * </p>
     */
    private static int counter = 0;

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
    private Class element;

    /**
     * <p>
     * Graph node for this node.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Creates an instance of <code>AddExceptionNodeAction</code>.
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
    public AddExceptionNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, String name) {
        this(mainFrame, view, position, size, name, null);
    }

    /**
     * <p>
     * Creates an instance of <code>AddExceptionNodeAction</code>.
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
    public AddExceptionNodeAction(MainFrame mainFrame, DiagramView view, Point position, Dimension size, String name,
        NodeContainer nodeContainer) {
        super(PRESENTATION_NAME, mainFrame, view, nodeContainer);
        this.position = position;
        this.size = size;
        if (name == null) {
            this.name = "Exception_" + (++counter);
        } else {
            this.name = name;
        }

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
        element = new ClassImpl();
        element.setName(name);

        // Obtain the stereotypes from project configuration manager
        Set<Stereotype> newStereotypes = new HashSet<Stereotype>();
        newStereotypes.add(getStandardStereotype("exception"));
        if (modelManager.getProjectLanguage().equals("CSharp")) {
            newStereotypes.add(getStandardStereotype("Serializable"));
        }
        getMainFrame().getPropertiesPanel().addStereotypes(newStereotypes, element.getClass());
        for (Stereotype stereotype : newStereotypes) {
            element.addStereotype(stereotype);
        }

        NodeContainer nodeContainer = getNodeContainer();
        try {
            if (nodeContainer != null) {
                setAddModelElementAction(new AddExceptionAction(element, modelManager, (Namespace) DeployHelper
                        .getElement(nodeContainer)));
            } else {
                setAddModelElementAction(new AddExceptionAction(element, modelManager));
            }
        } catch (InvalidDataContentException e) {
            // impossible
        }
    }

    /**
     * <p>
     * Gets the standard stereotype according to specified name.
     * </p>
     * @param name
     *            specified stereotype name
     * @return the found stereotype, null if not found
     */
    private Stereotype getStandardStereotype(String name) {
        try {
            List<Stereotype> standardStereotypes = getMainFrame().getPropertiesPanel().getStereotypes(
                    element.getClass());
            for (Stereotype standard : standardStereotypes) {
                if (standard.getName().equalsIgnoreCase(name)) {
                    return standard;
                }
            }
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    /**
     * <p>
     * Creates the graph node for new node.
     * </p>
     */
    protected void createGraphNode() {
        graphNode = DeployHelper.createGraphNodeForClass(element, position, size);

        NodeContainer nodeContainer = getNodeContainer();
        if (nodeContainer != null) {
            GraphNode container = nodeContainer.getGraphNode();
            GraphNode bodyCompartment = (GraphNode) container.getContaineds().get(1);
            setAddDiagramElementAction(new AddDiagramElementAction(bodyCompartment, graphNode,
                    modelManager.getProjectConfigurationManager()));
        } else {
            setAddDiagramElementAction(new AddDiagramElementAction(getDiagramView().getDiagram(), graphNode,
                    modelManager.getProjectConfigurationManager()));
        }
    }

    /**
     * <p>
     * Creates a new ExceptionNode node.
     * </p>
     */
    protected void createNode() {
        ExceptionNode node = DeployHelper.createExceptionNode(getMainFrame(), graphNode);
        setNode(node);
    }
}
