/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>
 * Unit tests for <code>XMISequenceDiagramConverterUtil</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class XMISequenceDiagramConverterUtilUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(XMISequenceDiagramConverterUtilUnitTest.class);
    }

    /**
     * <p>
     * Create a model for testing convertCollaborationInModel. There are 2 Interactions
     * in the hierarchy, they should be transformed to Collaboration, and added to the
     * root model. Then remove the original Interaction element.
     * </p>
     *
     * @return a Model instance for testing
     */
    private Model createModel() {
        Model model = new ModelImpl();
        Namespace n1 = new CollaborationImpl();
        //Level 1, one Namespace, one other
        model.addOwnedElement(n1);
        model.addOwnedElement(new AttributeImpl());

        //Level 2, the Namespace contains 1 interaction, 1 namespace, 1 other
        Interaction i21 = new InteractionImpl();
        n1.addOwnedElement(i21);

        Namespace n21 = new CollaborationImpl();
        n1.addOwnedElement(n21);

        n1.addOwnedElement(new AttributeImpl());

        //Leve 3, one namespace
        Interaction i31 = new InteractionImpl();
        n21.addOwnedElement(i31);

        return model;
    }

    /**
     * <p>Verify the in Namespace hierarchy, there is not any Interaction instance.</p>
     *
     * @param namespace the Namespace hierarchy
     * @return true indicates that there is no Interaction, otherwise false
     */
    private boolean verify(Namespace namespace) {
        for (ModelElement element : namespace.getOwnedElements()) {
            if (element instanceof Namespace) {
                if (!verify((Namespace) element)) {
                    return false;
                }
            }

            if (element instanceof Interaction) {
                return false;
            }
        }

        return true;
    }

    /**
     * <p>
     * Accuracy test for <code>convertCollaborationInModel(Model)</code>.
     * Verify that the Interactions in the model are transformed to Collaboration and
     * then added to the model.
     * </p>
     */
    public void testConvertCollaborationInModel() {
        //There are 2 Interaction in the hierarchy, they should be transformed to Collaboration
        //So, there are 3 Collaborations in the model's ownedElements (Namespace n1 is also Collaboration).
        Model model = createModel();

        XMISequenceDiagramConverterUtil.convertCollaborationInModel(model);

        //Verify that there are 3 corresponding Collaboration in Model
        int count = 0;

        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof Collaboration) {
                count++;
            }
        }

        assertEquals("The two interaction should be transformed to Collaboration.",
            3, count);

        //Verify that all the Interaction are removed from the namespaces
        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof Namespace) {
                assertTrue("There should be no Interactions.",
                    verify((Namespace) element));
            }
        }
    }

    /**
     * <p>
     * Failure test for <code>convertCollaborationInModel(Model)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the model is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertCollaborationInModel_Failure() {
        try {
            XMISequenceDiagramConverterUtil.convertCollaborationInModel(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagrams(Collection)</code>.
     * Create a list of Diagrams, after converted, verify them in the verifyDiagram method.
     * The diagram for testing is constructed on purpose, it's transformed Diagram should have
     * some special property, this will be verified in the verifyDiagram.
     * </p>
     */
    public void testConvertSequenceDiagrams() {
        Collection<Diagram> diagrams = new ArrayList<Diagram>();
        diagrams.add(createDiagramForTest());
        diagrams.add(createDiagramForTest());

        XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diagrams);

        for (Diagram diagram : diagrams) {
            verifyDiagram(diagram);
        }
    }

    /**
     * <p>
     * Failure test for <code>convertSequenceDiagrams(Collection)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertSequenceDiagrams_Failure1() {
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>convertSequenceDiagrams(Collection)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertSequenceDiagrams_Failure2() {
        try {
            Collection<Diagram> collection = new ArrayList<Diagram>();

            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(collection);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>convertSequenceDiagrams(Collection)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection contains null element, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertSequenceDiagrams_Failure3() {
        try {
            Collection<Diagram> collection = new ArrayList<Diagram>();
            collection.add(null);

            XMISequenceDiagramConverterUtil.convertSequenceDiagrams(collection);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Create a Diagram for testing <code>convertSequenceDiagram(Diagram)</code>.
     * </p>
     *
     * @return a Sequence diagram
     */
    private Diagram createDiagramForTest() {
        Diagram diagram = new Diagram();

        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        Interaction interaction = new InteractionImpl();
        model.setElement(interaction);
        diagram.setOwner(model);

        GraphNode childNode = new GraphNode();
        diagram.addContained(childNode);

        Uml1SemanticModelBridge cmodel = new Uml1SemanticModelBridge();
        childNode.setSemanticModel(cmodel);

        Attribute attr = new AttributeImpl();
        Classifier type = new InteractionImpl();

        //Set the type to Interaction
        attr.setType(type);

        Lifeline line = new LifelineImpl();
        line.setRepresents(attr);
        line.setName("line");
        cmodel.setElement(line);

        GraphNode grandNode = new GraphNode();
        childNode.addContained(grandNode);
        grandNode.addAnchorage(new GraphConnector());

        GraphNode grandGrandNode = new GraphNode();
        grandNode.addContained(grandGrandNode);
        grandGrandNode.addAnchorage(new GraphConnector());

        GraphEdge childEdge = new GraphEdge();
        Uml1SemanticModelBridge emodel = new Uml1SemanticModelBridge();
        childEdge.setSemanticModel(emodel);
        emodel.setElement(new MessageImpl());

        diagram.addContained(childEdge);

        return diagram;
    }

    /**
     * <p>
     * Verify the diagram from createDiagramForTest().
     * To check whether it's converted correctly.
     * </p>
     *
     * @param diagram the Diagram to verify
     */
    private void verifyDiagram(Diagram diagram) {
        //Verify that semantic model's element has been transformed to Collaboration
        Uml1SemanticModelBridge model = (Uml1SemanticModelBridge) diagram.getOwner();
        assertTrue("The Interaction has been transformed to Collaboration.",
            model.getElement() instanceof Collaboration);

        //It only has a GraphNode
        GraphNode node = (GraphNode) (diagram.getContaineds().get(0));
        model = (Uml1SemanticModelBridge) node.getSemanticModel();
        //The node's semantic model should be transformed to Object.
        assertTrue("The Lifeline should be transformed to Object.",
            model.getElement() instanceof Object);

        //It should have 2 anchorages, all of his subGraphNode's anchorage should be moved to the graphnode
        assertEquals("The GraphNode should have 2 anchorages.", 2,
            node.getAnchorages().size());
        //Its contained should be removed.
        assertTrue("The contained should be empty.",
            node.getContaineds().isEmpty());

        GraphEdge edge = (GraphEdge) (diagram.getContaineds().get(1));
        //The edge's semantic model's element should be transformed to Link
        model = (Uml1SemanticModelBridge) edge.getSemanticModel();
        assertTrue("The Message should be transformed to Link.",
            model.getElement() instanceof Link);

        //The edge should have only 4 GraphNodes
        assertEquals("The edge should have only 4 GraphNodes.", 4,
            edge.getContaineds().size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagram(Diagram)</code>.
     * Create a diagram for testing convertSequenceDiagram, and then it will be
     * verified in the verifyDiagram() to test whether the method is working well.
     * </p>
     */
    public void testConvertSequenceDiagram() {
        Diagram diagram = createDiagramForTest();

        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);

        verifyDiagram(diagram);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a Diagram doesn't have a Uml1SemanticModelBridge.
     * </p>
     */
    public void testConvertSequenceDiagram1() {
        Diagram diagram = new Diagram();
        diagram.setOwner(new SimpleSemanticModelElement());

        GraphEdge edge = new GraphEdge();
        diagram.addContained(edge);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);

        //As it's not sequence diagram, so any contained element should not be transformed.
        assertTrue("Its edges should not be transformed.",
            edge.getContaineds().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a Diagram has a Uml1SemanticModelBridge, but its element isn't instance of
     * Interaction.
     * </p>
     */
    public void testConvertSequenceDiagram2() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        diagram.setOwner(model);

        //It's not instance of Interaction
        model.setElement(new MessageImpl());

        GraphEdge edge = new GraphEdge();
        diagram.addContained(edge);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);

        //As it's not sequence diagram, so any contained element should not be transformed.
        assertTrue("Its edges should not be transformed.",
            edge.getContaineds().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a diagram doesn't have any GraphNode or GraphEdge.
     * Interaction.
     * </p>
     */
    public void testConvertSequenceDiagram3() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        diagram.setOwner(model);

        //It's not instance of Interaction
        model.setElement(new InteractionImpl());

        diagram.addContained(new TextElement());

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);

        assertEquals("The contained should not be changed.", 1,
            diagram.getContaineds().size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a diagram with GraphEdge and GraphNode, but they didn't have a Uml1SemanticModelBridge.
     * </p>
     */
    public void testConvertSequenceDiagram4() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        diagram.setOwner(model);

        //It's not instance of Interaction
        model.setElement(new InteractionImpl());

        GraphNode node = new GraphNode();
        diagram.addContained(node);

        GraphEdge edge = new GraphEdge();
        diagram.addContained(edge);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a diagram with GraphEdge and GraphNode, they have a Uml1SemanticModelBridge,
     * but the semantic model's element isn't the right type.
     * </p>
     */
    public void testConvertSequenceDiagram5() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        diagram.setOwner(model);

        //It's not instance of Interaction
        model.setElement(new InteractionImpl());

        GraphNode node = new GraphNode();
        diagram.addContained(node);
        model = new Uml1SemanticModelBridge();
        node.setSemanticModel(model);

        GraphEdge edge = new GraphEdge();
        diagram.addContained(edge);
        model = new Uml1SemanticModelBridge();
        edge.setSemanticModel(model);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSequenceDiagra(Diagram)</code>.
     * Test a diagram with GraphNode, but it's semantic model's element is
     * not ZUML2TCUMLTransformer&lt;Object&gt;.
     * </p>
     */
    public void testConvertSequenceDiagram6() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge model = new Uml1SemanticModelBridge();
        diagram.setOwner(model);

        //It's not instance of Interaction
        model.setElement(new InteractionImpl());

        GraphNode node = new GraphNode();
        diagram.addContained(node);
        model = new Uml1SemanticModelBridge();
        model.setElement(new MessageImpl());
        node.setSemanticModel(model);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
    }

    /**
     * <p>
     * Failure test for <code>convertSequenceDiagra(Diagram)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diagram is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertSequenceDiagram_Failure() {
        try {
            XMISequenceDiagramConverterUtil.convertSequenceDiagram(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
