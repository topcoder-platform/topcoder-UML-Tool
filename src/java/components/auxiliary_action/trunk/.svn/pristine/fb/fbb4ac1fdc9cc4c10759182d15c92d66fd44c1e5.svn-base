/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;

/**
 * <p>
 * This package private helper class provides several utility methods
 * for action implementations defined in package <code>com.topcoder.uml.actions.auxiliary.diagram</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
class Helper {
    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";
    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private Helper() {
    }
    /**
     * <p>
     * Validate if the freeTextGraphNode is valid for actions that relates to
     * Free Text graph nodes.
     * </p>
     * @param freeTextGraphNode the freeTextGraphNode to validate
     * @throws IllegalArgumentException If freeTextGraphNode is null, or the freeTextGraphNode doesn't
     *      contain a semanticModel attribute (<code>SimpleSemanticModelElement</code> object) with typeInfo
     *      attribute equal to "FreeText", or it doesn't contain a <code>TextElement</code> object in its
     *      contained attribute.
     */
    static void validateGraphNodeForFreeTextAction(GraphNode freeTextGraphNode) {
        if (freeTextGraphNode == null) {
            throw new IllegalArgumentException("freeTextGraphNode cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = freeTextGraphNode.getSemanticModel();
        if (!(smb instanceof SimpleSemanticModelElement)) {
            throw new IllegalArgumentException(
                    "SemanticModel of the freeTextGraphNode should be SimpleSemanticModelElement!");
        }
        SimpleSemanticModelElement ssme = (SimpleSemanticModelElement) smb;
        if (!FREE_TEXT.equals(ssme.getTypeInfo())) {
            throw new IllegalArgumentException("typeInfo of freeTextGraphNode's SemanticModel should be '"
                    + FREE_TEXT + "'!");
        }
        // Validate if the freeTextGraphNode contains a TextElement
        boolean valid = false;
        for (DiagramElement de : freeTextGraphNode.getContaineds()) {
            if (de instanceof TextElement) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("freeTextGraphNode should contain a TextElement!");
        }
    }
    /**
     * <p>
     * Validate if the polylineGraphEdge is valid for actions that relates to
     * Polyline graph nodes.
     * </p>
     * @param polylineGraphEdge The polylineGraphEdge to validate
     * @throws IllegalArgumentException if polylineGraphEdge is null, or
     *      the polylineGraphEdge doesn't contain a <code>Polyline</code> object in its contained
     *      attribute.
     */
    static void validateGraphEdgeForPolylineAction(GraphEdge polylineGraphEdge) {
        if (polylineGraphEdge == null) {
            throw new IllegalArgumentException("polylineGraphEdge cannot be null!");
        }
        // Validate if polylineGraphEdge contains a Polyline
        boolean valid = false;
        for (DiagramElement de : polylineGraphEdge.getContaineds()) {
            if (de instanceof Polyline) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("polylineGraphEdge should contain a Polyline!");
        }
    }
}
