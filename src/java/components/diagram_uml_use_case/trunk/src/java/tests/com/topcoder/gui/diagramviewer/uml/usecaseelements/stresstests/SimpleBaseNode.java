/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ SimpleBaseNode.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

import java.awt.Dimension;

import java.util.Map;


/**
 * <p>This is a simple mock class which extends the <code>BaseNode</code> abstract class. It is
 * used for stress test here.</p>
 *
 * @author zmg
 * @version 1.0
 */
@SuppressWarnings("serial")
final class SimpleBaseNode extends BaseNode {
    /**
         * <p>
         * Creates an instance of <code>SimpleBaseNode</code>.
         * </p>
         *
         * @param graphNode the graphNode corresponding to this Node.
         * @param properties the properties mapping.
         * @param name the TextField representing the name.
         * @param stereotype the TextField representing the stereotype.
         * @param namespace the TextField representing the namespace.
         *
         * @throws IllegalArgumentException if any argument is null, or properties contains null/empty element.
         */
    public SimpleBaseNode(GraphNode graphNode, Map<String, String> properties,
        TextField name, TextField stereotype, TextField namespace) {
        super(graphNode, properties, name, stereotype, namespace);
    }

    /**
     * <p>This method will notify the contained graphNode is changed. It is provided for
     * the concrete implementation to update the size/location of this node, and also update the
     * nested compartments.</p>
     *
     * @param message message telling how the graphNode is changed.
     */
    public void notifyGraphNodeChange(String message) {
    }

    /**
     * <p>This method will get the preferred graph node size.</p>
     *
     * @return the preferred size of graph node.
     */
    public Dimension getPreferredGraphNodeSize() {
        return new Dimension();
    }
}
