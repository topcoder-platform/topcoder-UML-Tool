/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.IllegalGraphNodeException;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Mock class for <code>BaseNode</code>.
 * </p>
 * @author Achilles_2005
 * @version 1.0
 */
public class MockBaseNode extends BaseNode {

    /**
     * call super constructor.
     */
    public MockBaseNode(GraphNode graphNode, PropertyMapping properties) {
        super(graphNode, properties);
    }

    /**
     * does nothing.
     */
    @Override
    public void notifyUpdate() throws IllegalGraphNodeException {
        // does nothing
    }

    /**
     * exposed as public.
     */
    public boolean consumeEvent(MouseEvent event) {
        return super.consumeEvent(event);
    }

    /**
     * exposed as public.
     */
    public void fireBoundaryChange(BoundaryChangeEvent event) {
        super.fireBoundaryChange(event);
    }
}
