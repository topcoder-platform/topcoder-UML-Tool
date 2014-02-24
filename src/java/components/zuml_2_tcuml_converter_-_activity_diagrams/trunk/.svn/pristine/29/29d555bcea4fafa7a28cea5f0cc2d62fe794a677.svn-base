/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.StateMachine;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUML2TCUMLConvertible;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Unit tests for <code>ActivityDiagramConversionFacade</code> class.
 * </p>
 *
 * <p>
 * <strong>Change note: </strong>Test cases are added to test the newly added methods.
 * And also one test case is added to test the return result of <code>convertModel</code>.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 * @author TCSDEVELOPER
 * @version 1.1
 */
public class ActivityDiagramConversionFacadeUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ActivityDiagramConversionFacadeUnitTest.class);
    }

    /**
     * <p>
     * Create a Model for testing. It will contain 1 Namespace, 1 non-Namespace instance.
     * And an ActivityDiagram in the namespace.
     * </p>
     *
     * @return the Model for testing
     */
    private Model createModelForTest() {
        Model model = new ModelImpl();
        Namespace n1 = new CollaborationImpl();
        //Level 1, one Namespace, one other
        model.addOwnedElement(n1);
        //Level 1, one none-Namespace element
        model.addOwnedElement(new AttributeImpl());

        //Level 2, the Namespace contains 1 ActivityDiagram
        ZUMLActivityDiagramImpl diagram = new ZUMLActivityDiagramImpl();
        diagram.addNode(new ZUMLFlowFinalNodeImpl());

        n1.addOwnedElement(diagram);

        return model;
    }

    /**
     * <p>
     * Accuracy test for <code>convertModel(Model)</code>.
     * </p>
     *
     * <p>
     * Verify that the ActivityDiagram in the Model is converted successfully.
     * </p>
     */
    public void testConvertModel() {
        Model model = createModelForTest();

        ActivityDiagramConversionFacade.convertModel(model);

        boolean converted = false;

        //Verify that the ActivityDiagram is converted and added to the Model
        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof StateMachine) {
                converted = true;
            }
        }

        assertTrue("The ActivityDiagram should be converted.", converted);

        //The tagDefinition should be added to the model
        converted = false;

        //Verify that the TagDefinition is added to the Model
        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof TagDefinition) {
                converted = true;
            }
        }

        assertTrue("The TagDefinition should be added to the Model.", converted);
    }

    /**
     * <p>
     * Failure test for <code>convertModel(Model)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the model is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testConvertModel_Failure() {
        try {
            ActivityDiagramConversionFacade.convertModel(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>convertModel(Model)</code>.
     * </p>
     *
     * <p>
     * The new version method only adds a return value, so we just check this feature. Other feature
     * is tested by the original test cases.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertModel_New() {
        Model model = new ModelImpl();

        //Level 1, the root model contains 1 ActivityDiagram
        ZUMLActivityDiagramImpl diagram = new ZUMLActivityDiagramImpl();
        diagram.addNode(new ZUMLFlowFinalNodeImpl());
        model.addOwnedElement(diagram);

        //Level 1, the model contains 1 child namespace.
        Namespace n1 = new CollaborationImpl();
        model.addOwnedElement(n1);

        //Level 1, one non-Namespace element
        model.addOwnedElement(new AttributeImpl());

        //Level 2, the Namespace contains 1 ActivityDiagram
        ZUMLActivityDiagramImpl diagram1 = new ZUMLActivityDiagramImpl();
        diagram1.addNode(new ZUMLFlowFinalNodeImpl());
        n1.addOwnedElement(diagram1);

        //converts the namespace
        List<ActivityGraph> activityGraphs = ActivityDiagramConversionFacade.convertModel(model);

        //Verify
        //There are 2 activity diagrams in the hierarchy, they should be returned.
        //We only verify this part, other features are tested by the original test case.
        assertEquals("There should 2 converted activity graphs.", 2,
            activityGraphs.size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertDiagrams(List&lt;Diagram&gt;)</code>.
     * </p>
     *
     * <p>
     * Verify that the given Diagrams are converted from Poseidon 1.5 to TC UML Tool.
     * It'll convert the contains, owner and SemanticModel. Actually, only all the
     * SemanticModelBridge in the hierarchy will be converted.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagrams_Accuracy1() {
        List<Diagram> diagrams = new ArrayList<Diagram>();

        Diagram diagram = new Diagram();
        diagrams.add(diagram);

        //First add a non GraphElement instance
        diagram.addContained(new TextElement());

        //Add a GraphElement instance
        GraphNode node1 = new GraphNode();
        diagram.addContained(node1);

        //It contains a Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge1 = new Uml1SemanticModelBridge();
        modelBridge1.setElement(new ZUMLInitialNodeImpl());
        node1.setSemanticModel(modelBridge1);

        //node1 has sub diagram elements
        GraphNode node2 = new GraphNode();
        node1.addContained(node2);

        //It contains a Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge2 = new Uml1SemanticModelBridge();
        modelBridge2.setElement(new ZUMLInitialNodeImpl());
        node2.setSemanticModel(modelBridge2);

        Uml1SemanticModelBridge owner = new Uml1SemanticModelBridge();
        owner.setElement(new ZUMLInitialNodeImpl());
        diagram.setOwner(owner);

        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(new ZUMLInitialNodeImpl());
        diagram.setSemanticModel(semanticModel);

        //Converts the diagrams
        ActivityDiagramConversionFacade.convertDiagrams(diagrams);

        //Verify that all the semantic model bridge under contained elements should be converted
        Element element = modelBridge1.getElement();
        assertTrue("The modelBridge1's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);

        element = modelBridge2.getElement();
        assertTrue("The modelBridge2's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);

        //Verify that the diagram's owner should be converted.
        element = owner.getElement();
        assertTrue("The owner's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);

        //Verify that the diagram's semantic model should be converted.
        element = semanticModel.getElement();
        assertTrue("The diagram's semantic model's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);
    }

    /**
     * <p>
     * Failure test for <code>convertDiagrams(List&lt;Diagram&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diarams is null, <code>IllegalArgumentException</code> is expected.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagrams_Failure1() {
        try {
            ActivityDiagramConversionFacade.convertDiagrams(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>convertDiagrams(List&lt;Diagram&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the diarams contains null element,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagrams_Failure2() {
        try {
            List<Diagram> diagrams = new ArrayList<Diagram>();
            diagrams.add(null);

            ActivityDiagramConversionFacade.convertDiagrams(diagrams);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>convertContainedElements(List&lt;DiagramElement&gt;)</code>;
     * </p>
     *
     * <p>
     * If the diagramElements is null, it does nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertContainedElements_Null() {
        //It should process successfully.
        ActivityDiagramConversionFacade.convertContainedElements(null);
    }

    /**
     * <p>
     * Accuracy test for <code>convertContainedElements(List&lt;DiagramElement&gt;)</code>;
     * </p>
     *
     * <p>
     * If the diagramElements is empty, it does nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertContainedElements_Empty() {
        List<DiagramElement> diagramElements = new ArrayList<DiagramElement>();

        //It should process successfully.
        ActivityDiagramConversionFacade.convertContainedElements(diagramElements);
    }

    /**
     * <p>
     * Accuracy test for <code>convertContainedElements(List&lt;DiagramElement&gt;)</code>;
     * </p>
     *
     * <p>
     * Verify that all the <code>SemanticModelBridge</code> instances in the hierarchy will
     * be converted properly. It means if it is an <code>Uml1SemanticModelBridge</code> instance,
     * and its element is instance of <code>ZUML2TCUMLConvertible</code>, then this element
     * will be converted to its corresponding TCUML representive.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertContainedElements_Accuracy() {
        List<DiagramElement> diagramElements = new ArrayList<DiagramElement>();

        //First add a non GraphElement instance
        diagramElements.add(new TextElement());

        //Add a GraphElement instance
        GraphNode node1 = new GraphNode();
        diagramElements.add(node1);

        //It contains a Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge1 = new Uml1SemanticModelBridge();
        modelBridge1.setElement(new ZUMLInitialNodeImpl());
        node1.setSemanticModel(modelBridge1);

        //node1 has sub diagram elements
        GraphNode node2 = new GraphNode();
        node1.addContained(node2);

        //It contains a Uml1SemanticModelBridge.
        Uml1SemanticModelBridge modelBridge2 = new Uml1SemanticModelBridge();
        modelBridge2.setElement(new ZUMLInitialNodeImpl());
        node2.setSemanticModel(modelBridge2);

        //node1 has sub diagram elements
        GraphNode node3 = new GraphNode();
        node1.addContained(node3);

        //node3 contains a non Uml1SemanticModelBridge modelBridge.
        node3.setSemanticModel(new SimpleSemanticModelElement());

        //node2 has a sub diagram element
        GraphNode node4 = new GraphNode();
        node2.addContained(node4);

        //node4 has a Uml1SemanticModelBridge, but its element isn't instance of ZUML2TCUMLConvertible
        Uml1SemanticModelBridge modelBridge4 = new Uml1SemanticModelBridge();
        modelBridge4.setElement(new CollaborationImpl());

        //It should process successfully.
        ActivityDiagramConversionFacade.convertContainedElements(diagramElements);

        //Verify the modelBridge1 and modelBridge2's element should be converted.
        Element element = modelBridge1.getElement();
        assertTrue("The modelBridge1's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);

        element = modelBridge2.getElement();
        assertTrue("The modelBridge2's element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);

        //Verify the modelBridge4's element should not change
        element = modelBridge4.getElement();
        assertTrue("The modelBridge4's element should not change.",
            element instanceof CollaborationImpl);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSemanticModelBridge(SemanticModelBridge)</code>.
     * </p>
     *
     * <p>
     * If the semanticModelBridge is null, it will return directly.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge_Null() {
        //It should process successfully
        ActivityDiagramConversionFacade.convertSemanticModelBridge(null);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSemanticModelBridge(SemanticModelBridge)</code>.
     * </p>
     *
     * <p>
     * If the semanticModelBridge is instance of <code>Uml1SemanticModelBridge</code>,
     * its element should be converted properly.
     * In this case, its element is null, it should process successfully.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge_Uml1() {
        SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();

        //It should process successfully
        ActivityDiagramConversionFacade.convertSemanticModelBridge(semanticModelBridge);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSemanticModelBridge(SemanticModelBridge)</code>.
     * </p>
     *
     * <p>
     * If the semanticModelBridge is instance of <code>Uml1SemanticModelBridge</code>,
     * its element should be converted properly.
     * In this case, its element is instance of <code>ZUML2TCUMLConvertible</code>,
     * it should be converted to corresponding TCUML element.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge_Uml1Convertible() {
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        ZUML2TCUMLConvertible node = new ZUMLInitialNodeImpl();
        semanticModelBridge.setElement(node);

        //It should process successfully
        ActivityDiagramConversionFacade.convertSemanticModelBridge(semanticModelBridge);

        Element element = semanticModelBridge.getElement();

        //It should be converted to a corresponding Pseudostate instance
        assertTrue("The element should be changed to Pseudostate instance.",
            element instanceof Pseudostate);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSemanticModelBridge(SemanticModelBridge)</code>.
     * </p>
     *
     * <p>
     * If the semanticModelBridge is instance of <code>Uml1SemanticModelBridge</code>,
     * its element should be converted properly.
     * In this case, its element isn't instance of <code>ZUML2TCUMLConvertible</code>,
     * it should do nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge_Uml1UnConvertible() {
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        Element collaboration = new CollaborationImpl();
        semanticModelBridge.setElement(collaboration);

        //It should process successfully
        ActivityDiagramConversionFacade.convertSemanticModelBridge(semanticModelBridge);

        //Gets the element after converted
        Element element = semanticModelBridge.getElement();

        //Verify that it should not be changed.
        assertEquals("The SemanticModelBridge's element shouldn't be changed.",
            collaboration, element);
    }

    /**
     * <p>
     * Accuracy test for <code>convertSemanticModelBridge(SemanticModelBridge)</code>.
     * </p>
     *
     * <p>
     * If the semanticModelBridge isn't instance of <code>Uml1SemanticModelBridge</code>,
     * it should do nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge_NotUml1() {
        SemanticModelBridge semanticModelBridge = new SimpleSemanticModelElement();

        //It should process successfully
        ActivityDiagramConversionFacade.convertSemanticModelBridge(semanticModelBridge);
    }

    /**
     * <p>
     * Accuracy test for <code>convertNamespace(Namespace, Model, List&lt;ActivityGraph&gt;)</code>.
     * </p>
     *
     * <p>
     * If the namespace is null, it should do nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertNamespace_Accuracy1() {
        //It should process successfully.
        ActivityDiagramConversionFacade.convertNamespace(null, new ModelImpl(),
            new ArrayList<ActivityGraph>());
    }

    /**
     * <p>
     * Accuracy test for <code>convertNamespace(Namespace, Model, List&lt;ActivityGraph&gt;)</code>.
     * </p>
     *
     * <p>
     * If the model is null, it should do nothing.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertNamespace_Accuracy2() {
        //It should process successfully.
        ActivityDiagramConversionFacade.convertNamespace(new CollaborationImpl(),
            null, new ArrayList<ActivityGraph>());
    }

    /**
     * <p>
     * Accuracy test for <code>convertNamespace(Namespace, Model, List&lt;ActivityGraph&gt;)</code>.
     * </p>
     *
     * <p>
     * Verify that all the activity diagrams in the hierarchy rooted by namespace will be converted
     * to TCUML element, and then added to activityGraphs.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertNamespace_Accuracy3() {
        Model rootModel = new ModelImpl();

        Namespace rootNamespace = new CollaborationImpl();

        //Level 1, the root namespace contains 1 ActivityDiagram
        ZUMLActivityDiagramImpl diagram = new ZUMLActivityDiagramImpl();
        diagram.addNode(new ZUMLFlowFinalNodeImpl());
        rootNamespace.addOwnedElement(diagram);

        //Level 1, the root namespace contains 1 child namespace.
        Namespace n1 = new CollaborationImpl();
        rootNamespace.addOwnedElement(n1);

        //Level 1, one none-Namespace element
        rootNamespace.addOwnedElement(new AttributeImpl());

        //Level 2, the Namespace contains 1 ActivityDiagram
        ZUMLActivityDiagramImpl diagram1 = new ZUMLActivityDiagramImpl();
        diagram1.addNode(new ZUMLFlowFinalNodeImpl());
        n1.addOwnedElement(diagram1);

        List<ActivityGraph> activityGraphs = new ArrayList<ActivityGraph>();

        //converts the namespace
        ActivityDiagramConversionFacade.convertNamespace(rootNamespace,
            rootModel, activityGraphs);

        //Verify
        //There are 2 activity diagrams in the namespace hierarchy, they should both be converted
        assertEquals("There should be 2 converted diagrams.", 2,
            activityGraphs.size());

        //The 2 converted activity graph should be added to the root model
        assertEquals("There should be 2 converted activity graph in the model.",
            2, rootModel.getOwnedElements().size());

        //Verify that they are removed from their original namespace
        assertTrue("The n1 should have 0 owned elements now.",
            n1.getOwnedElements().isEmpty());
        assertEquals("The root namespace should only have 2 owned elements now.",
            2, rootNamespace.getOwnedElements().size());
    }

    /**
     * <p>
     * Failure test for <code>convertNamespace(Namespace, Model, List&lt;ActivityGraph&gt;)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the activityGraphs is null, <code>IllegalArgumentException</code> is expected.
     * </p>
     *
     * <p>
     * <strong>Change Note: </strong> This is added in the version 1.1;
     * </p>
     *
     * @since 1.1
     */
    public void testConvertNamespace_Failure() {
        try {
            ActivityDiagramConversionFacade.convertNamespace(new CollaborationImpl(),
                new ModelImpl(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
