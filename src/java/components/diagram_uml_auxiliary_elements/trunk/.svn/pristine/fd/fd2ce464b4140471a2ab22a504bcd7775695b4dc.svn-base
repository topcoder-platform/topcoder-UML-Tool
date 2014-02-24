/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeEvent;

/**
 * <p>
 * Accuracy test of <code>TextChangeEvent</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class TextChangeEventAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for tests.
     * </p>
     */
    private TextChangeEvent textChangeEvent;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception
     *
     */
    protected void setUp() throws Exception {
    	ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        PropertyMapping propertyMapping = new PropertyMapping(ConfigHelper.ACC_NAMESPACE);
        GraphNode graphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        graphNode.setSemanticModel(ssme);
        TextElement textElement = new TextElement();
        textElement.setText("FreeTextNode");
        graphNode.addContained(textElement);
        com.topcoder.diagraminterchange.Point position = new com.topcoder.diagraminterchange.Point();
        position.setX(100);
        position.setY(100);
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setHeight(200);
        size.setWidth(200);
        graphNode.setPosition(position);
        graphNode.setSize(size);
        FreeTextNode freeTextNode = new FreeTextNode(graphNode, propertyMapping);
    	textChangeEvent = new TextChangeEvent(freeTextNode, "old", "new");
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
        view.add(freeTextNode);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    	ConfigHelper.clearConfigration();
    	textChangeEvent = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of constructor.
     * </p>
     *
     * @throws Exception
     */
    public void testConstructorAccuracy() throws Exception {
        assertNotNull("Constructed instance should not be null.", textChangeEvent);
    }

    /**
     * <p>
     * Tests accuracy of <code>getOldText()</code>.
     * </p>
     *
     * @throws Exception
     */
    public void testGetOldTextAccuracy() throws Exception {
        assertEquals("value should be getted correctly.", "old", textChangeEvent.getOldText());
    }

    /**
     * <p>
     * Tests TextChangeEvent#getNewText() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the TextChangeEvent#getNewText() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetNewText() throws Exception {
    	assertEquals("value should be getted correctly.", "new", textChangeEvent.getNewText());
    }
}
