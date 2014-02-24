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
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.EditBoxListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Accuracy test of <code>EditBoxListener</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class EditBoxListenerAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private EditBoxListener editBoxListener;

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
        ConfigHelper.clearConfigration();
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        GraphNode graphNode = new GraphNode();
        SimpleSemanticModelElement simpleSemanticModelElement = new SimpleSemanticModelElement();
        simpleSemanticModelElement.setTypeInfo("FreeText");
        graphNode.setSemanticModel(simpleSemanticModelElement);
        graphNode.setPosition(new Point());
        graphNode.setSize(new Dimension());
        TextElement textElement = new TextElement();
        textElement.setText("textElement");
        graphNode.addContained(textElement);
        FreeTextNode textNode = new FreeTextNode(graphNode, new PropertyMapping(ConfigHelper.ACC_NAMESPACE));
        editBoxListener = new EditBoxListener(textNode);
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
        view.add(textNode);
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
        editBoxListener = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of constructor.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("constructed instance should not be null.", editBoxListener);
    }

    /**
     * <p>
     * Tests accuracy of <code>textEntered(TextInputEvent)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testTextEnteredTextInputEventAccuracy() throws Exception {
        TextInputBox textInputBox = new TextInputBox();
        TextInputEvent textInputEvent = new TextInputEvent(textInputBox, "textInputEvent");
        editBoxListener.textEntered(textInputEvent);
        assertEquals("this should be removed from textInputBox.", 0, textInputBox
            .getListeners(TextInputListener.class).length);
    }

    /**
     * <p>
     * Tests accuracy of <code>textCancelled(TextInputEvent)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testTextCancelledTextInputEventAccuracy() throws Exception {
        TextInputBox textInputBox = new TextInputBox();
        TextInputEvent textInputEvent = new TextInputEvent(textInputBox, "textInputEvent");
        editBoxListener.textCancelled(textInputEvent);
        assertEquals("this should be removed from textInputBox.", 0, textInputBox
            .getListeners(TextInputListener.class).length);
    }
}
