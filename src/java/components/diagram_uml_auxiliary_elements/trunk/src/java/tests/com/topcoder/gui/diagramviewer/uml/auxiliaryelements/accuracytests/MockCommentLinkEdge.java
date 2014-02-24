/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;

/**
 * <p>
 * Mock class for <code>CommentLinkEdge</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class MockCommentLinkEdge extends CommentLinkEdge {

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public MockCommentLinkEdge(GraphEdge graphEdge) {
        super(graphEdge);
    }

    /**
     * <p>
     * Expose consumeEvent(MouseEvent) method as public for test purpose.
     * </p>
     */
    public boolean consumeEvent(MouseEvent event) {
        return super.consumeEvent(event);
    }
}
