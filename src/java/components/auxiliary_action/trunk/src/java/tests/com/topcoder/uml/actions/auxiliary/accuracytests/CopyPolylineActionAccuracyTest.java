/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.diagram.CopyPolylineAction;

/**
 * <p>
 * Set of accuracy tests for CopyPolylineAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyPolylineActionAccuracyTest extends TestCase {

    /**
     * Instance of GraphNode for testing.
     */
    private GraphEdge polylineGraphEdge;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CopyPolylineAction for testing.
     */
    private CopyPolylineAction copyPolylineAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        polylineGraphEdge = AccuracyTestsHelper.getPolylineGraphEdge();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyPolylineAction = new CopyPolylineAction(polylineGraphEdge, clipboard);
    }

    /**
     * Constructor under test CopyPolylineAction(GraphNode, Clipboard). Accuracy
     * testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyPolylineAction() throws Exception {
        CopyPolylineAction currentCopyPolylineAction = new CopyPolylineAction(polylineGraphEdge, clipboard);
        assertSame("nodes must be the same", polylineGraphEdge, AccuracyTestsHelper.getFieldValue(
            currentCopyPolylineAction, "polylineGraphEdge"));
        assertSame("clipboads must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCopyPolylineAction, "clipboard"));
    }

    /**
     * Method under test CopyPolylineAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        copyPolylineAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.POLYLINE);
        assertTrue("polyline graph edge was not successfully copied", object instanceof GraphEdge);
        assertFalse("copied polyline graph edge was not cloned", ((GraphEdge) object) == polylineGraphEdge);
    }
}