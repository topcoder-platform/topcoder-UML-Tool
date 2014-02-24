/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.umltool.deploy.DiagramType;

/**
 * <p>
 * Tests for adding, removing, and persistence for create message edge.
 * </p>
 * @author ly
 * @version 1.0
 */
public class CreateMessageEdgeTest extends EdgeTest {

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setDiagramType(DiagramType.SEQUENCE);
        super.setStartNodetype(ObjectNode.class);
        super.setEndNodetype(ObjectNode.class);
        super.setType(CreateMessageEdge.class);
        super.setUp();
    }
}
