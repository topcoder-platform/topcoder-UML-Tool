/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Point;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;

/**
 * <p>
 * This class is the concrete Edge of this component. It is an extension of {@link BaseEdge} class. The required
 * information is retrieved from the <code>Association</code> class from the UML Model and from the
 * <code>GraphEdge</code> associated with it. The special active edge endings will be assigned to the edge. The class
 * uses a continuous line, an open ending and the several different other endings: simple arrow, empty diamond, filled
 * diamond, empty diamond with simple arrow, filled diamond with simple arrow.
 * </p>
 *
 * <p>
 * This class implement creating of the concrete line style for the edge and the concrete edge endings (with
 * compartments). The drawing of the edge is implemented in the parent Edge class (in the Diagram Edges component). The
 * edge endings (and their compartments) painted automatically as child graphical components.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class AssociationEdge extends BaseEdge {

    /** Represent the default dash length. */
    private static final int DEFAULT_DASH_LENGTH = 5;

    /** Represent the default blank length. */
    private static final int DEFAULT_BLANK_LENGTH = 0;

    /**
     * <p>
     * Constructor of the concrete edge instance.
     * </p>
     *
     * @param graphEdge
     *            the graphEdge representing this Edge.
     *
     * @throws IllegalArgumentException
     *             If graphEdge is null
     * @throws IllegalGraphElementException
     *             if any problem with retrieving data from related graphEdge occurs
     */
    public AssociationEdge(GraphEdge graphEdge) throws IllegalGraphElementException {
        super(graphEdge, new LineStyle(DEFAULT_DASH_LENGTH, DEFAULT_BLANK_LENGTH), createEdgeEnding(graphEdge, true,
                null, null), createEdgeEnding(graphEdge, false, null, null));
    }

    /**
     * <p>
     * Create left/right edge ending.
     * </p>
     * @param graphEdge
     *            the GraphEdge instance
     * @param isLeft
     *            the flag indicating whether left or right edge ending should be created
     * @return the child of ActiveEdgeEnding
     * @throws IllegalArgumentException
     *             If graphEdge is null
     * @throws IllegalGraphElementException
     *             if the GraphEdge is not valid
     */
    private static EdgeEnding createEdgeEnding(GraphEdge graphEdge, boolean isLeft, ActiveEdgeEnding oldLeftEnding,
            ActiveEdgeEnding oldRightEnding) throws IllegalGraphElementException {
        Utils.checkObjectNotNull(graphEdge, "graphEdge");

        try {
            GraphNode leftAssociationEnd = (GraphNode) graphEdge.getContaineds().get(0);
            GraphNode rightAssociationEnd = (GraphNode) graphEdge.getContaineds().get(1);

            // Create concrete ActiveEdgeEnding
            /*
             * BugFix: UML-9875 Ending point and angle should be set.
             */
            // old code
            // return isLeft ? createConcreteActiveEdgeEnding(leftEnd, rightEnd) : createConcreteActiveEdgeEnding(
            // rightEnd, leftEnd);
            /*
             * BugFix: UML-9940 Creates compartments with anchor type
             */
            // old code
            // EdgeEnding edgeEnding = isLeft ? createConcreteActiveEdgeEnding(leftEnd, rightEnd) :
            // createConcreteActiveEdgeEnding(
            // rightEnd, leftEnd);
            EdgeEnding edgeEnding = isLeft ? createConcreteActiveEdgeEnding(leftAssociationEnd, rightAssociationEnd,
                    AnchorType.LeftEnding, oldLeftEnding) : createConcreteActiveEdgeEnding(rightAssociationEnd,
                    leftAssociationEnd, AnchorType.RightEnding, oldRightEnding);

            int index = isLeft ? 0 : graphEdge.getWaypoints().size() - 1;
            Point endingPoint = new Point();
            endingPoint.x = (int) graphEdge.getWaypoints().get(index).getX();
            endingPoint.y = (int) graphEdge.getWaypoints().get(index).getY();
            edgeEnding.setEndingPoint(endingPoint);

            edgeEnding.setAngle(calculateAngle(graphEdge, isLeft));

            return edgeEnding;

        } catch (NullPointerException e) {
            throw new IllegalGraphElementException(graphEdge, "GraphEdge is not valid", e);
        } catch (ClassCastException e) {
            throw new IllegalGraphElementException(graphEdge, "the element should be instance of Association", e);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalGraphElementException(graphEdge, "GraphEdge should contain at least 2 way points", e);
        }
    }

    /**
     * <p>
     * Calculates EdgeEnding's angle.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     * @return the angle of EdgeEnding
     */
    private static double calculateAngle(GraphEdge graphEdge, boolean isLeft) {
        int size = graphEdge.countWaypoints();
        int start, end;
        if (isLeft) {
            start = 0;
            end = 1;
        } else {
            start = size - 2;
            end = size - 1;
        }
        double x1 = graphEdge.getWaypoints().get(start).getX();
        double y1 = graphEdge.getWaypoints().get(start).getY();
        double x2 = graphEdge.getWaypoints().get(end).getX();
        double y2 = graphEdge.getWaypoints().get(end).getY();
        double angle = Math.atan2(y2 - y1, x2 - x1);
        if (angle < 0) {
            angle += Math.PI * 2;
        }
        if (isLeft) {
            angle -= Math.PI;
        }
        return angle;
    }

    /**
     * <p>
     * Create concrete ActiveEdgeEnding object.
     * </p>
     * <p>
     * The edge ending creation rules:
     * <ol>
     * <li>if the end is not 'navigable', or both ends of edge are 'navigable' - use NoneArrow.</li>
     * <li>if the edge ending is 'navigable' and the other end is not - use DirectedAssociation.</li>
     * <li>if the end is 'aggregation' and is not 'navigable' - use Aggregation.</li>
     * <li>if the end is 'aggregation' and is 'navigable' - use AggregationBiDirectional.</li>
     * <li>if the end is 'composition' and is not 'navigable' - use Composition.</li>
     * <li>if the end is 'composition' and is 'navigable' - use CompositionBiDirectional.</li>
     * </ol>
     * </p>
     * @param leftEnd
     *            the left AssociationEnd object
     * @param rightEnd
     *            the right AssociationEnd object
     * @param type
     *            the anchor type for compartments
     * @return the concrete ActiveEdgeEnding object
     */
    private static EdgeEnding createConcreteActiveEdgeEnding(GraphNode leftEndGraphNode, GraphNode rightEndGraphNode,
            AnchorType type, ActiveEdgeEnding oldEdgeEnding) {
        AssociationEnd leftEnd = (AssociationEnd) ((Uml1SemanticModelBridge) leftEndGraphNode.getSemanticModel())
                .getElement();
        AssociationEnd rightEnd = (AssociationEnd) ((Uml1SemanticModelBridge) rightEndGraphNode.getSemanticModel())
                .getElement();

        TextField nameCompartment = null;
        TextField multiplicityCompartment = null;
        if (oldEdgeEnding != null) {
            nameCompartment = oldEdgeEnding.getNameCompartment();
            multiplicityCompartment = oldEdgeEnding.getMultiplicityCompartment();
        } else {
            GraphNode nameGraphNode = (GraphNode) leftEndGraphNode.getContaineds().get(0);
            GraphNode multiplicityGraphNode = (GraphNode) leftEndGraphNode.getContaineds().get(2);

            nameCompartment = new TextField(nameGraphNode, type);
            multiplicityCompartment = new TextField(multiplicityGraphNode, type);

            if (nameGraphNode.getPosition() != null) {
                nameCompartment.setLocation((int) nameGraphNode.getPosition().getX(), (int) nameGraphNode.getPosition()
                        .getY());
            }
            if (multiplicityGraphNode.getPosition() != null) {
                multiplicityCompartment.setLocation((int) multiplicityGraphNode.getPosition().getX(),
                        (int) multiplicityGraphNode.getPosition().getY());
            }
        }

        // Create concrete ActiveEdgeEnding
        if (leftEnd.getAggregation() == AggregationKind.AGGREGATE) {
            /*
             * BugFix: UML-9889 Return directional edge ending only when given left end is navigable but right end is
             * not navigable.
             */
            // old code
            // if (!leftEnd.isNavigable()) {
            // return new Aggregation(nameCompartment, multiplicityCompartment);
            // }
            // return new AggregationBiDirectional(nameCompartment, multiplicityCompartment);
            if (!rightEnd.isNavigable() && leftEnd.isNavigable()) {
                return new AggregationBiDirectional(nameCompartment, multiplicityCompartment);
            }
            return new Aggregation(nameCompartment, multiplicityCompartment);
        }

        if (leftEnd.getAggregation() == AggregationKind.COMPOSITE) {
            /*
             * BugFix: UML-9889 Return directional edge ending only when given left end is navigable but right end is
             * not navigable.
             */
            // old code
            // if (!leftEnd.isNavigable()) {
            // return new Composition(nameCompartment, multiplicityCompartment);
            // }
            // return new CompositionBiDirectional(nameCompartment, multiplicityCompartment);
            if (!rightEnd.isNavigable() && leftEnd.isNavigable()) {
                return new CompositionBiDirectional(nameCompartment, multiplicityCompartment);
            }
            return new Composition(nameCompartment, multiplicityCompartment);
        }

        if (!leftEnd.isNavigable() || (leftEnd.isNavigable() && rightEnd.isNavigable())) {
            return new NoArrow(nameCompartment, multiplicityCompartment);
        }

        if (leftEnd.isNavigable() && !rightEnd.isNavigable()) {
            return new DirectedAssociation(nameCompartment, multiplicityCompartment);
        }

        return null;
    }

    /**
     * <p>
     * Reload diagram interchange information from contained <code>GraphEdge</code>.
     * </p>
     * @param message
     *            message telling how the <tt>GraphNode</tt> is changed
     * @throws IllegalArgumentException
     *             if <tt>message</tt> is null
     * @throws IllegalGraphElementException
     *             if the structure of <tt>GraphNode</tt> is invalid
     */
    public void notifyGraphEdgeChange(String message) throws IllegalGraphElementException {
        Utils.checkObjectNotNull(message, "message");

        // NOTE: we should update the text firstly
        try {
            ActiveEdgeEnding leftEnding = (ActiveEdgeEnding) getLeftEnding();
            ActiveEdgeEnding rightEnding = (ActiveEdgeEnding) getRightEnding();

            /*
             * BugFix: UML-9868 Change edge endings according to different association ends.
             */
            leftEnding = (ActiveEdgeEnding) createEdgeEnding(getGraphEdge(), true, leftEnding, rightEnding);
            rightEnding = (ActiveEdgeEnding) createEdgeEnding(getGraphEdge(), false, leftEnding, rightEnding);
            leftEnding.setSize(getSize());
            rightEnding.setSize(getSize());

            setLeftEnding(leftEnding);
            setRightEnding(rightEnding);

            // Retrieve the Association element
            Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) this.getGraphEdge()
                    .getSemanticModel();
            Association association = (Association) semanticModelBridge.getElement();

            // Update name/stereotype compartments' text
            getNameCompartment().setText(association.getName());
            getStereotypeCompartment().setText(Utils.retrieveStereotypeText(association.getStereotypes()));

            addAssociationEndTexts((ActiveEdgeEnding) getLeftEnding());
            addAssociationEndTexts((ActiveEdgeEnding) getRightEnding());

            // Update name/multiplicity compartments' text of left/right active edge ending
            List<AssociationEnd> connectiones = association.getConnections();
            Utils.updateActiveEdgeEnding((ActiveEdgeEnding) getLeftEnding(), connectiones.get(0));
            Utils.updateActiveEdgeEnding((ActiveEdgeEnding) getRightEnding(), connectiones.get(1));

        } catch (NullPointerException e) {
            throw new IllegalGraphElementException(getGraphEdge(), "expects a correct semantic model", e);
        } catch (ClassCastException e) {
            throw new IllegalGraphElementException(getGraphEdge(), "the element should be instance of Association", e);
        }

        // Resize and relocate name, stereotype compartments
        Utils.updateTextFieldSizeLocationVisibility(getNameCompartment());
        Utils.updateTextFieldSizeLocationVisibility(getStereotypeCompartment());

    }

    /**
     * <p>
     * Adds the name compartment and multiplicity compartment for given edge ending.
     * </p>
     * @param edgeEnding
     *            the edge ending whose compartments should be added
     */
    private void addAssociationEndTexts(ActiveEdgeEnding edgeEnding) {
        TextField nameCompartment = edgeEnding.getNameCompartment();
        TextField multiplicityCompartment = edgeEnding.getMultiplicityCompartment();

        addTextField(nameCompartment);
        addTextField(multiplicityCompartment);
    }

    /**
     * <p>
     * Adds given text field to this association edge. If the text field has been added, do nothing.
     * </p>
     * @param textField
     *            the text field to add
     */
    private void addTextField(TextField textField) {
        GraphNode graphNode = textField.getGraphNode();
        if (super.getTextField(graphNode) == null) {
            super.addTextField(textField, textField.getAnchorType());
        }
    }
}
