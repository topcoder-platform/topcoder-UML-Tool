/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for ZoomAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomActionUnitTests extends TestCase {

    /**
     * The namespace for testing.
     */
    private String namespace1 = "ZoomAction1";

    /**
     * The namespace for testing.
     */
    private String namespace2 = "ZoomAction2";

    /**
     * The namespace for testing.
     */
    private String namespace3 = "ZoomAction3";

    /**
     * The DiagramViewer for testing.
     */
    private DiagramViewer diagramViewer;

    /**
     * ZoomAction instance for testing.
     */
    private ZoomAction za;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        // loads the valid configuration
        UnitTestsHelper.loadConfig("config.xml");
        diagramViewer = new DiagramViewer();
        UnitTestsHelper.loadConfig("zoomAction.xml");
        za = new ZoomAction(diagramViewer);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomAction(diagramViewer).
     * <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create ZoomAction instance.", za);
    }

    /**
     * <p>
     * This is the failure test for constructor:ZoomAction( DiagramViewer
     * viewer).<br>
     * Failure condition: the viewer is null. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1WithInValidValue() throws Exception {
        try {
            new ZoomAction(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomAction(String namespace,
     * DiagramViewer viewer). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2() throws Exception {
        za = new ZoomAction(namespace1, this.diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), -10.0);

        za = new ZoomAction(namespace2, this.diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), 36.0);

        za = new ZoomAction(namespace3, this.diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), 2.0);

    }

    /**
     * <p>
     * This is the failure test for constructor:ZoomAction(String namespace,
     * DiagramViewer viewer).<br>
     * Failure condition: at least one of the arg is invalid. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidValue() throws Exception {
        UnitTestsHelper.loadConfig("ZoomAction.xml");
        try {
            new ZoomAction(namespace1, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomAction("", this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomAction(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomAction("      ", this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new ZoomAction(null, this.diagramViewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {

            // pass.
        }

    }

    /**
     * <p>
     * This is the failure test for constructor:ZoomAction(String namespace,
     * DiagramViewer viewer).<br>
     * Failure condition: the namespace is unknown. <br>
     * Expected: ConfigurationException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2WithInValidNamespace() throws Exception {
        try {
            new ZoomAction("INVALID_NAMESPACE", this.diagramViewer);
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
        Diagram diagram = new Diagram();

        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        diagram.setName("Test");
        this.diagramViewer.setTabShortenedTitleMaxLength(4);
        this.diagramViewer.setTabTitleDisplayedInFullVersion(false);
        this.diagramViewer.openDiagramView(diagram);
        this.za.actionPerformed(null);

        this.za.actionPerformed(new ActionEvent(za, 0, namespace1));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setIncrement(int increment).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetIncrementAccuracy() throws Exception {
        za.setIncrement(1000);
        assertEquals("Fail to call Method:  setIncrement()", 1000.0, za.getIncrement());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getIncrement().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetIncrementAccuracy() throws Exception {
        assertEquals("Fail to call Method:  getIncrement()", 0.0, za.getIncrement());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramViewerAccuracy() throws Exception {
        assertEquals("Fail to call Method:  getDiagramViewer().", this.diagramViewer, za.getDiagramViewer());
    }

}
