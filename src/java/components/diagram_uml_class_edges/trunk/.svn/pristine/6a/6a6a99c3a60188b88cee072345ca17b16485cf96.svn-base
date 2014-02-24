/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;

/**
 * <p>
 * Defines helper methods used in tests of this component.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class UnitTestsHelper {

    /**
     * <p>
     * Creates a new instance of <code>UnitTestsHelper</code> class.
     * This private constructor prevents the creation of a new instance.
     * </p>
     */
    private UnitTestsHelper() {
    }

    /**
     * <p>
     * This method creates a default <code>GraphEdge</code> for <code>AbstractionEdge</code>.
     * </p>
     *
     * @return the default GraphEdge for AbstractionEdge
     */
    public static GraphEdge createGraphEdgeForAbstractionEdge() {
        GraphEdge graphEdge = new GraphEdge();

        //Create child nodes: name and stereotype compartments
        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(getPoint(20, 20 * i));
            childNode.setSize(getDimension(110, 22));
            graphEdge.addContained(childNode);
        }

        //Create way points
        graphEdge.addWaypoint(getPoint(100, 100));
        graphEdge.addWaypoint(getPoint(250, 200));

        //Create a Abstraction element
        Abstraction abstraction = new AbstractionImpl();

        //Set name
        abstraction.setName("abstraction");

        //Set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        abstraction.addStereotype(stereotype);

        //Create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(abstraction);
        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a default <code>GraphEdge</code> for <code>DependencyEdge</code>.
     * </p>
     *
     * @return the default GraphEdge for DependencyEdge
     */
    public static GraphEdge createGraphEdgeForDependencyEdge() {
        GraphEdge graphEdge = new GraphEdge();

        //Create child nodes: name and stereotype compartments
        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(getPoint(20, 20 * i));
            childNode.setSize(getDimension(110, 22));
            graphEdge.addContained(childNode);
        }

        //Create way points
        graphEdge.addWaypoint(getPoint(100, 100));
        graphEdge.addWaypoint(getPoint(250, 200));

        //Create a Dependency element
        Dependency dependency = new DependencyImpl();

        //Set name
        dependency.setName("dependency");

        //Set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        dependency.addStereotype(stereotype);

        //Create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(dependency);
        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a default <code>GraphEdge</code> for <code>GeneralizationEdge</code>.
     * </p>
     *
     * @return the default GraphEdge for GeneralizationEdge
     */
    public static GraphEdge createGraphEdgeForGeneralizationEdge() {
        GraphEdge graphEdge = new GraphEdge();

        //Create child nodes: name and stereotype compartments
        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(getPoint(20, 20 * i));
            childNode.setSize(getDimension(110, 22));
            graphEdge.addContained(childNode);
        }

        //Create way points
        graphEdge.addWaypoint(getPoint(100, 100));
        graphEdge.addWaypoint(getPoint(250, 200));

        //Create a Generalization element
        Generalization generalization = new GeneralizationImpl();

        //Set name
        generalization.setName("generalization");

        //Set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        generalization.addStereotype(stereotype);

        //Create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(generalization);
        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a default <code>GraphEdge</code> for <code>AssociationEdge</code>.
     * </p>
     *
     * @return the default GraphEdge for AssociationEdge
     */
    public static GraphEdge createGraphEdgeForAssociationEdge() {
        GraphEdge graphEdge = new GraphEdge();

        //Create child nodes: name and stereotype compartments
        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(getPoint(20, 20 * i));
            childNode.setSize(getDimension(110, 22));
            graphEdge.addContained(childNode);
        }

        //Create way points
        graphEdge.addWaypoint(getPoint(100, 100));
        graphEdge.addWaypoint(getPoint(250, 200));

        //Create a Association element
        Association association = new AssociationImpl();

        //Set name
        association.setName("no name");

        //Set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        association.addStereotype(stereotype);

        //Add AssociationEnd
        AssociationEnd leftEnd = new AssociationEndImpl();
        leftEnd.setAggregation(AggregationKind.COMPOSITE);
        leftEnd.setNavigable(false);
        association.addConnection(leftEnd);
        AssociationEnd rightEnd = new AssociationEndImpl();
        rightEnd.setNavigable(false);
        association.addConnection(rightEnd);

        //Create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(association);
        graphEdge.setSemanticModel(semanticModel);

        GraphNode leftEndGraphNode = createGraphNodeForAssociationEnd(leftEnd);

        //Create graph nodes for right association end
        GraphNode rightEndGraphNode = createGraphNodeForAssociationEnd(rightEnd);

        // Add two graph nodes for association ends to graph edge
        graphEdge.addContained(0, leftEndGraphNode);
        graphEdge.addContained(1, rightEndGraphNode);

        return graphEdge;
    }

    /**
     * <p>
     * Creates the graph node for association end.
     * </p>
     *
     * @param associationEnd
     *            the association end to create graph node
     * @return the graph node for given association end
     */
    private static GraphNode createGraphNodeForAssociationEnd(AssociationEnd associationEnd) {
        Uml1SemanticModelBridge semanticModel;
        semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(associationEnd);
        GraphNode graphNode = new GraphNode();
        graphNode.setSemanticModel(semanticModel);

        // Add the graph nodes for name compartment and multiplicity compartment
        GraphNode name = new GraphNode();
        GraphNode visibility = new GraphNode();
        GraphNode multiplicity = new GraphNode();

        graphNode.addContained(name);
        graphNode.addContained(visibility);
        graphNode.addContained(multiplicity);

        return graphNode;
    }

    /**
     * <p>
     * Gets an instance of <code>Point</code>.
     * </p>
     *
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     *
     * @return the instance of <code>Point</code> with the given coordinates
     */
    static Point getPoint(double x, double y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

    /**
     * <p>
     * Gets an instance of <code>Dimension</code>.
     * </p>
     *
     * @param width the width of the point.
     * @param height the height of the dimension.
     *
     * @return the instance of <code>Dimension</code> with the given height and width.
     */
    static Dimension getDimension(double width, double height) {
        Dimension dimension = new Dimension();
        dimension.setHeight(height);
        dimension.setWidth(width);
        return dimension;
    }

    /**
     * <p>
     * Create a <code>DirectedAssociation</code> instance.
     * </p>
     *
     * @return a DirectedAssociation instance
     */
    public static DirectedAssociation createDirectedAssociation() {
        // create a DirectedAssociation
        TextField name = new TextField(new GraphNode());
        name.setText("directed association");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1..n");
        DirectedAssociation association = new DirectedAssociation(name, multiplicity);

        // set angle and ending point
        association.setAngle(0);
        association.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        association.setComponentPopupMenu(createPopupMenu());

        return association;
    }

    /**
     * <p>
     * Create a <code>NoArrow</code> instance.
     * </p>
     *
     * @return a NoArrow instance
     */
    public static NoArrow createNoArrow() {
        // create a NoArrow
        TextField name = new TextField(new GraphNode());
        name.setText("no arrow");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1");
        NoArrow edgeEnding = new NoArrow(name, multiplicity);

        // set angle and ending point
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        edgeEnding.setComponentPopupMenu(createPopupMenu());

        return edgeEnding;
    }

    /**
     * <p>
     * Create a <code>Aggregation</code> instance.
     * </p>
     *
     * @return a Aggregation instance
     */
    public static Aggregation createAggregation() {
        // create a Aggregation
        TextField name = new TextField(new GraphNode());
        name.setText("aggregation");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1");
        Aggregation edgeEnding = new Aggregation(name, multiplicity);

        // set angle and ending point
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        edgeEnding.setComponentPopupMenu(createPopupMenu());

        return edgeEnding;
    }

    /**
     * <p>
     * Create a <code>AggregationBiDirectional</code> instance.
     * </p>
     *
     * @return a AggregationBiDirectional instance
     */
    public static AggregationBiDirectional createAggregationBiDirectional() {
        // create a AggregationBiDirectional
        TextField name = new TextField(new GraphNode());
        name.setText("aggregation bi directional");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1");
        AggregationBiDirectional edgeEnding = new AggregationBiDirectional(name, multiplicity);

        // set angle and ending point
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        edgeEnding.setComponentPopupMenu(createPopupMenu());

        return edgeEnding;
    }

    /**
     * <p>
     * Create a <code>Composition</code> instance.
     * </p>
     *
     * @return a Composition instance
     */
    public static Composition createComposition() {
        // create a Composition
        TextField name = new TextField(new GraphNode());
        name.setText("composition");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1");
        Composition edgeEnding = new Composition(name, multiplicity);

        // set angle and ending point
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        edgeEnding.setComponentPopupMenu(createPopupMenu());

        return edgeEnding;
    }

    /**
     * <p>
     * Create a <code>CompositionBiDirectional</code> instance.
     * </p>
     *
     * @return a CompositionBiDirectional instance
     */
    public static CompositionBiDirectional createCompositionBiDirectional() {
        // create a CompositionBiDirectional
        TextField name = new TextField(new GraphNode());
        name.setText("composition bi directional");
        TextField multiplicity = new TextField(new GraphNode());
        multiplicity.setText("1");
        CompositionBiDirectional edgeEnding = new CompositionBiDirectional(name, multiplicity);

        // set angle and ending point
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new java.awt.Point(200, 100));

        // add popup menu
        edgeEnding.setComponentPopupMenu(createPopupMenu());

        return edgeEnding;
    }

    /**
     * <p>
     * Create a <code>JPopupMenu</code> instance.
     * </p>
     *
     * @return a JPopupMenu instance
     */
    public static JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JLabel("Help"));
        popupMenu.addSeparator();
        popupMenu.add(new JLabel("About"));
        return popupMenu;
    }

    /**
     * <p>
     * Create a <code>TextField</code> instance with specified text.
     * </p>
     *
     * @param text the text of text field
     * @return a TextField instance
     */
    public static TextField createTextFiled(String text) {
        TextField textField = new TextField(new GraphNode());
        textField.setText(text);
        return textField;
    }
}
