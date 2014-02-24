/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JTextArea;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.event.TextInputBoxKeyHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>TextInputBoxKeyHandler</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class TextInputBoxKeyHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>TextInputBoxKeyHandler</c> used for test.
     */
    private TextInputBoxKeyHandler handler;

    /**
     * Represent the instance of KeyEvent instance for testing.
     */
    private KeyEvent event;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception if any error occurs when set up
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfig(CONFIG);
        handler = new TextInputBoxKeyHandler();
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     *
     * @throws Exception if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>TextInputBoxKeyHandler</code>.
     * The instance of <code>TextInputBoxKeyHandler</code> should be created
     * successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of TextInputBoxKeyHandler should be created", new TextInputBoxKeyHandler());
    }

    /**
     * <p>
     * Accuracy test for the method <code>KeyTyped</code>.
     * </p>
     */
    public void testKeyTypedAccuracy() {
        try {
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
            event = new KeyEvent(area, 0, 0, KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_ENTER, (char) 0);

            handler.keyTyped(event);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>KeyReleased</code>.
     * </p>
     */
    public void testKeyPressedAccuracy() {
        try {
            JTextArea area = new JTextArea();
            TextInputBox box = new TextInputBox();
            box.add(area);
            this.event = new KeyEvent(area, 0, 0, 0, KeyEvent.VK_ESCAPE, (char) 0);
            handler.keyPressed(event);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
