/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Font;
import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EditBoxTrigger;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.PopupMenuTrigger;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class is the base Edge of this component. It is an extension of Edge class served for the purpose of providing
 * all the common functions required by Include and Extend edges.
 * </p>
 * <p>
 * It contains three kinds of properties. They are name compartment, stereotype compartment, and keyword metaclass.
 * </p>
 * <p>
 * This class also adds EditBoxTrigger to name compartment automatically to allow name editing. PopupMenuTrigger is also
 * registered automatically to support popup menu.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class BaseEdge extends Edge {
    /**
     * <p>
     * Represents the number of compartments should be contained in the graphNode.
     * </p>
     */
    private static final int NUMBER_OF_COMPARTMENTS = 2;

    /**
     * <p>
     * Represent the default dash length.
     * </p>
     */
    private static final int DEFAULT_DASH_LENGTH = 6;

    /**
     * <p>
     * Represent the default blank length.
     * </p>
     */
    private static final int DEFAULT_BLANK_LENGTH = 6;

    /**
     * <p>
     * Represents the name compartment of this edge. Initialized in constructor, never changed later, can't be null. Can
     * be accessed by getter.
     * </p>
     * <p>
     * The text/size/location of this TextField will be updated in notifyGraphEdgeChange method.
     * </p>
     */
    private final TextField name;

    /**
     * <p>
     * Represents the stereotype compartment of this edge. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter.
     * </p>
     * <p>
     * The text/size/location of this TextField will be updated in notifyGraphEdgeChange method.
     * </p>
     */
    private final TextField stereotype;

    /**
     * <p>
     * Represents the KeywordMetaclass of the edge. It will be displayed as part of stereotype compartment.
     * </p>
     * <p>
     * It could be null, because there is no KeywordMetaclass for the edge. But it couldn't be empty. It is initialized
     * in constructor, and never changed later.
     * </p>
     */
    private final String keywordMetaclass;

    /**
     * <p>
     * Construct a baseEdge instance.
     * </p>
     *
     * @param graphEdge the graphEdge representing this Edge.
     * @param keywordMetaclass the keyword metaclass of this edge
     * @throws IllegalArgumentException if <code>graphEdge</code> is null, or <code>keywordMetaclass</code> is empty
     * @throws IllegalGraphElementException if <code>graphEdge</code> has bad structure.
     */
    protected BaseEdge(GraphEdge graphEdge, String keywordMetaclass) throws IllegalGraphElementException {
        super(checkValidGraphEdge(graphEdge), new LineStyle(DEFAULT_DASH_LENGTH, DEFAULT_BLANK_LENGTH), null,
                new SimpleArrow());
        if (keywordMetaclass != null) {
            if (keywordMetaclass.trim().length() == 0) {
                throw new IllegalArgumentException("keywordMetaclass should not be empty");
            }
        }

        this.keywordMetaclass = keywordMetaclass;

        // Register PopupMenuTrigger to this edge to allow popup menu
        this.addMouseListener(new PopupMenuTrigger());

        // create the compartments
        this.name = new TextField((GraphNode) graphEdge.getContaineds().get(1));
        this.stereotype = new TextField((GraphNode) graphEdge.getContaineds().get(0));

        /*
         * BugFix: UML-10117
         * Set the default font, it is required by text fields to get preferred size. Can be updated by
         * notifyPropertiesChange method.
         */
        setFont(new Font("Arial", Font.PLAIN, 10));

        // add the name and stereotype to the edge
        super.addTextField(name, AnchorType.Line);
        super.addTextField(stereotype, AnchorType.Line);

        // register EditBoxTrigger to name compartment to allow it editable
        //BUGR-120 double click on edge opens name edit box
        EditBoxTrigger editBoxTrigger = new EditBoxTrigger(name);
        name.addMouseListener(editBoxTrigger);
        addMouseListener(editBoxTrigger);

        
        // load the name, stereotype's information
        notifyGraphEdgeChange();
    }

    /**
     * Getter of name compartment belonging to this edge.
     *
     * @return the text field representing name compartment.
     */
    public TextField getNameCompartment() {
        return name;
    }

    /**
     * Getter of stereotype compartment belonging to this edge.
     *
     * @return the text field representing stereotype compartment.
     */
    public TextField getStereotypeCompartment() {
        return stereotype;
    }

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element. Because all the edges in this
     * component don't react such events, we provide a default implementation here.
     * </p>
     * <p>
     * Always return false, indicating the event can't be consumed in this Edge.
     * </p>
     *
     * @return always false
     * @param event the mouse event
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>
     * Reload diagram interchange information from contained graphEdge.
     * </p>
     *
     * @throws IllegalGraphElementException if graphEdge has bad structure.
     */
    public void notifyGraphEdgeChange() throws IllegalGraphElementException {

        /*
         * BugFix: UML-7166
         */
        // set font for the compartments
        name.setFont(getFont());
        stereotype.setFont(getFont());

        /*
         * BugFix: UML-7168
         */
        // old code
//        // resize and relocate name, stereotype compartments
//        Utils.updateTextFieldSizeLocation(name);
//        Utils.updateTextFieldSizeLocation(stereotype);
//
//        // update name, stereotype compartments' text
//        try {
//            Relationship actorModel =
//                ((Relationship) ((Uml1SemanticModelBridge) super.getGraphEdge().getSemanticModel()).getElement());
//            name.setText(actorModel.getName());
//            stereotype.setText(Utils.getStereotypeText(keywordMetaclass, actorModel.getStereotypes()));
//        } catch (NullPointerException e) {
//            throw new IllegalGraphElementException(getGraphEdge(), "expects a correct semantic model", e);
//        } catch (ClassCastException e) {
//            throw new IllegalGraphElementException(getGraphEdge(), "the element should be instance of Relationship", e);
//        }
        GraphEdge edge = getGraphEdge();
        Utils.checkGraphEdge(this);

        ModelElement element = Utils.getElement(edge);
        stereotype.setText(Utils.getStereotypeText(keywordMetaclass, element.getStereotypes()));
        name.setText(element.getName());

        // resize and relocate name, stereotype compartments
        Utils.updateTextFieldSizeLocation(name);
        Utils.updateTextFieldSizeLocation(stereotype);
    }

    /**
     * <p>
     * Helper function that checks valid for GraphNode instance.
     * </p>
     * <p>
     * the structure should be
     * Uml1SemanticModelBridge.element = UML:Include
     *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *   SimpleSemanticModelElement.typeInfo = "Name"
     * </p>
     * @param graphEdge the GraphEdge instance for check
     * @return the instance of GraphEdge
     * @throws IllegalGraphElementException if the GraphNode is not a valid UseCase node
     */
    private static GraphEdge checkValidGraphEdge(GraphEdge graphEdge) throws IllegalGraphElementException {
        if (graphEdge == null) {
            throw new IllegalArgumentException("The graphNode can not be null.");
        }

        // check if contains stereotype and name compartment.

        if (graphEdge.getContaineds().size() != NUMBER_OF_COMPARTMENTS) {
            throw new IllegalGraphElementException(graphEdge, "does not contain 2 compartment.");
        }

        for (int i = 0; i < NUMBER_OF_COMPARTMENTS; i++) {
            if (!(graphEdge.getContaineds().get(i) instanceof GraphNode)) {
                throw new IllegalGraphElementException(graphEdge, "The contained should be instance of GraphNode");
            }
        }

        // check if it contains enough way points
        if (graphEdge.getWaypoints().size() < 2) {
            throw new IllegalGraphElementException(graphEdge,
                    "The size of way points for the given way edge is less than 2.");
        }

        return graphEdge;
    }
}
