/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

/**
 * This class aggregates accuracy tests for SendSignalMessageEdge class.
 *
 * @author ch_music
 * @version 1.0
 */
public class SendSignalMessageEdgeAccuracyTests extends TestCase {

    /**
     * <p>
     * The SendSignalMessageEdge instance used for testing.
     * </p>
     */
    private SendSignalMessageEdge test;

    /**
     * <p>
     * The GraphEdge instance used for testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        graphEdge = AccuracyTestHelper.createGraphEdge();
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(100, 100));
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(200, 100));
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(300, 300));

        Diagram diagram = new Diagram();
        diagram.addContained(graphEdge);

        test = new SendSignalMessageEdge(new LinkImpl(), graphEdge, AccuracyTestHelper
                .createEdgeEndingProperties(), AccuracyTestHelper.createSequenceEdgeProperties());
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testSendSignalMessageEdge() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests paintGraphics method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponent() throws Exception {
        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/asynchronous_message_edge.jpg");
        test.paintComponent(printer.initImage());
        printer.print();
    }
}
