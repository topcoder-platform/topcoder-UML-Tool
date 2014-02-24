/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for classCloseTabAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CloseTabActionUnitTests extends TestCase {

    /**
     * The namespace for testing.
     */
    private String namespace1 = "TestofCloseTabAction1";

    /**
     * The namespace for testing.
     */
    private String namespace2 = "TestofCloseTabAction2";

    /**
     * The namespace for testing.
     */
    private String namespace3 = "TestofCloseTabAction3";

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
        UnitTestsHelper.loadConfig("config.xml");
        diagramViewer = new DiagramViewer();
        cta = new CloseTabAction(diagramViewer);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: CloseTabAction(diagramViewer).
     * <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create CloseTabAction instance.", cta);
    }

    /**
     * <p>
     * This is the failure test for constructor:CloseTabAction( DiagramViewer
     * viewer).<br>
     * Failure condition: the viewer is null. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1WithInValidValue() throws Exception {
        try {
            new CloseTabAction(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
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
        UnitTestsHelper.loadConfig("closeTabAction.xml");
        assertNotNull("Failed to create CloseTabAction instance.", new CloseTabAction(namespace1, this.diagramViewer));
        assertNotNull("Failed to create CloseTabAction instance.", new CloseTabAction(namespace2, this.diagramViewer));
        assertNotNull("Failed to create CloseTabAction instance.", new CloseTabAction(namespace3, this.diagramViewer));
    }

    /**
     * <p>
     * This is the failure test for constructor:CloseTabAction(String namespace,
     * DiagramViewer viewer).<br>
     * Failure condition: at least one of the arg is invalid. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidValue() throws Exception {
        UnitTestsHelper.loadConfig("closeTabAction.xml");
        try {
            new CloseTabAction(namespace1, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new CloseTabAction("", this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new CloseTabAction(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new CloseTabAction("      ", this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new CloseTabAction(null, this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the failure test for constructor:CloseTabAction(String namespace,
     * DiagramViewer viewer).<br>
     * Failure condition: the namespace is unknown. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidNamespace() throws Exception {
        try {
            new CloseTabAction("INVALID_NAMESPACE", this.diagramViewer);
            fail("ConfigurationException is excepted.");
        } catch (ConfigurationException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: actionPerformed(ActionEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testActionPerformedAccuracy() throws Exception {
        this.cta.actionPerformed(null);
        this.cta.actionPerformed(new ActionEvent(cta, 0, namespace1));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramViewerAccuracy() throws Exception {
        assertEquals("Fail to get DiagramViewer", this.diagramViewer, this.cta.getDiagramViewer());
    }

}
