/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Helper class for the Diagram Elements Add Actions component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Util {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg
     *            the argument to check
     * @param name
     *            the name of the argument to check
     *
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Extract the graph element that has "DelimitedSection" semantic model type information under the given graph
     * element.
     * </p>
     *
     * <p>
     * Note, the given graph element should have "AttributeCompartment" or "OperationCompartment" semantic model
     * type information but it is not checked here.
     * </p>
     *
     * @param attributeCompartment
     *            the graph element has "AttributeCompartment" or "OperationCompartment" semantic model type
     *            information
     *
     * @return the graph element that has "DelimitedSection" semantic model type information under the given graph
     *         element
     *
     * @throws ActionExecutionException
     *             if the desired "DelimitedSection" graph element can not be found
     */
    public static GraphElement getDelimitedSectionGraphElement(GraphElement attributeCompartment)
        throws ActionExecutionException {
        Util.checkNull(attributeCompartment, "attributeCompartment");

        List<DiagramElement> diagramElements = attributeCompartment.getContaineds();

        if (diagramElements.size() == 0) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        DiagramElement diagramElement = diagramElements.get(0);

        if (diagramElement == null) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        if (!(diagramElement instanceof GraphElement)) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        GraphElement graphElement = (GraphElement) diagramElement;

        SemanticModelBridge bridge = graphElement.getSemanticModel();
        if (bridge == null) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        if (!(bridge instanceof SimpleSemanticModelElement)) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        if (!("DelimitedSection".equals(((SimpleSemanticModelElement) bridge).getTypeInfo()))) {
            throw new ActionExecutionException("The DelimitedSection graph element is missing.");
        }

        return graphElement;
    }

    /**
     * <p>
     * Clone the graph node.
     * </p>
     *
     * @param node
     *            the graph node to clone
     * @return the cloned graph node
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws ElementCloneException
     *             if the clone operation fails.
     */
    public static GraphNode cloneGraphNode(GraphNode node) throws ElementCloneException {
        // Clone it
        GraphNode clone = (GraphNode) cloneGraphElement(node);
        // Set the size
        clone.setSize(node.getSize());
        return clone;
    }

    /**
     * <p>
     * Clone the graph edge.
     * </p>
     *
     * @param edge
     *            the graph edge to clone
     * @return the cloned graph edge.
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws ElementCloneException
     *             if the clone operation fails.
     */
    public static GraphEdge cloneGraphEdge(GraphEdge edge) throws ElementCloneException {
        // Clone it
        GraphEdge clone = (GraphEdge) cloneGraphElement(edge);
        // Clone anchors
        for (GraphConnector gc : edge.getAnchors()) {
            clone.addAnchor(gc);
        }
        // Clone waypoints
        for (Point p : edge.getWaypoints()) {
            clone.addWaypoint(p);
        }
        return clone;
    }

    /**
     * <p>
     * Clone the <code>GraphElement</code>.
     * </p>
     *
     * @param graphElement
     *            the graph element to clone
     * @return the cloned graph element
     * @throws IllegalArgumentException
     *             if the argument is null
     * @throws ElementCloneException
     *             if the clone operation fails.
     */
    private static GraphElement cloneGraphElement(GraphElement graphElement) throws ElementCloneException {
        if (graphElement == null) {
            throw new IllegalArgumentException("graphElement cannot be null!");
        }
        GraphElement clone;
        try {
            clone = graphElement.getClass().newInstance();
        } catch (IllegalArgumentException e) {
            throw new ElementCloneException("IllegalArgumentException occurs while instantiating class "
                + graphElement.getClass() + " using default constructor.", e);
        } catch (SecurityException e) {
            throw new ElementCloneException("SecurityException occurs while instantiating class "
                + graphElement.getClass() + " using default constructor.", e);
        } catch (InstantiationException e) {
            throw new ElementCloneException("InstantiationException occurs while instantiating class "
                + graphElement.getClass() + " using default constructor.", e);
        } catch (IllegalAccessException e) {
            throw new ElementCloneException("IllegalAccessException occurs while instantiating class "
                + graphElement.getClass() + " using default constructor.", e);
        }
        /*
         * for (GraphConnector gc : graphElement.getAnchorages()) { clone.addAnchorage(gc); }
         */
        for (DiagramElement de : graphElement.getContaineds()) {
            clone.addContained(de);
        }
        for (DiagramLink dl : graphElement.getLinks()) {
            clone.addLink(dl);
        }
        clone.setPosition(graphElement.getPosition());
        for (Property p : graphElement.getProperties()) {
            clone.addProperty(cloneProperty(p));
        }
        for (Reference r : graphElement.getReferences()) {
            clone.addReference(r);
        }
        clone.setSemanticModel(graphElement.getSemanticModel());
        clone.setVisible(graphElement.isVisible());
        return clone;
    }

    /**
     * <p>
     * Clone the <code>Property</code>.
     * </p>
     *
     * @param property
     *            the property to clone
     * @return the cloned property
     */
    private static Property cloneProperty(Property property) {
        Property cloneProperty = new Property();
        cloneProperty.setKey(property.getKey());
        cloneProperty.setValue(property.getValue());
        return cloneProperty;
    }

}
