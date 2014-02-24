/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Dimension;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Accuracy test of <code>FreeTextNode</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class FreeTextNodeAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private FreeTextNode freeTextNode;

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
     *             exception to JUnit.
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
        freeTextNode = new FreeTextNode(graphNode, propertyMapping);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        ConfigHelper.clearConfigration();
        freeTextNode = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of constructor.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConstructorAccuracy() throws Exception {
        assertNotNull("constructed instance should not be null.", freeTextNode);
        assertNotNull("instance should have MouseListeners.", freeTextNode.getMouseListeners());
        assertNotNull("textElement value should be setted.", freeTextNode.getTextElement());
    }

    /**
     * <p>
     * Tests accuracy of <code>getTextElement()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetTextElementAccuracy() throws Exception {
        assertEquals("value should be getted correctly", "FreeTextNode", freeTextNode.getTextElement()
            .getText());
    }

    /**
     * <p>
     * Tests accuracy of <code>getPreferredSize(String)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetPreferredSizeStringAccuracy() throws Exception {
        String text = "a";
        Dimension size = freeTextNode.getPreferredSize(text);
        assertTrue("preferred size should be getted correctly.", size.getHeight() > 10);
        assertTrue("preferred size should be getted correctly.", size.getWidth() > 10);
    }

    /**
     * <p>
     * Tests accuracy of <code>notifyUpdate()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testNotifyUpdateAccuracy() throws Exception {
        Dimension oldSize = freeTextNode.getSize();
        assertEquals("height before notify should be 0.", 0.0, oldSize.getHeight());
        assertEquals("width before notify should be 0.", 0.0, oldSize.getWidth());

        freeTextNode.notifyUpdate();
        Dimension newSize = freeTextNode.getSize();
        assertEquals("size should be setted correctly.", 210.0, newSize.getHeight());
        assertEquals("size should be setted correctly.", 210.0, newSize.getWidth());

        freeTextNode.notifyUpdate();
        freeTextNode.notifyUpdate();
        freeTextNode.notifyUpdate();
        newSize = freeTextNode.getSize();
        assertEquals("size should be setted correctly.", 210.0, newSize.getHeight());
        assertEquals("size should be setted correctly.", 210.0, newSize.getWidth());
    }

    /**
     * <p>
     * Tests accuracy of <code>getText()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetTextAccuracy() throws Exception {
        assertEquals("value should be getted correctly", "FreeTextNode", freeTextNode.getText());
    }

    /**
     * <p>
     * Tests accuracy of <code>contains(int, int)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testContainsIntIntAccuracy() throws Exception {
        freeTextNode.notifyUpdate();
        assertTrue("commentNode should contain point (101, 101).", freeTextNode.contains(101, 101));
        assertFalse("commentNode should not contain point (1000, 1000).", freeTextNode.contains(1000, 1000));
    }

    /**
     * <p>
     * Tests accuracy of <code>paintComponent(Graphics)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testPaintComponent() throws Exception {
        freeTextNode.notifyUpdate();
        JFrame frame = new JFrame();
//        frame.getContentPane().add(freeTextNode);
//        frame.pack();
//        frame.setSize(2000, 2000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();

        Dimension size = new Dimension(500, 500);
        freeTextNode.setSize(size);
        freeTextNode.notifyUpdate();
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(freeTextNode);
        frame.pack();
        frame.setSize(2000, 2000);
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.dispose();

//        size = new Dimension(10, 10);
//        freeTextNode.setSize(size);
//        freeTextNode.setPreferredSize(size);
//        freeTextNode.notifyUpdate();
//        frame.getContentPane().add(freeTextNode);
//        frame.pack();
//        frame.setSize(2000, 2000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();
    }
}
