package com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event;

import java.awt.Dimension;
import java.awt.Point;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.FailureTestHelper;

import junit.framework.TestCase;

/**
 * Failure tests for TextChangedEvent class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class TextChangedEventFailureTests extends TestCase {
    /**
     * The TextField instance for testing.
     */
    private TextField textField;

    /**
     * Sets up the test environment. The test instance is created.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        GraphNode graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false,
                false);
        textField = new TextField(graphNode);
    }

    /**
     * Tests the constructor TextChangedEvent(TextField, String, String) with null node, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNode() throws Exception {
        try {
            new TextChangedEvent(null, "oldText", "newText");
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(TextField, Rectangle, Rectangle) with null oldText, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullOldText() throws Exception {
        try {
            new TextChangedEvent(textField, null, "newText");
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BoundaryChangedEvent(TextField, Rectangle, Rectangle) with null newText, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNewText() throws Exception {
        try {
            new TextChangedEvent(textField, "oldText", null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
