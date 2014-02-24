/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Dimension;
import java.awt.FontMetrics;

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
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextNode;

/**
 * <p>
 * Accuracy test of <code>TextNode</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class TextNodeAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private TextNode textNode;

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
        textNode = new FreeTextNode(graphNode, propertyMapping);
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
        textNode = null;
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
        assertNotNull("constructed instance should not be null.", textNode);
    }

    /**
     * <p>
     * Tests accuracy of <code>isDisplayText()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testIsDisplayTextAccuracy() throws Exception {
        assertTrue("value should be getted correctly.", textNode.isDisplayText());
        textNode.setDisplayText(false);
        assertFalse("value should be getted correctly.", textNode.isDisplayText());
    }

    /**
     * <p>
     * Tests accuracy of <code>setDisplayText(boolean)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testSetDisplayTextBooleanAccuracy() throws Exception {
        textNode.setDisplayText(true);
        assertTrue("value should be setted correctly.", textNode.isDisplayText());
        textNode.setDisplayText(false);
        assertFalse("value should be setted correctly.", textNode.isDisplayText());
    }

    /**
     * <p>
     * Tests accuracy of <code>getPreferredSize()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetPreferredSizeAccuracy() throws Exception {
        Dimension size = textNode.getPreferredSize();
        assertTrue("preferred size should be getted correctly.", size.getHeight() > 10);
        assertTrue("preferred size should be getted correctly.", size.getWidth() > 10);
    }

    /**
     * <p>
     * Tests accuracy of <code>getMinimumSize()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetMinimumSizeAccuracy() throws Exception {
        Dimension size = textNode.getPreferredSize();
        assertTrue("Minimum size should be getted correctly.", size.getHeight() > 10);
        assertTrue("Minimum size should be getted correctly.", size.getWidth() > 10);
    }

    /**
     * <p>
     * Tests accuracy of <code>measureText(String)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testMeasureTextAccuracy() throws Exception {
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
        textNode = new MockTextNode(graphNode, propertyMapping);

        String text = "text\nText\n";
        FontMetrics fontMetrics = textNode.getFontMetrics(textNode.getFont());
        int W = 0;
        String[] words = text.split("\n");
        for (String word : words) {
            int w = fontMetrics.stringWidth(word);
            if (w > W) {
                W = w;
            }
        }
        assertEquals("The measureText is wrong.", W, ((MockTextNode) textNode).measureText(text).width);
        assertEquals("The measureText is wrong.", words.length * fontMetrics.getHeight(),
            ((MockTextNode) textNode).measureText(text).height);
    }

    /**
     * <p>
     * Tests accuracy of <code>paintText(Graphics, Point)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testPaintTextAccuracy() throws Exception {
        textNode.notifyUpdate();
        JFrame frame = new JFrame();
//        frame.getContentPane().add(textNode);
//        frame.pack();
//        frame.setSize(2000, 2000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();

        Dimension size = new Dimension(500, 500);
        textNode.setSize(size);
        textNode.notifyUpdate();
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(textNode);
        frame.pack();
        frame.setSize(2000, 2000);
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.dispose();

//        size = new Dimension(10, 10);
//        textNode.setSize(size);
//        textNode.setPreferredSize(size);
//        textNode.notifyUpdate();
//        frame.getContentPane().add(textNode);
//        frame.pack();
//        frame.setSize(2000, 2000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();
    }

    /**
     * <p>
     * Tests accuracy of <code>addTextChangeListener(TextChangeListener)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testAddTextChangeListenerTextChangeListenerAccuracy() throws Exception {
        textNode.addTextChangeListener(new MockTextChangeListener());
        assertEquals("listener should be added correctly.", 1, textNode
            .getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Tests accuracy of <code>removeTextChangeListener(TextChangeListener)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testRemoveTextChangeListenerTextChangeListenerAccuracy() throws Exception {
        TextChangeListener listener = new MockTextChangeListener();
        textNode.addTextChangeListener(listener);
        assertEquals("listener should be added correctly.", 1, textNode
            .getListeners(TextChangeListener.class).length);
        textNode.removeTextChangeListener(listener);
        assertEquals("listener should be removed correctly.", 0, textNode
            .getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Tests accuracy of <code>fireTextChange(TextChangeEvent)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testFireTextChangeTextChangeEventAccuracy() throws Exception {
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
        textNode = new MockTextNode(graphNode, propertyMapping);

        MockTextChangeListener listener = new MockTextChangeListener();
        textNode.addTextChangeListener(listener);
        ((MockTextNode) textNode).fireTextChange(new TextChangeEvent(textNode, "a", "b"));
        assertTrue("after text changed flag should be positive.", listener.flag > 0);
    }
}
