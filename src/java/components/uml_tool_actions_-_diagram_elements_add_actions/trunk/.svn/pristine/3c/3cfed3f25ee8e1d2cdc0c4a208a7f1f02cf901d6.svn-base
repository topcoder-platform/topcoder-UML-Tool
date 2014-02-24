/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CompartmentExtractorFactory.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CompartmentExtractorFactoryTests extends TestCase {
    /**
     * <p>
     * CompartmentExtractorFactory instance for testing.
     * </p>
     */
    private CompartmentExtractorFactory factory;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        factory = new CompartmentExtractorFactory();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        factory = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CompartmentExtractorFactoryTests.class);
    }

    /**
     * <p>
     * Tests ctor CompartmentExtractorFactory#CompartmentExtractorFactory() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CompartmentExtractorFactory instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CompartmentExtractorFactory instance.", factory);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Package and expects DefaultNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForPackage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Package, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Package.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Package.",
            extractor instanceof DefaultNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Package and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForPackage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Package, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Interface and expects ClassifierCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForInterface() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Interface, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Interface.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Interface.",
            extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Interface and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForInterface_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Interface, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Class and expects ClassifierCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForClass() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Class, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Class.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Class.",
            extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Class and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForClass_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Class, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Exception and expects ClassifierCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForException() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Exception, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Exception.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Exception.",
            extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Exception and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForException_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Exception, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Enumeration and expects ClassifierCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForEnumeration() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Enumeration, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Enumeration.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Enumeration.",
            extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Enumeration and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForEnumeration_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Enumeration, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Association and expects AssociationCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForAssociation() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Association, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Association.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Association.",
            extractor instanceof AssociationCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Association and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForAssociation_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Association, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Generalization and
     * expects GeneralizationCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForGeneralization() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Generalization, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Generalization.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Generalization.",
            extractor instanceof GeneralizationCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Generalization and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForGeneralization_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Generalization, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Abstraction and expects GeneralizationCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForAbstraction() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Abstraction, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Abstraction.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Abstraction.",
            extractor instanceof GeneralizationCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Abstraction and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForAbstraction_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Abstraction, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Dependency and expects GeneralizationCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForDependency() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Dependency, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Dependency.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Dependency.",
            extractor instanceof GeneralizationCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Dependency and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForDependency_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Dependency, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Subsystem and expects DefaultNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForSubsystem() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Subsystem, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Subsystem.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Subsystem.",
            extractor instanceof DefaultNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Subsystem and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForSubsystem_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Subsystem, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Actor and expects DefaultNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForActor() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Actor, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Actor.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Actor.",
            extractor instanceof DefaultNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Actor and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForActor_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Actor, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is UseCase and expects DefaultNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForUseCase() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.UseCase, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for UseCase.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for UseCase.",
            extractor instanceof DefaultNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is UseCase and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForUseCase_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.UseCase, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Include and expects DefaultEdgeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForInclude() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Include, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Include.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Include.",
            extractor instanceof DefaultEdgeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Include and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForInclude_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Include, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Extend and expects DefaultEdgeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForExtend() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Extend, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Extend.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Extend.",
            extractor instanceof DefaultEdgeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Extend and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForExtend_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Extend, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Object and expects ObjectCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForObject() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Object, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for Object.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Object.",
            extractor instanceof ObjectCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Object and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForObject_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Object, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SynchronousMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForSynchronousMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(
            ObjectType.SynchronousMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for SynchronousMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for SynchronousMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(SynchronousMessageType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SynchronousMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForSynchronousMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.SynchronousMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is AsynchronousMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForAsynchronousMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(
            ObjectType.AsynchronousMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for AsynchronousMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for AsynchronousMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is AsynchronousMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForAsynchronousMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.AsynchronousMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is CreateMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForCreateMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.CreateMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for CreateMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for CreateMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is CreateMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForCreateMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.CreateMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SendSignalMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForSendSignalMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(
            ObjectType.SendSignalMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for SendSignalMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for SendSignalMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SendSignalMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForSendSignalMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.SendSignalMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is DestroyMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForDestroyMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.DestroyMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for DestroyMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for DestroyMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is DestroyMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForDestroyMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.DestroyMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ReturnMessage and expects MessageCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForReturnMessage() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.ReturnMessage, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for ReturnMessage.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for ReturnMessage.",
            extractor instanceof MessageCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ReturnMessage and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForReturnMessage_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.ReturnMessage, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is InitialNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForInitialNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.InitialNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for InitialNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for InitialNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is InitialNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForInitialNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.InitialNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ForkNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForForkNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.ForkNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for ForkNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for ForkNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ForkNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForForkNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.ForkNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is JoinNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForJoinNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.JoinNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for JoinNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for JoinNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is JoinNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForJoinNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.JoinNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is DecisionNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForDecisionNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.DecisionNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for DecisionNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for DecisionNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is DecisionNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForDecisionNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.DecisionNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is MergeNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForMergeNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.MergeNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for MergeNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for MergeNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is MergeNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForMergeNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.MergeNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is FlowFinalNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForFlowFinalNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.FlowFinalNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for FlowFinalNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for FlowFinalNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is FlowFinalNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForFlowFinalNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.FlowFinalNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is FinalNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForFinalNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.FinalNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for FinalNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for FinalNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is FinalNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForFinalNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.FinalNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ObjectFlowNode and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForObjectFlowNode() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.ObjectFlowNode, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for ObjectFlowNode.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for ObjectFlowNode.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ObjectFlowNode and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForObjectFlowNode_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.ObjectFlowNode, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ActionState and expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForActionState() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.ActionState, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for ActionState.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for ActionState.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is ActionState and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForActionState_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.ActionState, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SendSignalAction and
     * expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForSendSignalAction() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(
            ObjectType.SendSignalAction, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for SendSignalAction.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for SendSignalAction.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is SendSignalAction and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForSendSignalAction_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.SendSignalAction, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is AcceptEventAction and
     * expects ActivityNodeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForAcceptEventAction() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(
            ObjectType.AcceptEventAction, new GraphNode());

        assertNotNull("Failed to create a CompartmentExtractor instance for AcceptEventAction.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for AcceptEventAction.",
            extractor instanceof ActivityNodeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is AcceptEventAction and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForAcceptEventAction_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.AcceptEventAction, new GraphEdge());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Transition and expects DefaultEdgeCompartmentExtractor is created.
     * </p>
     */
    public void testCreateCompartmentExtractorForTransition() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Transition, new GraphEdge());

        assertNotNull("Failed to create a CompartmentExtractor instance for Transition.", extractor);
        assertTrue("Failed to create a CompartmentExtractor instance for Transition.",
            extractor instanceof DefaultEdgeCompartmentExtractor);
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the object type is Transition and the given diagram element type is wrong
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractorForTransition_InvalidElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Transition, new GraphNode());

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }





    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when type is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractor_NullType() {
        try {
            factory.createCompartmentExtractor(null, new GraphNode());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CompartmentExtractorFactory#createCompartmentExtractor(ObjectType,DiagramElement) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCreateCompartmentExtractor_NullElement() {
        try {
            factory.createCompartmentExtractor(ObjectType.Abstraction, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}