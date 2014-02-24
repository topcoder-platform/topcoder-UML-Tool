/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.XMISequenceDiagramConverterUtil;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;


/**
 * Accuracy tests for <code>XMISequenceDiagramConverterUtil</code>.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class XMISequenceDiagramConverterUtilTests extends TestCase {
    /**
     * 'asynchCall' value of 'messageSort' property of the Message.
     */
    private static final String MESSAGE_SORT_ASYNCH_CALL = "asynchCall";

    /**
     * Name of message used in tests.
     */
    private static final String TEST_MODEL_MESSAGE_NAME = "test_message";

    /**
     * Name of lifeline used in tests.
     */
    private static final String TEST_MODEL_LIFELINE_NAME = "test_lifeline";

    /**
     * 'Name' value of 'typeInfo' property of SemanticModel added to Sequence Diagram.
     */
    private static final String SEMMODEL_TYPEINFO_NAME = "Name";

    /**
     * 'StereotypeCompartment' value of 'typeInfo' property of SemanticModel added to Sequence Diagram.
     */
    private static final String SEMMODEL_TYPEINFO_STEREOTYPE_COMPARTMENT = "StereotypeCompartment";

    /**
     * 'StereotypeStart' value of 'typeInfo' property of SemanticModel added to Sequence Diagram.
     */
    private static final String SEMMODEL_TYPEINFO_STEREOTYPE_START = "StereotypeStart";

    /**
     * 'StereotypeEnd' value of 'typeInfo' property of SemanticModel added to Sequence Diagram.
     */
    private static final String SEMMODEL_TYPEINFO_STEREOTYPE_END = "StereotypeEnd";

    /**
     * Model object created for test converting.
     */
    private Model testModel;

    /**
     * Collaboration object created for test converting.
     */
    private Collaboration testCollab;

    /**
     * Interaction object created for test converting.
     */
    private Interaction testInter;

    /**
     * Message object created for test converting.
     */
    private Message testMsg;

    /**
     * Lifeline object created for test converting.
     */
    private Lifeline testLine;

    /**
     * Package object created for test converting.
     */
    private Package testPack;

    /**
     * Comment object created for test converting.
     */
    private Comment testComment;

    /**
     * <p>Create model for test converting.</p>
     * <p>Method creates the simple model much like the real one used in ZUML files.
     *    All created objects are stored to instance variables for use in testcase methods.</p>
     */
    private void createTestModel() {
        testModel = new ModelImpl();
        testCollab = new CollaborationImpl();
        testInter = new InteractionImpl();
        testMsg = new MessageImpl();
        testMsg.setName(TEST_MODEL_MESSAGE_NAME);
        testMsg.setMessageSort(MESSAGE_SORT_ASYNCH_CALL);
        testInter.addMessage(testMsg);
        testLine = new LifelineImpl();
        testLine.setName(TEST_MODEL_LIFELINE_NAME);
        testInter.addLifeline(testLine);
        testComment = new CommentImpl();
        testComment.setNamespace(testCollab);
        testInter.addOwnedElement(testComment);
        testCollab.addOwnedElement(testInter);
        testModel.addOwnedElement(testCollab);
        testPack = new PackageImpl();
        testModel.addOwnedElement(testPack);
    }

    /**
     * <p>Create Sequence Diagram for test converting.</p>
     * <p>Method creates simple SD object to test its convertion in XMISequenceDiagramConverterUtil class.
     *    None of created objects is stored somewhere. SD returned as a result of this method.</p>
     *
     * @return   Sequence Diagram created
     */
    private Diagram createTestDiagram() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge diagOwner = new Uml1SemanticModelBridge();
        diagOwner.setElement(testInter);
        diagram.setOwner(diagOwner);
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge nodeModel = new Uml1SemanticModelBridge();
        nodeModel.setElement(testLine);
        node.setSemanticModel(nodeModel);
        GraphNode node2 = new GraphNode();
        GraphConnector anchor = new GraphConnector();
        node2.addAnchorage(anchor);
        node.addContained(node2);
        node.addContained(new GraphEdge());
        diagram.addContained(node);
        GraphEdge edge = new GraphEdge();
        Uml1SemanticModelBridge edgeModel = new Uml1SemanticModelBridge();
        edgeModel.setElement(testMsg);
        edge.setSemanticModel(edgeModel);
        diagram.addContained(edge);
        return diagram;
    }

    /**
     * <p>Create the model for testing.</p>
     * <p>Objects created during model creation are used in several testcase methods.
     *    So this creation put in setUp for these objects to be accessible.</p>
     */
    public void setUp() {
        createTestModel();
    }

    /**
     * <p>Testing of XMISequenceDiagramConverterUtil constructor.</p>
     * <p>XMISequenceDiagramConverterUtil is the utility class. So it must not allow instantiation.</p>
     */
    public void test_Ctor() {
        try {
            XMISequenceDiagramConverterUtil.class.newInstance();
            fail("Class allows construction");
        } catch (IllegalAccessException iae) {
            // If we get this exception it's ok
        } catch (InstantiationException ie) {
            // This exception is ok too
        }
    }

    /**
     * <p>Testing of convertCollaborationInModel method.</p>
     * <p>Test relies on the data structure generated by {@link #createTestModel()} method.</p>
     */
    public void test_convertCollaborationInModel() {
        XMISequenceDiagramConverterUtil.convertCollaborationInModel(testModel);
        assertEquals("Wrong number of elements in model", 4, testModel.getOwnedElements().size());
        Iterator<ModelElement> iter = testModel.getOwnedElements().iterator();
        Collaboration collab = (Collaboration) iter.next();
        assertTrue("Wrong collaboration returned", collab == testCollab);
        assertEquals("Wrong number of elements in collaboration", 0, collab.getOwnedElements().size());
        Package pack = (Package) iter.next();
        assertTrue("Wrong package returned", pack == testPack);
        Collaboration interCollab = (Collaboration) iter.next();
        assertTrue("Wrong converted collaboration returned", interCollab == testInter.toTCUMLElement());
        Comment interComm = (Comment) iter.next();
        assertTrue("Wrong comment returned", interComm == testComment);
        assertTrue("Wrong comment namespace", interComm.getNamespace() == testModel);
    }

    /**
     * <p>Testing of convertSequenceDiagrams method.</p>
     * <p>Test relies on the data structure generated by {@link #createTestDiagram()} method.</p>
     */
    public void test_convertSequenceDiagrams() {
        ArrayList<Diagram> diags = new ArrayList<Diagram>();
        diags.add(createTestDiagram());
        diags.add(createTestDiagram());
        XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diags);
        checkConvertedDiagram(diags.get(0));
        checkConvertedDiagram(diags.get(1));
    }

    /**
     * <p>Testing of convertSequenceDiagram method.</p>
     * <p>Test relies on the data structure generated by {@link #createTestDiagram()} method.</p>
     */
    public void test_convertSequenceDiagram() {
        Diagram diagram = createTestDiagram();
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
        checkConvertedDiagram(diagram);
    }

    /**
     * <p>Check if converted diagram is converted correctly.</p>
     * <p>Checking relies on the data structure generated by {@link #createTestDiagram()} method.</p>
     *
     * @param diagram   converted diagram
     */
    private void checkConvertedDiagram(Diagram diagram) {
        Element elem = ((Uml1SemanticModelBridge) diagram.getOwner()).getElement();
        assertTrue("Interaction wasn't transformed", testInter.toTCUMLElement() == elem);
        assertEquals("Wrong number of containeds in diagram", 2, diagram.getContaineds().size());
        GraphNode node = (GraphNode) diagram.getContaineds().get(0);
        elem = ((Uml1SemanticModelBridge) node.getSemanticModel()).getElement();
        assertTrue("Lifeline in node wasn't transformed", testLine.toTCUMLElement() == elem);
        assertEquals("Wrong number of containeds in node", 0, node.getContaineds().size());
        assertEquals("Wrong number of anchorages in node", 1, node.getAnchorages().size());

        GraphEdge edge = (GraphEdge) diagram.getContaineds().get(1);
        elem = ((Uml1SemanticModelBridge) edge.getSemanticModel()).getElement();
        assertTrue("Message in graphEdge wasn't transformed", testMsg.toTCUMLElement() == elem);
        assertEquals("Wrong number of containeds in edge", 4, edge.getContaineds().size());
        checkStereotypeNode((GraphNode) edge.getContaineds().get(0));
        checkNameNode((GraphNode) edge.getContaineds().get(1));
        checkNameNode((GraphNode) edge.getContaineds().get(2));
        checkStereotypeNode((GraphNode) edge.getContaineds().get(3));
    }

    /**
     * Check that GraphNode contains correct SimpleSemanticModelElement as semanticModel with
     * 'Name' value as typeInfo.
     *
     * @param node   GraphNode to check
     */
    private void checkNameNode(GraphNode node) {
        assertTrue("Wrong semanticModel set", node.getSemanticModel() instanceof SimpleSemanticModelElement);
        String typeInfo = ((SimpleSemanticModelElement) node.getSemanticModel()).getTypeInfo();
        assertEquals("Wrong semantic typeInfo in node inside edge", SEMMODEL_TYPEINFO_NAME, typeInfo);
    }

    /**
     * Check that GraphNode contains correct structure of GraphNodes inside with semanticModels
     * related to StereotypeCompartment.
     *
     * @param node   GraphNode to check
     */
    private void checkStereotypeNode(GraphNode node) {
        assertTrue("Wrong semanticModel set", node.getSemanticModel() instanceof SimpleSemanticModelElement);
        String typeInfo = ((SimpleSemanticModelElement) node.getSemanticModel()).getTypeInfo();
        assertEquals("Wrong semantic typeInfo in node inside edge", SEMMODEL_TYPEINFO_STEREOTYPE_COMPARTMENT, typeInfo);
        assertEquals("Wrong number of containeds in node inside edge", 3, node.getContaineds().size());
        GraphNode childNode = (GraphNode) node.getContaineds().get(0);
        assertTrue("Wrong semanticModel set", childNode.getSemanticModel() instanceof SimpleSemanticModelElement);
        typeInfo = ((SimpleSemanticModelElement) childNode.getSemanticModel()).getTypeInfo();
        assertEquals("Wrong semantic typeInfo in node inside edge", SEMMODEL_TYPEINFO_STEREOTYPE_START, typeInfo);
        childNode = (GraphNode) node.getContaineds().get(1);
        assertEquals("Wrong number of containeds in subnode inside edge", 1, childNode.getContaineds().size());
        checkNameNode((GraphNode) childNode.getContaineds().get(0));
        childNode = (GraphNode) node.getContaineds().get(2);
        assertTrue("Wrong semanticModel set", childNode.getSemanticModel() instanceof SimpleSemanticModelElement);
        typeInfo = ((SimpleSemanticModelElement) childNode.getSemanticModel()).getTypeInfo();
        assertEquals("Wrong semantic typeInfo in node inside edge", SEMMODEL_TYPEINFO_STEREOTYPE_END, typeInfo);
    }

}
