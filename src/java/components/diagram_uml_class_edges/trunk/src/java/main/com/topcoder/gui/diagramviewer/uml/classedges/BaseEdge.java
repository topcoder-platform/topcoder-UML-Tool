/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuTrigger;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeSelectionTrigger;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputTrigger;

import java.awt.event.MouseEvent;

/**
 * <p>
 * This class is the base Edge of this component. It is an extension of <code>Edge</code> class served for the purpose
 * of providing all the common functionalities required by Association, Generalization, Abstraction and Dependency
 * edges.
 * </p>
 *
 * <p>
 * There are name compartment and stereotype compartment properties. The objects for these compartments are created in
 * the constructor.
 * </p>
 *
 * <p>
 * This class also adds <code>EditBoxTrigger</code> to name compartment automatically to allow name editing.
 * <code>PopupMenuTrigger</code> and <code>EdgeSelectionTrigger</code> are also registered automatically to edge and
 * name/stereotype compartments to support popup menu and selection for the edge.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public abstract class BaseEdge extends Edge {

    /**
     * <p>
     * Represents the name compartment of this edge.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later, can't be null. Can be accessed by getter. The text/size/location
     * of this <code>TextField</code> will be updated in <code>notifyGraphEdgeChange</code> method.
     * </p>
     */
    private final TextField name;

    /**
     * <p>
     * Represents the stereotype compartment of this edge.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later, can't be null. Can be accessed by getter. The text/size/location
     * of this <code>TextField</code> will be updated in <code>notifyGraphEdgeChange</code> method.
     * </p>
     */
    private final TextField stereotype;

    /**
     * <p>
     * The protected constructor preventing direct instantiation of this class.
     * </p>
     *
     * <p>
     * Please note, the "name" and "stereotype" compartments are created here. These compartments' text is initialized
     * by values from GraphEdge UML Model Element. The all properties, such as visibility, and position should be
     * retrieved from GraphEdge.
     * </p>
     *
     * @param graphEdge
     *            the graphEdge representing this Edge.
     * @param lineStyle
     *            The style of line representing the edge. Actually two types only used: dashed (with dashLength=5,
     *            blankLength=5), and continuous (with dashLength=5, blankLength=0).
     * @param leftEnding
     *            The ending attached to the left end of the edge. Can be null for the open end.
     * @param rightEnding
     *            The ending attached to the right end of the edge. Can be null (for the open edge end).
     *
     * @throws IllegalArgumentException
     *             if graphEdge or lineStyle is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure.
     */
    protected BaseEdge(GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding, EdgeEnding rightEnding)
        throws IllegalGraphElementException {
        super(validateGraphEdge(graphEdge), lineStyle, leftEnding, rightEnding);

        //Register listeners
        PopupMenuTrigger popupMenuTrigger = new PopupMenuTrigger();
        addMouseListener(popupMenuTrigger);
        EdgeSelectionTrigger edgeSelectionTrigger = new EdgeSelectionTrigger(this);
        addMouseListener(edgeSelectionTrigger);
        
        

        //Create the name/stereotype compartments
        int index = 0;
        if (this instanceof AssociationEdge) {
            index = 2;
        }
        name = new TextField((GraphNode) graphEdge.getContaineds().get(index));
        TextInputTrigger textInputTrigger = new TextInputTrigger(name);
        name.addMouseListener(textInputTrigger);
        //BUGR-120 double click on edge opens name edit box
        addMouseListener(textInputTrigger);
        
        stereotype = new TextField((GraphNode) graphEdge.getContaineds().get(index + 1));

        // add the name/stereotype compartments to edge
        super.addTextField(name, AnchorType.Line);
        super.addTextField(stereotype, AnchorType.Line);

        //load the graph edge
        notifyGraphEdgeChange("load the graph edge");
    }

    /**
     * <p>
     * Validates the structure of <code>GraphEdge</code>.
     * The structure should be something like:
     *
     * <pre>
     *  Uml1SemanticModelBridge.element = &lt;UML:Abstraction&gt;
     *    SimpleSemanticModelElement.typeInfo = &quot;DirectedName&quot;
     *      SimpleSemanticModelElement.typeInfo = &quot;Name&quot;
     *    SimpleSemanticModelElement.typeInfo = &quot;StereotypeCompartment&quot;
     * </pre>
     *
     * </p>
     *
     * @param graphEdge
     *            the GraphEdge instance for check
     *
     * @return the instance of GraphEdge
     *
     * @throws IllegalArgumentException
     *             if graphEdge is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure
     */
    private static GraphEdge validateGraphEdge(GraphEdge graphEdge) throws IllegalGraphElementException {
        //Check if graphEdge is null
        Utils.checkObjectNotNull(graphEdge, "graphEdge");

        //NOTE: check of way points is done in Edge#ctor, but it throws IAE :(
        if (graphEdge.getWaypoints().size() < 2) {
            throw new IllegalGraphElementException(graphEdge,
                    "The size of way points for the given way edge is less than 2.");
        }

        return graphEdge;
    }

    /**
     * <p>
     * Getter of the name compartment belonging to this edge.
     * </p>
     *
     * @return the text field representing name compartment.
     */
    public TextField getNameCompartment() {
        return this.name;
    }

    /**
     * <p>
     * Getter of the stereotype compartment belonging to this edge.
     * </p>
     *
     * @return the text field representing stereotype compartment.
     */
    public TextField getStereotypeCompartment() {
        return this.stereotype;
    }

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element. Because all the edges in this
     * component don't react such events, we provide a default implementation here. Always return false, indicating the
     * event can't be consumed in this Edge.
     * </p>
     *
     * @return always false
     *
     * @param event
     *            the mouse event
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>
     * Notify the <code>isVisibile</code> attribute of name compartment has been changed. This is a convenient variant
     * of notifyGraphEdgeChange method.
     * </p>
     *
     * <p>
     * The visual appearance of this edge would change according to the current value of GraphEdge. JComponent edge's
     * boundary may be changed to accommodate the new GraphEdge value.
     * </p>
     */
    public void notifyNameVisibilityChanged() {
        try {
            notifyGraphEdgeChange("name compartment's visibility is changed.");
        } catch (IllegalGraphElementException e) {
            //IllegalGraphElementException should never throw
        }
    }

    /**
     * <p>
     * Notify the <code>isVisibile</code> attribute of stereotype compartment has been changed. This is a convenient
     * variant of <code>notifyGraphEdgeChanged</code> method.
     * </p>
     *
     * <p>
     * The visual appearance of this edge would change according to the current value of GraphEdge. JComponent edge's
     * boundary may be changed to accommodate the new GraphEdge value.
     * </p>
     */
    public void notifyStereotypeVisibilityChanged() {
        try {
            notifyGraphEdgeChange("stereotype compartment's visibility is changed.");
        } catch (IllegalGraphElementException e) {
            //IllegalGraphElementException should never throw
        }
    }

    /**
     * <p>
     * Notify the contained <code>GraphNode</code> is changed. It is provided for the concrete implementation to
     * update the size/location of this node, and also update the nested compartments.
     * </p>
     *
     * <p>
     * The message parameter is usually used as a reason to tell how the <code>GraphNode</code> is changed. Maybe
     * something like "stereotype is made visible", "name is changed".
     * </p>
     *
     * @param message
     *            message telling how the <tt>GraphNode</tt> is changed
     *
     * @throws IllegalArgumentException
     *             if <tt>message</tt> is null
     * @throws IllegalGraphElementException
     *             if the structure of <tt>GraphNode</tt> is invalid
     */
    public abstract void notifyGraphEdgeChange(String message) throws IllegalGraphElementException;

}
