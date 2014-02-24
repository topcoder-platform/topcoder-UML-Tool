/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.failuretests;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.gui.toolbars.elements.ElementSelectedListener;
import com.topcoder.gui.toolbars.elements.SectionPanel;

/**
 * <p>
 * This class aggregates failure tests for SectionPanel class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class SectionPanelFailureTests extends TestCase {

    /**
     * Look and feel class name for unit testing.
     */
    private static final String LOOK_AND_FEEL_CLASS_NAME = UIManager.getCrossPlatformLookAndFeelClassName();

    /**
     * A placeholder for SectionPanel instance.
     */
    private SectionPanel test;

    /**
     * A listener for unit testing purposes.
     */
    private ElementSelectedListener listener;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new SectionPanel("sectionPanel", Color.black, new String[] {"btnName"},
                new ImageIcon[] {new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);

        // Creates a mock ElementSelectedListener instance.
        listener = new ElementSelectedListener() {
            public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            }
        };
    }

    /**
     * Tests SectionPanel 5-argument constructor with null argument. IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_NullArgument1() {
        try {
            new SectionPanel(null, Color.black, new String[] {"btnName"}, new ImageIcon[] {new ImageIcon()},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null argument. IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_NullArgument2() {
        try {
            new SectionPanel("sectionText", null, new String[] {"btnName"}, new ImageIcon[] {new ImageIcon()},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in buttonNames. IllegalArgumentException is
     * expected.
     */
    public void testSectionPanel5Args_NullButtonNamesElement1() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {null}, new ImageIcon[] {new ImageIcon()},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in buttonNames. IllegalArgumentException is
     * expected.
     */
    public void testSectionPanel5Args_NullButtonNamesElement2() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"test", null}, new ImageIcon[] {
                    new ImageIcon(), new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in buttonNames. IllegalArgumentException is
     * expected.
     */
    public void testSectionPanel5Args_NullButtonNamesElement3() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {null, "test"}, new ImageIcon[] {
                    new ImageIcon(), new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with empty string element in buttonNames. IllegalArgumentException
     * is expected.
     */
    public void testSectionPanel5Args_EmptyStrButtonNamesElement1() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {""}, new ImageIcon[] {new ImageIcon()},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with empty string element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with empty string element in buttonNames. IllegalArgumentException
     * is expected.
     */
    public void testSectionPanel5Args_EmptyStrButtonNamesElement2() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"test", ""}, new ImageIcon[] {
                    new ImageIcon(), new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with empty string element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with empty string element in buttonNames. IllegalArgumentException
     * is expected.
     */
    public void testSectionPanel5Args_EmptyStrButtonNamesElement3() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"", "test"}, new ImageIcon[] {
                    new ImageIcon(), new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with empty string element in buttonNames.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in images. IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_NullImagesElement1() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"test"}, new ImageIcon[] {null},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in images. IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_NullImagesElement2() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"test", "test"}, new ImageIcon[] {
                    new ImageIcon(), null}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with null element in images. IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_NullImagesElement3() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"test", "test"}, new ImageIcon[] {null,
                    new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with null element in images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with unequal array lengths for buttonNames and images.
     * IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_UnequalArrayLen1() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"btnName1", "btnName2"},
                    new ImageIcon[] {new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with unequal array length for buttonNames and images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with unequal array lengths for buttonNames and images.
     * IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_UnequalArrayLen2() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"btnName1"}, new ImageIcon[] {
                    new ImageIcon(), new ImageIcon()}, LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with unequal array length for buttonNames and images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with unequal array lengths for buttonNames and images.
     * IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_UnequalArrayLen3() {
        try {
            new SectionPanel("sectionText", Color.black, new String[0], new ImageIcon[] {new ImageIcon()},
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with unequal array length for buttonNames and images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests SectionPanel 5-argument constructor with unequal array lengths for buttonNames and images.
     * IllegalArgumentException is expected.
     */
    public void testSectionPanel5Args_UnequalArrayLen4() {
        try {
            new SectionPanel("sectionText", Color.black, new String[] {"btnName1"}, new ImageIcon[0],
                    LOOK_AND_FEEL_CLASS_NAME);
            fail("Did not throw IllegalArgumentException with unequal array length for buttonNames and images.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests unselectButton method with null argument. IllegalArgumentException is expected.
     */
    public void testUnselectButton_NullArgument() {
        try {
            test.unselectButton(null);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests unselectButton method with empty string argument. IllegalArgumentException is expected.
     */
    public void testUnselectButton_EmptyStrArgument() {
        try {
            test.unselectButton("");
            fail("Did not throw IllegalArgumentException with empty string argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addElementSelectedListener method with null argument. IllegalArgumentException is expected.
     */
    public void testAddElementSelectedListener_NullArgument1() {
        try {
            test.addElementSelectedListener(null, listener);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addElementSelectedListener method with null argument. IllegalArgumentException is expected.
     */
    public void testAddElementSelectedListener_NullArgument2() {
        try {
            test.addElementSelectedListener("btnName", null);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addElementSelectedListener method with empty string argument. IllegalArgumentException is expected.
     */
    public void testAddElementSelectedListener_EmptyStrArgument1() {
        try {
            test.addElementSelectedListener("", listener);
            fail("Did not throw IllegalArgumentException with empty string argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests removeElementSelectedListener method with null argument. IllegalArgumentException is expected.
     */
    public void testRemoveElementSelectedListener_NullArgument1() {
        try {
            test.removeElementSelectedListener(null, listener);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests removeElementSelectedListener method with null argument. IllegalArgumentException is expected.
     */
    public void testRemoveElementSelectedListener_NullArgument2() {
        try {
            test.removeElementSelectedListener("btnName", null);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests removeElementSelectedListener method with empty string argument. IllegalArgumentException is expected.
     */
    public void testRemoveElementSelectedListener_EmptyStrArgument1() {
        try {
            test.removeElementSelectedListener("", listener);
            fail("Did not throw IllegalArgumentException with empty string argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }

    /**
     * Tests addListenerForAllButtons method with null argument. IllegalArgumentException is expected.
     */
    public void testAddListenerForAllButtons_NullArgument() {
        try {
            test.addListenerForAllButtons(null);
            fail("Did not throw IllegalArgumentException with null argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception must not contain null message.", e.getMessage());
            assertTrue("Exception must contain a message.", e.getMessage().length() > 0);
        }
    }
}
