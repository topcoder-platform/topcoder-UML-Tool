/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;


/**
 * <p>
 * Unit test cases for TextChangeEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextChangeEventTests extends TestCase {
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
     * The TextNode instance for helping testing.
     * </p>
     */
    private TextNode textNode;

    /**
     * <p>
     * The String instance for helping testing.
     * </p>
     */
    private String oldText;

    /**
     * <p>
     * The String instance for helping testing.
     * </p>
     */
    private String newText;

    /**
     * <p>
     * The TextChangeEvent instance for helping testing.
     * </p>
     */
    private TextChangeEvent event;

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
        textNode = new FreeTextNode(graphNode, mapping);
        oldText = "oldText";
        newText = "newText";
        event = new TextChangeEvent(textNode, oldText, newText);
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
        textNode = null;
        oldText = null;
        newText = null;
        event = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TextChangeEventTests.class);
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TextChangeEvent instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new TextChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the constructor with empty oldText is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_EmptyOldText() throws Exception {
        event = new TextChangeEvent(textNode, "", newText);
        assertNotNull("Failed to create a new TextChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the constructor with empty newText is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_EmptyNewText() throws Exception {
        event = new TextChangeEvent(textNode, oldText, "");
        assertNotNull("Failed to create a new TextChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the constructor with empty oldText and newText is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_EmptyOldTextAndEmptyNewText() throws Exception {
        event = new TextChangeEvent(textNode, "", "");
        assertNotNull("Failed to create a new TextChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for failure.
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
            new TextChangeEvent(null, oldText, newText);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldText is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullOldText() throws Exception {
        try {
            new TextChangeEvent(textNode, null, newText);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * TextChangeEvent#TextChangeEvent(TextNode source, String oldText, String newText) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newText is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullNewText() throws Exception {
        try {
            new TextChangeEvent(textNode, oldText, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests TextChangeEvent#getOldText() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the TextChangeEvent#getOldText() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetOldText() throws Exception {
        assertTrue("The return value of getOldText() should be String.",
                event.getOldText() instanceof String);
        assertEquals("The return value of newly created TextChangeEvent's getOldText"
                + "should equal with the oldText parameter of constructor.",
                oldText, event.getOldText());
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
        assertTrue("The return value of getNewText() should be String.",
                event.getNewText() instanceof String);
        assertEquals("The return value of newly created TextChangeEvent's getNewText"
                + "should equal with the newText parameter of constructor.",
                newText, event.getNewText());
    }
}
