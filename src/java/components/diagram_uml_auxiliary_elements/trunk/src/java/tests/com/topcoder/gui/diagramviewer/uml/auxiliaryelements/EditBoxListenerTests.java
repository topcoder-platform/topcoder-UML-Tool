/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;

import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * Unit test cases for EditBoxListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListenerTests extends TestCase {
    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The FreeTextNode instance for helping testing.
     * </p>
     */
    private FreeTextNode node;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The SimpleSemanticModelElement instance for helping testing.
     * </p>
     */
    private SimpleSemanticModelElement ssme;

    /**
     * <p>
     * The TextElement instance for helping testing.
     * </p>
     */
    private TextElement textElement;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The TextInputBox instance for helping testing.
     * </p>
     */
    private TextInputBox textInputBox;

    /**
     * <p>
     * The TextInputEvent instance for helping testing.
     * </p>
     */
    private TextInputEvent textInputEvent;

    /**
     * <p>
     * The EditBoxListener instance for helping testing.
     * </p>
     */
    private EditBoxListener listener;

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
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo(FREE_TEXT);
        graphNode.setSemanticModel(ssme);
        textElement = new TextElement();
        textElement.setText("oldText");
        graphNode.addContained(textElement);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        node = new FreeTextNode(graphNode, mapping);
        textInputBox = new TextInputBox();
        textInputEvent = new TextInputEvent(textInputBox, "textInputEvent");
        listener = new EditBoxListener(node);
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
        view.add(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        textElement = null;
        ssme = null;
        node = null;
        textInputBox = null;
        textInputEvent = null;
        listener = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EditBoxListenerTests.class);
    }

    /**
     * <p>
     * Tests constructor EditBoxListener#EditBoxListener(TextNode textNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created EditBoxListener instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new EditBoxListener instance.", listener);
        assertTrue("A EditBoxListener instance should be also a TextInputListener instance.",
                listener instanceof TextInputListener);
    }

    /**
     * <p>
     * Tests constructor EditBoxListener#EditBoxListener(TextNode textNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when textNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullTextNode() throws Exception {
        try {
            new EditBoxListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests EditBoxListener#textEntered(TextInputEvent e) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EditBoxListener#textEntered(TextInputEvent e) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextEntered() throws Exception {
        listener.textEntered(textInputEvent);
        assertEquals(
                "The EditBoxListener#textEntered should remove this listener from corresponding TextInputBox.",
                textInputBox.getListeners(TextInputListener.class).length, 0);
    }

    /**
     * <p>
     * Tests EditBoxListener#textCancelled(TextInputEvent e) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EditBoxListener#textCancelled(TextInputEvent e) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextCancelled() throws Exception {
        listener.textCancelled(textInputEvent);
        assertEquals(
                "The EditBoxListener#textCancelled should remove this listener from corresponding TextInputBox.",
                textInputBox.getListeners(TextInputListener.class).length, 0);
    }
}
