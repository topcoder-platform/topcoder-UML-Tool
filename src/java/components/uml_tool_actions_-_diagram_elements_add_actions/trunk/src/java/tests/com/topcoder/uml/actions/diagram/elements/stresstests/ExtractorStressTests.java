/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.stresstests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityStateCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.GeneralizationCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.MessageCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ObjectCompartmentExtractor;

import junit.framework.TestCase;


/**
 * Stress test for extractors.
 *
 * @author lyt
 * @version 1.0
 */
public class ExtractorStressTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        StressTestHelper.loadConfig();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
    }

    /**
     * Stress test for ActivityNodeCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testActivityNodeCompartmentExtractor()
        throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForActivityNode();
        CompartmentExtractor extractor = new ActivityNodeCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("ActivityNodeCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for ActivityStateCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testActivityStateCompartmentExtractor()
        throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForActivityState();
        CompartmentExtractor extractor = new ActivityStateCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);
        }

        StressTestHelper.printTime("ActivityStateCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for AssociationCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testAssociationCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForAssociation();
        CompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);

            newElement = extractor.extractFirstAssociationEnd();
            extractor.updateFirstAssociationEnd(newElement);

            newElement = extractor.extractSecondAssociationEnd();
            extractor.updateSecondAssociationEnd(newElement);
        }

        StressTestHelper.printTime("AssociationCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for ClassifierCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testClassifierCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForClassifier();
        CompartmentExtractor extractor = new ClassifierCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractAttribute();
            extractor.updateAttribute(newElement);

            newElement = extractor.extractOperation();
            extractor.updateOperation(newElement);
        }

        StressTestHelper.printTime("ClassifierCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for DefaultEdgeCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testDefaultEdgeCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForDefaultEdge();
        CompartmentExtractor extractor = new DefaultEdgeCompartmentExtractor(edge);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("DefaultEdgeCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for DefaultNodeCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testDefaultNodeCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForClassifier();
        CompartmentExtractor extractor = new DefaultNodeCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractNamespace();
            extractor.updateNamespace(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("DefaultNodeCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for GeneralizationCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testGeneralizationCompartmentExtractor()
        throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForGeneralization();
        CompartmentExtractor extractor = new GeneralizationCompartmentExtractor(edge);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("GeneralizationCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for MessageCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testMessageCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForMessage();
        CompartmentExtractor extractor = new MessageCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("MessageCompartmentExtractor", StressTestHelper.testCount);
    }

    /**
     * Stress test for ObjectCompartmentExtractor.
     *
     * @throws Exception to junit
     */
    public void testObjectCompartmentExtractor() throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForObject();
        CompartmentExtractor extractor = new ObjectCompartmentExtractor(node);
        GraphElement newElement = null;

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            newElement = extractor.extractName();
            extractor.updateName(newElement);

            newElement = extractor.extractStereotype();
            extractor.updateStereotype(newElement);
        }

        StressTestHelper.printTime("ObjectCompartmentExtractor", StressTestHelper.testCount);
    }
}
