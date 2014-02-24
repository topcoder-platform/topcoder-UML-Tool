/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * Represents an concrete implementation of <code>NodeContainer</code> class. It is only used in demo.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultContainer extends NodeContainer {

    /**
     * The default constructor.
     */
    public DefaultContainer() {
        super(new GraphNode(), new Point(), new Rectangle(), new ArrayList<SelectionCornerType>());
    }

    /**
     * Simply return false.
     *
     * @param event
     *            ignore
     * @return always false
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }
}
