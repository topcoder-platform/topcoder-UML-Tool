/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.TextInputBoxKeyHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for TextInputBoxKeyHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextInputBoxKeyHandlerUnitTests extends TestCase {

    /**
     * TextInputBoxKeyHandler instance for testing.
     */
    private TextInputBoxKeyHandler handler;

    /**
     * KeyEvent instance for testing.
     */
    private KeyEvent event;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        this.handler = new TextInputBoxKeyHandler();
        this.event = new KeyEvent(new TextInputBox(), 0, 0, 0, KeyEvent.VK_ESCAPE, (char) 0);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: TextInputBoxKeyHandler(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create TextInputBoxKeyHandler instance.", this.handler);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: keyTyped(KeyEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testKeyType() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        DiagramViewer viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        Diagram diagram2 = new Diagram();
        diagram2.setName("Test");
        diagram2.setSize(dimension);
        diagram2.setPosition(point);
        diagram.setContainer(diagram2);
        viewer.openDiagramView(diagram);
        JTextArea area = new JTextArea();
        TextInputBox box = viewer.getTextInputBox();
        box.add(area);
        box.setNewLineAccepted(true);
        this.event = new KeyEvent(area, 0, 0, KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_ENTER, (char) 0);
        this.handler.keyTyped(event);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: keyPressed(KeyEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testPressed() throws Exception {
        JTextArea area = new JTextArea();
        TextInputBox box = new TextInputBox();
        box.add(area);
        this.event = new KeyEvent(area, 0, 0, 0, KeyEvent.VK_ESCAPE, (char) 0);
        this.handler.keyPressed(event);
    }

}
