/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Dimension;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;

/**
 * <p>
 * This is a mock extends of BaseNode class. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockBaseNode extends BaseNode {
    /**
     * <p>
     * Indicate whether notifyGraphNodeChange has been called.
     * </p>
     */
    private boolean isGraphNodeChanged = false;

    /**
     * <p>
     * Construct a Base Node.
     * </p>
     *
     * @param graphNode the graphNode corresponding to this Node
     * @param properties the property names mappings(See field document for explanation).
     * @param name the TextField representing the name
     * @param stereotype the TextField representing the stereotype
     * @param namespace the TextField representing the namespace
     * @throws IllegalArgumentException if any argument is null. Or map contains null/empty element
     */
    public MockBaseNode(GraphNode graphNode, Map<String, String> properties, TextField name, TextField stereotype,
            TextField namespace) {
        super(graphNode, properties, name, stereotype, namespace);
    }

    /**
     * <p>
     * Notify the contained graphNode is changed. It is provided for the concrete implementation to update the
     * size/location of this node, and also update the nested compartments.
     * </p>
     * <p>
     * The message parameter is usually used as a reason to tell how the GraphNode is changed. Maybe something like
     * "stereotype is made visible", "name is changed".
     * </p>
     *
     * @param message message telling how the graphNode is changed.
     */
    public void notifyGraphNodeChange(String message) {
        isGraphNodeChanged = true;
    }

    /**
     * <p>
     * Get the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The returned
     * value indicating the preferred size of core shape of this node. This method is provided for the application to
     * set proper size of graph node.
     * </p>
     *
     * @return the preferred size of graph node.
     */
    public Dimension getPreferredGraphNodeSize() {
        return new Dimension();
    }

    /**
     * <p>
     * return the state of <code>isGraphNodeChanged</code>.
     * </p>
     *
     * @return the state of <code>isGraphNodeChanged</code>
     */
    public boolean getIsGraphNodeChanged() {
        return isGraphNodeChanged;
    }

    /**
     * <p>
     * Call the BaseNode#setConnector(Connector).
     * </p>
     *
     * @param connector the Connector
     * @see BaseNode#setConnector(Connector)
     */
    public void setConnector(Connector connector) {
        super.setConnector(connector);
    }
}
