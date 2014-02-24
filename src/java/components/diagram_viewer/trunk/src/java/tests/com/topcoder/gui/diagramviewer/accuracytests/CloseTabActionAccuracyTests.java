/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.accuracytests;

import com.topcoder.gui.diagramviewer.CloseTabAction;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for classCloseTabAction.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class CloseTabActionAccuracyTests extends TestCase {
    /**
     * The DiagramViewer for testing.
     */
    private DiagramViewer diagramViewer;

    /**
     * CloseTabAction instance for testing.
     */
    private CloseTabAction cta;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);
        diagramViewer = new DiagramViewer();
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DIR + "closeTabAction.xml");
        cta = new CloseTabAction(diagramViewer);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: CloseTabAction(String
     * namespace, DiagramViewer viewer). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create CloseTabAction instance.", new CloseTabAction("name.optional", diagramViewer));
    }

    /**
     * <p>
     * This is the accuracy test for constructor: CloseTabAction(String
     * namespace, DiagramViewer viewer). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2() throws Exception {
        assertNotNull("Failed to create CloseTabAction instance.", new CloseTabAction("icon.optional", diagramViewer));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: actionPerformed(ActionEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testActionPerformedAccuracy() throws Exception {
        cta.actionPerformed(null);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramViewerAccuracy() throws Exception {
        assertEquals("Fail to get DiagramViewer", diagramViewer, cta.getDiagramViewer());
    }
}
