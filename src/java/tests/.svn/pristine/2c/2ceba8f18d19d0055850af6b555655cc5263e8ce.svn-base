/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TextField;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>SequenceEdgeNameChangedHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SequenceEdgeNameChangedHandlerTest extends TestCase {
    /** An instance of <code>SequenceEdgeNameChangedHandler</code> for testing. */
    private SequenceEdgeNameChangedHandler handler;

    /** An instance of <code>SequenceEdge</code> for testing. */
    private SequenceEdge sequenceEdge;

    /** Graph node of the name text filed in sequence edge. */
    private GraphNode nameGraphNode;

    /** The corresponding model element in sequence edge. */
    private Link link;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        link = new LinkImpl();
        link.setName("");

        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(0, DeployHelper.createPoint(0.0, 0.0));
        graphEdge.addWaypoint(1, DeployHelper.createPoint(100.0, 100.0));
        DeployHelper.addContained(graphEdge, new GraphNode());
        nameGraphNode = new GraphNode();
        DeployHelper.addContained(graphEdge, nameGraphNode);
        DeployHelper.setElement(graphEdge, link);

        EnumMap<SequenceEdgePropertyType, String> edgeProperties = new EnumMap<SequenceEdgePropertyType, String>(
                SequenceEdgePropertyType.class);
        edgeProperties.put(SequenceEdgePropertyType.STROKE_COLOR, "STROKE_COLOR");
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);
        endingProperties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "STROKE_COLOR");
        sequenceEdge = new CreateMessageEdge(link, graphEdge, endingProperties, edgeProperties);

        handler = new SequenceEdgeNameChangedHandler(TestHelper.getMainFrame());
    }

    /**
     * Test method for 'SequenceEdgeNameChangedHandler.SequenceEdgeNameChangedHandler(MainFrame)' The instance should be
     * created successfully.
     */
    public void testSequenceEdgeNameChangedHandler_Accuracy() {
        assertNotNull("Test method for 'SequenceEdgeNameChangedHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'SequenceEdgeNameChangedHandler.SequenceEdgeNameChangedHandler(MainFrame)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testSequenceEdgeNameChangedHandler_Null() {
        try {
            new SequenceEdgeNameChangedHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'SequenceEdgeNameChangedHandler.textChange(TextChangeEvent)'
     */
    public void testTextChange_Accuracy() {
        String oldText = "oldText";
        String newText = "newText";
        TextChangedEvent event = new TextChangedEvent((TextField) sequenceEdge.getTextField(nameGraphNode), oldText,
                newText);
        handler.textChanged(event);

        assertEquals("Name of the link in sequence edge should equals the new text", link.getName(), newText);
    }

    /**
     * Test method for 'SequenceEdgeNameChangedHandler.textChange(TextChangeEvent)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testTextChange_Null() {
        try {
            handler.textChanged(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
        sequenceEdge = null;
        nameGraphNode = null;
        link = null;
    }

}
