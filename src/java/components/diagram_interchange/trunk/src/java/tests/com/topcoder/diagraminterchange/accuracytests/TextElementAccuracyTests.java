/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ TextElementAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.TextElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>TextElement</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>TextElement</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class TextElementAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>TextElement</code> used for tests.
     * </p>
     */
    private TextElement test = null;

    /**
     * <p>
     * The array of <code>String</code> used for tests.
     * </p>
     */
    private String [] texts = null;
    /**
     * <p>
     * Test suite of <code>TextElementAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>TextElementAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(TextElementAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new TextElement();
        texts = new String [] {"Top", "Coder", "Dev", "Des"};
    }

    /**
     * <p>
     * Accuracy Test of the <code>TextElement()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new TextElement());

        // get the original value of text to check the constructor
        assertNull("The text expected to be null", test.getText());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setText(String)</code> method and
     * <code>getText()</code>.
     * </p>
     */
    public void testText_Operation() {
        for (String text : texts) {
        // set the text.
            test.setText(text);
            // get the text.
            assertEquals("The text expected to be equal", text,
                test.getText());
        }
        // set the text to null.
        test.setText(null);
        // get the text.
        assertNull("The text expected to be null", test.getText());
    }
}
