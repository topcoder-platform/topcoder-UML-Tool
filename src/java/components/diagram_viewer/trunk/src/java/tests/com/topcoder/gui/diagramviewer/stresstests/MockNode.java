/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * Mock class of com.topcoder.gui.diagramviewer.elements.Node. Exposes the protected methods.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public class MockNode extends Node {

    /**
     * Constructor of MockNode.
     * 
     * @param node A com.topcoder.diagraminterchange.GraphNode instance.
     * @param pt A Point instance.
     * @param rect A Rectangle instance.
     * @param coll A Collection&lt;SelectionCornerType&gt; instance.
     */
    public MockNode(GraphNode node, Point pt, Rectangle rect, Collection<SelectionCornerType> coll) {
        super(node, pt, rect, coll);
    }

    /**
     * Dummy consumeEvent.
     */
    protected boolean consumeEvent(MouseEvent arg0) {
        return false;
    }
}
