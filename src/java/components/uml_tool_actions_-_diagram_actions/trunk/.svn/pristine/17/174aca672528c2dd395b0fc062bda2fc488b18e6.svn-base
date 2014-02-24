/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;

/**
 * <p>
 * Unit tests for {@link CreateSequenceDiagramAction}. It only tests constructor.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateSequenceDiagramActionTest extends BaseTestCase {
    /**
     * <p>
     * String representing the name of the Diagram.
     * </p>
     */
    private static final String NAME = "name";

    /**
     * <p>
     * Element instance used for testing.
     * </p>
     */
    private Element owner;

    /**
     * <p>
     * CreateSequenceDiagramAction instance used for testing.
     * </p>
     */
    private CreateSequenceDiagramAction action;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(CreateSequenceDiagramActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        super.setUp();
        owner = new EnumerationLiteralImpl();
        action = new CreateSequenceDiagramAction(owner, NAME);
    }

    /**
     * <p>
     * Tears down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        super.tearDown();
        owner = null;
        action = null;
    }

    /**
     * <p>
     * Tests constructor for 'CreateSequenceDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that CreateSequenceDiagramAction(Element, String) is correct.
     * </p>
     */
    public void testCreateClassDiagramAction() {
        assertNotNull("The CreateSequenceDiagramAction instance should not be null.", action);
        assertEquals("The presentation name is incorrect.",
                "Create SequenceDiagram diagram " + NAME, action.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'CreateSequenceDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that CreateSequenceDiagramAction is a subclass of CreateDiagramAction.
     * </p>
     */
    public void testCreateClassDiagramActionForInheritance() {
        assertTrue("The CreateSequenceDiagramAction instance should be a subclass of CreateDiagramAction.",
                action instanceof CreateDiagramAction);
    }

    /**
     * <p>
     * Tests constructor for 'CreateSequenceDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the owner is null and verifies that CreateSequenceDiagramAction(Element, String)
     * is correct.
     * </p>
     */
    public void testCreateClassDiagramActionWithNullElement() {
        assertNotNull("The CreateSequenceDiagramAction instance should not be null.",
                new CreateSequenceDiagramAction(null, NAME));
    }

    /**
     * <p>
     * Tests constructor for 'CreateSequenceDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name is null and verifies that CreateSequenceDiagramAction(Element, String)
     * is correct.
     * </p>
     */
    public void testCreateClassDiagramActionWithNullName() {
        assertNotNull("The CreateSequenceDiagramAction instance should not be null.",
                new CreateSequenceDiagramAction(owner, null));
    }

    /**
     * <p>
     * Tests constructor for 'CreateSequenceDiagramAction(Element, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name is empty and verifies that CreateSequenceDiagramAction(Element, String) is
     * correct.
     * </p>
     */
    public void testCreateClassDiagramActionWithEmptyName() {
        assertNotNull("The CreateSequenceDiagramAction instance should not be null.",
                new CreateSequenceDiagramAction(owner, "   "));
    }
}
