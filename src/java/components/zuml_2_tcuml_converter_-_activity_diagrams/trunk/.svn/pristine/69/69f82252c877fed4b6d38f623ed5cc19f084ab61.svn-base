/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.umltool.xmiconverters.poseidon5.ActivityDiagramConversionFacade;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl;


/**
 * The accuracy tests for the class ActivityDiagramConversionFacade.
 *
 * @author bbskill
 * @version 1.1
 */
public class ActivityDiagramConversionFacadeAccuracyTests extends TestCase {

    /**
     * <p>
     * Create a Diagram for testing.
     * </p>
     *
     * @return a diagrams used for testing
     * @since 1.1
     */
    private Diagram createDisgram() {
        Diagram diagram = new Diagram();
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(new ZUMLActivityDiagramImpl());

        // set owner and semanticModel
        Uml1SemanticModelBridge owner = new Uml1SemanticModelBridge();
        owner.setElement(new ZUMLActivityDiagramImpl());
        diagram.setOwner(owner);
        diagram.setSemanticModel(semanticModel);

        // add edge to the diagram
        GraphEdge edge = new GraphEdge();
        Uml1SemanticModelBridge semanticModelEdge = new Uml1SemanticModelBridge();
        semanticModelEdge.setElement(new ZUMLActivityDiagramImpl());
        edge.setSemanticModel(semanticModelEdge);
        diagram.addContained(edge);

        // add node to the diagram
        GraphNode node = new GraphNode();
        Uml1SemanticModelBridge semanticModelNode = new Uml1SemanticModelBridge();
        semanticModelNode.setElement(new ZUMLActivityDiagramImpl());
        node.setSemanticModel(semanticModelNode);
        diagram.addContained(node);

        // add a Ellipse instance to the diagram.
        diagram.addContained(new Ellipse());

        return diagram;
    }

