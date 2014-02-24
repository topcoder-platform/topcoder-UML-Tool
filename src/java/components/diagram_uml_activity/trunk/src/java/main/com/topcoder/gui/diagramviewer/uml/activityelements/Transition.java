/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextInputTrigger;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.statemachines.Guard;

/**
 * <p>
 * This class is a concrete Edge, it will be shown as a line (continuous in general with the exception that when it is
 * connected to an ObjectFlowNode is is a dashed line).
 * </p>
 * <p>
 * It contains three TextField fields to represent name, description and stereotype compartment.
 * </p>
 * <p>
 * Change has been made to the original design. The fields nameCompartment, descriptionCompartment and
 * stereotypeCompartment are not final again, they will be changed after graph edge is changed. They will be used to
 * paint themselves.
 * </p>
 * <p>
 * Thread safety: this class is mutable so not thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class Transition extends Edge {

    /**
     * <p>
     * Represents the name compartment of the GraphEdge that this class represents. It will be changed in constructor
     * and <code>notifyGraphEdgeChange</code> method, can be accessed.
     * </p>
     */
    private TextField nameCompartment;

    /**
     * <p>
     * Represents the transition description compartment of the GraphEdge that this class represents. It will be changed
     * in constructor and <code>notifyGraphEdgeChange</code> method, can be accessed.
     * </p>
     */
    private TextField descriptionCompartment;

    /**
     * <p>
     * Represents the stereotype compartment of the GraphEdge that this class represents. It will be changed in
     * constructor and <code>notifyGraphEdgeChange</code> method, can be accessed.
     * </p>
     */
    private TextField stereotypeCompartment;

    /**
     * <p>
     * Creates an instance of <code>Transition</code>.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     * @throws IllegalArgumentException
     *             if graphEdge is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure
     */
    public Transition(GraphEdge graphEdge) {
        super(graphEdge, getLineStyle(graphEdge), null, new SimpleArrowEdgeEnding(calculateAngle(graphEdge),
                calculateEndingPoint(graphEdge)));
        addTextFields(graphEdge);

        setFont(new Font("Arial", Font.PLAIN, 10));
        // set font for the compartments
        nameCompartment.setFont(getFont());
        stereotypeCompartment.setFont(getFont());
        descriptionCompartment.setFont(getFont());

        TextInputTrigger textInputTrigger = new TextInputTrigger(nameCompartment);
        nameCompartment.addMouseListener(textInputTrigger);
        //BUGR-120 double click on edge opens name edit box
        addMouseListener(textInputTrigger);

        notifyGraphEdgeChange();
    }

    /**
     * <p>
     * Returns the <code>LineStyle</code> corresponding to the nodes which are connected by this transition.
     * </p>
     * <p>
     * If this transition connects an <code>ObjectFlowNode</code> a dashed line style is returned, otherwise a
     * continuous line style is returned.
     * </p>
     * @param graphEdge
     *            the <code>GraphEdge</code> which connects to <code>GraphElements</code>
     * @return the suitable <code>LineStyle</code> according to the connected nodes
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure
     */
    private static LineStyle getLineStyle(GraphEdge graphEdge) {
        Util.checkNotNull(graphEdge, "graphEdge");
        Util.checkGraphEdge(graphEdge);
        List<GraphConnector> graphConnectors = graphEdge.getAnchors();
        for (GraphConnector graphConnector : graphConnectors) {
            if ((Util.getElement(graphConnector.getGraphElement())) instanceof ObjectFlowNode) {
                // return dashed line
                return (new LineStyle(5, 3));
            }
        }
        // return continuous line
        return (new LineStyle(5, 0));
    }

    /**
     * <p>
     * Creates three compartments and adds them as children.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     */
    private void addTextFields(GraphEdge graphEdge) {
        GraphNode nameGraphNode = (GraphNode) (graphEdge.getContaineds().get(0));
        GraphNode descriptionGraphNode = (GraphNode) (graphEdge.getContaineds().get(1));
        GraphNode stereotypeGraphNode = (GraphNode) (graphEdge.getContaineds().get(2));
        /*
         * BugFix: BUGID UML-7178
         * Description:
         * This method should create three TextFields and add them to the edge through new added addTextField
         * method which can add a created TextField. This method should not call addTextField with a graph edge
         * argument now. And it doesn't have to set the position and size of TextFields, because they will be
         * arranged automatically by Edge.
         * Solution:
         * Code is modified to use the new addTextField method of Edge.
         */
        // old code
//        addTextField(nameGraphNode, "name", AnchorType.Line);
//        addTextField(descriptionGraphNode, "description", AnchorType.Line);
//        addTextField(stereotypeGraphNode, "stereotype", AnchorType.Line);
//        nameCompartment = new TextField(nameGraphNode);
//        descriptionCompartment = new TextField(descriptionGraphNode);
//        stereotypeCompartment = new TextField(stereotypeGraphNode);
//        nameCompartment.setLocation(Util.getGraphNodePosition(nameGraphNode));
//        nameCompartment.setSize(Util.getGraphNodeSize(nameGraphNode));
//        nameCompartment.setVisible(nameGraphNode.isVisible());
//        descriptionCompartment.setLocation(Util.getGraphNodePosition(descriptionGraphNode));
//        descriptionCompartment.setSize(Util.getGraphNodeSize(descriptionGraphNode));
//        descriptionCompartment.setVisible(descriptionGraphNode.isVisible());
//        stereotypeCompartment.setLocation(Util.getGraphNodePosition(stereotypeGraphNode));
//        stereotypeCompartment.setSize(Util.getGraphNodeSize(stereotypeGraphNode));
//        stereotypeCompartment.setVisible(stereotypeGraphNode.isVisible());
//        add(nameCompartment);
//        add(descriptionCompartment);
//        add(stereotypeCompartment);
        nameCompartment = new TextField(nameGraphNode);
        descriptionCompartment = new TextField(descriptionGraphNode);
        stereotypeCompartment = new TextField(stereotypeGraphNode);
        addTextField(nameCompartment, AnchorType.Line);
        addTextField(descriptionCompartment, AnchorType.Line);
        addTextField(stereotypeCompartment, AnchorType.Line);
    }

    /**
     * <p>
     * Calculates EdgeEnding's angle.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     * @throws IllegalArgumentException
     *             if graphEdge is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure
     * @return the angle of EdgeEnding
     */
    private static double calculateAngle(GraphEdge graphEdge) {
        Util.checkNotNull(graphEdge, "graphEdge");
        if (graphEdge.countAnchors() != 2) {
            throw new IllegalGraphElementException(graphEdge, "graphEdge should have two anchors.");
        }
        List<GraphConnector> anchors = graphEdge.getAnchors();
        double x1 = anchors.get(0).getPosition().getX();
        double y1 = anchors.get(0).getPosition().getY();
        double x2 = anchors.get(1).getPosition().getX();
        double y2 = anchors.get(1).getPosition().getY();
        double angle = Math.atan2(y2 - y1, x2 - x1);
        if (angle < 0) {
            angle += Math.PI * 2;
        }
        return angle;
    }

    /**
     * <p>
     * Calculates EdgeEnding's endingPoint.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     * @throws IllegalArgumentException
     *             if graphEdge is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure
     * @return the endingPoint of EdgeEnding
     */
    private static Point calculateEndingPoint(GraphEdge graphEdge) {
        Util.checkNotNull(graphEdge, "graphEdge");
        if (graphEdge.countAnchors() != 2) {
            throw new IllegalGraphElementException(graphEdge, "graphEdge should have two anchors.");
        }
        return new Point((int) graphEdge.getAnchors().get(1).getPosition().getX(), (int) graphEdge.getAnchors().get(1)
                .getPosition().getY());
    }

    /**
     * <p>
     * Gets a name compartment <code>TextField</code>.
     * </p>
     * @return the text field representing name compartment
     */
    public TextField getNameCompartment() {
        return nameCompartment;
    }

    /**
     * <p>
     * Gets a description compartment <code>TextField</code>.
     * </p>
     * @return the text field representing description compartment
     */
    public TextField getDescriptionCompartment() {
        return descriptionCompartment;
    }

    /**
     * <p>
     * Gets a stereotype compartment <code>TextField</code>.
     * </p>
     * @return the text field representing stereotype compartment
     */
    public TextField getStereotypeCompartment() {
        return stereotypeCompartment;
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained graphEdge.
     * </p>
     * @throws IllegalGraphElementException
     *             if the structure of <code>GraphEdge</code> is invalid
     */
    public void notifyGraphEdgeChange() {
        GraphEdge graphEdge = getGraphEdge();
        Util.checkGraphEdge(graphEdge);

        /*
         * Bugfix: UML-9716
         */
        // old code
//        // Remove old text fields
//        removeTextField(nameCompartment.getGraphNode());
//        removeTextField(descriptionCompartment.getGraphNode());
//        removeTextField(stereotypeCompartment.getGraphNode());
//        remove(nameCompartment);
//        remove(descriptionCompartment);
//        remove(stereotypeCompartment);
//        // Add new text fields
//        addTextFields(graphEdge);

        ModelElement element = Util.getElement(graphEdge);
        stereotypeCompartment.setText(Util.getStereotypeCompartment(graphEdge));
        nameCompartment.setText(element.getName());
        descriptionCompartment.setText(getDescriptionCompartment(graphEdge));

        // resize and relocate name, stereotype compartments
        updateTextFieldSizeLocation(nameCompartment);
        updateTextFieldSizeLocation(stereotypeCompartment);
        updateTextFieldSizeLocation(descriptionCompartment);
    }

    /**
     * <p>
     * Updates the TextField's size and location / visibility.
     * </p>
     * @param textField
     *            the TextField needs to be updated
     */
    private void updateTextFieldSizeLocation(TextField textField) {
        GraphNode graphNode = textField.getGraphNode();

        if (graphNode.isVisible()) {
            Dimension preferredSize = textField.getPreferredSize();
            if (textField.getWidth() < preferredSize.width) {
                textField.setSize(preferredSize);
            }
            textField.setVisible(true);
        } else {
            textField.setVisible(false);
        }
    }

    /**
     * <p>
     * Returns the description compartment text of given <code>GraphElement</code>.
     * </p>
     * @param graphEdge
     *            the <code>GraphEdge</code> which description compartment text is returned
     * @return the text of the description compartment of given <code>GraphEdge</code>
     */
    private String getDescriptionCompartment(GraphEdge graphEdge) {

        com.topcoder.uml.model.statemachines.Transition transition = (com.topcoder.uml.model.statemachines.Transition) ((Uml1SemanticModelBridge) graphEdge
                .getSemanticModel()).getElement();

        Guard guard = transition.getGuard();

        if (guard != null) {
            BooleanExpression expression = guard.getExpression();
            if (expression != null) {
                return "[" + expression.getBody() + "]";
            }
        }
        return "";
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element.
     * </p>
     * @param event
     *            the mouse event or mouse motion event
     * @return true if the event is consumed, otherwise false
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }
}
