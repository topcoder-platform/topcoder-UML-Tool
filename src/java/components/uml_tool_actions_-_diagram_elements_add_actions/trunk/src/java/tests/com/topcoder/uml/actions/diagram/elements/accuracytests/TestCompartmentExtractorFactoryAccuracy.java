/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractorFactory;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.GeneralizationCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.MessageCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ObjectType;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>CompartmentExtractorFactory </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestCompartmentExtractorFactoryAccuracy extends TestCase {

    /**
     * Represents the CompartmentExtractorFactory instance for testing.
     */
    private static CompartmentExtractorFactory factory = new CompartmentExtractorFactory();

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_1() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Interface, new GraphNode());
        assertNotNull(extractor);
        assertTrue(extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_2() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Package, new GraphNode());
        assertNotNull(extractor);
        assertTrue(extractor instanceof DefaultNodeCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_3() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Class, new GraphNode());
        assertNotNull(extractor);
        assertTrue(extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_4() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Exception, new GraphNode());
        assertNotNull(extractor);
        assertTrue(extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_5() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Enumeration, new GraphNode());
        assertNotNull(extractor);
        assertTrue(extractor instanceof ClassifierCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_6() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Association, new GraphEdge());
        assertNotNull(extractor);
        assertTrue(extractor instanceof AssociationCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_7() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Generalization,
                new GraphEdge());
        assertNotNull(extractor);
        assertTrue(extractor instanceof GeneralizationCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_8() {
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Abstraction, new GraphEdge());
        assertNotNull(extractor);
        assertTrue(extractor instanceof GeneralizationCompartmentExtractor);
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_9() {
        ObjectType[] types = new ObjectType[] { ObjectType.Subsystem, ObjectType.Actor, ObjectType.UseCase };

        for (int i = 0; i < types.length; i++) {
            CompartmentExtractor extractor = factory.createCompartmentExtractor(types[i], new GraphNode());
            assertNotNull(extractor);
            assertTrue(extractor instanceof DefaultNodeCompartmentExtractor);
        }
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_10() {
        ObjectType[] types = new ObjectType[] { ObjectType.Include, ObjectType.Extend, ObjectType.Transition };

        for (int i = 0; i < types.length; i++) {
            CompartmentExtractor extractor = factory.createCompartmentExtractor(types[i], new GraphEdge());
            assertNotNull(extractor);
            assertTrue(extractor instanceof DefaultEdgeCompartmentExtractor);
        }
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_11() {
        ObjectType[] types = new ObjectType[] { ObjectType.SynchronousMessage, ObjectType.AsynchronousMessage,
                ObjectType.CreateMessage, ObjectType.SendSignalMessage, ObjectType.DestroyMessage,
                ObjectType.ReturnMessage };

        for (int i = 0; i < types.length; i++) {
            CompartmentExtractor extractor = factory.createCompartmentExtractor(types[i], new GraphNode());
            assertNotNull(extractor);
            assertTrue(extractor instanceof MessageCompartmentExtractor);
        }
    }

    /**
     * Test its function.
     *
     */
    public void testCreateCompartmentExtractor_12() {
        ObjectType[] types = new ObjectType[] { ObjectType.InitialNode, ObjectType.ForkNode, ObjectType.JoinNode,
                ObjectType.DecisionNode, ObjectType.MergeNode, ObjectType.FlowFinalNode, ObjectType.FinalNode,
                ObjectType.ObjectFlowNode, ObjectType.ActionState, ObjectType.SendSignalAction,
                ObjectType.AcceptEventAction };

        for (int i = 0; i < types.length; i++) {
            CompartmentExtractor extractor = factory.createCompartmentExtractor(types[i], new GraphNode());
            assertNotNull(extractor);
            assertTrue(extractor instanceof ActivityNodeCompartmentExtractor);
        }
    }
}