    /**
     * <p>
     * Tests for convertSemanticModelBridge(SemanticModelBridge) for accuracy.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridge() throws Exception {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(new ZUMLActivityDiagramImpl());
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertSemanticModelBridge",
                SemanticModelBridge.class);
        method.setAccessible(true);
        method.invoke(null, bridge);
        checkSemanticModelBridgeElement(bridge);
    }

    /**
     * <p>
     * Tests for convertSemanticModelBridge(SemanticModelBridge) for accuracy.
     * </p>
     *
     * <p>
     * It tests the SemanticModelBridge is not Uml1SemanticModelBridge, and the method does nothing.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridgeWithoutUml1SemanticModelBridge() throws Exception {
        SemanticModelBridge bridge = new SimpleSemanticModelElement();
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertSemanticModelBridge",
                SemanticModelBridge.class);
        method.setAccessible(true);
        // nothing happen
        method.invoke(null, bridge);
    }

    /**
     * <p>
     * Tests for convertSemanticModelBridge(SemanticModelBridge) for accuracy.
     * </p>
     *
     * <p>
     * It tests the SemanticModelBridge is null, and expects no exception
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridgeWithNullUml1SemanticModelBridge() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertSemanticModelBridge",
                SemanticModelBridge.class);
        method.setAccessible(true);
        // nothing happen
        method.invoke(null, (Uml1SemanticModelBridge) null);
    }

    /**
     * <p>
     * Tests for convertSemanticModelBridge(SemanticModelBridge) for accuracy.
     * </p>
     *
     * <p>
     * It tests the Uml1SemanticModelBridge doesn't contain ZUML2TCUMLConvertible as element, and the method does
     * nothing.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertSemanticModelBridgeWithoutZUML2TCUMLConvertible() throws Exception {
        SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        CommentImpl element = new CommentImpl();
        ((Uml1SemanticModelBridge) bridge).setElement(element);
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertSemanticModelBridge", SemanticModelBridge.class);
        method.setAccessible(true);
        method.invoke(null, bridge);
        // nothing happen
        assertSame("The element should be the same.", element, ((Uml1SemanticModelBridge) bridge).getElement());
    }

    /**
     * <p>
     * Tests for convertContainedElements(List<DiagramElement>) accuracy.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertContainedElements() throws Exception {
        List<DiagramElement> list = new ArrayList<DiagramElement>();
        Diagram diagram = createDisgram();
        diagram.addContained(createDisgram());
        list.add(diagram);
        list.add(createDisgram());

        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertContainedElements",
                List.class);
        method.setAccessible(true);
        method.invoke(null, list);
        for (DiagramElement listElement : list) {
            Diagram element = (Diagram) listElement;
            checkSemanticModelBridgeElement(element.getSemanticModel());
            for (DiagramElement diagramElement : element.getContaineds()) {
                if (diagramElement instanceof GraphElement) {
                    checkSemanticModelBridgeElement(((GraphElement) diagramElement).getSemanticModel());
                }
            }
        }
    }

    /**
     * <p>
     * Tests for convertContainedElements(List<DiagramElement>) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the list is null and expects no exception.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertContainedElementsWithNullList() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertContainedElements",
                List.class);
        method.setAccessible(true);
        method.invoke(null, (List) null);
    }


    /**
     * <p>
     * Tests for convertDiagrams(List<Diagram>) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the list is null and expects {@link IllegalArgumentException}.
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagramsWithNullList() {
        try {
            ActivityDiagramConversionFacade.convertDiagrams(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests for convertDiagrams(List<Diagram>) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the list contains null elements and expects {@link IllegalArgumentException}.
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagramsWithNullListElement() {
        try {
            ActivityDiagramConversionFacade.convertDiagrams(Arrays.asList(new Diagram(), null));
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests for convertDiagrams(List<Diagram>) for accuracy.
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagrams() {
        List<Diagram> list = new ArrayList<Diagram>();
        Diagram diagram = createDisgram();
        diagram.addContained(createDisgram());
        list.add(diagram);
        list.add(createDisgram());
        ActivityDiagramConversionFacade.convertDiagrams(list);
        for (Diagram element : list) {
            // check SemanticModel
            checkSemanticModelBridgeElement(element.getSemanticModel());
            // check owner
            checkSemanticModelBridgeElement(element.getOwner());
            for (DiagramElement diagramElement : element.getContaineds()) {
                if (diagramElement instanceof GraphElement) {
                 // check SemanticModel
                    checkSemanticModelBridgeElement(((GraphElement) diagramElement).getSemanticModel());
                }
            }
        }
    }

    /**
     * <p>
     * Tests the method for convertNamespace(Namespace, Model, List<ActivityGraph>) for accuracy.
     * <p>
     *
     * <p>
     * It tests the case that the namespace is null and expects the method does nothing.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertNamespaceWithNullNamespace() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertNamespace",
                Namespace.class, Model.class, List.class);
        method.setAccessible(true);
        List<ActivityGraphImpl> list = new ArrayList<ActivityGraphImpl>();
        method.invoke(null, (Namespace) null, new ModelImpl(), list);
        assertTrue("The ActivityGraphImpl list should be empty.", list.isEmpty());
    }

    /**
     * <p>
     * Tests the method for convertNamespace(Namespace, Model, List<ActivityGraph>) for accuracy.
     * <p>
     *
     * <p>
     * It tests the case that the Model is null and expects the method does nothing.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertNamespaceWithNullModel() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertNamespace",
                Namespace.class, Model.class, List.class);
        method.setAccessible(true);
        List<ActivityGraphImpl> list = new ArrayList<ActivityGraphImpl>();
        Namespace namespace = new PackageImpl();
        namespace.addOwnedElement(new ZUMLActivityDiagramImpl());
        method.invoke(null, namespace, (Model) null, list);
        assertTrue("The ActivityGraphImpl list should be empty.", list.isEmpty());
    }

    /**
     * <p>
     * Tests the method for convertNamespace(Namespace, Model, List<ActivityGraph>) for accuracy.
     * <p>
     *
     * <p>
     * It tests the case that the List is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to Junit
     *
     * @since 1.1
     */
    public void testConvertNamespaceWithNullList() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertNamespace",
                Namespace.class, Model.class, List.class);
        method.setAccessible(true);
        Namespace namespace = new PackageImpl();
        namespace.addOwnedElement(new ZUMLActivityDiagramImpl());
        try {
            method.invoke(null, namespace, new ModelImpl(), (List) null);
            fail("IllegalArgumentException is expected.");
        } catch (InvocationTargetException e) {
            assertTrue("The exception should be of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
            // good
        }
    }

    /**
     * <p>
     * Tests the method for convertNamespace(Namespace, Model, List<ActivityGraph>) for accuracy.
     * <p>
     *
     * @throws NoSuchMethodException to Junit
     *
     * @since 1.1
     */
    public void testConvertNamespace() throws Exception {
        Method method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertNamespace",
                Namespace.class, Model.class, List.class);
        method.setAccessible(true);
        Model model = new ModelImpl();
        Namespace namespace = new PackageImpl();

        //add one ActivityDiagram to the namespace
        namespace.addOwnedElement(new ZUMLActivityDiagramImpl());

        //add another PackageImpl namespace to the orignal namespace
        Namespace packageNamespace = new PackageImpl();
        namespace.addOwnedElement(packageNamespace);

        //add one ActivityDiagram to the PackageImpl namespace
        packageNamespace.addOwnedElement(new ZUMLActivityDiagramImpl());
        List<ActivityGraph> activityGraphsList = new ArrayList<ActivityGraph>();

        method.invoke(null, namespace, model, activityGraphsList);
        // the element should be added into the activityGraphsList
        assertEquals("The size of activityGraphsList should be 2.", 2, activityGraphsList.size());
        // the element should be added into the model
        Collection<ModelElement> modelElements = model.getOwnedElements();
        assertEquals("The size of ownedElements of model should be 2.", 2, modelElements.size());

        // the element of namespaces should be removed.
        assertTrue("The packageNamespace should have no element", packageNamespace.getOwnedElements().isEmpty());

        assertEquals("The namespace should only have one element.",1, namespace.getOwnedElements().size());
        ModelElement[] elements = modelElements.toArray(new ModelElement[modelElements.size()]);
        for (int i = 0; i < activityGraphsList.size(); i++) {
            assertSame("The ModelElement should be the same.", elements[i], activityGraphsList.get(i));
        }
    }


    /**
     * the accuracy tests for the method
     * {@link ActivityDiagramConversionFacade
     * #convertModel(com.topcoder.uml.model.modelmanagement.Model)}.
     */
    public void testConvertModel() {
        Model model = new ModelImpl();
        Namespace namespace = new CollaborationImpl();

        model.addOwnedElement(namespace);

        model.addOwnedElement(new AttributeImpl());

        ZUMLActivityDiagramImpl diagram = new ZUMLActivityDiagramImpl();
        diagram.addNode(new ZUMLFlowFinalNodeImpl());

        namespace.addOwnedElement(diagram);

        List<ActivityGraph> list = ActivityDiagramConversionFacade.convertModel(model);

        boolean changed = false;

        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof ActivityGraph) {
                // make sure the list contains it.
                if (!list.contains(element)) {
                    changed = false;
                    break;
                }
                changed = true;
            }
        }

        assertTrue("The Activity Diagrams should be converted to TCUML Activity Diagrams.", changed);

        changed = false;

        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof TagDefinition) {
                changed = true;
            }
        }
        assertTrue("The TagDefinition should be added to the Model.", changed);
    }

    /**
     * <p>
     * Checks the bridge is of Uml1SemanticModelBridge and its element is of ActivityGraphImpl.
     * </p>
     *
     * @param bridge
     */
    private void checkSemanticModelBridgeElement(SemanticModelBridge bridge) {
        assertTrue("THe bridge should be of Uml1SemanticModelBridge.", bridge instanceof Uml1SemanticModelBridge);
        assertTrue("The element should be converted to the ActivityGraphImpl",
                ((Uml1SemanticModelBridge) bridge).getElement() instanceof ActivityGraphImpl);
    }
}
